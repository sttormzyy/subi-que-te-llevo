/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class VentanaCliente extends javax.swing.JFrame {

    private PanelLogin panelLogin = new PanelLogin();
    private PanelInicioSesion panelSesion = new PanelInicioSesion();
    private PanelRegistro panelRegistro = new PanelRegistro();
    private PanelApp panelApp = new PanelApp();
    private DialogFinViaje dialogFinViaje = new DialogFinViaje(this,"Fin Viaje", true);
    private JPanel fondo = new JPanel();
    private VentanaClienteAbstract currentVentana;

    /**
     * Creates new form NewJFrame
     */
    public VentanaCliente() {
        this.setContentPane(fondo);
        fondo.setBackground(new Color(22,14,37));
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconovioleta.jpg")).getImage());
        initComponents();
        this.setTitle("Subi que te llevo");
        this.setLocation(800,100);
        currentVentana = panelLogin;
        switchPanel(panelLogin);
        setVisible(true);
    }

   public void setRegistro()
    {
        this.setTitle("Subi que te llevo - Registro");
        switchPanel(panelRegistro);
    }
   
   public void setInicioSesion()
    {
        this.setTitle("Subi que te llevo - Inicio de sesion");
        switchPanel(panelSesion);
    }
   
   public void setLogin()
    {
        this.setTitle("Subi que te llevo - Login");
        switchPanel(panelLogin);
    }
   
   public void setApp()
    {
        this.setMinimumSize(new Dimension(600,420));
        setContentPane(panelApp);
        currentVentana = (VentanaClienteAbstract) panelApp;
        revalidate();
        repaint();
    }
   
   public void setActionListener(ActionListener c)
   {
       panelSesion.getButtonSesion().addActionListener(c);
       panelSesion.getButtonAtras().addActionListener(c);
       panelRegistro.getButtonAtras().addActionListener(c);
       panelRegistro.getButtonRegistro().addActionListener(c);
       panelLogin.getButtonSesion().addActionListener(c);
       panelLogin.getButtonRegistro().addActionListener(c);
       panelApp.getButtonPagar().addActionListener(c);
       panelApp.getButtonPedirViaje().addActionListener(c);
       dialogFinViaje.getButtonAbandonar().addActionListener(c);
   }
   
   public void setDialogError(String mensaje)
    {
        DialogCliente dialog = new DialogCliente(this, true, "Error", mensaje);
        dialog.setVisible(true);
    }
    
    public void setDialogExito(String mensaje)
    {
        DialogCliente dialog = new DialogCliente(this, true, "Exito", mensaje);
        dialog.setVisible(true);
    }
    
    public void setDialogAdv(String mensaje)
    {
        DialogCliente dialog = new DialogCliente(this, true, "Advertencia", mensaje);
        dialog.setVisible(true);
    }
    
    public void setDialogPedidoRechazado(String mensaje)
    {
        DialogCliente dialog = new DialogCliente(this, true, "Advertencia", mensaje);
        dialog.setVisible(true);
    }
    
    public void setDialogFinViaje()
    {
        dialogFinViaje.setVisible(true);
    }
    
    public String getNombre()
    {
        return currentVentana.getNombre();
    }
    
    public String getNombreUsuario()
    {
        return currentVentana.getNombreUsuario();
    }
    
    public String getContrasena()
    {
        return currentVentana.getContrasena();
    }
    
    private void switchPanel(JPanel ventana) {
        getContentPane().removeAll();
        getContentPane().add(ventana);
        currentVentana= (VentanaClienteAbstract) ventana; 
        revalidate();
        repaint();
    }
    
    
    public String getZona()
    {
       return currentVentana.getZona();
    }
    
    public LocalDateTime getFecha()
    {
       return currentVentana.getFecha(); 
    }
    
    public int getMascota()
    {
       return currentVentana.getMascota();  
    }
    
    public int getEquipaje()
    {
       return currentVentana.getEquipaje();
    }
    
    public double getDistancia()
    {
       return currentVentana.getDistancia(); 
    }
    
    public int getCantPax()
    {
       return currentVentana.getCantPax(); 
    }
    
    public void appendDisplay(String mensaje) {
            currentVentana.appendDisplay(mensaje);
    }
    
  
    public void enablePagar(){
      currentVentana.enablePagar();
    }
    
     public void disablePagar(){
      currentVentana.disablePagar();
    }
     
     public void enablePedirViaje(){
      currentVentana.enablePedirViaje();
    }
    
     public void disablePedirViaje(){
      currentVentana.disablePedirViaje();
    } 
     
     
     public void disposeDialogFinViaje()
     {
       this.dialogFinViaje.setVisible(false);  
     }
    ;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel("fondo1violeta.jpg");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(485, 435));
        setPreferredSize(new java.awt.Dimension(485, 435));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(22, 14, 37));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
