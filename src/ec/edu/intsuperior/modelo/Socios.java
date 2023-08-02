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
public class Socios {
    private String Cedula;
    private String PrimerNombre;
    private String SegundoNombre;
    private String PrimerApellido;
    private String SegundoApellido;
    private Date FechaNacieminto;
    private String Email;
    private String TelefonoMovil;
    private String TelefonoFijo;
    private String Provincia;
    private String Canton;
    private String Parroquia;
    private String Barrio;
    private String CallePrincipal;
    private String NumeroCasa;
    private String CalleSecundaria;
    private String Refencia;

    public Socios(String Cedula, String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, Date FechaNacieminto, String Email, String TelefonoMovil, String TelefonoFijo, String Provincia, String Canton, String Parroquia, String Barrio, String CallePrincipal, String NumeroCasa, String CalleSecundaria, String Refencia) {
        this.Cedula = Cedula;
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombre = SegundoNombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.FechaNacieminto = FechaNacieminto;
        this.Email = Email;
        this.TelefonoMovil = TelefonoMovil;
        this.TelefonoFijo = TelefonoFijo;
        this.Provincia = Provincia;
        this.Canton = Canton;
        this.Parroquia = Parroquia;
        this.Barrio = Barrio;
        this.CallePrincipal = CallePrincipal;
        this.NumeroCasa = NumeroCasa;
        this.CalleSecundaria = CalleSecundaria;
        this.Refencia = Refencia;
    }

    public Socios(String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, Date FechaNacieminto, String Email, String TelefonoMovil, String TelefonoFijo, String Provincia, String Canton, String Parroquia, String Barrio, String CallePrincipal, String NumeroCasa, String CalleSecundaria, String Refencia) {
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombre = SegundoNombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.FechaNacieminto = FechaNacieminto;
        this.Email = Email;
        this.TelefonoMovil = TelefonoMovil;
        this.TelefonoFijo = TelefonoFijo;
        this.Provincia = Provincia;
        this.Canton = Canton;
        this.Parroquia = Parroquia;
        this.Barrio = Barrio;
        this.CallePrincipal = CallePrincipal;
        this.NumeroCasa = NumeroCasa;
        this.CalleSecundaria = CalleSecundaria;
        this.Refencia = Refencia;
    }

