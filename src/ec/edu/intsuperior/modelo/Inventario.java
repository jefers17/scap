/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.intsuperior.modelo;
import com.toedter.calendar.JDateChooser;
import ec.edu.intsuperior.controlador.Conexion;
import static java.lang.reflect.Array.set;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author User
 */
public class Inventario {
      private Integer id;
    private Integer IDImplemento;
    private  LocalDateTime Fecha;
    private  Integer Stock;
    private Double Precio;
    private String Estado;

    public Inventario(Integer id, Integer IDImplemento, LocalDateTime Fecha, Integer Stock, Double Precio, String Estado) {
        this.id = id;
        this.IDImplemento = IDImplemento;
        this.Fecha = Fecha;
        this.Stock = Stock;
        this.Precio = Precio;
        this.Estado = Estado;
    }

    public Inventario(Integer IDImplemento, LocalDateTime Fecha, Integer Stock, Double Precio, String Estado) {
        this.IDImplemento = IDImplemento;
        this.Fecha = Fecha;
        this.Stock = Stock;
        this.Precio = Precio;
        this.Estado = Estado;
    }

    public Inventario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIDImplemento() {
        return IDImplemento;
    }

    public void setIDImplemento(Integer IDImplemento) {
        this.IDImplemento = IDImplemento;
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime Fecha) {
        this.Fecha = Fecha;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer Stock) {
        this.Stock = Stock;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    public void InsertarInventario(JTextField paramIdImplemento,JTextField paramFechaHo,JTextField paramStock,JTextField paramPrecio,JTextField paramEstado){
        
        setIDImplemento(Integer.parseInt(paramIdImplemento.getText()));
        setFecha(LocalDateTime.now());
        setStock(Integer.parseInt(paramStock.getText()));
       setPrecio(Double.parseDouble(paramPrecio.getText()));
        setEstado(paramEstado.getText());

        Conexion objetoConexion = new Conexion();
        
        
        String consulta ="call dbscap_sd1.SP_IsertInventario(?,?,?,?,?);";
        
        try {
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            String idImplemento = String.valueOf(getIDImplemento());
            cs.setString(1, idImplemento); 
            String stock = String.valueOf(getStock());
            cs.setString(2, stock);  
            cs.setDouble(3, getPrecio());            
            cs.setString(4, getEstado());
            cs.setObject(5, getFecha());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el Implento");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "No Se insertó correctamente el Implemento, error: "+e.toString());
        } 
    }
    public void MostrarInventario(JTable paramTablaTotalInventario){
    
        Conexion objetoConexion = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla= new TableRowSorter<TableModel>(modelo);
        paramTablaTotalInventario.setRowSorter(OrdenarTabla);
        
        String sql="";
        
        modelo.addColumn("Id");
        modelo.addColumn("Id Implemento");
        modelo.addColumn("Fecha");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio");
        modelo.addColumn("Estado");
        
        
        paramTablaTotalInventario.setModel(modelo); 
        
        
        sql ="select * from inventario;";
        
        
        String[] datos = new String[6];
        Statement st;
        
        try {
            st= objetoConexion.estableceConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
            
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
       
                modelo.addRow(datos);
            }
            
            paramTablaTotalInventario.setModel(modelo);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());
        }
     
    }
    public void SeleccionarInventario(JTable paramTablaTotalInventario,JTextField paramId,JTextField paramIdImplemento,JTextField paramFechaHo,JTextField paramStock,JTextField paramPrecio,JTextField paramEstado){
    
        try {
            int fila = paramTablaTotalInventario.getSelectedRow();
            
            if (fila >=0) {
                
                paramId.setText((paramTablaTotalInventario.getValueAt(fila, 0).toString()));
                paramIdImplemento.setText((paramTablaTotalInventario.getValueAt(fila, 1).toString()));
                paramFechaHo.setText((paramTablaTotalInventario.getValueAt(fila, 2).toString()));
                paramStock.setText((paramTablaTotalInventario.getValueAt(fila, 3).toString()));
                paramPrecio.setText((paramTablaTotalInventario.getValueAt(fila, 4).toString()));
                paramEstado.setText((paramTablaTotalInventario.getValueAt(fila, 5).toString()));
               
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
        } catch (Exception e) {
            
                JOptionPane.showMessageDialog(null,"Error de seleccion, error: "+ e.toString());
        }
        
    }
    public void ModificarInventario (JTextField paramId,JTextField paramIdImplemento,JTextField paramFechaHo,JTextField paramStock,JTextField paramPrecio,JTextField paramEstado){
    
       /* IdEmpleado =paramIdEmpleado.getText().trim();
        String usuario = paramUsuario.getText().trim();
        String clave = paramClave.getText().trim();
        String descripcion = paramDescripcion.getText().trim();
        String rol =paramRol.getText().trim();

        if (IdEmpleado.isEmpty() || usuario.isEmpty() || clave.isEmpty() || descripcion.isEmpty() || rol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Debes completar todos los campos antes de insertar el Implemento.");
            return;
        }*/
        setIDImplemento(Integer.parseInt(paramIdImplemento.getText()));
        setFecha(LocalDateTime.now());
        setStock(Integer.parseInt(paramStock.getText()));
        setPrecio(Double.parseDouble(paramPrecio.getText()));
        setEstado(paramEstado.getText());
        setId(Integer.parseInt(paramId.getText()));
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        //setNombreALumnos(paramNombres.getText());
        //setApellidosAlumnos(paramApellidos.getText());
        
        
        Conexion objetoConexion = new Conexion();
        
        String consulta = "call dbscap_sd1.SP_ActualizarInventario(?,?,?,?,?,?);";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            String idImplemento = String.valueOf(getIDImplemento());
            cs.setString(1, idImplemento); 
            String stock = String.valueOf(getStock());
            cs.setString(2, stock);  
            cs.setDouble(3, getPrecio());            
            cs.setString(4, getEstado());
            cs.setObject(5, getFecha());
             cs.setInt(6, getId());
            
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Modificación Exitosa");
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se modificó, error:"+ e.toString());
        }
    }
    
    public void EliminarInventario(JTextField paramId){
    
        Conexion objetoConexion = new Conexion();
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        setId(Integer.parseInt(paramId.getText()));
        
        
        
        String consulta = "call dbscap_sd1.SP_EliminarInventario(?);";
        
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
