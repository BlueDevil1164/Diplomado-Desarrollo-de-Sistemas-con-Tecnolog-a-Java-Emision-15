package dgtic.core.servicio;

public class PredeterminadoServicio {
    // Instancias únicas de los servicios
    private static final EmpleadoServicio empleadoServicio = new EmpleadoServicioImpl();
    private static final ReporteEmpleadoServicio empleadoReporteServicio = new ReporteEmpleadoImpl();

    // Constructor privado para evitar instancias externas
    private PredeterminadoServicio() {
    }

    // Métodos para obtener los servicios
    public EmpleadoServicio getEmpleadoServicio() {
        return empleadoServicio;
    }

    public ReporteEmpleadoServicio getReporteEmpleadoServicio() {
        return empleadoReporteServicio;
    }
}