    public Socios() {
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

    public Date getFechaNacieminto() {
        return FechaNacieminto;
    }

    public void setFechaNacieminto(Date FechaNacieminto) {
        this.FechaNacieminto = FechaNacieminto;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefonoMovil() {
        return TelefonoMovil;
    }

    public void setTelefonoMovil(String TelefonoMovil) {
        this.TelefonoMovil = TelefonoMovil;
    }

    public String getTelefonoFijo() {
        return TelefonoFijo;
    }

    public void setTelefonoFijo(String TelefonoFijo) {
        this.TelefonoFijo = TelefonoFijo;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public String getCanton() {
        return Canton;
    }

    public void setCanton(String Canton) {
        this.Canton = Canton;
    }

    public String getParroquia() {
        return Parroquia;
    }

    public void setParroquia(String Parroquia) {
        this.Parroquia = Parroquia;
    }

    public String getBarrio() {
        return Barrio;
    }

    public void setBarrio(String Barrio) {
        this.Barrio = Barrio;
    }

    public String getCallePrincipal() {
        return CallePrincipal;
    }

    public void setCallePrincipal(String CallePrincipal) {
        this.CallePrincipal = CallePrincipal;
    }

    public String getNumeroCasa() {
        return NumeroCasa;
    }

    public void setNumeroCasa(String NumeroCasa) {
        this.NumeroCasa = NumeroCasa;
    }

    public String getCalleSecundaria() {
        return CalleSecundaria;
    }

    public void setCalleSecundaria(String CalleSecundaria) {
        this.CalleSecundaria = CalleSecundaria;
    }

    public String getRefencia() {
        return Refencia;
    }

    public void setRefencia(String Refencia) {
        this.Refencia = Refencia;
    }
    public void InsertarSocio(JTextField paramCedula,JTextField paramPrimerNombre,JTextField paramSegundoNombre,
            JTextField paramPrimerApellido,JTextField paramSegundoApellido, JDateChooser paramFecha,JTextField paramCorreo,
            JTextField paramTelefonoMovil,JTextField paramTelefonoFijo,
            JTextField paramProvicia,JTextField paramCanton,JTextField paramParroquia,JTextField paramBarrio,
            JTextField paramCallePrincipal,JTextField paramNumeroCasa,JTextField paramCalleSecundaria,JTextField paramReferencia){
        
        String cedula = paramCedula.getText().trim();
        String primerNombre = paramPrimerNombre.getText().trim();
        String segundoNombre = paramSegundoNombre.getText().trim();
        String primerApellido = paramPrimerApellido.getText().trim();
        String segundoApellido = paramSegundoApellido.getText().trim();
        java.util.Date fechaNacimiento = paramFecha.getDate();
        String correo = paramCorreo.getText().trim();
        String telefonoMovil = paramTelefonoMovil.getText().trim();
        String telefonoFijo = paramTelefonoFijo.getText().trim();
        String provincia = paramProvicia.getText().trim();
        String canton = paramCanton.getText().trim();
        String parroquia = paramParroquia.getText().trim();
        String barrio = paramBarrio.getText().trim();
        String callePrincipal = paramCallePrincipal.getText().trim();
        String numeroCasa = paramNumeroCasa.getText().trim();
        String calleSecundaria = paramCalleSecundaria.getText().trim();
        String referencia = paramReferencia.getText().trim();

        // Verificar si todos los campos están vacíos
        if (cedula.isEmpty() && primerNombre.isEmpty() && segundoNombre.isEmpty() && primerApellido.isEmpty() && segundoApellido.isEmpty()
                && fechaNacimiento == null && correo.isEmpty() && telefonoMovil.isEmpty() && telefonoFijo.isEmpty() && provincia.isEmpty()
                && canton.isEmpty() && parroquia.isEmpty() && barrio.isEmpty() && callePrincipal.isEmpty() && numeroCasa.isEmpty()
                && calleSecundaria.isEmpty() && referencia.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Error: Debes ingresar al menos un campo antes de insertar el Implemento.");
            return;
        }

        setCedula(paramCedula.getText());
        setPrimerNombre(paramPrimerNombre.getText());
        setSegundoNombre(paramSegundoNombre.getText());
        setPrimerApellido(paramPrimerApellido.getText());
        setSegundoApellido(paramSegundoApellido.getText());
        setFechaNacieminto(paramFecha.getDate());
        setEmail(paramCorreo.getText());
        setTelefonoMovil(paramTelefonoMovil.getText());
        setTelefonoFijo(paramTelefonoFijo.getText());
        setProvincia(paramProvicia.getText());
        setCanton(paramCanton.getText());
        setParroquia(paramParroquia.getText());
        setBarrio(paramBarrio.getText());
        setCallePrincipal(paramCallePrincipal.getText());
        setNumeroCasa(paramNumeroCasa.getText());
        setCalleSecundaria(paramCalleSecundaria.getText());
        setRefencia(paramReferencia.getText());

        //java.sql.Date fechaNacimientoSQL = new java.sql.Date(fechaNacimiento.getDate());
        Conexion objetoConexion = new Conexion();

        String consulta = "call dbscap_sd1.SP_IsertSocios(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {

            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, getCedula());
            cs.setString(2, getPrimerNombre());
            cs.setString(3, getSegundoNombre());
            cs.setString(4, getPrimerApellido());
            cs.setString(5, getSegundoApellido());
            
                  
            cs.setString(6, getEmail());
            cs.setString(7, getTelefonoMovil());
            cs.setString(8, getTelefonoFijo());
            cs.setString(9, getProvincia());
            cs.setString(10, getCanton());
            cs.setString(11, getParroquia());
            cs.setString(12, getBarrio());
            cs.setString(13, getCallePrincipal());
            cs.setString(14, getNumeroCasa());
            cs.setString(15, getCalleSecundaria());
            cs.setString(16, getRefencia());
            cs.setDate(17, new java.sql.Date(paramFecha.getDate().getTime()));  

            cs.execute();
            
            
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el Implento");
            
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "No Se insertó correctamente el Implemento, error: "+e.toString());
        } 
    }
    public void MostrarSocio(JTable paramTablaTotalSocios){
    
        Conexion objetoConexion = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla= new TableRowSorter<TableModel>(modelo);
        paramTablaTotalSocios.setRowSorter(OrdenarTabla);
        
        String sql="";
        
        modelo.addColumn("Cedula");
        modelo.addColumn("Primer Nombre");
        modelo.addColumn("Segundo Nombre");
        modelo.addColumn("Primer Apellido");
        modelo.addColumn("Segundo Apellido");
        modelo.addColumn("Fceha Nacimeinto");
        modelo.addColumn("Correo");
        modelo.addColumn("Movil");
        modelo.addColumn("Telefono Fijo");
        modelo.addColumn("Provincia");
        modelo.addColumn("Canton");
        modelo.addColumn("Parraquia");
        modelo.addColumn("Barrio");
        modelo.addColumn("Calle Principal");
        modelo.addColumn("Numero De Casa");
        modelo.addColumn("Calle Secundaria");
        modelo.addColumn("Referencia");
        
        
        paramTablaTotalSocios.setModel(modelo); 
        
        
        sql ="select * from Socios;";
        
        
        String[] datos = new String[17];
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
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
                datos[12]=rs.getString(13);
                datos[13]=rs.getString(14);
                datos[14]=rs.getString(15);
                datos[15]=rs.getString(16);
                datos[16]=rs.getString(17);
       
                modelo.addRow(datos);
            }
            
