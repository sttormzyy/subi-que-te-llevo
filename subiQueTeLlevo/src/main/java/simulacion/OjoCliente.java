/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import java.util.Observable;
import static simulacion.EventoSimulacion.TipoEvento.CHOFER;
import static simulacion.EventoSimulacion.TipoEvento.CLIENTE;
import static simulacion.EventoSimulacion.TipoEvento.SISTEMA;
import usuarios.Cliente;
import vista.VentanaCliente;
import vista.VentanaGeneral;

/**
 *Clase encargada de observar al recurso compartido y comunicarle a la ventana general los eventos relacionados con un cliente que esta usando la app 
 */
public class OjoCliente extends OjoAbstracto{
    private VentanaCliente vista;
    
    public OjoCliente(VentanaCliente vista, Observable observado)
    {
        this.vista = vista;
        this.observado = observado;
        observado.addObserver(this);
    }
    
    /**
     * Comunica a la ventana general el evento correspondiente asociado a un cliente determinado
     * @param o Objeto observado, en este caso el recurso compartido
     * @param e Objeto que contiene la informacion transmitida por el observado
     */
    @Override
    public void update(Observable o, Object e) {
        super.update(o, e);
        Cliente clienteEvento;
        
        EventoSimulacion evento = (EventoSimulacion)e;
        
        clienteEvento = evento.getCliente();
        if(clienteEvento != null && clienteEvento.isUsandoApp()==true)
        {
            switch(evento.getTipo())
            {
               case CLIENTE:  vista.appendDisplay(evento.getCliente().getNombreUsuario()+" "+evento.getMensaje()+"\n");
               break;
               case CHOFER:  vista.appendDisplay(evento.getChofer().getNombre()+" "+evento.getMensaje()+"\n");
                             if(evento.getMensaje().contains("tomo el viaje del cliente "))
                                vista.enablePagar();
               break;
               case SISTEMA: vista.appendDisplay(evento.getMensaje()+"\n");
            }
        }
    }
    
    
    
}
