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
public class OjoCliente extends OjoAbstracto{
    private VentanaCliente vista;
    private Cliente cliente;
    
    public OjoCliente(VentanaCliente vista, Observable observado)
    {
        this.vista = vista;
        this.observado = observado;
        observado.addObserver(this);
    }
    
    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
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
               case CLIENTE:  vista.appendDisplay(evento.getCliente().getNombreUsuario()+" "+evento.getMensaje()+"\n");
               break;
               case CHOFER:  vista.appendDisplay(evento.getChofer().getNombre()+" "+evento.getMensaje()+"\n");
                             vista.enablePagar();
               break;
               case SISTEMA: vista.appendDisplay(evento.getMensaje()+"\n");
            }
        }
    }
    
    
    
}
