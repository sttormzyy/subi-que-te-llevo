/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaSimulacion;

/**
 *
 * @author Usuario
 */
public class ControladorMenuSimulacion implements Controlador,ActionListener{
private VentanaSimulacion vista;
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getActionCommand().equals("COMENZAR"))
        {
            vista.setVisible(false);
        }
    }
    
    public void setVista(VentanaSimulacion v)
    {
        this.vista = v;
    }
    
    
}
