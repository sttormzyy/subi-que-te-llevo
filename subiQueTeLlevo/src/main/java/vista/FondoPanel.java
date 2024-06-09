/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *Clase que permite crear JPanels con la imagen de fondo que se desee 
 **/
public  class FondoPanel extends JPanel {
     private Image imagen;
     private String ruta;
    
     FondoPanel(String ruta){
         super();
         this.ruta = "/imagenes/" + ruta;
     }

     /**
      * Metodo que permite tener una imagen como fondo de JPanel la cual sea capaz de adaptarse al tamano del mismo
      * @param g graficos
      */
     public void paint(Graphics g){
         imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
         g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
         setOpaque(false);
         super.paint(g);
     }
}
