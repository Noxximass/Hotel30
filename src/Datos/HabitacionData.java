
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
    
    public void CargarHab(tipoHab habitacion){
        
        String sql = "INSERT INTO habitaciones(tipoHab,cantPerMax,cantCamas, tipoCamas,precioNoch,estado)"
                + "VALUES (?,?,?,?,?,?)";
        
           try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
               ps.setString(1, habitacion.getTipoHab());
               ps.setInt(2, habitacion.getCantPerMax());
               ps.setInt(3, habitacion.getCantCamas());
               ps.setString(4, habitacion.getTipoCamas());  
               ps.setDouble(5, habitacion.getPrecioNoch());
               ps.setBoolean(6, habitacion.isEstado());
               ps.executeQuery();
               
               ResultSet rs= ps.getGeneratedKeys();
               
               if (rs.next()) {
                   habitacion.setIdHabitacion(rs.getInt(1));
                   
                   //JOptionPane.showMessageDialog(null, "Habitacion agregada");
                   
               }
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al cargar en tabla habitaciones");
           }
    
    }
    
    
    public void modificarHab(tipoHab habitacion){
    
        String sql= "UPDATE habitaciones SET tipoHab=?,cantPerMax=?, cantCamas=?, tipoCamas=?, precioNoch=?, estado=?"
                + "WHERE idHab=?";
        
           try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
               ps.setString(1, habitacion.getTipoHab());
               ps.setInt(2, habitacion.getCantPerMax());
               ps.setInt(3, habitacion.getCantCamas());
               ps.setString(4, habitacion.getTipoCamas());  
               ps.setDouble(5, habitacion.getPrecioNoch());
               ps.setBoolean(6, habitacion.isEstado());
               ps.setInt(7, habitacion.getIdHabitacion());
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
        
        String sql = "SELECT tipoHab,cantPerMax, cantCamas, tipoCamas, precioNoch, estado FROM tipoHab WHERE idHab = ?";
        tipoHab habitacion = null;
           try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               ps.setInt(1, id);
               
               ResultSet rs = ps.executeQuery();
               
               if(rs.next()){
               
                   habitacion = new tipoHab();
                   habitacion.setIdHabitacion(id);
                   habitacion.setTipoHab("tipoHab");
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
    
    
        public List<tipoHab> BuscarHabPorTipo(String tipoHab){
        
        String sql = "SELECT idHab,cantPerMax, cantCamas,tipoCamas, precioNoch, FROM tipoHab WHERE cantCamas = ? AND tipoHab=?";
        tipoHab habitacion = null;
        ArrayList<tipoHab> habitaciones = new ArrayList<>();
           try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               ps.setString(1, tipoHab);
               
               ResultSet rs = ps.executeQuery();
               
               while(rs.next()){
               
                   habitacion = new tipoHab();
                   habitacion.setIdHabitacion(rs.getInt("idHab"));
                   habitacion.setTipoHab(tipoHab);
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
