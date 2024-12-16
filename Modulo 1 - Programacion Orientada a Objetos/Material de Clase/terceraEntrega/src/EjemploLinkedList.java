import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class EjemploLinkedList {

    public static void main(String[] args) {
        System.out.println("Listas enlazadas con LinkedList");
        LinkedList<String> listaE = new LinkedList<>();

        List<String> x = new LinkedList<>();

        listaE.add("Hugo");
        System.out.println("Lista inicial: "+ listaE);

        listaE.addFirst ("Paco");  // add (0, x)
        listaE.addLast ("Luis");   // add(x) de ArrayList
        System.out.println("Después de add First y addLast: "+ listaE);

        System.out.println("Primer elemento: "+ listaE.getFirst());  // get(0)
        System.out.println("Último elemento: "+ listaE.getLast());   // get (lista.size()-1)

        // push(elemento)
        listaE.push ("Donald");  // ¿Dónde lo agrega?
        System.out.println("Después del push(): "+ listaE);

        // peek()
        System.out.println("Peek: " + listaE.peek());  // Regresa el primero
        System.out.println("Después del peek(): "+listaE);

        // pop()
        System.out.println("Pop: " + listaE.pop());  // Regresa el primero
        System.out.println("Después del pop(): "+listaE);

        Collections.sort (listaE);
        System.out.println("Después del sort: "+listaE);

    }
}
