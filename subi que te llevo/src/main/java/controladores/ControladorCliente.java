/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import excepciones.usuario.ExceptionUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.Empresa;
import usuarios.Cliente;
import vista.VentanaCliente;



/**
 *
 * @author Usuario
 */
public class ControladorCliente implements Controlador,ActionListener {
    private Empresa modelo;
    private VentanaCliente  vista;
    private String nombreUsuario;
    private String nombre;
    private String contrasena;

    public ControladorCliente(Empresa modelo, VentanaCliente vista)
    {
        super();
        this.modelo = modelo;
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
                        modelo.addCliente(new Cliente( nombreUsuario,nombre, contrasena));
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
                        if(modelo.getCliente(nombreUsuario)!= null)
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