            paramTablaTotalSocios.setModel(modelo);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());
        }
     
    }
    public void SeleccionarSocios(JTable paramTablaTotalSocios,JTextField paramCedula,JTextField paramPrimerNombre,JTextField paramSegundoNombre,
            JTextField paramPrimerApellido,JTextField paramSegundoApellido, JDateChooser paramFecha,JTextField paramCorreo,
            JTextField paramTelefonoMovil,JTextField paramTelefonoFijo,
            JTextField paramProvicia,JTextField paramCanton,JTextField paramParroquia,JTextField paramBarrio,
            JTextField paramCallePrincipal,JTextField paramNumeroCasa,JTextField paramCalleSecundaria,JTextField paramReferencia){
    
        
        try {
            int fila = paramTablaTotalSocios.getSelectedRow();
            
            if (fila >=0) {
                
                paramCedula.setText((paramTablaTotalSocios.getValueAt(fila, 0).toString()));
                paramPrimerNombre.setText((paramTablaTotalSocios.getValueAt(fila, 1).toString()));
                paramSegundoNombre.setText((paramTablaTotalSocios.getValueAt(fila, 2).toString()));
                paramPrimerApellido.setText((paramTablaTotalSocios.getValueAt(fila, 3).toString()));
                paramSegundoApellido.setText((paramTablaTotalSocios.getValueAt(fila, 4).toString()));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date fechaNacimiento = sdf.parse(paramTablaTotalSocios.getValueAt(fila, 5).toString());
                    paramFecha.setDate(fechaNacimiento);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Error al convertir la fecha: " + ex.getMessage());
                }
                
                paramCorreo.setText((paramTablaTotalSocios.getValueAt(fila, 6).toString()));
                paramTelefonoMovil.setText((paramTablaTotalSocios.getValueAt(fila, 7).toString()));
                paramTelefonoFijo.setText((paramTablaTotalSocios.getValueAt(fila, 8).toString()));
                paramProvicia.setText((paramTablaTotalSocios.getValueAt(fila, 9).toString()));
                paramCanton.setText((paramTablaTotalSocios.getValueAt(fila, 10).toString()));
                paramParroquia.setText((paramTablaTotalSocios.getValueAt(fila, 11).toString()));
                paramBarrio.setText((paramTablaTotalSocios.getValueAt(fila, 12).toString()));
                paramCallePrincipal.setText((paramTablaTotalSocios.getValueAt(fila, 13).toString()));
                paramNumeroCasa.setText((paramTablaTotalSocios.getValueAt(fila, 14).toString()));
                paramCalleSecundaria.setText((paramTablaTotalSocios.getValueAt(fila, 15).toString()));
                paramReferencia.setText((paramTablaTotalSocios.getValueAt(fila, 16).toString()));
               
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de seleccion, error: " + e.toString());
        }

    }

    public void ModificarSocios(JTextField paramCedula, JTextField paramPrimerNombre, JTextField paramSegundoNombre,
            JTextField paramPrimerApellido, JTextField paramSegundoApellido, JDateChooser paramFecha, JTextField paramCorreo,
            JTextField paramTelefonoMovil, JTextField paramTelefonoFijo,
            JTextField paramProvicia, JTextField paramCanton, JTextField paramParroquia, JTextField paramBarrio,
            JTextField paramCallePrincipal, JTextField paramNumeroCasa, JTextField paramCalleSecundaria, JTextField paramReferencia) {

        String cedula = paramCedula.getText().trim();
        String primerNombre = paramPrimerNombre.getText().trim();
        String segundoNombre = paramSegundoNombre.getText().trim();
        String primerApellido = paramPrimerApellido.getText().trim();
        String segundoApellido = paramSegundoApellido.getText().trim();
        java.util.Date fechaNacimiento = paramFecha.getDate();
        String correo = paramCorreo.getText().trim();
        String telefonoMovil = paramTelefonoMovil.getText().trim();
        String telefonoFijo = paramTelefonoFijo.getText().trim();
        String provincia = paramProvicia.getText().trim();
        String canton = paramCanton.getText().trim();
        String parroquia = paramParroquia.getText().trim();
        String barrio = paramBarrio.getText().trim();
        String callePrincipal = paramCallePrincipal.getText().trim();
        String numeroCasa = paramNumeroCasa.getText().trim();
        String calleSecundaria = paramCalleSecundaria.getText().trim();
        String referencia = paramReferencia.getText().trim();

        // Verificar si todos los campos están vacíos
        if (cedula.isEmpty() && primerNombre.isEmpty() && segundoNombre.isEmpty() && primerApellido.isEmpty() && segundoApellido.isEmpty()
                && fechaNacimiento == null && correo.isEmpty() && telefonoMovil.isEmpty() && telefonoFijo.isEmpty() && provincia.isEmpty()
                && canton.isEmpty() && parroquia.isEmpty() && barrio.isEmpty() && callePrincipal.isEmpty() && numeroCasa.isEmpty()
                && calleSecundaria.isEmpty() && referencia.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Error: Debes ingresar al menos un campo antes de insertar el Implemento.");
            return;
        }
        setCedula(paramCedula.getText());
        setPrimerNombre(paramPrimerNombre.getText());
        setSegundoNombre(paramSegundoNombre.getText());
        setPrimerApellido(paramPrimerApellido.getText());
        setSegundoApellido(paramSegundoApellido.getText());
        setFechaNacieminto(paramFecha.getDate());
        setEmail(paramCorreo.getText());
        setTelefonoMovil(paramTelefonoMovil.getText());
        setTelefonoFijo(paramTelefonoFijo.getText());
        setProvincia(paramProvicia.getText());
        setCanton(paramCanton.getText());
        setParroquia(paramParroquia.getText());
        setBarrio(paramBarrio.getText());
        setCallePrincipal(paramCallePrincipal.getText());
        setNumeroCasa(paramNumeroCasa.getText());
        setCalleSecundaria(paramCalleSecundaria.getText());
        setRefencia(paramReferencia.getText());

        Conexion objetoConexion = new Conexion();

        String consulta =//"insert into socios values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                "call dbscap_sd1.SP_ActualizarSocios(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                //"call dbscap_sd1.SP_ActualizarSocios(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {

            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, getPrimerNombre());
            cs.setString(2, getSegundoNombre());
            cs.setString(3, getPrimerApellido());
            cs.setString(4, getSegundoApellido());
            
            cs.setString(5, getEmail());
            cs.setString(6, getTelefonoMovil());
            cs.setString(7, getTelefonoFijo());
            cs.setString(8, getProvincia());
            cs.setString(9, getCanton());
            cs.setString(10, getParroquia());
            cs.setString(11, getBarrio());
            cs.setString(12, getCallePrincipal());
            cs.setString(13, getNumeroCasa());
            cs.setString(14, getCalleSecundaria());
            cs.setString(15, getRefencia());
            cs.setDate(16, new java.sql.Date(paramFecha.getDate().getTime()));
            //cs.setDate(16, (java.sql.Date) getFechaNacieminto());
            cs.setString(17, getCedula());

            cs.execute();

            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error:" + e.toString());
        }
    }
    
    public void EliminarSocio(JTextField paramCedula){
    
        Conexion objetoConexion = new Conexion();
        //setCodigo(Integer.parseInt(paramCodigo.getText()));
        setCedula(paramCedula.getText());
        
        
        
        String consulta = "call dbscap_sd1.SP_EliminarSocios(?);";
        
        try {
             CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
             cs.setString(1, getCedula());
             cs.execute();
             
             JOptionPane.showMessageDialog(null,"Se eliminó correctamente el Cargos");
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"No se pudo eliminar, error: "+ e.toString());
        }
        
    }
}
