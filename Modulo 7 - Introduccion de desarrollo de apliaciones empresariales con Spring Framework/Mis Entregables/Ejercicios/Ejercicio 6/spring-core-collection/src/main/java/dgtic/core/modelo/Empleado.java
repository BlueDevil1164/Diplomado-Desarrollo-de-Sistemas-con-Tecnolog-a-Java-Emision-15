package dgtic.core.modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Empleado {

    private String nombre;
    private Integer edad;
    private ArrayList<Actividades> actividad;

    public Empleado() {}

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

    public ArrayList<Actividades> getActividad() {
        return actividad;
    }

    public void setActividad(ArrayList<Actividades> actividad) {
        this.actividad = actividad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
