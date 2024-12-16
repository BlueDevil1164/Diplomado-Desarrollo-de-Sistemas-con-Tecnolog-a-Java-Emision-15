/*
 * Noyola Nazario Alejandro
 * Diplomado de desarrollo de Sistemas con Tecnología Java Emisión 15
 * Interfaz IcontrolesUniversales
 * */

public interface IcontrolesUniversales {

    // Definicion de atributos, deben ser estaticos.
    public static final int VOLUMEN_MAXIMO = 100;
    public static final int VOLUMEN_MINIMO = 0;

    // Definición de métodos abstractos
    public abstract void subeVolumen();

    public abstract void bajaVolumen();

    public abstract boolean enciende();

    // NOTA: A partir de la versión 9 de Java, se puede definir métodos en interfaces (métodos default).
    // Métodos default
    default void imprimeStatus() {
        System.out.println("Muestro el estatus.");
    }

}