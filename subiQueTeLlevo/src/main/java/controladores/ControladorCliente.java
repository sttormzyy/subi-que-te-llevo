/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import excepciones.pedido.ExceptionPedido;
import excepciones.usuario.ExceptionUsuario;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import simulacion.OjoCliente;
import simulacion.RecursoCompartido;
import usuarios.Cliente;
import vista.VentanaCliente;


public class ControladorCliente implements Controlador {
    private RecursoCompartido recursoCompartido;
    private VentanaCliente  vista;
    private OjoCliente ojoCliente;
    private Cliente cliente;          
            
    public ControladorCliente(RecursoCompartido recursoCompartido, VentanaCliente vista)
    {
        super();
        this.recursoCompartido = recursoCompartido;
        this.vista = vista;
        this.ojoCliente = new OjoCliente(vista,recursoCompartido);
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "ATRAS REG":
            case "ATRAS SESION":
                vista.setLogin();
                break;

            case "REGISTRAR":
                vista.setRegistro();
                break;

            case "INICIAR SESION":
                vista.setInicioSesion();
                break;

            case "INTENTO REGISTRO":
                intentoRegistro();
                break;

            case "INTENTO INICIO SESION":
                intentoInicioSesion();
                break;

            case "PAGAR":
                vista.setDialogFinViaje();
                break;

            case "PEDIR VIAJE":
                System.out.println("HOLAA PDIO VAIJE");
                pedirViaje();
                break;

            case "PAGAR VIAJE":
                System.out.println("PIDO VIAJEEEE");
                pagarViaje();
                vista.disablePagar();
                vista.enablePedirViaje();
                break;
            
            case "ABANDONAR":
                vista.dispose();
                recursoCompartido.matarSimulacion();
                break;
                
            case "CONTINUAR PIDIENDO":
                vista.disablePagar();
                vista.enablePedirViaje();
                break;
        }
    }

    private void intentoRegistro() {
        String nombre = vista.getNombre();
        String nombreUsuario = vista.getNombreUsuario();
        String contrasena = vista.getContrasena();

        if (validoParametrosRegistro(nombre, nombreUsuario, contrasena)) {
            cliente = new Cliente(nombreUsuario, nombre, contrasena);
            try {
                recursoCompartido.addCliente(cliente);
                ojoCliente.setCliente(cliente);
                vista.setDialogExito("Registro exitoso");
                vista.setApp();
            } catch (ExceptionUsuario ex) {
                vista.setDialogError("Nombre usuario repetido");
            }
        } else {
            vista.setDialogAdv("<html>Datos inválidos.<br>Por favor, reingrese correctamente.</html>");
        }
    }

    private void intentoInicioSesion() {
        String nombreUsuario = vista.getNombreUsuario();
        String contrasena = vista.getContrasena();

        if (validoParametrosSesion(nombreUsuario, contrasena)) {
            try {
                cliente = recursoCompartido.getCliente(nombreUsuario);
                if (cliente != null) {
                    vista.setDialogExito("Inicio sesión exitoso");
                    ojoCliente.setCliente(cliente);
                    vista.setApp();
                } else {
                    vista.setDialogError("Usuario no encontrado");
                }
            } catch (ExceptionUsuario ex) {
                vista.setDialogError("Usuario no encontrado");
            }
        } else {
            vista.setDialogAdv("<html>Datos inválidos.<br>Por favor, reingrese correctamente.</html>");
        }
    }

    private void pedirViaje() {

        double distancia = vista.getDistancia();
        LocalDateTime fecha = vista.getFecha();
        int mascota = vista.getMascota();
        int equipaje = vista.getEquipaje();
        int cantPax = vista.getCantPax();
        String zona = vista.getZona();

        if (validoParametrosViaje(distancia, fecha))
            try {
                recursoCompartido.pedirViaje(cliente, zona, mascota, "transporte", equipaje, cantPax, distancia, fecha);
                vista.disablePedirViaje();
             } catch (ExceptionPedido ex) {
                vista.setDialogPedidoRechazado(ex.getMessage());
        } else
        {
            if(distancia <= 0)
                vista.setDialogAdv("<html>Distancia invalida.<br>Por favor, reingrese correctamente.</html>");
            else
                vista.setDialogAdv("<html>Fecha invalida.<br>Por favor, reingrese correctamente.</html>");
        }
    }

    private void pagarViaje() {
        recursoCompartido.pagarViaje(cliente);
        vista.setDialogFinViaje();
    }
    
    private boolean validoParametrosViaje(double distancia, LocalDateTime fecha)
    {
        return distancia > 0 ;//&&  (LocalDateTime.now().isEqual(fecha)||LocalDateTime.now().isBefore(fecha));
    }
    private boolean validoParametrosRegistro(String nombre, String usuario, String contrasena) {
        return (nombre != null && !nombre.equals("") && usuario != null && !usuario.equals("") &&  contrasena != null && !contrasena.equals(""));
    }

    private boolean validoParametrosSesion(String usuario, String contrasena) {
        return (usuario !=null && !usuario.equals("") && contrasena !=null && !contrasena.equals(""));
    }
}