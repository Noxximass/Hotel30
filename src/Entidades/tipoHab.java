package Entidades;

public class tipoHab {

    protected int idHabitacion;
    protected int cantPerMax;
    private boolean estado;

    public tipoHab() {
    }

    public tipoHab(int cantPerMax, boolean estado) {

        this.cantPerMax = cantPerMax;
        this.estado = estado;
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

 

    

    

}
