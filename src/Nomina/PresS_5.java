package Nomina;

import Conexion.ConexionSQL;
import Inicio.Login_2;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JDeat
 */
public final class PresS_5 extends javax.swing.JFrame {

    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion();
    Calendar fecha_actual = new GregorianCalendar();
    double DS, DD, DL, DM, DMi, DJ, DV,
            AS, AD, AL, AM, AMi, AJ, AV;

    public PresS_5() {
        initComponents();

        LabelPrestamos.setVisible(false);
        BE.setVisible(false);
        BE.setText("");
        Busapshpre.setText("");
        Busapshpre.setVisible(false);
        Busamshpre.setText("");
        Busamshpre.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setExtendedState(6);
        LabelFPDP.setVisible(false);
        FilPDPname.setVisible(false);
        FilPDPAp.setVisible(false);
        FilPDPAm.setVisible(false);
        shareprestamo();
        MDP();
        MDTPPres();
        setIconImage(new ImageIcon(PresS_5.class.getClassLoader().getResource("Imagenes/Icono.png")).getImage());

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Prestamos = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        Num = new javax.swing.JTextField();
        Mes = new javax.swing.JComboBox<>();
        Cantidad = new javax.swing.JTextField();
        Interes = new javax.swing.JComboBox<>();
        interes = new javax.swing.JTextField();
        MT = new javax.swing.JTextField();
        Carpeta = new javax.swing.JTextField();
        Status = new javax.swing.JTextField();
        Metodo = new javax.swing.JTextField();
        LabelPrestamos = new javax.swing.JLabel();
        BE = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        share1 = new javax.swing.JTable();
        Zona = new javax.swing.JTextField();
        Serv = new javax.swing.JTextField();
        Agregarprestamo = new javax.swing.JButton();
        modprestamo = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        PS = new javax.swing.JTextField();
        FS = new javax.swing.JTextField();
        FL = new javax.swing.JTextField();
        CS4 = new javax.swing.JButton();
        Busapshpre = new javax.swing.JTextField();
        Filtrosshp = new javax.swing.JComboBox<>();
        Busamshpre = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        Appres = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        Ampres = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        Namepres = new javax.swing.JTextField();
        Pendientepres = new javax.swing.JTextField();
        PagadoPres = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        SPprest = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        Sinteres = new javax.swing.JCheckBox();
        Tprestamos = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        BP = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        Pre = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        CS5 = new javax.swing.JButton();
        botonWeb3 = new botones.BotonWeb();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        botonWeb5 = new botones.BotonWeb();
        FilPDPAm = new javax.swing.JTextField();
        FilPDPAp = new javax.swing.JTextField();
        FilPDPname = new javax.swing.JTextField();
        LabelFPDP = new javax.swing.JLabel();
        FiltrosTPDP = new javax.swing.JComboBox<>();
        jLabel157 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        TPPRES = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        ODT = new javax.swing.JMenuItem();
        CDA = new javax.swing.JMenuItem();
        PRES = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        CNQ = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nomina Semanal");

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        jLabel30.setText("Apellido P:");

        jLabel34.setText("Zona:");

        jLabel35.setText("Servicio:");

        jLabel36.setText("Cantidad:");

        jLabel37.setText("Interes:");

        jLabel38.setText("Monto total:");

        jLabel39.setText("Carpeta:");

        jLabel40.setText("Fecha liberado:");

        jLabel41.setText("Mes:");

        jLabel42.setText("Fecha solicitud");

        jLabel43.setText("# Prestamo");

        jLabel44.setText("Status:");

        jLabel45.setText("Metodo:");

        Num.setText("0");

        Mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        Cantidad.setText("0");

        Interes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "4 Semanas 10%", "5 Semanas 15%", "6 Semanas 15%", "7 Semanas 15%", "8 Semanas 15%", "9 Semanas 20%", "10 Semanas 20%", "11 Semanas 20%", "12 Semanas 20%", "13 Semanas 25%", "14 Semanas 25%", "15 Semanas 25%", "16 Semanas 25%", "17 Semanas 25%", "18 Semanas 25%", "19 Semanas 25%", "20 Semanas 25%" }));
        Interes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                InteresItemStateChanged(evt);
            }
        });

        interes.setText("0");

        MT.setText("0");

        LabelPrestamos.setText("Buscar empleado:");

        BE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BEKeyReleased(evt);
            }
        });

        share1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        share1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                share1MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(share1);

        Agregarprestamo.setText("Agregar");
        Agregarprestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarprestamoActionPerformed(evt);
            }
        });

        modprestamo.setText("Modificar");
        modprestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modprestamoActionPerformed(evt);
            }
        });

        jLabel47.setText("Por semana:");

        PS.setText("0");

        FS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FSActionPerformed(evt);
            }
        });

        CS4.setText("Cerrar sesion");
        CS4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CS4ActionPerformed(evt);
            }
        });

        Busapshpre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BusapshpreKeyReleased(evt);
            }
        });

        Filtrosshp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona filtro", "Apellido P", "Apellido M", "Nombre(s)" }));
        Filtrosshp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FiltrosshpItemStateChanged(evt);
            }
        });

        Busamshpre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BusamshpreKeyReleased(evt);
            }
        });

        jLabel31.setText("Filtros:");

        jLabel33.setText("Apellido M:");

        jLabel46.setText("Nombre(s):");

        Pendientepres.setText("0");

        PagadoPres.setText("0");

        jLabel100.setText("Pendiente:");

        jLabel99.setText("Pagado:");

        SPprest.setText("0");

        jLabel97.setText("Semanas pagadas:");

        jLabel58.setText("Detalles de pagos:");

        Sinteres.setText("Sin interes");
        Sinteres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SinteresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel46)
                    .addComponent(jLabel45)
                    .addComponent(jLabel44)
                    .addComponent(jLabel43)
                    .addComponent(jLabel40)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34)
                    .addComponent(jLabel30)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Namepres, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Num, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(Zona, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(Mes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(Appres, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ampres, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(161, 161, 161)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Filtrosshp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelPrestamos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Busapshpre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Busamshpre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CS4)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(Metodo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(Agregarprestamo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modprestamo))
                            .addComponent(MT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Carpeta, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(FL, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                            .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(Serv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(236, 236, 236)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel99)
                                    .addComponent(jLabel97))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel58)
                                    .addComponent(PagadoPres, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(SPprest, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel100)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Pendientepres, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(Interes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(interes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(PS, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Sinteres)))))
                        .addGap(0, 500, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPrestamos)
                    .addComponent(Busapshpre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Filtrosshp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Busamshpre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(CS4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(FS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(Appres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(Ampres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(Namepres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(Zona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(Serv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel100)
                                .addComponent(Pendientepres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel97)
                                .addComponent(SPprest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(PagadoPres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(Interes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(interes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sinteres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(MT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(Carpeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(FL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(Metodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregarprestamo)
                    .addComponent(modprestamo))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        Prestamos.setViewportView(jPanel5);

        jTabbedPane1.addTab("Prestamos", Prestamos);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        jLabel48.setText("Buscar prestamos:");

        BP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BPKeyReleased(evt);
            }
        });

        Pre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14"
            }
        ));
        Pre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PreMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(Pre);

        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        CS5.setText("Cerrar sesion");
        CS5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CS5ActionPerformed(evt);
            }
        });

        botonWeb3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Microsoft-Excel-Logo.png"))); // NOI18N
        botonWeb3.setLink("http://192.168.3.10/Reportes/ReportesNominaSem/EPCPrestamosSem.php");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 3137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonWeb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CS5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(BP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(CS5)
                    .addComponent(botonWeb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addGap(55, 55, 55))
        );

        Tprestamos.setViewportView(jPanel6);

        jTabbedPane1.addTab("Tabla prestamos", Tprestamos);

        botonWeb5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Microsoft-Excel-Logo.png"))); // NOI18N
        botonWeb5.setToolTipText("");
        botonWeb5.setLink("http://192.168.3.10/Reportes/ReportesNominaSem/EPCPagosPrestamosSem.php");

        FilPDPAm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FilPDPAmKeyReleased(evt);
            }
        });

        FilPDPAp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FilPDPApKeyReleased(evt);
            }
        });

        FilPDPname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FilPDPnameKeyReleased(evt);
            }
        });

        LabelFPDP.setText("jLabel158");

        FiltrosTPDP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona filtro", "Apellido P", "Apellido M", "Nombre(s)" }));
        FiltrosTPDP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FiltrosTPDPItemStateChanged(evt);
            }
        });

        jLabel157.setText("Filtros:");

        TPPRES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(TPPRES);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel157)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FiltrosTPDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelFPDP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FilPDPname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FilPDPAp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FilPDPAm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonWeb5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 825, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel157)
                        .addComponent(FiltrosTPDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelFPDP)
                        .addComponent(FilPDPname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FilPDPAp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FilPDPAm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonWeb5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane7.setViewportView(jPanel7);

        jTabbedPane1.addTab("Tabla pagos prestamos", jScrollPane7);

        jMenu1.setText("Cambiar a:");

        jMenu2.setText("Nomina quincenal");

        ODT.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ODT.setText("Ordenes de taller");
        ODT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ODTActionPerformed(evt);
            }
        });
        jMenu2.add(ODT);

        CDA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CDA.setText("Caja de ahorro");
        CDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDAActionPerformed(evt);
            }
        });
        jMenu2.add(CDA);

        PRES.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        PRES.setText("Prestamos");
        PRES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRESActionPerformed(evt);
            }
        });
        jMenu2.add(PRES);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem2.setText("Nomina General");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        CNQ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CNQ.setText("Nomina IMSS");
        CNQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNQActionPerformed(evt);
            }
        });
        jMenu2.add(CNQ);

        jMenu1.add(jMenu2);

        jMenu3.setText("Semanal");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem1.setText("Nomina Semanal");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem3.setText("Prestamos Semanales");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void IOMTPres() {
        double inter = 0, Sem = 0;

        String dt = (String) Interes.getSelectedItem();
        if (dt.equals(".")) {
            inter = 0;
            Sem = 0;
        }
        if (dt.equals("4 Semanas 10%")) {
            inter = 10;
            Sem = 4;
        }
        if (dt.equals("5 Semanas 15%")) {
            inter = 15;
            Sem = 5;
        }
        if (dt.equals("6 Semanas 15%")) {
            inter = 15;
            Sem = 6;
        }
        if (dt.equals("7 Semanas 15%")) {
            inter = 15;
            Sem = 7;
        }
        if (dt.equals("8 Semanas 15%")) {
            inter = 15;
            Sem = 8;
        }
        if (dt.equals("9 Semanas 20%")) {
            inter = 20;
            Sem = 9;
        }
        if (dt.equals("10 Semanas 20%")) {
            inter = 20;
            Sem = 10;
        }
        if (dt.equals("11 Semanas 20%")) {
            inter = 15;
            Sem = 11;
        }
        if (dt.equals("12 Semanas 20%")) {
            inter = 20;
            Sem = 12;
        }
        if (dt.equals("13 Semanas 25%")) {
            inter = 25;
            Sem = 13;
        }
        if (dt.equals("14 Semanas 25%")) {
            inter = 25;
            Sem = 14;
        }
        if (dt.equals("15 Semanas 25%")) {
            inter = 25;
            Sem = 15;
        }
        if (dt.equals("16 Semanas 25%")) {
            inter = 25;
            Sem = 16;
        }
        if (dt.equals("17 Semanas 25%")) {
            inter = 25;
            Sem = 17;
        }
        if (dt.equals("18 Semanas 25%")) {
            inter = 25;
            Sem = 18;
        }
        if (dt.equals("19 Semanas 25%")) {
            inter = 25;
            Sem = 19;
        }
        if (dt.equals("20 Semanas 25%")) {
            inter = 25;
            Sem = 20;
        }
        if (Sinteres.isSelected() == true) {
            inter = 0;
        }

        //operacion interes
        double CAN = Double.parseDouble(this.Cantidad.getText());
        double total = (inter * CAN) / 100;
        this.interes.setText("" + total + "");
        //operacion por semanas

        double d6 = Double.parseDouble(this.MT.getText());
        double totalPS = d6 / Sem;
        this.PS.setText("" + totalPS + "");
//monto total
        double d1 = Double.parseDouble(this.Cantidad.getText());
        double d2 = Double.parseDouble(this.interes.getText());
        double MTo = (d1 + d2);
        this.MT.setText("" + MTo + "");;
    }

    public void MDTPPres() {
        String FiltroN = FilPDPname.getText();
        String FAP = FilPDPAp.getText();
        String FAM = FilPDPAm.getText();
        String where = "SELECT * FROM `nomina.pagos.prestamosem`";

        if (!"".equals(FiltroN)) {
            where = "SELECT * FROM `nomina.pagos.prestamosem`"
                    + " where `Nombre(s)` LIKE '%" + FiltroN + "%'";
        } else if (!"".equals(FAP)) {
            where = "SELECT * FROM `nomina.pagos.prestamosem`"
                    + " Where `Apellido P` LIKE '%" + FAP + "%'";
        } else if (!"".equals(FAM)) {
            where = "SELECT * FROM `nomina.pagos.prestamosem`"
                    + " Where `Apellido M` LIKE '%" + FAM + "%'";
        }

        try {
            //Cargar datos
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columna) {
                    return false;
                }

            };
