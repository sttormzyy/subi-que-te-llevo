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
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import simulacion.EventoSimulacion.TipoEvento;
import sistema.Empresa;
import usuarios.Cliente;
import viajes.IViaje;
import viajes.IViaje.EstadosViajes;

/**
 *
 * @author Usuario
 */
public class RecursoCompartido extends Observable{   
    private ArrayList<IViaje> viajeLista;
    private Empresa empresa;
    private boolean simulacionVive=true;
    private int cantChoferes;
    private int cantClientes;
    private EventoSimulacion  evento;
    
    public RecursoCompartido(Empresa empresa, int cantChoferes, int cantClientes)
    {
        this.empresa = empresa;
        this.viajeLista = empresa.getViajeLista();
        this.cantChoferes = cantChoferes;
        this.cantClientes = cantClientes;
    }
    
    public synchronized void pedirViaje(Cliente cliente,String zona, int mascota, String tipoServicio, int equipaje, int cantPax, double distancia, LocalDateTime fecha)
            throws ExceptionPedido, ExceptionVehiculoDisp
    {
       System.out.println("PEDIR VIAJE " + cliente.getNombreUsuario() + " " + zona + " " + mascota + " " + tipoServicio + " " + equipaje + " " + cantPax + " " + distancia + "\n");

        try{
            empresa.pedirViaje(cliente.getNombreUsuario(), zona, mascota, tipoServicio, equipaje, cantPax, distancia, fecha);
            evento = new EventoSimulacion("solicito viaje y espera",cliente,null,null,TipoEvento.CLIENTE);         
        }
        catch(ExceptionVehiculoDisp e){
            evento = new EventoSimulacion("realizo pedido pero no habia auto disponible",cliente,null,null,TipoEvento.CLIENTE);
            throw  e;
        }
        catch(ExceptionPedido e){
           evento = new EventoSimulacion("realizo pedido pero fue rechazado",cliente,null,null,TipoEvento.CLIENTE);
           throw  e;
        } catch (ExceptionUsuario ex) {
            
        }
          setChanged();
          notifyObservers(evento);
          notifyAll();
    }
    
    public synchronized void asignarVehiculo()
    {
        System.out.println("ASIGNAR AUTO \n");
       IViaje viajeSolicitado = getViajeSolicitado();
       
       while(viajeSolicitado == null && simulacionIsActiva())
       {
           try {
               wait();
               viajeSolicitado = getViajeSolicitado();
                       } catch (InterruptedException ex) {
               Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       System.out.println("ASIGNANDO \n");
       if(viajeSolicitado != null)
       {
        if(simulacionIsActiva())
            {
               empresa.asignarVehiculo(viajeSolicitado);
            evento = new EventoSimulacion("El sistema asignó "+viajeSolicitado.getVehiculo().getTipo()+" al viaje del cliente " + evento.getCliente().getNombreUsuario(), 
                                           null, null, null, TipoEvento.SISTEMA);
         }else
            evento = new EventoSimulacion("El sistema se apaga",null,null,null,TipoEvento.SISTEMA);
        setChanged();
        notifyObservers(evento);
        notifyAll();
       }
    }
    
    public synchronized void tomarViaje(Chofer chofer)
    {
        System.out.println("TOMAR VIAJE \n");
        while(!hayViajeConVehiculo() && simulacionIsActiva())
        {
            try {
                wait();
                        } catch (InterruptedException ex) {
                Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(simulacionVive)
        {
            if(cantClientes>0)
            {
                 empresa.asignarChofer(chofer);
                 evento =  new EventoSimulacion("tomo el viaje del cliente "+getViaje(chofer).getCliente().getNombreUsuario(),null,chofer,null,TipoEvento.CHOFER);
            }else
                evento =  new EventoSimulacion("no hay mas clientes se retira de la empresa",null,chofer,null,TipoEvento.CHOFER); 
        }
        else
          evento =  new EventoSimulacion("se retira de la empresa porque cierra",null,chofer,null,TipoEvento.CHOFER); 
        
         setChanged();
         notifyObservers(evento);
         notifyAll();
    }
    
    public synchronized void pagarViaje(Cliente cliente)
    {
        System.out.println("PAGAR VIAJE \n");
        while(!viajeIniciado(cliente) &&  simulacionIsActiva())
        {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

        if(viajeIniciado(cliente))
        {
            try {
                 empresa.pagarViaje(cliente);
                 evento = new EventoSimulacion("pago el viaje y se retiro del auto",cliente,null,null,TipoEvento.CLIENTE);
            } catch (ExceptionSinViajeaPagar ex) {
                    Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExceptionUsuario ex) {
                    Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
             }
        }else
               evento = new EventoSimulacion("cancela el viaje porque no hay choferes disponibles",cliente,null,null,TipoEvento.CLIENTE);
        
      
        setChanged();
        notifyObservers(evento);
        notifyAll();
    }
   
    
    
    public synchronized void finalizarViaje(Chofer chofer)
    {
        System.out.println("FINALIZAR VIAJE \n");
        
        while(!viajePago(chofer) && simulacionIsActiva())
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        try {
            empresa.finalizarViaje(chofer);
            evento = new EventoSimulacion("finalizo el viaje y devolvio el vehiculo",null,chofer,null,TipoEvento.CHOFER);
        } catch (ExceptionChofer ex) {
            Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExceptionChoferSinViajesPagos ex) {
            Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
        }
        setChanged();
        notifyObservers(evento);
        notifyAll();
    }
    
    
    
    // AUXILIARES
    private boolean hayViajeConVehiculo()
    {
        int i=0;
        
        while(i<viajeLista.size() && viajeLista.get(i).getEstado() != EstadosViajes.CONVEHICULO){
            i++;
        }        
        
         return i<viajeLista.size();
    }
    
    private IViaje getViajeSolicitado()
    {
        int i=0;
        
        while(i<viajeLista.size() && viajeLista.get(i).getEstado() != EstadosViajes.SOLICITADO){
            i++;
        }        
        
        if(i<viajeLista.size())
            return viajeLista.get(i);
        else
            return null;      
    }
    
    private IViaje getViaje(Chofer chofer)
    {
        int i=0;
        
        while(viajeLista.get(i).getChofer() != chofer){
            i++;
        }        
        return viajeLista.get(i);   
    }
    
    private boolean viajeIniciado(Cliente cliente)
    {
        int i=0;
        
        while((i<viajeLista.size()) && !(viajeLista.get(i).getCliente() == cliente && viajeLista.get(i).getEstado() == EstadosViajes.INICIADO)){
            i++;
        }
  
        return i<viajeLista.size();
                  
    }
    
    
    private boolean viajePago(Chofer chofer){
        int i= 0;
        
        while((i<viajeLista.size()) && !(viajeLista.get(i).getChofer() == chofer && viajeLista.get(i).getEstado() == EstadosViajes.PAGO)){
            i++;
        }        
        
        return i<viajeLista.size();
    }
    
    public void matarSimulacion()
    {
        this.simulacionVive = false;
    }
    
    public void subChofer()
    {
        System.out.println("SUb chofer");
        cantChoferes--;
    }
    
    public void subCliente()
    {
        cantClientes--;
    }
    
    public boolean simulacionIsActiva()
    {
        return this.simulacionVive && this.cantChoferes>0 && this.cantClientes>0;
    }
}
