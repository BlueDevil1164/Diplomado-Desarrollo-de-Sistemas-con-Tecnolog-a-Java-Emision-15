package dgtic.core.inicio;

import dgtic.core.modelo.*;
import dgtic.core.servicio.Servicio;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;

public class Inicio {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{
                        "bean-configuration.xml",
                        "bean-services.xml"
                }
        );

        Empleado emp1 = context.getBean("empleado", Empleado.class);
        emp1.limpiar();
        //System.out.println(emp1);
        System.out.println("--------------");
        Servicio servicio1 = context.getBean("servicio", Servicio.class);
        servicio1.getEmpleado().limpiar();





        ((ClassPathXmlApplicationContext) context).close();

    }
}

