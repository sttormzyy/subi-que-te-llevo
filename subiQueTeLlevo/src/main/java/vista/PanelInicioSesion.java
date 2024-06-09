/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;


/**
 *Clase encargad de representar la vista de inicio de sesion de la app
 * */
public class PanelInicioSesion extends VentanaClienteAbstract implements KeyListener{

    /**
     * Creates new form NewJPanel
     */
    public PanelInicioSesion() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textNombreUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textContrasena = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();
        botonIniciarSesion = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        setMinimumSize(new java.awt.Dimension(470, 400));

        textNombreUsuario.addKeyListener(this);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese nombre de usuario");

        textContrasena.addKeyListener(this);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese contraseña");

        botonAtras.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonAtras.setText("atras");
        botonAtras.setActionCommand("ATRAS SESION");

        botonIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonIniciarSesion.setText("INICIAR SESION");
        botonIniciarSesion.setActionCommand("INTENTO INICIO SESION");
        botonIniciarSesion.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1)))
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(botonAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAtras)
                    .addComponent(botonIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Obtiene el boton utilizado para iniciar de sesion.<br>
	 * <b>POST:</b> Se devuelve el boton de inicio de sesion.<br>
     * @return  boton de inicio de sesion
     */
    public JButton getButtonSesion()
    {
        return botonIniciarSesion;
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
    
  
    @Override
    public String getNombre() {
        return null;
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField textContrasena;
    private javax.swing.JTextField textNombreUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    /**
     * Habilita el boton de iniciar sesion siempre y cuando los campos nombre y contrasena esten completos
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e) {
        String nombreUsuario = textNombreUsuario.getText();
        String contrasena = textContrasena.getText();
       
        boolean condicion  = !nombreUsuario.isEmpty() && !contrasena.isEmpty();
        
        
        this.botonIniciarSesion.setEnabled(condicion);
    }

   
}
