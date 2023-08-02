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
/**
 *
 * @author User
 */
public class Planilla {
      private Integer id;
    private Integer IDInventario;
    private Integer IDMedidor;
    private Integer IDServicio;
    private Integer IDUusario;
    private LocalDateTime Fecha;
    private Double Valor;
    private String Estado;
    private  Integer LecturaActual;
    private Integer LecturaAnterior;
    private String Observacion;

    public Planilla(Integer id, Integer IDInventario, Integer IDMedidor, Integer IDServicio, Integer IDUusario, LocalDateTime Fecha, Double Valor, String Estado, Integer LecturaActual, Integer LecturaAnterior, String Observacion) {
        this.id = id;
        this.IDInventario = IDInventario;
        this.IDMedidor = IDMedidor;
        this.IDServicio = IDServicio;
        this.IDUusario = IDUusario;
        this.Fecha = Fecha;
        this.Valor = Valor;
        this.Estado = Estado;
        this.LecturaActual = LecturaActual;
        this.LecturaAnterior = LecturaAnterior;
        this.Observacion = Observacion;
    }

    public Planilla(Integer IDInventario, Integer IDMedidor, Integer IDServicio, Integer IDUusario, LocalDateTime Fecha, Double Valor, String Estado, Integer LecturaActual, Integer LecturaAnterior, String Observacion) {
        this.IDInventario = IDInventario;
        this.IDMedidor = IDMedidor;
        this.IDServicio = IDServicio;
        this.IDUusario = IDUusario;
        this.Fecha = Fecha;
        this.Valor = Valor;
        this.Estado = Estado;
        this.LecturaActual = LecturaActual;
        this.LecturaAnterior = LecturaAnterior;
        this.Observacion = Observacion;
    }

    public Planilla() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIDInventario() {
        return IDInventario;
    }

    public void setIDInventario(Integer IDInventario) {
        this.IDInventario = IDInventario;
    }

    public Integer getIDMedidor() {
        return IDMedidor;
    }

    public void setIDMedidor(Integer IDMedidor) {
        this.IDMedidor = IDMedidor;
    }

    public Integer getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(Integer IDServicio) {
        this.IDServicio = IDServicio;
    }

    public Integer getIDUusario() {
        return IDUusario;
    }

