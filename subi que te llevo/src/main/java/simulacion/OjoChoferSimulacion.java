/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import choferes.Chofer;
import java.util.Observable;
import static simulacion.EventoSimulacion.TipoEvento.CHOFER;
import static simulacion.EventoSimulacion.TipoEvento.CLIENTE;
import static simulacion.EventoSimulacion.TipoEvento.SISTEMA;
import usuarios.Cliente;
import vista.VentanaCliente;
import vista.VentanaGeneral;

/**
 *
 * @author Usuario
 */
public class OjoChoferSimulacion extends OjoAbstracto
{   private VentanaGeneral vista;
    private Chofer chofer;
    
    public OjoChoferSimulacion(VentanaGeneral vista, Observable observado, Chofer chofer)
    {
        this.vista = vista;
        this.observado = observado;
        this.chofer = chofer;
        observado.addObserver(this);
    }
    
    
    
    @Override
    public void update(Observable o, Object e) {
        super.update(o, e);
        
        EventoSimulacion evento = (EventoSimulacion)e;
        
        Chofer choferEvento = evento.getChofer();
        if(choferEvento != null && choferEvento.equals(chofer))
        {
            switch(evento.getTipo())
            {
               case CLIENTE:  vista.appendChofer(evento.getCliente().getNombreUsuario()+" "+evento.getMensaje()+"\n");
               break;
               case CHOFER:  vista.appendChofer(evento.getChofer().getNombre()+" "+evento.getMensaje()+"\n");
               break;
               case SISTEMA: vista.appendChofer(evento.getMensaje()+"\n");
            }
        }
    }
    
    
    
    
}
