
package Datos;

import Entidades.Reserva;
import java.sql.Connection;


public class ReservaData {
    
    
    private Connection con = null;

    public ReservaData() {

        con = Conexion.getConexion();

    }
    
    public void hacerReserva(Reserva reserva){
        
        Strng sql ="INSERT INTO reserva ()"
    
    }
}
