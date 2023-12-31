package Entidades;

import java.time.LocalDate;

public class Reserva {
    private Usuarios usuario; 
    private int idReserva;
    private Huesped huesped; // huspedData buscarporid huesped.getDni
    private tipoHab habitacion; // habitacionData buscarporid hab.getTipoHab
    private int cantPer;
    private LocalDate fechaIng;
    private LocalDate fechaSal;
    private double importe;
    private boolean estado;

    public Reserva() {
    }

    public Reserva(Huesped huesped, tipoHab habitacion, int cantPer, LocalDate fechaIng, LocalDate fechaSal, double importe, boolean estado) {
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.cantPer = cantPer;
        this.fechaIng = fechaIng;
        this.fechaSal = fechaSal;
        this.importe = importe;
        this.estado = estado;
    }

    public Reserva(int idReserva, Huesped huesped, tipoHab habitacion, int cantPer, LocalDate fechaIng, LocalDate fechaSal, double importe, boolean estado) {
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.cantPer = cantPer;
        this.fechaIng = fechaIng;
        this.fechaSal = fechaSal;
        this.importe = importe;
        this.estado = estado;
    }
    
    

    public Reserva(Usuarios usuario, int idReserva, Huesped huesped, tipoHab habitacion, int cantPer, LocalDate fechaIng, LocalDate fechaSal, double importe, boolean estado) {
        this.usuario = usuario;
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.cantPer = cantPer;
        this.fechaIng = fechaIng;
        this.fechaSal = fechaSal;
        this.importe = importe;
        this.estado = estado;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public tipoHab getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(tipoHab habitacion) {
        this.habitacion = habitacion;
    }

    public int getCantPer() {
        return cantPer;
    }

    public void setCantPer(int cantPer) {
        this.cantPer = cantPer;
    }

    public LocalDate getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(LocalDate fechaIng) {
        this.fechaIng = fechaIng;
    }

    public LocalDate getFechaSal() {
        return fechaSal;
    }

    public void setFechaSal(LocalDate fechaSal) {
        this.fechaSal = fechaSal;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    

   

}
