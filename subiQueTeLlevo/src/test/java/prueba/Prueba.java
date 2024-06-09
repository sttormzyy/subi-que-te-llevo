package prueba;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import controladores.ControladorMenuSimulacion;
import simulacion.Simulacion;
import vista.MenuSimulacion;

public class Prueba {

    public static void main(String[] args){

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
        }

        Simulacion simulacion = new Simulacion();
        ControladorMenuSimulacion controladorMenu= new ControladorMenuSimulacion(simulacion);
        controladorMenu.setVista(new MenuSimulacion());
        
    }
}
