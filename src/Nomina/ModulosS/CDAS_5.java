package Nomina.ModulosS;

import Nomina.VentanasDReportes.RepNomSem_7;
import Nomina.VentanasDReportes.RepNom_7;
import RH.Depositos.DepositosQ_4;
import Semanal.PT_4;
import Semanal.Tehuantepec_4;
import Semanal.Iturbide_4;
import Nomina.ModulosQ.CDAQ_5;
import Nomina.ModulosQ.ODTQ_5;
import Nomina.ModulosQ.PresQ_5;
import Admin.*;
import Inicio.Inicio_1;
import RH.*;
import Conexion.ConexionSQL;
import Logicas.*;
import Logicas.BDNomS.Logica_bd_NomCDAS;
import Logicas.BDNomS.Logica_bd_pagosCDAS;
import Nomina.Listas.*;
import Nomina.NominaQSiMSS_5;
import Nomina.NominaQ_5;
import Nomina.NominaS_5;
import Nomina.NominaS_simss_5;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JDeat
 */
public final class CDAS_5 extends javax.swing.JFrame {

    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion();
    Logica_usuarios usr;
    Logica_permisos LP;

    public CDAS_5() {
        initComponents();
        NL.setVisible(false);
        NC.setVisible(false);
        MDCDA();
        sumaTA();
        MDTPCDA();
        sharecda();
        Labelcda.setVisible(false);
        Busnamecdash.setVisible(false);
        BusAPcdash.setVisible(false);
        BusAMcdash.setVisible(false);
        Labelfilcda.setVisible(false);
        BusnameCDA.setVisible(false);
        FilAPCDA.setVisible(false);
        FillAMCDA.setVisible(false);
        labelpcda.setVisible(false);
        FilnamePCDA.setVisible(false);
        FilAPPCDA.setVisible(false);
        FilAMPCDA.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setExtendedState(6);
        setIconImage(new ImageIcon(CDAS_5.class.getClassLoader().getResource("Imagenes/Icono.png")).getImage());

    }

    public CDAS_5(Logica_usuarios usr, Logica_permisos LP) {
        initComponents();
        this.usr = usr;
        this.LP = LP;
        NL.setVisible(false);
        NC.setVisible(false);
        MDCDA();
        sumaTA();
        MDTPCDA();
        sharecda();
        Labelcda.setVisible(false);
        Busnamecdash.setVisible(false);
        BusAPcdash.setVisible(false);
        BusAMcdash.setVisible(false);
        Labelfilcda.setVisible(false);
        BusnameCDA.setVisible(false);
        FilAPCDA.setVisible(false);
        FillAMCDA.setVisible(false);
        labelpcda.setVisible(false);
        FilnamePCDA.setVisible(false);
        FilAPPCDA.setVisible(false);
        FilAMPCDA.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setExtendedState(6);
        setIconImage(new ImageIcon(CDAS_5.class.getClassLoader().getResource("Imagenes/Icono.png")).getImage());
        setTitle("Nomina: Caja de ahorro Semanal. # Usuario: " + usr.getId_user() + " " + usr.getApellidop() + " " + usr.getApellidoM() + " " + usr.getNombre()
                + " Tipo de ususario: " + usr.getNombre_tipo() + " Usuario: " + usr.getUsuario());
        switch (LP.getVDA()) {
            case 0 -> {
            }
            case 1 -> {
                Menuadm.setVisible(false);

            }
            case 2 -> {
                Menuadm.setVisible(false);
                if (LP.getP1() == 0) {
                    ODT.setVisible(false);
                }
                if (LP.getP2() == 0) {
                    //CDA.setVisible(false);
                }
                if (LP.getP3() == 0) {
                    LDA.setVisible(false);
                }
                if (LP.getP4() == 0) {
                    Reportes.setVisible(false);
                }
                if (LP.getP5() == 0) {
                    //   NomDetallada.setVisible(false);
                }
                if (LP.getP6() == 0) {
                    // NomPagos.setVisible(false);
                }
                if (LP.getP7() == 0) {
                    PRES.setVisible(false);
                }
                if (LP.getP8() == 0) {
                    Nomsem.setVisible(false);
                    NomSemGen.setVisible(false);
                }
                if (LP.getP9() == 0) {
                    PresSem.setVisible(false);
                }
                if (LP.getP10() == 0) {
                    //Modm.setVisible(false);
                }
            }
            default -> {
            }
        }

    }

    //compartr con caja de ahorro
    public void sharecda() {
        //Buscar empleado
        String Share = Busnamecdash.getText();
        String ShareAP = BusAPcdash.getText();
        String ShareAM = BusAMcdash.getText();
        String where = "select `# Exp`, `Apellido P`, `Apellido M`, `Nombre(s)`,"
                + " `Zona`, `Servicio` from `rh.empleados`  where `Status` LIKE '%Vigente%'";

        if (!"".equals(Share)) {
            where = " select `# Exp`, `Apellido P`, `Apellido M`, `Nombre(s)`, `Zona`,"
                    + " `Servicio` from `rh.empleados` WHERE `Nombre(s)` LIKE '%" + Share + "%' AND `Status` LIKE '%Vigente%'";
        } else if (!"".equals(ShareAP)) {
            where = " select `# Exp`, `Apellido P`, `Apellido M`, `Nombre(s)`, `Zona`,"
                    + " `Servicio` from `rh.empleados` WHERE `Apellido P` LIKE '%" + ShareAP + "%' AND `Status` LIKE '%Vigente%'";
        } else if (!"".equals(ShareAM)) {
            where = " select `# Exp`, `Apellido P`, `Apellido M`, `Nombre(s)`, `Zona`,"
                    + " `Servicio` from `rh.empleados` WHERE `Apellido M` LIKE '%" + ShareAM + "%' AND `Status` LIKE '%Vigente%'";
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
            ShareCDA.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(where);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Empleado");//1
            modelo.addColumn("Apellido P");//2
            modelo.addColumn("Apellido M");//
            modelo.addColumn("Nombre(s)");//4
            modelo.addColumn("Zona");
            modelo.addColumn("Servicio");//6

//Anchos
            int[] anchos = {25, 50, 50, 150, 40, 75};

            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                ShareCDA.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException error_sh_cda) {
            JOptionPane.showMessageDialog(null, "Error al mostrar compartir con caja de ahorro: " + error_sh_cda.getMessage());

        }

    }

