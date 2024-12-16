package dgtic.core.inicio;

import dgtic.core.modelo.Empleado;
import dgtic.core.modelo.PlanificacionProyectos;
import dgtic.core.servicio.Servicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inicio {
    public static void main(String[] args) {
        //Context carga los dos archivos de conf
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{
                        "bean-configuration.xml"
                }
        );

        //Logica de negocio
        Empleado empleado = context.getBean("empleado", Empleado.class);
        System.out.println(empleado);
        empleado.getActividad().realiza();
        System.out.println("----------------");
        Empleado emplDos = context.getBean("empleadoDos", Empleado.class);
        emplDos.getActividad().realiza();
        System.out.println("----------------");
        Empleado emplTres=context.getBean("empleadoTres",Empleado.class);
        ((PlanificacionProyectos)emplTres.getActividad()).setNumeroProyectos(20);
        System.out.println(((PlanificacionProyectos)emplTres.getActividad()).getNumeroProyectos());
        System.out.println("---------------");
        Empleado emplCuatro=context.getBean("empleadoCuatro",Empleado.class);
        ((PlanificacionProyectos)emplCuatro.getActividad()).setNumeroProyectos(3);
        System.out.println(((PlanificacionProyectos)emplCuatro.getActividad()).getNumeroProyectos());
        System.out.println("---------------");
        ((PlanificacionProyectos)emplTres.getActividad()).setNumeroProyectos(-1);
        ((PlanificacionProyectos)emplCuatro.getActividad()).setNumeroProyectos(90);
        System.out.println(((PlanificacionProyectos)emplTres.getActividad()).getNumeroProyectos());
        System.out.println(((PlanificacionProyectos)emplCuatro.getActividad()).getNumeroProyectos());


        ((ClassPathXmlApplicationContext)context).close();

    }
}
