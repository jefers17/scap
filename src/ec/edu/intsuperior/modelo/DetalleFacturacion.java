/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.intsuperior.modelo;

import ec.edu.intsuperior.controlador.Conexion;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author User
 */
public class DetalleFacturacion {

    private Integer id;
    private Integer IDPlanilla;
    private LocalDateTime Fecha;
    private Integer PalDUsuario;

    public DetalleFacturacion(Integer id, Integer IDPlanilla, LocalDateTime Fecha, Integer PalDUsuario) {
        this.id = id;
        this.IDPlanilla = IDPlanilla;
        this.Fecha = Fecha;
        this.PalDUsuario = PalDUsuario;
    }

    public DetalleFacturacion(Integer IDPlanilla, LocalDateTime Fecha, Integer PalDUsuario) {
        this.IDPlanilla = IDPlanilla;
        this.Fecha = Fecha;
        this.PalDUsuario = PalDUsuario;
    }

    public DetalleFacturacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIDPlanilla() {
        return IDPlanilla;
    }

    public void setIDPlanilla(Integer IDPlanilla) {
        this.IDPlanilla = IDPlanilla;
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime Fecha) {
        this.Fecha = Fecha;
    }

    public Integer getPalDUsuario() {
        return PalDUsuario;
    }

    public void setPalDUsuario(Integer PalDUsuario) {
        this.PalDUsuario = PalDUsuario;
    }

    public void InsertarDetalleCobro(JTextField paramIDPlanilla, JTextField paramFechaHo, JTextField paramPalUsuario) {
        setIDPlanilla(IDPlanilla);
        setFecha(Fecha);
        setPalDUsuario(PalDUsuario);
        setIDPlanilla(Integer.parseInt(paramIDPlanilla.getText()));
        setFecha(LocalDateTime.now());
        setPalDUsuario(Integer.parseInt(paramPalUsuario.getText()));

        Conexion objetoConexion = new Conexion();

        String consulta = "call dbscap_sd1.SP_IsertDetalleCobro(?,?,?);";

        try {

            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            String idPlanilla = String.valueOf(getIDPlanilla());
            cs.setString(1, idPlanilla);
            String paldUsuario = String.valueOf(getPalDUsuario());
            cs.setString(2, paldUsuario);
            cs.setObject(3, getFecha());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el DetalleCobro");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Se insertó correctamente el Implemento, error: " + e.toString());
        }
    }

    public void MostrarDetalleCobro(JTable paramTablaDetalleCobro) {

        Conexion objetoConexion = new Conexion();

        DefaultTableModel modelo = new DefaultTableModel();

        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        paramTablaDetalleCobro.setRowSorter(OrdenarTabla);

        String sql = "";

        modelo.addColumn("Id");
        modelo.addColumn("Id Planilla");
        modelo.addColumn("Fecha");
        modelo.addColumn("PALDUSUARIO");

        paramTablaDetalleCobro.setModel(modelo);

        sql = "select * from detallefacturacion;";

        String[] datos = new String[4];
        Statement st;

        try {
            st = objetoConexion.estableceConexion().createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                modelo.addRow(datos);
            }

            paramTablaDetalleCobro.setModel(modelo);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, error: " + e.toString());
        }

    }

    public void SeleccionarDetalleCobro(JTable paramTablaDetalleCobro, JTextField paramId, JTextField paramIDPlanilla, JTextField paramFechaHo, JTextField paramPalUsuario) {

        try {
            int fila = paramTablaDetalleCobro.getSelectedRow();

            if (fila >= 0) {

                paramId.setText((paramTablaDetalleCobro.getValueAt(fila, 0).toString()));
                paramIDPlanilla.setText((paramTablaDetalleCobro.getValueAt(fila, 1).toString()));
                paramFechaHo.setText((paramTablaDetalleCobro.getValueAt(fila, 2).toString()));
                paramPalUsuario.setText((paramTablaDetalleCobro.getValueAt(fila, 3).toString()));

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de seleccion, error: " + e.toString());
        }

    }

    public void ModificarDetalleCobro(JTextField paramId, JTextField paramIDPlanilla, JTextField paramFechaHo, JTextField paramPalUsuario) {

        /* IdEmpleado =paramIdEmpleado.getText().trim();
        String usuario = paramUsuario.getText().trim();
        String clave = paramClave.getText().trim();
        String descripcion = paramDescripcion.getText().trim();
        String rol =paramRol.getText().trim();

        if (IdEmpleado.isEmpty() || usuario.isEmpty() || clave.isEmpty() || descripcion.isEmpty() || rol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Debes completar todos los campos antes de insertar el Implemento.");
            return;
        }*/
        setIDPlanilla(Integer.parseInt(paramIDPlanilla.getText()));
        setFecha(LocalDateTime.now());
        setPalDUsuario(Integer.parseInt(paramPalUsuario.getText()));
        setId(Integer.parseInt(paramId.getText()));
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        //setNombreALumnos(paramNombres.getText());
        //setApellidosAlumnos(paramApellidos.getText());

        Conexion objetoConexion = new Conexion();

        String consulta = "call dbscap_sd1.SP_ActualizarDetalleCobro(?,?,?,?);";

        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            String idPlanilla = String.valueOf(getIDPlanilla());
            cs.setString(1, idPlanilla);
            String paldUsuario = String.valueOf(getPalDUsuario());
            cs.setString(2, paldUsuario);
            cs.setObject(3, getFecha());
            cs.setInt(4, getId());

            cs.execute();

            JOptionPane.showMessageDialog(null, "Modificación Exitosa");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error:" + e.toString());
        }
    }

    public void EliminarDetalleCobro(JTextField paramId) {

        Conexion objetoConexion = new Conexion();
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        setId(Integer.parseInt(paramId.getText()));

        String consulta = "call dbscap_sd1.SP_EliminarDetalleCobro(?);";

        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, getId());
            cs.execute();

            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el Cargos");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        }

    }
}
