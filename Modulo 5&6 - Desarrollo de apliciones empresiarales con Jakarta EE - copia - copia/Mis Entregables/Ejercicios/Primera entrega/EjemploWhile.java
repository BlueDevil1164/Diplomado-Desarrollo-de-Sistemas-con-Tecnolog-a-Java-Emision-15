import javax.swing.*;

public class EjemploWhile {
    public static void main(String[] args) {
        // Ejemplo de ciclos while
        System.out.println("Ejemplo de ciclos while:");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Imprime un ciclo de Ola hasta que el contador sea menor a 5");
        int contador = 0;
        while (contador < 5) {
            // El ciclo a repetir
            System.out.println("Ola");
            contador++;
        }
        System.out.println("----------------------------------------------------------------");
        // Reiniciar el contador para el siguiente ciclo
        System.out.println("Reiniciamos el contador para el siguiente ciclo.\nEste se inicializa cuando el contador es igual a 5");
        contador = 5; // Asegúrate de que el contador se actualiza correctamente
        while (contador < 15) {
            System.out.println(contador++);
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("Finalizamos el contador con este mensaje de despedida");
        System.out.println("Sayonara");

        System.out.println("----------------------------------------------------------------");
        System.out.println("Se reinicia el contador con un valor igual a 100");
        System.out.println("Y este incrementa hasta que se su valor es igual a 120");
        // Reiniciar el contador para el siguiente ciclo
        contador = 100;
        while (contador <= 120) {
            System.out.println(contador++);
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("Reiniciamos el contador una ultima vez, esta vez con el valor 0");
        System.out.println("Mediante el uso de do while metemos en un ciclo al contador y lo forzamos a terminar caundo este sea igual a 20");
        // Reiniciar el contador para el siguiente ciclo
        contador = 0; // O cualquier valor con el que quieras comenzar
        do {
            System.out.println(contador++);
        } while (contador <= 20);

        System.out.println("----------------------------------------------------------------");
        System.out.println("Finalizamos el programa con este mensaje de despedida");
        System.out.println("Sayonara");
        System.out.println("----------------------------------------------------------------");
    }

}
