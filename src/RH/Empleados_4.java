package RH;

import Nomina.Listas.*;
import Semanal.PT_4;
import Semanal.Tehuantepec_4;
import Semanal.Iturbide_4;
import Nomina.ModulosS.CDAS_5;
import Nomina.ModulosS.ODTS_5;
import Nomina.ModulosS.PresS_5;
import Nomina.ModulosQ.CDAQ_5;
import Nomina.ModulosQ.ODTQ_5;
import Nomina.ModulosQ.PresQ_5;
import Nomina.*;
import Admin.*;
import Conexion.ConexionSQL;
import Filtros.FiltroServ;
import Filtros.FiltrosZonas;
import ColoresT.ColorRH;
import Inicio.Inicio_1;
import Logicas.*;
import Logicas.BDRH.Logica_bd_RHIMSS;
import RH.Depositos.DepositosQ_4;
import RH.Depositos.DepositosQ_SIMSS_4;
import RH.Depositos.DepositosS_4;
import RH.Depositos.DepositosS_SIMSS_4;
import RH.Depositos.Santander.DepositosQSan_4;
import RH.Depositos.Santander.DepositosQsan_SIMSS_4;
import RH.Depositos.Santander.DepositosSSan_4;
import RH.Depositos.Santander.DepositosSSan_SIMSS_4;
import RH.Expedientes.Datos;
import RH.Expedientes.Expedientes_4;
import Semanal.Padrones.Padrones;
import Semanal.Vales.Rvales;
import Semanal.Vales.VDE;
import ZyS.Servicios;
import ZyS.Zonas;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JDeat
 */
public final class Empleados_4 extends javax.swing.JFrame {

    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion();
    ColorRH colores = new ColorRH();
    Logica_usuarios usr;
    Logica_permisos LP;
    Datos dat = new Datos();

    public Empleados_4() {
        initComponents();
        data.setDefaultRenderer(data.getColumnClass(0), colores);
        this.setExtendedState(6);
        namesimss.setVisible(false);
        expFimss.setVisible(false);
        ApimssF.setVisible(false);
        AmimssF.setVisible(false);
        FdiimssF.setVisible(false);
        nssimssF.setVisible(false);
        rfcimssF.setVisible(false);
        curpimssF.setVisible(false);
        FBimssF.setVisible(false);
        FZimss.setVisible(false);
        PuestoimssF.setVisible(false);
        StatusimssF.setVisible(false);
        Nfilimss.setVisible(false);
        Zonas zz = new Zonas();
        DefaultComboBoxModel modelzonas = new DefaultComboBoxModel(zz.mostrarzonas());
        zona.setModel(modelzonas);
        elim.setVisible(false);
        FiltrosZonas FZS = new FiltrosZonas();
        DefaultComboBoxModel MODELFZS = new DefaultComboBoxModel(FZS.mostrarzonas());
        FiltroZGe.setModel(MODELFZS);
        FiltrosZonas xd = new FiltrosZonas();
        DefaultComboBoxModel modelzonass = new DefaultComboBoxModel(xd.mostrarzonas());
        FiltroSZGen.setModel(modelzonass);
        FiltrosZonas imss = new FiltrosZonas();
        DefaultComboBoxModel zonasimss = new DefaultComboBoxModel(imss.mostrarzonas());
        FZimss.setModel(zonasimss);
        FiltroNG.setVisible(false);
        Filtroam.setVisible(false);
        Filtroap.setVisible(false);
        LabelF1.setVisible(false);
        LabelF2.setVisible(false);
        FiltroCurpGen.setVisible(false);
        FiltroFDI.setVisible(false);
        FiltroNSSGen.setVisible(false);
        FiltroSZGen.setVisible(false);
        FiltroStatus.setVisible(false);
        FiltroServGen.setVisible(false);
        FiltroZGe.setVisible(false);
        Filobs.setVisible(false);
        setIconImage(new ImageIcon(Empleados_4.class.getClassLoader().getResource("Imagenes/Icono.png")).getImage());
        MDEm();
        MDIMSS();
    }

    public Empleados_4(Logica_usuarios usr, Logica_permisos LP) {
        initComponents();
        this.usr = usr;
        this.LP = LP;
        data.setDefaultRenderer(data.getColumnClass(0), colores);
        this.setExtendedState(6);
        namesimss.setVisible(false);
        expFimss.setVisible(false);
        ApimssF.setVisible(false);
        AmimssF.setVisible(false);
        FdiimssF.setVisible(false);
        nssimssF.setVisible(false);
        rfcimssF.setVisible(false);
        curpimssF.setVisible(false);
        FBimssF.setVisible(false);
        FZimss.setVisible(false);
        PuestoimssF.setVisible(false);
        StatusimssF.setVisible(false);
        Nfilimss.setVisible(false);
        Zonas zz = new Zonas();
        DefaultComboBoxModel modelzonas = new DefaultComboBoxModel(zz.mostrarzonas());
        zona.setModel(modelzonas);
        elim.setVisible(false);
        FiltrosZonas FZS = new FiltrosZonas();
        DefaultComboBoxModel MODELFZS = new DefaultComboBoxModel(FZS.mostrarzonas());
        FiltroZGe.setModel(MODELFZS);
        FiltrosZonas xd = new FiltrosZonas();
        DefaultComboBoxModel modelzonass = new DefaultComboBoxModel(xd.mostrarzonas());
        FiltroSZGen.setModel(modelzonass);
        FiltrosZonas imss = new FiltrosZonas();
        DefaultComboBoxModel zonasimss = new DefaultComboBoxModel(imss.mostrarzonas());
        FZimss.setModel(zonasimss);
        FiltroNG.setVisible(false);
        Filtroam.setVisible(false);
        Filtroap.setVisible(false);
        LabelF1.setVisible(false);
        LabelF2.setVisible(false);
        FiltroCurpGen.setVisible(false);
        FiltroFDI.setVisible(false);
        FiltroNSSGen.setVisible(false);
        FiltroSZGen.setVisible(false);
        FiltroStatus.setVisible(false);
        FiltroServGen.setVisible(false);
        FiltroZGe.setVisible(false);
        Filobs.setVisible(false);
        setIconImage(new ImageIcon(Empleados_4.class.getClassLoader().getResource("Imagenes/Icono.png")).getImage());
        MDEm();
        MDIMSS();
        setTitle("Empleados Confort # Usuario: " + usr.getId_user() + " " + usr.getApellidop() + " " + usr.getApellidoM() + " " + usr.getNombre()
                + " Tipo de ususario: " + usr.getNombre_tipo() + " Usuario: " + usr.getUsuario());

        switch (LP.getVDA()) {
            case 0 -> {
            }
            case 1 -> {
                Menuadm.setVisible(false);
                if (LP.getP1() == 0) {
                    Alumnos.setVisible(false);
                }
                if (LP.getP2() == 0) {
                    EmpleadosT.setVisible(false);
                }
                if (LP.getP3() == 0) {
                    Depositos.setVisible(false);
                }
                if (LP.getP4() == 0) {
                    Semanales.setVisible(false);
                }
                if (LP.getP5() == 0) {
                    Timss.setEnabled(false);
                    data.setEnabled(false);
                    Timss.setVisible(false);
                    data.setVisible(false);

                }
                if (LP.getP6() == 0) {
                    add.setEnabled(false);
                    addimss.setEnabled(false);
                }
                if (LP.getP7() == 0) {
                    mod.setEnabled(false);
                    modIMSS.setEnabled(false);
                }
                if (LP.getP9() == 0) {
                    Usuarios.setEnabled(false);
                }
            }
            case 2 -> {
                Menuadm.setVisible(false);
                if (LP.getP1() == 0) {
                    Alumnos.setVisible(false);
                }
                if (LP.getP2() == 0) {
                    EmpleadosT.setVisible(false);
                }
                if (LP.getP3() == 0) {
                    Depositos.setVisible(false);
                }
                if (LP.getP4() == 0) {
                    Semanales.setVisible(false);
                }
            }
            default -> {
            }
        }

    }

    @SuppressWarnings("unchecked")

    private void limpimms() {
        expimss.setText("");
        nssimss.setText("");
        expimss.setText("0");
        nameimss.setText("");
        APimss.setText("");
        AMimss.setText("");
        rfcimss.setText("");
        curpimss.setText("");
        sueldoimss.setText("");
        zona1.setText("");
        gen.setSelectedIndex(0);
        puesto.setSelectedIndex(0);
        Status1.setSelectedIndex(0);
        FIimss.setText("");
        FBimss.setText("");
        obsimss.setText("");
        Servimss.setText("");
        FDREimss.setText("");
        FBREimss.setText("");
    }

    private void CleanGen() {
        NRP.setText("");
        NExp.setText("0");
        NameGen.setText("");
        APgen.setText("");
        AMgen.setText("");
        Correo.setText("");
        Rec.setText("");
        Casa.setText("");
        Celular.setText("");
        RFC.setText("");
        NSS.setText("");
        CURP.setText("");
        Sueldo.setText("0");
        Bono.setText("0");
        cta.setText("");
        Obs.setText("");
        Calle.setText("");
        Exterior.setText("");
        INT.setText("");
        Colonia.setText("");
        DLGMUN.setText("");
        CP.setText("");
        DO.setText("");
        DE.setText("");
        DF.setText("");
        fdp.setSelectedIndex(0);
        Banco.setSelectedIndex(0);
        zona.setSelectedIndex(0);
        Serv.setSelectedIndex(0);
        Status.setSelectedIndex(0);
        bf.setSelectedIndex(0);
        cfin.setSelectedIndex(0);
        FE.setText("");
        FI.setText("");
        UDL.setText("");
        FFB.setText("");
        NDC.setText("");
    }

