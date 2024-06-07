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

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
        }

        Simulacion simulacion = new Simulacion();
        ControladorMenuSimulacion controladorMenu= new ControladorMenuSimulacion(new MenuSimulacion(),simulacion);
    }
}
