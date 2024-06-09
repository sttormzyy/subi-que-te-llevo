/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import java.util.Observable;
import vista.VentanaGeneral;

/**
 *Clase encargada de observar al recurso compartido y comunicarle a la ventana general los eventos generales relacionados con la simulacion
 */
public class OjoGeneral extends OjoAbstracto{
    private VentanaGeneral vista;
    
    public OjoGeneral(VentanaGeneral vista, Observable observado)
    {
        this.vista = vista;
        this.observado = observado;
        observado.addObserver(this);
    }

     /**
     * Comunica a la ventana general todos los eventos asociados con la simulacion
     * @param o Objeto observado, en este caso el recurso compartido
     * @param e Objeto que contiene la informacion transmitida por el observado
     */
    @Override
    public void update(Observable o, Object e) {
        super.update(o, e);
       
        EventoSimulacion evento;
        evento = (EventoSimulacion)e;

           switch(evento.getTipo())
           {
              
               case CLIENTE:  vista.appendGeneral(evento.getCliente().getNombreUsuario()+" "+evento.getMensaje()+"\n");
               break;
               case CHOFER:  vista.appendGeneral(evento.getChofer().getNombre()+" "+evento.getMensaje()+"\n");
               break;
               case SISTEMA: vista.appendGeneral(evento.getMensaje()+"\n");
             
           }

        
    }
    
}
