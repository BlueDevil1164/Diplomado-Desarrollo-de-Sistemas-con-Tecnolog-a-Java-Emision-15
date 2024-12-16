package dgtic.core.servicio;

import dgtic.core.modelo.Empleado;

public class Servicio {

    private static Servicio instance = new Servicio();
    private Empleado empleado;

    private Servicio() {}

    public static Servicio getInstance() {
        return instance;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void iniciar(){
        System.out.println("Inicio servicio");
    }

    public void destroy(){
        System.out.println("Liberando los recursos.");
    }
}
