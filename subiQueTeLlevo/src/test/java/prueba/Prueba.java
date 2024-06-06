package prueba;

import Persistencia.EmpresaDTO;
import Persistencia.PersistenciaBIN;
import Persistencia.PersistenciaXML;
import Persistencia.UTILEmpresa;
import controladores.ControladorCliente;
import controladores.ControladorMenuSimulacion;
import excepciones.usuario.ExceptionUsuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema.Empresa;
import usuarios.Administrador;
import usuarios.Cliente;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import simulacion.OjoChoferSimulacion;
import simulacion.OjoClienteSimulacion;
import simulacion.OjoGeneral;
import simulacion.RecursoCompartido;
import simulacion.Simulacion;
import simulacion.Util;
import vista.*;
import vista.MenuSimulacion;

public class Prueba {

    public static void main(String[] args){
        Empresa empresa = Empresa.getInstance();

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
        }

        /*try {
            empresa.addAdmin(new Administrador("admin", "admin", "1234"));
        } catch (ExceptionUsuario e) {
        
        }
 */
        RecursoCompartido rc = new RecursoCompartido(empresa);
        
        Simulacion simulacion = new Simulacion(rc,empresa);
        
        MenuSimulacion menu= new MenuSimulacion();
        ControladorMenuSimulacion controladorMenu= new ControladorMenuSimulacion(menu,simulacion);
        menu.setActionListener(controladorMenu);
        
       
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

        VentanaGeneral vistaGeneral = new VentanaGeneral();


        OjoGeneral ojoGeneral = new OjoGeneral(vistaGeneral, rc);
        OjoClienteSimulacion ojoClienteSimulacion = new OjoClienteSimulacion(vistaGeneral, rc, (Cliente)empresa.getUsuarioLista().get(Util.rand(5)));
        OjoChoferSimulacion ojoChoferSimulacion = new OjoChoferSimulacion(vistaGeneral, rc,empresa.getChoferLista().get(0));
        
        VentanaCliente vistaCliente = new VentanaCliente();
        ControladorCliente controladorCliente = new ControladorCliente(rc, vistaCliente);
        vistaCliente.setActionListener(controladorCliente);

        

       while(rc.simulacionIsActiva()){}
            System.out.println("escribi aarch");
        PersistenciaXML p = new PersistenciaXML();
        
        try {
            p.abrirOutput("empresa.xml");
        } catch (IOException ex) {

        }
        
     
        try {
            p.escribir(empresa);
             System.out.println("escribi aarch");
             p.cerrarOutput();
        } catch (IOException ex) {

        }
      vistaGeneral.dispose();
      vistaCliente.dispose();
    }

}
