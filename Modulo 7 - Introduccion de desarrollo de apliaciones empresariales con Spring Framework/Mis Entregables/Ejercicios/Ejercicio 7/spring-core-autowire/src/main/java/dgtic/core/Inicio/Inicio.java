package dgtic.core.Inicio;

import dgtic.core.modelo.*;
import dgtic.core.servicio.Servicio;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;

public class Inicio {
    public static void main(String[] args) {
    try {
        //Context carga los dos archivos de conf
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{
                        "bean-configuration.xml"
                }
        );

        //Logica de negocio
        Empleado empleado = context.getBean("empleado", Empleado.class);
        System.out.println(empleado);
        if (empleado.getActividad()!=null){
            empleado.getActividad().realiza();
        }else{
            System.out.println("No hay dependencia");
            System.out.println(empleado);
        }
        ((ClassPathXmlApplicationContext)context).close();
    } catch (UnsatisfiedDependencyException ex){
        System.out.println("error dependencia");
    }
    }
}