    public void setIDUusario(Integer IDUusario) {
        this.IDUusario = IDUusario;
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime Fecha) {
        this.Fecha = Fecha;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Integer getLecturaActual() {
        return LecturaActual;
    }

    public void setLecturaActual(Integer LecturaActual) {
        this.LecturaActual = LecturaActual;
    }

    public Integer getLecturaAnterior() {
        return LecturaAnterior;
    }

    public void setLecturaAnterior(Integer LecturaAnterior) {
        this.LecturaAnterior = LecturaAnterior;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public void InsertarPlanilla(JTextField paramIDInventario,
            JTextField paramIDMedidor,
            JTextField paramIDServicio,
            JTextField paramIDUsuario,
            JTextField paramFechaHo,
            JTextField paramValor,
            JTextField paramEstado,
            JTextField paramLecturaActual,
            JTextField paramLecturaAnterior,
            JTextField paramObservacion) {

        setIDInventario(Integer.parseInt(paramIDInventario.getText()));
        setIDMedidor(Integer.parseInt(paramIDMedidor.getText()));
        setIDServicio(Integer.parseInt(paramIDServicio.getText()));
        setIDUusario(Integer.parseInt(paramIDUsuario.getText()));
        setFecha(LocalDateTime.now());
        setValor(Double.parseDouble(paramValor.getText()));
        setEstado(paramEstado.getText());
        setLecturaActual(Integer.parseInt(paramLecturaActual.getText()));
        setLecturaAnterior(Integer.parseInt(paramLecturaAnterior.getText()));
        setObservacion(paramObservacion.getText());

        Conexion objetoConexion = new Conexion();

        String consulta = "call dbscap_sd1.SP_IsertPlanilla(?,?,?,?,?,?,?,?,?,?);";

        try {

            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            String idInventario = String.valueOf(getIDInventario());
            cs.setString(1, idInventario);
            String idMedidor = String.valueOf(getIDMedidor());
            cs.setString(2, idMedidor);
            String idServicio = String.valueOf(getIDServicio());
            cs.setString(3, idServicio);
            String idUsuario = String.valueOf(getIDUusario());
            cs.setString(4, idUsuario);
            cs.setDouble(5, getValor());
            cs.setString(6, getEstado());
            String lecturaActual = String.valueOf(getLecturaActual());
            cs.setString(7, lecturaActual);
            String lecturaAnterior = String.valueOf(getLecturaAnterior());
            cs.setString(8, lecturaAnterior);
            cs.setString(9, getObservacion());
            cs.setObject(10, getFecha());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente la planilla");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Se insertó correctamente la planilla, error: " + e.toString());
        }
    }

    public void MostrarPlanilla(JTable paramTablaTotalPlanilla) {

        Conexion objetoConexion = new Conexion();

        DefaultTableModel modelo = new DefaultTableModel();

        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        paramTablaTotalPlanilla.setRowSorter(OrdenarTabla);

        String sql = "";

        modelo.addColumn("Id");
        modelo.addColumn("Id Inventario");
        modelo.addColumn("Id Medidor");
        modelo.addColumn("Id Servicio");
        modelo.addColumn("Id Usuario");
        modelo.addColumn("Fecha");
        modelo.addColumn("Valor");
        modelo.addColumn("Estado");
        modelo.addColumn("Lectura Actual");
        modelo.addColumn("Lectura Anterior");
        modelo.addColumn("Lectura Observacion");

        paramTablaTotalPlanilla.setModel(modelo);

        sql = "select * from planillas;";

        String[] datos = new String[11];
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
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                modelo.addRow(datos);
            }

            paramTablaTotalPlanilla.setModel(modelo);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, error: " + e.toString());
        }

    }

    public void SeleccionarInventario(JTable paramTablaTotalPlanilla, JTextField paramId,JTextField paramIDInventario,
            JTextField paramIDMedidor,
            JTextField paramIDServicio,
            JTextField paramIDUsuario,
            JTextField paramFechaHo,
            JTextField paramValor,
            JTextField paramEstado,
            JTextField paramLecturaActual,
            JTextField paramLecturaAnterior,
            JTextField paramObservacion) {
    
        try {
            int fila = paramTablaTotalPlanilla.getSelectedRow();

            if (fila >= 0) {

                paramId.setText((paramTablaTotalPlanilla.getValueAt(fila, 0).toString()));
                paramIDInventario.setText((paramTablaTotalPlanilla.getValueAt(fila, 1).toString()));
                paramIDMedidor.setText((paramTablaTotalPlanilla.getValueAt(fila, 2).toString()));
                paramIDServicio.setText((paramTablaTotalPlanilla.getValueAt(fila, 3).toString()));
                paramIDUsuario.setText((paramTablaTotalPlanilla.getValueAt(fila, 4).toString()));
                paramFechaHo.setText((paramTablaTotalPlanilla.getValueAt(fila, 5).toString()));
                paramValor.setText((paramTablaTotalPlanilla.getValueAt(fila, 6).toString()));
                paramEstado.setText((paramTablaTotalPlanilla.getValueAt(fila, 7).toString()));
                paramLecturaActual.setText((paramTablaTotalPlanilla.getValueAt(fila, 8).toString()));
                paramLecturaAnterior.setText((paramTablaTotalPlanilla.getValueAt(fila, 9).toString()));
                paramObservacion.setText((paramTablaTotalPlanilla.getValueAt(fila, 10).toString()));
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
        } catch (Exception e) {
            
                JOptionPane.showMessageDialog(null,"Error de seleccion, error: "+ e.toString());
        }
        
    }
    public void ModificarInventario (JTextField paramId,JTextField paramIDInventario,
            JTextField paramIDMedidor,
            JTextField paramIDServicio,
            JTextField paramIDUsuario,
            JTextField paramFechaHo,
            JTextField paramValor,
            JTextField paramEstado,
            JTextField paramLecturaActual,
            JTextField paramLecturaAnterior,
            JTextField paramObservacion
    ){
        setIDInventario(Integer.parseInt(paramIDInventario.getText()));
        setIDMedidor(Integer.parseInt(paramIDMedidor.getText()));
        setIDServicio(Integer.parseInt(paramIDServicio.getText()));
        setIDUusario(Integer.parseInt(paramIDUsuario.getText()));
        setFecha(LocalDateTime.now());
        setValor(Double.parseDouble(paramValor.getText()));
        setEstado(paramEstado.getText());
        setLecturaActual(Integer.parseInt(paramLecturaActual.getText()));
        setLecturaAnterior(Integer.parseInt(paramLecturaAnterior.getText()));
        setObservacion(paramObservacion.getText());
        setId(Integer.parseInt(paramId.getText()));
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        //setNombreALumnos(paramNombres.getText());
        //setApellidosAlumnos(paramApellidos.getText());
        
        
        Conexion objetoConexion = new Conexion();
        
        String consulta = "call dbscap_sd1.SP_ActualizarPlanilla(?,?,?,?,?,?,?,?,?,?,?);";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            String idInventario = String.valueOf(getIDInventario());
            cs.setString(1, idInventario);
            String idMedidor = String.valueOf(getIDMedidor());
            cs.setString(2, idMedidor);
            String idServicio = String.valueOf(getIDServicio());
            cs.setString(3, idServicio);
            String idUsuario = String.valueOf(getIDUusario());
            cs.setString(4, idUsuario);
            cs.setDouble(5, getValor());
            cs.setString(6, getEstado());
            String lecturaActual = String.valueOf(getLecturaActual());
            cs.setString(7, lecturaActual);
            String lecturaAnterior = String.valueOf(getLecturaAnterior());
            cs.setString(8, lecturaAnterior);
            cs.setString(9, getObservacion());
            cs.setObject(10, getFecha());
             cs.setInt(11, getId());
            
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Modificación Exitosa");
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se modificó, error:"+ e.toString());
        }
    }
    
    public void EliminaPlanilla(JTextField paramId){
    
        Conexion objetoConexion = new Conexion();
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        setId(Integer.parseInt(paramId.getText()));
        
        
        
        String consulta = "call dbscap_sd1.SP_EliminarPlanilla(?);";
        
        try {
             CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
             cs.setInt(1, getId());
             cs.execute();
             
             JOptionPane.showMessageDialog(null,"Se eliminó correctamente el Cargos");
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"No se pudo eliminar, error: "+ e.toString());
        }
        
    }
}