    public void MODPAGOCDA() {

        String SQL = "UPDATE `nominasem.pagos.cda` SET `Caja de ahorro` = ?, `Observaciones` = ?, "
                + "`Qnas aportadas` = ?, `# de recibo de pago`"
                + " = ? WHERE `nomina.pagos.cda`.`#Folio` = ?";

        try {
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, ADCDA.getText());
            pst.setString(2, obdpagocda.getText());
            pst.setString(3, NQna.getText());
            pst.setString(4, NREcda.getText());
            pst.setInt(5, Integer.parseInt(NFpagocda.getText()));

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pago de caja de ahorro en modificado.");

            ADCDA.setText("0");
            NQna.setText("0");
            obdpagocda.setText("");
            NREcda.setText("");
            NFpagocda.setText("0");

        } catch (HeadlessException | SQLException error_mod_pcda) {
            JOptionPane.showMessageDialog(null, "Error al modificar pago de caja de ahorro en : " + error_mod_pcda.getMessage());
        }
    }

    //mostrar datos pagos cda
    public void MDTPCDA() {
        String FiltroN = FilnamePCDA.getText();
        String FAP = FilAPPCDA.getText();
        String FAM = FilAMPCDA.getText();
        String where = "SELECT * FROM `nominasem.pagos.cda`";

        if (!"".equals(FiltroN)) {
            where = "SELECT * FROM `nominasem.pagos.cda`"
                    + " where `Nombre(s)` LIKE '%" + FiltroN + "%'";
        } else if (!"".equals(FAP)) {
            where = "SELECT * FROM `nominasem.pagos.cda`"
                    + " Where `Apellido P` LIKE '%" + FAP + "%'";
        } else if (!"".equals(FAM)) {
            where = "SELECT * FROM `nominasem.pagos.cda`"
                    + " Where `Apellido M` LIKE '%" + FAM + "%'";
        } else if (!"".equals(NL.getText())) {
            where = "SELECT * FROM `nominasem.pagos.cda`"
                    + " Where `#Lista` LIKE '%" + NL.getText() + "%'";
        } else if (!"".equals(NC.getText())) {
            where = "SELECT * FROM `nominasem.pagos.cda`"
                    + " Where `#caja` LIKE '%" + NC.getText() + "%'";
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
            TPCDA.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(where);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Folio");
            modelo.addColumn("# Lista");//2
            modelo.addColumn("# caja");//2
            modelo.addColumn("# Empleado");
            modelo.addColumn("Apellido P");//4
            modelo.addColumn("Apellido M");
            modelo.addColumn("Nombre(s)");//6
            modelo.addColumn("Zona");
            modelo.addColumn("Servicio");//8
            modelo.addColumn("Quincena");
            modelo.addColumn("Caja de ahorro");//10
            modelo.addColumn("Observaciones");
            modelo.addColumn("Qnas aportadas");//12
            modelo.addColumn("# de recibo de pago");

//ANCHOS
            int[] anchos = {/*ND*/30, /*NL*/ 30, /*NC*/ 30, /*NE*/ 50, /*AP*/ 60, /*AM*/ 60, /*NAME*/ 50, /*ZON*/ 50,
                /*SERV*/ 50, /*QUIN*/ 60, /*cda*/ 50, /*OBS*/ 100, /*QA*/ 60,/*NDRDP*/ 60};

            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                TPCDA.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException error_mostrsr_pcda) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos pagos de caja de ahorro: " + error_mostrsr_pcda.getMessage());

        }

    }

    //Editar CDA
    public void editarCDA() {

        String SQL = "UPDATE `nominasem.cajadeahorro` SET `#caja` = ?,"
                + " `#exp_Empleado` = ?, `Apellido P` = ?, `Apellido M` = ?,"
                + " `Nombre(s)` = ?, `Zona` = ?, `Servicio` = ?, "
                + "`Ahorro por semana` = ?, `Semanas Ahorradas` = ?,"
                + " `Total Ahorrado` = ?, `caja anticipada` = ?, `total a pagar` = ?, "
                + "`% interes` = ?, `interes a pagar` = ?, `Por final pagar` = ?, "
                + "`Status` = ?, `Observacion 1` = ?, `Observaciones` = ? WHERE "
                + "`nominasem.cajadeahorro`.`#caja` = ?";

        try {
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setInt(1, Integer.parseInt(Numcda.getText()));
            pst.setInt(2, Integer.parseInt(numEcda.getText()));
            pst.setString(3, APcda.getText());
            pst.setString(4, AMcda.getText());
            pst.setString(5, namecda.getText());
            pst.setString(6, zonacda.getText());
            pst.setString(7, servcda.getText());
            pst.setString(8, APQ.getText());
            pst.setString(9, QAdas.getText());
            pst.setString(10, TArrado.getText());
            pst.setString(11, CajaA.getText());
            pst.setString(12, Totalap.getText());
            pst.setString(13, PorcenIn.getText());
            pst.setString(14, IAP.getText());
            pst.setString(15, PPF.getText());
            pst.setString(16, Statuscda.getSelectedItem().toString());
            pst.setString(17, Obs1cda.getSelectedItem().toString());
            pst.setString(18, Obscda.getText());
            pst.setInt(19, Integer.parseInt(Numcda.getText()));

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Caja de ahorro Modificada");

            //limpiar campos
            Numcda.setText("0");
            numEcda.setText("0");
            APcda.setText("");
            AMcda.setText("");
            namecda.setText("");
            zonacda.setText("");
            servcda.setText("");
            APQ.setText("0");
            QAdas.setText("0");
            TArrado.setText("0");
            CajaA.setText("0");
            Totalap.setText("0");
            PorcenIn.setText("0");
            IAP.setText("0");
            PPF.setText("0");
            Obscda.setText("");
            Statuscda.setSelectedIndex(0);
            Obs1cda.setSelectedIndex(0);
            CalIn.setSelected(false);

        } catch (HeadlessException | SQLException error_mod_cda) {
            JOptionPane.showMessageDialog(null, "Error modificar Caja de ahorro: " + error_mod_cda.getMessage());
        }
    }

    //agregar caja de ahorro
    public void AgregarCDA() {

        String SQL = "INSERT INTO `nominasem.cajadeahorro` (`#caja`, `#exp_Empleado`, `Apellido P`, "
                + "`Apellido M`, `Nombre(s)`, `Zona`, `Servicio`, `Ahorro por semana`, "
                + "`Semanas Ahorradas`, `Total Ahorrado`, `caja anticipada`, `total a pagar`, `% interes`, "
                + "`interes a pagar`, `Por final pagar`, `Status`, `Observacion 1`, `Observaciones`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setInt(1, Integer.parseInt(Numcda.getText()));
            pst.setInt(2, Integer.parseInt(numEcda.getText()));
            pst.setString(3, APcda.getText());
            pst.setString(4, AMcda.getText());
            pst.setString(5, namecda.getText());
            pst.setString(6, zonacda.getText());
            pst.setString(7, servcda.getText());
            pst.setString(8, APQ.getText());
            pst.setString(9, QAdas.getText());
            pst.setString(10, TArrado.getText());
            pst.setString(11, CajaA.getText());
            pst.setString(12, Totalap.getText());
            pst.setString(13, PorcenIn.getText());
            pst.setString(14, IAP.getText());
            pst.setString(15, PPF.getText());
            pst.setString(16, Statuscda.getSelectedItem().toString());
            pst.setString(17, Obs1cda.getSelectedItem().toString());
            pst.setString(18, Obscda.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Caja de ahorro Agregada");

            //limpiar
            Numcda.setText("0");
            numEcda.setText("0");
            APcda.setText("");
            AMcda.setText("");
            namecda.setText("");
            zonacda.setText("");
            servcda.setText("");
            APQ.setText("0");
            QAdas.setText("0");
            TArrado.setText("0");
            CajaA.setText("0");
            Totalap.setText("0");
            PorcenIn.setText("0");
            IAP.setText("0");
            PPF.setText("0");
            Obscda.setText("");
            Statuscda.setSelectedIndex(0);
            Obs1cda.setSelectedIndex(0);
            CalIn.setSelected(false);

        } catch (HeadlessException | SQLException error_add_cda) {
            JOptionPane.showMessageDialog(null, "Error al agregar Caja de ahorro: " + error_add_cda.getMessage());
        }
    }

    //Suma de total ahorrado 
    public void sumaTA() {
        double t = 0;
        double p;
        if (Tablacda.getRowCount() > 0) {
            for (int i = 0; i < Tablacda.getRowCount(); i++) {
                p = Double.parseDouble(Tablacda.getValueAt(i, 9).toString());
                t += p;
            }
            TELC.setText("" + t);
        } else {

        }
    }

    //mostrar datos caja de ahorro
    public void MDCDA() {
        //Buscar empleado
        String Share = BusnameCDA.getText();
        String ShareAP = FilAPCDA.getText();
        String ShareAM = FillAMCDA.getText();
        String where = "select * from `nominasem.cajadeahorro`";

        if (!"".equals(Share)) {
            where = " select * from `nominasem.cajadeahorro` WHERE `Nombre(s)` LIKE '%" + Share + "%'";
        } else if (!"".equals(ShareAP)) {
            where = " select * from `nominasem.cajadeahorro` WHERE `Apellido P` LIKE '%" + ShareAP + "%'";
        } else if (!"".equals(ShareAM)) {
            where = " select * from `nominasem.cajadeahorro` WHERE `Apellido M` LIKE '%" + ShareAM + "%'";
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
            Tablacda.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(where);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Caja");//1
            modelo.addColumn("# Empleado");//
            modelo.addColumn("Apellido P");//3
            modelo.addColumn("Apellido M");
            modelo.addColumn("Nombre(s)");//5
            modelo.addColumn("Zona");
            modelo.addColumn("Servicio");//7
            modelo.addColumn("Ahorro por quincena");
            modelo.addColumn("Quincenas Ahorradas");//9
            modelo.addColumn("Total Ahorrado");
            modelo.addColumn("caja anticipada");//11
            modelo.addColumn("total a pagar");
            modelo.addColumn("% interes");//13
            modelo.addColumn("interes a pagar");
            modelo.addColumn("Por final pagar");//15
            modelo.addColumn("Status");
            modelo.addColumn("Observacion 1");//17
            modelo.addColumn("Observaciones");
//Anchos
            int[] anchos = {/*ndf*/35, /*nde*/ 35, /*ap*/ 55, /*am*/ 55, /*nom*/ 150,
                /*Zon*/ 60, /*serv*/ 75, /*APQ*/ 60, /*QA*/ 60, /*TA*/ 60, /*CA*/ 60,
                /*TAP*/ 50, /*PINT*/ 50, /*IAP*/ 55, /*PFP*/ 60, /*Status*/ 60, /*OBS1*/ 60,
                /*obs*/ 750};

            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                Tablacda.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException error_md_cda) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos de caja de ahorro: " + error_md_cda.getMessage());

        }

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PestañasPrin = new javax.swing.JTabbedPane();
        Cajadeahorro = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        numEcda = new javax.swing.JTextField();
        APcda = new javax.swing.JTextField();
        AMcda = new javax.swing.JTextField();
        namecda = new javax.swing.JTextField();
        zonacda = new javax.swing.JTextField();
        servcda = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        Numcda = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        Obscda = new javax.swing.JTextArea();
        jLabel118 = new javax.swing.JLabel();
        Filsharecda = new javax.swing.JComboBox<>();
        jLabel119 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        ShareCDA = new javax.swing.JTable();
        jLabel124 = new javax.swing.JLabel();
        TELC = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        Tablacda = new javax.swing.JTable();
        CalIn = new javax.swing.JCheckBox();
        jLabel125 = new javax.swing.JLabel();
        TIAP = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        Totalap = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        APQ = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        QAdas = new javax.swing.JTextField();
        TArrado = new javax.swing.JTextField();
        PorcenIn = new javax.swing.JTextField();
        CajaA = new javax.swing.JTextField();
        IAP = new javax.swing.JTextField();
        PPF = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        Obs1cda = new javax.swing.JComboBox<>();
        jLabel114 = new javax.swing.JLabel();
        Statuscda = new javax.swing.JComboBox<>();
        jLabel115 = new javax.swing.JLabel();
        Labelcda = new javax.swing.JLabel();
        BusAPcdash = new javax.swing.JTextField();
        BusAMcdash = new javax.swing.JTextField();
        Busnamecdash = new javax.swing.JTextField();
        Labelfilcda = new javax.swing.JLabel();
        BusnameCDA = new javax.swing.JTextField();
        AgregarCDA = new javax.swing.JButton();
        ModCDA = new javax.swing.JButton();
        jLabel162 = new javax.swing.JLabel();
        Filtroscda = new javax.swing.JComboBox<>();
        FilAPCDA = new javax.swing.JTextField();
        FillAMCDA = new javax.swing.JTextField();
        Eliminarcda = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        TPDCDA = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        NREcda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TPCDA = new javax.swing.JTable();
        jLabel150 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        obdpagocda = new javax.swing.JTextArea();
        jLabel152 = new javax.swing.JLabel();
        NFpagocda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel155 = new javax.swing.JLabel();
        FilPCDA = new javax.swing.JComboBox<>();
        labelpcda = new javax.swing.JLabel();
        FilnamePCDA = new javax.swing.JTextField();
        FilAPPCDA = new javax.swing.JTextField();
        FilAMPCDA = new javax.swing.JTextField();
        MMAPagos = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        MADE = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ADCDA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        NQna = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        NL = new javax.swing.JTextField();
        NC = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menuadm = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        ODT1 = new javax.swing.JMenuItem();
        CNQ1 = new javax.swing.JMenuItem();
        PRESQ1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        CDA1 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        ODT2 = new javax.swing.JMenuItem();
        CDA3 = new javax.swing.JMenuItem();
        LDA1 = new javax.swing.JMenuItem();
        LDA4 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        General = new javax.swing.JMenuItem();
        Estadias = new javax.swing.JMenuItem();
        Torteria = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        Depositos = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        ZYS = new javax.swing.JMenuItem();
        ADMV2 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        Nomsem = new javax.swing.JMenuItem();
        NomSemGen = new javax.swing.JMenuItem();
        PresSem = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        ODT = new javax.swing.JMenuItem();
        CNQ = new javax.swing.JMenuItem();
        PRES = new javax.swing.JMenuItem();
        NomGen = new javax.swing.JMenuItem();
        CDA = new javax.swing.JMenuItem();
        LDA = new javax.swing.JMenuItem();
        LDA3 = new javax.swing.JMenuItem();
        Reportes = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caja de ahorro");

        jLabel98.setText("# empleado:");

        jLabel101.setText("Apellido P:");

        jLabel102.setText("Apellido M");

        jLabel106.setText("Nombre(s):");

        jLabel108.setText("Zona:");

        jLabel109.setText("Servicio:");

        numEcda.setText("0");

        jLabel116.setText("# Caja:");

        Numcda.setText("0");

        jLabel117.setText("Observaciones:");

        Obscda.setColumns(20);
        Obscda.setLineWrap(true);
        Obscda.setRows(5);
        jScrollPane13.setViewportView(Obscda);

        jLabel118.setText("Filtros:");

        Filsharecda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona filtro", "Apellido P", "Apellido M", "Nombre(s)" }));
        Filsharecda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FilsharecdaItemStateChanged(evt);
            }
        });

        jLabel119.setText("Detalles de caja:");

        ShareCDA.setModel(new javax.swing.table.DefaultTableModel(
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
        ShareCDA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShareCDAMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(ShareCDA);

        jLabel124.setText("Total en la caja:");

        TELC.setText("0");

        Tablacda.setModel(new javax.swing.table.DefaultTableModel(
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
        Tablacda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablacdaMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(Tablacda);

        CalIn.setText("Calcular interes.");
        CalIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalInActionPerformed(evt);
            }
        });

        jLabel125.setText("Total interes a pagar:");

        TIAP.setText("0");

        jLabel110.setText("Ahorro por Sem:");

        jLabel120.setText("Total a pagar:");

        jLabel111.setText("Sem ahorradas:");

        jLabel112.setText("Total ahorrado:");

        Totalap.setText("0");

        jLabel121.setText("% Interes:");

        jLabel113.setText("Caja anticipada:");

        jLabel122.setText("Interes a pagar:");

        APQ.setText("0");
        APQ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                APQKeyReleased(evt);
            }
        });

        jLabel123.setText("Por pagar final:");

        QAdas.setText("0");
        QAdas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                QAdasKeyReleased(evt);
            }
        });

        TArrado.setText("0");

        PorcenIn.setText("0");

        CajaA.setText("0");
        CajaA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CajaAKeyReleased(evt);
            }
        });

        IAP.setText("0");

        PPF.setText("0");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel123)
                    .addComponent(jLabel122)
                    .addComponent(jLabel113)
                    .addComponent(jLabel112)
                    .addComponent(jLabel111)
                    .addComponent(jLabel110)
                    .addComponent(jLabel120)
                    .addComponent(jLabel121))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(CajaA, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TArrado)
                        .addComponent(Totalap, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(QAdas, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(APQ, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(PorcenIn, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(IAP, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(APQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111)
                    .addComponent(QAdas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(TArrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(CajaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(Totalap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel121)
                    .addComponent(PorcenIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel122)
                    .addComponent(IAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel123)
                    .addComponent(PPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Obs1cda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "ABANDONA", "PAGADA", "DEBE" }));

        jLabel114.setText("Status:");

        Statuscda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "BAJA", "BAJA TEMPORAL", "SALE DE CAJA", "VIGENTE" }));

        jLabel115.setText("Observacione 1:");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel115)
                    .addComponent(jLabel114))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Statuscda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Obs1cda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(Statuscda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(Obs1cda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        Labelcda.setText("jLabel126");

        BusAPcdash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BusAPcdashKeyReleased(evt);
            }
        });

        BusAMcdash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BusAMcdashKeyReleased(evt);
            }
        });

        Busnamecdash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BusnamecdashKeyReleased(evt);
            }
        });

        Labelfilcda.setText("Buscar por nombre(s):");

        BusnameCDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BusnameCDAKeyReleased(evt);
            }
        });

        AgregarCDA.setText("Agregar");
        AgregarCDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarCDAActionPerformed(evt);
            }
        });

        ModCDA.setText("Modificar");
        ModCDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModCDAActionPerformed(evt);
            }
        });

        jLabel162.setText("Filtros:");

        Filtroscda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona filtro", "Apellido P", "Apellido M", "Nombre(s)" }));
        Filtroscda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FiltroscdaItemStateChanged(evt);
            }
        });

        FilAPCDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FilAPCDAKeyReleased(evt);
            }
        });

        FillAMCDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FillAMCDAKeyReleased(evt);
            }
        });

        Eliminarcda.setText("Eliminar");
        Eliminarcda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarcdaActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Microsoft-Excel-Logo.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel118)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Filsharecda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Labelcda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BusAPcdash, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BusAMcdash, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Busnamecdash, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel116)
                            .addComponent(jLabel98)
                            .addComponent(jLabel101)
                            .addComponent(jLabel102))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(APcda)
                            .addComponent(AMcda)
                            .addComponent(numEcda, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(Numcda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel109)
                            .addComponent(jLabel108)
                            .addComponent(jLabel106))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(servcda, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(zonacda)
                            .addComponent(namecda)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(jLabel119))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CalIn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(jLabel117))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel125)
                                            .addComponent(jLabel124))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TELC)
                                            .addComponent(TIAP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(AgregarCDA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ModCDA)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel162)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Filtroscda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Labelfilcda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BusnameCDA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FilAPCDA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FillAMCDA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Eliminarcda))
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 2500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(Numcda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel118)
                    .addComponent(Filsharecda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Labelcda)
                    .addComponent(BusAPcdash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusAMcdash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Busnamecdash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel106)
                                .addComponent(namecda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel108)
                                .addComponent(zonacda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel109)
                                .addComponent(servcda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel98)
                                .addComponent(numEcda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel101)
                                .addComponent(APcda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel102)
                                .addComponent(AMcda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel119)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel117)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel124)
                                    .addComponent(TELC))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel125)
                                    .addComponent(TIAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CalIn)
                                .addGap(59, 59, 59)))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AgregarCDA)
                            .addComponent(ModCDA))
                        .addGap(0, 309, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Labelfilcda)
                                .addComponent(BusnameCDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel162)
                                .addComponent(Filtroscda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FilAPCDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FillAMCDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Eliminarcda)
                                    .addComponent(jLabel4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Cajadeahorro.setViewportView(jPanel14);

        PestañasPrin.addTab("Caja de ahorro", Cajadeahorro);

        jLabel129.setText("# recibo entregado");

        TPCDA.setModel(new javax.swing.table.DefaultTableModel(
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
        TPCDA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TPCDAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TPCDA);

        jLabel150.setText("Observaciones:");

        obdpagocda.setColumns(20);
        obdpagocda.setRows(5);
        jScrollPane16.setViewportView(obdpagocda);

        jLabel152.setText("# Folio");

        NFpagocda.setEnabled(false);

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel155.setText("Filtro:");

        FilPCDA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona filtro", "Apellido P", "Apellido M", "Nombre(s)" }));
        FilPCDA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FilPCDAItemStateChanged(evt);
            }
        });

        labelpcda.setText("jLabel156");

        FilnamePCDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FilnamePCDAKeyReleased(evt);
            }
        });

        FilAPPCDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FilAPPCDAKeyReleased(evt);
            }
        });

        FilAMPCDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FilAMPCDAKeyReleased(evt);
            }
        });

        MMAPagos.setText("Mostrar monto ahorrado");
        MMAPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MMAPagosActionPerformed(evt);
            }
        });

        jLabel1.setText("Monto Ahorrado del empleado:");

        MADE.setText("0");

        jLabel2.setText("Ajuste de caja:");

        ADCDA.setText("0");

        jLabel3.setText("# Quincena");

        NQna.setText("0");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Microsoft-Excel-Logo.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        NL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NLKeyReleased(evt);
            }
        });

        NC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NCKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel129)
                            .addComponent(jLabel150)
                            .addComponent(jLabel152)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(NQna, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ADCDA, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NFpagocda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(NREcda, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addComponent(jButton1)
                    .addComponent(MMAPagos)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MADE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel155)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FilPCDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelpcda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FilnamePCDA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FilAPPCDA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FilAMPCDA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addContainerGap(713, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel152)
                    .addComponent(NFpagocda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel155)
                    .addComponent(FilPCDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelpcda)
                    .addComponent(FilnamePCDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FilAPPCDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FilAMPCDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(NL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel129)
                            .addComponent(NREcda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ADCDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(NQna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel150)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MMAPagos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(MADE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE))
                .addContainerGap())
        );

        TPDCDA.setViewportView(jPanel1);

        PestañasPrin.addTab("Tabla pagos de caja de ahorro", TPDCDA);

        Menuadm.setText("Todas las ventanas");

        jMenu5.setText("Area Nomina");

        jMenu6.setText("Nomina quincenal");

        ODT1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ODT1.setText("Ordenes de taller");
        ODT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ODT1ActionPerformed(evt);
            }
        });
        jMenu6.add(ODT1);

        CNQ1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CNQ1.setText("Nomina IMSS");
        CNQ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNQ1ActionPerformed(evt);
            }
        });
        jMenu6.add(CNQ1);

        PRESQ1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        PRESQ1.setText("Prestamos");
        PRESQ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRESQ1ActionPerformed(evt);
            }
        });
        jMenu6.add(PRESQ1);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem8.setText("Nomina General");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        CDA1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CDA1.setText("Caja de ahorro");
        CDA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDA1ActionPerformed(evt);
            }
        });
        jMenu6.add(CDA1);

        jMenu5.add(jMenu6);

        jMenu7.setText("Semanal");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem9.setText("Nomina Semanal IMSS");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem10.setText("Prestamos Semanales");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem11.setText("Nomina Semanal General");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem11);

        ODT2.setText("Ordenes de taller");
        ODT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ODT2ActionPerformed(evt);
            }
        });
        jMenu7.add(ODT2);

        CDA3.setText("Caja de ahorro");
        CDA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDA3ActionPerformed(evt);
            }
        });
        jMenu7.add(CDA3);

        jMenu5.add(jMenu7);

        LDA1.setText("Listas de asistencia C/IMSS ");
        LDA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LDA1ActionPerformed(evt);
            }
        });
        jMenu5.add(LDA1);

        LDA4.setText("Listas de asistencia S/IMSS");
        LDA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LDA4ActionPerformed(evt);
            }
        });
        jMenu5.add(LDA4);

        Menuadm.add(jMenu5);

        jMenu8.setText("Area RH");

        General.setText("Empleados General");
        General.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneralActionPerformed(evt);
            }
        });
        jMenu8.add(General);

        Estadias.setText("Alumno de estadia");
        Estadias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadiasActionPerformed(evt);
            }
        });
        jMenu8.add(Estadias);

        Torteria.setText("Empleados Torteria");
        Torteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TorteriaActionPerformed(evt);
            }
        });
        jMenu8.add(Torteria);

        jMenu9.setText("Semanales");

        jMenuItem13.setText("Inturbide");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem13);

        jMenuItem14.setText("Tehuantepec");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem14);

        jMenuItem15.setText("PTE titla");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem15);

        jMenu8.add(jMenu9);

        Depositos.setText("Depositos");

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem16.setText("Depositos C/ IMSS");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        Depositos.add(jMenuItem16);

        jMenu8.add(Depositos);

        Menuadm.add(jMenu8);

        ZYS.setText("Zonas y Servicios");
        ZYS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZYSActionPerformed(evt);
            }
        });
        Menuadm.add(ZYS);

        ADMV2.setText("Usuarios");
        ADMV2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMV2ActionPerformed(evt);
            }
        });
        Menuadm.add(ADMV2);

        jMenuItem7.setText("Edicion Pagos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        Menuadm.add(jMenuItem7);

        jMenuBar1.add(Menuadm);

        jMenu4.setText("Cambiar a:");

        jMenu10.setText("Semanal");

        Nomsem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        Nomsem.setText("Nomina Semanal IMSS");
        Nomsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomsemActionPerformed(evt);
            }
        });
        jMenu10.add(Nomsem);

        NomSemGen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        NomSemGen.setText("Nomina Semanal General");
        NomSemGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomSemGenActionPerformed(evt);
            }
        });
        jMenu10.add(NomSemGen);

        PresSem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        PresSem.setText("Prestamos Semanales");
        PresSem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PresSemActionPerformed(evt);
            }
        });
        jMenu10.add(PresSem);

        jMenu4.add(jMenu10);

        jMenu11.setText("Nomina quincenal");

        ODT.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ODT.setText("Ordenes de taller");
        ODT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ODTActionPerformed(evt);
            }
        });
        jMenu11.add(ODT);

        CNQ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CNQ.setText("Nomina IMSS");
        CNQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNQActionPerformed(evt);
            }
        });
        jMenu11.add(CNQ);

        PRES.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        PRES.setText("Prestamos");
        PRES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRESActionPerformed(evt);
            }
        });
        jMenu11.add(PRES);

        NomGen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
        NomGen.setText("Nomina General");
        NomGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomGenActionPerformed(evt);
            }
        });
        jMenu11.add(NomGen);

        CDA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CDA.setText("Caja de ahorro");
        CDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDAActionPerformed(evt);
            }
        });
        jMenu11.add(CDA);

        jMenu4.add(jMenu11);

        LDA.setText("Listas de asistencia C/IMSS ");
        LDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LDAActionPerformed(evt);
            }
        });
        jMenu4.add(LDA);

        LDA3.setText("Listas de asistencia S/IMSS");
        LDA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LDA3ActionPerformed(evt);
            }
        });
        jMenu4.add(LDA3);

        jMenuBar1.add(jMenu4);

        Reportes.setText("Reportes");

        jMenuItem6.setText("Reportes de nomina");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        Reportes.add(jMenuItem6);

        jMenuItem17.setText("Reportes de nomina sem");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        Reportes.add(jMenuItem17);

        jMenuBar1.add(Reportes);

        jMenu1.setText("Seguridad.");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IcoCDU.png"))); // NOI18N
        jMenuItem2.setText("Cambiar de usuario");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PestañasPrin, javax.swing.GroupLayout.DEFAULT_SIZE, 1640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PestañasPrin, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FilsharecdaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FilsharecdaItemStateChanged
        String dt = (String) Filsharecda.getSelectedItem();
        if (dt.equals("Selecciona filtro")) {
            Labelcda.setVisible(false);
            Busnamecdash.setVisible(false);
            Busnamecdash.setText("");
            BusAPcdash.setText("");
            BusAPcdash.setVisible(false);
            BusAMcdash.setText("");
            BusAMcdash.setVisible(false);
            sharecda();
        }
        if (dt.equals("Apellido P")) {
            Labelcda.setVisible(true);
            Labelcda.setText("Buscar por Apellido P:");
            Busnamecdash.setVisible(false);
            Busnamecdash.setText("");
            BusAPcdash.setText("");
            BusAPcdash.setVisible(true);
            BusAMcdash.setText("");
            BusAMcdash.setVisible(false);
            sharecda();

        }
        if (dt.equals("Apellido M")) {
            Labelcda.setVisible(true);
            Labelcda.setText("Buscar por Apellido M:");
            Busnamecdash.setVisible(false);
            Busnamecdash.setText("");
            BusAPcdash.setText("");
            BusAPcdash.setVisible(false);
            BusAMcdash.setText("");
            BusAMcdash.setVisible(true);
            sharecda();

        }
        if (dt.equals("Nombre(s)")) {
            Labelcda.setVisible(true);
            Labelcda.setText("Buscar por Nombre(s):");
            Busnamecdash.setVisible(true);
            Busnamecdash.setText("");
            BusAPcdash.setText("");
            BusAPcdash.setVisible(false);
            BusAMcdash.setText("");
            BusAMcdash.setVisible(false);
            sharecda();

        }
    }//GEN-LAST:event_FilsharecdaItemStateChanged

    private void ShareCDAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShareCDAMouseClicked

        int fila = ShareCDA.getSelectedRow();
        numEcda.setText(String.valueOf(ShareCDA.getValueAt(fila, 0)));
        APcda.setText(String.valueOf(ShareCDA.getValueAt(fila, 1)));
        AMcda.setText(String.valueOf(ShareCDA.getValueAt(fila, 2)));
        namecda.setText(String.valueOf(ShareCDA.getValueAt(fila, 3)));
        zonacda.setText(String.valueOf(ShareCDA.getValueAt(fila, 4)));
        servcda.setText(String.valueOf(ShareCDA.getValueAt(fila, 5)));
    }//GEN-LAST:event_ShareCDAMouseClicked

    private void TablacdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablacdaMouseClicked
        DefaultTableModel model = (DefaultTableModel) Tablacda.getModel();

        int fila = Tablacda.getSelectedRow();
        Numcda.setText(String.valueOf(Tablacda.getValueAt(fila, 0)));
        numEcda.setText(String.valueOf(Tablacda.getValueAt(fila, 1)));
        APcda.setText(String.valueOf(Tablacda.getValueAt(fila, 2)));
        AMcda.setText(String.valueOf(Tablacda.getValueAt(fila, 3)));
        namecda.setText(String.valueOf(Tablacda.getValueAt(fila, 4)));
        zonacda.setText(String.valueOf(Tablacda.getValueAt(fila, 5)));
        servcda.setText(String.valueOf(Tablacda.getValueAt(fila, 6)));
        APQ.setText(String.valueOf(Tablacda.getValueAt(fila, 7)));
        QAdas.setText(String.valueOf(Tablacda.getValueAt(fila, 8)));
        TArrado.setText(String.valueOf(Tablacda.getValueAt(fila, 9)));
        CajaA.setText(String.valueOf(Tablacda.getValueAt(fila, 10)));
        Totalap.setText(String.valueOf(Tablacda.getValueAt(fila, 11)));
        PorcenIn.setText(String.valueOf(Tablacda.getValueAt(fila, 12)));
        IAP.setText(String.valueOf(Tablacda.getValueAt(fila, 13)));
        PPF.setText(String.valueOf(Tablacda.getValueAt(fila, 14)));

        Obscda.setText(String.valueOf(Tablacda.getValueAt(fila, 17)));
        String combo1 = model.getValueAt(fila, 15).toString();
        for (int i = 0; i < Statuscda.getItemCount(); i++) {
            if (Statuscda.getItemAt(i).equalsIgnoreCase(combo1)) {
                Statuscda.setSelectedIndex(i);
            }
        }
        //Combobo2
        String combo3 = model.getValueAt(fila, 16).toString();
        for (int i = 0; i < Obs1cda.getItemCount(); i++) {
            if (Obs1cda.getItemAt(i).equalsIgnoreCase(combo3)) {
                Obs1cda.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_TablacdaMouseClicked

    private void CalInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalInActionPerformed
        if (CalIn.isSelected() == true) {

            double TA = Double.parseDouble(this.TArrado.getText());
            double Tcaja = Double.parseDouble(this.TELC.getText());
            double totalinteres = ((TA * 100) / (Tcaja)) / 100;
            PorcenIn.setText("" + (totalinteres) * 100);

            double Piin = Double.parseDouble(this.PorcenIn.getText());
            double TotalintP = Double.parseDouble(this.TIAP.getText());

            IAP.setText("" + ((Piin / 100) * TotalintP));

            double TAPagar = Double.parseDouble(this.Totalap.getText());
            double IApagar = Double.parseDouble(this.IAP.getText());
            PPF.setText("" + ((TAPagar) + IApagar));

        } else if (CalIn.isSelected() == false) {
            PorcenIn.setText("0");

        }
    }//GEN-LAST:event_CalInActionPerformed

    private void APQKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_APQKeyReleased
        //operacion quincenas cde caja de ahorro
        double APQna = Double.parseDouble(this.APQ.getText());
        double QA = Double.parseDouble(this.QAdas.getText());
        double totalahorrado = APQna * QA;
        TArrado.setText("" + totalahorrado);

        double TA = Double.parseDouble(this.TArrado.getText());
        double CA = Double.parseDouble(this.CajaA.getText());
        double totalpagar = TA - CA;
        Totalap.setText("" + totalpagar);
    }//GEN-LAST:event_APQKeyReleased

    private void QAdasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QAdasKeyReleased
        double APQna = Double.parseDouble(this.APQ.getText());
        double QA = Double.parseDouble(this.QAdas.getText());
        double totalahorrado = APQna * QA;
        TArrado.setText("" + totalahorrado);

        double TA = Double.parseDouble(this.TArrado.getText());
        double CA = Double.parseDouble(this.CajaA.getText());
        double totalpagar = TA - CA;
        Totalap.setText("" + totalpagar);
    }//GEN-LAST:event_QAdasKeyReleased

    private void CajaAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CajaAKeyReleased
        double TA = Double.parseDouble(this.TArrado.getText());
        double CA = Double.parseDouble(this.CajaA.getText());
        double totalpagar = TA - CA;
        Totalap.setText("" + totalpagar);
    }//GEN-LAST:event_CajaAKeyReleased

    private void BusAPcdashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BusAPcdashKeyReleased
        sharecda();
    }//GEN-LAST:event_BusAPcdashKeyReleased

    private void BusAMcdashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BusAMcdashKeyReleased
        sharecda();
    }//GEN-LAST:event_BusAMcdashKeyReleased

    private void BusnamecdashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BusnamecdashKeyReleased
        sharecda();
    }//GEN-LAST:event_BusnamecdashKeyReleased

    private void BusnameCDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BusnameCDAKeyReleased
        MDCDA();
    }//GEN-LAST:event_BusnameCDAKeyReleased

    private void AgregarCDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarCDAActionPerformed
        AgregarCDA();
        MDCDA();
        sumaTA();
    }//GEN-LAST:event_AgregarCDAActionPerformed

    private void ModCDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModCDAActionPerformed
        editarCDA();
        MDCDA();
        sumaTA();
    }//GEN-LAST:event_ModCDAActionPerformed

    private void FiltroscdaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FiltroscdaItemStateChanged
        String FTP = (String) Filtroscda.getSelectedItem();
        if (FTP.equals("Selecciona filtro")) {
            Labelfilcda.setVisible(false);
            BusnameCDA.setVisible(false);
            BusnameCDA.setText("");
            FilAPCDA.setText("");
            FilAPCDA.setVisible(false);
            FillAMCDA.setText("");
            FillAMCDA.setVisible(false);
            MDCDA();
        }
        if (FTP.equals("Apellido P")) {
            Labelfilcda.setVisible(true);
            Labelfilcda.setText("Buscar por Apellido P:");
            BusnameCDA.setVisible(false);
            BusnameCDA.setText("");
            FilAPCDA.setText("");
            FilAPCDA.setVisible(true);
            FillAMCDA.setText("");
            FillAMCDA.setVisible(false);
            MDCDA();
        }
        if (FTP.equals("Apellido M")) {
            Labelfilcda.setVisible(true);
            Labelfilcda.setText("Buscar por Apellido M:");
            BusnameCDA.setVisible(false);
            BusnameCDA.setText("");
            FilAPCDA.setText("");
            FilAPCDA.setVisible(false);
            FillAMCDA.setText("");
            FillAMCDA.setVisible(true);
            MDCDA();
        }
        if (FTP.equals("Nombre(s)")) {
            Labelfilcda.setVisible(true);
            Labelfilcda.setText("Buscar por Nombre(s):");
            BusnameCDA.setVisible(true);
            BusnameCDA.setText("");
            FilAPCDA.setText("");
            FilAPCDA.setVisible(false);
            FillAMCDA.setText("");
            FillAMCDA.setVisible(false);
            MDCDA();

        }
    }//GEN-LAST:event_FiltroscdaItemStateChanged

    private void FilAPCDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilAPCDAKeyReleased
        MDCDA();
    }//GEN-LAST:event_FilAPCDAKeyReleased

    private void FillAMCDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FillAMCDAKeyReleased
        MDCDA();
    }//GEN-LAST:event_FillAMCDAKeyReleased

    private void EliminarcdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarcdaActionPerformed
        try {

            int filaseleccionada = Tablacda.getSelectedRow();
            String sql = "delete from `nominasem.cajadeahorro` where #caja=" + Tablacda.getValueAt(filaseleccionada, 0);
            java.sql.Statement st = con.createStatement();
            int n = st.executeUpdate(sql);
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Caja de ahorro eliminada eliminada.");
            }
        } catch (HeadlessException | SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al eliminar Caja de ahorro: " + e.getMessage());

        }
    }//GEN-LAST:event_EliminarcdaActionPerformed

    private void TPCDAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPCDAMouseClicked
        int fila = TPCDA.getSelectedRow();
        NFpagocda.setText(String.valueOf(TPCDA.getValueAt(fila, 0)));
        NQna.setText(String.valueOf(TPCDA.getValueAt(fila, 12)));
        ADCDA.setText(String.valueOf(TPCDA.getValueAt(fila, 10)));
        obdpagocda.setText(String.valueOf(TPCDA.getValueAt(fila, 11)));
        NREcda.setText(String.valueOf(TPCDA.getValueAt(fila, 13)));
    }//GEN-LAST:event_TPCDAMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MODPAGOCDA();
        MDTPCDA();
        if (MMAPagos.isSelected() == true) {
            double t = 0;
            double p;
            if (TPCDA.getRowCount() > 0) {
                for (int i = 0; i < TPCDA.getRowCount(); i++) {
                    p = Double.parseDouble(TPCDA.getValueAt(i, 10).toString());
                    t += p;
                }
                MADE.setText("" + t);
            } else {

            }
        }
        if (MMAPagos.isSelected() == false) {
            MADE.setText("0");

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void FilPCDAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FilPCDAItemStateChanged
        String FTP = (String) FilPCDA.getSelectedItem();
        if (FTP.equals("Selecciona filtro")) {
            NL.setVisible(false);
            NL.setText("");
            NC.setText("");
            NC.setVisible(false);
            labelpcda.setVisible(false);
            FilnamePCDA.setVisible(false);
            FilnamePCDA.setText("");
            FilAPPCDA.setText("");
            FilAPPCDA.setVisible(false);
            FilAMPCDA.setText("");
            FilAMPCDA.setVisible(false);
            MDTPCDA();
        }
        if (FTP.equals("Apellido P")) {
            NL.setVisible(false);
            NC.setVisible(false);
            NL.setText("");
            NC.setText("");
            labelpcda.setVisible(true);
            labelpcda.setText("Buscar por Apellido P:");
            FilnamePCDA.setVisible(false);
            FilnamePCDA.setText("");
            FilAPPCDA.setText("");
            FilAPPCDA.setVisible(true);
            FilAMPCDA.setText("");
            FilAMPCDA.setVisible(false);
            MDTPCDA();
        }
        if (FTP.equals("Apellido M")) {
            NL.setVisible(false);
            NC.setVisible(false);
            NL.setText("");
            NC.setText("");
            labelpcda.setVisible(true);
            labelpcda.setText("Buscar por Apellido M:");
            FilnamePCDA.setVisible(false);
            FilnamePCDA.setText("");
            FilAPPCDA.setText("");
            FilAPPCDA.setVisible(false);
            FilAMPCDA.setText("");
            FilAMPCDA.setVisible(true);
            MDTPCDA();
        }
        if (FTP.equals("Nombre(s)")) {
            NL.setVisible(false);
            NC.setVisible(false);
            NL.setText("");
            NC.setText("");
            labelpcda.setVisible(true);
            labelpcda.setText("Buscar por Nombre(s):");
            FilnamePCDA.setVisible(true);
            FilnamePCDA.setText("");
            FilAPPCDA.setText("");
            FilAPPCDA.setVisible(false);
            FilAMPCDA.setText("");
            FilAMPCDA.setVisible(false);
            MDTPCDA();

        }
        if (FTP.equals("# Lista")) {
            NL.setVisible(true);
            NC.setVisible(false);
            NL.setText("");
            NC.setText("");
            labelpcda.setVisible(true);
            labelpcda.setText("Buscar por # Lista:");
            FilnamePCDA.setVisible(false);
            FilnamePCDA.setText("");
            FilAPPCDA.setText("");
            FilAPPCDA.setVisible(false);
            FilAMPCDA.setText("");
            FilAMPCDA.setVisible(false);
            MDTPCDA();

        }
        if (FTP.equals("# Caja")) {
            NL.setVisible(false);
            NC.setVisible(true);
            NL.setText("");
            NC.setText("");
            labelpcda.setVisible(true);
            labelpcda.setText("Buscar por # Caja:");
            FilnamePCDA.setVisible(false);
            FilnamePCDA.setText("");
            FilAPPCDA.setText("");
            FilAPPCDA.setVisible(false);
            FilAMPCDA.setText("");
            FilAMPCDA.setVisible(false);
            MDTPCDA();

        }
    }//GEN-LAST:event_FilPCDAItemStateChanged

    private void FilnamePCDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilnamePCDAKeyReleased
        MDTPCDA();
        if (MMAPagos.isSelected() == true) {
            double t = 0;
            double p;
            if (TPCDA.getRowCount() > 0) {
                for (int i = 0; i < TPCDA.getRowCount(); i++) {
                    p = Double.parseDouble(TPCDA.getValueAt(i, 10).toString());
                    t += p;
                }
                MADE.setText("" + t);
            } else {

            }
        }
        if (MMAPagos.isSelected() == false) {
            MADE.setText("0");

        }
    }//GEN-LAST:event_FilnamePCDAKeyReleased

    private void FilAPPCDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilAPPCDAKeyReleased
        MDTPCDA();
        if (MMAPagos.isSelected() == true) {
            double t = 0;
            double p;
            if (TPCDA.getRowCount() > 0) {
                for (int i = 0; i < TPCDA.getRowCount(); i++) {
                    p = Double.parseDouble(TPCDA.getValueAt(i, 10).toString());
                    t += p;
                }
                MADE.setText("" + t);
            } else {

            }
        }
        if (MMAPagos.isSelected() == false) {
            MADE.setText("0");

        }
    }//GEN-LAST:event_FilAPPCDAKeyReleased

    private void FilAMPCDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilAMPCDAKeyReleased
        MDTPCDA();
        if (MMAPagos.isSelected() == true) {
            double t = 0;
            double p;
            if (TPCDA.getRowCount() > 0) {
                for (int i = 0; i < TPCDA.getRowCount(); i++) {
                    p = Double.parseDouble(TPCDA.getValueAt(i, 10).toString());
                    t += p;
                }
                MADE.setText("" + t);
            } else {

            }
        }
        if (MMAPagos.isSelected() == false) {
            MADE.setText("0");

        }
    }//GEN-LAST:event_FilAMPCDAKeyReleased

    private void CNQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNQActionPerformed
        NominaQ_5 regr = new NominaQ_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CNQActionPerformed

    private void MMAPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MMAPagosActionPerformed
        if (MMAPagos.isSelected() == true) {
            double t = 0;
            double p;
            if (TPCDA.getRowCount() > 0) {
                for (int i = 0; i < TPCDA.getRowCount(); i++) {
                    p = Double.parseDouble(TPCDA.getValueAt(i, 10).toString());
                    t += p;
                }
                MADE.setText("" + t);
            } else {

            }
        }
        if (MMAPagos.isSelected() == false) {
            MADE.setText("0");

        }
    }//GEN-LAST:event_MMAPagosActionPerformed

    private void ODT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ODT1ActionPerformed
        ODTQ_5 regr = new ODTQ_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ODT1ActionPerformed

    private void CNQ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNQ1ActionPerformed
        NominaQ_5 regr = new NominaQ_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CNQ1ActionPerformed

    private void PRESQ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRESQ1ActionPerformed
        PresQ_5 regr = new PresQ_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PRESQ1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        NominaQSiMSS_5 regr = new NominaQSiMSS_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void CDA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDA1ActionPerformed
        CDAS_5 regr = new CDAS_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CDA1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        NominaS_5 regr = new NominaS_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        PresS_5 regr = new PresS_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        NominaS_simss_5 regr = new NominaS_simss_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void GeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneralActionPerformed

        Empleados_4 RH = new Empleados_4(usr, LP);
        RH.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_GeneralActionPerformed

    private void EstadiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadiasActionPerformed
        Estadias_4 regr = new Estadias_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EstadiasActionPerformed

    private void TorteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TorteriaActionPerformed
        Tortas_4 regr = new Tortas_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_TorteriaActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        Iturbide_4 regr = new Iturbide_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        Tehuantepec_4 regr = new Tehuantepec_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        PT_4 regr = new PT_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void ZYSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZYSActionPerformed
        AltasZyS_3 regr = new AltasZyS_3(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ZYSActionPerformed

    private void NomsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomsemActionPerformed
        NominaS_5 regr = new NominaS_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_NomsemActionPerformed

    private void NomSemGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomSemGenActionPerformed
        NominaS_simss_5 regr = new NominaS_simss_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_NomSemGenActionPerformed

    private void PresSemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PresSemActionPerformed
        PresS_5 regr = new PresS_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PresSemActionPerformed

    private void ODTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ODTActionPerformed
        ODTQ_5 regr = new ODTQ_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ODTActionPerformed

    private void PRESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRESActionPerformed
        PresQ_5 regr = new PresQ_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PRESActionPerformed

    private void NomGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomGenActionPerformed
        NominaQSiMSS_5 regr = new NominaQSiMSS_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_NomGenActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        RepNom_7 regr = new RepNom_7(usr, LP);
        regr.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        DepositosQ_4 regr = new DepositosQ_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void ADMV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMV2ActionPerformed
        VentanaADM_3 regr = new VentanaADM_3(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADMV2ActionPerformed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        Logica_bd_NomCDAS obj = new Logica_bd_NomCDAS();
        obj.BDRH();
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        Logica_bd_pagosCDAS obj = new Logica_bd_pagosCDAS();
        obj.BDRH();
    }//GEN-LAST:event_jLabel5MousePressed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        RepNomSem_7 regr = new RepNomSem_7();
        regr.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void CDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDAActionPerformed
        CDAQ_5 regr = new CDAQ_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CDAActionPerformed

    private void ODT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ODT2ActionPerformed
        ODTS_5 regr = new ODTS_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ODT2ActionPerformed

    private void CDA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDA3ActionPerformed
        CDAQ_5 regr = new CDAQ_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CDA3ActionPerformed

    private void LDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LDAActionPerformed
        Listas_CI_5 regr = new Listas_CI_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LDAActionPerformed

    private void LDA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LDA3ActionPerformed
        Listas_SI_5 regr = new Listas_SI_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LDA3ActionPerformed

    private void LDA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LDA1ActionPerformed
        Listas_CI_5 regr = new Listas_CI_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LDA1ActionPerformed

    private void LDA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LDA4ActionPerformed
        Listas_SI_5 regr = new Listas_SI_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LDA4ActionPerformed

    private void NLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NLKeyReleased
        MDTPCDA();
        if (MMAPagos.isSelected() == true) {
            double t = 0;
            double p;
            if (TPCDA.getRowCount() > 0) {
                for (int i = 0; i < TPCDA.getRowCount(); i++) {
                    p = Double.parseDouble(TPCDA.getValueAt(i, 10).toString());
                    t += p;
                }
                MADE.setText("" + t);
            } else {

            }
        }
        if (MMAPagos.isSelected() == false) {
            MADE.setText("0");

        }
    }//GEN-LAST:event_NLKeyReleased

    private void NCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NCKeyReleased
        MDTPCDA();
        if (MMAPagos.isSelected() == true) {
            double t = 0;
            double p;
            if (TPCDA.getRowCount() > 0) {
                for (int i = 0; i < TPCDA.getRowCount(); i++) {
                    p = Double.parseDouble(TPCDA.getValueAt(i, 10).toString());
                    t += p;
                }
                MADE.setText("" + t);
            } else {

            }
        }
        if (MMAPagos.isSelected() == false) {
            MADE.setText("0");

        }
    }//GEN-LAST:event_NCKeyReleased

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        EdicionPagos_3 regr = new EdicionPagos_3(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        int i = JOptionPane.showConfirmDialog(this, "El cambiar de usuario cerrara la ventana actual. \n ¿Seguir con esta accion?");
        if (i == 0) {
            Inicio_1 regr = new Inicio_1();
            regr.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(CDAS_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CDAS_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CDAS_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CDAS_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CDAS_5().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ADCDA;
    private javax.swing.JMenuItem ADMV2;
    private javax.swing.JTextField AMcda;
    private javax.swing.JTextField APQ;
    private javax.swing.JTextField APcda;
    private javax.swing.JButton AgregarCDA;
    private javax.swing.JTextField BusAMcdash;
    private javax.swing.JTextField BusAPcdash;
    private javax.swing.JTextField BusnameCDA;
    private javax.swing.JTextField Busnamecdash;
    private javax.swing.JMenuItem CDA;
    private javax.swing.JMenuItem CDA1;
    private javax.swing.JMenuItem CDA3;
    private javax.swing.JMenuItem CNQ;
    private javax.swing.JMenuItem CNQ1;
    private javax.swing.JTextField CajaA;
    private javax.swing.JScrollPane Cajadeahorro;
    private javax.swing.JCheckBox CalIn;
    private javax.swing.JMenu Depositos;
    private javax.swing.JButton Eliminarcda;
    private javax.swing.JMenuItem Estadias;
    private javax.swing.JTextField FilAMPCDA;
    private javax.swing.JTextField FilAPCDA;
    private javax.swing.JTextField FilAPPCDA;
    private javax.swing.JComboBox<String> FilPCDA;
    private javax.swing.JTextField FillAMCDA;
    private javax.swing.JTextField FilnamePCDA;
    private javax.swing.JComboBox<String> Filsharecda;
    private javax.swing.JComboBox<String> Filtroscda;
    private javax.swing.JMenuItem General;
    private javax.swing.JTextField IAP;
    private javax.swing.JMenuItem LDA;
    private javax.swing.JMenuItem LDA1;
    private javax.swing.JMenuItem LDA3;
    private javax.swing.JMenuItem LDA4;
    private javax.swing.JLabel Labelcda;
    private javax.swing.JLabel Labelfilcda;
    private javax.swing.JLabel MADE;
    private javax.swing.JCheckBox MMAPagos;
    private javax.swing.JMenu Menuadm;
    private javax.swing.JButton ModCDA;
    private javax.swing.JTextField NC;
    private javax.swing.JTextField NFpagocda;
    private javax.swing.JTextField NL;
    private javax.swing.JTextField NQna;
    private javax.swing.JTextField NREcda;
    private javax.swing.JMenuItem NomGen;
    private javax.swing.JMenuItem NomSemGen;
    private javax.swing.JMenuItem Nomsem;
    private javax.swing.JTextField Numcda;
    private javax.swing.JMenuItem ODT;
    private javax.swing.JMenuItem ODT1;
    private javax.swing.JMenuItem ODT2;
    private javax.swing.JComboBox<String> Obs1cda;
    private javax.swing.JTextArea Obscda;
    private javax.swing.JTextField PPF;
    private javax.swing.JMenuItem PRES;
    private javax.swing.JMenuItem PRESQ1;
    private javax.swing.JTabbedPane PestañasPrin;
    private javax.swing.JTextField PorcenIn;
    private javax.swing.JMenuItem PresSem;
    private javax.swing.JTextField QAdas;
    private javax.swing.JMenu Reportes;
    private javax.swing.JTable ShareCDA;
    private javax.swing.JComboBox<String> Statuscda;
    private javax.swing.JTextField TArrado;
    private javax.swing.JLabel TELC;
    private javax.swing.JTextField TIAP;
    private javax.swing.JTable TPCDA;
    private javax.swing.JScrollPane TPDCDA;
    private javax.swing.JTable Tablacda;
    private javax.swing.JMenuItem Torteria;
    private javax.swing.JTextField Totalap;
    private javax.swing.JMenuItem ZYS;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JLabel labelpcda;
    private javax.swing.JTextField namecda;
    private javax.swing.JTextField numEcda;
    private javax.swing.JTextArea obdpagocda;
    private javax.swing.JTextField servcda;
    private javax.swing.JTextField zonacda;
    // End of variables declaration//GEN-END:variables
}
