package dgtic.core.servicio;

import dgtic.core.modelo.Empleado;

public class Servicio {
    private Empleado empleado;

    public Servicio() {

    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "empleado=" + empleado +
                '}';
    }
}
