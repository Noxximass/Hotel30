
package Datos;

import Entidades.Usuarios;
import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuariosData {
    
    private Connection con = null;
    
    public UsuariosData() {

        con = Conexion.getConexion();

    }
    
    
    public void agregarEmpleado(Usuarios usuario){
    
    
        String sql= "INSERT INTO usuarios (usuario, contraseña,dni,nombre,apellido,fechaNac,direccion,cargo)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContraseña());
            ps.setInt(3, usuario.getDni());
            ps.setString(4, usuario.getNombre());
            ps.setString(5, usuario.getApellido());
            ps.setDate(6, Date.valueOf(usuario.getFechaNac()));
            ps.setString(7, usuario.getDirecion());
            ps.setString(8, usuario.getCargo());
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                
                JOptionPane.showMessageDialog(null, "Usuario cargado correctamente" );
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla usuarios");
        }
    }
    
}
