
package hotel30;

import Datos.HuespedData;
import Datos.UsuariosData;
import Entidades.Huesped;
import Entidades.Usuarios;
import java.time.LocalDate;
import java.time.Month;



public class Hotel30 {

   

  public static void main(String[] args) { 
      
Huesped hus =new Huesped(1, "Juan", 456546464, "San Martin 656", "asdasda@asdasfga", 2254655, true);

HuespedData husd = new HuespedData();
        husd.guardarHuesped(hus);
        Huesped hus2 =new Huesped(1, "Martin", 456546464, "San Martin 656", "asdasda@asdas", 2254655, true);
        husd.actualizarHuesped(hus2,456546464);
    }
    
}
