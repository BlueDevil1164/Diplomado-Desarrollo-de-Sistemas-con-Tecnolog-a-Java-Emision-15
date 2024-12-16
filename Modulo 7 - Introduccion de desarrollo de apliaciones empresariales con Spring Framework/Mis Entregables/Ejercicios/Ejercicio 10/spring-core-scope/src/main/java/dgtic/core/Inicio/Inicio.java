package dgtic.core.Inicio;

import dgtic.core.modelo.*;
import dgtic.core.servicio.Servicio;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;

public class Inicio {
    public static void main(String[] args) {
        //Context carga los dos archivos de conf
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{
                        "bean-configuration.xml",
                        "bean-services.xml"
                }
        );
        try {
            Persona persona=context.getBean("persona", Persona.class);
            System.out.println(persona);
            System.out.println(persona);
            persona.getCoche().getModeloCoche(TipoCarro.FAMILIAR).crear();
            persona.getCoche().getModeloCoche(TipoCarro.DEPORTIVO).crear();
            System.out.println("---------------------");
            Persona personaDos=context.getBean("personaDos", Persona.class);
            System.out.println(personaDos);

        } catch(IllegalAccessException ex){
            System.out.println(ex.getMessage());
        }

        ((ClassPathXmlApplicationContext) context).close();
    }
}
