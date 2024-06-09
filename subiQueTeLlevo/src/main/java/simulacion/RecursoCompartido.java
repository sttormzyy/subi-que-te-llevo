/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import choferes.Chofer;
import excepciones.chofer.ExceptionChofer;
import excepciones.pedido.ExceptionPedido;
import excepciones.pedido.ExceptionVehiculoDisp;
import excepciones.usuario.ExceptionUsuario;
import excepciones.usuario.ExceptionUsuarioInexistente;
import excepciones.viaje.ExceptionChoferSinViajesPagos;
import excepciones.viaje.ExceptionSinViajeaPagar;
import java.time.LocalDateTime;
import java.util.Observable;
import simulacion.EventoSimulacion.TipoEvento;
import sistema.Empresa;
import usuarios.Cliente;
import viajes.IViaje;
import viajes.IViaje.EstadosViajes;

/**
 *Clase que tiene la responsabilidad de comunicar los hilos de simulacion con la empresa y restringir el uso de los recursos de la misma para que solo un hilo simultáneo pueda acceder
**/

public class RecursoCompartido extends Observable{   
    private Empresa empresa;
    private boolean usuarioActivo=true;
    private int cantChoferes;
    private int cantClientes;
    private EventoSimulacion  evento;
    
    public RecursoCompartido(Empresa empresa, int cantChoferes, int cantClientes)
    {
        this.empresa = empresa;
        this.cantChoferes = cantChoferes;
        this.cantClientes = cantClientes;
    }
    
    public RecursoCompartido(Empresa empresa)
    {
        this.empresa = empresa;
    }
    
    /**
     * Setea la cantidad de hilos cliente de la simulacion
     * @param c 
     */
    public void setCantClientes(int c)
    {
        this.cantClientes = c;
    }
    
