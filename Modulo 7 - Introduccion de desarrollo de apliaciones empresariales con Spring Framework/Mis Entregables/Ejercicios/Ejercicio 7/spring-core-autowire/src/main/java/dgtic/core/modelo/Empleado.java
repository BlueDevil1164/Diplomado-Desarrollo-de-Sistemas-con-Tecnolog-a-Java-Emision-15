package dgtic.core.modelo;

import java.util.ArrayList;

public class Empleado {
    private String nombre;
    private Integer edad;
    private Actividades actividad;
    //private ArrayList<Actividades> actividades; // Usa ArrayList en lugar de Collection

    /*
    public Empleado() {
    }
    */

    public Actividades getActividad() {
        return actividad;
    }

    public void setActividad(Actividades actividad) {
        this.actividad = actividad;
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
