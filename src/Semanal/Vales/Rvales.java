package Semanal.Vales;

import Conexion.ConexionSQL;
import Logicas.Logica_permisos;
import Logicas.Logica_usuarios;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.PaperSize;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author JDeat
 */
public final class Rvales extends javax.swing.JFrame implements Printable {

    int xMouse, yMouse;
    Logica_usuarios usr;
    Logica_permisos LP;
    Calendar fecha_actual = new GregorianCalendar();
    private final String[] UNIDADES = {"", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
    private final String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
        "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ",
        "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
    private final String[] CENTENAS = {"", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
        "setecientos ", "ochocientos ", "novecientos "};
    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion();
    double BM = 1000, BQ = 500, BD = 200, BC = 100, BCIN = 50, BV = 20,
            MV = 20, MD = 10, MC = 5, MDOS = 2, MU = 1, MCENT = 0.50;

    public Rvales() {
        initComponents();
        Fecha.setCalendar(fecha_actual);
        Fecha1.setCalendar(fecha_actual);
        this.setLocationRelativeTo(null);
        MDVales();
    }

    public Rvales(Logica_usuarios usr, Logica_permisos LP) {
        initComponents();
        Fecha.setCalendar(fecha_actual);
        Fecha1.setCalendar(fecha_actual);
        this.usr = usr;
        this.LP = LP;
        this.setLocationRelativeTo(null);
        MDVales();
    }

    public void TDEN() {
        double TDen;
        TDen = Double.parseDouble(SB1000.getText()) + Double.parseDouble(SB500.getText()) + Double.parseDouble(SB200.getText())
                + Double.parseDouble(SB100.getText()) + Double.parseDouble(SB50.getText()) + Double.parseDouble(SB20.getText())
                + Double.parseDouble(SM20.getText()) + Double.parseDouble(SM10.getText()) + Double.parseDouble(SM5.getText())
                + Double.parseDouble(SM2.getText()) + Double.parseDouble(SM1.getText()) + Double.parseDouble(SM050.getText());
        DecimalFormat dDeposito = new DecimalFormat("#.00");
        TR.setText(dDeposito.format(TDen));
    }

    public void MDVales() {
        String Statusimss = NVSearch.getText();
        String sql = "SELECT `#vale`, `buenopor`, `Recibi de`, `Concepto`, `en`, `fecha`, `BPescrito` FROM `semanal.vales`";

        if (!"".equals(Statusimss)) {
            sql = " SELECT `#vale`, `buenopor`, `Recibi de`, `Concepto`, `en`, `fecha`, `BPescrito` FROM `semanal.vales` WHERE `#vale` LIKE '%" + Statusimss + "%'";
        }
        try {
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columna) {
                    return false;
                }
            };
//nombre tabla
            Tvales.setModel(modelo);

            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Vale");
            modelo.addColumn("Bueno por");
            modelo.addColumn("Recibi de");
            modelo.addColumn("Concepto");
            modelo.addColumn("En");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cantidad escrita");

//Anchos
            int[] anchos = {30, 30, 50, 100, 100, 30, 60, 100};

            for (int x = 0; x < cantidadColumnas; x++) {
                //nombre tabla
                Tvales.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Datos de servicios de inturbide: \n" + e.getMessage());

        }
    }

