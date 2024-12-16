public class EjemploWhile {
    public static void main (String[] args){
        // Ejemplo de ciclos while
        int contador = 0;
        while (contador < 5){
            // Lo que se va a repetir
            System.out.println ("Hola");
            contador++;
        }

        contador=100;
        while (contador <11){
           System.out.println (contador++);
        }

        // do-while
        do {
            System.out.println (contador++);

        } while (contador <=10);

        System.out.println ("Adiós");
    }
}
