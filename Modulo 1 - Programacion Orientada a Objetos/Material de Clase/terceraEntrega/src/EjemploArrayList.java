import java.util.ArrayList;
import java.util.Collections;

public class EjemploArrayList {
    public static void main(String[] args) {
        System.out.println("Uso de ArrayList");
        // Instancia de clase genérica:
        // Clase<Tipo> objeto = new Clase<Tipo> ();

        ArrayList<String> personajes = new ArrayList<String>();
        // Porque implementa Collection

        personajes.add ("Rachel");  // Agrega elementos al ArrayList
        personajes.add ("Mónica");
        personajes.add ("Chandler");
        personajes.add ("Chandler");   // ¿Permite valores repetidos?
        personajes.add ("Ross");

        System.out.println("Colección: " + personajes);
        System.out.println ("¿Está vacía? " + personajes.isEmpty());
        System.out.println("Número de elementos: " + personajes.size());

        personajes.remove ("Chandler"); // ¿A cuántos elimina?
        System.out.println("Después del remove: " + personajes);

        // Porque implementó List
        personajes.add (2, "Phoebe");
        System.out.println("Después del add (índice,valor): " + personajes);

        personajes.add ("Joey");  // Agrega al final
        System.out.println("Con todos: " + personajes);
        ///
        personajes.set (3, "VALOR CAMBIADO");
        System.out.println("Cambiando la posición 3: " + personajes);

        personajes.add ("Mónica");
        System.out.println("¿Dónde está Chandler? " + personajes.indexOf ("Chandler"));
        System.out.println("¿Dónde está Mónica? " + personajes.indexOf ("Mónica"));
        System.out.println("¿Dónde está Mónica? " + personajes.lastIndexOf ("Mónica"));
        System.out.println("Final: " + personajes);
        // Algunos métodos de Collections
        Collections.sort (personajes);
        System.out.println("Después del sort: " + personajes);

        System.out.println( "¿Está Ross? "+personajes.contains("Ross"));
        System.out.println( "¿Está Hugo? "+personajes.contains("Hugo"));

        System.out.println("¿Qué hay en el índice 3? "+ personajes.get(3));
        int indice=0;

        for (indice=0; indice < personajes.size(); indice++)
            System.out.println (personajes.get (indice) + " en la posición "+ indice);

        for (String elemento : personajes)
            System.out.print (elemento+", ");
        System.out.println();  // Salto de línea

        Collections.fill (personajes, "??");
        System.out.println("Después del fill: " + personajes);

        personajes.clear();
        System.out.println("Después del clear(): "+ personajes);

        // ArrayList de Productos
        ArrayList<Producto> inventario = new ArrayList<>();
        System.out.println("Catálogo inicial: "+ inventario);

        inventario.add(new Producto());  // Agrega un producto nuevo
        System.out.println("Después de un add: "+ inventario);

        inventario.add (new Producto ("Agua", 10));
        inventario.add (new Producto ("Jabón", 7));
        inventario.add (new Producto ("Sal", 20));
        inventario.add (new Producto ("Azúcar", 5.5));
        System.out.println("Después de varios add: "+ inventario);

        System.out.println("¿Está vacío el catálogo? "+ inventario.isEmpty());
        System.out.println("Tamaño del catálogo: " + inventario.size());

        Collections.sort (inventario);
        System.out.println("Después del sort: "+ inventario);

        System.out.println("¿Hay Aguacate? " + inventario.contains(new Producto ("Aguacate",8)));
        System.out.println("¿Hay Sal? " + inventario.contains(new Producto ("Sal",55)));

        System.out.println("¿Dónde está el Aguacate: "+ inventario.indexOf(new Producto ("Aguacate",33)));
        System.out.println("¿Dónde está el Azúcar? " + inventario.indexOf(new Producto ("Azúcar",99)));

    }
}
