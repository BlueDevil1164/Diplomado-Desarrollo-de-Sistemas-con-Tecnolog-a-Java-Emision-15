// Ejemplo de uso de Scanner para
// capturar datos del teclado
// Carlos Eligio

// 1. import para "avisar" que usaremos Scanner
import java.util.Scanner;
public class CapturaDeTeclado {
    public static void main (String[] args) {
        // 2. Crear objeto de la clase Scanner
        Scanner teclado = new Scanner (System.in);  // System.in es el teclado

        String nombre = "Desconocido";
        int edad = 0;
        double calificacion = 0.0;

        System.out.println ("Te voy a pedir unos datos...");
        System.out.print ("Nombre: ");
        // 3. Ya podemos pedir datos.
        nombre = teclado.nextLine();  // Capturar un dato String
        System.out.print ("¿Cuántos años tienes? ");
        edad = teclado.nextInt();

        System.out.print ("¿Qué calificación obtuviste? ");
        calificacion = teclado.nextDouble();

        System.out.println ("Hola "+nombre);
        System.out.println ("Tienes "+edad+" años");
        System.out.println ("Tu calificación fue de "+calificacion);
    }
}