    public void ModEm() {

        String SQL = "UPDATE `rh.empleados` SET `# Exp` = ?, `Entra a IMSS` = ?,"
                + " `Apellido P` = ?, `Apellido M` = ?, `Nombre(s)` = ?, `# Celular` = ?,"
                + " `# Casa` = ?, `# Recados` = ?, `Forma de pago` = ?, `Sueldo` = ?, "
                + "`Bono` = ?, `Banco` = ?, `Cuenta bancaria` = ?, `Zona` = ?, `Servicio` = ?,"
                + " `Status` = ?, `Fecha entrevista` = ?, `Fecha de ingreso` = ?, "
                + "`Fecha ultimo dia laborado` = ?, `Fecha firma baja` = ?, `Baja Firmada` = ?, "
                + "`Finiquito` = ?, `Años de antiguedad` = ?, `RFC` = ?, `NSS` = ?, `CURP` = ?,"
                + " `Correo electronico` = ?, `Calle` = ?, `# Exterior` = ?, `# Interior` = ?, "
                + "`Colonia` = ?, `DLG o Mun` = ?, `C.P` = ?, `Documentos originales` = ?,"
                + " `Documentos faltantes` = ?, `Documentos entregados` = ?, `# Recepcion` = ?,"
                + " `#Credencial` = ?, `Observaciones` = ? WHERE `rh.empleados`.`# Exp` = ?";

        String EI = "";
        if (EIMSS.isSelected() == true) {
            EI = "Si";
        } else if (EIMSS.isSelected() == false) {
            EI = "No";

        }
        try {
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setInt(1, Integer.parseInt(NExp.getText()));
            pst.setString(2, EI);
            pst.setString(3, APgen.getText());
            pst.setString(4, AMgen.getText());
            pst.setString(5, NameGen.getText());
            pst.setString(6, Celular.getText());
            pst.setString(7, Casa.getText());
            pst.setString(8, Rec.getText());
            pst.setString(9, fdp.getSelectedItem().toString());
            pst.setString(10, Sueldo.getText());
            pst.setString(11, Bono.getText());
            pst.setString(12, Banco.getSelectedItem().toString());
            pst.setString(13, cta.getText());
            pst.setString(14, zona.getSelectedItem().toString());
            pst.setString(15, Serv.getSelectedItem().toString());
            pst.setString(16, Status.getSelectedItem().toString());
            pst.setString(17, FE.getText());
            pst.setString(18, FI.getText());
            pst.setString(19, UDL.getText());
            pst.setString(20, FFB.getText());
            pst.setString(21, bf.getSelectedItem().toString());
            pst.setString(22, cfin.getSelectedItem().toString());
            pst.setString(23, ADA.getText());
            pst.setString(24, RFC.getText());
            pst.setString(25, NSS.getText());
            pst.setString(26, CURP.getText());
            pst.setString(27, Correo.getText());
            pst.setString(28, Calle.getText());
            pst.setString(29, Exterior.getText());
            pst.setString(30, INT.getText());
            pst.setString(31, Colonia.getText());
            pst.setString(32, DLGMUN.getText());
            pst.setString(33, CP.getText());
            pst.setString(34, DO.getText());
            pst.setString(35, DF.getText());
            pst.setString(36, DE.getText());
            pst.setString(37, NRP.getText());
            pst.setString(38, NDC.getText());
            pst.setString(39, Obs.getText());
            pst.setInt(40, Integer.parseInt(NExp.getText()));

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empleado Modificado");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en modificar empleado: " + e.getMessage());
        }
    }

    public void ModIMSS() {
        String Item = gen.getSelectedItem().toString();
        String Item3 = puesto.getSelectedItem().toString();
        String Item4 = Status1.getSelectedItem().toString();
        String SQL = "UPDATE `imss` SET `idimss` = ?, `Apellido P` = ?, `Apellido M` = ?, `Nombre(s)` = ?, "
                + "`Genero_imss` = ?, `Fecha_de_incorporacion` = ?, `Zona_Imss` = ?, `servicio` = ?,`nss_imss` = ?, "
                + "`rfc_imss` = ?, `curp_imss` = ?,`Puesto` = ?, `Salario` = ?, `Status_imss` = ?, `fecha_baja` = ?,"
                + "`Fecha de reingreso`  = ?, `fecha baja (re)` = ?, `observaciones` = ?, `fecha de antiguedad` = ?"
                + " WHERE (`idimss` = ?);";

        try {
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, Integer.parseInt(expimss.getText()));
            pst.setString(2, APimss.getText());
            pst.setString(3, AMimss.getText());
            pst.setString(4, nameimss.getText());
            pst.setString(5, Item);
            pst.setString(6, FIimss.getText());
            pst.setString(7, zona1.getText());
            pst.setString(8, Servimss.getText());
            pst.setString(9, nssimss.getText());
            pst.setString(10, rfcimss.getText());
            pst.setString(11, curpimss.getText());
            pst.setString(12, Item3);
            pst.setString(13, sueldoimss.getText());
            pst.setString(14, Item4);
            pst.setString(15, FBimss.getText());
            pst.setString(16, FDREimss.getText());
            pst.setString(17, FBREimss.getText());
            pst.setString(18, obsimss.getText());
            pst.setString(19, ADEIMSS.getText());
            pst.setInt(20, Integer.parseInt(expimss.getText()));

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "IMSS Modificado");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error modificar IMSS: " + e.getMessage());
        }
    }

    public void DelGen() {

        try {

            int filaseleccionada = data.getSelectedRow();
            String sql = "delete from `rh.empleados` where ´# Exp´= " + data.getValueAt(filaseleccionada, 0);
            java.sql.Statement st = con.createStatement();
            int n = st.executeUpdate(sql);
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Empleado eliminado.");
            }
        } catch (HeadlessException | SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al eliminar empleado: " + e.getMessage());

        }

    }

    public void DelIMSS() {

        try {

            int filaseleccionada = Timss.getSelectedRow();
            String sql = "delete from imss where idimss=" + Timss.getValueAt(filaseleccionada, 0);
            java.sql.Statement st = con.createStatement();
            int n = st.executeUpdate(sql);
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "IMSS eliminado.");
            }
        } catch (HeadlessException | SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al eliminar IMSS." + e.getMessage());

        }

    }

    public void FStatusimss() {
        //Buscar servicio
        String Statusimss = StatusimssF.getSelectedItem().toString();
        String where = "select * from imss";

        if (!"".equals(Statusimss)) {
            where = " select * from imss WHERE `Status_imss` LIKE '%" + Statusimss + "%'";
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
            Timss.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(where);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Exp");//1
            modelo.addColumn("Apellido P");//3
            modelo.addColumn("Apellido M");
            modelo.addColumn("Nombre(s)");//5
            modelo.addColumn("Genero");
            modelo.addColumn("Fecha de incorporacion");//7
            modelo.addColumn("Antguiedad");//7
            modelo.addColumn("Zona");
            modelo.addColumn("Servicio");
            modelo.addColumn("NSS");//9
            modelo.addColumn("RFC");
            modelo.addColumn("CURP");//11
            modelo.addColumn("Puesto");
            modelo.addColumn("Salario");//13
            modelo.addColumn("Status");
            modelo.addColumn("Fecha baja");//15
            modelo.addColumn("Fecha de reingreso");//15
            modelo.addColumn("fecha baja (re)");//15
            modelo.addColumn("Observaciones");

//Anchos
            int[] anchos = {/*idbd*/10, /*AP*/ 60, /*AM*/ 60, /*NAME*/ 80,
                /*GEN*/ 30, /*FDI*/ 50, 50, /*ZONA*/ 50, /*serv*/ 100, /*NSS*/ 65, /*RFC*/ 60,
                /*CURP*/ 60, /*puesto*/ 60, /*salario*/ 50, /*Status*/ 65, /*FDB*/ 70,
                /*FRE*/ 70, /*FBRE*/ 70, /*OBS*/ 2000};

            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                Timss.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Datos " + e.getMessage());

        }

    }

    public void FPuestoimss() {
        //Buscar servicio
        String PST = PuestoimssF.getSelectedItem().toString();
        String where = "select * from imss";

        if (!"".equals(PST)) {
            where = " select * from imss WHERE `Puesto` LIKE '%" + PST + "%'";
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
            Timss.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(where);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Exp");//1
            modelo.addColumn("Apellido P");//3
            modelo.addColumn("Apellido M");
            modelo.addColumn("Nombre(s)");//5
            modelo.addColumn("Genero");
            modelo.addColumn("Fecha de incorporacion");//7
            modelo.addColumn("Antguiedad");//7
            modelo.addColumn("Zona");
            modelo.addColumn("Servicio");
            modelo.addColumn("NSS");//9
            modelo.addColumn("RFC");
            modelo.addColumn("CURP");//11
            modelo.addColumn("Puesto");
            modelo.addColumn("Salario");//13
            modelo.addColumn("Status");
            modelo.addColumn("Fecha baja");//15
            modelo.addColumn("Fecha de reingreso");//15
            modelo.addColumn("fecha baja (re)");//15
            modelo.addColumn("Observaciones");

//Anchos
            int[] anchos = {/*idbd*/10, /*AP*/ 60, /*AM*/ 60, /*NAME*/ 80,
                /*GEN*/ 30, /*FDI*/ 50, 50, /*ZONA*/ 50, /*serv*/ 100, /*NSS*/ 65, /*RFC*/ 60,
                /*CURP*/ 60, /*puesto*/ 60, /*salario*/ 50, /*Status*/ 65, /*FDB*/ 70,
                /*FRE*/ 70, /*FBRE*/ 70, /*OBS*/ 2000};

            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                Timss.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Datos " + e.getMessage());

        }

    }

    public void FiltroZimss() {
        //Buscar servicio
        String Zonaimms = FZimss.getSelectedItem().toString();
        String where = "select * from imss";

        if (!"".equals(Zonaimms)) {
            where = " select * from imss WHERE `Zona_Imss` LIKE '%" + Zonaimms + "%'";
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
            Timss.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(where);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Exp");//1
            modelo.addColumn("Apellido P");//3
            modelo.addColumn("Apellido M");
            modelo.addColumn("Nombre(s)");//5
            modelo.addColumn("Genero");
            modelo.addColumn("Fecha de incorporacion");//7
            modelo.addColumn("Antguiedad");//7
            modelo.addColumn("Zona");
            modelo.addColumn("Servicio");
            modelo.addColumn("NSS");//9
            modelo.addColumn("RFC");
            modelo.addColumn("CURP");//11
            modelo.addColumn("Puesto");
            modelo.addColumn("Salario");//13
            modelo.addColumn("Status");
            modelo.addColumn("Fecha baja");//15
            modelo.addColumn("Fecha de reingreso");//15
            modelo.addColumn("fecha baja (re)");//15
            modelo.addColumn("Observaciones");

//Anchos
            int[] anchos = {/*idbd*/10, /*AP*/ 60, /*AM*/ 60, /*NAME*/ 80,
                /*GEN*/ 30, /*FDI*/ 50, 50, /*ZONA*/ 50, /*serv*/ 100, /*NSS*/ 65, /*RFC*/ 60,
                /*CURP*/ 60, /*puesto*/ 60, /*salario*/ 50, /*Status*/ 65, /*FDB*/ 70,
                /*FRE*/ 70, /*FBRE*/ 70, /*OBS*/ 2000};

            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                Timss.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Datos " + e.getMessage());

        }

    }

    public void MDIMSS() {
        //Buscar servicio
        String NIMSS = namesimss.getText();
        String Exp = expFimss.getText();
        String Ap = ApimssF.getText();
        String Am = AmimssF.getText();
        String fdi = FdiimssF.getText();
        String nss = nssimssF.getText();
        String rfc = rfcimssF.getText();
        String curp = curpimssF.getText();
        String fb = FBimssF.getText();
        String where = "select * from imss";

        if (!"".equals(NIMSS)) {
            where = " select * from imss WHERE `Nombre(s)` LIKE '%" + NIMSS + "%'";
        } else if (!"".equals(Exp)) {
            where = " select * from imss Where `idimss` LIKE '%" + Exp + "%'";
        } else if (!"".equals(Ap)) {
            where = "select * from imss Where `Apellido P` LIKE '%" + Ap + "%'";
        } else if (!"".equals(Am)) {
            where = "select * from imss Where `Apellido M` LIKE '%" + Am + "%'";
        } else if (!"".equals(fdi)) {
            where = "select * from imss Where `Fecha_de_incorporacion` LIKE '%" + fdi + "%'";
        } else if (!"".equals(nss)) {
            where = "select * from imss Where `nss_imss` LIKE '%" + nss + "%'";
        } else if (!"".equals(rfc)) {
            where = "select * from imss Where `rfc_imss` LIKE '%" + rfc + "%'";
        } else if (!"".equals(curp)) {
            where = "select * from imss Where `curp_imss` LIKE '%" + curp + "%'";
        } else if (!"".equals(fb)) {
            where = "select * from imss Where `fecha_baja` LIKE '%" + fb + "%'";
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
            Timss.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(where);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Exp");//1
            modelo.addColumn("Apellido P");//3
            modelo.addColumn("Apellido M");
            modelo.addColumn("Nombre(s)");//5
            modelo.addColumn("Genero");
            modelo.addColumn("Fecha de incorporacion");//7
            modelo.addColumn("Antguiedad");//7
            modelo.addColumn("Zona");
            modelo.addColumn("Servicio");
            modelo.addColumn("NSS");//9
            modelo.addColumn("RFC");
            modelo.addColumn("CURP");//11
            modelo.addColumn("Puesto");
            modelo.addColumn("Salario");//13
            modelo.addColumn("Status");
            modelo.addColumn("Fecha baja");//15
            modelo.addColumn("Fecha de reingreso");//15
            modelo.addColumn("fecha baja (re)");//15
            modelo.addColumn("Observaciones");

//Anchos
            int[] anchos = {/*idbd*/10, /*AP*/ 60, /*AM*/ 60, /*NAME*/ 80,
                /*GEN*/ 30, /*FDI*/ 50, 50, /*ZONA*/ 50, /*serv*/ 100, /*NSS*/ 65, /*RFC*/ 60,
                /*CURP*/ 60, /*puesto*/ 60, /*salario*/ 50, /*Status*/ 65, /*FDB*/ 70,
                /*FRE*/ 70, /*FBRE*/ 70, /*OBS*/ 2000};

            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                Timss.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Datos " + e.getMessage());

        }

    }

    public void FstatusGen() {
        //filtro Zonas

        String SQL = "select * from `rh.empleados`";
        String FiltroStatusGen = FiltroStatus.getSelectedItem().toString();

        if (!"".equals(FiltroStatusGen)) {
            SQL = "select * from `rh.empleados` Where `Status` LIKE '%" + FiltroStatusGen + "%'";
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
            data.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Exp");//1
            modelo.addColumn("Entra IMSS");
            modelo.addColumn("Apellido P");
            modelo.addColumn("Apellido M");//4
            modelo.addColumn("Nombre(s)");
            modelo.addColumn("# Celular");
            modelo.addColumn("# Casa");
            modelo.addColumn("# Recados");//8
            modelo.addColumn("Forma de pago");
            modelo.addColumn("Sueldo");
            modelo.addColumn("Bono");
            modelo.addColumn("Banco");//16
            modelo.addColumn("Cuenta de banco");
            modelo.addColumn("Zona");
            modelo.addColumn("Servicio");
            modelo.addColumn("Status");
            modelo.addColumn("Fecha entrevista");
            modelo.addColumn("Fecha ingreso");
            modelo.addColumn("Fecha ultimo dia laborado");
            modelo.addColumn("Fecha firma baja");
            modelo.addColumn("Baja firmada");
            modelo.addColumn("Finiquito");//35
            modelo.addColumn("Años de antiguedad");//35
            modelo.addColumn("RFC");
            modelo.addColumn("NSS");
            modelo.addColumn("CURP");//12
            modelo.addColumn("Correo electronico");//12
            modelo.addColumn("Calle");//21
            modelo.addColumn("# Exterior");
            modelo.addColumn("# Interior");
            modelo.addColumn("Colonia");
            modelo.addColumn("DLG o MUN");
            modelo.addColumn("C.P");//26
            modelo.addColumn("Doc. Originales");
            modelo.addColumn("Doc. Faltantes");
            modelo.addColumn("Doc. Entregables");
            modelo.addColumn("# recepcion personal");
            modelo.addColumn("# Credencial");
            modelo.addColumn("Observaciones");//44

            int[] anchos = {/*idbd*/35, /*entraimms*/ 65, /*ap*/ 70, /*am*/ 70, /*name*/ 100,
                /*celular*/ 65, /*casa*/ 65, /*recados*/ 70, /*fdp*/ 70,
                /*sueldo*/ 40, /*bono*/ 35, /*banco*/ 55, /*CTA*/ 60, /*zona*/ 60,
                /*serv*/ 60, /*status*/ 75, /*FDE*/ 75, /*FDI*/ 75, /*FUDL*/ 75, /*FFB*/ 75,
                /*ada*/ 80,/*BF*/ 60, /*FIN*/ 70, /*rfc*/ 60,
                /*nss*/ 65, /*curp*/ 70, /*correo*/ 75,
                /*calle*/ 200, /*ext*/ 30, /*int*/ 30, /*colonia*/ 60, /*dlgmun*/ 75, /*cp*/ 85, /*DO*/ 1000, /*DF*/ 300, /*DE*/ 300, 50,
                /*NRP*/ 60, /*OBS*/ 2000};
            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                data.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Datos de Tabla Nomina: " + e.getMessage());
        }

    }

    public void FZGen() {
        //filtro Zonas

        String SQL = "select * from `rh.empleados`";
        String FiltroZGen = FiltroZGe.getSelectedItem().toString();

        if (!"".equals(FiltroZGen)) {
            SQL = "select * from `rh.empleados` where `Zona` LIKE '%" + FiltroZGen + "%'";
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
            data.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Exp");//1
            modelo.addColumn("Entra IMSS");
            modelo.addColumn("Apellido P");
            modelo.addColumn("Apellido M");//4
            modelo.addColumn("Nombre(s)");
            modelo.addColumn("# Celular");
            modelo.addColumn("# Casa");
            modelo.addColumn("# Recados");//8
            modelo.addColumn("Forma de pago");
            modelo.addColumn("Sueldo");
            modelo.addColumn("Bono");
            modelo.addColumn("Banco");//16
            modelo.addColumn("Cuenta de banco");
            modelo.addColumn("Zona");
            modelo.addColumn("Servicio");
            modelo.addColumn("Status");
            modelo.addColumn("Fecha entrevista");
            modelo.addColumn("Fecha ingreso");
            modelo.addColumn("Fecha ultimo dia laborado");
            modelo.addColumn("Fecha firma baja");
            modelo.addColumn("Baja firmada");
            modelo.addColumn("Finiquito");//35
            modelo.addColumn("Años de antiguedad");//35
            modelo.addColumn("RFC");
            modelo.addColumn("NSS");
            modelo.addColumn("CURP");//12
            modelo.addColumn("Correo electronico");//12
            modelo.addColumn("Calle");//21
            modelo.addColumn("# Exterior");
            modelo.addColumn("# Interior");
            modelo.addColumn("Colonia");
            modelo.addColumn("DLG o MUN");
            modelo.addColumn("C.P");//26
            modelo.addColumn("Doc. Originales");
            modelo.addColumn("Doc. Faltantes");
            modelo.addColumn("Doc. Entregables");
            modelo.addColumn("# recepcion personal");
            modelo.addColumn("# Credencial");
            modelo.addColumn("Observaciones");//44

            int[] anchos = {/*idbd*/35, /*entraimms*/ 65, /*ap*/ 70, /*am*/ 70, /*name*/ 100,
                /*celular*/ 65, /*casa*/ 65, /*recados*/ 70, /*fdp*/ 70,
                /*sueldo*/ 40, /*bono*/ 35, /*banco*/ 55, /*CTA*/ 60, /*zona*/ 60,
                /*serv*/ 60, /*status*/ 75, /*FDE*/ 75, /*FDI*/ 75, /*FUDL*/ 75, /*FFB*/ 75,
                /*ada*/ 80,/*BF*/ 60, /*FIN*/ 70, /*rfc*/ 60,
                /*nss*/ 65, /*curp*/ 70, /*correo*/ 75,
                /*calle*/ 200, /*ext*/ 30, /*int*/ 30, /*colonia*/ 60, /*dlgmun*/ 75, /*cp*/ 85, /*DO*/ 1000, /*DF*/ 300, /*DE*/ 300, 50,
                /*NRP*/ 60, /*OBS*/ 2000};

            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                data.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Datos de Tabla Nomina: " + e.getMessage());
        }

    }

    public void FServGen() {
        //filtro servicio

        String SQL = "select * from `rh.empleados`";
        String FiltroSGen = FiltroServGen.getSelectedItem().toString();

        if (!"".equals(FiltroSGen)) {
            SQL = "select * from `rh.empleados` Where `Servicio` LIKE '%" + FiltroSGen + "%'";
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
            data.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Exp");//1
            modelo.addColumn("Entra IMSS");
            modelo.addColumn("Apellido P");
            modelo.addColumn("Apellido M");//4
            modelo.addColumn("Nombre(s)");
            modelo.addColumn("# Celular");
            modelo.addColumn("# Casa");
            modelo.addColumn("# Recados");//8
            modelo.addColumn("Forma de pago");
            modelo.addColumn("Sueldo");
            modelo.addColumn("Bono");
            modelo.addColumn("Banco");//16
            modelo.addColumn("Cuenta de banco");
            modelo.addColumn("Zona");
            modelo.addColumn("Servicio");
            modelo.addColumn("Status");
            modelo.addColumn("Fecha entrevista");
            modelo.addColumn("Fecha ingreso");
            modelo.addColumn("Fecha ultimo dia laborado");
            modelo.addColumn("Fecha firma baja");
            modelo.addColumn("Baja firmada");
            modelo.addColumn("Finiquito");//35
            modelo.addColumn("Años de antiguedad");//35
            modelo.addColumn("RFC");
            modelo.addColumn("NSS");
            modelo.addColumn("CURP");//12
            modelo.addColumn("Correo electronico");//12
            modelo.addColumn("Calle");//21
            modelo.addColumn("# Exterior");
            modelo.addColumn("# Interior");
            modelo.addColumn("Colonia");
            modelo.addColumn("DLG o MUN");
            modelo.addColumn("C.P");//26
            modelo.addColumn("Doc. Originales");
            modelo.addColumn("Doc. Faltantes");
            modelo.addColumn("Doc. Entregables");
            modelo.addColumn("# recepcion personal");
            modelo.addColumn("# Credencial");
            modelo.addColumn("Observaciones");//44

            int[] anchos = {/*idbd*/35, /*entraimms*/ 65, /*ap*/ 70, /*am*/ 70, /*name*/ 100,
                /*celular*/ 65, /*casa*/ 65, /*recados*/ 70, /*fdp*/ 70,
                /*sueldo*/ 40, /*bono*/ 35, /*banco*/ 55, /*CTA*/ 60, /*zona*/ 60,
                /*serv*/ 60, /*status*/ 75, /*FDE*/ 75, /*FDI*/ 75, /*FUDL*/ 75, /*FFB*/ 75,
                /*ada*/ 80,/*BF*/ 60, /*FIN*/ 70, /*rfc*/ 60,
                /*nss*/ 65, /*curp*/ 70, /*correo*/ 75,
                /*calle*/ 200, /*ext*/ 30, /*int*/ 30, /*colonia*/ 60, /*dlgmun*/ 75, /*cp*/ 85, /*DO*/ 1000, /*DF*/ 300, /*DE*/ 300, 50,
                /*NRP*/ 60, /*OBS*/ 2000};

            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                data.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Datos de Tabla Nomina: " + e.getMessage());
        }

    }

    public void MDEm() {
        //Buscar empleado
        String FiltroOBS = Filobs.getText();
        String FiltroNGe = FiltroNG.getText();
        String Filtroapgen = Filtroap.getText();
        String FilAM = Filtroam.getText();
        String SQL = "select * from `rh.empleados`";
        String FiltroFDIGen = FiltroFDI.getText();
        String FiltrocurpGen = FiltroCurpGen.getText();
        String FiltroNSSGe = FiltroNSSGen.getText();

        if (!"".equals(FiltroNGe)) {
            SQL = "Select * from `rh.empleados` where `Nombre(s)` LIKE '%" + FiltroNGe + "%'";
        } else if (!"".equals(FiltroFDIGen)) {
            SQL = "select * from `rh.empleados` Where `Fecha de ingreso` LIKE '%" + FiltroFDIGen + "%'";
        } else if (!"".equals(FiltrocurpGen)) {
            SQL = "select * from `rh.empleados` Where `CURP` LIKE '%" + FiltrocurpGen + "%'";
        } else if (!"".equals(FiltroNSSGe)) {
            SQL = "select * from `rh.empleados` Where `NSS` LIKE '%" + FiltroNSSGe + "%'";
        } else if (!"".equals(Filtroapgen)) {
            SQL = "select * from `rh.empleados` Where `Apellido P` LIKE '%" + Filtroapgen + "%'";
        } else if (!"".equals(FilAM)) {
            SQL = "select * from `rh.empleados` Where `Apellido M` LIKE '%" + FilAM + "%'";
        } else if (!"".equals(FiltroOBS)) {
            SQL = "select * from `rh.empleados` where `Observaciones` LIKE '%" + FiltroOBS + "%'";
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
            data.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Exp");//1
            modelo.addColumn("Entra IMSS");
            modelo.addColumn("Apellido P");
            modelo.addColumn("Apellido M");//4
            modelo.addColumn("Nombre(s)");
            modelo.addColumn("# Celular");
            modelo.addColumn("# Casa");
            modelo.addColumn("# Recados");//8
            modelo.addColumn("Forma de pago");
            modelo.addColumn("Sueldo");
            modelo.addColumn("Bono");
            modelo.addColumn("Banco");//16
            modelo.addColumn("Cuenta de banco");
            modelo.addColumn("Zona");
            modelo.addColumn("Servicio");
            modelo.addColumn("Status");
            modelo.addColumn("Fecha entrevista");
            modelo.addColumn("Fecha ingreso");
            modelo.addColumn("Fecha ultimo dia laborado");
            modelo.addColumn("Fecha firma baja");
            modelo.addColumn("Baja firmada");
            modelo.addColumn("Finiquito");//35
            modelo.addColumn("Años de antiguedad");//35
            modelo.addColumn("RFC");
            modelo.addColumn("NSS");
            modelo.addColumn("CURP");//12
            modelo.addColumn("Correo electronico");//12
            modelo.addColumn("Calle");//21
            modelo.addColumn("# Exterior");
            modelo.addColumn("# Interior");
            modelo.addColumn("Colonia");
            modelo.addColumn("DLG o MUN");
            modelo.addColumn("C.P");//26
            modelo.addColumn("Doc. Originales");
            modelo.addColumn("Doc. Faltantes");
            modelo.addColumn("Doc. Entregables");
            modelo.addColumn("# recepcion personal");
            modelo.addColumn("# Credencial");
            modelo.addColumn("Observaciones");//44

            int[] anchos = {/*idbd*/35, /*entraimms*/ 65, /*ap*/ 70, /*am*/ 70, /*name*/ 100,
                /*celular*/ 65, /*casa*/ 65, /*recados*/ 70, /*fdp*/ 70,
                /*sueldo*/ 40, /*bono*/ 35, /*banco*/ 55, /*CTA*/ 60, /*zona*/ 60,
                /*serv*/ 60, /*status*/ 75, /*FDE*/ 75, /*FDI*/ 75, /*FUDL*/ 75, /*FFB*/ 75,
                /*ada*/ 80,/*BF*/ 60, /*FIN*/ 70, /*rfc*/ 60,
                /*nss*/ 65, /*curp*/ 70, /*correo*/ 75,
                /*calle*/ 200, /*ext*/ 30, /*int*/ 30, /*colonia*/ 60, /*dlgmun*/ 75, /*cp*/ 85, /*DO*/ 1000, /*DF*/ 300, /*DE*/ 300, 50,
                /*NRP*/ 60, /*OBS*/ 2000};

            for (int x = 0; x < cantidadColumnas; x++) {
                //Nombre tabla
                data.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Datos de Tabla empleados: " + e.getMessage());
        }

    }

    public void AgregarI() {
        String SQL = "INSERT INTO `imss` (`idimss`, "
                + " `Apellido P`, `Apellido M`, `Nombre(s)`, "
                + "`Genero_imss`, `Fecha_de_incorporacion`, `fecha de antiguedad`,"
                + "`Zona_Imss`, `servicio`, `nss_imss`, `rfc_imss`, `curp_imss`,"
                + " `Puesto`, `Salario`, `Status_imss`, `fecha_baja`,"
                + " `Fecha de reingreso`, `fecha baja (re)`, `observaciones`) VALUES (?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setInt(1, Integer.parseInt(expimss.getText()));
            pst.setString(2, APimss.getText());
            pst.setString(3, AMimss.getText());
            pst.setString(4, nameimss.getText());
            pst.setString(5, gen.getSelectedItem().toString());
            pst.setString(6, FIimss.getText());
            pst.setString(7, ADEIMSS.getText());
            pst.setString(8, zona1.getText());
            pst.setString(9, Servimss.getText());
            pst.setString(10, nssimss.getText());
            pst.setString(11, rfcimss.getText());
            pst.setString(12, curpimss.getText());
            pst.setString(13, puesto.getSelectedItem().toString());
            pst.setString(14, sueldoimss.getText());
            pst.setString(15, Status1.getSelectedItem().toString());
            pst.setString(16, FBimss.getText());
            pst.setString(17, FDREimss.getText());
            pst.setString(18, FBREimss.getText());
            pst.setString(19, obsimss.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "IMSS agregado.");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar imss: " + e.getMessage());
        }
    }

    public void AgregarE() {

        String SQL = "INSERT INTO `rh.empleados` (`# Exp`, `Entra a IMSS`,"
                + " `Apellido P`, `Apellido M`, `Nombre(s)`, `# Celular`, `# Casa`,"
                + " `# Recados`, `Forma de pago`, `Sueldo`, `Bono`, `Banco`, `Cuenta bancaria`,"
                + " `Zona`, `Servicio`, `Status`, `Fecha entrevista`, `Fecha de ingreso`,"
                + " `Fecha ultimo dia laborado`, `Fecha firma baja`, `Baja Firmada`, `Finiquito`,"
                + " `Años de antiguedad`, `RFC`, `NSS`, `CURP`, `Correo electronico`, `Calle`,"
                + " `# Exterior`, `# Interior`, `Colonia`, `DLG o Mun`, `C.P`, `Documentos originales`,"
                + " `Documentos faltantes`, `Documentos entregados`, `# Recepcion`, `#Credencial`, `Observaciones`)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String EI = "";
        if (EIMSS.isSelected() == true) {
            EI = "Si";
        } else if (EIMSS.isSelected() == false) {
            EI = "No";

        }
        try {
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setInt(1, Integer.parseInt(NExp.getText()));
            pst.setString(2, EI);
            pst.setString(3, APgen.getText());
            pst.setString(4, AMgen.getText());
            pst.setString(5, NameGen.getText());
            pst.setString(6, Celular.getText());
            pst.setString(7, Casa.getText());
            pst.setString(8, Rec.getText());
            pst.setString(9, fdp.getSelectedItem().toString());
            pst.setString(10, Sueldo.getText());
            pst.setString(11, Bono.getText());
            pst.setString(12, Banco.getSelectedItem().toString());
            pst.setString(13, cta.getText());
            pst.setString(14, zona.getSelectedItem().toString());
            pst.setString(15, Serv.getSelectedItem().toString());
            pst.setString(16, Status.getSelectedItem().toString());
            pst.setString(17, FE.getText());
            pst.setString(18, FI.getText());
            pst.setString(19, UDL.getText());
            pst.setString(20, FFB.getText());
            pst.setString(21, bf.getSelectedItem().toString());
            pst.setString(22, cfin.getSelectedItem().toString());
            pst.setString(23, ADA.getText());
            pst.setString(24, RFC.getText());
            pst.setString(25, NSS.getText());
            pst.setString(26, CURP.getText());
            pst.setString(27, Correo.getText());
            pst.setString(28, Calle.getText());
            pst.setString(29, Exterior.getText());
            pst.setString(30, INT.getText());
            pst.setString(31, Colonia.getText());
            pst.setString(32, DLGMUN.getText());
            pst.setString(33, CP.getText());
            pst.setString(34, DO.getText());
            pst.setString(35, DF.getText());
            pst.setString(36, DE.getText());
            pst.setString(37, NRP.getText());
            pst.setString(38, NDC.getText());
            pst.setString(39, Obs.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empleado agregado.");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar empleado: " + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RH = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        General = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Correo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Rec = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Casa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Celular = new javax.swing.JTextField();
        RFC = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NSS = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        CURP = new javax.swing.JTextField();
        APgen = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        AMgen = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        NameGen = new javax.swing.JTextField();
        NExp = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        EIMSS = new javax.swing.JCheckBox();
        jLabel33 = new javax.swing.JLabel();
        NDC = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        Sueldo = new javax.swing.JTextField();
        Bono = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Obs = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cta = new javax.swing.JTextField();
        fdp = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Banco = new javax.swing.JComboBox<>();
        zona = new javax.swing.JComboBox<>();
        Serv = new javax.swing.JComboBox<>();
        Status = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        Calle = new javax.swing.JTextField();
        Exterior = new javax.swing.JTextField();
        INT = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Colonia = new javax.swing.JTextField();
        DLGMUN = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        CP = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        DO = new javax.swing.JTextField();
        DF = new javax.swing.JTextField();
        DE = new javax.swing.JTextField();
        bf = new javax.swing.JComboBox<>();
        cfin = new javax.swing.JComboBox<>();
        jLabel71 = new javax.swing.JLabel();
        NRP = new javax.swing.JTextField();
        FE = new javax.swing.JTextField();
        FI = new javax.swing.JTextField();
        UDL = new javax.swing.JTextField();
        FFB = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        ADA = new javax.swing.JLabel();
        AADA = new javax.swing.JButton();
        mod = new javax.swing.JButton();
        add = new javax.swing.JButton();
        Cs = new javax.swing.JButton();
        mod1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        FiltroNG = new javax.swing.JTextField();
        LabelF1 = new javax.swing.JLabel();
        ScrollpaneTG = new javax.swing.JScrollPane();
        data = new javax.swing.JTable();
        elim = new javax.swing.JButton();
        Cs2 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        Filtros = new javax.swing.JComboBox<>();
        LabelF2 = new javax.swing.JLabel();
        FiltroZGe = new javax.swing.JComboBox<>();
        FiltroSZGen = new javax.swing.JComboBox<>();
        FiltroStatus = new javax.swing.JComboBox<>();
        FiltroFDI = new javax.swing.JTextField();
        FiltroServGen = new javax.swing.JComboBox<>();
        FiltroCurpGen = new javax.swing.JTextField();
        FiltroNSSGen = new javax.swing.JTextField();
        Filtroap = new javax.swing.JTextField();
        Filtroam = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ObsTgen = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        Filobs = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        IMSS = new javax.swing.JPanel();
        modIMSS = new javax.swing.JButton();
        addimss = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        gen = new javax.swing.JComboBox<>();
        nssimss = new javax.swing.JTextField();
        expimss = new javax.swing.JTextField();
        FIimss = new javax.swing.JTextField();
        zona1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        APimss = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        AMimss = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        nameimss = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        Servimss = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        puesto = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        rfcimss = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        curpimss = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        sueldoimss = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        obsimss = new javax.swing.JTextArea();
        FBimss = new javax.swing.JTextField();
        Status1 = new javax.swing.JComboBox<>();
        Cs3 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        FDREimss = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        FBREimss = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ADEIMSS = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        deleteimss = new javax.swing.JButton();
        Nfilimss = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Timss = new javax.swing.JTable();
        namesimss = new javax.swing.JTextField();
        Cs4 = new javax.swing.JButton();
        Fimss = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        expFimss = new javax.swing.JTextField();
        ApimssF = new javax.swing.JTextField();
        AmimssF = new javax.swing.JTextField();
        FdiimssF = new javax.swing.JTextField();
        FZimss = new javax.swing.JComboBox<>();
        nssimssF = new javax.swing.JTextField();
        rfcimssF = new javax.swing.JTextField();
        curpimssF = new javax.swing.JTextField();
        PuestoimssF = new javax.swing.JComboBox<>();
        StatusimssF = new javax.swing.JComboBox<>();
        FBimssF = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menuadm = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        ODT = new javax.swing.JMenuItem();
        CNQ = new javax.swing.JMenuItem();
        PRESQ = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        CDA = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        CDA4 = new javax.swing.JMenuItem();
        ODT2 = new javax.swing.JMenuItem();
        LDA = new javax.swing.JMenuItem();
        LDA3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        General1 = new javax.swing.JMenuItem();
        Estadias = new javax.swing.JMenuItem();
        Torteria = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        Depositos2 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        ZYS = new javax.swing.JMenuItem();
        ADMV1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        Alumnos = new javax.swing.JMenuItem();
        EmpleadosT = new javax.swing.JMenuItem();
        Depositos = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        Usuarios = new javax.swing.JMenuItem();
        Semanales = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem28 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interface de Recursos Humanos");

        jLabel5.setText("# Recados:");

        jLabel6.setText("# Casa:");

        jLabel7.setText("# Celular:");

        jLabel8.setText("RFC:");

        jLabel9.setText("NSS:");

        jLabel17.setText("Apellido P:");

        jLabel4.setText("Correo:");

        jLabel10.setText("CURP");

        jLabel44.setText("Apellido M:");

        jLabel62.setText("Nombre(s):");

        NExp.setText("0");

        jLabel64.setText("# Exp");

        EIMSS.setText("Entra a IMSS");

        jLabel33.setText("N. Credencial:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel44)
                            .addComponent(jLabel64)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Correo, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(Rec)
                    .addComponent(Casa)
                    .addComponent(Celular)
                    .addComponent(RFC)
                    .addComponent(NSS)
                    .addComponent(CURP)
                    .addComponent(APgen)
                    .addComponent(AMgen)
                    .addComponent(NameGen)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EIMSS)
                            .addComponent(NExp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(NDC))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EIMSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(APgen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(AMgen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Rec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Casa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(RFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(NSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(CURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(NDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jLabel14.setText("Zona");

        Sueldo.setText("0");

        Bono.setText("0");

        jLabel13.setText("Bono");

        jLabel18.setText("Observaciones");

        Obs.setColumns(20);
        Obs.setLineWrap(true);
        Obs.setRows(5);
        jScrollPane1.setViewportView(Obs);

        jLabel16.setText("Status");

        jLabel11.setText("Forma de pago");

        fdp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "TARJETA", "EFECTIVO" }));
        fdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fdpActionPerformed(evt);
            }
        });

        jLabel15.setText("Servicio");

        jLabel12.setText("Sueldo");

        jLabel27.setText("Cuenta de banco:");

        jLabel29.setText("Banco:");

        Banco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "BANCOMER", "SANTANDER", "EFECTIVO" }));

        zona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "." }));
        zona.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                zonaItemStateChanged(evt);
            }
        });

        Serv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "." }));

        Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "BAJA", "PENDIENTE", "EN ESPERA", "RECHAZADO", "TEMPORAL", "VIGENTE", "BOLETINADO", "DEPURADO", "RECHAZADO/DEPURADO", "NO CONTRATAR/DEPURADO", "BOLETINADO/DEPURADO", "BAJA/DEPURADO", "NO CONTRATAR" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel27)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel29)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Serv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Banco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fdp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(Bono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(Banco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(zona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(Serv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap())
        );

        jLabel19.setText("Domicilio");

        jLabel20.setText("Calle");

        jLabel21.setText("# Exterior");

        jLabel22.setText("# Interior");

        jLabel23.setText("Colonia");

        jLabel24.setText("DLG o Mun");

        Colonia.setPreferredSize(new java.awt.Dimension(70, 20));

        DLGMUN.setPreferredSize(new java.awt.Dimension(70, 20));

        jLabel25.setText("C.P");

        CP.setPreferredSize(new java.awt.Dimension(70, 20));
        CP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPActionPerformed(evt);
            }
        });

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
                                .addGap(215, 215, 215)
                                .addComponent(jLabel25))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Exterior, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(INT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Calle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CP, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(DLGMUN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Colonia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel19)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(Calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(Exterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(INT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Colonia, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(DLGMUN, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(CP, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        jLabel30.setText("Consecutivo");

        jLabel39.setText("Doc. originales:");

        jLabel40.setText("Doc. faltantes:");

        jLabel41.setText("(debe chofer)");

        jLabel57.setText("Doc. entregados:");

        jLabel58.setText("(recibe chofer)");

        jLabel59.setText("Fecha entrevista:");

        jLabel66.setText("Fecha ingreso:");

        jLabel67.setText("Ultimo dia laborado:");

        jLabel68.setText("Fecha firma baja:");

        jLabel69.setText("Baja firmada:");

        jLabel70.setText("Finiquito:");

        bf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "Si", "No", "No aplica", "No ha venido a firmar", "Firma no coincide con la ine", "Pendiente" }));

        cfin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "No", "No aplica", "Si", "Si se le dio", "Pagado", "Pendiente" }));

        jLabel71.setText("# recepcion personal:");

        jLabel26.setText("Antiguedad del empelado:");

        ADA.setText("0");

        AADA.setText("Actualizar antiguedad");
        AADA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AADAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(124, 124, 124))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel71)
                    .addComponent(jLabel70)
                    .addComponent(jLabel69)
                    .addComponent(jLabel68)
                    .addComponent(jLabel67)
                    .addComponent(jLabel66)
                    .addComponent(jLabel59)
                    .addComponent(jLabel58)
                    .addComponent(jLabel57)
                    .addComponent(jLabel41)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DO, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DF, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DE, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NRP, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FE, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FI, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UDL, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FFB, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(ADA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AADA)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(DO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(DF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(DE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel58)
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(FE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(FI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(UDL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(FFB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(bf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(cfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(ADA)
                    .addComponent(AADA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(NRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lapizmod.jpg"))); // NOI18N
        mod.setText("Modificar");
        mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modActionPerformed(evt);
            }
        });

        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        add.setText("Agregar");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        Cs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrarsesionlogo.jpg"))); // NOI18N
        Cs.setText("Cerrar sesion");
        Cs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CsActionPerformed(evt);
            }
        });

        mod1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lapizmod.jpg"))); // NOI18N
        mod1.setText("Historial Empleado");
        mod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GeneralLayout = new javax.swing.GroupLayout(General);
        General.setLayout(GeneralLayout);
        GeneralLayout.setHorizontalGroup(
            GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GeneralLayout.createSequentialGroup()
                .addGroup(GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GeneralLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addGroup(GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GeneralLayout.createSequentialGroup()
                                .addComponent(mod)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(add)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cs))
                            .addComponent(mod1))))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        GeneralLayout.setVerticalGroup(
            GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GeneralLayout.createSequentialGroup()
                        .addGroup(GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GeneralLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(GeneralLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mod)
                                    .addComponent(add)
                                    .addComponent(Cs))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mod1))))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(General);

        RH.addTab("Registro", jScrollPane3);

        FiltroNG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FiltroNGKeyReleased(evt);
            }
        });

        LabelF1.setText("Buscar:");

        data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19", "Title 20", "Title 21", "Title 22", "Title 23", "Title 24", "Title 25", "Title 26", "Title 27", "Title 28", "Title 29", "Title 30", "Title 31", "Title 32", "Title 33", "Title 34", "Title 35", "Title 36", "Title 37", "Title 38", "Title 39", "Title 40", "Title 41", "Title 42", "Title 43", "Title 44", "Title 45", "Title 46", "Title 47", "Title 48", "Title 49", "Title 50"
            }
        ));
        data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataMouseClicked(evt);
            }
        });
        ScrollpaneTG.setViewportView(data);

        elim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarlogo.png"))); // NOI18N
        elim.setText("Eliminar");
        elim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elimActionPerformed(evt);
            }
        });

        Cs2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrarsesionlogo.jpg"))); // NOI18N
        Cs2.setText("Cerrar sesion");
        Cs2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cs2ActionPerformed(evt);
            }
        });

        jLabel28.setText("Filtrar por:");

        Filtros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Filtro", "Apellido P", "Apellido M", "Nombre(s)", "Zona", "Servicio", "Fecha de ingreso", "CURP", "NSS", "Estatus", "Observaciones" }));
        Filtros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FiltrosItemStateChanged(evt);
            }
        });

        LabelF2.setText("Filtro 2:");

        FiltroZGe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        FiltroZGe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FiltroZGeItemStateChanged(evt);
            }
        });

        FiltroSZGen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        FiltroSZGen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FiltroSZGenItemStateChanged(evt);
            }
        });

        FiltroStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "BAJA", "IMSS", "PENDIENTE", "RECHAZADO", "TEMPORAL", "VIGENTE", "BOLETINADO" }));
        FiltroStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FiltroStatusItemStateChanged(evt);
            }
        });

        FiltroFDI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FiltroFDIKeyReleased(evt);
            }
        });

        FiltroServGen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        FiltroServGen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FiltroServGenItemStateChanged(evt);
            }
        });

        FiltroCurpGen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FiltroCurpGenKeyReleased(evt);
            }
        });

        FiltroNSSGen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FiltroNSSGenKeyReleased(evt);
            }
        });

        Filtroap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FiltroapKeyReleased(evt);
            }
        });

        Filtroam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FiltroamKeyReleased(evt);
            }
        });

        ObsTgen.setColumns(20);
        ObsTgen.setLineWrap(true);
        ObsTgen.setRows(5);
        jScrollPane2.setViewportView(ObsTgen);

        jLabel1.setText("Observaciones:");

        Filobs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilobsActionPerformed(evt);
            }
        });
        Filobs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FilobsKeyReleased(evt);
            }
        });

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Microsoft-Excel-Logo.png"))); // NOI18N
        jLabel31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel31MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ScrollpaneTG)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(elim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelF1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Filtroam, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Filtroap, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FiltroNG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FiltroZGe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FiltroSZGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelF2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FiltroServGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FiltroStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FiltroFDI, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FiltroCurpGen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FiltroNSSGen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Filobs, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cs2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5473, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 2118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LabelF1)
                        .addComponent(FiltroNG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(elim)
                        .addComponent(jLabel28)
                        .addComponent(Filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelF2)
                        .addComponent(FiltroZGe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FiltroSZGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FiltroStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FiltroFDI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FiltroServGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FiltroCurpGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FiltroNSSGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cs2)
                        .addComponent(Filtroap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Filtroam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(Filobs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollpaneTG, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel6);

        RH.addTab("Tabla General", jScrollPane5);

        IMSS.setBackground(new java.awt.Color(255, 204, 255));

        modIMSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lapizmod.jpg"))); // NOI18N
        modIMSS.setText("Modificar");
        modIMSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modIMSSActionPerformed(evt);
            }
        });

        addimss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        addimss.setText("Agregar");
        addimss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addimssActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 204, 255));

        jLabel46.setText("Genero:");

        jLabel47.setText("Fecha IMSS");

        jLabel48.setText("Zona:");

        jLabel49.setText("NSS:");

        gen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "HOMBRE", "MUJER" }));

        expimss.setText("0");

        jLabel2.setText("Apellido P");

        jLabel63.setText("Apellido M");

        jLabel65.setText("# Exp");

        jLabel45.setText("Nombre(s):");

        jLabel111.setText("Servicio:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel49)
                    .addComponent(jLabel2)
                    .addComponent(jLabel63)
                    .addComponent(jLabel65)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48)
                    .addComponent(jLabel111))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(APimss)
                    .addComponent(AMimss)
                    .addComponent(nameimss, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(expimss, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(FIimss)
                    .addComponent(Servimss)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(gen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 66, Short.MAX_VALUE))
                    .addComponent(zona1)
                    .addComponent(nssimss))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(APimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(AMimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(gen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(FIimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(zona1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111)
                    .addComponent(Servimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(nssimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 204, 255));

        puesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "CHOFER", "ADMINISTRATIVO", "SUPERVISOR" }));

        jLabel50.setText("RFC");

        jLabel51.setText("CURP");

        jLabel52.setText("Puesto");

        jLabel53.setText("Sueldo:");

        jLabel54.setText("Status:");

        jLabel55.setText("Fecha baja:");

        jLabel56.setText("Observaciones");

        obsimss.setColumns(20);
        obsimss.setLineWrap(true);
        obsimss.setRows(5);
        jScrollPane4.setViewportView(obsimss);

        Status1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "BAJA", "IMSS", "PENDIENTE", "RECHAZADO", "TEMPORAL", "VIGENTE" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FBimss, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel52))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(curpimss, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(puesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rfcimss, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sueldoimss, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Status1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(rfcimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curpimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(puesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(sueldoimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Status1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(FBimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Cs3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrarsesionlogo.jpg"))); // NOI18N
        Cs3.setText("Cerrar sesion");
        Cs3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cs3ActionPerformed(evt);
            }
        });

        jLabel42.setText("Re-Ingreso");

        jLabel112.setText("Fecha de reingreso:");

        jLabel120.setText("Fecha de baja:");

        jLabel34.setText("Antguedad de empleado:");

        jButton1.setText("Actualizar antiguedad.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ADEIMSS.setText("0");

        javax.swing.GroupLayout IMSSLayout = new javax.swing.GroupLayout(IMSS);
        IMSS.setLayout(IMSSLayout);
        IMSSLayout.setHorizontalGroup(
            IMSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IMSSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IMSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(IMSSLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(modIMSS)
                        .addGap(18, 18, 18)
                        .addComponent(addimss)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(IMSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(IMSSLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(Cs3))
                    .addGroup(IMSSLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel42))
                    .addGroup(IMSSLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(IMSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel112)
                            .addComponent(jLabel120)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(IMSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(IMSSLayout.createSequentialGroup()
                                .addComponent(ADEIMSS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(FDREimss, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FBREimss, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 377, Short.MAX_VALUE))
        );
        IMSSLayout.setVerticalGroup(
            IMSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IMSSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IMSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(IMSSLayout.createSequentialGroup()
                        .addComponent(Cs3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(IMSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FDREimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel112))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(IMSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel120)
                            .addComponent(FBREimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(IMSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(jButton1)
                            .addComponent(ADEIMSS)))
                    .addGroup(IMSSLayout.createSequentialGroup()
                        .addGroup(IMSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(IMSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modIMSS)
                            .addComponent(addimss))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane8.setViewportView(IMSS);

        RH.addTab("IMSS", jScrollPane8);

        jPanel8.setBackground(new java.awt.Color(255, 204, 255));

        deleteimss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarlogo.png"))); // NOI18N
        deleteimss.setText("Eliminar");
        deleteimss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteimssActionPerformed(evt);
            }
        });

        Nfilimss.setText("Buscar por IMSS:");

        Timss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16"
            }
        ));
        Timss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimssMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(Timss);

        namesimss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                namesimssKeyReleased(evt);
            }
        });

        Cs4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrarsesionlogo.jpg"))); // NOI18N
        Cs4.setText("Cerrar sesion");
        Cs4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cs4ActionPerformed(evt);
            }
        });

        Fimss.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona filtro", "# Exp", "Apellido P", "Apellido M", "Nombre(s)", "Fecha de incorporacion", "Zona", "NSS", "RFC", "CURP", "Puesto", "Status", "Fecha de baja" }));
        Fimss.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FimssItemStateChanged(evt);
            }
        });

        jLabel3.setText("Filtrar por:");

        expFimss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                expFimssKeyReleased(evt);
            }
        });

        ApimssF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ApimssFKeyReleased(evt);
            }
        });

        AmimssF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AmimssFKeyReleased(evt);
            }
        });

        FdiimssF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FdiimssFKeyReleased(evt);
            }
        });

        FZimss.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "." }));
        FZimss.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FZimssItemStateChanged(evt);
            }
        });

        nssimssF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nssimssFKeyReleased(evt);
            }
        });

        rfcimssF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rfcimssFKeyReleased(evt);
            }
        });

        curpimssF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                curpimssFKeyReleased(evt);
            }
        });

        PuestoimssF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "CHOFER", "ADMINISTRATIVO", "SUPERVISOR" }));
        PuestoimssF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PuestoimssFItemStateChanged(evt);
            }
        });

        StatusimssF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "BAJA", "IMSS", "PENDIENTE", "RECHAZADO", "TEMPORAL", "VIGENTE" }));
        StatusimssF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                StatusimssFItemStateChanged(evt);
            }
        });

        FBimssF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FBimssFKeyReleased(evt);
            }
        });

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Microsoft-Excel-Logo.png"))); // NOI18N
        jLabel32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel32MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Fimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nfilimss)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namesimss, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(expFimss, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ApimssF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AmimssF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FdiimssF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FZimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nssimssF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rfcimssF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(curpimssF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PuestoimssF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StatusimssF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FBimssF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteimss)
                        .addGap(86, 86, 86)
                        .addComponent(Cs4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32)
                        .addGap(0, 3813, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nfilimss)
                    .addComponent(namesimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteimss)
                    .addComponent(Cs4)
                    .addComponent(Fimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(expFimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ApimssF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmimssF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FdiimssF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FZimss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nssimssF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rfcimssF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PuestoimssF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StatusimssF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FBimssF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(curpimssF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane6.setViewportView(jPanel8);

        RH.addTab("Tabla IMSS", jScrollPane6);

        Menuadm.setText("Todas las ventanas");

        jMenu2.setText("Area Nomina");

        jMenu3.setText("Nomina quincenal");

        ODT.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ODT.setText("Ordenes de taller");
        ODT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ODTActionPerformed(evt);
            }
        });
        jMenu3.add(ODT);

        CNQ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CNQ.setText("Nomina IMSS");
        CNQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNQActionPerformed(evt);
            }
        });
        jMenu3.add(CNQ);

        PRESQ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        PRESQ.setText("Prestamos");
        PRESQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRESQActionPerformed(evt);
            }
        });
        jMenu3.add(PRESQ);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem5.setText("Nomina General");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        CDA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CDA.setText("Caja de ahorro");
        CDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDAActionPerformed(evt);
            }
        });
        jMenu3.add(CDA);

        jMenu2.add(jMenu3);

        jMenu4.setText("Semanal");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem6.setText("Nomina Semanal IMSS");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem7.setText("Prestamos Semanales");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem8.setText("Nomina Semanal General");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        CDA4.setText("Caja de ahorro");
        CDA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDA4ActionPerformed(evt);
            }
        });
        jMenu4.add(CDA4);

        ODT2.setText("Ordenes de taller");
        ODT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ODT2ActionPerformed(evt);
            }
        });
        jMenu4.add(ODT2);

        jMenu2.add(jMenu4);

        LDA.setText("Listas de asistencia C/IMSS ");
        LDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LDAActionPerformed(evt);
            }
        });
        jMenu2.add(LDA);

        LDA3.setText("Listas de asistencia S/IMSS");
        LDA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LDA3ActionPerformed(evt);
            }
        });
        jMenu2.add(LDA3);

        Menuadm.add(jMenu2);

        jMenu5.setText("Area RH");

        General1.setText("Empleados General");
        General1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                General1ActionPerformed(evt);
            }
        });
        jMenu5.add(General1);

        Estadias.setText("Alumno de estadia");
        Estadias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadiasActionPerformed(evt);
            }
        });
        jMenu5.add(Estadias);

        Torteria.setText("Empleados Torteria");
        Torteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TorteriaActionPerformed(evt);
            }
        });
        jMenu5.add(Torteria);

        jMenu6.setText("Semanales");

        jMenuItem10.setText("Inturbide");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuItem11.setText("Tehuantepec");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuItem12.setText("PTE titla");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenuItem22.setText("Reimprimir vale");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem22);

        jMenuItem23.setText("Generar vale de efectivo");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem23);

        jMenuItem17.setText("Generar padron");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem17);

        jMenu5.add(jMenu6);

        Depositos2.setText("Depositos");

        jMenu10.setText("Quincenales");

        jMenuItem18.setText("Depositos C/ IMSS");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem18);

        jMenuItem19.setText("Depositos S/ IMSS");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem19);

        Depositos2.add(jMenu10);

        jMenu11.setText("Semanales");

        jMenuItem20.setText("Depositos C/ IMSS");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem20);

        jMenuItem21.setText("Depositos S/ IMSS");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem21);

        Depositos2.add(jMenu11);

        jMenu5.add(Depositos2);

        Menuadm.add(jMenu5);

        ZYS.setText("Zonas y Servicios");
        ZYS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZYSActionPerformed(evt);
            }
        });
        Menuadm.add(ZYS);

        ADMV1.setText("Usuarios");
        ADMV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMV1ActionPerformed(evt);
            }
        });
        Menuadm.add(ADMV1);

        jMenuBar1.add(Menuadm);

        jMenu1.setText("Cambiar a:");

        Alumnos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Alumnos.setText("Alumnos estadia");
        Alumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlumnosActionPerformed(evt);
            }
        });
        jMenu1.add(Alumnos);

        EmpleadosT.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        EmpleadosT.setText("Empelados torteria");
        EmpleadosT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpleadosTActionPerformed(evt);
            }
        });
        jMenu1.add(EmpleadosT);

        Depositos.setText("Depositos");

        jMenu7.setText("Quincenales");

        jMenuItem1.setText("Depositos C/ IMSS");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem1);

        jMenuItem9.setText("Depositos S/ IMSS");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem9);

        jMenuItem24.setText("Santander Depositos C/ IMSS");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem24);

        jMenuItem25.setText("Santander Depositos S/ IMSS");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem25);

        Depositos.add(jMenu7);

        jMenu8.setText("Semanales");

        jMenuItem15.setText("Depositos C/ IMSS");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem15);

        jMenuItem16.setText("Depositos S/ IMSS");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem16);

        jMenuItem26.setText("Santander Depositos C/ IMSS");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem26);

        jMenuItem27.setText("Santander Depositos S/ IMSS");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem27);

        Depositos.add(jMenu8);

        jMenu1.add(Depositos);

        Usuarios.setText("Usuarios");
        Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(Usuarios);

        jMenuBar1.add(jMenu1);

        Semanales.setText("Semanales");

        jMenuItem2.setText("Iturbide");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Semanales.add(jMenuItem2);

        jMenuItem3.setText("Tehuantepec");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Semanales.add(jMenuItem3);

        jMenuItem4.setText("PTE titla");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Semanales.add(jMenuItem4);

        jMenuItem13.setText("Generar vale de efectivo");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        Semanales.add(jMenuItem13);

        jMenuItem14.setText("Generar padron");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        Semanales.add(jMenuItem14);

        jMenuBar1.add(Semanales);

        jMenu9.setText("Seguridad.");

        jMenuItem28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IcoCDU.png"))); // NOI18N
        jMenuItem28.setText("Cambiar de usuario");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem28);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RH, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RH, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addimssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addimssActionPerformed

        AgregarI();
        MDIMSS();
        limpimms();
    }//GEN-LAST:event_addimssActionPerformed

    private void modIMSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modIMSSActionPerformed

        ModIMSS();
        MDIMSS();
        limpimms();
    }//GEN-LAST:event_modIMSSActionPerformed

    private void elimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimActionPerformed

        DelGen();
        MDEm();
        CleanGen();
    }//GEN-LAST:event_elimActionPerformed

    private void dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataMouseClicked

        DefaultTableModel model = (DefaultTableModel) data.getModel();

        try {
            int fila = data.getSelectedRow();
            int id = Integer.parseInt(data.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("select * from `rh.empleados` where `# Exp` = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                switch (rs.getString("Entra a imss")) {
                    case "SI" ->
                        EIMSS.setSelected(true);
                    case "Si" ->
                        EIMSS.setSelected(true);
                    case "" ->
                        EIMSS.setSelected(false);
                    case "No" ->
                        EIMSS.setSelected(false);
                    case "NO" ->
                        EIMSS.setSelected(false);
                    default -> {
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }
        int fila = data.getSelectedRow();
        NExp.setText(String.valueOf(data.getValueAt(fila, 0)));
        APgen.setText(String.valueOf(data.getValueAt(fila, 2)));
        AMgen.setText(String.valueOf(data.getValueAt(fila, 3)));
        NameGen.setText(String.valueOf(data.getValueAt(fila, 4)));
        Celular.setText(String.valueOf(data.getValueAt(fila, 5)));
        Casa.setText(String.valueOf(data.getValueAt(fila, 6)));
        Rec.setText(String.valueOf(data.getValueAt(fila, 7)));

//combobox1
        String combo1 = model.getValueAt(fila, 8).toString();
        for (int i = 0; i < fdp.getItemCount(); i++) {
            if (fdp.getItemAt(i).equalsIgnoreCase(combo1)) {
                fdp.setSelectedIndex(i);
            }
        }

        Sueldo.setText(String.valueOf(data.getValueAt(fila, 9)));
        Bono.setText(String.valueOf(data.getValueAt(fila, 10)));

        //combobox2
        String combo2 = model.getValueAt(fila, 11).toString();
        for (int i = 0; i < Banco.getItemCount(); i++) {
            if (Banco.getItemAt(i).equalsIgnoreCase(combo2)) {
                Banco.setSelectedIndex(i);
            }
        }
        cta.setText(String.valueOf(data.getValueAt(fila, 12)));

        //combobox5
        String combo5 = model.getValueAt(fila, 15).toString();
        for (int i = 0; i < Status.getItemCount(); i++) {
            if (Status.getItemAt(i).equalsIgnoreCase(combo5)) {
                Status.setSelectedIndex(i);
            }
        }
        FE.setText(String.valueOf(data.getValueAt(fila, 16)));
        FI.setText(String.valueOf(data.getValueAt(fila, 17)));
        UDL.setText(String.valueOf(data.getValueAt(fila, 18)));
        FFB.setText(String.valueOf(data.getValueAt(fila, 19)));

        //combobox7
        String combo7 = model.getValueAt(fila, 20).toString();
        for (int i = 0; i < bf.getItemCount(); i++) {
            if (bf.getItemAt(i).equalsIgnoreCase(combo7)) {
                bf.setSelectedIndex(i);
            }
        }
        String combo8 = model.getValueAt(fila, 21).toString();
        for (int i = 0; i < cfin.getItemCount(); i++) {
            if (cfin.getItemAt(i).equalsIgnoreCase(combo8)) {
                cfin.setSelectedIndex(i);
            }
        }

        ADA.setText(String.valueOf(data.getValueAt(fila, 22)));
        RFC.setText(String.valueOf(data.getValueAt(fila, 23)));
        NSS.setText(String.valueOf(data.getValueAt(fila, 24)));
        CURP.setText(String.valueOf(data.getValueAt(fila, 25)));
        Correo.setText(String.valueOf(data.getValueAt(fila, 26)));
        Calle.setText(String.valueOf(data.getValueAt(fila, 27)));
        INT.setText(String.valueOf(data.getValueAt(fila, 28)));
        Exterior.setText(String.valueOf(data.getValueAt(fila, 29)));
        Colonia.setText(String.valueOf(data.getValueAt(fila, 30)));
        DLGMUN.setText(String.valueOf(data.getValueAt(fila, 31)));
        CP.setText(String.valueOf(data.getValueAt(fila, 32)));
        DO.setText(String.valueOf(data.getValueAt(fila, 33)));
        DF.setText(String.valueOf(data.getValueAt(fila, 34)));
        DE.setText(String.valueOf(data.getValueAt(fila, 35)));
        NRP.setText(String.valueOf(data.getValueAt(fila, 36)));
        NDC.setText(String.valueOf(data.getValueAt(fila, 37)));
        Obs.setText(String.valueOf(data.getValueAt(fila, 38)));
        ObsTgen.setText(String.valueOf(data.getValueAt(fila, 38)));

        //combobox8

    }//GEN-LAST:event_dataMouseClicked

    private void FiltroNGKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiltroNGKeyReleased

        MDEm();
    }//GEN-LAST:event_FiltroNGKeyReleased

    private void Cs3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cs3ActionPerformed

        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres cerrar la sesion?");
        if (i == 0) {
            Inicio_1 regr = new Inicio_1();
            regr.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_Cs3ActionPerformed

    private void Cs2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cs2ActionPerformed

        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres cerrar la sesion?");
        if (i == 0) {
            Inicio_1 regr = new Inicio_1();
            regr.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_Cs2ActionPerformed

    private void FiltroFDIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiltroFDIKeyReleased

        MDEm();
    }//GEN-LAST:event_FiltroFDIKeyReleased

    private void FiltroZGeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FiltroZGeItemStateChanged

        FZGen();
    }//GEN-LAST:event_FiltroZGeItemStateChanged

    private void FiltroServGenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FiltroServGenItemStateChanged

        FServGen();
    }//GEN-LAST:event_FiltroServGenItemStateChanged

    private void FiltroStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FiltroStatusItemStateChanged

        FstatusGen();
    }//GEN-LAST:event_FiltroStatusItemStateChanged

    private void FiltroCurpGenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiltroCurpGenKeyReleased

        MDEm();
    }//GEN-LAST:event_FiltroCurpGenKeyReleased

    private void FiltroNSSGenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiltroNSSGenKeyReleased

        MDEm();
    }//GEN-LAST:event_FiltroNSSGenKeyReleased

    private void AlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlumnosActionPerformed

        Estadias_4 regr = new Estadias_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AlumnosActionPerformed

    private void EmpleadosTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpleadosTActionPerformed

        Tortas_4 regr = new Tortas_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EmpleadosTActionPerformed

    private void FiltroSZGenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FiltroSZGenItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            FiltrosZonas zon = (FiltrosZonas) FiltroSZGen.getSelectedItem();
            FiltroServ serv = new FiltroServ();
            DefaultComboBoxModel modelServicio = new DefaultComboBoxModel(serv.mostrarservicio(zon.getId()));
            FiltroServGen.setModel(modelServicio);
        }

    }//GEN-LAST:event_FiltroSZGenItemStateChanged

    private void FiltrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FiltrosItemStateChanged

        String Filtrosgen = (String) Filtros.getSelectedItem();
        if (Filtrosgen.equals("Selecciona Filtro")) {
            Filtroam.setVisible(false);
            Filtroap.setVisible(false);
            FiltroNG.setVisible(false);
            LabelF1.setVisible(false);
            LabelF2.setVisible(false);
            FiltroCurpGen.setVisible(false);
            FiltroFDI.setVisible(false);
            FiltroNSSGen.setVisible(false);
            FiltroSZGen.setVisible(false);
            FiltroStatus.setVisible(false);
            FiltroServGen.setVisible(false);
            FiltroZGe.setVisible(false);
            Filobs.setVisible(false);
            Filobs.setText("");
            Filtroap.setText("");
            Filtroam.setText("");
            FiltroNG.setText("");
            FiltroCurpGen.setText("");
            FiltroFDI.setText("");
            FiltroNSSGen.setText("");
            FiltroSZGen.setSelectedIndex(0);
            FiltroStatus.setSelectedIndex(0);
            FiltroServGen.setSelectedIndex(0);
            FiltroZGe.setSelectedIndex(0);
            MDEm();
        }
        if (Filtrosgen.equals("Apellido P")) {
            Filtroam.setVisible(false);
            Filtroam.setText("");
            Filtroap.setVisible(true);
            Filtroap.setText("");
            FiltroNG.setVisible(false);
            FiltroNG.setText("");
            LabelF1.setVisible(true);
            LabelF1.setText("Buscar por Apellido P:");
            LabelF2.setVisible(false);
            FiltroCurpGen.setVisible(false);
            FiltroCurpGen.setText("");
            FiltroFDI.setVisible(false);
            FiltroFDI.setText("");
            FiltroNSSGen.setVisible(false);
            FiltroNSSGen.setText("");
            FiltroSZGen.setVisible(false);
            FiltroSZGen.setSelectedIndex(0);
            FiltroStatus.setVisible(false);
            FiltroStatus.setSelectedIndex(0);
            FiltroServGen.setVisible(false);
            FiltroServGen.setSelectedIndex(0);
            FiltroZGe.setVisible(false);
            FiltroZGe.setSelectedIndex(0);
            Filobs.setVisible(false);
            Filobs.setText("");
            MDEm();
        }
        if (Filtrosgen.equals("Apellido M")) {
            Filtroam.setVisible(true);
            Filtroap.setVisible(false);
            FiltroNG.setVisible(false);
            LabelF1.setVisible(true);
            LabelF1.setText("Buscar por Apellido M:");
            LabelF2.setVisible(false);
            FiltroCurpGen.setVisible(false);
            FiltroFDI.setVisible(false);
            FiltroNSSGen.setVisible(false);
            FiltroSZGen.setVisible(false);
            FiltroStatus.setVisible(false);
            FiltroServGen.setVisible(false);
            FiltroZGe.setVisible(false);
            Filobs.setVisible(false);
            Filobs.setText("");
            Filtroap.setText("");
            Filtroam.setText("");
            FiltroNG.setText("");
            FiltroCurpGen.setText("");
            FiltroFDI.setText("");
            FiltroNSSGen.setText("");
            FiltroSZGen.setSelectedIndex(0);
            FiltroStatus.setSelectedIndex(0);
            FiltroServGen.setSelectedIndex(0);
            FiltroZGe.setSelectedIndex(0);
            MDEm();
        }
        if (Filtrosgen.equals("Nombre(s)")) {
            Filtroam.setVisible(false);
            Filtroap.setVisible(false);
            FiltroNG.setVisible(true);
            LabelF1.setVisible(true);
            LabelF1.setText("Buscar por Nombre(s):");
            LabelF2.setVisible(false);
            FiltroCurpGen.setVisible(false);
            FiltroFDI.setVisible(false);
            FiltroNSSGen.setVisible(false);
            FiltroSZGen.setVisible(false);
            FiltroStatus.setVisible(false);
            FiltroServGen.setVisible(false);
            FiltroZGe.setVisible(false);
            Filobs.setVisible(false);
            Filobs.setText("");
            Filtroap.setText("");
            Filtroam.setText("");
            FiltroNG.setText("");
            FiltroCurpGen.setText("");
            FiltroFDI.setText("");
            FiltroNSSGen.setText("");
            FiltroSZGen.setSelectedIndex(0);
            FiltroStatus.setSelectedIndex(0);
            FiltroServGen.setSelectedIndex(0);
            FiltroZGe.setSelectedIndex(0);
            MDEm();

        }
        if (Filtrosgen.equals("Zona")) {
            Filtroam.setVisible(false);
            Filtroap.setVisible(false);
            FiltroNG.setVisible(false);
            LabelF1.setVisible(true);
            LabelF1.setText("Buscar por Zona:");
            LabelF2.setVisible(false);
            FiltroCurpGen.setVisible(false);
            FiltroFDI.setVisible(false);
            FiltroNSSGen.setVisible(false);
            FiltroSZGen.setVisible(false);
            FiltroStatus.setVisible(false);
            FiltroServGen.setVisible(false);
            FiltroZGe.setVisible(true);
            Filobs.setVisible(false);
            Filobs.setText("");
            Filtroap.setText("");
            Filtroam.setText("");
            FiltroNG.setText("");
            FiltroCurpGen.setText("");
            FiltroFDI.setText("");
            FiltroNSSGen.setText("");
            FiltroSZGen.setSelectedIndex(0);
            FiltroStatus.setSelectedIndex(0);
            FiltroServGen.setSelectedIndex(0);
            FiltroZGe.setSelectedIndex(0);
            MDEm();

        }
        if (Filtrosgen.equals("Servicio")) {
            Filtroam.setVisible(false);
            Filtroap.setVisible(false);
            FiltroNG.setVisible(false);
            LabelF1.setVisible(true);
            LabelF1.setText("Selecciona Zona:");
            LabelF2.setVisible(true);
            LabelF2.setText("Selecciona servicio:");
            FiltroCurpGen.setVisible(false);
            FiltroFDI.setVisible(false);
            FiltroNSSGen.setVisible(false);
            FiltroSZGen.setVisible(true);
            FiltroStatus.setVisible(false);
            FiltroServGen.setVisible(true);
            FiltroZGe.setVisible(false);
            Filobs.setVisible(false);
            Filobs.setText("");
            Filtroap.setText("");
            Filtroam.setText("");
            FiltroNG.setText("");
            FiltroCurpGen.setText("");
            FiltroFDI.setText("");
            FiltroNSSGen.setText("");
            FiltroSZGen.setSelectedIndex(0);
            FiltroStatus.setSelectedIndex(0);
            FiltroServGen.setSelectedIndex(0);
            FiltroZGe.setSelectedIndex(0);
            MDEm();
        }
        if (Filtrosgen.equals("Fecha de ingreso")) {
            Filtroam.setVisible(false);
            Filtroap.setVisible(false);
            FiltroNG.setVisible(false);
            LabelF1.setVisible(true);
            LabelF1.setText("Buscar Fecha de ingreso");
            LabelF2.setVisible(false);
            FiltroCurpGen.setVisible(false);
            FiltroFDI.setVisible(true);
            FiltroNSSGen.setVisible(false);
            FiltroSZGen.setVisible(false);
            FiltroStatus.setVisible(false);
            FiltroServGen.setVisible(false);
            FiltroZGe.setVisible(false);
            Filobs.setVisible(false);
            Filobs.setText("");
            Filtroap.setText("");
            Filtroam.setText("");
            FiltroNG.setText("");
            FiltroCurpGen.setText("");
            FiltroFDI.setText("");
            FiltroNSSGen.setText("");
            FiltroSZGen.setSelectedIndex(0);
            FiltroStatus.setSelectedIndex(0);
            FiltroServGen.setSelectedIndex(0);
            FiltroZGe.setSelectedIndex(0);
            MDEm();

        }
        if (Filtrosgen.equals("CURP")) {
            Filtroam.setVisible(false);
            Filtroap.setVisible(false);
            FiltroNG.setVisible(false);
            LabelF1.setVisible(true);
            LabelF1.setText("Buscar por CURP:");
            LabelF2.setVisible(false);
            FiltroCurpGen.setVisible(true);
            FiltroFDI.setVisible(false);
            FiltroNSSGen.setVisible(false);
            FiltroSZGen.setVisible(false);
            FiltroStatus.setVisible(false);
            FiltroServGen.setVisible(false);
            FiltroZGe.setVisible(false);
            Filobs.setVisible(false);
            Filobs.setText("");
            Filtroap.setText("");
            Filtroam.setText("");
            FiltroNG.setText("");
            FiltroCurpGen.setText("");
            FiltroFDI.setText("");
            FiltroNSSGen.setText("");
            FiltroSZGen.setSelectedIndex(0);
            FiltroStatus.setSelectedIndex(0);
            FiltroServGen.setSelectedIndex(0);
            FiltroZGe.setSelectedIndex(0);
            MDEm();

        }
        if (Filtrosgen.equals("NSS")) {
            Filtroam.setVisible(false);
            Filtroap.setVisible(false);
            FiltroNG.setVisible(false);
            LabelF1.setVisible(true);
            LabelF1.setText("Buscar por NSS:");
            LabelF2.setVisible(false);
            FiltroCurpGen.setVisible(false);
            FiltroFDI.setVisible(false);
            FiltroNSSGen.setVisible(true);
            FiltroSZGen.setVisible(false);
            FiltroStatus.setVisible(false);
            FiltroServGen.setVisible(false);
            FiltroZGe.setVisible(false);
            Filobs.setVisible(false);
            Filobs.setText("");
            Filtroap.setText("");
            Filtroam.setText("");
            FiltroNG.setText("");
            FiltroCurpGen.setText("");
            FiltroFDI.setText("");
            FiltroNSSGen.setText("");
            FiltroSZGen.setSelectedIndex(0);
            FiltroStatus.setSelectedIndex(0);
            FiltroServGen.setSelectedIndex(0);
            FiltroZGe.setSelectedIndex(0);
            MDEm();

        }
        if (Filtrosgen.equals("Estatus")) {
            Filtroam.setVisible(false);
            Filtroap.setVisible(false);
            FiltroNG.setVisible(false);
            LabelF1.setVisible(true);
            LabelF1.setText("Buscar por Estatus:");
            LabelF2.setVisible(false);
            FiltroCurpGen.setVisible(false);
            FiltroFDI.setVisible(false);
            FiltroNSSGen.setVisible(false);
            FiltroSZGen.setVisible(false);
            FiltroStatus.setVisible(true);
            FiltroServGen.setVisible(false);
            FiltroZGe.setVisible(false);
            Filobs.setVisible(false);
            Filobs.setText("");
            Filtroap.setText("");
            Filtroam.setText("");
            FiltroNG.setText("");
            FiltroCurpGen.setText("");
            FiltroFDI.setText("");
            FiltroNSSGen.setText("");
            FiltroSZGen.setSelectedIndex(0);
            FiltroStatus.setSelectedIndex(0);
            FiltroServGen.setSelectedIndex(0);
            FiltroZGe.setSelectedIndex(0);
            MDEm();

        }
        if (Filtrosgen.equals("Observaciones")) {
            Filtroam.setVisible(false);
            Filtroap.setVisible(false);
            FiltroNG.setVisible(false);
            LabelF1.setVisible(true);
            LabelF1.setText("Buscar por Observacion:");
            LabelF2.setVisible(false);
            FiltroCurpGen.setVisible(false);
            FiltroFDI.setVisible(false);
            FiltroNSSGen.setVisible(false);
            FiltroSZGen.setVisible(false);
            FiltroStatus.setVisible(false);
            FiltroServGen.setVisible(false);
            FiltroZGe.setVisible(false);
            Filobs.setVisible(true);
            Filobs.setText("");
            Filtroap.setText("");
            Filtroam.setText("");
            FiltroNG.setText("");
            FiltroCurpGen.setText("");
            FiltroFDI.setText("");
            FiltroNSSGen.setText("");
            FiltroSZGen.setSelectedIndex(0);
            FiltroStatus.setSelectedIndex(0);
            FiltroServGen.setSelectedIndex(0);
            FiltroZGe.setSelectedIndex(0);
            MDEm();
        }

    }//GEN-LAST:event_FiltrosItemStateChanged

    private void FiltroapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiltroapKeyReleased

        MDEm();
    }//GEN-LAST:event_FiltroapKeyReleased

    private void FiltroamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiltroamKeyReleased

        MDEm();
    }//GEN-LAST:event_FiltroamKeyReleased

    private void FBimssFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FBimssFKeyReleased
        MDIMSS();
    }//GEN-LAST:event_FBimssFKeyReleased

    private void StatusimssFItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_StatusimssFItemStateChanged
        FStatusimss();
    }//GEN-LAST:event_StatusimssFItemStateChanged

    private void PuestoimssFItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PuestoimssFItemStateChanged
        FPuestoimss();
    }//GEN-LAST:event_PuestoimssFItemStateChanged

    private void curpimssFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_curpimssFKeyReleased
        MDIMSS();
    }//GEN-LAST:event_curpimssFKeyReleased

    private void rfcimssFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rfcimssFKeyReleased
        MDIMSS();
    }//GEN-LAST:event_rfcimssFKeyReleased

    private void nssimssFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nssimssFKeyReleased
        MDIMSS();
    }//GEN-LAST:event_nssimssFKeyReleased

    private void FZimssItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FZimssItemStateChanged
        FiltroZimss();
    }//GEN-LAST:event_FZimssItemStateChanged

    private void FdiimssFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FdiimssFKeyReleased
        MDIMSS();
    }//GEN-LAST:event_FdiimssFKeyReleased

    private void AmimssFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmimssFKeyReleased
        MDIMSS();
    }//GEN-LAST:event_AmimssFKeyReleased

    private void ApimssFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ApimssFKeyReleased
        MDIMSS();
    }//GEN-LAST:event_ApimssFKeyReleased

    private void expFimssKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expFimssKeyReleased
        MDIMSS();
    }//GEN-LAST:event_expFimssKeyReleased

    private void FimssItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FimssItemStateChanged

        String dt = (String) Fimss.getSelectedItem();
        if (dt.equals("Selecciona filtro")) {
            namesimss.setText("");
            namesimss.setVisible(false);
            expFimss.setText("");
            expFimss.setVisible(false);
            ApimssF.setText("");
            ApimssF.setVisible(false);
            AmimssF.setText("");
            AmimssF.setVisible(false);
            FdiimssF.setText("");
            FdiimssF.setVisible(false);
            nssimssF.setText("");
            nssimssF.setVisible(false);
            rfcimssF.setText("");
            rfcimssF.setVisible(false);
            curpimssF.setText("");
            curpimssF.setVisible(false);
            FBimssF.setText("");
            FBimssF.setVisible(false);
            FZimss.setSelectedIndex(0);
            FZimss.setVisible(false);
            PuestoimssF.setSelectedIndex(0);
            PuestoimssF.setVisible(false);
            StatusimssF.setSelectedIndex(0);
            StatusimssF.setVisible(false);
            Nfilimss.setVisible(false);
            MDIMSS();

        }
        if (dt.equals("# Exp")) {
            namesimss.setText("");
            namesimss.setVisible(false);
            expFimss.setText("");
            expFimss.setVisible(true);
            ApimssF.setText("");
            ApimssF.setVisible(false);
            AmimssF.setText("");
            AmimssF.setVisible(false);
            FdiimssF.setText("");
            FdiimssF.setVisible(false);
            nssimssF.setText("");
            nssimssF.setVisible(false);
            rfcimssF.setText("");
            rfcimssF.setVisible(false);
            curpimssF.setText("");
            curpimssF.setVisible(false);
            FBimssF.setText("");
            FBimssF.setVisible(false);
            FZimss.setSelectedIndex(0);
            FZimss.setVisible(false);
            PuestoimssF.setSelectedIndex(0);
            PuestoimssF.setVisible(false);
            StatusimssF.setSelectedIndex(0);
            StatusimssF.setVisible(false);
            Nfilimss.setText("Buscar por # de expediente:");
            Nfilimss.setVisible(true);
            MDIMSS();

        }
        if (dt.equals("Apellido P")) {
            namesimss.setText("");
            namesimss.setVisible(false);
            expFimss.setText("");
            expFimss.setVisible(false);
            ApimssF.setText("");
            ApimssF.setVisible(true);
            AmimssF.setText("");
            AmimssF.setVisible(false);
            FdiimssF.setText("");
            FdiimssF.setVisible(false);
            nssimssF.setText("");
            nssimssF.setVisible(false);
            rfcimssF.setText("");
            rfcimssF.setVisible(false);
            curpimssF.setText("");
            curpimssF.setVisible(false);
            FBimssF.setText("");
            FBimssF.setVisible(false);
            FZimss.setSelectedIndex(0);
            FZimss.setVisible(false);
            PuestoimssF.setSelectedIndex(0);
            PuestoimssF.setVisible(false);
            StatusimssF.setSelectedIndex(0);
            StatusimssF.setVisible(false);
            Nfilimss.setText("Buscar por Apellido Paterno: ");
            Nfilimss.setVisible(true);
            MDIMSS();
        }
        if (dt.equals("Apellido M")) {
            namesimss.setText("");
            namesimss.setVisible(false);
            expFimss.setText("");
            expFimss.setVisible(false);
            ApimssF.setText("");
            ApimssF.setVisible(false);
            AmimssF.setText("");
            AmimssF.setVisible(true);
            FdiimssF.setText("");
            FdiimssF.setVisible(false);
            nssimssF.setText("");
            nssimssF.setVisible(false);
            rfcimssF.setText("");
            rfcimssF.setVisible(false);
            curpimssF.setText("");
            curpimssF.setVisible(false);
            FBimssF.setText("");
            FBimssF.setVisible(false);
            FZimss.setSelectedIndex(0);
            FZimss.setVisible(false);
            PuestoimssF.setSelectedIndex(0);
            PuestoimssF.setVisible(false);
            StatusimssF.setSelectedIndex(0);
            StatusimssF.setVisible(false);
            Nfilimss.setText("Buscar por Apellido Materno: ");
            Nfilimss.setVisible(true);
            MDIMSS();

        }
        if (dt.equals("Nombre(s)")) {
            namesimss.setText("");
            namesimss.setVisible(true);
            expFimss.setText("");
            expFimss.setVisible(false);
            ApimssF.setText("");
            ApimssF.setVisible(false);
            AmimssF.setText("");
            AmimssF.setVisible(false);
            FdiimssF.setText("");
            FdiimssF.setVisible(false);
            nssimssF.setText("");
            nssimssF.setVisible(false);
            rfcimssF.setText("");
            rfcimssF.setVisible(false);
            curpimssF.setText("");
            curpimssF.setVisible(false);
            FBimssF.setText("");
            FBimssF.setVisible(false);
            FZimss.setSelectedIndex(0);
            FZimss.setVisible(false);
            PuestoimssF.setSelectedIndex(0);
            PuestoimssF.setVisible(false);
            StatusimssF.setSelectedIndex(0);
            StatusimssF.setVisible(false);
            Nfilimss.setText("Buscar por Nombre(s): ");
            Nfilimss.setVisible(true);
            MDIMSS();

        }
        if (dt.equals("Fecha de incorporacion")) {
            namesimss.setText("");
            namesimss.setVisible(false);
            expFimss.setText("");
            expFimss.setVisible(false);
            ApimssF.setText("");
            ApimssF.setVisible(false);
            AmimssF.setText("");
            AmimssF.setVisible(false);
            FdiimssF.setText("");
            FdiimssF.setVisible(true);
            nssimssF.setText("");
            nssimssF.setVisible(false);
            rfcimssF.setText("");
            rfcimssF.setVisible(false);
            curpimssF.setText("");
            curpimssF.setVisible(false);
            FBimssF.setText("");
            FBimssF.setVisible(false);
            FZimss.setSelectedIndex(0);
            FZimss.setVisible(false);
            PuestoimssF.setSelectedIndex(0);
            PuestoimssF.setVisible(false);
            StatusimssF.setSelectedIndex(0);
            StatusimssF.setVisible(false);
            Nfilimss.setText("Buscar por Fecha de incorporacion: ");
            Nfilimss.setVisible(true);
            MDIMSS();
        }
        if (dt.equals("Zona")) {
            namesimss.setText("");
            namesimss.setVisible(false);
            expFimss.setText("");
            expFimss.setVisible(false);
            ApimssF.setText("");
            ApimssF.setVisible(false);
            AmimssF.setText("");
            AmimssF.setVisible(false);
            FdiimssF.setText("");
            FdiimssF.setVisible(false);
            nssimssF.setText("");
            nssimssF.setVisible(false);
            rfcimssF.setText("");
            rfcimssF.setVisible(false);
            curpimssF.setText("");
            curpimssF.setVisible(false);
            FBimssF.setText("");
            FBimssF.setVisible(false);
            FZimss.setSelectedIndex(0);
            FZimss.setVisible(true);
            PuestoimssF.setSelectedIndex(0);
            PuestoimssF.setVisible(false);
            StatusimssF.setSelectedIndex(0);
            StatusimssF.setVisible(false);
            Nfilimss.setText("Buscar por Zona: ");
            Nfilimss.setVisible(true);
            MDIMSS();

        }
        if (dt.equals("NSS")) {
            namesimss.setText("");
            namesimss.setVisible(false);
            expFimss.setText("");
            expFimss.setVisible(false);
            ApimssF.setText("");
            ApimssF.setVisible(false);
            AmimssF.setText("");
            AmimssF.setVisible(false);
            FdiimssF.setText("");
            FdiimssF.setVisible(false);
            nssimssF.setText("");
            nssimssF.setVisible(true);
            rfcimssF.setText("");
            rfcimssF.setVisible(false);
            curpimssF.setText("");
            curpimssF.setVisible(false);
            FBimssF.setText("");
            FBimssF.setVisible(false);
            FZimss.setSelectedIndex(0);
            FZimss.setVisible(false);
            PuestoimssF.setSelectedIndex(0);
            PuestoimssF.setVisible(false);
            StatusimssF.setSelectedIndex(0);
            StatusimssF.setVisible(false);
            Nfilimss.setText("Buscar por NSS: ");
            Nfilimss.setVisible(true);
            MDIMSS();
        }
        if (dt.equals("RFC")) {
            namesimss.setText("");
            namesimss.setVisible(false);
            expFimss.setText("");
            expFimss.setVisible(false);
            ApimssF.setText("");
            ApimssF.setVisible(false);
            AmimssF.setText("");
            AmimssF.setVisible(false);
            FdiimssF.setText("");
            FdiimssF.setVisible(false);
            nssimssF.setText("");
            nssimssF.setVisible(false);
            rfcimssF.setText("");
            rfcimssF.setVisible(true);
            curpimssF.setText("");
            curpimssF.setVisible(false);
            FBimssF.setText("");
            FBimssF.setVisible(false);
            FZimss.setSelectedIndex(0);
            FZimss.setVisible(false);
            PuestoimssF.setSelectedIndex(0);
            PuestoimssF.setVisible(false);
            StatusimssF.setSelectedIndex(0);
            StatusimssF.setVisible(false);
            Nfilimss.setText("Buscar por RFC: ");
            Nfilimss.setVisible(true);
            MDIMSS();

        }
        if (dt.equals("CURP")) {
            namesimss.setText("");
            namesimss.setVisible(false);
            expFimss.setText("");
            expFimss.setVisible(false);
            ApimssF.setText("");
            ApimssF.setVisible(false);
            AmimssF.setText("");
            AmimssF.setVisible(false);
            FdiimssF.setText("");
            FdiimssF.setVisible(false);
            nssimssF.setText("");
            nssimssF.setVisible(false);
            rfcimssF.setText("");
            rfcimssF.setVisible(false);
            curpimssF.setText("");
            curpimssF.setVisible(true);
            FBimssF.setText("");
            FBimssF.setVisible(false);
            FZimss.setSelectedIndex(0);
            FZimss.setVisible(false);
            PuestoimssF.setSelectedIndex(0);
            PuestoimssF.setVisible(false);
            StatusimssF.setSelectedIndex(0);
            StatusimssF.setVisible(false);
            Nfilimss.setText("Buscar por CURP: ");
            Nfilimss.setVisible(true);
            MDIMSS();

        }
        if (dt.equals("Puesto")) {
            namesimss.setText("");
            namesimss.setVisible(false);
            expFimss.setText("");
            expFimss.setVisible(false);
            ApimssF.setText("");
            ApimssF.setVisible(false);
            AmimssF.setText("");
            AmimssF.setVisible(false);
            FdiimssF.setText("");
            FdiimssF.setVisible(false);
            nssimssF.setText("");
            nssimssF.setVisible(false);
            rfcimssF.setText("");
            rfcimssF.setVisible(false);
            curpimssF.setText("");
            curpimssF.setVisible(false);
            FBimssF.setText("");
            FBimssF.setVisible(false);
            FZimss.setSelectedIndex(0);
            FZimss.setVisible(false);
            PuestoimssF.setSelectedIndex(0);
            PuestoimssF.setVisible(true);
            StatusimssF.setSelectedIndex(0);
            StatusimssF.setVisible(false);
            Nfilimss.setText("Buscar por Puesto: ");
            Nfilimss.setVisible(true);
            MDIMSS();

        }
        if (dt.equals("Status")) {
            namesimss.setText("");
            namesimss.setVisible(false);
            expFimss.setText("");
            expFimss.setVisible(false);
            ApimssF.setText("");
            ApimssF.setVisible(false);
            AmimssF.setText("");
            AmimssF.setVisible(false);
            FdiimssF.setText("");
            FdiimssF.setVisible(false);
            nssimssF.setText("");
            nssimssF.setVisible(false);
            rfcimssF.setText("");
            rfcimssF.setVisible(false);
            curpimssF.setText("");
            curpimssF.setVisible(false);
            FBimssF.setText("");
            FBimssF.setVisible(false);
            FZimss.setSelectedIndex(0);
            FZimss.setVisible(false);
            PuestoimssF.setSelectedIndex(0);
            PuestoimssF.setVisible(false);
            StatusimssF.setSelectedIndex(0);
            StatusimssF.setVisible(true);
            Nfilimss.setText("Buscar por Status: ");
            Nfilimss.setVisible(true);
            MDIMSS();

        }
        if (dt.equals("Fecha de baja")) {
            namesimss.setText("");
            namesimss.setVisible(false);
            expFimss.setText("");
            expFimss.setVisible(false);
            ApimssF.setText("");
            ApimssF.setVisible(false);
            AmimssF.setText("");
            AmimssF.setVisible(false);
            FdiimssF.setText("");
            FdiimssF.setVisible(false);
            nssimssF.setText("");
            nssimssF.setVisible(false);
            rfcimssF.setText("");
            rfcimssF.setVisible(false);
            curpimssF.setText("");
            curpimssF.setVisible(false);
            FBimssF.setText("");
            FBimssF.setVisible(true);
            FZimss.setSelectedIndex(0);
            FZimss.setVisible(false);
            PuestoimssF.setSelectedIndex(0);
            PuestoimssF.setVisible(false);
            StatusimssF.setSelectedIndex(0);
            StatusimssF.setVisible(false);
            Nfilimss.setText("Buscar por Fecha baja: ");
            Nfilimss.setVisible(true);
            MDIMSS();

        }
    }//GEN-LAST:event_FimssItemStateChanged

    private void Cs4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cs4ActionPerformed

        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres cerrar la sesion?");
        if (i == 0) {
            Inicio_1 regr = new Inicio_1();
            regr.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_Cs4ActionPerformed

    private void namesimssKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namesimssKeyReleased

        MDIMSS();
    }//GEN-LAST:event_namesimssKeyReleased

    private void TimssMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimssMouseClicked

        DefaultTableModel model = (DefaultTableModel) Timss.getModel();

        try {

            int fila = Timss.getSelectedRow();

            //combo1
            String combo10 = model.getValueAt(fila, 4).toString();
            for (int i = 0; i < gen.getItemCount(); i++) {
                if (gen.getItemAt(i).equalsIgnoreCase(combo10)) {
                    gen.setSelectedIndex(i);
                }
            }

            //Combo3
            String combo12 = model.getValueAt(fila, 12).toString();
            for (int i = 0; i < puesto.getItemCount(); i++) {
                if (puesto.getItemAt(i).equalsIgnoreCase(combo12)) {
                    puesto.setSelectedIndex(i);
                }
            }
            //Combo4
            String combo13 = model.getValueAt(fila, 14).toString();
            for (int i = 0; i < Status1.getItemCount(); i++) {
                if (Status1.getItemAt(i).equalsIgnoreCase(combo13)) {
                    Status1.setSelectedIndex(i);
                }
            }

            int id = Integer.parseInt(Timss.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("select * from imss where idimss =?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            java.sql.Statement st = con.createStatement();
            while (rs.next()) {
                expimss.setText(String.valueOf(id));
                expimss.setText(rs.getString("idimss"));
                APimss.setText(rs.getString("Apellido P"));
                AMimss.setText(rs.getString("Apellido M"));
                nameimss.setText(rs.getString("Nombre(s)"));
                zona1.setText(rs.getString("Zona_Imss"));
                Servimss.setText(rs.getString("servicio"));
                rfcimss.setText(rs.getString("rfc_imss"));
                nssimss.setText(rs.getString("nss_imss"));
                curpimss.setText(rs.getString("curp_imss"));
                sueldoimss.setText(rs.getString("salario"));
                obsimss.setText(rs.getString("observaciones"));
                FIimss.setText(rs.getString("Fecha_de_incorporacion"));
                FBimss.setText(rs.getString("fecha_baja"));
                FDREimss.setText(rs.getString("Fecha de reingreso"));
                FBREimss.setText(rs.getString("fecha baja (re)"));
                ADEIMSS.setText(rs.getString("fecha de antiguedad"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }
    }//GEN-LAST:event_TimssMouseClicked

    private void deleteimssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteimssActionPerformed

        DelIMSS();
        MDIMSS();
        limpimms();
    }//GEN-LAST:event_deleteimssActionPerformed

    private void FilobsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilobsActionPerformed
    }//GEN-LAST:event_FilobsActionPerformed

    private void FilobsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilobsKeyReleased
        MDEm();
    }//GEN-LAST:event_FilobsKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DepositosQ_4 regr = new DepositosQ_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Iturbide_4 regr = new Iturbide_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Tehuantepec_4 regr = new Tehuantepec_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        PT_4 regr = new PT_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void CsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CsActionPerformed

        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres cerrar la sesion?");
        if (i == 0) {
            Inicio_1 regr = new Inicio_1();
            regr.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_CsActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        AgregarE();
        CleanGen();

        MDEm();
    }//GEN-LAST:event_addActionPerformed

    private void modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modActionPerformed

        int i = JOptionPane.showConfirmDialog(this, "Recuerda que debes volver a seleccionar la zona y servicio. ¿Seguro que quieres realizar la modificacion?");
        if (i == 0) {
            ModEm();
            CleanGen();
            MDEm();
        }
    }//GEN-LAST:event_modActionPerformed

    private void AADAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AADAActionPerformed
        if (FI.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llena el campo fecha de ingreso con el siguiente formato de fecha: dd/MM/yyyy (01/11/2021)");
        } else {
            try {

                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fechaNac = LocalDate.parse(FI.getText(), fmt);
                LocalDate ahora = LocalDate.now();

                Period periodo = Period.between(fechaNac, ahora);
                ADA.setText("" + periodo.getYears() + " Años, " + periodo.getMonths() + " Meses, " + periodo.getDays() + " Dias");

            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Llena el campo fecha de ingreso con el siguiente formato de fecha: dd/MM/yyyy (01/11/2021)");
            }
        }
    }//GEN-LAST:event_AADAActionPerformed

    private void CPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPActionPerformed

    }//GEN-LAST:event_CPActionPerformed

    private void zonaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_zonaItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Zonas zon = (Zonas) zona.getSelectedItem();
            Servicios serv = new Servicios();
            DefaultComboBoxModel modelServicio = new DefaultComboBoxModel(serv.mostrarservicio(zon.getId()));
            Serv.setModel(modelServicio);
        }
    }//GEN-LAST:event_zonaItemStateChanged

    private void fdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fdpActionPerformed

    }//GEN-LAST:event_fdpActionPerformed

    private void ODTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ODTActionPerformed
        ODTQ_5 regr = new ODTQ_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ODTActionPerformed

    private void CNQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNQActionPerformed
        NominaQ_5 regr = new NominaQ_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CNQActionPerformed

    private void PRESQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRESQActionPerformed
        PresQ_5 regr = new PresQ_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PRESQActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        NominaQSiMSS_5 regr = new NominaQSiMSS_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void CDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDAActionPerformed
        CDAQ_5 regr = new CDAQ_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CDAActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        NominaS_5 regr = new NominaS_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        PresS_5 regr = new PresS_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        NominaS_simss_5 regr = new NominaS_simss_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void General1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_General1ActionPerformed

        Empleados_4 RH = new Empleados_4(usr, LP);
        RH.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_General1ActionPerformed

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

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Iturbide_4 regr = new Iturbide_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Tehuantepec_4 regr = new Tehuantepec_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        PT_4 regr = new PT_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void ZYSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZYSActionPerformed
        AltasZyS_3 regr = new AltasZyS_3(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ZYSActionPerformed

    private void ADMV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMV1ActionPerformed
        VentanaADM_3 regr = new VentanaADM_3(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADMV1ActionPerformed

    private void jLabel31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MousePressed
        BDEmpleados_4 regr = new BDEmpleados_4(usr, LP);
        regr.setVisible(true);

    }//GEN-LAST:event_jLabel31MousePressed

    private void CDA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDA4ActionPerformed
        CDAS_5 regr = new CDAS_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CDA4ActionPerformed

    private void ODT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ODT2ActionPerformed
        ODTS_5 regr = new ODTS_5(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ODT2ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        VDE regr = new VDE(usr, LP);
        regr.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jLabel32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MousePressed
        Logica_bd_RHIMSS obj = new Logica_bd_RHIMSS();
        obj.BDRH();
    }//GEN-LAST:event_jLabel32MousePressed

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

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        DepositosQ_SIMSS_4 regr = new DepositosQ_SIMSS_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        DepositosS_4 regr = new DepositosS_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        DepositosS_SIMSS_4 regr = new DepositosS_SIMSS_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        DepositosQ_4 regr = new DepositosQ_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        DepositosQ_SIMSS_4 regr = new DepositosQ_SIMSS_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        DepositosS_4 regr = new DepositosS_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        DepositosS_SIMSS_4 regr = new DepositosS_SIMSS_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        Rvales regr = new Rvales(usr, LP);
        regr.setVisible(true);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        VDE regr = new VDE(usr, LP);
        regr.setVisible(true);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        Padrones regr = new Padrones(usr, LP);
        regr.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        Padrones regr = new Padrones(usr, LP);
        regr.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        DepositosQSan_4 regr = new DepositosQSan_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        DepositosQsan_SIMSS_4 regr = new DepositosQsan_SIMSS_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        DepositosSSan_4 regr = new DepositosSSan_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        DepositosSSan_SIMSS_4 regr = new DepositosSSan_SIMSS_4(usr, LP);
        regr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void mod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod1ActionPerformed
        dat.setApellidoP(APgen.getText());
        dat.setApellidoM(AMgen.getText());
        dat.setName(NameGen.getText());
        dat.setCURP(CURP.getText());
        dat.setNSS(NSS.getText());
        dat.setRFC(RFC.getText());
        dat.setFechaDI(FI.getText());

        try {
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("Select `Entra a IMSS` from `rh.empleados` WHERE `# Exp` = " + NExp.getText() + "");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals("Si")) {
                    PreparedStatement pst;
                    ResultSet rst;

                    pst = con.prepareStatement("Select `idimss` from `imss` WHERE `Apellido P` LIKE '%" + APgen.getText() + "%' "
                            + "AND `Apellido M` LIKE '%" + AMgen.getText() + "%' AND `Nombre(s)` LIKE '%" + NameGen.getText() + "%'");
                    rst = pst.executeQuery();
                    while (rst.next()) {
                        dat.setNE(rst.getString(1));
                    }

                } else {
                    dat.setNE(NExp.getText());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empleados_4.class.getName()).log(Level.SEVERE, null, ex);
        }

        dat.setNDCrendial(NDC.getText());

        Expedientes_4 regr = new Expedientes_4(usr, LP, dat);
        regr.setVisible(true);
    }//GEN-LAST:event_mod1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (FIimss.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llena el campo fecha de ingreso con el siguiente formato de fecha: dd/MM/yyyy (01/11/2021)");
        } else {
            try {

                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fechaNac = LocalDate.parse(FIimss.getText(), fmt);
                LocalDate ahora = LocalDate.now();

                Period periodo = Period.between(fechaNac, ahora);
                ADEIMSS.setText("" + periodo.getYears() + " Años, " + periodo.getMonths() + " Meses, " + periodo.getDays() + " Dias");

            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Llena el campo fecha de ingreso con el siguiente formato de fecha: dd/MM/yyyy (01/11/2021)");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosActionPerformed
        Usuarios regr = new Usuarios(usr, LP);
        regr.setVisible(true);
    }//GEN-LAST:event_UsuariosActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed

        int i = JOptionPane.showConfirmDialog(this, "El cambiar de usuario cerrara la ventana actual. \n ¿Seguir con esta accion?");
        if (i == 0) {
            Inicio_1 regr = new Inicio_1();
            regr.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the
        Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Empleados_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Empleados_4().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AADA;
    private javax.swing.JLabel ADA;
    private javax.swing.JLabel ADEIMSS;
    private javax.swing.JMenuItem ADMV1;
    private javax.swing.JTextField AMgen;
    private javax.swing.JTextField AMimss;
    private javax.swing.JTextField APgen;
    private javax.swing.JTextField APimss;
    private javax.swing.JMenuItem Alumnos;
    private javax.swing.JTextField AmimssF;
    private javax.swing.JTextField ApimssF;
    private javax.swing.JComboBox<String> Banco;
    private javax.swing.JTextField Bono;
    private javax.swing.JMenuItem CDA;
    private javax.swing.JMenuItem CDA4;
    private javax.swing.JMenuItem CNQ;
    private javax.swing.JTextField CP;
    private javax.swing.JTextField CURP;
    private javax.swing.JTextField Calle;
    private javax.swing.JTextField Casa;
    private javax.swing.JTextField Celular;
    private javax.swing.JTextField Colonia;
    private javax.swing.JTextField Correo;
    private javax.swing.JButton Cs;
    private javax.swing.JButton Cs2;
    private javax.swing.JButton Cs3;
    private javax.swing.JButton Cs4;
    private javax.swing.JTextField DE;
    private javax.swing.JTextField DF;
    private javax.swing.JTextField DLGMUN;
    private javax.swing.JTextField DO;
    private javax.swing.JMenu Depositos;
    private javax.swing.JMenu Depositos2;
    private javax.swing.JCheckBox EIMSS;
    private javax.swing.JMenuItem EmpleadosT;
    private javax.swing.JMenuItem Estadias;
    private javax.swing.JTextField Exterior;
    private javax.swing.JTextField FBREimss;
    private javax.swing.JTextField FBimss;
    private javax.swing.JTextField FBimssF;
    private javax.swing.JTextField FDREimss;
    private javax.swing.JTextField FE;
    private javax.swing.JTextField FFB;
    private javax.swing.JTextField FI;
    private javax.swing.JTextField FIimss;
    private javax.swing.JComboBox<String> FZimss;
    private javax.swing.JTextField FdiimssF;
    private javax.swing.JTextField Filobs;
    private javax.swing.JTextField FiltroCurpGen;
    private javax.swing.JTextField FiltroFDI;
    private javax.swing.JTextField FiltroNG;
    private javax.swing.JTextField FiltroNSSGen;
    private javax.swing.JComboBox<String> FiltroSZGen;
    private javax.swing.JComboBox<String> FiltroServGen;
    private javax.swing.JComboBox<String> FiltroStatus;
    private javax.swing.JComboBox<String> FiltroZGe;
    private javax.swing.JTextField Filtroam;
    private javax.swing.JTextField Filtroap;
    private javax.swing.JComboBox<String> Filtros;
    private javax.swing.JComboBox<String> Fimss;
    private javax.swing.JPanel General;
    private javax.swing.JMenuItem General1;
    private javax.swing.JPanel IMSS;
    private javax.swing.JTextField INT;
    private javax.swing.JMenuItem LDA;
    private javax.swing.JMenuItem LDA3;
    private javax.swing.JLabel LabelF1;
    private javax.swing.JLabel LabelF2;
    private javax.swing.JMenu Menuadm;
    private javax.swing.JTextField NDC;
    private javax.swing.JTextField NExp;
    private javax.swing.JTextField NRP;
    private javax.swing.JTextField NSS;
    private javax.swing.JTextField NameGen;
    private javax.swing.JLabel Nfilimss;
    private javax.swing.JMenuItem ODT;
    private javax.swing.JMenuItem ODT2;
    private javax.swing.JTextArea Obs;
    private javax.swing.JTextArea ObsTgen;
    private javax.swing.JMenuItem PRESQ;
    private javax.swing.JComboBox<String> PuestoimssF;
    private javax.swing.JTextField RFC;
    private javax.swing.JTabbedPane RH;
    private javax.swing.JTextField Rec;
    private javax.swing.JScrollPane ScrollpaneTG;
    private javax.swing.JMenu Semanales;
    private javax.swing.JComboBox<String> Serv;
    private javax.swing.JTextField Servimss;
    private javax.swing.JComboBox<String> Status;
    private javax.swing.JComboBox<String> Status1;
    private javax.swing.JComboBox<String> StatusimssF;
    private javax.swing.JTextField Sueldo;
    private javax.swing.JTable Timss;
    private javax.swing.JMenuItem Torteria;
    private javax.swing.JTextField UDL;
    private javax.swing.JMenuItem Usuarios;
    private javax.swing.JMenuItem ZYS;
    private javax.swing.JButton add;
    private javax.swing.JButton addimss;
    private javax.swing.JComboBox<String> bf;
    private javax.swing.JComboBox<String> cfin;
    private javax.swing.JTextField cta;
    private javax.swing.JTextField curpimss;
    private javax.swing.JTextField curpimssF;
    private javax.swing.JTable data;
    private javax.swing.JButton deleteimss;
    private javax.swing.JButton elim;
    private javax.swing.JTextField expFimss;
    private javax.swing.JTextField expimss;
    private javax.swing.JComboBox<String> fdp;
    private javax.swing.JComboBox<String> gen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JButton mod;
    private javax.swing.JButton mod1;
    private javax.swing.JButton modIMSS;
    private javax.swing.JTextField nameimss;
    private javax.swing.JTextField namesimss;
    private javax.swing.JTextField nssimss;
    private javax.swing.JTextField nssimssF;
    private javax.swing.JTextArea obsimss;
    private javax.swing.JComboBox<String> puesto;
    private javax.swing.JTextField rfcimss;
    private javax.swing.JTextField rfcimssF;
    private javax.swing.JTextField sueldoimss;
    private javax.swing.JComboBox<String> zona;
    private javax.swing.JTextField zona1;
    // End of variables declaration//GEN-END:variables
}
