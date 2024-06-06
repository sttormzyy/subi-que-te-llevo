/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;


import java.awt.event.ActionEvent;
import simulacion.Simulacion;
import vista.MenuSimulacion;

/**
 *
 * @author Usuario
 */
public class ControladorMenuSimulacion implements Controlador{
    private MenuSimulacion vista;
    private Simulacion simulacion;
 
    
    public ControladorMenuSimulacion(MenuSimulacion vista, Simulacion simulacion)
   {
       this.vista = vista;
       this.simulacion = simulacion;
   }


   @Override
    public void actionPerformed(ActionEvent evento) {
        

         switch(evento.getActionCommand()) {
            case "COMENZAR":
                int cantClientes = vista.getCantClientes();
                int cantChoferTemporario = vista.getCantChoferTemporario();
                int cantChoferContratado = vista.getCantChoferContratado();
                int cantChoferPermanente = vista.getCantChoferPermanente();
                int cantMaxViajeCliente = vista.getCantMaxViajeCliente();
                int cantMaxViajeChofer = vista.getCantMaxViajeChofer();
                int cantAutos = vista.getCantAuto();
                int cantMotos = vista.getCantMoto();
                int cantCombis = vista.getCantCombi();

                simulacion.iniciarSimulacionNueva(cantClientes,cantMaxViajeCliente,cantChoferTemporario,
                cantChoferContratado,  cantChoferPermanente, cantMaxViajeChofer, 
                cantAutos, cantMotos, cantCombis);
                vista.dispose();
                break;

            case "INICIAR CON DATOS CARGADOS":
                cantMaxViajeCliente = vista.getCantMaxViajeCliente();
                cantMaxViajeChofer = vista.getCantMaxViajeChofer();

                simulacion.iniciarSimulacionConDatosViejos(cantMaxViajeCliente,cantMaxViajeChofer);
                vista.dispose();
                break;
        }
        
    }
    
}
