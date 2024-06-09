/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;


import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
/**
 *Clase encargada de representar la vista que permite al usuario rellenar formulario de viajes y ver el avance del mismo
 **/
public class PanelApp extends VentanaClienteAbstract{

    /**
     * Crea nueva PanelApp
     */
    public PanelApp() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotonesMascota = new javax.swing.ButtonGroup();
        grupoBotonEquipaje = new javax.swing.ButtonGroup();
        grupoBotonesZona = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        ScrollPaneInfoViaje = new javax.swing.JScrollPane();
        textAreaInfoViaje = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        labelCantPasajeros = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        ComboBoxCantPax = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        labelDistancia = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        textDistancia = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        labelFecha = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        selectorFecha = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        labelFecha1 = new javax.swing.JLabel();
        botonSinAsfaltar = new javax.swing.JRadioButton();
        botonPeligrosa = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        botonEstandar = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        labelMascota = new javax.swing.JLabel();
        botonSImascota = new javax.swing.JRadioButton();
        botonNOmascota = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        labelEquipaje = new javax.swing.JLabel();
        botonSIequipaje = new javax.swing.JRadioButton();
        botonNOequipaje = new javax.swing.JRadioButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        botonPagar = new javax.swing.JButton();
        botonPedirViaje = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        setMinimumSize(new java.awt.Dimension(580, 420));
        setPreferredSize(new java.awt.Dimension(580, 420));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        ScrollPaneInfoViaje.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        textAreaInfoViaje.setColumns(20);
        textAreaInfoViaje.setRows(5);
        textAreaInfoViaje.setFocusable(false);
        ScrollPaneInfoViaje.setViewportView(textAreaInfoViaje);

