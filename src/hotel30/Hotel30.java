
package hotel30;

import Datos.Conexion;
import Datos.HabitacionData;
import Entidades.tipoHab;
import java.sql.Connection;

public class Hotel30 {

   

  public static void main(String[] args) { 
      
     // Connection con = Conexion.getConexion();
     
       HabitacionData habd= new HabitacionData();
        tipoHab hab= new tipoHab();
        for (int i = 1; i < 200; i++) {
            
            if (i>=2 && 1<=50) {
                
                hab.setCantCamas(1);
                hab.setTipoCamas(" una de 1 plaza");
                hab.setCantPerMax(1);
                hab.setPrecioNoch(5000);
                hab.setEstado(false);
                habd.cargarHab(hab);
            }else if (i>=51 && 1<=100) {
                
                hab.setCantCamas(1);
                hab.setTipoCamas("una de 2 plazas");
                hab.setCantPerMax(2);
                hab.setPrecioNoch(7000);
                hab.setEstado(false);
                habd.cargarHab(hab);
            }else if (i>=101 && 1<=150) {
                
                hab.setTipoCamas("una de 1 plaza y una de 2 plazas");
                hab.setCantPerMax(3);
                hab.setPrecioNoch(9000);
                hab.setEstado(false);
                habd.cargarHab(hab);
            }else if (i>=151 && 1<=175) {
                
                hab.setCantCamas(3);
                hab.setTipoCamas("dos de 1 plaza y 1 2 plazas");
                hab.setCantPerMax(4);
                hab.setPrecioNoch(11000);
                hab.setEstado(false);
                habd.cargarHab(hab);
            }else if (i>=176 && 1<=195) {
                
                hab.setCantCamas(3);
                hab.setTipoCamas("dos de 2 plazas y 1 Queen");
                hab.setCantPerMax(6);
                hab.setPrecioNoch(15000);
                hab.setEstado(false);
                habd.cargarHab(hab);
            }else if(i>=196 && 1<=200){
                
            hab.setCantCamas(8);
                hab.setTipoCamas("6 de 1 plaza y media, y 2 kings");
                hab.setCantPerMax(10);
                hab.setPrecioNoch(35000);
                hab.setEstado(false);
                habd.cargarHab(hab);
            }
        }
        
    }
    
}
