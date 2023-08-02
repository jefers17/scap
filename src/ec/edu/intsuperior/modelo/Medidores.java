/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.intsuperior.modelo;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import ec.edu.intsuperior.controlador.Conexion;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author User
 */
public class Medidores {
     private Integer id;
    private String Cedula;
    private Date FEchaIs;
    private String Marca;
    private  String Barrio;
    private String CallePr;
    private String NumeroCas;
    private String CalleSecu;
    private String Referencia;
    private String Observacion;   

    public Medidores(Integer id, String Cedula, Date FEchaIs, String Marca, String Barrio, String CallePr, String NumeroCas, String CalleSecu, String Referencia, String Observacion) {
        this.id = id;
        this.Cedula = Cedula;
        this.FEchaIs = FEchaIs;
        this.Marca = Marca;
        this.Barrio = Barrio;
        this.CallePr = CallePr;
        this.NumeroCas = NumeroCas;
        this.CalleSecu = CalleSecu;
        this.Referencia = Referencia;
        this.Observacion = Observacion;
    }

    public Medidores(String Cedula, Date FEchaIs, String Marca, String Barrio, String CallePr, String NumeroCas, String CalleSecu, String Referencia, String Observacion) {
        this.Cedula = Cedula;
        this.FEchaIs = FEchaIs;
        this.Marca = Marca;
        this.Barrio = Barrio;
        this.CallePr = CallePr;
        this.NumeroCas = NumeroCas;
        this.CalleSecu = CalleSecu;
        this.Referencia = Referencia;
        this.Observacion = Observacion;
    }

    public Medidores() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public Date getFEchaIs() {
        return FEchaIs;
    }

