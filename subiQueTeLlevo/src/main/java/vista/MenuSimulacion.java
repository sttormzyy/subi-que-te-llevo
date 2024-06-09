/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;


import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;


/**
 *Clase encargada de representar el menu de inicio de la simulacion en forma de ventana
**/
public class MenuSimulacion extends javax.swing.JFrame implements MouseListener{   
    
    /**
     * Creates new form VentanaSimulacion
     */
    public MenuSimulacion() {
        initComponents();
        this.setTitle("Menu Simulacion");
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconovioleta.jpg")).getImage());
        setVisible(true);
    }

    public void setActionListener(ActionListener c)
    {
        this.BotonComenzarSimulacion.addActionListener(c);
        this.BotonComenzarSimulacionVieja.addActionListener(c);
    }
    
    /**
     * Obtiene la cantidad de clientes para arrancar la simulacion ingresadas por usuario.<br>
	 * <b>POST:</b> Se devuelve el numero de clientes para la simulacion.<br>
     * @return cantidad de hilos clientes a usar en la simulacion.
     */
    public int getCantClientes()
    {
        return Integer.parseInt(textCantClientes.getText());
    }
    
    /**
     * Obtiene la cantidad maxima de viajes de los hilos cliente ingresada por usuario.<br>
	 * <b>POST:</b> Se devuelve la cantidad maxima de viajes de los hilos cliente.<br>
     * @return  cantidad maxima de viajes de los hilos cliente
     */
    public int getCantMaxViajeCliente()
    {
        return Integer.parseInt(textCantClientes.getText());
    }
     
    /**
     * Obtiene la cantidad de choferes contratados para arrancar la simulacion ingresadas por usuario.<br>
	 * <b>POST:</b> Se devuelve la cantidad de choferes contratados para arrancar la simulacion.<br>
     * @return  cantidad de hilos chofer contratado a usar en la simulacion.
     */
   public int getCantChoferContratado()
    {
        return Integer.parseInt(textCantContratado.getText());
    }
      
   /**
     * Obtiene la cantidad de choferes permanentes para arrancar la simulacion ingresadas por usuario.<br>
	 * <b>POST:</b> Se devuelve la cantidad de choferes permanentes para arrancar la simulacion.<br>
     * @return  cantidad de hilos chofer permanente a usar en la simulacion.
     */
    public int getCantChoferPermanente()
    {
        return Integer.parseInt(textCantPermanente.getText());
    }
     
    /**
     * Obtiene la cantidad de choferes temporarios para arrancar la simulacion ingresadas por usuario.<br>
	 * <b>POST:</b> Se devuelve la cantidad de choferes temporarios para arrancar la simulacion.<br>
     * @return  cantidad de hilos chofer permanente a usar en la simulacion.
     */
    public int getCantChoferTemporario()
    {
        return Integer.parseInt(textCantTemporario.getText());
    }
     
    /**
     * Obtiene la cantidad maxima de viajes de los hilos chofer ingresada por usuario.<br>
	 * <b>POST:</b> Se devuelve la cantidad maxima de viajes de los hilos chofer.<br>
     * @return  cantidad maxima de viajes de los hilos chofer
     */
    public int getCantMaxViajeChofer()
    {
        return Integer.parseInt(textCantMaxViajesxChofer.getText());
    }
    
    /**
     * Obtiene la cantidad de autos para arrancar la simulacion ingresada por usuario.<br>
	 * <b>POST:</b> Se devuelve la cantidad de autos para arrancar la simulacion.<br>
     * @return  cantidad de autos a ingresar en la empresa
     */
    public int getCantAuto()
    {
        return Integer.parseInt(textCantAuto.getText());
    }
    
    /**
     * Obtiene la cantidad de motos para arrancar la simulacion ingresada por usuario.<br>
	 * <b>POST:</b> Se devuelve la cantidad de motos para arrancar la simulacion.<br>
     * @return  cantidad de motos a ingresar en la empresa
     */
    public int getCantMoto()
    {
        return Integer.parseInt(textCantMoto.getText());
    }
    
