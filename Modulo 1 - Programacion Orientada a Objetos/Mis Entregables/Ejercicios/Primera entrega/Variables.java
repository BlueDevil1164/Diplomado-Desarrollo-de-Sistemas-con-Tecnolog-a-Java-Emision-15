/*  Ejemplos de uso variables
    Noyola Nazario Alejandro
    Fecha 3 de mayo 2024
*/
public class Variables {
    public static void main (String[] args){
        //Este es el codigo que se ejecuta
        //Ejemplo de definicion de variables
        // tipo nombre;
        // tipo nombre = valor inicial;
        // boolean (solo puede tomar los valores de true y false)
        boolean aprobado = true;
        boolean soltero = false;
        System.out.println ("Los ejemplos de variables fueron los siguientes: " );
        System.out.println ("-----------------------------" );
        System.out.println ("El hombre es soltero? " + aprobado); //despligue de la palabra aprobado
        System.out.println ("-----------------------------" );

        //Numeros
        //Numeros Enteros (SIEMPRE CON SIGNO)
        //byte , short, int, long
        //   1      2    4    8
        //  1 byte = 8 bits --> 10000011 +3 00000011 -3
        byte edad = 99;
        System.out.println ("Valor de la varible =" + edad);
        System.out.println ("-----------------------------" );
        short peso = 136;
        System.out.println ("Peso: " + peso + "kg.");
        System.out.println ("-----------------------------" );
        int salario = 98765;
        System.out.println ("Sueldo de $ = " + salario);
        System.out.println ("-----------------------------" );
        long enteroGrande = 837464582;
        System.out.println ("Long de "+ enteroGrande);
        System.out.println ("-----------------------------" );

        //Numeros reales
        // float, double
        //   4       8
        float edadReal = 98.7F;
        // variable float = valor float
        double pesoReal = 123.45; // La D al final convierte (mantiene) la literal double

        // Caracter (char)
        char inicial = 'E'; // Las literales char van entre comillas simples (')
        System.out.println ("Letra:" + (inicial+3));
        System.out.println ("-----------------------------" );

        //¿ Y los String ?
        String nombre = "UNAM";
        System.out.println (nombre);
        System.out.println ("-----------------------------" );

        //??
        System.out.println (12.3 + 100);
        //                  double  int
        //                  double  double
        System.out.println ("-----------------------------" );

        double numero = 1.5 * 2;
        System.out.println (numero=789);
        System.out.println ("-----------------------------" );
        numero = edad = 78;
        //numero = algo
        //          edad = 78
        System.out.println (numero);
        System.out.println ("-----------------------------" );

        int calificacion = 10;
        System.out.println ("Calificacion de " + calificacion);
        System.out.println ("-----------------------------" );

        {   //Definicion de un bloque interno
            int asistencias = 8;
            System.out.println("Asistencias = " + asistencias);
            System.out.println ("-----------------------------" );

        }

        }



}
