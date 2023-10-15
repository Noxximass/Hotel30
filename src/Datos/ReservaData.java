package Datos;

import Entidades.Huesped;
import Entidades.Reserva;
import Entidades.tipoHab;
import java.sql.*;
import java.time.LocalDate;
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
// hacer reserva es para agregar reservas

    public void hacerReserva(Reserva reserva) {

        String sql = "INSERT INTO reserva (usuario,huesped,habitacion,cantPer,fechaIng,fechaSal,importe,estado)"
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, reserva.getUsuario().getUsuario());
            ps.setInt(2, reserva.getHuesped().getIdHuesped());
            ps.setInt(3, reserva.getHabitacion().getIdHabitacion());
            ps.setInt(4, reserva.getCantPer());
            ps.setDate(5, Date.valueOf(reserva.getFechaIng()));
            ps.setDate(6, Date.valueOf(reserva.getFechaSal()));
            ps.setDouble(7, reserva.getImporte());
            ps.setBoolean(8, reserva.isEstado());

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                reserva.setIdReserva(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Reserva realizada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla reserva");
        }

    }
// Baja de reserva es para dar de baja a una reserva realizada

    public void bajaReserva(int id) {

        String sql = "UPDATE reserva SET estado = 0  WHERE idReserva = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Reserva dada de baja");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla reserva");
        }

    }
//listar reservas es para listar las reservas activas

    public List<Reserva> listadoReservas() {

        String sql = "SELECT huesped,habitacion,cantPer,fechaIng,fechaSal FROM reserva WHERE estado=1";
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Reserva reserva = new Reserva();
                Huesped hues = hud.buscarHuespedId(rs.getInt("huesped"));
                tipoHab hab = had.BuscarHab(rs.getInt("habitacion"));
                reserva.setHuesped(hues);
                reserva.setHabitacion(hab);
                reserva.setCantPer(rs.getInt("cantPer"));
                reserva.setFechaIng(rs.getDate("fechaIng").toLocalDate());
                reserva.setFechaSal(rs.getDate("fechaSal").toLocalDate());
                reservas.add(reserva);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla reserva");
        }

        return reservas;

    }
// listado para reservar muestra las reservas dadas de baja

    public List<Reserva> listadoParaReservar() {

        String sql = "SELECT huesped,habitacion,cantPer,fechaIng,fechaSal FROM reserva WHERE estado=0";
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Reserva reserva = new Reserva();
                Huesped hues = hud.buscarHuespedId(rs.getInt("huesped"));
                tipoHab hab = had.BuscarHab(rs.getInt("habitacion"));
                reserva.setHuesped(hues);
                reserva.setHabitacion(hab);
                reserva.setCantPer(rs.getInt("cantPer"));
                reserva.setFechaIng(rs.getDate("fechaIng").toLocalDate());
                reserva.setFechaSal(rs.getDate("fechaSal").toLocalDate());
                reservas.add(reserva);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla reserva");
        }

        return reservas;

    }

    public List<Reserva> listadoReservasPorHuesped(int idHuesped) {

        String sql = "SELECT habitacion,cantPer,fechaIng,fechaSal,estado FROM reserva WHERE huesped=?";
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idHuesped);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Reserva reserva = new Reserva();
                Huesped hues = hud.buscarHuespedId(idHuesped);
                tipoHab hab = had.BuscarHab(rs.getInt("habitacion"));
                reserva.setHuesped(hues);
                reserva.setHabitacion(hab);
                reserva.setCantPer(rs.getInt("cantPer"));
                reserva.setFechaIng(rs.getDate("fechaIng").toLocalDate());
                reserva.setFechaSal(rs.getDate("fechaSal").toLocalDate());
                reservas.add(reserva);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla reserva");
        }

        return reservas;

    }

    public List<Reserva> ListadoPorMes(LocalDate fecha1, LocalDate fecha2) {

        String sql = "SELECT habitacion,cantPer,fechaIng,fechaSal,estado FROM reserva"
                + " WHERE fechaIng BETWEEN fecha1=? AND fecha2=?";
        ArrayList<Reserva> reservas = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(fecha1));
            ps.setDate(2, Date.valueOf(fecha2));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Reserva reserva = new Reserva();
                Huesped hues = hud.buscarHuespedId(rs.getInt("huesped"));
                tipoHab hab = had.BuscarHab(rs.getInt("habitacion"));
                reserva.setHuesped(hues);
                reserva.setHabitacion(hab);
                reserva.setCantPer(rs.getInt("cantPer"));
                reserva.setFechaIng(rs.getDate("fechaIng").toLocalDate());
                reserva.setFechaSal(rs.getDate("fechaSal").toLocalDate());
                reservas.add(reserva);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla reserva");
        }

        return reservas;

    }

}
