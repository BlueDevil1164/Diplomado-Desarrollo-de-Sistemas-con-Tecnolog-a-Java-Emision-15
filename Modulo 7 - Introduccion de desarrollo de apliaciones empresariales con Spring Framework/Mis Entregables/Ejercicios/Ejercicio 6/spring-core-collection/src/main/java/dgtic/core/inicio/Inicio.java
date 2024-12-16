package dgtic.core.inicio;

import dgtic.core.modelo.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;

public class Inicio {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {
                        "bean-configuration.xml"
                }
        );

        Empleado empleado = context.getBean("empleado", Empleado.class);
        System.out.println(empleado);
        ((PlanificacionProyectos) empleado.getActividad().get(2)).setNumeroProyectos(20);
        ((PlanificacionProyectos) empleado.getActividad().get(3)).setNumeroProyectos(1);
        for(Actividades act: empleado.getActividad()){
            act.realiza();
        }
        System.out.println(((PlanificacionProyectos) empleado.getActividad().get(2)).getNumeroProyectos());
        System.out.println(((PlanificacionProyectos) empleado.getActividad().get(3)).getNumeroProyectos());

        System.out.println("---------------------------------------------");

        EmpleadoS empleado2 = context.getBean("empleadoDos", EmpleadoS.class);
        System.out.println(empleado2);
        for(Actividades act: empleado2.getActividad()){
            act.realiza();
        }

        System.out.println("---------------------------------------------");

        EmpleadoM empleado3 = context.getBean("empleado3", EmpleadoM.class);
        System.out.println(empleado3);
        for(String key: empleado3.getActividad().keySet()){
            System.out.print("LLave: " + key + " -> ");
            empleado3.getActividad().get(key).realiza();
        }

        System.out.println("---------------------------------------------");
        EmpleadoP empleado4 = context.getBean("empleado4", EmpleadoP.class);
        System.out.println(empleado4);
        for (Iterator<Object> iter=empleado4.getActividad().keySet().iterator(); iter.hasNext(); ) {
            String key = (String) iter.next();
            System.out.print("LLave: " + key + " -> ");
            System.out.println(empleado4.getActividad().get(key));
        }











        ((ClassPathXmlApplicationContext) context).close();
    }
}

