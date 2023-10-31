
package Entidades;


public class habitacionTriple extends tipoHab {

    protected int cantCamas;
    protected double precioNoch;
    protected String tipoCamas;
    private String tipohab;

    public String getTipohab() {
        return tipohab;
    }

    public void setTipohab(String tipohab) {
        this.tipohab = tipohab;
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

    public habitacionTriple(int cantCamas, double precioNoch, String tipoCamas) {
        this.cantCamas = cantCamas;
        this.precioNoch = precioNoch;
        this.tipoCamas = tipoCamas;
    }

    public habitacionTriple(int cantCamas,String tipoCamas, int cantPerMax, boolean estado) {
        super(cantPerMax, estado);
        this.cantCamas = cantCamas;
        this.precioNoch = 7000;
        this.tipoCamas = tipoCamas;
        this.tipohab = "triple";
    }

    public int getCantCamas() {
        return cantCamas;
    }

    public void setCantCamas(int cantCamas) {
        this.cantCamas = cantCamas;
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
    
    
}
