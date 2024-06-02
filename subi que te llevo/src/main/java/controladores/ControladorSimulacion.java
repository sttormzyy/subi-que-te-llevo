/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import simulacion.RecursoCompartido;
import vista.VentanaGeneral;

/**
 *
 * @author Usuario
 */
public class ControladorSimulacion implements ActionListener{
    private VentanaGeneral vista;
    private RecursoCompartido recursoCompartido;
    
    public ControladorSimulacion(VentanaGeneral vista, RecursoCompartido recursoCompartido)
    {
        this.vista = vista;
        this.recursoCompartido = recursoCompartido;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
       if(evento.getActionCommand().equals("FINALIZAR SIMULACION"))
           this.recursoCompartido.matarSimulacion();
    }
}
