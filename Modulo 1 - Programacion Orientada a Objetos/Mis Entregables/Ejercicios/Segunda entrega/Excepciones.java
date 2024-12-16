/*
 * Noyola Nazario Alejandro
 * Diplomado de desarrollo de Sistemas con Tecnología Java Emisión 15
 * Clase Excepciones
 * */
import java.util.InputMismatchException;
import java.util.Scanner;
public class Excepciones {
    public static void main (String[] args){
        System.out.println("Manejo de Excepciones");
        int variable = 10;
        variable = 20;
        Scanner teclado = new Scanner(System.in);
        int numero=99;

        try {
            numero = teclado.nextInt();
        }
        catch (InputMismatchException e){
            //Lo que hare cuando suceda una excepcion de tipo InputMismatchException
            System.out.println("Sucedio un problema con el valor de entrada");
            System.out.println("recuerda que debe ser un numero entero");
        }


        try {
            numero = teclado.nextInt();
            System.out.println("100 entre dicho numero es "+ (100/numero));
        } catch (ArithmeticException e){
            System.out.println("No puedes dividir por cero");
        }


        //Un try para varias lineas
        System.out.println("Prueba del segundo modelo de try");
        try{
            //teclado.close();
            numero = teclado.nextInt();

            System.out.println("100 entre dicho numero es "+(100/numero));
            //System.out.println("Corresponde al mes: "+ meses(numero-1));
        }
        catch (ArithmeticException e){
            //Lo que hare cuando suceda una excepcion de tipo InputMismatchException
            System.out.println("Sucedio un problema con el valor de entrada");
            System.out.println("recuerda que debe ser un numero entero");
        }
        try{
            numero = teclado.nextInt();
            System.out.println("100 entre dicho numero es "+(100/numero));
        }
        catch (ArithmeticException e){
            System.out.println("No puedes dividir por cero");
        }
        catch (Exception e){
            System.out.println("Sucedio algo inesperado. Error 6754. Contacta a tu administrador");
            System.out.println(e);
            System.out.println(e.getMessage());
        }

    }
}
