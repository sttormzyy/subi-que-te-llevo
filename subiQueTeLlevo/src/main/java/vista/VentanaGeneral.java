/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Usuario
 */
public class VentanaGeneral extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public VentanaGeneral() {
        initComponents();
        panelTitulos.setSize(400,100);
       // textGeneral.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       this.setTitle("Subi que te llevo - Simulacion");
       this.setLocation(0,100);
       this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconovioleta.jpg")).getImage());
       this.setVisible(true);
    }
    
    public void appendGeneral(String mensaje) {
            textGeneral.append(mensaje);
    }

    
     public void appendChofer(String mensaje)
    {
        this.textChofer.append(mensaje);
    }
     
     public void appendCliente(String mensaje)
    {
        System.out.println("\n mensaje cliente\n");
        this.textCliente.append(mensaje);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelTextos = new javax.swing.JPanel();
        scrollPanelGeneral = new javax.swing.JScrollPane();
        textGeneral = new javax.swing.JTextArea();
        scrollPanelChofer = new javax.swing.JScrollPane();
        textChofer = new javax.swing.JTextArea();
        scrollPanelCliente = new javax.swing.JScrollPane();
        textCliente = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(620, 378));

        panelTitulos.setBackground(new java.awt.Color(22, 14, 37));
        panelTitulos.setPreferredSize(new java.awt.Dimension(720, 50));
        panelTitulos.setLayout(new java.awt.GridLayout(1, 3));

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VENTANA GENERAL");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        panelTitulos.add(jLabel2);

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VENTANA CHOFER");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        panelTitulos.add(jLabel1);

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("VENTANA CLIENTE");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        panelTitulos.add(jLabel3);

        getContentPane().add(panelTitulos, java.awt.BorderLayout.PAGE_START);

        panelTextos.setBackground(new java.awt.Color(122, 110, 137));
        panelTextos.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        panelTextos.setMinimumSize(new java.awt.Dimension(720, 228));
        panelTextos.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        scrollPanelGeneral.setPreferredSize(new java.awt.Dimension(234, 290));

        textGeneral.setBackground(new java.awt.Color(234, 234, 234));
        textGeneral.setColumns(20);
        textGeneral.setRows(5);
        textGeneral.setFocusable(false);
        scrollPanelGeneral.setViewportView(textGeneral);

        panelTextos.add(scrollPanelGeneral);

        textChofer.setBackground(new java.awt.Color(234, 234, 234));
        textChofer.setColumns(20);
        textChofer.setRows(5);
        textChofer.setFocusable(false);
        textChofer.setPreferredSize(new java.awt.Dimension(232, 290));
        scrollPanelChofer.setViewportView(textChofer);

        panelTextos.add(scrollPanelChofer);

        textCliente.setBackground(new java.awt.Color(234, 234, 234));
        textCliente.setColumns(20);
        textCliente.setRows(5);
        textCliente.setFocusable(false);
        textCliente.setPreferredSize(new java.awt.Dimension(232, 290));
        scrollPanelCliente.setViewportView(textCliente);

        panelTextos.add(scrollPanelCliente);

        getContentPane().add(panelTextos, java.awt.BorderLayout.CENTER);

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
            java.util.logging.Logger.getLogger(VentanaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaGeneral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelTextos;
    private javax.swing.JPanel panelTitulos;
    private javax.swing.JScrollPane scrollPanelChofer;
    private javax.swing.JScrollPane scrollPanelCliente;
    private javax.swing.JScrollPane scrollPanelGeneral;
    private javax.swing.JTextArea textChofer;
    private javax.swing.JTextArea textCliente;
    private javax.swing.JTextArea textGeneral;
    // End of variables declaration//GEN-END:variables
}
