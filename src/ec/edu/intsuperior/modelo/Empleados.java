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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author User
 */
public class Empleados {

    private Integer id;
    private Integer idCargo;
    private String Cedula;
    private String PrimerNombre;
    private String SegundoNombre;
    private String PrimerApellido;
    private String SegundoApellido;
    private String Telefono;
    private String Email;

    public Empleados(Integer id, Integer idCargo, String Cedula, String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String Telefono, String Email) {
        this.id = id;
        this.idCargo = idCargo;
        this.Cedula = Cedula;
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombre = SegundoNombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.Telefono = Telefono;
        this.Email = Email;
    }

    public Empleados(Integer idCargo, String Cedula, String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String Telefono, String Email) {
        this.idCargo = idCargo;
        this.Cedula = Cedula;
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombre = SegundoNombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.Telefono = Telefono;
        this.Email = Email;
    }

    public Empleados() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String PrimerNombre) {
        this.PrimerNombre = PrimerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String SegundoNombre) {
        this.SegundoNombre = SegundoNombre;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void InsertarEmpleado(JTextField paramIdCargo, JTextField paramCedula, JTextField paramPrimerNombre,
            JTextField paramSegunNombre, JTextField paramPrimerApellido, JTextField paramSegundoApellido,
            JTextField paramTelefono, JTextField paramCorreo) {

        /*String descctipcion =paramDescripcion.getText().trim();
        if(descctipcion.isEmpty()){
            JOptionPane.showMessageDialog(null,"Error: Debes ingresar una descripción antes de insertar el cargo.");
        return;
        }*/
        if (paramIdCargo.getText().isEmpty() || paramCedula.getText().isEmpty() || paramPrimerNombre.getText().isEmpty()
                || paramSegunNombre.getText().isEmpty() || paramPrimerApellido.getText().isEmpty()
                || paramSegundoApellido.getText().isEmpty() || paramTelefono.getText().isEmpty()
                || paramCorreo.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Error: Debes ingresar todos los campos antes de insertar el empleado.");
            return;
        }
        setIdCargo(Integer.parseInt(paramIdCargo.getText()));
        setCedula(paramCedula.getText());
        setPrimerNombre(paramPrimerNombre.getText());
        setSegundoNombre(paramSegunNombre.getText());
        setPrimerApellido(paramPrimerApellido.getText());
        setSegundoApellido(paramSegundoApellido.getText());
        setTelefono(paramTelefono.getText());
        setEmail(paramCorreo.getText());

        Conexion objetoConexion = new Conexion();

        String consulta = "call dbscap_sd1.SP_IsertEmpleado(?,?,?,?,?,?,?,?);";

        try {

            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            String idCargoString = String.valueOf(getIdCargo());
            cs.setString(1, idCargoString);
            //cs.setInt(1, getIdCargo()));
            cs.setString(2, getCedula());
            cs.setString(3, getPrimerNombre());
            cs.setString(4, getSegundoNombre());
            cs.setString(5, getPrimerApellido());
            cs.setString(6, getSegundoApellido());
            cs.setString(7, getTelefono());
            cs.setString(8, getEmail());

            cs.execute();

            JOptionPane.showMessageDialog(null, "Se insertó correctamente el alumno");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Se insertó correctamente el alumno, error: " + e.toString());
        }
    }

    public void MostrarEmpleado(JTable paramTablaTotalEmpleados) {

        Conexion objetoConexion = new Conexion();

        DefaultTableModel modelo = new DefaultTableModel();

        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        paramTablaTotalEmpleados.setRowSorter(OrdenarTabla);

        String sql = "";

        modelo.addColumn("Id");
        modelo.addColumn("Cargo");
        modelo.addColumn("Cedula");
        modelo.addColumn("Primer Nombre");
        modelo.addColumn("Segundo Nombre");
        modelo.addColumn("Primer Apellido");
        modelo.addColumn("SegundoApellido");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");

        paramTablaTotalEmpleados.setModel(modelo);

        sql = "select * from empleados;";

        String[] datos = new String[9];
        Statement st;

        try {
            st = objetoConexion.estableceConexion().createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);

                modelo.addRow(datos);
            }

            paramTablaTotalEmpleados.setModel(modelo);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, error: " + e.toString());
        }

    }

    public void SeleccionarEmpleado(JTable paramTablaTotalEmpleados, JTextField paramId, JTextField paramIdCargo, JTextField paramCedula, JTextField paramPrimerNombre,
            JTextField paramSegunNombre, JTextField paramPrimerApellido, JTextField paramSegundoApellido,
            JTextField paramTelefono, JTextField paramCorreo) {

        try {
            int fila = paramTablaTotalEmpleados.getSelectedRow();

            if (fila >= 0) {

                paramId.setText((paramTablaTotalEmpleados.getValueAt(fila, 0).toString()));
                paramIdCargo.setText((paramTablaTotalEmpleados.getValueAt(fila, 1).toString()));
                paramCedula.setText((paramTablaTotalEmpleados.getValueAt(fila, 2).toString()));
                paramPrimerNombre.setText((paramTablaTotalEmpleados.getValueAt(fila, 3).toString()));
                paramSegunNombre.setText((paramTablaTotalEmpleados.getValueAt(fila, 4).toString()));
                paramPrimerApellido.setText((paramTablaTotalEmpleados.getValueAt(fila, 5).toString()));
                paramSegundoApellido.setText((paramTablaTotalEmpleados.getValueAt(fila, 6).toString()));
                paramTelefono.setText((paramTablaTotalEmpleados.getValueAt(fila, 7).toString()));
                paramCorreo.setText((paramTablaTotalEmpleados.getValueAt(fila, 8).toString()));

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de seleccion, error: " + e.toString());
        }

    }

    public void ModificarEmpleado(JTextField paramId, JTextField paramIdCargo, JTextField paramCedula, JTextField paramPrimerNombre,
            JTextField paramSegunNombre, JTextField paramPrimerApellido, JTextField paramSegundoApellido,
            JTextField paramTelefono, JTextField paramCorreo) {
        if (paramIdCargo.getText().isEmpty() || paramCedula.getText().isEmpty() || paramPrimerNombre.getText().isEmpty()
                || paramSegunNombre.getText().isEmpty() || paramPrimerApellido.getText().isEmpty()
                || paramSegundoApellido.getText().isEmpty() || paramTelefono.getText().isEmpty()
                || paramCorreo.getText().isEmpty() || paramId.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Error: Debes ingresar todos los campos antes de modificar el cargo.");
            return;
        }
        setIdCargo(Integer.parseInt(paramIdCargo.getText()));
        setCedula(paramCedula.getText());
        setPrimerNombre(paramPrimerNombre.getText());
        setSegundoNombre(paramSegunNombre.getText());
        setPrimerApellido(paramPrimerApellido.getText());
        setSegundoApellido(paramSegundoApellido.getText());
        setTelefono(paramTelefono.getText());
        setEmail(paramCorreo.getText());
        setId(Integer.parseInt(paramId.getText()));

        Conexion objetoConexion = new Conexion();

        String consulta = "call dbscap_sd1.SP_ActualizarEmpleado(?,?,?,?,?,?,?,?,?);";

        try {

            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, getIdCargo());
            cs.setString(2, getCedula());
            cs.setString(3, getPrimerNombre());
            cs.setString(4, getSegundoNombre());
            cs.setString(5, getPrimerApellido());
            cs.setString(6, getSegundoApellido());
            cs.setString(7, getTelefono());
            cs.setString(8, getEmail());

            cs.setInt(9, getId());

            cs.execute();

            JOptionPane.showMessageDialog(null, "Modificación Exitosa");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error:" + e.toString());
        }
    }

    public void EliminarEmpleado(JTextField paramId) {

        Conexion objetoConexion = new Conexion();
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        setId(Integer.parseInt(paramId.getText()));

        String consulta = "call dbscap_sd1.SP_EliminarEmpleado(?);";

        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, getId());
            cs.execute();

            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el Alumno");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        }

    }
}
