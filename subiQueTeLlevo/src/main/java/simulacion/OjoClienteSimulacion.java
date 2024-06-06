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
 *
 * @author Usuario
 */
public class OjoClienteSimulacion extends OjoAbstracto{
  
      private VentanaGeneral vista;
    private Cliente cliente;
    
    public OjoClienteSimulacion(VentanaGeneral vista, Observable observado, Cliente cliente)
    {
        this.vista = vista;
        this.observado = observado;
        this.cliente = cliente;
        observado.addObserver(this);
    }
    
    
    
    @Override
    public void update(Observable o, Object e) {
        super.update(o, e);
        
        EventoSimulacion evento = (EventoSimulacion)e;
        
        Cliente clienteEvento = evento.getCliente();
        if(clienteEvento != null && clienteEvento.equals(cliente))
        {
            switch(evento.getTipo())
            {
               case CLIENTE:  vista.appendCliente(evento.getCliente().getNombreUsuario()+" "+evento.getMensaje()+"\n");
               break;
               case CHOFER:  vista.appendCliente(evento.getChofer().getNombre()+" "+evento.getMensaje()+"\n");
               break;
               case SISTEMA: vista.appendCliente(evento.getMensaje()+"\n");
            }
        }
    }
}
