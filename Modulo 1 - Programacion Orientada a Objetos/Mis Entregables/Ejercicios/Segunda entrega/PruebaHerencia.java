/*
 * Noyola Nazario Alejandro
 * Diplomado de desarrollo de Sistemas con Tecnología Java Emisión 15
 * Clase PruebaHerencia
 * */
public class PruebaHerencia {
    public static void main(String[] args){
        System.out.println("----------------------------------------------------------------------------------------------------");

        System.out.println("Ejemplo de herencia en java");
        System.out.println("----------------------------------------------------------------------------------------------------");

        Persona o1 = new Persona();
        System.out.println(o1);
        System.out.println("----------------------------------------------------------------------------------------------------");

        Persona o2 = new Estudiante(9888);
        System.out.println(o2);
        System.out.println("----------------------------------------------------------------------------------------------------");


        Egresado o3 = new Egresado();
        System.out.println(o3);
        System.out.println("----------------------------------------------------------------------------------------------------");

        Docente o4 = new Docente();
        System.out.println(o4);
        System.out.println("----------------------------------------------------------------------------------------------------");


        System.out.println(o4 instanceof Docente);
        System.out.println(o4 instanceof Persona);
        System.out.println("----------------------------------------------------------------------------------------------------");


        System.out.println(o4.getClass());
        System.out.println("----------------------------------------------------------------------------------------------------");

        System.out.println(o2.getClass());
        System.out.println("----------------------------------------------------------------------------------------------------");


        double pi = 3.1416;
        double iva = 0.16;
        System.out.println(pi);
        System.out.println(iva);
        System.out.println("----------------------------------------------------------------------------------------------------");

        iva = 0.87;
        System.out.println(iva);
        System.out.println("----------------------------------------------------------------------------------------------------");

    }
}
