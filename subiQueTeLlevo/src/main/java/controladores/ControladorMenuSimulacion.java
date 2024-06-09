/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import simulacion.ParametrosSimulacion;
import simulacion.Simulacion;
import vista.MenuSimulacion;

/**
 *
 * @author Usuario
 */
public class ControladorMenuSimulacion implements ActionListener{
    private MenuSimulacion vista;
    private Simulacion simulacion;
 
    
    public ControladorMenuSimulacion(Simulacion simulacion)
   {
       this.simulacion = simulacion;
   }

    /**
     * Setea la vista para la cual el controlador funciona de ActionListener
     * @param vista 
     */
    public void setVista(MenuSimulacion vista)
    {
       this.vista = vista;
       this.vista.setActionListener(this);
    }

    /**
     * Ejecuta el metodo que corresponda segun el action command del parametro ActionEvent<br>
     * Este puede ser comenzar una nueva simulacion o activar una simulacion con datos previos
     * @param evento evento que contiene el comando de la accion solicitada desde la visa
     */
   @Override
    public void actionPerformed(ActionEvent evento) {
        

         switch(evento.getActionCommand()) {
            case "COMENZAR":
                 ParametrosSimulacion Parametros = new ParametrosSimulacion();
                 Parametros.setCantClientes(vista.getCantClientes());
                 Parametros.setCantChoferTemporario(vista.getCantChoferTemporario());
                 Parametros.setCantChoferContratado(vista.getCantChoferContratado());
                 Parametros.setCantChoferPermanente(vista.getCantChoferPermanente());
                 Parametros.setCantMaxViajeCliente(vista.getCantMaxViajeCliente());
                 Parametros.setCantMaxViajeChofer(vista.getCantMaxViajeChofer());
                 Parametros.setCantAutos(vista.getCantAuto());
                 Parametros.setCantMotos(vista.getCantMoto());
                 Parametros.setCantCombis(vista.getCantCombi());

                 simulacion.iniciarSimulacionNueva(Parametros);
                 vista.dispose();
                 break;

            case "INICIAR CON DATOS CARGADOS":
                simulacion.iniciarSimulacionConDatosViejos();
                vista.dispose();
                break;
        }
        
    }
    
}
