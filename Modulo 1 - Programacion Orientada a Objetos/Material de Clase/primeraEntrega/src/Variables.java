/* Ejemplo de definición y uso de variables
   Carlos Eligio Ortiz
   Creado el 3 de mayo de 2024
*/
public class Variables {
    public static void main (String[] args){
        // Este es el código que se ejecuta
        // Ejemplo de definición de variables
        //  tipo nombre;
        //  tipo nomnbre = valor inicial;
        // boolean (solo puede tomar los valores true y false)
        boolean aprobado = true;
        boolean soltero = false;
        System.out.println (aprobado);   // Despliegue en pantalla de la variable aprobado

        // Números
        // Números enteros (SIEMPRE CON SIGNO)
        // byte, short, int, long
        //  1      2     4     8
        // 1 byte = 8 bits   -->  10000011   +3   00000011   -3
        byte edad = 99;
        System.out.println ("Valor de la variable = "+edad);
        short peso = 136;
        System.out.println ("Peso: "+peso + " kg.");
        int salario = 98765;
        System.out.println("Sueldo de $"+salario);
        long enteroGrande = 837_464_582;  // El _ aumenta la legibilidad (permite separar bloques de dígitos)
        System.out.println ("Long de "+enteroGrande);

        // Números reales
        // float, double
        //   4       8
        float edadReal = 98.7F;  // La F al final convierte la literarl a float
        // variable float = valor float
        double pesoReal = 123.45D;   // La D al final convierte (mantiene) la literal double

        // Caracter (char)
        char inicial = 'E';  // Las literales char van entre comillas simples (')
        System.out.println ("Letra:"+(inicial+3));

        // ¿ Y los String?
        String nombre = "UNAM";
        System.out.println (nombre);

        // ??
        System.out.println (12.3 + 100);
        //                 double   int
        //                 double   double

        double numero = 1.5 * 2;
        System.out.println (numero=789);
        numero = edad = 78;
        //numero = algo
        //          edad = 78
        System.out.println (numero);

        int calificacion = 10;
        System.out.println ("Calificación de " + calificacion);

        {  // Definición de un bloque interno
            int asistencias = 8;
            System.out.println ("Asistencias=" + asistencias);

        }




    }
}
