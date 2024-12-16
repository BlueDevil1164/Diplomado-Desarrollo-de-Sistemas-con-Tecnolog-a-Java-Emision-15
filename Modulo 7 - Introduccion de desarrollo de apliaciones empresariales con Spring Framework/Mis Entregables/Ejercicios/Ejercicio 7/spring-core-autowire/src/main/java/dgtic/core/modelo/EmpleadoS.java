package dgtic.core.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class EmpleadoS {
    private String nombre;
    private Integer edad;

    public void setActividades(Set<Actividades> actividades) {
        this.actividades = actividades;
    }

    private Set<Actividades> actividades;

    public Collection<Actividades> getActividad() {
        return actividad;
    }

    public void setActividad(Collection<Actividades> actividad) {
        this.actividad = actividad;
    }

    private Collection<Actividades> actividad;

    public EmpleadoS() {
    }

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


    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
