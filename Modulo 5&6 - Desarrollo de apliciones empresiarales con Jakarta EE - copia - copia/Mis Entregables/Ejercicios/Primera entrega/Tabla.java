import java.util.Scanner;

public class Tabla {
        public static void  main(String[] args ){
            Scanner teclado = new Scanner(System.in);
            int contador = 0;
            int numero = 0;


            System.out.println("Escribe un numero");
            numero = teclado.nextInt();
            System.out.println("la tabla del numero "+ numero +" es la siguiente: ");


            //el ciclo a repetir
            while  (contador < 11){
                System.out.println( numero+" X "+contador+" = "+(contador*numero)  );
                contador++;
            }

        }
}
