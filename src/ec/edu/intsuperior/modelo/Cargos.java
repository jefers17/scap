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
public class Cargos {
    private Integer id;
    private String Descripcion;

    public Cargos(Integer id, String Descripcion) {
        this.id = id;
        this.Descripcion = Descripcion;
    }

    public Cargos(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Cargos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    public void InsertarCargo(JTextField paramDescripcion){
        String descctipcion =paramDescripcion.getText().trim();
        if(descctipcion.isEmpty()){
            JOptionPane.showMessageDialog(null,"Error: Debes ingresar una descripción antes de insertar el cargo.");
        return;
        }
        setDescripcion(paramDescripcion.getText());
        
        Conexion objetoConexion = new Conexion();
        
        
        String consulta ="call dbscap_sd1.SP_IsertCargos(?);";
        
        try {
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
          
            cs.setString(1, getDescripcion());
            
            cs.execute();
            
            
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el Cargo");
            
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "No Se insertó correctamente el Cargo, error: "+e.toString());
        } 
    }
    public void MostrarCargos(JTable paramTablaTotalCargos){
    
        Conexion objetoConexion = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla= new TableRowSorter<TableModel>(modelo);
        paramTablaTotalCargos.setRowSorter(OrdenarTabla);
        
        String sql="";
        
        modelo.addColumn("Id");
        modelo.addColumn("Descripcion");
        
        
        paramTablaTotalCargos.setModel(modelo); 
        
        
        sql ="select * from cargosempleados;";
        
        
        String[] datos = new String[2];
        Statement st;
        
        try {
            st= objetoConexion.estableceConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
            
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
       
                modelo.addRow(datos);
            }
            
            paramTablaTotalCargos.setModel(modelo);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());
        }
     
    }
    public void SeleccionarCargo(JTable paramTablaTotalCargos, JTextField paramId, JTextField paramDescripcion){
    
        try {
            int fila = paramTablaTotalCargos.getSelectedRow();
            
            if (fila >=0) {
                
                paramId.setText((paramTablaTotalCargos.getValueAt(fila, 0).toString()));
                paramDescripcion.setText((paramTablaTotalCargos.getValueAt(fila, 1).toString()));
               
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
        } catch (Exception e) {
            
                JOptionPane.showMessageDialog(null,"Error de seleccion, error: "+ e.toString());
        }
        
    }
    public void ModificarCargo (JTextField paramId, JTextField paramDescripcion){
    
        String descctipcion =paramDescripcion.getText().trim();
        if(descctipcion.isEmpty()){
            JOptionPane.showMessageDialog(null,"Error: Debes ingresar una descripción antes de insertar el cargo.");
        return;
        }
        setDescripcion(paramDescripcion.getText());
        setId(Integer.parseInt(paramId.getText()));
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        //setNombreALumnos(paramNombres.getText());
        //setApellidosAlumnos(paramApellidos.getText());
        
        
        Conexion objetoConexion = new Conexion();
        
        String consulta = "call dbscap_sd1.SP_ActualizarCargos(?,?);";
        
        try {
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, getDescripcion());
            
            cs.setInt(2, getId());
            
            
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
        
        
        
        String consulta = "call dbscap_sd1.SP_EliminarCargos(?);";
        
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