//Nombre de la tabla
            TPPRES.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(where);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Folio");
            modelo.addColumn("# Lista");
            modelo.addColumn("# de prestamo");//2
            modelo.addColumn("# Empleado");
            modelo.addColumn("Apellido P");//4
            modelo.addColumn("Apellido M");
            modelo.addColumn("Nombre(s)");//6
            modelo.addColumn("Zona");
            modelo.addColumn("Servicio");//8
            modelo.addColumn("Semana");
            modelo.addColumn("# Semana");//10
            modelo.addColumn("Pagado");
            modelo.addColumn("Pendiente");//12
            modelo.addColumn("Pago de prestamo");

//ANCHOS
            int[] anchos = {50, /*NL*/ 50, /*NF*/ 50,/*NE*/ 50, /*AP*/ 60, /*AM*/ 60, /*NAME*/ 50, /*ZON*/ 50,
                /*SERV*/ 50, /*SEM*/ 60, /*NS*/ 50, /*PAG*/ 60, /*PEN*/ 60,/*PDPres*/ 60};

            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                TPPRES.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException error_mpdp) {
            JOptionPane.showMessageDialog(null, "Error al mostrar pagos de Prestamos: " + error_mpdp.getMessage());

        }

    }

    public void eliminarpre() {

        try {

            int filaseleccionada = Pre.getSelectedRow();
            String sql = "delete from prestamosem where idprestamos=" + Pre.getValueAt(filaseleccionada, 0);
            java.sql.Statement st = con.createStatement();
            int n = st.executeUpdate(sql);
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Prestamo eliminado.");
            }
        } catch (HeadlessException | SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al eliminar prestamo: " + e.getMessage());

        }

    }

    public void editarpre() {

        int id = Integer.parseInt(Num.getText());

        String SQL = "UPDATE `prestamosem` SET `idprestamos` = ?, `Fecha de solicitud` = ?,"
                + " `Mes` = ?, `Apellido P` = ?, `Apellido M` = ?, `Nombre(s)` = ?,"
                + " `Zona` = ?, `Servicio` = ?, `Cantidad` = ?, `Tiempo` = ?, `Interes` = ?,"
                + " `Monto total` = ?, `Por semana` = ?, `Carpeta de descuentos` = ?,"
                + " `Fecha liberado` = ?, `Status` = ?, `Metodo` = ?, `Semanaspagadas` = ?,"
                + " `Pendiente` = ?, `Pagado` = ? WHERE `prestamosem`.`idprestamos` = ?";

        try {
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, id);
            pst.setString(2, FS.getText());
            pst.setString(3, Mes.getSelectedItem().toString());
            pst.setString(4, Appres.getText());
            pst.setString(5, Ampres.getText());
            pst.setString(6, Namepres.getText());
            pst.setString(7, Zona.getText());
            pst.setString(8, Serv.getText());
            pst.setString(9, Cantidad.getText());
            pst.setString(10, Interes.getSelectedItem().toString());
            pst.setString(11, interes.getText());
            pst.setString(12, MT.getText());
            pst.setString(13, PS.getText());
            pst.setString(14, Carpeta.getText());
            pst.setString(15, FL.getText());
            pst.setString(16, Status.getText());
            pst.setString(17, Metodo.getText());
            pst.setString(18, SPprest.getText());
            pst.setString(19, Pendientepres.getText());
            pst.setString(20, PagadoPres.getText());
            pst.setInt(21, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Prestamo Modificado");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar Prestamo: " + e.getMessage());
        }
    }

    public void limpiarP() {
        Pendientepres.setText("0");
        PagadoPres.setText("0");
        SPprest.setText("0");
        Num.setText("0");
        FS.setText("");
        Namepres.setText("");
        Appres.setText("");
        Ampres.setText("");
        Zona.setText("");
        Serv.setText("");
        Cantidad.setText("0");
        interes.setText("0");
        Interes.setSelectedIndex(0);
        Mes.setSelectedIndex(0);
        PS.setText("0");
        MT.setText("0");
        Carpeta.setText("");
        FL.setText("");
        Status.setText("");
        Metodo.setText("");

    }

    //mostrar datos prestamos
    public void MDP() {
        //Buscar empleado
        String Share = BP.getText();
        /*String ShareAP = BAPNom.getText();
        String ShareAM = BAMNom.getText();*/
        String where = "select * from `nominasem.prestamosem`";

        if (!"".equals(Share)) {
            where = " select * from `nominasem.prestamosem` WHERE `Nombre(s)` LIKE '%" + Share + "%'";
        }
        /*else if (!"".equals(ShareAP)) {
            where = " select * from `nominasem.prestamosem` WHERE `Apellido P` LIKE '%" + ShareAP + "%'";
        } else if (!"".equals(ShareAM)) {
            where = " select * from `nominasem.prestamosem` WHERE `Apellido M` LIKE '%" + ShareAM + "%'";
        }*/

        try {
            //Cargar datos
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columna) {
                    return false;
                }

            };
