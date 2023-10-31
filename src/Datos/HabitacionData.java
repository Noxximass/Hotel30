
package Datos;

import Entidades.Reserva;
import Entidades.habitacionDoble;
import Entidades.habitacionSimple;
import Entidades.habitacionSuit;
import Entidades.habitacionTriple;
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
        
        String sql = "INSERT INTO habitaciones(cantPerMax,cantCamas, tipoCamas,precioNoch,estado,tipoHab)"
                + "VALUES (?,?,?,?,?,?)";
        
        
        
        if (habitacion instanceof habitacionSimple) {
            
            
             try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
               
               ps.setInt(1, habitacion.getCantPerMax());
               ps.setInt(2, ((habitacionSimple)habitacion).getCantPerMax());
               ps.setString(3, ((habitacionSimple)habitacion).getTipoCamas());  
               ps.setDouble(4, ((habitacionSimple)habitacion).getPrecioNoch());
               ps.setBoolean(5, ((habitacionSimple)habitacion).isEstado());
               ps.setString(6, ((habitacionSimple)habitacion).getTipohab());
               ps.executeQuery();
               
               ResultSet rs= ps.getGeneratedKeys();
               
               if (rs.next()) {
                   habitacion.setIdHabitacion(rs.getInt(1));
                   
                   JOptionPane.showMessageDialog(null, "Habitacion agregada");
                   
               }
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al cargar en tabla habitaciones");
           }
            
            
            
        }
        
        if (habitacion instanceof habitacionDoble) {
            
            
             try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
               
               ps.setInt(1, habitacion.getCantPerMax());
               ps.setInt(2, ((habitacionDoble)habitacion).getCantPerMax());
               ps.setString(3, ((habitacionDoble)habitacion).getTipoCamas());  
               ps.setDouble(4, ((habitacionDoble)habitacion).getPrecioNoch());
               ps.setBoolean(5, ((habitacionDoble)habitacion).isEstado());
               ps.setString(6, ((habitacionDoble)habitacion).getTipohab());
               ps.executeQuery();
               
               ResultSet rs= ps.getGeneratedKeys();
               
               if (rs.next()) {
                   habitacion.setIdHabitacion(rs.getInt(1));
                   
                   JOptionPane.showMessageDialog(null, "Habitacion agregada");
                   
               }
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al cargar en tabla habitaciones");
           }
            
            
            
        }
        
         if (habitacion instanceof habitacionTriple) {
            
            
             try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
               
               ps.setInt(1, habitacion.getCantPerMax());
               ps.setInt(2, ((habitacionTriple)habitacion).getCantPerMax());
               ps.setString(3, ((habitacionTriple)habitacion).getTipoCamas());  
               ps.setDouble(4, ((habitacionTriple)habitacion).getPrecioNoch());
               ps.setBoolean(5, ((habitacionTriple)habitacion).isEstado());
               ps.setString(6, ((habitacionTriple)habitacion).getTipohab());
               ps.executeQuery();
               
               ResultSet rs= ps.getGeneratedKeys();
               
               if (rs.next()) {
                   habitacion.setIdHabitacion(rs.getInt(1));
                   
                   JOptionPane.showMessageDialog(null, "Habitacion agregada");
                   
               }
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al cargar en tabla habitaciones");
           }
            
            
            
        }
         
          if (habitacion instanceof habitacionSuit) {
            
            
             try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
               
               ps.setInt(1, habitacion.getCantPerMax());
               ps.setInt(2, ((habitacionSuit)habitacion).getCantPerMax());
               ps.setString(3, ((habitacionSuit)habitacion).getTipoCamas());  
               ps.setDouble(4, ((habitacionSuit)habitacion).getPrecioNoch());
               ps.setBoolean(5, ((habitacionSuit)habitacion).isEstado());
               ps.setString(6, ((habitacionSuit)habitacion).getTipohab());
               ps.executeQuery();
               
               ResultSet rs= ps.getGeneratedKeys();
               
               if (rs.next()) {
                   habitacion.setIdHabitacion(rs.getInt(1));
                   
                   JOptionPane.showMessageDialog(null, "Habitacion agregada");
                   
               }
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al cargar en tabla habitaciones");
           }
            
            
            
        }
        
    
    }
    
    
    public void modificarHab(tipoHab habitacion){
    
        String sql= "UPDATE habitaciones SET cantPerMax=?, cantCamas=?, tipoCamas=?, precioNoch=?, estado=?, tipoHab=?"
                + "WHERE idHab=?";
        if (habitacion instanceof habitacionSimple) {
            
        
           try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
               ps.setInt(1, ((habitacionSimple)habitacion).getCantPerMax());
               ps.setInt(2, ((habitacionSimple)habitacion).getCantCamas());
               ps.setString(3, ((habitacionSimple)habitacion).getTipoCamas());  
               ps.setDouble(4, ((habitacionSimple)habitacion).getPrecioNoch());
               ps.setBoolean(5, ((habitacionSimple)habitacion).isEstado());
               ps.setString(6, ((habitacionSimple)habitacion).getTipohab());
               ps.setInt(7, ((habitacionSimple)habitacion).getIdHabitacion());
               int exito = ps.executeUpdate();
               
               if (exito==1) {
                   
                   JOptionPane.showMessageDialog(null,"Habitacion modificada");
               }
               ps.close();
           } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Error al acceder a la tabla tipoHab");
           }
        }
        
         if (habitacion instanceof habitacionDoble) {
            
        
           try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
               ps.setInt(1, ((habitacionDoble)habitacion).getCantPerMax());
               ps.setInt(2, ((habitacionDoble)habitacion).getCantCamas());
               ps.setString(3, ((habitacionDoble)habitacion).getTipoCamas());  
               ps.setDouble(4, ((habitacionDoble)habitacion).getPrecioNoch());
               ps.setBoolean(5, ((habitacionDoble)habitacion).isEstado());
               ps.setString(6, ((habitacionDoble)habitacion).getTipohab());
               ps.setInt(7, ((habitacionDoble)habitacion).getIdHabitacion());
               int exito = ps.executeUpdate();
               
               if (exito==1) {
                   
                   JOptionPane.showMessageDialog(null,"Habitacion modificada");
               }
               ps.close();
           } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Error al acceder a la tabla tipoHab");
           }
        }
         
          if (habitacion instanceof habitacionTriple) {
            
        
           try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
               ps.setInt(1, ((habitacionTriple)habitacion).getCantPerMax());
               ps.setInt(2, ((habitacionTriple)habitacion).getCantCamas());
               ps.setString(3, ((habitacionTriple)habitacion).getTipoCamas());  
               ps.setDouble(4, ((habitacionTriple)habitacion).getPrecioNoch());
               ps.setBoolean(5, ((habitacionTriple)habitacion).isEstado());
               ps.setString(6, ((habitacionTriple)habitacion).getTipohab());
               ps.setInt(7, ((habitacionTriple)habitacion).getIdHabitacion());
               int exito = ps.executeUpdate();
               
               if (exito==1) {
                   
                   JOptionPane.showMessageDialog(null,"Habitacion modificada");
               }
               ps.close();
           } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Error al acceder a la tabla tipoHab");
           }
        }
          
           if (habitacion instanceof habitacionSuit) {
            
        
           try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
               ps.setInt(1, ((habitacionSuit)habitacion).getCantPerMax());
               ps.setInt(2, ((habitacionSuit)habitacion).getCantCamas());
               ps.setString(3, ((habitacionSuit)habitacion).getTipoCamas());  
               ps.setDouble(4, ((habitacionSuit)habitacion).getPrecioNoch());
               ps.setBoolean(5, ((habitacionSuit)habitacion).isEstado());
               ps.setString(6, ((habitacionSimple)habitacion).getTipohab());
               ps.setInt(7, ((habitacionSuit)habitacion).getIdHabitacion());
               int exito = ps.executeUpdate();
               
               if (exito==1) {
                   
                   JOptionPane.showMessageDialog(null,"Habitacion modificada");
               }
               ps.close();
           } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Error al acceder a la tabla tipoHab");
           }
        }
    
    }
    
    public tipoHab BuscarHab(int id){
        
        String sql = "SELECT cantPerMax, cantCamas, tipoCamas, precioNoch, estado, tipoHab FROM tipoHab WHERE idHab = ?";
        tipoHab habitacion = null;
           try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               ps.setInt(1, id);
               
               ResultSet rs = ps.executeQuery();
               
               if(rs.next()){
               
                   habitacion = new tipoHab();
                   habitacion.setIdHabitacion(id);
                   habitacion.setCantPerMax(rs.getInt("cantPerMax"));
                   
                   if ("simple".equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionSimple)habitacion).setCantCamas(rs.getInt("cantCamas"));
                   }
                   else if ("doble".equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionDoble)habitacion).setCantCamas(rs.getInt("cantCamas"));
                   }
                   else if ("triple".equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionTriple)habitacion).setCantCamas(rs.getInt("cantCamas"));
                   }
                   else if ("suit".equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionSuit)habitacion).setCantCamas(rs.getInt("cantCamas"));
                   }
                   
                    if ("simple".equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionSimple)habitacion).setCantCamas(rs.getInt("precioNoch"));
                   }
                   else if ("doble".equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionDoble)habitacion).setCantCamas(rs.getInt("precioNoch"));
                   }
                   else if ("triple".equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionTriple)habitacion).setCantCamas(rs.getInt("precioNoch"));
                   }
                   else if ("suit".equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionSuit)habitacion).setCantCamas(rs.getInt("precioNoch"));
                   }
                    
                   habitacion.setEstado(rs.getBoolean("estado"));
               }
               
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Error al acceder a la tabla tipoHab");
           }
    return habitacion;
    
    }
    
    
        public List<tipoHab> BuscarHabPorTipo(String tipoHab){
        
        String sql = "SELECT idHab,cantPerMax, cantCamas,tipoCamas, precioNoch,estado FROM tipoHab WHERE tipoHab=?";
        tipoHab habitacion = null;
        ArrayList<tipoHab> habitaciones = new ArrayList<>();
           try {
               PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               ps.setString(1,tipoHab);
               
               ResultSet rs = ps.executeQuery();
               
               while(rs.next()){
               
                   habitacion = new tipoHab();
                   habitacion.setIdHabitacion(rs.getInt("idHab"));
                   
                   if (tipoHab.equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionSimple)habitacion).setCantCamas(rs.getInt("cantCamas"));
                   }
                   else if (tipoHab.equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionDoble)habitacion).setCantCamas(rs.getInt("cantCamas"));
                   }
                   else if (tipoHab.equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionTriple)habitacion).setCantCamas(rs.getInt("cantCamas"));
                   }
                   else if (tipoHab.equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionSuit)habitacion).setCantCamas(rs.getInt("cantCamas"));
                   }
                   
                   if (tipoHab.equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionSimple)habitacion).setTipoCamas(rs.getString("tipoCamas"));
                   }
                   else if (tipoHab.equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionDoble)habitacion).setTipoCamas(rs.getString("tipoCamas"));
                   }
                   else if (tipoHab.equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionTriple)habitacion).setTipoCamas(rs.getString("tipoCamas"));
                   }
                   else if (tipoHab.equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionSuit)habitacion).setTipoCamas(rs.getString("tipoCamas"));
                   }
                   
                   if (tipoHab.equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionSimple)habitacion).setPrecioNoch(rs.getInt("precioNoch"));
                   }
                   else if (tipoHab.equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionDoble)habitacion).setPrecioNoch(rs.getInt("precioNoch"));
                   }
                   else if (tipoHab.equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionTriple)habitacion).setPrecioNoch(rs.getInt("precioNoch"));
                   }
                   else if (tipoHab.equalsIgnoreCase(rs.getString("tipoHab"))) {
                    ((habitacionSuit)habitacion).setPrecioNoch(rs.getInt("precioNoch"));
                   }
                   
                   habitacion.setCantPerMax(rs.getInt("cantPerMax"));
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
