/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import simulacion.EventoSimulacion.TipoEvento;
import vista.VentanaGeneral;

/**
 *
 * @author Usuario
 */
public class OjoGeneral extends OjoAbstracto{
    private VentanaGeneral vista;
    
    public OjoGeneral(VentanaGeneral vista, Observable observado)
    {
        this.vista = vista;
        this.observado = observado;
        observado.addObserver(this);
    }

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
