/*
* Funciones
* Procedimientos


* Las subrutinas se tienen que definir para usarlas
*/
public class SubRutinas {
    // Definicion de Subrutinas
    /// Procedimientos
    public static  void saluda(){
        System.out.println("hola");
    }
    public static void saludaNveces (int nVeces){
        for(int i=0; i<nVeces; i++)
            System.out.println("¡ HOLA YO !");
    }

    public static void saludaNveces (int nVeces, String nombre){
        for(int i=0; i<nVeces; i++)
            System.out.println("¡ HOLA ! " + nombre);
    }
    public static void saludaNveces1 (int nVeces){
        for(int i=0; i<nVeces; i++)
            System.out.println(nVeces + "Nameless1");
    }

    /// Funciones

    public static void main (String[] args) {
        // Ejemplo de llamado de subrutinas
        System.out.println("*----------------------------------*");
        saluda();
        System.out.println("*----------------------------------*");
        System.out.println("Llamamos la subrutina...");
        saluda();
        System.out.println("*----------------------------------*");
        saludaNveces(7, "Nameless");
        System.out.println("*----------------------------------*");
        saludaNveces(2);
        System.out.println("*----------------------------------*");
        saludaNveces1('E');
        System.out.println("*----------------------------------*");
        System.out.println("Sayonara");


        System.out.println(suma(8, 2));
        double variable;
        variable = suma(9, -2);
        variable = suma('8', 2);
        variable = suma(8.0, '2');
        //variable = suma ('E', 'Q');
        System.out.println(variable);
        System.out.println(suma('A','B'));
        System.out.println("bye");

    }
    public static double suma (int numero1, int numero2){
        double resultado = 0;
        resultado = numero1 + numero2;
        return resultado;

    }

    public static double suma (double numero1, double numero2){
        double resultado = 0;
        resultado = numero1 + numero2;
        return resultado;

    }

    public static double suma (char numero1, char numero2) {
        double resultado = 0;
        resultado = numero1 + numero2;
        return resultado;

    }
}
