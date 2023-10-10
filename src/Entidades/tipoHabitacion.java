
package Entidades;

public class tipoHabitacion {
    
    private int idHavitacion;
    private int cantPerMax;
    private int cantCamas;
    private String tipoCamas;
    private int precioNoch;

    public tipoHabitacion() {
    }

    public tipoHabitacion(int idHavitacion, int cantPerMax, int cantCamas, String tipoCamas, int precioNoch) {
        this.idHavitacion = idHavitacion;
        this.cantPerMax = cantPerMax;
        this.cantCamas = cantCamas;
        this.tipoCamas = tipoCamas;
        this.precioNoch = precioNoch;
    }

    public int getIdHavitacion() {
        return idHavitacion;
    }

    public void setIdHavitacion(int idHavitacion) {
        this.idHavitacion = idHavitacion;
    }

    public int getCantPerMax() {
        return cantPerMax;
    }

    public void setCantPerMax(int cantPerMax) {
        this.cantPerMax = cantPerMax;
    }

    public int getCantCamas() {
        return cantCamas;
    }

    public void setCantCamas(int cantCamas) {
        this.cantCamas = cantCamas;
    }

    public String getTipoCamas() {
        return tipoCamas;
    }

    public void setTipoCamas(String tipoCamas) {
        this.tipoCamas = tipoCamas;
    }

    public int getPrecioNoch() {
        return precioNoch;
    }

    public void setPrecioNoch(int precioNoch) {
        this.precioNoch = precioNoch;
    }
    
    
    
    
}
