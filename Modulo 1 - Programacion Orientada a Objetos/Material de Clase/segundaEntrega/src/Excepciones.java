import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {
    public static void main (String[] args){
        System.out.println("Manejo de excepciones");
        int variable = 10;
        variable = 20;
        Scanner teclado = new Scanner(System.in);
        int numero=99;
        System.out.print  ("Dame un número...");

        // Un try para cada línea-bloque que pueda generar excepciones

        try {
            if (teclado.hasNext())  // Si "hay algo" en el buffer del teclado
                teclado.nextLine();  // Leen la línea ("flush")
              numero = teclado.nextInt();

        }
        catch (InputMismatchException e){
            // Lo que haré cuando suceda una excepción de tipo InputMismatchException
            System.out.println ("Sucedió un problema con el valor de entrada");
            System.out.println ("recuerda que debe ser un número entero");
        }

        try {
            System.out.println ("100 entre dicho número es "+ (100/numero));
        } catch (ArithmeticException e){
            System.out.println ("No puedes dividir por cero");
        }
// Ya no existe x

        // Un try para varias líneas
        System.out.println(" Prueba del segundo modelo de try");
        System.out.print ("Dame otro número: ");
        // Arreglo (llamado meses) con los nombres de los 12 meses
        String [] meses = {"Enero", "Feb", "Mar", "Dic"};
        try {
            //teclado.close();
            numero = teclado.nextInt(); // No se pude hacer uso de teclado porque está cerrado

            System.out.println ("100 entre dicho número es "+ (100/numero));
            System.out.println ("Corresponde al mes: "+ meses[numero-1]);
        }
        catch (InputMismatchException e){
            // Lo que haré cuando suceda una excepción de tipo InputMismatchException
            System.out.println ("Sucedió un problema con el valor de entrada");
            System.out.println ("recuerda que debe ser un número entero");
        }
        catch (ArithmeticException e){
            System.out.println ("No puedes dividir por cero");
        }

        catch (Exception e){   // Atrapara cualquier excepción no contemplada
            System.out.println ("Sucedió algo inesperado. Error 6754. Contacta a tu administrador");
            System.out.println(e);
            System.out.println (e.getMessage());
            e.printStackTrace();
        }

    }
}