    public void setFEchaIs(Date FEchaIs) {
        this.FEchaIs = FEchaIs;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getBarrio() {
        return Barrio;
    }

    public void setBarrio(String Barrio) {
        this.Barrio = Barrio;
    }

    public String getCallePr() {
        return CallePr;
    }

    public void setCallePr(String CallePr) {
        this.CallePr = CallePr;
    }

    public String getNumeroCas() {
        return NumeroCas;
    }

    public void setNumeroCas(String NumeroCas) {
        this.NumeroCas = NumeroCas;
    }

    public String getCalleSecu() {
        return CalleSecu;
    }

    public void setCalleSecu(String CalleSecu) {
        this.CalleSecu = CalleSecu;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }
    public void InsertarUsuario(JTextField paramCedula,JDateChooser paramFecha,JTextField paramMarca,JTextField paramBarrio,
        JTextField paramCallePrincipal, JTextField paramNumeroCasa, JTextField paramCalleSecundaria, JTextField paramReferencia, JTextField paramObservacion){
        /*String cedula =paramCedula.getText().trim();
        java.util.Date fecha = paramFecha.getDate();
        //String fecha=paramFecha.getText().trim();
        String marca=paramMarca.getText().trim();
        String barrio=paramBarrio.getText().trim();
        String callePrincipal=paramCallePrincipal.getText().trim();
        String numeroCasa=paramNumeroCasa.getText().trim();
        String calleSecundaria=paramCalleSecundaria.getText().trim();
        String referencia=paramReferencia.getText().trim();
        String observacion=paramObservacion.getText().trim();
        if (cedula.isEmpty()||fecha== null()||marca.isEmpty()||barrio.isEmpty()||callePrincipal.isEmpty() ||
                numeroCasa.isEmpty() || calleSecundaria.isEmpty()|| referencia.isEmpty()||observacion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Debes completar todos los campos antes de insertar el Implemento.");
            return;
        }*/
        setCedula(paramCedula.getText());
        setFEchaIs(paramFecha.getDate());
        setMarca(paramMarca.getText());
        setBarrio(paramBarrio.getText());
        setCallePr(paramCallePrincipal.getText());
        setNumeroCas(paramNumeroCasa.getText());
        setCalleSecu(paramCalleSecundaria.getText());
        setReferencia(paramReferencia.getText());
        setObservacion(paramObservacion.getText());
        Conexion objetoConexion = new Conexion();
        String consulta ="call dbscap_sd1.SP_IsertMedidores(?,?,?,?,?,?,?,?,?);";
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            cs.setString(1,getCedula());
            cs.setString(2, getMarca());    
            cs.setString(3, getBarrio());
            cs.setString(4, getCallePr());
            cs.setString(5, getNumeroCas());
            cs.setString(6, getCalleSecu());
            cs.setString(7,getReferencia());
            cs.setString(8, getObservacion());
            cs.setDate(9, new java.sql.Date(paramFecha.getDate().getTime())); 
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el Implento");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "No Se insertó correctamente el Implemento, error: "+e.toString());
        } 
    }
    public void MostrarMedidores(JTable paramTablaTotalMediodres){
    
        Conexion objetoConexion = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla= new TableRowSorter<TableModel>(modelo);
        paramTablaTotalMediodres.setRowSorter(OrdenarTabla);
        
        String sql="";
        
        modelo.addColumn("Id");
        modelo.addColumn("Cedula");
        modelo.addColumn("Fecha Istalacion");
        modelo.addColumn("Marca");
        modelo.addColumn("Barrio");
        modelo.addColumn("Calle Principal");
        modelo.addColumn("Numero Casa");
        modelo.addColumn("Calle Secundario");
        modelo.addColumn("Referencia");
        modelo.addColumn("Observacion");
        
        
        paramTablaTotalMediodres.setModel(modelo); 
        
        
        sql ="select * from medidores;";
        
        
        String[] datos = new String[10];
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
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);
                
       
                modelo.addRow(datos);
            }
            
            paramTablaTotalMediodres.setModel(modelo);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());
        }
     
    }
    public void SeleccionarMedidores(JTable paramTablaTotalMediodres,JTextField paramId,JTextField paramCedula,JDateChooser paramFecha,JTextField paramMarca,JTextField paramBarrio,
        JTextField paramCallePrincipal, JTextField paramNumeroCasa, JTextField paramCalleSecundaria, JTextField paramReferencia, JTextField paramObservacion){
    
        try {
            int fila = paramTablaTotalMediodres.getSelectedRow();
            
            if (fila >=0) {
                
                paramId.setText((paramTablaTotalMediodres.getValueAt(fila, 0).toString()));
                paramCedula.setText((paramTablaTotalMediodres.getValueAt(fila, 1).toString()));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date fechaNacimiento = sdf.parse(paramTablaTotalMediodres.getValueAt(fila, 2).toString());
                    paramFecha.setDate(fechaNacimiento);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Error al convertir la fecha: " + ex.getMessage());
                }
                paramMarca.setText((paramTablaTotalMediodres.getValueAt(fila, 3).toString()));
                paramBarrio.setText((paramTablaTotalMediodres.getValueAt(fila, 4).toString()));
                paramCallePrincipal.setText((paramTablaTotalMediodres.getValueAt(fila, 5).toString()));
                paramNumeroCasa.setText((paramTablaTotalMediodres.getValueAt(fila, 6).toString()));
                paramCalleSecundaria.setText((paramTablaTotalMediodres.getValueAt(fila, 7).toString()));
                paramReferencia.setText((paramTablaTotalMediodres.getValueAt(fila, 8).toString()));
                paramObservacion.setText((paramTablaTotalMediodres.getValueAt(fila, 9).toString()));
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
        } catch (Exception e) {
            
                JOptionPane.showMessageDialog(null,"Error de seleccion, error: "+ e.toString());
        }
        
    }
    public void ModificarMedidores (JTextField paramId,JTextField paramCedula,JDateChooser paramFecha,JTextField paramMarca,JTextField paramBarrio,
        JTextField paramCallePrincipal, JTextField paramNumeroCasa, JTextField paramCalleSecundaria, JTextField paramReferencia, JTextField paramObservacion){
    
       /*String IdEmpleado =paramIdEmpleado.getText().trim();
        String usuario = paramUsuario.getText().trim();
        String clave = paramClave.getText().trim();
        String descripcion = paramDescripcion.getText().trim();
        String rol =paramRol.getText().trim();

        if (IdEmpleado.isEmpty() || usuario.isEmpty() || clave.isEmpty() || descripcion.isEmpty() || rol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Debes completar todos los campos antes de insertar el Implemento.");
            return;
        }*/
        setCedula(paramCedula.getText());
        setFEchaIs(paramFecha.getDate());
        setMarca(paramMarca.getText());
        setBarrio(paramBarrio.getText());
        setCallePr(paramCallePrincipal.getText());
        setNumeroCas(paramNumeroCasa.getText());
        setCalleSecu(paramCalleSecundaria.getText());
        setReferencia(paramReferencia.getText());
        setObservacion(paramObservacion.getText());
        
        setId(Integer.parseInt(paramId.getText()));
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        //setNombreALumnos(paramNombres.getText());
        //setApellidosAlumnos(paramApellidos.getText());
        Conexion objetoConexion = new Conexion();
        String consulta = "call dbscap_sd1.SP_ActualizarMedidores(?,?,?,?,?,?,?,?,?,? );";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, getCedula());
            cs.setString(2, getMarca());
            cs.setString(3, getBarrio());
            cs.setString(4, getCallePr());
            cs.setString(5, getNumeroCas());
            cs.setString(6, getCalleSecu());
            cs.setString(7, getReferencia());
            cs.setString(8, getObservacion());
            cs.setDate(9, new java.sql.Date(paramFecha.getDate().getTime()));
            cs.setInt(10, getId());

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
        
        
        
        String consulta = "call dbscap_sd1.SP_EliminarMedidores(?);";
        
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