    /**
     * Obtiene la cantidad de combis para arrancar la simulacion ingresada por usuario.<br>
	 * <b>POST:</b> Se devuelve la cantidad de combis para arrancar la simulacion.<br>
     * @return  cantidad de combis a ingresar en la empresa
     */
    public int getCantCombi()
    {
        return Integer.parseInt(textCantCombi.getText());
    }
    
    /**
     * Deshabilita el boton de iniciar simulacion con datos persistidos
     * */
    public void disableIniciarConDatosViejos()
    {
        this.BotonComenzarSimulacionVieja.setEnabled(false);
    }
    
    
    /**
     * Muestra por pantalla una ventana emergente comunicando un error al usuario
     * @param mensaje mensaje a mostrar
     * @param tipo tipo mensaje
     */
   public void setDialog(String mensaje, String tipo)
    {
        DialogCliente dialog = new DialogCliente(this, true, tipo, mensaje);
        dialog.setVisible(true);
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PanelCentral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelClientes = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textCantClientes = new javax.swing.JTextField();
        textCantMaxViajesXCliente = new javax.swing.JTextField();
        PanelChoferes2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        textCantMaxViajesxChofer = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        textCantContratado = new javax.swing.JTextField();
        textCantPermanente = new javax.swing.JTextField();
        textCantTemporario = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new FondoPanel("auto.png");
        jPanel7 = new FondoPanel("moto.png");
        jPanel6 = new FondoPanel("combi.png");
        textCantAuto = new javax.swing.JTextField();
        textCantMoto = new javax.swing.JTextField();
        textCantCombi = new javax.swing.JTextField();
        BotonComenzarSimulacion = new javax.swing.JButton();
        BotonComenzarSimulacionVieja = new javax.swing.JButton();
        PanelImagen = new FondoPanel("subiquetellevo.jpg");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        PanelCentral.setBackground(new java.awt.Color(199, 179, 211));
        PanelCentral.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createTitledBorder("")));

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jLabel1.setText("¡ BIENVENIDO !");
        jLabel1.setIconTextGap(0);

        PanelClientes.setBackground(new java.awt.Color(178, 152, 214));
        PanelClientes.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createTitledBorder(null, "CLIENTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12)))); // NOI18N
        PanelClientes.setForeground(new java.awt.Color(255, 255, 255));
        PanelClientes.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Cantidad clientes:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        PanelClientes.add(jLabel6, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Cantidad viajes:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        PanelClientes.add(jLabel12, gridBagConstraints);

        textCantClientes.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        textCantClientes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCantClientes.setText("3");
        textCantClientes.setMinimumSize(new java.awt.Dimension(40, 20));
        textCantClientes.setPreferredSize(new java.awt.Dimension(40, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.1;
        PanelClientes.add(textCantClientes, gridBagConstraints);

        textCantMaxViajesXCliente.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        textCantMaxViajesXCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCantMaxViajesXCliente.setText("2");
        textCantMaxViajesXCliente.setMinimumSize(new java.awt.Dimension(40, 20));
        textCantMaxViajesXCliente.setPreferredSize(new java.awt.Dimension(40, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weighty = 0.1;
        PanelClientes.add(textCantMaxViajesXCliente, gridBagConstraints);

        PanelChoferes2.setBackground(new java.awt.Color(178, 152, 214));
        PanelChoferes2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createTitledBorder(null, "CHOFERES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12)))); // NOI18N
        PanelChoferes2.setLayout(new java.awt.GridBagLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Cantidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 15);
        PanelChoferes2.add(jLabel19, gridBagConstraints);

        jLabel20.setText("Contratado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 14, 0, 0);
        PanelChoferes2.add(jLabel20, gridBagConstraints);

        jLabel21.setText("Temporario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 14, 0, 0);
        PanelChoferes2.add(jLabel21, gridBagConstraints);

        jLabel22.setText("Permanente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 14, 11, 0);
        PanelChoferes2.add(jLabel22, gridBagConstraints);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Tipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 23, 0, 0);
        PanelChoferes2.add(jLabel23, gridBagConstraints);

        textCantMaxViajesxChofer.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        textCantMaxViajesxChofer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCantMaxViajesxChofer.setText("2");
        textCantMaxViajesxChofer.setMinimumSize(new java.awt.Dimension(45, 20));
        textCantMaxViajesxChofer.setPreferredSize(new java.awt.Dimension(45, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        PanelChoferes2.add(textCantMaxViajesxChofer, gridBagConstraints);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Cantidad viajes:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 14, 0, 0);
        PanelChoferes2.add(jLabel24, gridBagConstraints);

        textCantContratado.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        textCantContratado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCantContratado.setText("2");
        textCantContratado.setMinimumSize(new java.awt.Dimension(45, 20));
        textCantContratado.setPreferredSize(new java.awt.Dimension(45, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 4, 6, 5);
        PanelChoferes2.add(textCantContratado, gridBagConstraints);

        textCantPermanente.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        textCantPermanente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCantPermanente.setText("1");
        textCantPermanente.setMinimumSize(new java.awt.Dimension(45, 20));
        textCantPermanente.setPreferredSize(new java.awt.Dimension(45, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        PanelChoferes2.add(textCantPermanente, gridBagConstraints);

        textCantTemporario.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        textCantTemporario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCantTemporario.setText("2");
        textCantTemporario.setMinimumSize(new java.awt.Dimension(45, 20));
        textCantTemporario.setPreferredSize(new java.awt.Dimension(45, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 1, 0);
        PanelChoferes2.add(textCantTemporario, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(178, 152, 214));
        jPanel5.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createTitledBorder(null, "VEHICULOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12)))); // NOI18N
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tipo");
        jPanel5.add(jLabel4, new java.awt.GridBagConstraints());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Cantidad");
        jPanel5.add(jLabel5, new java.awt.GridBagConstraints());

        jPanel4.setMinimumSize(new java.awt.Dimension(70, 30));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(70, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel5.add(jPanel4, gridBagConstraints);

        jPanel7.setMinimumSize(new java.awt.Dimension(70, 30));
        jPanel7.setPreferredSize(new java.awt.Dimension(70, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel5.add(jPanel7, gridBagConstraints);

        jPanel6.setMinimumSize(new java.awt.Dimension(70, 30));
        jPanel6.setPreferredSize(new java.awt.Dimension(70, 30));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel5.add(jPanel6, gridBagConstraints);

        textCantAuto.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        textCantAuto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCantAuto.setText("5");
        textCantAuto.setMinimumSize(new java.awt.Dimension(40, 20));
        textCantAuto.setPreferredSize(new java.awt.Dimension(40, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel5.add(textCantAuto, gridBagConstraints);

        textCantMoto.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        textCantMoto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCantMoto.setText("5");
        textCantMoto.setMinimumSize(new java.awt.Dimension(40, 20));
        textCantMoto.setPreferredSize(new java.awt.Dimension(40, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel5.add(textCantMoto, gridBagConstraints);

        textCantCombi.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        textCantCombi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCantCombi.setText("2");
        textCantCombi.setMinimumSize(new java.awt.Dimension(40, 20));
        textCantCombi.setPreferredSize(new java.awt.Dimension(40, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel5.add(textCantCombi, gridBagConstraints);

        BotonComenzarSimulacion.addMouseListener(this);
        BotonComenzarSimulacion.setBackground(new java.awt.Color(51, 0, 51));
        BotonComenzarSimulacion.setForeground(new java.awt.Color(255, 255, 255));
        BotonComenzarSimulacion.setText("COMENZAR NUEVA");
        BotonComenzarSimulacion.setActionCommand("COMENZAR");
        BotonComenzarSimulacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));

        BotonComenzarSimulacionVieja.setBackground(new java.awt.Color(51, 0, 51));
        BotonComenzarSimulacionVieja.setForeground(new java.awt.Color(255, 255, 255));
        BotonComenzarSimulacionVieja.setText("INICIAR CON DATOS CARGADOS");
        BotonComenzarSimulacionVieja.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));

        javax.swing.GroupLayout PanelCentralLayout = new javax.swing.GroupLayout(PanelCentral);
        PanelCentral.setLayout(PanelCentralLayout);
        PanelCentralLayout.setHorizontalGroup(
            PanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCentralLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonComenzarSimulacionVieja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotonComenzarSimulacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelChoferes2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        PanelCentralLayout.setVerticalGroup(
            PanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCentralLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(PanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCentralLayout.createSequentialGroup()
                        .addComponent(PanelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(PanelChoferes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonComenzarSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonComenzarSimulacionVieja, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelImagenLayout = new javax.swing.GroupLayout(PanelImagen);
        PanelImagen.setLayout(PanelImagenLayout);
        PanelImagenLayout.setHorizontalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        PanelImagenLayout.setVerticalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonComenzarSimulacion;
    private javax.swing.JButton BotonComenzarSimulacionVieja;
    private javax.swing.JPanel PanelCentral;
    private javax.swing.JPanel PanelChoferes2;
    private javax.swing.JPanel PanelClientes;
    private javax.swing.JPanel PanelImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField textCantAuto;
    private javax.swing.JTextField textCantClientes;
    private javax.swing.JTextField textCantCombi;
    private javax.swing.JTextField textCantContratado;
    private javax.swing.JTextField textCantMaxViajesXCliente;
    private javax.swing.JTextField textCantMaxViajesxChofer;
    private javax.swing.JTextField textCantMoto;
    private javax.swing.JTextField textCantPermanente;
    private javax.swing.JTextField textCantTemporario;
    // End of variables declaration//GEN-END:variables

   

    /**
     * Habilita el boton de comenzar simulacion nueva si todos los campos con parametros requeridos estan completos <br>
     * Caso contrario advierte al usuario que complete por medio de ventana emergente
     * @param e evento mouse
     */
    @Override
    public void mouseEntered(MouseEvent e) 
    {
        DialogCliente dialog;
        int cantClientes=-1;
        int cantChoferTemporario=-1;
        int cantChoferContratado=-1;
        int cantChoferPermanente=-1;
        int cantMaxViajeCliente=-1;
        int cantMaxViajeChofer=-1;
        int cantAutos=-1;
        int cantMotos=-1;
        int cantCombis=-1;
        
        try{
         cantClientes = getCantClientes();
         cantChoferTemporario = getCantChoferTemporario();
         cantChoferContratado = getCantChoferContratado();
         cantChoferPermanente = getCantChoferPermanente();
         cantMaxViajeCliente = getCantMaxViajeCliente();
         cantMaxViajeChofer = getCantMaxViajeChofer();
         cantAutos = getCantAuto();
         cantMotos = getCantMoto();
         cantCombis = getCantCombi();
        } catch (NumberFormatException exc){
          
        }
        
        
        boolean condicion = cantClientes > 0 && cantChoferTemporario > 0 && cantChoferContratado > 0 && cantChoferPermanente>0
                            && cantMaxViajeCliente>0 &&  cantMaxViajeChofer>0 && cantAutos>=0 && cantMotos>=0 && cantCombis>=0;
        if(condicion)
            this.BotonComenzarSimulacion.setEnabled(true);
        else
        {
            dialog = new DialogCliente(this, true, "Advertencia", "<html>Complete todos los campos<br>con valores mayores a 0</html>");
            dialog.setVisible(true);  
        }
            
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
    public void mouseExited(MouseEvent e) {
      
    }


}
