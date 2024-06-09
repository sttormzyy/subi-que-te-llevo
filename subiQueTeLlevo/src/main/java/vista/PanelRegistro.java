/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;


import java.awt.event.KeyEvent;
import javax.swing.JButton;


/**
 *Clase encargada de representar la vista de registro para un nuevo cliente 
 * */
public class PanelRegistro extends VentanaClienteAbstract{

    /**
     * Creates new form NewJPanel
     */
    public PanelRegistro() 
    {
        initComponents();
    }
    
    /**
     * Obtiene el boton utilizado para registro.<br>
	 * <b>POST:</b> Se devuelve el boton para registro.<br>
     * @return boton para registro.
     */
     public JButton getButtonRegistro()
    {
        return botonRegistrarse;
    }
     
     /**
     * Obtiene el boton utilizado para volver a la pagina de login.<br>
	 * <b>POST:</b> Se devuelve el boton para volver atras.<br>
     * @return  boton para volver atras
     */
     public JButton getButtonAtras()
    {
        return botonAtras;
    }
     
     /**
     * Obtiene el nombre real ingresado por el usuario<br>
	 * <b>POST:</b> Se devuelve el nombre nombre real ingresado por el usuario.<br>
     * @return  nombre real usuario
     */
    @Override
     public String getNombre()
     {
         return textNombre.getText();
     }
     
     /**
     * Obtiene la contrasena ingresada por el usuario<br>
	 * <b>POST:</b> Se devuelve la contrasena ingresada por el usuario.<br>
     * @return contrasena usuario
     */
    @Override
     public String getContrasena() {
       return textContrasena.getText();
    }


     /**
     * Obtiene el nombre de usuario ingresada por el usuario<br>
	 * <b>POST:</b> Se devuelve el nombre de usuario ingresada por el usuario.<br>
     * @return nombre de usuario
     */
    @Override
    public String getNombreUsuario() {
        return textNombreUsuario.getText();
    }
   

    /**
     * Habilita el boton de registro siempre y cuando los campos nombre, nombre de usuario y contrasena esten completos
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e) {
        
        String nombre = textNombre.getText();
        String nombreUsuario = textNombreUsuario.getText();
        String contrasena = textContrasena.getText();
       
        boolean condicion  = !nombre.isEmpty() && !nombreUsuario.isEmpty() && !contrasena.isEmpty();
        
        
        this.botonRegistrarse.setEnabled(condicion);
   }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        textNombreUsuario = new javax.swing.JTextField();
        botonRegistrarse = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textContrasena = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        setMinimumSize(new java.awt.Dimension(470, 400));
        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese nombre de usuario");

        textNombre.addKeyListener(this);

        textNombreUsuario.addKeyListener(this);

        botonRegistrarse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonRegistrarse.setText("REGISTRARSE");
        botonRegistrarse.setActionCommand("INTENTO REGISTRO");
        botonRegistrarse.setEnabled(false);

        botonAtras.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonAtras.setText("atras");
        botonAtras.setActionCommand("ATRAS REG");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingrese contraseña");

        textContrasena.addKeyListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(textNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(textContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel4)))
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(botonAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(textContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAtras))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonRegistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField textContrasena;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNombreUsuario;
    // End of variables declaration//GEN-END:variables

   
}
