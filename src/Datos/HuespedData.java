package Datos;

import java.sql.Connection;

public class HuespedData {

    private Connection con = null;

    public HuespedData() {

        con = Conexion.getConexion();

    }

    
    public void guardarHuesped(huesped huesped){
    
    
    }
}
