
package Datos;

import Entidades.Usuarios;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

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
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                
                JOptionPane.showMessageDialog(null, "Usuario cargado correctamente" );
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla usuarios");
        }
    }
    
    public Usuarios ingresoDeEmpleado(String usuario, String contraseña){
    
        String sql =  "SELECT usuario, contraseña, dni, nombre, apellido , fechaNac,direccion , cargo FROM usuarios WHERE usuario=? AND contraseña=?";
        Usuarios empleado = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                empleado = new Usuarios();
                empleado.setUsuario(rs.getString("usuario"));
                empleado.setContraseña(rs.getString("contraseña"));
                empleado.setDni(rs.getInt("dni"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                empleado.setDirecion(rs.getString("direccion"));
                empleado.setCargo(rs.getString("cargo"));
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la tabla usuarios");
        }
        
        return empleado;
    
    }
    
}
