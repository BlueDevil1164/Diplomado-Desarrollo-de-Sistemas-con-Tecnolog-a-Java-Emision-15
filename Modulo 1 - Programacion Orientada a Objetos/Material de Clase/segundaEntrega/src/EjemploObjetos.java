public class EjemploObjetos {
    // Atributos

    // Métodos
    public static void main (String[] args){
        // Ejemplo de instanciación/creación de objetos
        // Clase objeto = new Clase ();

        Casa objeto1 = new Casa();
        Casa objeto2 = new Casa();  // Creamos referencia y asignamos una casa
        Casa objeto3;  //Creando la referencia a una casa

        objeto3 = objeto1;   //  ???

        objeto3.comprado = true;

        System.out.println ("Mi primer objeto: "+ objeto1);
        System.out.println ("Mi segundo objeto: "+ objeto2);
        System.out.println ("Mi tercer objeto: "+ objeto3);

        double precio=123.45;
        // Atributos de los objetos
        // objeto.atributo
        // De mi primer objeto...
        System.out.println("Precio de mi primer casa: "+objeto1.precio);
        objeto1.precio = 100;
        objeto1.color = "Negro";
        objeto1.precio = 999;
        System.out.println("Precio de mi primer casa: "+objeto1.precio);
        System.out.println ("Color de mi primer casa: " + objeto1.color);
        System.out.println ("¿Está vendida? "+ objeto1.comprado);

        // De mi segundo objeto...
        objeto2.superficieConstruccion = 789;

        System.out.println ("Superficie construida: " +objeto2.superficieConstruccion);
        System.out.println ("Color de mi segunda casa: " + objeto2.color);

        // Mi tercer objeto
        objeto3.precio = 88;
        System.out.println("Precio de mi PRIMER casa: "+objeto1.precio);
        System.out.println("Precio de mi tercer casa: "+objeto3.precio);
        System.out.println ("Color de mi tercer casa: " + objeto3.color);
        System.out.println ("¿Está vendida? "+ objeto3.comprado);
    }
}
