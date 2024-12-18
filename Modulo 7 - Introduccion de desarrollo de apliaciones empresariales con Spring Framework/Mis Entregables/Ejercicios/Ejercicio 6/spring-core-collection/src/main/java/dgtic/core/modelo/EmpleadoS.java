package dgtic.core.modelo;

import java.util.ArrayList;
import java.util.Set;

public class EmpleadoS {

    private String nombre;
    private Integer edad;
    private Set<Actividades> actividad;

    public EmpleadoS() {}

    public EmpleadoS(String nombre) {
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

    public Set<Actividades> getActividad() {
        return actividad;
    }

    public void setActividad(Set<Actividades> actividad) {
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
