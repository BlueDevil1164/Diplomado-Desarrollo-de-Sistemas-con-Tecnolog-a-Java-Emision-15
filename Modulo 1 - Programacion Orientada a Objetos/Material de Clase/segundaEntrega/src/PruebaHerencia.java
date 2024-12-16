public class PruebaHerencia {
    public static void main (String[] args){
        System.out.println ("Ejemplo de herencia en Java");

        Persona o1 = new Persona();
        System.out.println (o1);

        Estudiante o2 = new Estudiante(9988);
        o2.setEdad(44.8);
        System.out.println ("OBJETO NUEVO: " + o2);

        Egresado o3 = new Egresado ();
        System.out.println (o3);

        Docente o4 = new Docente();
        o4.setNombre("Hugo");
        o4.setEdad(20);
        o4.setNumeroEmpleado(44);
        System.out.println (o4);


        Docente o5 = new Docente();
        o5.setNumeroEmpleado(55);
        o5.setNombre ("Hugo");
        o5.setEdad (20);
        System.out.println (o5);

        System.out.println ("¿Son iguales los docentes ?"+ o4.equals(o1));

        // o4 es de tipo Docente  ¿es también de tipo Persona?
        System.out.println (o4 instanceof Docente);
        System.out.println (o4 instanceof Persona);

        System.out.println (o2.getClass());






    }
}