//Nombre de la tabla
            Pre.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(where);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# de prestamo");//1
            modelo.addColumn("Fecha de solicitud");//
            modelo.addColumn("Mes");//3
            modelo.addColumn("Apellido P");
            modelo.addColumn("Apellido M");//5
            modelo.addColumn("Nombre(s)");
            modelo.addColumn("Zona");//7
            modelo.addColumn("Servicio");
            modelo.addColumn("Cantidad");//9
            modelo.addColumn("Tiempo");
            modelo.addColumn("Interes");
            modelo.addColumn("Monto total");//12
            modelo.addColumn("Pago por Semana");
            modelo.addColumn("Carpeta de descuentos");//14
            modelo.addColumn("Fecha liberado");
            modelo.addColumn("Status");//16
            modelo.addColumn("Metodo");
            modelo.addColumn("# de semanas");//18
            modelo.addColumn("Pendiente");
            modelo.addColumn("Pagado");//20

//Anchos
            int[] anchos = {/*ndp*/35, /*fds*/ 50, /*mes*/ 45, /*ap*/ 55, /*am*/ 55,
                /*Nom*/ 125, /*zon*/ 65, /*Serv*/ 80, /*Cantidad*/ 55,/*tiempo*/ 60, /*inte*/ 50,
                /*MT*/ 55, /*PQ*/ 75, /*CDD*/ 250, /*FL*/ 55, /*STATUS*/ 70, /*METODO*/ 60,
                /*NDS*/ 60, /*Pen*/ 60, /*pag*/ 60};

            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                Pre.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos de prestamos: " + e.getMessage());

        }
    }

    public void AgregarPre() {

        String SQL = "INSERT INTO `prestamosem` (`idprestamos`, `Fecha de solicitud`,"
                + " `Mes`, `Apellido P`, `Apellido M`, `Nombre(s)`, `Zona`, `Servicio`,"
                + " `Cantidad`, `Tiempo`, `Interes`, `Monto total`, `Por semana`,"
                + " `Carpeta de descuentos`, `Fecha liberado`, `Status`, `Metodo`,"
                + " `Semanaspagadas`, `Pendiente`, `Pagado`) VALUES (?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setInt(1, Integer.parseInt(Num.getText()));
            pst.setString(2, FS.getText());
            pst.setString(3, Mes.getSelectedItem().toString());
            pst.setString(4, Appres.getText());
            pst.setString(5, Ampres.getText());
            pst.setString(6, Namepres.getText());
            pst.setString(7, Zona.getText());
            pst.setString(8, Serv.getText());
            pst.setString(9, Cantidad.getText());
            pst.setString(10, Interes.getSelectedItem().toString());
            pst.setString(11, interes.getText());
            pst.setString(12, MT.getText());
            pst.setString(13, PS.getText());
            pst.setString(14, Carpeta.getText());
            pst.setString(15, FL.getText());
            pst.setString(16, Status.getText());
            pst.setString(17, Metodo.getText());
            pst.setString(18, SPprest.getText());
            pst.setString(19, Pendientepres.getText());
            pst.setString(20, PagadoPres.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Prestamo Agregado");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar prestamo: " + e.getMessage());
        }
    }

    public void shareprestamo() {
        //Buscar empleado
        String Share = BE.getText();
        String ShareAP = Busapshpre.getText();
        String ShareAM = Busamshpre.getText();
        String where = "select `id_bd`, `Apellido P`, `Apellido M`, `Nombre(s)`, `Banco`, `Cuenta banco`, `Zona`, `Servicio`, `Sueldo`, `Bono`"
                + " from empleados  where `Status` LIKE '%Vigente%'";

        if (!"".equals(Share)) {
            where = " select `id_bd`, `Apellido P`, `Apellido M`, `Nombre(s)`, `Banco`, `Cuenta banco`, `Zona`, `Servicio`, `Sueldo`, `Bono` "
                    + "from empleados WHERE `Nombre(s)` LIKE '%" + Share + "%' AND `Status` LIKE '%Vigente%'";
        } else if (!"".equals(ShareAP)) {
            where = " select `id_bd`, `Apellido P`, `Apellido M`, `Nombre(s)`, `Banco`, `Cuenta banco`, `Zona`, `Servicio`, `Sueldo`, `Bono` "
                    + "from empleados WHERE `Apellido P` LIKE '%" + ShareAP + "%' AND `Status` LIKE '%Vigente%'";
        } else if (!"".equals(ShareAM)) {
            where = " select `id_bd`, `Apellido P`, `Apellido M`, `Nombre(s)`, `Banco`, `Cuenta banco`, `Zona`, `Servicio`, `Sueldo`, `Bono` "
                    + "from empleados WHERE `Apellido M` LIKE '%" + ShareAM + "%' AND `Status` LIKE '%Vigente%'";
        }

        try {
            //Cargar datos
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columna) {
                    return false;
                }

            };
