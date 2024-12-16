import java.util.Scanner;

public class EjemploIf {
    public static void main (String[] args){
        // Ejemplo de uso de if-else
        int edad = 0;
        Scanner entrada = new Scanner (System.in);


        System.out.print("Ejemplo de un if que consiste en valorar una variable de edad si es o no es (+18)\n" +
                        "El usuario responde la siguiente pregunta: \n");
        System.out.println("----------------------------------------------");
        System.out.print("¿Cuantos años tienes? \n" + "Tu Respuesta: ");
        edad =entrada.nextInt();



        //if
        System.out.println("----------------------------------------------");
        System.out.print("***Este caso en la edad esa menor a 18***\n");
        if (edad < 18) {
            System.out.println("Aun no votar, lo siento");
            System.out.println("te faltan " + (18 - edad) + " años");
        }else {
            System.out.println("----------------------------------------------");
            System.out.println("***Este caso en la edad esa mayor a 18\n***");
            System.out.println("**************************************************");
            System.out.println("Puedes votar, bien hecho");
            System.out.println("No necesitas esperar mas años");
        }

        System.out.println("----------------------------------------------");
        if (edad >= 65) {
            System.out.println("En el caso que la edad sea mayor a 65");
            System.out.println("----------------------------------------------");
            System.out.println("felicidades entras gratis al metro");
        }else{
            System.out.println("En el caso que la edad sea menor a 65");
            System.out.println ("Por desgracia no puedes entrar al metro gratis");
        }
        System.out.println("----------------------------------------------");
        System.out.println("Eso es todo, bye, bye");
    }

}
