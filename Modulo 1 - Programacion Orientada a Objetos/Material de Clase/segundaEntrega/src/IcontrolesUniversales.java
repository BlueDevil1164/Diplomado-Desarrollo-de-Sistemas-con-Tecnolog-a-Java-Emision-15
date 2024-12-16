public interface IcontrolesUniversales {
    public static final int VOLUMENMAXIMO=100;
    public static final int VOLUMENMINIMO = 0;

    // Definición de métodos abstractos
    public abstract void subeVolumen();
    public abstract void bajaVolumen();
    public abstract boolean enciende();

    // Métodos default (sí tienen cuerpo estos métodos)
    default void imprimeStatus(){
        // El cuerpo del método
        System.out.println("Muestro el estatus ");
    }
}
