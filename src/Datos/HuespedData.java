package Datos;

import Entidades.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class HuespedData {

    private Connection con = null;

    public HuespedData() {

        con = Conexion.getConexion();

    }
// guardar huesped es para agendar los huespedes y agregarlos a la db

    public void guardarHuesped(Huesped huesped) {

        String sql = "INSERT INTO huesped (nombre,dni,domicilio,correo,celular) "
                + "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, huesped.getNombre());
            ps.setInt(2, huesped.getDni());
            ps.setString(3, huesped.getDomicilio());
            ps.setString(4, huesped.getCorreo());
            ps.setInt(5, huesped.getCelular());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                huesped.setIdHuesped(rs.getInt(1));

                JOptionPane.showMessageDialog(null, "Huesped agregado correctamente");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped");
        }
    }
// actualizar es para modificar buscando con el dni los datos de huespeded o actualizar datos

    public void actualizarHuesped(Huesped huesped) {

        String sql = "UPDATE huesped SET domicilio=? , correo=?, celular=?"
                + "WHERE dni=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, huesped.getDomicilio());
            ps.setString(2, huesped.getCorreo());
            ps.setInt(3, huesped.getCelular());
            ps.setInt(4, huesped.getDni());

            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Huesped actualizado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla huesped");
        }
    }
    // buscar huespede por dni   

    public Huesped buscarHuespedDni(int dni) {

        String sql = "SELECT nombre, domicilio, correo, celular, alojado FROM huesped WHERE dni=?";
        Huesped huesped = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                huesped = new Huesped();
                huesped.setDni(dni);
                huesped.setNombre(rs.getString("nombre"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setCelular(rs.getInt("celular"));
                huesped.setAlojado(rs.getBoolean("alojado"));

            } else {

                JOptionPane.showMessageDialog(null, "Ese DNI no corresponde a un Huesped de la Base de datos");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla huesped");
        }
        return huesped;

    }
// buscar huesped por id

    public Huesped buscarHuespedId(int id) {

        String sql = "SELECT nombre,dni, domicilio, correo, celular, alojado FROM huesped WHERE idHuesped=?";
        Huesped huesped = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                huesped = new Huesped();
                huesped.setIdHuesped(id);
                huesped.setDni(rs.getInt("dni"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setCelular(rs.getInt("celular"));
                huesped.setAlojado(rs.getBoolean("alojado"));

            } else {

                JOptionPane.showMessageDialog(null, "Ese ID no corresponde a un Huesped de la Base de datos");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla huesped");
        }
        return huesped;

    }
// listado de huespedes que estan dentro del hotel alojados

    public List<Huesped> listarHuespedesAlojados() {
        String sql = "SELECT nombre, domicilio, correo, celular FROM huesped WHERE alojado=1";
        ArrayList<Huesped> huespedes = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Huesped huesped = new Huesped();
                huesped.setDni(rs.getInt("dni"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setCelular(rs.getInt("celular"));
                huespedes.add(huesped);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla huesped");
        }
        return huespedes;

    }
}
