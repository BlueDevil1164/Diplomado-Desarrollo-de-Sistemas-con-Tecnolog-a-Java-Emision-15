import java.util.Scanner;

public class EjemploIf {
    public static void main (String[] args){
        // Ejemplo de uso de if-else
        int edad = 0;
        Scanner entrada = new Scanner (System.in);

        System.out.print ("¿Cuántos años tienes? ");
        edad = entrada.nextInt();

        // if
        if (edad < 18) {  // Lo siquiente se ejecuta solo cuando es MENOR de edad
            System.out.println("Aún no puedes votar, lo siento");
            System.out.println("Te faltan " + (18 - edad));
        }

        // if-else
        if (edad >= 65){
            // Cuando la persona es de la tercera edad
            System.out.println ("Felicidades, ya entras gratis al metro");
        } else {
            // Cuando aún no es de la tercera edad
            System.out.println ("Aún eres joven");
        }
        System.out.println ("Eso es todo, bye");
    }
}