//Nombre de la tabla
            share1.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(where);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Empleado");
            modelo.addColumn("Apellido P");//1
            modelo.addColumn("Apellido M");//
            modelo.addColumn("Nombre(s)");//3
            modelo.addColumn("Banco");//7
            modelo.addColumn("Cuenta de banco");
            modelo.addColumn("Zona");
            modelo.addColumn("Servicio");//5
            modelo.addColumn("Sueldo");
            modelo.addColumn("Bono");

//Anchos
            int[] anchos = {/*numE*/35, /*AP*/ 50, /*AM*/ 50, /*NAME*/ 150, /*Banco*/ 75, /*CTA*/ 50, /*zona*/ 60,
                /*servicio*/ 100, /*sueldo*/ 60, /*bono*/ 40};

            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                share1.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al compartir datos con prestamos: " + e.getMessage());

        }

    }


    private void InteresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_InteresItemStateChanged
        IOMTPres();
    }//GEN-LAST:event_InteresItemStateChanged

    private void BEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BEKeyReleased

        shareprestamo();
    }//GEN-LAST:event_BEKeyReleased

    private void share1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_share1MouseClicked

        int seleccionar = share1.getSelectedRow();
        Appres.setText(String.valueOf(share1.getValueAt(seleccionar, 0)));
        Ampres.setText(String.valueOf(share1.getValueAt(seleccionar, 1)));
        Namepres.setText(String.valueOf(share1.getValueAt(seleccionar, 2)));
        Zona.setText(String.valueOf(share1.getValueAt(seleccionar, 3)));
        Serv.setText(String.valueOf(share1.getValueAt(seleccionar, 4)));
    }//GEN-LAST:event_share1MouseClicked

    private void AgregarprestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarprestamoActionPerformed

        AgregarPre();
        MDP();
        limpiarP();
    }//GEN-LAST:event_AgregarprestamoActionPerformed

    private void modprestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modprestamoActionPerformed

        editarpre();
        MDP();
        limpiarP();
    }//GEN-LAST:event_modprestamoActionPerformed

    private void FSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FSActionPerformed

    }//GEN-LAST:event_FSActionPerformed

    private void CS4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CS4ActionPerformed

        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres cerrar la sesion?");
        if (i == 0) {
            Login_2 regr = new Login_2();
            regr.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_CS4ActionPerformed

    private void BusapshpreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BusapshpreKeyReleased

        shareprestamo();
    }//GEN-LAST:event_BusapshpreKeyReleased

    private void FiltrosshpItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FiltrosshpItemStateChanged

        String dt = (String) Filtrosshp.getSelectedItem();
        if (dt.equals("Selecciona filtro")) {
            LabelPrestamos.setVisible(false);
            BE.setVisible(false);
            BE.setText("");
            Busapshpre.setText("");
            Busapshpre.setVisible(false);
            Busamshpre.setText("");
            Busamshpre.setVisible(false);
            shareprestamo();
        }
        if (dt.equals("Apellido P")) {
            LabelPrestamos.setVisible(true);
            LabelPrestamos.setText("Buscar por Apellido P:");
            BE.setVisible(false);
            BE.setText("");
            Busapshpre.setText("");
            Busapshpre.setVisible(true);
            Busamshpre.setText("");
            Busamshpre.setVisible(false);
            shareprestamo();
        }
        if (dt.equals("Apellido M")) {
            LabelPrestamos.setVisible(true);
            LabelPrestamos.setText("Buscar por Apellido M:");
            BE.setVisible(false);
            BE.setText("");
            Busapshpre.setText("");
            Busapshpre.setVisible(false);
            Busamshpre.setText("");
            Busamshpre.setVisible(true);
            shareprestamo();
        }
        if (dt.equals("Nombre(s)")) {
            LabelPrestamos.setVisible(true);
            LabelPrestamos.setText("Buscar por Nombre(s):");
            BE.setVisible(true);
            BE.setText("");
            Busapshpre.setText("");
            Busapshpre.setVisible(false);
            Busamshpre.setText("");
            Busamshpre.setVisible(false);
            shareprestamo();

        }
    }//GEN-LAST:event_FiltrosshpItemStateChanged

    private void BusamshpreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BusamshpreKeyReleased

        shareprestamo();
    }//GEN-LAST:event_BusamshpreKeyReleased

    private void BPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BPKeyReleased

        MDP();
    }//GEN-LAST:event_BPKeyReleased

    private void PreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PreMouseClicked

        DefaultTableModel model = (DefaultTableModel) Pre.getModel();
        int seleccionar = Pre.getSelectedRow();
        try {

            Num.setText(String.valueOf(Pre.getValueAt(seleccionar, 0)));
            FS.setText(String.valueOf(Pre.getValueAt(seleccionar, 1)));
            String combo1 = model.getValueAt(seleccionar, 2).toString();
            for (int i = 0; i < Mes.getItemCount(); i++) {
                if (Mes.getItemAt(i).equalsIgnoreCase(combo1)) {
                    Mes.setSelectedIndex(i);
                }
            }
            Appres.setText(String.valueOf(Pre.getValueAt(seleccionar, 3)));
            Ampres.setText(String.valueOf(Pre.getValueAt(seleccionar, 4)));
            Namepres.setText(String.valueOf(Pre.getValueAt(seleccionar, 5)));
            Zona.setText(String.valueOf(Pre.getValueAt(seleccionar, 6)));
            Serv.setText(String.valueOf(Pre.getValueAt(seleccionar, 7)));
            Cantidad.setText(String.valueOf(Pre.getValueAt(seleccionar, 8)));
            String combo2 = model.getValueAt(seleccionar, 9).toString();
            for (int i = 0; i < Interes.getItemCount(); i++) {
                if (Interes.getItemAt(i).equalsIgnoreCase(combo2)) {
                    Interes.setSelectedIndex(i);
                }
            }
            interes.setText(String.valueOf(Pre.getValueAt(seleccionar, 10)));
            MT.setText(String.valueOf(Pre.getValueAt(seleccionar, 11)));
            PS.setText(String.valueOf(Pre.getValueAt(seleccionar, 12)));
            Carpeta.setText(String.valueOf(Pre.getValueAt(seleccionar, 13)));
            FL.setText(String.valueOf(Pre.getValueAt(seleccionar, 14)));
            Status.setText(String.valueOf(Pre.getValueAt(seleccionar, 15)));
            Metodo.setText(String.valueOf(Pre.getValueAt(seleccionar, 16)));
            SPprest.setText(String.valueOf(Pre.getValueAt(seleccionar, 17)));
            Pendientepres.setText(String.valueOf(Pre.getValueAt(seleccionar, 18)));
            PagadoPres.setText(String.valueOf(Pre.getValueAt(seleccionar, 19)));
            int id = Integer.parseInt(Pre.getValueAt(seleccionar, 0).toString());
            String Otrointeres = interes.getText();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("select * from prestamosem where idprestamos =?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            java.sql.Statement st = con.createStatement();
            while (rs.next()) {
                if (rs.getString("Interes").equals("0.0")) {
                    Sinteres.setSelected(true);

                } else if (rs.getString("Interes").equals(Otrointeres)) {
                    Sinteres.setSelected(false);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }

    }//GEN-LAST:event_PreMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        eliminarpre();
        MDP();
        limpiarP();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void CS5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CS5ActionPerformed

        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres cerrar la sesion?");
        if (i == 0) {
            Login_2 regr = new Login_2();
            regr.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_CS5ActionPerformed

    private void FilPDPAmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilPDPAmKeyReleased
        MDTPPres();
    }//GEN-LAST:event_FilPDPAmKeyReleased

    private void FilPDPApKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilPDPApKeyReleased
        MDTPPres();
    }//GEN-LAST:event_FilPDPApKeyReleased

    private void FilPDPnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilPDPnameKeyReleased
        MDTPPres();
    }//GEN-LAST:event_FilPDPnameKeyReleased

    private void FiltrosTPDPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FiltrosTPDPItemStateChanged
        String FTP = (String) FiltrosTPDP.getSelectedItem();
        if (FTP.equals("Selecciona filtro")) {
            LabelFPDP.setVisible(false);
            FilPDPname.setVisible(false);
            FilPDPname.setText("");
            FilPDPAp.setText("");
            FilPDPAp.setVisible(false);
            FilPDPAm.setText("");
            FilPDPAm.setVisible(false);
            MDTPPres();
        }
        if (FTP.equals("Apellido P")) {
            LabelFPDP.setVisible(true);
            LabelFPDP.setText("Buscar por Apellido P:");
            FilPDPname.setVisible(false);
            FilPDPname.setText("");
            FilPDPAp.setText("");
            FilPDPAp.setVisible(true);
            FilPDPAm.setText("");
            FilPDPAm.setVisible(false);
            MDTPPres();
        }
        if (FTP.equals("Apellido M")) {
            LabelFPDP.setVisible(true);
            LabelFPDP.setText("Buscar por Apellido M:");
            FilPDPname.setVisible(false);
            FilPDPname.setText("");
            FilPDPAp.setText("");
            FilPDPAp.setVisible(false);
            FilPDPAm.setText("");
            FilPDPAm.setVisible(true);
            MDTPPres();
        }
        if (FTP.equals("Nombre(s)")) {
            LabelFPDP.setVisible(true);
            LabelFPDP.setText("Buscar por Nombre(s):");
            FilPDPname.setVisible(true);
            FilPDPname.setText("");
            FilPDPAp.setText("");
            FilPDPAp.setVisible(false);
            FilPDPAm.setText("");
            FilPDPAm.setVisible(false);
            MDTPPres();

        }
    }//GEN-LAST:event_FiltrosTPDPItemStateChanged

    private void SinteresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SinteresActionPerformed
        IOMTPres();

    }//GEN-LAST:event_SinteresActionPerformed

    private void ODTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ODTActionPerformed
        ODTQ_5 regr = new ODTQ_5();
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ODTActionPerformed

    private void CDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDAActionPerformed
        CDAQ_5 regr = new CDAQ_5();
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CDAActionPerformed

    private void PRESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRESActionPerformed
        PresQ_5 regr = new PresQ_5();
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PRESActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        NominaQSiMSS_5 regr = new NominaQSiMSS_5();
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void CNQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNQActionPerformed
        NominaQ_5 regr = new NominaQ_5();
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CNQActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        NominaS_5 regr = new NominaS_5();
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        PresS_5 regr = new PresS_5();
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(PresS_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PresS_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PresS_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PresS_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PresS_5().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregarprestamo;
    private javax.swing.JTextField Ampres;
    private javax.swing.JTextField Appres;
    private javax.swing.JTextField BE;
    private javax.swing.JTextField BP;
    private javax.swing.JTextField Busamshpre;
    private javax.swing.JTextField Busapshpre;
    private javax.swing.JMenuItem CDA;
    private javax.swing.JMenuItem CNQ;
    private javax.swing.JButton CS4;
    private javax.swing.JButton CS5;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JTextField Carpeta;
    private javax.swing.JTextField FL;
    private javax.swing.JTextField FS;
    private javax.swing.JTextField FilPDPAm;
    private javax.swing.JTextField FilPDPAp;
    private javax.swing.JTextField FilPDPname;
    private javax.swing.JComboBox<String> FiltrosTPDP;
    private javax.swing.JComboBox<String> Filtrosshp;
    private javax.swing.JComboBox<String> Interes;
    private javax.swing.JLabel LabelFPDP;
    private javax.swing.JLabel LabelPrestamos;
    private javax.swing.JTextField MT;
    private javax.swing.JComboBox<String> Mes;
    private javax.swing.JTextField Metodo;
    private javax.swing.JTextField Namepres;
    private javax.swing.JTextField Num;
    private javax.swing.JMenuItem ODT;
    private javax.swing.JMenuItem PRES;
    private javax.swing.JTextField PS;
    private javax.swing.JTextField PagadoPres;
    private javax.swing.JTextField Pendientepres;
    private javax.swing.JTable Pre;
    private javax.swing.JScrollPane Prestamos;
    private javax.swing.JTextField SPprest;
    private javax.swing.JTextField Serv;
    private javax.swing.JCheckBox Sinteres;
    private javax.swing.JTextField Status;
    private javax.swing.JTable TPPRES;
    private javax.swing.JScrollPane Tprestamos;
    private javax.swing.JTextField Zona;
    private botones.BotonWeb botonWeb3;
    private botones.BotonWeb botonWeb5;
    private javax.swing.JTextField interes;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton modprestamo;
    private javax.swing.JTable share1;
    // End of variables declaration//GEN-END:variables
}