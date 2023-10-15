
package Datos;

import Entidades.Reserva;
import Entidades.tipoHab;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class HabitacionData {
    
       private Connection con = null;

    public HabitacionData() {

        con = Conexion.getConexion();
        
    }
    
    public void cargarHab(tipoHab habitacion){
    
        String sql = "INSERT INTO tipoHab(cantPerMax,cantCamas,tipoCamas,precioNoch,estado)"
                +"VALUES (?,?,?,?,?)";
        
           try {
               PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               ps.setInt(1,habitacion.getCantPerMax());
               ps.setInt(2,habitacion.getCantCamas());
               ps.setString(3,habitacion.getTipoCamas());
               ps.setDouble(4,habitacion.getPrecioNoch());
               ps.setBoolean(4,habitacion.isEstado());
               
               ResultSet rs= ps.getGeneratedKeys();
               
               if (rs.next()) {
                   
                   habitacion.setIdHabitacion(rs.getInt(1));
                   //JOptionPane.showMessageDialog(null, "Habitacion cargada correctamente");
               }
               ps.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Error al acceder a la tabla tipoHab");
           }
    }
    
    
    public void modificarHab(tipoHab habitacion){
    
        String sql= "UPDATE tipoHab SET cantPerMax, cantCamas, tipoCamas, precioNoch, estado"
                + "WHERE idHab=?";
        
           try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
               ps.setInt(1, habitacion.getCantPerMax());
               ps.setInt(2, habitacion.getCantCamas());
               ps.setString(3, habitacion.getTipoCamas());
               ps.setInt(4, habitacion.getPrecioNoch());
               ps.setBoolean(5, habitacion.isEstado());
               ps.setInt(6, habitacion.getIdHabitacion());
               
               int exito = ps.executeUpdate();
               
               if (exito==1) {
                   
                   JOptionPane.showMessageDialog(null,"Habitacion modificada");
               }
               ps.close();
           } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Error al acceder a la tabla tipoHab");
           }
    
    
    }
    
    public tipoHab BuscarHab(int id){
        
        String sql = "SELECT cantPerMax, cantCamas, tipoCamas, precioNoch, estado FROM tipoHab WHERE idHab = ?";
        tipoHab habitacion = null;
           try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               ps.setInt(1, id);
               
               ResultSet rs = ps.executeQuery();
               
               if(rs.next()){
               
                   habitacion = new tipoHab();
                   habitacion.setIdHabitacion(id);
                   habitacion.setCantPerMax(rs.getInt("cantPerMax"));
                   habitacion.setCantCamas(rs.getInt("cantCamas"));
                   habitacion.setPrecioNoch(rs.getInt("precioNoch"));
                   habitacion.setEstado(rs.getBoolean("estado"));
               }
               
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Error al acceder a la tabla tipoHab");
           }
    return habitacion;
    
    }
    
    
        public List<tipoHab> BuscarHabPorTipo(String cantCamas, String tipoCamas){
        
        String sql = "SELECT idHab,cantPerMax, precioNoch, FROM tipoHab WHERE cantCamas = ? AND tipoCamas=? AND estado=0";
        tipoHab habitacion = null;
        ArrayList<tipoHab> habitaciones = new ArrayList<>();
           try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               ps.setString(1, cantCamas);
               ps.setString(1, tipoCamas);
               
               ResultSet rs = ps.executeQuery();
               
               while(rs.next()){
               
                   habitacion = new tipoHab();
                   habitacion.setIdHabitacion(rs.getInt("idHab"));
                   habitacion.setCantPerMax(rs.getInt("cantPerMax"));
                   habitacion.setCantCamas(rs.getInt("cantCamas"));
                   habitacion.setTipoCamas(rs.getString("tipoCamas"));
                   habitacion.setPrecioNoch(rs.getInt("precioNoch"));
                   habitacion.setEstado(rs.getBoolean("estado"));
                   habitaciones.add(habitacion);
               }
               ps.close();
               
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Error al acceder a la tabla tipoHab");
           }
    return habitaciones;
    
    }
}
