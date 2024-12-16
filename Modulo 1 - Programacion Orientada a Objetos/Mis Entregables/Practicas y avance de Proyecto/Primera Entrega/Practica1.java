/*
* Noyola Nazario Alejandro
* Diplomado de desrrollo de Tecnogias con java
* */
import java.util.Scanner;
public class Practica1 {
    // Definicion de Subrutinas
    /// Procedimientos
    public static  void Candidatura(){
        //Nuestro menu
        System.out.println(" 0: Luis");
        System.out.println(" 1: Paco");
        System.out.println(" 2: Hugo");
        System.out.println(" 3: Nulo");
        System.out.println(" 4: Terminar");
    }
    public static void main (String[] args) {
        int candidatos = 5;
        int votosL = 0;
        int votosP = 0;
        int votosH = 0;
        int votosN = 0;
        double votos = 0.0;

        double porcentajeL = 0.0;
        double porcentajeP = 0.0;
        double porcentajeH = 0.0;
        double porcentajeN = 0.0;

        double candidatura = 0.0;

        do {
            //Nuestro menu
            System.out.println("------------------------------------------------------");
            System.out.println("Las opciones de la eleccion es la siguiente:");
            System.out.println(" 0: Luis");
            System.out.println(" 1: Paco");
            System.out.println(" 2: Hugo");
            System.out.println(" 3: Nulo");
            System.out.println(" 4: Terminar Eleccion");
            System.out.print("¿Por quien vas a votar? Escribe su numero.\n");
            System.out.println("------------------------------------------------------");

            System.out.println("El numero de tu voto es: ");
            Scanner teclado = new Scanner(System.in);

            //Uso de switch como Menu
            candidatos = teclado.nextInt();
            //Mensajes por cada opcion
            switch (candidatos) {

                case 0:
                    System.out.println(" Votaste por Luis");
                    votos++;
                    votosL++;
                    System.out.println("los votos de Luis son = " + votosL);
                    break;
                case 1:
                    System.out.println(" Votaste por Paco");
                    votos++;
                    votosP++;
                    porcentajeP = (votosP * 100 / votos);
                    System.out.println("los votos de Paco son = " + votosP);


                    break;
                case 2:
                    System.out.println(" Votaste por Hugo");
                    votos++;
                    votosH++;
                    System.out.println("los votos de Hugo son = " + votosH);

                    break;
                case 3:
                    System.out.println(" Votaste por Voto Nulo");
                    votos++;
                    votosN++;
                    System.out.println("los votos Nulos son = " + votosN);
                    break;
                default:
                    System.out.println("Votacion finalizada");
                    System.out.println("Es todo por hoy gracias");
                    break;
            }

        } while (candidatos !=4);

        if (votos > 0) {

            porcentajeL = (votosL * 100 / votos);
            porcentajeP = (votosP * 100 / votos);
            porcentajeH = (votosH * 100 / votos);
            porcentajeN = (votosN * 100 / votos);

            candidatura = (porcentajeL + porcentajeP + porcentajeH );

            System.out.println("Los resultados de la elección son los siguientes:");
            System.out.println("Votos Luis = " + porcentajeL + "%" + " Con un total de " + votosL + " votos");
            System.out.println("Votos Paco = " + porcentajeP + "%" + " Con un total de " + votosP + " votos");
            System.out.println("Votos Hugo = " + porcentajeH + "%" + " Con un total de " + votosH + " votos");
            System.out.println("Votos Nulos = " + porcentajeN + "%" + " Con un total de " + votosN + " votos");

            System.out.println("------------------------------------------------------");
            System.out.println( "El resultado de votos no Nulos es igual a = "+candidatura);
            System.out.println("------------------------------------------------------");
        } else {

            System.out.println("No hay Candidatura si no votas por nadie :(");
            System.out.println("------------------------------------------------------");
        }
    }
}


