
package Entidades;


public class Huesped {
    private int idHuesped;
    private String nombre;
    private int dni;
    private String domicilio;
    private String correo;
    private int celular;
    private boolean alojado;

    public Huesped() {
    }

    public Huesped(int idHuesped, String nombre, int dni, String domicilio, String correo, int celular, boolean alojado) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.correo = correo;
        this.celular = celular;
        this.alojado = alojado;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public boolean isAlojado() {
        return alojado;
    }

    public void setAlojado(boolean alojado) {
        this.alojado = alojado;
    }

   
 
    
    
}
