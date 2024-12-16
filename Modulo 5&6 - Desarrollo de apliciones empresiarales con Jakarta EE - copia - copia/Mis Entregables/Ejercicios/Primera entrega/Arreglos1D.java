/*public class Arreglo {


    int numero = 1;
    String[] nombres = {"Enero", "Febrero", }
}
*/
public class Arreglos1D {
    public static void main(String[] args) {
        // Declaración e inicialización de un arreglo
        String[] Meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre", "SinNombre"};

        // Acceso y modificación de elementos
        Meses[12] = "Mes 13TH"; // Cambia el tercer elemento a 10

        // Imprimir todos los elementos usando un bucle for
        System.out.println("Elementos de un arreglo de Strings");
        for (int i = 0; i < Meses.length; i++) {
            System.out.println(Meses[i]);
        }

    }

}