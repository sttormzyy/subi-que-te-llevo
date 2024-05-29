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
 *
 * @author Usuario
 */
public class FondoPanel extends JPanel {
     private Image imagen;
     private String ruta;
    
     FondoPanel(String ruta){
         super();
         this.ruta = "/imagenes/" + ruta;
     }

     public void paint(Graphics g){
         imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
         g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
         setOpaque(false);
         super.paint(g);
     }
}
