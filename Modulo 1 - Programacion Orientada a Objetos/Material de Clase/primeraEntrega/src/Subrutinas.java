/* Ejemplo de subrutinas
- Funciones
- Procedimientos

Las subrutinas se tienen que definir para usarlasr
 */
public class Subrutinas {
    // Definición de SUbrutinas
    /// Procedimientos
    public static void saluda (){
        System.out.println ("Hola");
    }
    public static void saludaNveces (int nVeces, String nombre){
        for (int i=0;i<nVeces;i++)
            System.out.println ("¡ HOLA !"+ nombre);
    }
    public static void saludaNveces (int nVeces){
        saludaNveces (nVeces, "Gisela");
    }
    /// Funciones

    public static void main (String[] args){
        // Ejemplo de LLAMADO de subrutinas
        saluda();
        System.out.println ("Llamaremos nuevamente a la subrutina...");
        saluda();
        saludaNveces(5,"Juan");
        saludaNveces (2);
        saludaNveces ('E');  // ?????????

        // Llamado de funciones
        System.out.println (suma(8,2));
        double variable;
        variable = suma (9,-2);
        // variable = suma ('8', '2');
        variable = suma (8.0, 2);
        variable = suma (8.0, '2');
        // variable = suma ('E','O');
        System.out.println (variable);
        System.out.println (suma('A','B'));
        System.out.println ("Bye");
    }

    public static double suma (int numero1, int numero2){
        double resultado=0;
        resultado = numero1 + numero2;
        return resultado;
    }

    public static double suma (double numero1, double numero2){
        double resultado=0;
        resultado = numero1 + numero2;
        return resultado;
    }

    public static String suma (char numero1, char numero2){
        String resultado;
        resultado = ""+numero1 + numero2;
        return resultado;
    }
}
