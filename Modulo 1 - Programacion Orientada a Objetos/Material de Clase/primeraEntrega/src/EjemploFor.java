import java.util.Scanner;

public class EjemploFor {
    public static void main (String[] args){
        // Ejemplo de for

        int numero = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.print ("Dame un número y te daré su tabla de multiplicar ");
        numero = teclado.nextInt();

        for ( int contador=1    ; contador<=10     ;  contador++  ){
            // Lo que se repite en cada iteración/vuelta
            System.out.println (numero+" x "+ contador + " = "+ numero*contador);
        }
        System.out.println ("Bye");
    }
}
