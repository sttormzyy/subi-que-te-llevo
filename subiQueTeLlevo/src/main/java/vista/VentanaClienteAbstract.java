/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;

/**
 *Clase que define un comportamiento basico para las distintas ventanas usadas en la app ademas de representar un ancestro comun y facilitar el uso polimorfico
 * */
public class VentanaClienteAbstract extends javax.swing.JPanel implements KeyListener,MouseListener {

    /**
     * Creates new form VentanaClienteAbstract
     */
    public VentanaClienteAbstract() {
        initComponents();
    }

    @Override
     public void paint(Graphics g){
         Image imagen = new ImageIcon(getClass().getResource("/imagenes/fondo1violeta.jpg")).getImage();
         g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
         setOpaque(false);
         super.paint(g);
     }
     
    public String getNombre() {
        return null;
    }

    ;

    public String getContrasena() {
        return null;
    }

    ;

    public String getNombreUsuario() {
        return null;
    }

    ;

    public String getZona() {
        return null;
    }

    ;

    public int getEquipaje() {
        return -1;
    }

    ;

   public int getMascota() {
        return -1;
    }

    ;

  public Integer getCantPax() {
        return null;
    }

    ;

  public LocalDateTime getFecha() {
        return null;
    }

    ;

   public double getDistancia() {
        return -1;
    }

    ;
    
   public void appendDisplay(String mensaje) {
    }

    ;
    
   public void enablePagar() {
    }

    ;

   public void disablePagar() {
    }

    ;
   
    public void disablePedirViaje() {
    }

    ;
      
    public void enablePedirViaje() {
    }

    ;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
   
    }

    @Override
    public void keyReleased(KeyEvent e) {
  
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    
    }

    @Override
    public void mousePressed(MouseEvent e) {
     
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
  
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
