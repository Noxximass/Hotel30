package Entidades;

public class tipoHab {

    protected int idHabitacion;
    protected int cantPerMax;
    protected boolean estado;
    protected int cantCamas;
    protected double precioNoch;
    protected String tipoCamas;
    protected String tipohab;

    public tipoHab() {
    }

    public tipoHab(int cantPerMax, boolean estado, int cantCamas, double precioNoch, String tipoCamas, String tipohab) {
        this.cantPerMax = cantPerMax;
        this.estado = estado;
        this.cantCamas = cantCamas;
        this.precioNoch = precioNoch;
        this.tipoCamas = tipoCamas;
        this.tipohab = tipohab;
    }

    public tipoHab(int idHabitacion, int cantPerMax, boolean estado, int cantCamas, double precioNoch, String tipoCamas, String tipohab) {
        this.idHabitacion = idHabitacion;
        this.cantPerMax = cantPerMax;
        this.estado = estado;
        this.cantCamas = cantCamas;
        this.precioNoch = precioNoch;
        this.tipoCamas = tipoCamas;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    public String getTipohab() {
        return tipohab;
    }

    public void setTipohab(String tipohab) {
        this.tipohab = tipohab;
    }

   

 

    

    

}
