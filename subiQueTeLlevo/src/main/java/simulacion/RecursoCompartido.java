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
     * @param c cantidad de hilos cliente
     */
    public void setCantClientes(int c)
    {
        this.cantClientes = c;
    }
    
    /**
     * Setea la cantidad de hilos chofer de la simulacion
     * @param c cantidad de hilos chofer
     */
    public void setCantChoferes(int c)
    {
        this.cantChoferes = c;
    } 
    /**
     * Deveulve la cantidad de hilos cliente de la simulacion
     * @return cantidad de hilos cliente
     */
    public int getCantClientes()
    {
        return this.cantClientes;
    }
    
    /**
     * Deveulve la cantidad de hilos chofer de la simulacion 
     * @return  cantidad de hilos chofer
     */
    public int getCantChoferes()
    {
        return this.cantChoferes ;
    } 
  
    /**
     * Deriva en la empresa la solicitud de pedir viaje de un hilo cliente.<br>
     * Ademas, informa a los observers lo ocurrido en caso de exito o fracaso 
     * @param cliente      El cliente que realiza el pedido.
     * @param zona         La zona de destino del viaje.
     * @param mascota      La cantidad de mascotas que viajan.
     * @param tipoServicio El tipo de servicio solicitado (transporte o mensajeria).
     * @param equipaje     La cantidad de equipaje.
     * @param cantPax      La cantidad de pasajeros.
     * @param fecha        La fecha del viaje.
     * @throws excepciones.pedido.ExceptionPedido excepcion pedido
     * @throws excepciones.pedido.ExceptionVehiculoDisp excepcion vehiculo disponible
     */
    public synchronized void pedirViaje(Cliente cliente,String zona, int mascota, String tipoServicio, int equipaje, int cantPax, double distancia, LocalDateTime fecha)
            throws ExceptionPedido, ExceptionVehiculoDisp
    {

       if(cantChoferes>0)
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
            evento = new EventoSimulacion("no pudo realizar pedido porque no hay choferes disponibles ",cliente,null,null,TipoEvento.CLIENTE);
 
       
       
       setChanged();
       notifyObservers(evento);
       notifyAll();
    }
    
    
    /**
     * Deriva en la empresa la solicitud de asignar vehiculo a un viaje solicitado del hilo ssitema.<br>
     * Ademas, informa a los observers lo ocurrido en caso de exito o fracaso 
     */
    public synchronized void asignarVehiculo()
    {
       IViaje viajeSolicitado = getViajeSolicitado();
       
       while(simulacionIsActiva() && viajeSolicitado == null)
       {
           try {
                evento = new EventoSimulacion("El sistema intento asignar auto pero no hay viajes solicitados", null, null, null, TipoEvento.SISTEMA);
                setChanged();
                notifyObservers(evento);
                wait();

                viajeSolicitado = getViajeSolicitado();
            } 
           catch (InterruptedException ex) {}
        }
      
     
    
        while(simulacionIsActiva()  && !empresa.asignarVehiculo(viajeSolicitado))
        {
            try {
                evento = new EventoSimulacion("El sistema intento asignar vehiculo al viaje del cliente " + viajeSolicitado.getCliente().getNombreUsuario()+" pero no encontro uno libre, sigue en espera", 
                                           viajeSolicitado.getCliente(), null, null, TipoEvento.SISTEMA);
                setChanged();
                notifyObservers(evento);
                wait();
             } catch (InterruptedException ex) {}
            viajeSolicitado = getViajeSolicitado();
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
     * @param chofer chofer que desea tomar un viaje
     * @param cantViajesPendientes cantidad de viajes pendientes del chofer
     */
    public synchronized void tomarViaje(Chofer chofer, int cantViajesPedientes)
    {
        IViaje viaje;
        
        while(hayClientes() && !hayViajeConVehiculo() && (cantViajesPedientes > 0 || usuarioActivo))
        {
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        
        if (cantViajesPedientes > 0 || usuarioActivo) {
            if(hayClientes())
            {
                empresa.asignarChofer(chofer);
                viaje = getViaje(chofer,EstadosViajes.INICIADO);
                if(viaje!=null)
                     evento =  new EventoSimulacion("tomo el viaje del cliente "+
                    		 viaje.getCliente().getNombreUsuario(),viaje.getCliente(),chofer,null,TipoEvento.CHOFER);
                else
                    evento =  new EventoSimulacion("intento tomar viaje pero no habia ninguno con vehiculo asignado",null,chofer,null,TipoEvento.CHOFER); 
            }
            else
                evento =  new EventoSimulacion("descubre que no hay mas clientes se retira de la empresa",null,chofer,null,TipoEvento.CHOFER); 
            
            setChanged();
            notifyObservers(evento);
        }

        notifyAll();
    }
    
    
    /**
     * Deriva en la empresa la solicitud de pagar un viaje iniciado por parte de un hilo cliente.<br>
     * Ademas, informa a los observers lo ocurrido en caso de exito o fracaso 
     * @param cliente cliente que desea pagar un viaje
     */
    public synchronized void pagarViaje(Cliente cliente)
    {

    if(cantChoferes>0)
    {
        while(cantChoferes>0 && !viajeIniciado(cliente))
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
                 evento = new EventoSimulacion("pago el viaje y se retiro del vehiculo",
                		 cliente,getViaje(cliente,EstadosViajes.PAGO).getChofer(),null,TipoEvento.CLIENTE);
            } catch (ExceptionSinViajeaPagar ex) {
                //no entramos nunca porque validamos q tenga viaje iniciado
            } catch (ExceptionUsuario ex) {
                    
             }
        }else
               evento = new EventoSimulacion("cancela el viaje porque no hay choferes disponibles",
            		   cliente,null,null,TipoEvento.CLIENTE);
             
	        setChanged();
	        notifyObservers(evento);
	    }
        notifyAll();
    }
   
   
    /**
     * Deriva en la empresa la solicitud de finalizar un viaje pago por parte de un hilo chofer.<br>
     * Ademas, informa a los observers lo ocurrido en caso de exito o fracaso 
     * @param chofer chofer que desea finalizar un viaje
     * @param cantViajesPendientes cantidad de viajes pendientes del chofer
     */
    public synchronized void finalizarViaje(Chofer chofer, int cantViajesPendientes)
    {

        while (simulacionIsActiva() && !viajePago(chofer) && (cantViajesPendientes > 0 || usuarioActivo))
            try {
                wait();
            } catch (InterruptedException ex) {}
        

        if (viajePago(chofer)) 
        {
            try {
                empresa.finalizarViaje(chofer);
                evento = new EventoSimulacion("finalizo el viaje y devolvio el vehiculo", 
                		getViaje(chofer, EstadosViajes.FINALIZADO).getCliente(), chofer, null, TipoEvento.CHOFER);
                setChanged();
                notifyObservers(evento);
            } 
            catch (ExceptionChofer ex) {}
            catch (ExceptionChoferSinViajesPagos ex) {}
        }
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
     * @param nombreUsuario nombre de usuario
     * @param contrasena contrasena
     * @return  cliente  
     * @throws excepciones.usuario.ExceptionUsuario excepcion usuario
     */
    public Cliente getCliente(String nombreUsuario,String contrasena) throws ExceptionUsuario
    {
        return empresa.getCliente(nombreUsuario, contrasena);
    }
    
    /**
     *Agrega a la lista de clientes de la empresa, un nuevo cliente.<br>
	 * <b>POST:</b> Se agrega un cliente, si el nombre de usuario ya existe lanza excepcion.<br>
     * @param nuevoCliente nuevo cliente
     * @throws excepciones.usuario.ExceptionUsuario excepcion usuario
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
        evento = new EventoSimulacion("deja de usar la app", cliente, null, null, TipoEvento.CLIENTE);
        setChanged();
        notifyObservers(evento);

    }
    
    /**
     * Devuelve true si la simulacion sigue activa, false caso contrario
     * @return true si la simulacion sigue activa, false caso contrario
     */
    public boolean simulacionIsActiva()
    {
        return (cantChoferes>0 && cantClientes>0) || usuarioActivo==true;
    }
    
    
     /**
      * Chequea que existan clientes activos, ya sea el usuario de la app o los hilos
      * @return  true si hay clientes activos
      */
    public boolean hayClientes()
    {
        return cantClientes>0 || usuarioActivo==true;
    }
    
    public boolean getUsuarioActivo() {
    	return usuarioActivo;
    }
    
}
