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
public class Usuarios {

    private Integer id;
    private Integer IDEmpleado;
    private String Usuario;
    private String Clave;
    private String Descripcion;
    private String Rol;

    public Usuarios(Integer id, Integer IDEmpleado, String Usuario, String Clave, String Descripcion, String Rol) {
        this.id = id;
        this.IDEmpleado = IDEmpleado;
        this.Usuario = Usuario;
        this.Clave = Clave;
        this.Descripcion = Descripcion;
        this.Rol = Rol;
    }

    public Usuarios(Integer IDEmpleado, String Usuario, String Clave, String Descripcion, String Rol) {
        this.IDEmpleado = IDEmpleado;
        this.Usuario = Usuario;
        this.Clave = Clave;
        this.Descripcion = Descripcion;
        this.Rol = Rol;
    }

    public Usuarios() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(Integer IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

   

    public void InsertarUsuario(JTextField paramIdEmpleado,JTextField paramUsuario,JTextField paramClave,JTextField paramDescripcion,JTextField paramRol){
        String IdEmpleado =paramIdEmpleado.getText().trim();
        String usuario = paramUsuario.getText().trim();
        String clave = paramClave.getText().trim();
        String descripcion = paramDescripcion.getText().trim();
        String rol =paramRol.getText().trim();

        if (IdEmpleado.isEmpty()||usuario.isEmpty() || clave.isEmpty() || descripcion.isEmpty()|| rol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Debes completar todos los campos antes de insertar el Implemento.");
            return;
        }
        setIDEmpleado(Integer.parseInt(paramIdEmpleado.getText()));
        setUsuario(paramUsuario.getText());
        setClave(paramClave.getText());
        setDescripcion(paramDescripcion.getText());
        setRol(paramRol.getText());

        Conexion objetoConexion = new Conexion();
        
        
        String consulta ="call dbscap_sd1.SP_IsertUsuario(?,?,?,?,?);";
        
        try {
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            String idCargoString = String.valueOf(getIDEmpleado());
            cs.setString(1, idCargoString);    
            cs.setString(2, getUsuario());
            cs.setString(3, getClave());
            cs.setString(4, getDescripcion());
            cs.setString(5, getRol());
            
            cs.execute();
            
            
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el Implento");
            
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "No Se insertó correctamente el Implemento, error: "+e.toString());
        } 
    }
    public void MostrarUsuario(JTable paramTablaTotalUsuario){
    
        Conexion objetoConexion = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla= new TableRowSorter<TableModel>(modelo);
        paramTablaTotalUsuario.setRowSorter(OrdenarTabla);
        
        String sql="";
        
        modelo.addColumn("Id");
        modelo.addColumn("Id Empleado");
        modelo.addColumn("Usuario");
        modelo.addColumn("Clave");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Rol");
        
        
        paramTablaTotalUsuario.setModel(modelo); 
        
        
        sql ="select * from usuarios;";
        
        
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
            
            paramTablaTotalUsuario.setModel(modelo);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());
        }
     
    }
    public void SeleccionarUsuario(JTable paramTablaTotalUsuario,JTextField paramId,JTextField paramIdEmpleado,JTextField paramUsuario,JTextField paramClave,JTextField paramDescripcion,JTextField paramRol){
    
        try {
            int fila = paramTablaTotalUsuario.getSelectedRow();
            
            if (fila >=0) {
                
                paramId.setText((paramTablaTotalUsuario.getValueAt(fila, 0).toString()));
                paramIdEmpleado.setText((paramTablaTotalUsuario.getValueAt(fila, 1).toString()));
                paramUsuario.setText((paramTablaTotalUsuario.getValueAt(fila, 2).toString()));
                paramClave.setText((paramTablaTotalUsuario.getValueAt(fila, 3).toString()));
                paramDescripcion.setText((paramTablaTotalUsuario.getValueAt(fila, 4).toString()));
                paramRol.setText((paramTablaTotalUsuario.getValueAt(fila, 5).toString()));
               
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
        } catch (Exception e) {
            
                JOptionPane.showMessageDialog(null,"Error de seleccion, error: "+ e.toString());
        }
        
    }
    public void ModificarUsuario (JTextField paramId,JTextField paramIdEmpleado,JTextField paramUsuario,JTextField paramClave,JTextField paramDescripcion,JTextField paramRol){
    
       String IdEmpleado =paramIdEmpleado.getText().trim();
        String usuario = paramUsuario.getText().trim();
        String clave = paramClave.getText().trim();
        String descripcion = paramDescripcion.getText().trim();
        String rol =paramRol.getText().trim();

        if (IdEmpleado.isEmpty() || usuario.isEmpty() || clave.isEmpty() || descripcion.isEmpty() || rol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Debes completar todos los campos antes de insertar el Implemento.");
            return;
        }
        setIDEmpleado(Integer.parseInt(paramIdEmpleado.getText()));
        setUsuario(paramUsuario.getText());
        setClave(paramClave.getText());
        setDescripcion(paramDescripcion.getText());
        setRol(paramRol.getText());
        setId(Integer.parseInt(paramId.getText()));
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        //setNombreALumnos(paramNombres.getText());
        //setApellidosAlumnos(paramApellidos.getText());
        
        
        Conexion objetoConexion = new Conexion();
        
        String consulta = "call dbscap_sd1.SP_ActualizarUsuarios(?,?,?,?,?,?);";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, getIDEmpleado());
            cs.setString(2, getUsuario());
            cs.setString(3, getClave());
            cs.setString(4, getDescripcion());
            cs.setString(5, getRol());
            cs.setInt(6, getId());
            
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Modificación Exitosa");
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se modificó, error:"+ e.toString());
        }
    }
    
    public void EliminarUsuario(JTextField paramId){
    
        Conexion objetoConexion = new Conexion();
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        setId(Integer.parseInt(paramId.getText()));
        
        
        
        String consulta = "call dbscap_sd1.SP_EliminarUsuarios(?);";
        
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
