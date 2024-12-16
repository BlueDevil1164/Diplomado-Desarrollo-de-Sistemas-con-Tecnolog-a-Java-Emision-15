import java.util.ArrayList;

public class Polimorfismo {
    public static void main(String[] args) {
        System.out.println("Polimorfismo");

        Persona p = new Persona();
        // Clase o = new Clase();

        Cliente c = new Cliente();
        Asociado a = new Asociado();

        Persona x = new Cliente();
        // Superclase o = new Subclase();

        ArrayList<Persona> lista = new ArrayList<>();
        lista.add (new Persona());
        lista.add (new Cliente());
        lista.add (new Asociado());

        System.out.println("Lista: " + lista);

        for (int i=0; i < 3; i++){
            lista.get(i).setEdad((byte)11);
            System.out.println("Elemento "+i + ". COntenido= "+ lista.get(i));

        }
    }
}
