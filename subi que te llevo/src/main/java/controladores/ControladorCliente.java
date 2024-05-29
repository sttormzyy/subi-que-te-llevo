package controladores;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import excepciones.usuario.ExceptionUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.Empresa;
import usuarios.Cliente;
import vista.MainFrameCliente;

/**
 *
 * @author Usuario
 */
public class ControladorCliente implements Controlador,ActionListener {
    private Empresa modelo;
    private MainFrameCliente  vista;
    private String nombreUsuario;
    private String nombre;
    private String contrasena;

    public ControladorCliente(Empresa modelo, MainFrameCliente vista)
    {
        super();
        this.modelo = modelo;
        this.vista = vista;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch(e.getActionCommand())
        {
            case "ATRAS_REG", "ATRAS_SESION" -> vista.setLogin();
            case "REGISTRO" -> vista.setRegistro();
            
            case "INICIAR_SESION" ->   vista.setInicioSesion();

            
            case "INTENTO_REGISTRO" -> {
                 System.out.println("insesion");
                nombre = vista.getNombre();
                nombreUsuario = vista.getNombreUsuario();
                contrasena = vista.getContrasena();
                
                if(validoParametrosRegistro(nombre, nombreUsuario, contrasena))
                {
                    
                    try {
                        modelo.addCliente(new Cliente( nombreUsuario,nombre, contrasena));
                        //JOptionPane.showMessageDialog(null, "Registro exitoso", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        vista.setDialogExito("Registro exitoso");
                    } catch (ExceptionUsuario ex) {
                        vista.setDialogError("Nombre usuario repetido");
                        //JOptionPane.showMessageDialog(null, "Nombre usuario repetido", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                    
                }else
                    //JOptionPane.showMessageDialog(null, "Complete todos los campossdadsadasdsadasdsadassads", "Error", JOptionPane.ERROR_MESSAGE);
                    vista.setDialogAdv("<html>Datos inválidos.<br>Por favor, reingrese correctamente.</html>");
            }
            
            case "INTENTO_INICIO_SESION" -> {
                System.out.println("insesion");
                nombreUsuario = vista.getNombreUsuario();
                contrasena = vista.getContrasena();
                
                if(validoParametrosSesion(nombreUsuario, contrasena))
                {
                    try {
                        if(modelo.getCliente(nombreUsuario)!= null)
                            //JOptionPane.showMessageDialog(null, "Registro exitoso", "Exito", JOptionPane.INFORMATION_MESSAGE);
                            vista.setDialogExito("Inicio sesion exitoso");
                    } catch (ExceptionUsuario ex) {
                        vista.setDialogError("Usuario no encontrado");
                        //JOptionPane.showMessageDialog(null, "Nombre usuario repetido", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                    
                }else
                    //JOptionPane.showMessageDialog(null, "Complete todos los campossdadsadasdsadasdsadassads", "Error", JOptionPane.ERROR_MESSAGE);
                    vista.setDialogAdv("<html>Datos inválidos.<br>Por favor, reingrese correctamente.</html>");
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