        jPanel2.add(ScrollPaneInfoViaje, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INFORMACION VIAJE");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        add(jPanel2);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(11, 0));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FORMULARIO PEDIDO");
        jPanel4.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel4);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.BorderLayout());

        labelCantPasajeros.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        labelCantPasajeros.setForeground(new java.awt.Color(255, 255, 255));
        labelCantPasajeros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCantPasajeros.setText("Cantidad de pasajeros");
        jPanel18.add(labelCantPasajeros, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel18);

        jPanel16.setOpaque(false);

        ComboBoxCantPax.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBoxCantPax, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ComboBoxCantPax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel16);

        jPanel3.add(jPanel5);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        labelDistancia.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        labelDistancia.setForeground(new java.awt.Color(255, 255, 255));
        labelDistancia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDistancia.setText("Distancia      ");
        labelDistancia.setToolTipText("");
        jPanel6.add(labelDistancia);

        jPanel1.setOpaque(false);

        textDistancia.setMinimumSize(new java.awt.Dimension(65, 22));
        textDistancia.setPreferredSize(new java.awt.Dimension(65, 22));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textDistancia, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        jPanel6.add(jPanel1);

        jPanel3.add(jPanel6);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(1, 2));

        labelFecha.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFecha.setText("Fecha        ");
        jPanel7.add(labelFecha);

        jPanel17.setOpaque(false);

        selectorFecha.setDateFormatString("d/M/yyyy");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(selectorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel17);

        jPanel3.add(jPanel7);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridLayout(1, 3));

        labelFecha1.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        labelFecha1.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFecha1.setText("Zona");
        jPanel8.add(labelFecha1);

        grupoBotonesZona.add(botonSinAsfaltar);
        botonSinAsfaltar.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        botonSinAsfaltar.setForeground(new java.awt.Color(255, 255, 255));
        botonSinAsfaltar.setText("sin asfaltar");
        jPanel8.add(botonSinAsfaltar);

        grupoBotonesZona.add(botonPeligrosa);
        botonPeligrosa.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        botonPeligrosa.setForeground(new java.awt.Color(255, 255, 255));
        botonPeligrosa.setText("peligrosa");
        jPanel8.add(botonPeligrosa);

        jPanel3.add(jPanel8);

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.GridLayout(1, 2));

        jPanel15.setOpaque(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel15);

        grupoBotonesZona.add(botonEstandar);
        botonEstandar.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        botonEstandar.setForeground(new java.awt.Color(255, 255, 255));
        botonEstandar.setSelected(true);
        botonEstandar.setText("estandar");
        jPanel10.add(botonEstandar);

        jPanel3.add(jPanel10);

        jPanel11.setOpaque(false);
        jPanel11.setLayout(new java.awt.GridLayout(1, 3));

        labelMascota.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        labelMascota.setForeground(new java.awt.Color(255, 255, 255));
        labelMascota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMascota.setText("Mascota");
        jPanel11.add(labelMascota);

        grupoBotonesMascota.add(botonSImascota);
        botonSImascota.setFont(new java.awt.Font("Palatino Linotype", 0, 12)); // NOI18N
        botonSImascota.setForeground(new java.awt.Color(255, 255, 255));
        botonSImascota.setText("Si");
        jPanel11.add(botonSImascota);

        grupoBotonesMascota.add(botonNOmascota);
        botonNOmascota.setFont(new java.awt.Font("Palatino Linotype", 0, 12)); // NOI18N
        botonNOmascota.setForeground(new java.awt.Color(255, 255, 255));
        botonNOmascota.setSelected(true);
        botonNOmascota.setText("No");
        jPanel11.add(botonNOmascota);

        jPanel3.add(jPanel11);

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.GridLayout(1, 3));

        labelEquipaje.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        labelEquipaje.setForeground(new java.awt.Color(255, 255, 255));
        labelEquipaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEquipaje.setText("Equipaje");
        jPanel12.add(labelEquipaje);

        grupoBotonEquipaje.add(botonSIequipaje);
        botonSIequipaje.setFont(new java.awt.Font("Palatino Linotype", 0, 12)); // NOI18N
        botonSIequipaje.setForeground(new java.awt.Color(255, 255, 255));
        botonSIequipaje.setText("Si");
        jPanel12.add(botonSIequipaje);

        grupoBotonEquipaje.add(botonNOequipaje);
        botonNOequipaje.setFont(new java.awt.Font("Palatino Linotype", 0, 12)); // NOI18N
        botonNOequipaje.setForeground(new java.awt.Color(255, 255, 255));
        botonNOequipaje.setSelected(true);
        botonNOequipaje.setText("No");
        jPanel12.add(botonNOequipaje);

        jPanel3.add(jPanel12);

        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.GridLayout(1, 2));
        jPanel3.add(jPanel13);

        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.GridLayout(1, 2));
        jPanel3.add(jPanel14);

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.GridLayout(1, 2));

        botonPagar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonPagar.setText("PAGAR");
        botonPagar.setActionCommand("PAGAR VIAJE");
        botonPagar.setEnabled(false);
        jPanel9.add(botonPagar);

        botonPedirViaje.addMouseListener(this);
        botonPedirViaje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonPedirViaje.setText("PEDIR VIAJE");
        botonPedirViaje.setEnabled(false);
        jPanel9.add(botonPedirViaje);

        jPanel3.add(jPanel9);

        add(jPanel3);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxCantPax;
    private javax.swing.JScrollPane ScrollPaneInfoViaje;
    private javax.swing.JRadioButton botonEstandar;
    private javax.swing.JRadioButton botonNOequipaje;
    private javax.swing.JRadioButton botonNOmascota;
    private javax.swing.JButton botonPagar;
    private javax.swing.JButton botonPedirViaje;
    private javax.swing.JRadioButton botonPeligrosa;
    private javax.swing.JRadioButton botonSIequipaje;
    private javax.swing.JRadioButton botonSImascota;
    private javax.swing.JRadioButton botonSinAsfaltar;
    private javax.swing.ButtonGroup grupoBotonEquipaje;
    private javax.swing.ButtonGroup grupoBotonesMascota;
    private javax.swing.ButtonGroup grupoBotonesZona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labelCantPasajeros;
    private javax.swing.JLabel labelDistancia;
    private javax.swing.JLabel labelEquipaje;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelFecha1;
    private javax.swing.JLabel labelMascota;
    private com.toedter.calendar.JDateChooser selectorFecha;
    private javax.swing.JTextArea textAreaInfoViaje;
    private javax.swing.JTextField textDistancia;
    // End of variables declaration//GEN-END:variables

    
    /**
     * Obtiene el boton utilizado para pagar.<br>
	 * <b>POST:</b> Se devuelve el boton de pago.<br>
     * @return  boton de pago
     */
   public JButton getButtonPagar()
    {
        return botonPagar;
    }
    
    /**
     * Obtiene el boton utilizado para pedir viaje.<br>
	 * <b>POST:</b> Se devuelve el boton de pedir viaje.<br>
     * @return  boton de pedir viaje
     */
    public JButton getButtonPedirViaje()
    {
        return botonPedirViaje;
    }

     /**
     * Obtiene la zona seleccionada para el viaje por el usuario.<br>
	 * <b>POST:</b> Se devuelve la zona del proximo viaje.<br>
     * @return la zona del proximo viaje
     */
    @Override
    public String getZona() {
        if(botonPeligrosa.isSelected())
            return "Peligrosa";
        else
            if(botonEstandar.isSelected())
                return "Estandar";
            else
                if(botonSinAsfaltar.isSelected())
                    return "Sin asfaltar";
                else
                    return null;
    }

    /**
     * Informa si el viaje del cliente es con equipaje o no.<br>
	 * <b>POST:</b> Se devuelve la confirmacion de equipaje.<br>
     * @return confirmacion de equipaje
     */
    @Override
    public int getEquipaje() {
        if(botonSIequipaje.isSelected())
            return 1;
        else
            return 0;
    }

    /**
     * Informa si el viaje del cliente es con mascota o no.<br>
	 * <b>POST:</b> Se devuelve la confirmacion de mascota.<br>
     * @return confirmacion de mascota
     */
    @Override
    public int getMascota() {
       if(botonSImascota.isSelected())
            return 1;
        else
            return 0;
    }

    /**
     * Devuelve la cantidad de pasajeros ingresada por el usuario.<br>
	 * <b>POST:</b> Se devuelve  la cantidad de pasajeros del proximo viaje.<br>
     * @return cantidad de pasajeros
     */
    @Override
    public Integer getCantPax() {
        return Integer.parseInt((String)ComboBoxCantPax.getSelectedItem());
    }

    /**
     * Devuelve la fecha  ingresada por el usuario.<br>
	 * <b>POST:</b> Se devuelve  la fecha del proximo viaje.<br>
     * @return fecha del proximo viaje
     */
    @Override
    public LocalDateTime getFecha() {
      Date selectedDate = selectorFecha.getDate();
      if (selectedDate != null) {
        LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime fecha = LocalDateTime.of(localDate, currentTime);
        return fecha;
    } else {
        return null;
    }
    }    

     /**
     * Devuelve  la distancia del proximo viaje ingresada por el usuario.<br>
	 * <b>POST:</b> Se devuelve  la distancia del proximo viaje.<br>
     * @return distancia del proximo viaje, -1 si es invalido
     */
    @Override
    public double getDistancia() {
     String text = textDistancia.getText();
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * Concatena el textarea los eventos que suceden relacionados al estado del viaje en curso
     * @param mensaje descripcion del estado del viaje
     */
    @Override
    public void appendDisplay(String mensaje){
        textAreaInfoViaje.append(mensaje);
    };
    
    /**
     * Habilita el boton de pagar
     * */
     @Override
    public void enablePagar(){
        botonPagar.setEnabled(true);
    };
    
    /**
     * Deshabilita el boton de pagar
     * */
     @Override
    public void disablePagar(){
        botonPagar.setEnabled(false);
    };
    
    /**
     * Habilita el boton de pedir viaje
     * */
      @Override
    public void enablePedirViaje(){
        botonPedirViaje.setEnabled(true);
    };
    
    /**
     * Deshabilita el boton de pedir viaje
     * */
     @Override
    public void disablePedirViaje(){
        botonPedirViaje.setEnabled(false);
    };

    /**
     * Controla la habilitacion del boton de pedir viaje<br>
     * Si la distancia y la fecha son validas, lo habilita<br>
     * Caso contrario avisa al usuario el error
     * @param e 
     */
    @Override
    public void mouseEntered(MouseEvent e) 
    {
    DialogCliente dialog = null;
    double distancia = getDistancia();
    LocalDateTime fecha = getFecha();

    if (distancia > 0 && fecha != null &&  (LocalDateTime.now().isEqual(fecha) || LocalDateTime.now().isBefore(fecha)))
        botonPedirViaje.setEnabled(true);
    else 
    {
        if (distancia <= 0) 
            dialog = new DialogCliente(null, true, "Advertencia", "La distancia debe ser mayor a 0");
         else 
            dialog = new DialogCliente(null, true, "Advertencia", "Seleccione una fecha válida");
        
        dialog.setVisible(true);  
    }
    }
}
 

    
