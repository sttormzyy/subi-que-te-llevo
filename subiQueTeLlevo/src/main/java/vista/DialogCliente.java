/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

/**
 *Clase encargada transmitir informacion de errores o advertencias al usuario en formato de ventana emergente
 */
public class DialogCliente extends javax.swing.JDialog {
    /**
     * Creates new form DialogCliente
      * @param parent padre
     * @param modal modo
     * @param tipo tipo
     * @param texto texto
     **/
    public DialogCliente(java.awt.Frame parent, boolean modal, String tipo, String texto) {
        super(parent, tipo, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconovioleta.jpg")).getImage());
        label.setText(texto);
        }
        
        
        private FondoPanel  getImagenDialog()
        {
            switch(getTitle().toUpperCase())
            {
                case "ERROR": return new FondoPanel("error.png");
                case "EXITO": return new FondoPanel("exito.png");
                case "ADVERTENCIA": return new FondoPanel("advertencia.png");
            }
            return null;
         }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        botonOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(215, 190, 245));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(231, 216, 248));
        jPanel1.setLayout(null);

        label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("jLabel1");
        jPanel1.add(label);
        label.setBounds(10, 10, 210, 40);

        botonOK.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonOK.setText("ok");
        botonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOKActionPerformed(evt);
            }
        });
        jPanel1.add(botonOK);
        botonOK.setBounds(150, 70, 51, 27);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Esconde el dialog una vez fue aceptado su mensaje por medio de la interaccion con el boton
     * @param evt evento boton apretado
     */
    private void botonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOKActionPerformed
        dispose();
    }//GEN-LAST:event_botonOKActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonOK;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