    /**
     * Setea la cantidad de hilos chofer de la simulacion
     * @param c 
     */
    public void setCantChoferes(int c)
    {
        this.cantChoferes = c;
    } 
    
    
    /**
     * Deriva en la empresa la solicitud de pedir viaje de un hilo cliente.<br>
     * Ademas, informa a los observers lo ocurrido en caso de exito o fracaso
     * @param c 
     */
    public synchronized void pedirViaje(Cliente cliente,String zona, int mascota, String tipoServicio, int equipaje, int cantPax, double distancia, LocalDateTime fecha)
            throws ExceptionPedido, ExceptionVehiculoDisp
    {
       System.out.println("PEDIR VIAJE " + cliente.getNombreUsuario() + " " + zona + " " + mascota + " " + tipoServicio + " " + equipaje + " " + cantPax + " " + distancia + "\n");

       if(simulacionIsActiva())
       {
        try{
            empresa.pedirViaje(cliente.getNombreUsuario(), zona, mascota, tipoServicio, equipaje, cantPax, distancia, fecha);
            evento = new EventoSimulacion("solicito viaje y espera",cliente,null,null,TipoEvento.CLIENTE);         
        }
        catch(ExceptionVehiculoDisp e){
            evento = new EventoSimulacion("realizo pedido pero no habia auto que cumpla las especificaciones",cliente,null,null,TipoEvento.CLIENTE);
            setChanged();
            notifyObservers(evento);
            notifyAll();
            throw  e;
        }
        catch(ExceptionPedido e){
           evento = new EventoSimulacion("realizo pedido pero fue rechazado "+e.getMessage().toLowerCase(),cliente,null,null,TipoEvento.CLIENTE);
           setChanged();
           notifyObservers(evento);
           notifyAll();
           throw  e;
        } catch (ExceptionUsuario ex) {
            
        }
       }else
           if(cantChoferes == 0)
            evento = new EventoSimulacion("no pudo realizar pedido porque no hay choferes disponibles ",cliente,null,null,TipoEvento.CLIENTE);
           else
            evento = new EventoSimulacion("se le cayo la app, apaga el celular",cliente,null,null,TipoEvento.CLIENTE);    
       
       
       setChanged();
       notifyObservers(evento);
       notifyAll();
    }
    
    
    /**
     * Deriva en la empresa la solicitud de asignar vehiculo a un viaje solicitado del hilo ssitema.<br>
     * Ademas, informa a los observers lo ocurrido en caso de exito o fracaso
     * @param c 
     */
    public synchronized void asignarVehiculo()
    {
       IViaje viajeSolicitado = getViajeSolicitado();
       
       while(viajeSolicitado == null && simulacionIsActiva())
       {
           try {
                evento = new EventoSimulacion("El sistema intento asignar auto pero no hay viajes solicitados", null, null, null, TipoEvento.SISTEMA);
                setChanged();
                notifyObservers(evento);
                wait();

                viajeSolicitado = getViajeSolicitado();
            } 
           catch (InterruptedException ex) {
                
            }
        }
      
     
    
        while(simulacionIsActiva()  && !empresa.asignarVehiculo(viajeSolicitado))
        {
            evento = new EventoSimulacion("El sistema intento asignar vehiculo al viaje del cliente " + viajeSolicitado.getCliente().getNombreUsuario()+" pero no encontro uno libre, sigue en espera", 
                                           viajeSolicitado.getCliente(), null, null, TipoEvento.SISTEMA);
            setChanged();
            notifyObservers(evento);
            notifyAll();
            viajeSolicitado = getViajeSolicitado();
            try {
                wait();
             } catch (InterruptedException ex) {}
        }
        if(viajeSolicitado != null)
            evento = new EventoSimulacion("El sistema asignó "+viajeSolicitado.getVehiculo().getTipo()+" al viaje del cliente " + viajeSolicitado.getCliente().getNombreUsuario(), 
                                           viajeSolicitado.getCliente(), null, null, TipoEvento.SISTEMA);
        else
            evento = new EventoSimulacion("El sistema se apaga",null,null,null,TipoEvento.SISTEMA);
        
        setChanged();
        notifyObservers(evento);
        notifyAll();
    }
    
    
    /**
     * Deriva en la empresa la solicitud de tomar un viaje con vehiculo por parte de un hilo chofer.<br>
     * Ademas, informa a los observers lo ocurrido en caso de exito o fracaso
     * @param c 
     */
    public synchronized void tomarViaje(Chofer chofer)
    {
        IViaje viaje;
        
        while(!hayViajeConVehiculo() && simulacionIsActiva())
        {
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        
        if(usuarioActivo)
        {
            empresa.asignarChofer(chofer);
            viaje = getViaje(chofer,EstadosViajes.INICIADO);
            if(viaje!=null)
                 evento =  new EventoSimulacion("tomo el viaje del cliente "+viaje.getCliente().getNombreUsuario(),viaje.getCliente(),chofer,null,TipoEvento.CHOFER);
            else
                evento =  new EventoSimulacion("no hay mas clientes se retira de la empresa",null,chofer,null,TipoEvento.CHOFER); 
        }
        else
          evento =  new EventoSimulacion("recibe un llamado de la empresa",null,chofer,null,TipoEvento.CHOFER); 
        
        setChanged();
        notifyObservers(evento);
        notifyAll();
    }
    
    
    /**
     * Deriva en la empresa la solicitud de pagar un viaje iniciado por parte de un hilo cliente.<br>
     * Ademas, informa a los observers lo ocurrido en caso de exito o fracaso
     * @param c 
     */
    public synchronized void pagarViaje(Cliente cliente)
    {

        while(!viajeIniciado(cliente) &&  simulacionIsActiva())
        {
            try {
                wait();
            } catch (InterruptedException ex) {
               
            }
        }
        

        if(viajeIniciado(cliente))
        {
            try {
                 empresa.pagarViaje(cliente);
                 evento = new EventoSimulacion("pago el viaje y se retiro del auto",cliente,getViaje(cliente,EstadosViajes.PAGO).getChofer(),null,TipoEvento.CLIENTE);
            } catch (ExceptionSinViajeaPagar ex) {
                //no entramos nunca porque validamos q tenga viaje solicitado
            } catch (ExceptionUsuario ex) {
                    
             }
        }else
            if(cantChoferes==0)
               evento = new EventoSimulacion("cancela el viaje porque no hay choferes disponibles",cliente,null,null,TipoEvento.CLIENTE);
            else
               evento = new EventoSimulacion("se le cayo la app, apaga el celular",cliente,null,null,TipoEvento.CLIENTE); 
      
        setChanged();
        notifyObservers(evento);
        notifyAll();
    }
   
   
    /**
     * Deriva en la empresa la solicitud de finalizar un viaje pago por parte de un hilo chofer.<br>
     * Ademas, informa a los observers lo ocurrido en caso de exito o fracaso
     * @param c 
     */
    public synchronized void finalizarViaje(Chofer chofer)
    {

        while(!viajePago(chofer) && simulacionIsActiva())
            try {
                wait();
            } catch (InterruptedException ex) {
                
            }
       
       
            try {
                empresa.finalizarViaje(chofer);
                evento = new EventoSimulacion("finalizo el viaje y devolvio el vehiculo",getViaje(chofer,EstadosViajes.FINALIZADO).getCliente(), chofer, null, TipoEvento.CHOFER);
            } 
            catch (ExceptionChofer ex) {} 
            catch (ExceptionChoferSinViajesPagos ex) {}
        
        setChanged();
        notifyObservers(evento);
        notifyAll();
    }
    
    
    
    // AUXILIARES
    
    /**
     *Chequea que exista un viaje con vehiculo.<br>
	 * <b>POST:</b> Se devuelve true si existe, false caso contrario.<br>
     * @return  existencia de un viaje con vehiculo 
     */
    private boolean hayViajeConVehiculo()
    {
       return empresa.hayViajeConVehiculo();
    }
    
    
    /**
     * Devuelve un viaje en estado solicitado.<br>
	 * <b>POST:</b> Se devuelve  un viaje en estado solicitado si existe, null caso contrario.<br>
     * @return  viaje en estado solicitado
     */
    private IViaje getViajeSolicitado()
    {
       return empresa.getViajeSolicitado();
    }
    
    
    /**
     * Devuelve un viaje asociado al chofer pasado como parametro cuyo estado coincida con el pasado como parametro.<br>
	 * <b>POST:</b> Se devuelve  viaje asociado al chofer pasado como parametro si existe, null caso contrario.<br>
     * @return  viaje asociado al chofer pasado como parametro 
     */
    private IViaje getViaje(Chofer chofer, EstadosViajes estado)
    {
       return empresa.getViaje(chofer,estado);
    }
    
     /**
     * Devuelve un viaje asociado al cliente pasado como parametro cuyo estado coincida con el pasado como parametro.<br>
	 * <b>POST:</b> Se devuelve  viaje asociado al cliente pasado como parametro si existe, null caso contrario.<br>
     * @return  viaje asociado al cliente pasado como parametro 
     */
     private IViaje getViaje(Cliente cliente, EstadosViajes estado)
    {
        return empresa.getViaje(cliente,estado);
    }
    
     
     /**
     *Chequea que exista un viaje iniciado  de un cliente especifico.<br>
	 * <b>POST:</b> Se devuelve true si existe, false caso contrario.<br>
     * @return  existencia de un viaje iniciado de un cliente especifico
     */
    private boolean viajeIniciado(Cliente cliente)
    {
         return empresa.viajeIniciado(cliente);
    }
    
    /**
     *Devuelve un cliente cuyo nombre y contrasena coincidan con los parametros, lanza excepcion en caso contrario.<br>
	 * <b>POST:</b> Se devuelve cliente si existe, false caso contrario.<br>
     * @return  cliente
     */
    public Cliente getCliente(String nombreUsuario,String contrasena) throws ExceptionUsuario
    {
        return empresa.getCliente(nombreUsuario, contrasena);
    }
    
    /**
     *Agrega a la lista de clientes de la empresa, un nuevo cliente.<br>
	 * <b>POST:</b> Se agrega un cliente, si el nombre de usuario ya existe lanza excepcion.<br>
     */
     public void addCliente(Cliente nuevoCliente) throws ExceptionUsuario
    {
         empresa.addCliente(nuevoCliente);
    }
    
   /**
     *Chequea que exista un viaje pago de un chofer especifico.<br>
	 * <b>POST:</b> Se devuelve true si existe, false caso contrario.<br>
     * @return  existencia de un viaje iniciado de un chofer especifico
     */
    private boolean viajePago(Chofer chofer){
        return empresa.viajePago(chofer);
    }
    
    /**
     * Setea el estado del usuario de la app
     */
    public void desconectarUsuario()
    {
        this.usuarioActivo = false;
    }
    
    /**
     * Resta un chofer de la simulacion cuando un hilo chofer termina su run. Ademas, informa a los observadores lo sucedido
     * @param chofer chofer del hilo que acabo
     */
    public synchronized void subChofer(Chofer chofer)
    {
        cantChoferes--;

        evento = new EventoSimulacion("finalizo su jornada laboral", null, chofer, null, TipoEvento.CHOFER);
        setChanged();
        notifyObservers(evento);

    }
    
    /**
     * Resta un chofer de la simulacion cuando un hilo cliente termina su run. Ademas, informa a los observadores lo sucedido
     * @param cliente del hilo que acabo
     */
    public synchronized void subCliente(Cliente cliente)
    {
        cantClientes--;
        if(usuarioActivo)
        {
            evento = new EventoSimulacion("deja de usar la app",cliente,null,null,TipoEvento.CLIENTE);
            setChanged();
            notifyObservers(evento);
        }
    }
    
    /**
     * Devuelve true si la simulacion sigue activa, false caso contrario
     * @return 
     */
    public boolean simulacionIsActiva()
    {
        return this.usuarioActivo && (this.cantChoferes>0 || this.cantClientes>0);
    }
    
}
