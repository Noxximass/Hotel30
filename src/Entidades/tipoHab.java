package Entidades;

public class tipoHab {

    private int idHabitacion;
    private String tipoHab;
    private int cantPerMax;
    private int cantCamas;
    private String tipoCamas;
    private int precioNoch;
    private boolean estado;

    public tipoHab() {
    }

    public tipoHab(String tipoHab, int cantPerMax, int cantCamas, String tipoCamas, int precioNoch, boolean estado) {
        this.tipoHab = tipoHab;
        this.cantPerMax = cantPerMax;
        this.cantCamas = cantCamas;
        this.tipoCamas = tipoCamas;
        this.precioNoch = precioNoch;
        this.estado = estado;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(String tipoHab) {
        this.tipoHab = tipoHab;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    

    

}
