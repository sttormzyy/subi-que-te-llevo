/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *Clase encargada de representar la ventana de la aplicacion e ir navegando entre vistas de registro, inicio de sesion y pedido de viaj
 * **/
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

    /**
     * Cambia la ventana actual a la vista de registro
     */
   public void setRegistro()
    {
        this.setTitle("Subi que te llevo - Registro");
        switchPanel(panelRegistro);
    }
   
   /**
     * Cambia la ventana actual a la vista de inicio de sesion
     */
   public void setInicioSesion()
    {
        this.setTitle("Subi que te llevo - Inicio de sesion");
        switchPanel(panelSesion);
    }
   
   /**
     * Cambia la ventana actual a la vista de login
     */
   public void setLogin()
    {
        this.setTitle("Subi que te llevo - Login");
        switchPanel(panelLogin);
    }
   
    /**
     * Cambia la ventana actual a la vista de app donde se puede rellenar formulario de viaje
     */
   public void setApp()
    {
        this.setMinimumSize(new Dimension(600,420));
        setContentPane(panelApp);
        currentVentana = (VentanaClienteAbstract) panelApp;
        revalidate();
        repaint();
    }
   
    /**
     * Setea el controlador correspondiente a los objetos interactivos de la ventana
     * @param c action listener
     */
   public void setActionListener(ActionListener c)
   {
       panelSesion.getButtonSesion().addActionListener(c);
       panelSesion.getButtonAtras().addActionListener(c);
       panelRegistro.getButtonAtras().addActionListener(c);
       panelRegistro.getButtonRegistro().addActionListener(c);
       panelLogin.getButtonSesion().addActionListener(c);
       panelLogin.getButtonRegistro().addActionListener(c);
       panelApp.addActionListener(c);
       dialogFinViaje.getButtonAbandonar().addActionListener(c);
   }
   
   /**
     * Muestra por pantalla una ventana emergente comunicando un error al usuario
     * @param mensaje mensaje a mostrar
     * @param tipo tipo de mensaje
     */
   public void setDialog(String mensaje, String tipo)
    {
        DialogCliente dialog = new DialogCliente(this, true, tipo, mensaje);
        dialog.setVisible(true);
    }
    
    
   /**
     * Muestra por pantalla una ventana emergente que permite al cliente actual seguir pidiendo viajes o abandonar la app
     */
    public void setDialogFinViaje()
    {
        dialogFinViaje.setLocationRelativeTo(this);
        dialogFinViaje.setVisible(true);
    }
    
    
    /**
     * Obtiene el nombre real ingresado por el usuario<br>
	 * <b>POST:</b> Se devuelve el nombre nombre real ingresado por el usuario.<br>
     * @return  nombre real usuario
     */
    public String getNombre()
    {
        return currentVentana.getNombre();
    }
    
     /**
     * Obtiene el nombre de usuario ingresada por el usuario<br>
	 * <b>POST:</b> Se devuelve el nombre de usuario ingresada por el usuario.<br>
     * @return nombre de usuario
     */
    public String getNombreUsuario()
    {
        return currentVentana.getNombreUsuario();
    }
    
    /**
     * Obtiene la contrasena ingresada por el usuario<br>
	 * <b>POST:</b> Se devuelve la contrasena ingresada por el usuario.<br>
     * @return contrasena usuario
     */
    public String getContrasena()
    {
        return currentVentana.getContrasena();
    }
    
    /**
     * Modifica la ventana actual por la ventana pasada por parametro (transiciones registro -> app por ejemplo)
     * @param ventana 
     */
    private void switchPanel(JPanel ventana) {
        getContentPane().removeAll();
        getContentPane().add(ventana);
        currentVentana= (VentanaClienteAbstract) ventana; 
        revalidate();
        repaint();
    }
    
    
    /**
     * Obtiene la zona de viaje por el usuario<br>
	 * <b>POST:</b> Se devuelve la contrasena ingresada por el usuario.<br>
     * @return contrasena usuario
     */
    public String getZona()
    {
       return currentVentana.getZona();
    }
    
    /**
     * Devuelve la fecha  ingresada por el usuario.<br>
	 * <b>POST:</b> Se devuelve  la fecha del proximo viaje.<br>
     * @return fecha del proximo viaje
     */
    public LocalDateTime getFecha()
    {
       return currentVentana.getFecha(); 
    }
    
     /**
     * Informa si el viaje del cliente es con mascota o no.<br>
	 * <b>POST:</b> Se devuelve la confirmacion de mascota.<br>
     * @return confirmacion de mascota
     */
    public int getMascota()
    {
       return currentVentana.getMascota();  
    }
    
    /**
     * Informa si el viaje del cliente es con equipaje o no.<br>
	 * <b>POST:</b> Se devuelve la confirmacion de equipaje.<br>
     * @return confirmacion de equipaje
     */
    public int getEquipaje()
    {
       return currentVentana.getEquipaje();
    }
    
    /**
     * Devuelve  la distancia del proximo viaje ingresada por el usuario.<br>
	 * <b>POST:</b> Se devuelve  la distancia del proximo viaje.<br>
     * @return distancia del proximo viaje, -1 si es invalido
     */
    public double getDistancia()
    {
       return currentVentana.getDistancia(); 
    }
    
    /**
     * Devuelve la cantidad de pasajeros ingresada por el usuario.<br>
	 * <b>POST:</b> Se devuelve  la cantidad de pasajeros del proximo viaje.<br>
     * @return cantidad de pasajeros
     */
    public int getCantPax()
    {
       return currentVentana.getCantPax(); 
    }
    
    /**
     * Concatena el text area los eventos que suceden relacionados al estado del viaje en curso
     * @param mensaje descripcion del estado del viaje
     */
    public void appendDisplay(String mensaje) {
            currentVentana.appendDisplay(mensaje);
    }
    
  
    /**
     * Habilita el boton de pagar
     * */
    public void enablePagar(){
      currentVentana.enablePagar();
    }
    
     /**
     * Deshabilita el boton de pagar
     * */
     public void disablePagar(){
      currentVentana.disablePagar();
    }
     
     /**
     * Habilita el boton de pedir viaje
     * */
     public void enablePedirViaje(){
      currentVentana.enablePedirViaje();
    }
    
     /**
     * Deshabilita el boton de pedir viaje
     * */
     public void disablePedirViaje(){
      currentVentana.disablePedirViaje();
    } 
     
     /**
      * Elimina la ventana emergente de fin de viaje una vez el usuario decidio seguir pidiendo o abandonar la app
      */
     public void disposeDialogFinViaje()
     {
       this.dialogFinViaje.setVisible(false);  
     }
    ;
 
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
