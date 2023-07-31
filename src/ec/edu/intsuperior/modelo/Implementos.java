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
/**
 *
 * @author User
 */
public class Implementos {
   private Integer Id;
   private  String Nombre;
   private String Tipo;
   private String Descripcion; 

    public Implementos(Integer Id, String Nombre, String Tipo, String Descripcion) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Descripcion = Descripcion;
    }

    public Implementos(String Nombre, String Tipo, String Descripcion) {
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Descripcion = Descripcion;
    }

    public Implementos() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
   
    
    public void InsertarImplemento(JTextField paramNombre,JTextField paramTipo,JTextField paramDescripcion){
        String nombre = paramNombre.getText().trim();
        String tipo = paramTipo.getText().trim();
        String descripcion = paramDescripcion.getText().trim();

        if (nombre.isEmpty() || tipo.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Debes completar todos los campos antes de insertar el Implemento.");
            return;
        }
        
        setNombre(paramNombre.getText());
        setTipo(paramTipo.getText());
        setDescripcion(paramDescripcion.getText());
        
        Conexion objetoConexion = new Conexion();
        
        
        String consulta ="call dbscap_sd1.SP_IsertImplementos(?,?,?);";
        
        try {
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, getNombre());     
            cs.setString(2, getTipo());
            cs.setString(3, getDescripcion());
            
            cs.execute();
            
            
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el Implento");
            
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "No Se insertó correctamente el Implemento, error: "+e.toString());
        } 
    }
    public void MostrarImplementos(JTable paramTablaTotalImplemntos){
    
        Conexion objetoConexion = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla= new TableRowSorter<TableModel>(modelo);
        paramTablaTotalImplemntos.setRowSorter(OrdenarTabla);
        
        String sql="";
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Descripcion");
        
        
        paramTablaTotalImplemntos.setModel(modelo); 
        
        
        sql ="select * from implementos;";
        
        
        String[] datos = new String[4];
        Statement st;
        
        try {
            st= objetoConexion.estableceConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
            
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
       
                modelo.addRow(datos);
            }
            
            paramTablaTotalImplemntos.setModel(modelo);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());
        }
     
    }
    public void SeleccionarImplementos(JTable paramTablaTotalImplemntos, JTextField paramId,JTextField paramNombre,JTextField paramTipo,JTextField paramDescripcion){
    
        try {
            int fila = paramTablaTotalImplemntos.getSelectedRow();
            
            if (fila >=0) {
                
                paramId.setText((paramTablaTotalImplemntos.getValueAt(fila, 0).toString()));
                paramNombre.setText((paramTablaTotalImplemntos.getValueAt(fila, 1).toString()));
                paramTipo.setText((paramTablaTotalImplemntos.getValueAt(fila, 2).toString()));
                paramDescripcion.setText((paramTablaTotalImplemntos.getValueAt(fila, 3).toString()));
               
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
        } catch (Exception e) {
            
                JOptionPane.showMessageDialog(null,"Error de seleccion, error: "+ e.toString());
        }
        
    }
    public void ModificarImplementos (JTextField paramId, JTextField paramNombre,JTextField paramTipo,JTextField paramDescripcion){
    
        String nombre = paramNombre.getText().trim();
        String tipo = paramTipo.getText().trim();
        String descripcion = paramDescripcion.getText().trim();

        if (nombre.isEmpty() || tipo.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Debes completar todos los campos antes de insertar el Implemento.");
            return;
        }
        setNombre(paramNombre.getText());
        setTipo(paramTipo.getText());
        setDescripcion(paramDescripcion.getText());
        setId(Integer.parseInt(paramId.getText()));
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        //setNombreALumnos(paramNombres.getText());
        //setApellidosAlumnos(paramApellidos.getText());
        
        
        Conexion objetoConexion = new Conexion();
        
        String consulta = "call dbscap_sd1.SP_ActualizarImplementos(?,?,?,?);";
        
        try {
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, getNombre());
            cs.setString(2, getTipo());
            cs.setString(3, getDescripcion());
            cs.setInt(4, getId());
            
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Modificación Exitosa");
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se modificó, error:"+ e.toString());
        }
    }
    
    public void EliminarCargo(JTextField paramId){
    
        Conexion objetoConexion = new Conexion();
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        setId(Integer.parseInt(paramId.getText()));
        
        
        
        String consulta = "call dbscap_sd1.SP_EliminarImplementos(?);";
        
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

