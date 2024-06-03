/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import excepciones.pedido.ExceptionPedido;
import excepciones.usuario.ExceptionUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import simulacion.RecursoCompartido;
import sistema.Empresa;
import usuarios.Cliente;
import vista.VentanaCliente;



/**
 *
 * @author Usuario
 */
public class ControladorCliente implements Controlador,ActionListener {
    private RecursoCompartido recursoCompartido;
    private VentanaCliente  vista;
    private String nombreUsuario;
    private String nombre;
    private String contrasena;

    public ControladorCliente(RecursoCompartido recursoCompartido, VentanaCliente vista)
    {
        super();
        this.recursoCompartido = recursoCompartido;
        this.vista = vista;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch(e.getActionCommand())
        {
            case "ATRAS REG", "ATRAS SESION" -> vista.setLogin();
            case "REGISTRAR" -> vista.setRegistro();
            
            case "INICIAR SESION" ->   vista.setInicioSesion();

            
            case "INTENTO REGISTRO" -> {
                nombre = vista.getNombre();
                nombreUsuario = vista.getNombreUsuario();
                contrasena = vista.getContrasena();
                
                if(validoParametrosRegistro(nombre, nombreUsuario, contrasena))
                {
                    
                    try {
                        recursoCompartido.addCliente(new Cliente( nombreUsuario,nombre, contrasena));
                        vista.setDialogExito("Registro exitoso");
                        vista.setApp();
                    } catch (ExceptionUsuario ex) {
                        vista.setDialogError("Nombre usuario repetido");
                    }
                    
                }else
                    vista.setDialogAdv("<html>Datos inválidos.<br>Por favor, reingrese correctamente.</html>");
            }
            
            case "INTENTO INICIO SESION" -> {
                nombreUsuario = vista.getNombreUsuario();
                contrasena = vista.getContrasena();
                
                if(validoParametrosSesion(nombreUsuario, contrasena))
                {
                    try {
                        if(recursoCompartido.getCliente(nombreUsuario)!= null)
                        {
                            vista.setDialogExito("Inicio sesion exitoso");
                            vista.setApp();
                        }                    
                    } catch (ExceptionUsuario ex) {
                        vista.setDialogError("Usuario no encontrado");
                        
                    }
                    
                }else
                    vista.setDialogAdv("<html>Datos inválidos.<br>Por favor, reingrese correctamente.</html>");
            }
            
            case "PAGAR" -> vista.setDialogFinViaje();
            
            case "PEDIR VIAJE" ->
            {
                System.out.println("PIDO VIAJE");
                try {
                    double distancia = vista.getDistancia();
                    LocalDateTime fecha = vista.getFecha();
                    int mascota = vista.getMascota();
                    int equipaje = vista.getEquipaje();
                    int cantPax = vista.getCantPax();
                    String zona = vista.getZona();
                    Cliente cliente = recursoCompartido.getCliente(nombreUsuario);
                    
                    try {
                        recursoCompartido.pedirViaje(cliente,zona,mascota,"transporte",equipaje,cantPax,distancia,fecha);
                    } catch (ExceptionPedido ex) {
                        vista.setDialogPedidoRechazado(ex.getMessage());
                    }
                } catch (ExceptionUsuario ex) {
                    Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            case "PAGAR VIAJE" ->
            {
                try {
                    Cliente cliente = recursoCompartido.getCliente(nombreUsuario);
                    
                    recursoCompartido.pagarViaje(cliente);
                    vista.setDialogFinViaje();
                } catch (ExceptionUsuario ex) {
                    
                }
            }


            
        }
    }
    
private boolean validoParametrosRegistro(String nombre, String usuario, String contrasena)
{
 return (nombre != null && !nombre.equals("") && usuario != null && !usuario.equals("") &&  contrasena != null && !contrasena.equals(""));
}

private boolean validoParametrosSesion(String usuario, String contrasena)
{
 return (usuario !=null && !usuario.equals("") && contrasena !=null && !contrasena.equals(""));
}
}

