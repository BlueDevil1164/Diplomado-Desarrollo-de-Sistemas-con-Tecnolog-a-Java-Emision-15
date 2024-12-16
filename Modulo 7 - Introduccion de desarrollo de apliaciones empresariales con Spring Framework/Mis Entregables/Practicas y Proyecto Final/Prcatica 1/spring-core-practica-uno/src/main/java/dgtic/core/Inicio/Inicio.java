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
            persona.setNombre("Oscar");
            persona.setEdad(24);
            persona.getCorreo("oscarNoda72@gmail.com");
            System.out.println(persona);
            persona.setNombre("Adela");
            persona.setEdad(50);
            persona.setCorreo("adela25@gmail.com");
            System.out.println(persona);
            persona.setNombre("Valerie");
            persona.setEdad(27);
            persona.setCorreo("Val117@gmail.com");
            System.out.println(persona);
            persona.getProducto().getProductos(TipoElectronico.LAPTOP).registrar();
            persona.getProducto().getProductos(TipoElectronico.CELULAR).registrar();
            persona.getProducto().getProductos(TipoElectronico.CELULAR).registrar();
            persona.getProducto().getProductos(TipoElectronico.TABLET).registrar();
            System.out.println("---------------------");

        } catch(IllegalAccessException ex){
            System.out.println(ex.getMessage());
        }

        ((ClassPathXmlApplicationContext) context).close();
    }
}
