package Entidades;

import java.time.LocalDate;

public class Reserva {

    private String idReserva;
    private Huesped huesped;
    private tipoHab habitacion;
    private int cantPer;
    private LocalDate fechaIng;
    private LocalDate fechaSal;
    private double importe;

    public Reserva() {
    }

    public Reserva(String idReserva, Huesped huesped, tipoHab habitacion, int cantPer, LocalDate fechaIng, LocalDate fechaSal, double importe) {
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.cantPer = cantPer;
        this.fechaIng = fechaIng;
        this.fechaSal = fechaSal;
        this.importe = importe;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
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

}
