
package hotel30;

import Datos.UsuariosData;
import Entidades.Usuarios;
import java.time.LocalDate;
import java.time.Month;



public class Hotel30 {

   

  public static void main(String[] args) { 
      
//Usuarios us=new Usuarios("tmvannucci", "tomas123",40823370, "Tomas", "Moyano Vannucci",LocalDate.of(1997, Month.NOVEMBER, 26), "Jose Marti 116", "Administrativo");
UsuariosData usd= new UsuariosData();
//usd.agregarEmpleado(us);
usd.ingresoDeEmpleado("tmvannucci", "tomas123");
    }
    
}
