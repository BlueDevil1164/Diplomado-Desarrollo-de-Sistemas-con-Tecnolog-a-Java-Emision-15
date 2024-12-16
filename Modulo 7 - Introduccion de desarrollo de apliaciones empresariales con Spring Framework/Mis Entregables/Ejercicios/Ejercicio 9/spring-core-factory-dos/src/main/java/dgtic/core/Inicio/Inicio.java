package dgtic.core.Inicio;

import dgtic.core.servicio.EmpleadoServicio;
import dgtic.core.servicio.PredeterminadoServicio;
import dgtic.core.servicio.ReporteEmpleadoServicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Inicio {
    public static void main(String[] args) {
        //Context carga los dos archivos de conf
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{
                        "bean-configuration.xml",
                        "bean-services.xml"
                }
        );
        EmpleadoServicio servicioUno=context.getBean("empleadoServicio",EmpleadoServicio.class);
        servicioUno.servicioEmpleado();

        ReporteEmpleadoServicio reporteEmpleadoServicio=context.getBean("empleadoServicioReporte", ReporteEmpleadoServicio.class);
        reporteEmpleadoServicio.reporteDiario();

        System.out.println("--------------------------");
        PredeterminadoServicio predeterminadoServicio= context.getBean("servicioLocal", PredeterminadoServicio.class);
        predeterminadoServicio.getEmpleadoServicio().servicioEmpleado();
        predeterminadoServicio.getReporteEmpleadoServicio().reporteDiario();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
