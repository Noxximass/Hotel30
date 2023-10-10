package Datos;

import Entidades.Huesped;
import Entidades.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ReservaData {

    private Connection con = null;
    private HuespedData hud = new HuespedData();
    private HabitacionData had = new HabitacionData();
    public ReservaData() {

        con = Conexion.getConexion();

    }

    public void hacerReserva(Reserva reserva) {

        String sql = "INSERT INTO reserva (huesped,habitacion,cantPer,fechaIng,fechaSal,importe,estado)"
                +"VALUES (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,reserva.getHuesped().getIdHuesped());
            ps.setInt(2, reserva.getHabitacion().getIdHabitacion());
            ps.setInt(3, reserva.getCantPer());
            ps.setDate(4, Date.valueOf(reserva.getFechaIng()));
            ps.setDate(5, Date.valueOf(reserva.getFechaSal()));
            ps.setDouble(6, reserva.getImporte());
            ps.setBoolean(7, reserva.isEstado());
            
            ResultSet rs= ps.getGeneratedKeys();
               
               if (rs.next()) {
                   
                   reserva.setIdReserva(rs.getInt(1));
                   JOptionPane.showMessageDialog(null, "Reserva realizada");
               }
               ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a tabla reserva");
        }

    }
    
    public void bajaReserva(int id){
    
        String sql = "UPDATE reserva SET estado = 0  WHERE idReserva = ?";
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
           int exito= ps.executeUpdate();
           
            if (exito==1) {
                
                JOptionPane.showMessageDialog(null, "Reserva dada de baja");
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a tabla reserva");
        }
    
    
    }
    
    public List<Reserva> listadoReservasActiv(){
    
        String sql = "SELECT huesped,habitacion,cantPer,fechaIng,fechaSal FROM reserva WHERE estado=1";
        ArrayList<Reserva> reservas = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs= ps.executeQuery();
            
            while   (rs.next()){
            
                Reserva reserva= new Reserva();
                Huesped hues= hud.buscarHuespedId(rs.getInt("huesped"));
                tipoHab hab= had.(rs.getInt("huesped"));
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a tabla reserva");
        }
    
    }
}
