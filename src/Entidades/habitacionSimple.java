
package Entidades;


public class habitacionSimple extends tipoHab {

    protected int cantCamas;
    protected double precioNoch;
    protected String tipoCamas;
    protected String tipohab;

    public habitacionSimple(int cantCamas, double precioNoch, String tipoCamas) {
        this.cantCamas = cantCamas;
        this.precioNoch = precioNoch;
        this.tipoCamas = tipoCamas;
    }

    public habitacionSimple(String tipoCamas, int cantPerMax, boolean estado) {
        super(cantPerMax, estado);
        this.cantCamas = 1;
        this.precioNoch = 3000;
        this.tipoCamas = tipoCamas;
        this.tipohab = "simple";
    }

    public String getTipohab() {
        return tipohab;
    }

    public void setTipohab(String tipohab) {
        this.tipohab = tipohab;
    }

    public double getPrecioNoch() {
        return precioNoch;
    }

    public void setPrecioNoch(double precioNoch) {
        this.precioNoch = precioNoch;
    }

    public String getTipoCamas() {
        return tipoCamas;
    }

    public void setTipoCamas(String tipoCamas) {
        this.tipoCamas = tipoCamas;
    }

    public int getCantCamas() {
        return cantCamas;
    }

    public void setCantCamas(int cantCamas) {
        this.cantCamas = cantCamas;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getCantPerMax() {
        return cantPerMax;
    }

    public void setCantPerMax(int cantPerMax) {
        this.cantPerMax = cantPerMax;
    }
    
    
}