    public String Convertir(String numero, boolean mayusculas) {
        String literal = "";
        String parte_decimal;
        //si el numero utiliza (.) en lugar de (,) -> se reemplaza
        numero = numero.replace(".", ",");
        //si el numero no tiene parte decimal, se le agrega ,00
        if (!numero.contains(",")) {
            numero = numero + ",00";
        }
        //se valida formato de entrada -> 0,00 y 999 999 999,00
        if (Pattern.matches("\\d{1,9},\\d{1,2}", numero)) {
            //se divide el numero 0000000,00 -> entero y decimal
            String Num[] = numero.split(",");
            //de da formato al numero decimal
            parte_decimal = ", " + Num[1] + "¢ Pesos";
            //se convierte el numero a literal
            if (Integer.parseInt(Num[0]) == 0) {//si el valor es cero
                literal = "cero ";
            } else if (Integer.parseInt(Num[0]) > 999999) {//si es millon
                literal = getMillones(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 999) {//si es miles
                literal = getMiles(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 99) {//si es centena
                literal = getCentenas(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 9) {//si es decena
                literal = getDecenas(Num[0]);
            } else {//sino unidades -> 9
                literal = getUnidades(Num[0]);
            }
            //devuelve el resultado en mayusculas o minusculas
            if (mayusculas) {
                return (literal + parte_decimal).toUpperCase();
            } else {
                return (literal + parte_decimal);
            }
        } else {//error, no se puede convertir
            return literal = null;
        }
    }

    /* funciones para convertir los numeros a literales */
    private String getUnidades(String numero) {// 1 - 9
        //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
        String num = numero.substring(numero.length() - 1);
        return UNIDADES[Integer.parseInt(num)];
    }

    private String getDecenas(String num) {// 99                        
        int n = Integer.parseInt(num);
        if (n < 10) {//para casos como -> 01 - 09
            return getUnidades(num);
        } else if (n > 19) {//para 20...99
            String u = getUnidades(num);
            if (u.equals("")) { //para 20,30,40,50,60,70,80,90
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
            } else {
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
            }
        } else {//numeros entre 11 y 19
            return DECENAS[n - 10];
        }
    }

    private String getCentenas(String num) {// 999 o 099
        if (Integer.parseInt(num) > 99) {//es centena
            if (Integer.parseInt(num) == 100) {//caso especial
                return " cien ";
            } else {
                return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
            }
        } else {//por Ej. 099 
            //se quita el 0 antes de convertir a decenas
            return getDecenas(Integer.parseInt(num) + "");
        }
    }

    private String getMiles(String numero) {// 999 999
        //obtiene las centenas
        String c = numero.substring(numero.length() - 3);
        //obtiene los miles
        String m = numero.substring(0, numero.length() - 3);
        String n = "";
        //se comprueba que miles tenga valor entero
        if (Integer.parseInt(m) > 0) {
            n = getCentenas(m);
            return n + "mil " + getCentenas(c);
        } else {
            return "" + getCentenas(c);
        }

    }

    private String getMillones(String numero) { //000 000 000        
        //se obtiene los miles
        String miles = numero.substring(numero.length() - 6);
        //se obtiene los millones
        String millon = numero.substring(0, numero.length() - 6);
        String n = "";
        if (millon.length() > 1) {
            n = getCentenas(millon) + "millones ";
        } else {
            n = getUnidades(millon) + "millon ";
        }
        return n + getMiles(miles);
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) graphics;
        //Punto donde empezará a imprimir dentro la pagina (100, 50)
        g2d.translate(pageFormat.getImageableX(),
                pageFormat.getImageableY());
        g2d.scale(0.50, 0.50); //Reducción de la impresión al 50%
        jPanel1.printAll(graphics);
        return PAGE_EXISTS;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngen = new javax.swing.JPanel();
        txtbtngen = new javax.swing.JLabel();
        Harder1 = new javax.swing.JPanel();
        Move = new javax.swing.JLabel();
        btnexit = new javax.swing.JPanel();
        txtbtnexit = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tvales = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        NVSearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Importe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        RD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Concepto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        En = new javax.swing.JTextField();
        Fecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        ImporteEsc = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        NV1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Importe1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        RD1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Concepto1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        En1 = new javax.swing.JTextField();
        Fecha1 = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        ImporteEsc1 = new javax.swing.JTextArea();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        Rec1 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        Entr1 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel48 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        B1000 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        B500 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        B200 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        B100 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        B50 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        B20 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        M1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        M10 = new javax.swing.JTextField();
        M050 = new javax.swing.JTextField();
        M20 = new javax.swing.JTextField();
        M2 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        M5 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        SB1000 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        SB500 = new javax.swing.JTextField();
        SB200 = new javax.swing.JTextField();
        SB100 = new javax.swing.JTextField();
        SB50 = new javax.swing.JTextField();
        SB20 = new javax.swing.JTextField();
        SM20 = new javax.swing.JTextField();
        SM10 = new javax.swing.JTextField();
        SM5 = new javax.swing.JTextField();
        SM2 = new javax.swing.JTextField();
        SM1 = new javax.swing.JTextField();
        SM050 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        TR = new javax.swing.JLabel();
        Rec = new javax.swing.JLabel();
        Entr = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btngen.setBackground(new java.awt.Color(255, 255, 255));

        txtbtngen.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txtbtngen.setForeground(new java.awt.Color(0, 0, 0));
        txtbtngen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtbtngen.setText("Reimprimir vale.");
        txtbtngen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtbtngen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtbtngenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtbtngenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtbtngenMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btngenLayout = new javax.swing.GroupLayout(btngen);
        btngen.setLayout(btngenLayout);
        btngenLayout.setHorizontalGroup(
            btngenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtbtngen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE)
        );
        btngenLayout.setVerticalGroup(
            btngenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btngenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtbtngen, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(btngen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 1170, 90));

        Harder1.setBackground(new java.awt.Color(255, 255, 255));
        Harder1.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        Harder1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Harder1MouseDragged(evt);
            }
        });
        Harder1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Harder1MousePressed(evt);
            }
        });

        Move.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Move.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Move.setText("Reimprimir vale de efectivo");
        Move.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MoveMouseDragged(evt);
            }
        });
        Move.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MoveMousePressed(evt);
            }
        });

        javax.swing.GroupLayout Harder1Layout = new javax.swing.GroupLayout(Harder1);
        Harder1.setLayout(Harder1Layout);
        Harder1Layout.setHorizontalGroup(
            Harder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Harder1Layout.createSequentialGroup()
                .addComponent(Move, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
                .addGap(78, 78, 78))
        );
        Harder1Layout.setVerticalGroup(
            Harder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Harder1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Move, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(Harder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 40));

        btnexit.setBackground(new java.awt.Color(255, 255, 255));

        txtbtnexit.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txtbtnexit.setForeground(new java.awt.Color(0, 0, 0));
        txtbtnexit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtbtnexit.setText("x");
        txtbtnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtbtnexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtbtnexitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtbtnexitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtbtnexitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnexitLayout = new javax.swing.GroupLayout(btnexit);
        btnexit.setLayout(btnexitLayout);
        btnexitLayout.setHorizontalGroup(
            btnexitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnexitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtbtnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnexitLayout.setVerticalGroup(
            btnexitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnexitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtbtnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, -1, -1));

        Tvales.setModel(new javax.swing.table.DefaultTableModel(
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
        Tvales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TvalesMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(Tvales);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1170, 110));

        jLabel24.setText("# Vale:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        NVSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NVSearchKeyReleased(evt);
            }
        });
        getContentPane().add(NVSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 90, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("A-22");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, 20));

        NV.setEditable(false);
        NV.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NV.setForeground(new java.awt.Color(255, 51, 51));
        NV.setText("0");
        NV.setBorder(null);
        NV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NVKeyReleased(evt);
            }
        });
        jPanel1.add(NV, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 90, 20));

        jLabel2.setText("Bueno por:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        Importe.setEditable(false);
        Importe.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Importe.setText("0");
        Importe.setBorder(null);
        Importe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ImporteKeyReleased(evt);
            }
        });
        jPanel1.add(Importe, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 120, 20));

        jLabel3.setText("Recibi de:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        RD.setEditable(false);
        RD.setBorder(null);
        RD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RDKeyReleased(evt);
            }
        });
        jPanel1.add(RD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 160, 20));

        jLabel4.setText("Cantidad de:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        jLabel5.setText("Concepto:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        Concepto.setEditable(false);
        Concepto.setBorder(null);
        Concepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ConceptoKeyReleased(evt);
            }
        });
        jPanel1.add(Concepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 240, 20));

        jLabel6.setText("En:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        En.setEditable(false);
        En.setBorder(null);
        En.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EnKeyReleased(evt);
            }
        });
        jPanel1.add(En, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 120, 20));

        Fecha.setDateFormatString("'A' d 'de' MMMM 'de' y");
        Fecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FechaMousePressed(evt);
            }
        });
        jPanel1.add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 190, -1));

        ImporteEsc.setEditable(false);
        ImporteEsc.setColumns(20);
        ImporteEsc.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        ImporteEsc.setLineWrap(true);
        ImporteEsc.setRows(5);
        jScrollPane1.setViewportView(ImporteEsc);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 340, 50));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 120, 10));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 330, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 170, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 90, 10));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 240, 10));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("A-22");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, 20));

        NV1.setEditable(false);
        NV1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        NV1.setForeground(new java.awt.Color(255, 51, 51));
        NV1.setText("0");
        NV1.setBorder(null);
        jPanel2.add(NV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 100, 20));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Bueno por:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 57, 20));

        Importe1.setEditable(false);
        Importe1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Importe1.setText("0");
        Importe1.setBorder(null);
        Importe1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Importe1KeyReleased(evt);
            }
        });
        jPanel2.add(Importe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 20));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Recibi de:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 45, 20));

        RD1.setEditable(false);
        RD1.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        RD1.setBorder(null);
        jPanel2.add(RD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 165, 20));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel13.setText("Cantidad de:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel14.setText("Concepto:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        Concepto1.setEditable(false);
        Concepto1.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        Concepto1.setBorder(null);
        jPanel2.add(Concepto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 180, 20));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel15.setText("En:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 20, -1));

        En1.setEditable(false);
        En1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        En1.setBorder(null);
        jPanel2.add(En1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 130, 20));

        Fecha1.setDateFormatString("'A' d 'de' MMMM 'de' y");
        jPanel2.add(Fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 180, -1));

        ImporteEsc1.setEditable(false);
        ImporteEsc1.setColumns(20);
        ImporteEsc1.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        ImporteEsc1.setLineWrap(true);
        ImporteEsc1.setRows(5);
        jScrollPane2.setViewportView(ImporteEsc1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 360, 60));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 100, 10));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 180, 10));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 190, 10));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 100, 10));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 190, 10));
        jPanel2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 170, 10));

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Recibe");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 50, 20));
        jPanel2.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 130, 10));

        jLabel23.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("# Vale");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 40, 20));

        Rec1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        Rec1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(Rec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 190, 20));

        jLabel47.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel47.setText("Entrega");
        jPanel2.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, 20));

        Entr1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        Entr1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(Entr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 190, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 380, 380));
        jPanel1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 310, 10));

        jLabel21.setText("Recibe");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        jLabel22.setText("# Vale");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));
        jPanel1.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 310, 10));

        jLabel48.setText("Entrega");
        jPanel1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel25.setText("Denominacion.");

        jLabel26.setText("$1000");

        B1000.setEditable(false);
        B1000.setText("0");
        B1000.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B1000KeyReleased(evt);
            }
        });

        jLabel27.setText("$500");

        B500.setEditable(false);
        B500.setText("0");
        B500.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B500KeyReleased(evt);
            }
        });

        jLabel28.setText("$200");

        B200.setEditable(false);
        B200.setText("0");
        B200.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B200KeyReleased(evt);
            }
        });

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Billete");

        B100.setEditable(false);
        B100.setText("0");
        B100.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B100KeyReleased(evt);
            }
        });

        jLabel31.setText("$100");

        B50.setEditable(false);
        B50.setText("0");
        B50.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B50KeyReleased(evt);
            }
        });

        jLabel32.setText("$50");

        B20.setEditable(false);
        B20.setText("0");
        B20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B20KeyReleased(evt);
            }
        });

        jLabel33.setText("$20");

        jLabel34.setText("$20");

        M1.setEditable(false);
        M1.setText("0");
        M1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                M1KeyReleased(evt);
            }
        });

        jLabel35.setText("$2");

        M10.setEditable(false);
        M10.setText("0");
        M10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                M10KeyReleased(evt);
            }
        });

        M050.setEditable(false);
        M050.setText("0");
        M050.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                M050KeyReleased(evt);
            }
        });

        M20.setEditable(false);
        M20.setText("0");
        M20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                M20KeyReleased(evt);
            }
        });

        M2.setEditable(false);
        M2.setText("0");
        M2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                M2KeyReleased(evt);
            }
        });

        jLabel38.setText("$10");

        jLabel39.setText("$1");

        M5.setEditable(false);
        M5.setText("0");
        M5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                M5KeyReleased(evt);
            }
        });

        jLabel36.setText("$5");

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Moneda");

        jLabel37.setText("$0,50");

        jLabel41.setText("Cantidad");

        jLabel42.setText("Cantidad");

        SB1000.setEditable(false);
        SB1000.setText("0");

        jLabel43.setText("Subtotal");

        SB500.setEditable(false);
        SB500.setText("0");

        SB200.setEditable(false);
        SB200.setText("0");

        SB100.setEditable(false);
        SB100.setText("0");

        SB50.setEditable(false);
        SB50.setText("0");

        SB20.setEditable(false);
        SB20.setText("0");

        SM20.setEditable(false);
        SM20.setText("0");

        SM10.setEditable(false);
        SM10.setText("0");

        SM5.setEditable(false);
        SM5.setText("0");

        SM2.setEditable(false);
        SM2.setText("0");

        SM1.setEditable(false);
        SM1.setText("0");

        SM050.setEditable(false);
        SM050.setText("0");

        jLabel44.setText("Subtotal");

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel45.setText("Total real:");

        TR.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TR.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B1000, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SB1000, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel31)
                                                    .addComponent(jLabel32)
                                                    .addComponent(jLabel33))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(B100, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(B50, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(B20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel28)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(B200, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel27)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(B500, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SB500, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SB200, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SB100, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SB50, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SB20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel45)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TR))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel41)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel43)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel34)
                                        .addComponent(jLabel38))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(M20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(M10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel36)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(M5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel39)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(M1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel35)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(M2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel37)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(M050, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(1, 1, 1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel44))
                    .addComponent(SM20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SM10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SM5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SM2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SM1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SM050, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel41)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(B1000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SB1000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SB500, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(B500, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SB200, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(B200, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(SB100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(SB50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(B20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SB20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel40)
                                .addComponent(jLabel42)
                                .addComponent(jLabel44))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel34)
                                .addComponent(M20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(M10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel38))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(M5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel36))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel35)
                                .addComponent(M2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(M1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel39))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(M050, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel37)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(SM20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SM10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SM5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SM050, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(TR))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 430, 380));

        Rec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Rec, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 310, 30));

        Entr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Entr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 310, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1170, -1));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Microsoft-Excel-Logo.png"))); // NOI18N
        jLabel46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MoveMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoveMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_MoveMouseDragged

    private void MoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoveMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_MoveMousePressed

    private void Harder1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Harder1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_Harder1MouseDragged

    private void Harder1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Harder1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_Harder1MousePressed

    private void txtbtngenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbtngenMouseClicked
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable((Printable) this);
            job.printDialog();
            job.print();
            NV.setText("0");
            Importe.setText("");
            RD.setText("");
            Concepto.setText("");
            En.setText("");
            Fecha.setDate(null);
            ImporteEsc.setText("");
            NV1.setText("0");
            Importe1.setText("");
            RD1.setText("");
            Concepto1.setText("");
            En1.setText("");
            Fecha1.setDate(null);
            ImporteEsc1.setText("");
        } catch (PrinterException ex) {
        }
    }//GEN-LAST:event_txtbtngenMouseClicked

    private void txtbtngenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbtngenMouseEntered
        btngen.setBackground(Color.green);
        txtbtngen.setForeground(Color.black);
    }//GEN-LAST:event_txtbtngenMouseEntered

    private void txtbtngenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbtngenMouseExited
        btngen.setBackground(Color.white);
        txtbtngen.setForeground(Color.black);
    }//GEN-LAST:event_txtbtngenMouseExited

    private void txtbtnexitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbtnexitMouseExited
        btnexit.setBackground(Color.white);
        txtbtnexit.setForeground(Color.black);
    }//GEN-LAST:event_txtbtnexitMouseExited

    private void txtbtnexitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbtnexitMouseEntered
        btnexit.setBackground(Color.red);
        txtbtnexit.setForeground(Color.white);
    }//GEN-LAST:event_txtbtnexitMouseEntered

    private void txtbtnexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbtnexitMouseClicked
        this.dispose();
    }//GEN-LAST:event_txtbtnexitMouseClicked

    private void TvalesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TvalesMousePressed
        try {
            DefaultTableModel model = (DefaultTableModel) Tvales.getModel();
            int seleccionar = Tvales.getSelectedRow();
            NV.setText(String.valueOf(Tvales.getValueAt(seleccionar, 0)));
            Importe.setText(String.valueOf(Tvales.getValueAt(seleccionar, 1)));
            RD.setText(String.valueOf(Tvales.getValueAt(seleccionar, 2)));
            Concepto.setText(String.valueOf(Tvales.getValueAt(seleccionar, 3)));
            En.setText(String.valueOf(Tvales.getValueAt(seleccionar, 4)));
            Date date2 = new SimpleDateFormat("'A' d 'de' MMMM 'de' y").parse((String) model.getValueAt(seleccionar, 5));
            Fecha.setDate(date2);
            ImporteEsc.setText(String.valueOf(Tvales.getValueAt(seleccionar, 6)));

            NV1.setText(String.valueOf(Tvales.getValueAt(seleccionar, 0)));
            Importe1.setText(String.valueOf(Tvales.getValueAt(seleccionar, 1)));
            RD1.setText(String.valueOf(Tvales.getValueAt(seleccionar, 2)));
            Concepto1.setText(String.valueOf(Tvales.getValueAt(seleccionar, 3)));
            En1.setText(String.valueOf(Tvales.getValueAt(seleccionar, 4)));
            Date date1 = new SimpleDateFormat("'A' d 'de' MMMM 'de' y").parse((String) model.getValueAt(seleccionar, 5));
            Fecha1.setDate(date1);
            ImporteEsc1.setText(String.valueOf(Tvales.getValueAt(seleccionar, 6)));

            int id = Integer.parseInt(Tvales.getValueAt(seleccionar, 0).toString());
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("select `B1000`, `SB1000`, `B500`, `SB500`, "
                    + "`B200`, `SB200`, `B100`, `SB100`, `B50`, `SB50`, `B20`, `SB20`, "
                    + "`M20`, `SM20`, `M10`, `SM10`, `M5`, `SM5`, `M2`, `SM2`, `M1`, "
                    + "`SM1`, `M050`, `SM050`, `total real`, `recibe`, `entrega` from `semanal.vales` where `#vale` = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                B1000.setText(rs.getString(1));
                SB1000.setText(rs.getString(2));
                B500.setText(rs.getString(3));
                SB500.setText(rs.getString(4));
                B200.setText(rs.getString(5));
                SB200.setText(rs.getString(6));
                B100.setText(rs.getString(7));
                SB100.setText(rs.getString(8));
                B50.setText(rs.getString(9));
                SB50.setText(rs.getString(10));
                B20.setText(rs.getString(11));
                SB20.setText(rs.getString(12));
                M20.setText(rs.getString(13));
                SM20.setText(rs.getString(14));
                M10.setText(rs.getString(15));
                SM10.setText(rs.getString(16));
                M5.setText(rs.getString(17));
                SM5.setText(rs.getString(18));
                M2.setText(rs.getString(19));
                SM2.setText(rs.getString(20));
                M1.setText(rs.getString(21));
                SM1.setText(rs.getString(22));
                M050.setText(rs.getString(23));
                SM050.setText(rs.getString(24));
                TR.setText(rs.getString(25));
                Rec.setText(rs.getString(26));
                Rec1.setText(rs.getString(26));
                Entr.setText(rs.getString(27));
                Entr1.setText(rs.getString(27));

            }
            ps.isClosed();
            rs.isClosed();

        } catch (ParseException | SQLException ex) {
            Logger.getLogger(Rvales.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_TvalesMousePressed

    private void NVSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NVSearchKeyReleased
        MDVales();
    }//GEN-LAST:event_NVSearchKeyReleased

    private void NVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NVKeyReleased
        NV1.setText(NV.getText());
    }//GEN-LAST:event_NVKeyReleased

    private void ImporteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ImporteKeyReleased
        Importe1.setText(Importe.getText());
        ImporteEsc.setText(Convertir(Importe.getText(), true));
        ImporteEsc1.setText(ImporteEsc.getText());
    }//GEN-LAST:event_ImporteKeyReleased

    private void RDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RDKeyReleased
        RD1.setText(RD.getText());
    }//GEN-LAST:event_RDKeyReleased

    private void ConceptoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConceptoKeyReleased
        Concepto1.setText(Concepto.getText());
    }//GEN-LAST:event_ConceptoKeyReleased

    private void EnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EnKeyReleased
        En1.setText(En.getText());
    }//GEN-LAST:event_EnKeyReleased

    private void FechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FechaMousePressed
        Fecha1.setDate(Fecha.getDate());
    }//GEN-LAST:event_FechaMousePressed

    private void Importe1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Importe1KeyReleased
        ImporteEsc1.setText(Convertir(Importe1.getText(), true));
    }//GEN-LAST:event_Importe1KeyReleased

    private void B1000KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B1000KeyReleased
        SB1000.setText("" + (BM * Double.parseDouble(B1000.getText())));
        TDEN();
    }//GEN-LAST:event_B1000KeyReleased

    private void B500KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B500KeyReleased
        SB500.setText("" + (BQ * Double.parseDouble(B500.getText())));
        TDEN();
    }//GEN-LAST:event_B500KeyReleased

    private void B200KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B200KeyReleased
        SB200.setText("" + (BD * Double.parseDouble(B200.getText())));
        TDEN();
    }//GEN-LAST:event_B200KeyReleased

    private void B100KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B100KeyReleased
        SB100.setText("" + (BC * Double.parseDouble(B100.getText())));
        TDEN();
    }//GEN-LAST:event_B100KeyReleased

    private void B50KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B50KeyReleased
        SB50.setText("" + (BCIN * Double.parseDouble(B50.getText())));
        TDEN();
    }//GEN-LAST:event_B50KeyReleased

    private void B20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B20KeyReleased
        SB20.setText("" + (BV * Double.parseDouble(B20.getText())));
        TDEN();
    }//GEN-LAST:event_B20KeyReleased

    private void M1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M1KeyReleased
        SM1.setText("" + (MU * Double.parseDouble(M1.getText())));
        TDEN();
    }//GEN-LAST:event_M1KeyReleased

    private void M10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M10KeyReleased
        SM10.setText("" + (MD * Double.parseDouble(M10.getText())));
        TDEN();
    }//GEN-LAST:event_M10KeyReleased

    private void M050KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M050KeyReleased
        SM050.setText("" + (MCENT * Double.parseDouble(M050.getText())));
        TDEN();
    }//GEN-LAST:event_M050KeyReleased

    private void M20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M20KeyReleased
        SM20.setText("" + (MV * Double.parseDouble(M20.getText())));
        TDEN();
    }//GEN-LAST:event_M20KeyReleased

    private void M2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M2KeyReleased
        SM2.setText("" + (MDOS * Double.parseDouble(M2.getText())));
        TDEN();
    }//GEN-LAST:event_M2KeyReleased

    private void M5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M5KeyReleased
        SM5.setText("" + (MC * Double.parseDouble(M5.getText())));
        TDEN();
    }//GEN-LAST:event_M5KeyReleased

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Excel", "xlsx");
        chooser.setSelectedFile(new File("Reporte de Datos BD"));
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xlsx"); //extención del archivo excel
        }
        try {
            String ruta = chooser.getSelectedFile().toString().concat(".xlsx");
            File archivoXLS = new File(ruta);
            if (archivoXLS.exists()) {
                archivoXLS.delete();
            }
            archivoXLS.createNewFile();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://192.168.1.170:3306/confort2022",
                    "Servidor",
                    "Confort1022"
            );
            Statement RHstatement = connect.createStatement();
            ResultSet resultSetRH = RHstatement.executeQuery("SELECT * FROM `semanal.vales`");
            try ( FileOutputStream archivo = new FileOutputStream(archivoXLS)) {
                XSSFWorkbook libro = new XSSFWorkbook();
                XSSFSheet spreadsheet = libro.createSheet("Datos vales");

                XSSFCellStyle Encabezado = libro.createCellStyle();
                Encabezado.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                Encabezado.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);

                XSSFCellStyle Stilodd = libro.createCellStyle();

                Stilodd.setBorderBottom(XSSFCellStyle.BORDER_THIN);
                Stilodd.setBorderLeft(XSSFCellStyle.BORDER_THIN);
                Stilodd.setBorderTop(XSSFCellStyle.BORDER_THIN);
                Stilodd.setAlignment(XSSFCellStyle.ALIGN_CENTER_SELECTION);
                Stilodd.setVerticalAlignment(XSSFCellStyle.VERTICAL_BOTTOM);

                XSSFCellStyle StiloEEEE = libro.createCellStyle();

                StiloEEEE.setBorderBottom(XSSFCellStyle.BORDER_THIN);
                StiloEEEE.setBorderRight(XSSFCellStyle.BORDER_THIN);
                StiloEEEE.setBorderTop(XSSFCellStyle.BORDER_THIN);
                StiloEEEE.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
                StiloEEEE.setVerticalAlignment(XSSFCellStyle.VERTICAL_BOTTOM);

                XSSFCellStyle Contenido = libro.createCellStyle();
                Contenido.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                Contenido.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
                Contenido.setBorderBottom(XSSFCellStyle.BORDER_THIN);
                Contenido.setBorderLeft(XSSFCellStyle.BORDER_THIN);
                Contenido.setBorderRight(XSSFCellStyle.BORDER_THIN);
                Contenido.setBorderTop(XSSFCellStyle.BORDER_THIN);
                XSSFRow row = spreadsheet.createRow((short) 0);
                XSSFCell cell = (XSSFCell) row.createCell((short) 0);
                cell.setCellValue("Datos vales");
                cell.setCellStyle(Encabezado);

                spreadsheet.addMergedRegion(
                        new CellRangeAddress(
                                0, //first row (0-based)
                                0, //last row (0-based)
                                0, //first column (0-based)
                                5 //last column (0-based)
                        )
                );
                row = spreadsheet.createRow(1);
                cell = row.createCell(0);
                cell.setCellValue("# Vale");
                cell.setCellStyle(Contenido);
                cell = row.createCell(1);
                cell.setCellValue("Bueno por:");
                cell.setCellStyle(Contenido);
                cell = row.createCell(2);
                cell.setCellValue("Recibi de");
                cell.setCellStyle(Contenido);
                cell = row.createCell(3);
                cell.setCellValue("Concepto");
                cell.setCellStyle(Contenido);
                cell = row.createCell(4);
                cell.setCellValue("EN");
                cell.setCellStyle(Contenido);
                cell = row.createCell(5);
                cell.setCellValue("Fecha");
                cell.setCellStyle(Contenido);
                cell = row.createCell(6);
                cell.setCellValue("Cantidad");
                cell.setCellStyle(Contenido);
                cell = row.createCell(7);
                cell.setCellValue("Billetes 1000");
                cell.setCellStyle(Contenido);
                cell = row.createCell(8);
                cell.setCellValue("Subtotal 1000");
                cell.setCellStyle(Contenido);
                cell = row.createCell(9);
                cell.setCellValue("Billetes 500");
                cell.setCellStyle(Contenido);
                cell = row.createCell(10);
                cell.setCellValue("Subtotal 500");
                cell.setCellStyle(Contenido);
                cell = row.createCell(11);
                cell.setCellValue("Billetes 200");
                cell.setCellStyle(Contenido);
                cell = row.createCell(12);
                cell.setCellValue("Subtotal 200");
                cell.setCellStyle(Contenido);
                cell = row.createCell(13);
                cell.setCellValue("Billetes 100");
                cell.setCellStyle(Contenido);
                cell = row.createCell(14);
                cell.setCellValue("Subtotal 100");
                cell.setCellStyle(Contenido);
                cell = row.createCell(15);
                cell.setCellValue("Billetes 50");
                cell.setCellStyle(Contenido);
                cell = row.createCell(16);
                cell.setCellValue("Subtotal 50");
                cell.setCellStyle(Contenido);
                cell = row.createCell(17);
                cell.setCellValue("Billetes 20");
                cell.setCellStyle(Contenido);
                cell = row.createCell(18);
                cell.setCellValue("Subtotal 20");
                cell.setCellStyle(Contenido);
                cell = row.createCell(19);
                cell.setCellValue("Monedas 20");
                cell.setCellStyle(Contenido);
                cell = row.createCell(20);
                cell.setCellValue("Subtotal 20");
                cell.setCellStyle(Contenido);
                cell = row.createCell(21);
                cell.setCellValue("Monedas 10");
                cell.setCellStyle(Contenido);
                cell = row.createCell(22);
                cell.setCellValue("Subtotal 10");
                cell.setCellStyle(Contenido);
                cell = row.createCell(23);
                cell.setCellValue("Monedas 5");
                cell.setCellStyle(Contenido);
                cell = row.createCell(24);
                cell.setCellValue("Subtotal 5");
                cell.setCellStyle(Contenido);
                cell = row.createCell(25);
                cell.setCellValue("Monedas 2");
                cell.setCellStyle(Contenido);
                cell = row.createCell(26);
                cell.setCellValue("Subtotal 2");
                cell.setCellStyle(Contenido);
                cell = row.createCell(27);
                cell.setCellValue("Monedas 1");
                cell.setCellStyle(Contenido);
                cell = row.createCell(28);
                cell.setCellValue("Subtotal 1");
                cell.setCellStyle(Contenido);
                cell = row.createCell(29);
                cell.setCellValue("Monedas 0.50");
                cell.setCellStyle(Contenido);
                cell = row.createCell(30);
                cell.setCellValue("Subtotal 0.50");
                cell.setCellStyle(Contenido);
                cell = row.createCell(31);
                cell.setCellValue("Total real");
                cell.setCellStyle(Contenido);
                cell = row.createCell(32);
                cell.setCellValue("Recibe");
                cell.setCellStyle(Contenido);
                cell = row.createCell(33);
                cell.setCellValue("Entrega");

                int i = 2;

                while (resultSetRH.next()) {
                    row = spreadsheet.createRow(i);
                    cell = row.createCell(0);
                    cell.setCellValue(resultSetRH.getInt(1));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(1);
                    cell.setCellValue(resultSetRH.getString(2));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(2);
                    cell.setCellValue(resultSetRH.getString(3));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(3);
                    cell.setCellValue(resultSetRH.getString(4));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(4);
                    cell.setCellValue(resultSetRH.getString(5));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(5);
                    cell.setCellValue(resultSetRH.getString(6));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(6);
                    cell.setCellValue(resultSetRH.getString(7));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(7);
                    cell.setCellValue(resultSetRH.getDouble(8));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(8);
                    cell.setCellValue(resultSetRH.getDouble(9));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(9);
                    cell.setCellValue(resultSetRH.getDouble(10));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(10);
                    cell.setCellValue(resultSetRH.getDouble(11));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(11);
                    cell.setCellValue(resultSetRH.getDouble(12));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(12);
                    cell.setCellValue(resultSetRH.getDouble(13));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(13);
                    cell.setCellValue(resultSetRH.getDouble(14));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(14);
                    cell.setCellValue(resultSetRH.getDouble(15));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(15);
                    cell.setCellValue(resultSetRH.getDouble(16));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(16);
                    cell.setCellValue(resultSetRH.getDouble(17));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(17);
                    cell.setCellValue(resultSetRH.getDouble(18));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(18);
                    cell.setCellValue(resultSetRH.getDouble(19));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(19);
                    cell.setCellValue(resultSetRH.getDouble(20));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(20);
                    cell.setCellValue(resultSetRH.getDouble(21));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(21);
                    cell.setCellValue(resultSetRH.getDouble(22));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(22);
                    cell.setCellValue(resultSetRH.getDouble(23));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(23);
                    cell.setCellValue(resultSetRH.getDouble(24));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(24);
                    cell.setCellValue(resultSetRH.getDouble(25));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(25);
                    cell.setCellValue(resultSetRH.getDouble(26));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(26);
                    cell.setCellValue(resultSetRH.getDouble(27));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(27);
                    cell.setCellValue(resultSetRH.getDouble(28));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(28);
                    cell.setCellValue(resultSetRH.getDouble(29));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(29);
                    cell.setCellValue(resultSetRH.getDouble(30));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(30);
                    cell.setCellValue(resultSetRH.getDouble(31));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(31);
                    cell.setCellValue(resultSetRH.getDouble(32));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(32);
                    cell.setCellValue(resultSetRH.getString(33));
                    cell.setCellStyle(Contenido);
                    cell = row.createCell(33);
                    cell.setCellValue(resultSetRH.getString(34));
                    cell.setCellStyle(Contenido);
                    i++;
                }

                spreadsheet.getPrintSetup();
                spreadsheet.getPrintSetup().setPaperSize(PaperSize.LETTER_PAPER);
                spreadsheet.getPrintSetup().setLandscape(false); // Dirección de impresión, true: horizontal, false: vertical
                spreadsheet.setMargin(HSSFSheet.BottomMargin, (double) 0.1); // Margen (abajo)
                spreadsheet.setMargin(HSSFSheet.LeftMargin, (double) 0.1); // Margen (izquierda)
                spreadsheet.setMargin(HSSFSheet.RightMargin, (double) 0.1); // Margen (derecha)
                spreadsheet.setMargin(HSSFSheet.TopMargin, (double) 0.1); // Margen (arriba)
                spreadsheet.setMargin(HSSFSheet.FooterMargin, (double) 0.1);
                spreadsheet.setMargin(HSSFSheet.HeaderMargin, (double) 0.1);

                spreadsheet.setVerticallyCenter(true);
                libro.write(archivo);
            }
            Desktop.getDesktop().open(archivoXLS);
        } catch (IOException | NumberFormatException e) {

            try {
                throw e;
            } catch (IOException | NumberFormatException ex) {
                Logger.getLogger(Rvales.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Rvales.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jLabel46MouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rvales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Rvales().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField B100;
    private javax.swing.JTextField B1000;
    private javax.swing.JTextField B20;
    private javax.swing.JTextField B200;
    private javax.swing.JTextField B50;
    private javax.swing.JTextField B500;
    private javax.swing.JTextField Concepto;
    private javax.swing.JTextField Concepto1;
    private javax.swing.JTextField En;
    private javax.swing.JTextField En1;
    private javax.swing.JLabel Entr;
    private javax.swing.JLabel Entr1;
    private com.toedter.calendar.JDateChooser Fecha;
    private com.toedter.calendar.JDateChooser Fecha1;
    private javax.swing.JPanel Harder1;
    private javax.swing.JTextField Importe;
    private javax.swing.JTextField Importe1;
    private javax.swing.JTextArea ImporteEsc;
    private javax.swing.JTextArea ImporteEsc1;
    private javax.swing.JTextField M050;
    private javax.swing.JTextField M1;
    private javax.swing.JTextField M10;
    private javax.swing.JTextField M2;
    private javax.swing.JTextField M20;
    private javax.swing.JTextField M5;
    private javax.swing.JLabel Move;
    private javax.swing.JTextField NV;
    private javax.swing.JTextField NV1;
    private javax.swing.JTextField NVSearch;
    private javax.swing.JTextField RD;
    private javax.swing.JTextField RD1;
    private javax.swing.JLabel Rec;
    private javax.swing.JLabel Rec1;
    private javax.swing.JTextField SB100;
    private javax.swing.JTextField SB1000;
    private javax.swing.JTextField SB20;
    private javax.swing.JTextField SB200;
    private javax.swing.JTextField SB50;
    private javax.swing.JTextField SB500;
    private javax.swing.JTextField SM050;
    private javax.swing.JTextField SM1;
    private javax.swing.JTextField SM10;
    private javax.swing.JTextField SM2;
    private javax.swing.JTextField SM20;
    private javax.swing.JTextField SM5;
    private javax.swing.JLabel TR;
    private javax.swing.JTable Tvales;
    private javax.swing.JPanel btnexit;
    private javax.swing.JPanel btngen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel txtbtnexit;
    private javax.swing.JLabel txtbtngen;
    // End of variables declaration//GEN-END:variables
}
