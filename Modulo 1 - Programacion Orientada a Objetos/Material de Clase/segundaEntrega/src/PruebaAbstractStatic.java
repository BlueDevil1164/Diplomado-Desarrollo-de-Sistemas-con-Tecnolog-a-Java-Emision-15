import java.util.Scanner;

public class PruebaAbstractStatic {
    public static void main(String[] args) {
        System.out.println ("Ejemplo de abstract y de static");// out es un miembro estático de System
        Scanner x = new Scanner(System.in);  // in es un miembro estático de System

        // abstract
        // ClaseAbstracta objeto = new ClaseAbstracta();
        // Una clase que es abstract no la puedo instanciar

        SubClaseDeUnaAbstracta objeto2 = new SubClaseDeUnaAbstracta ();
        objeto2.suma (3);
        objeto2.resta (6);

        // static
        ClaseConEstaticos objeto3 = new ClaseConEstaticos();
        objeto3.numero = 55;

        ClaseConEstaticos objeto4 = new ClaseConEstaticos();
        objeto4.numero = 44;

        System.out.println (objeto3.numero);
        System.out.println (objeto4.numero);

        // Uso de elementos estáticos
        System.out.println ("Original:"+ClaseConEstaticos.real);
        ClaseConEstaticos.real = -16;
        System.out.println ("Atributo 'del objeto':" + objeto3.real);
        System.out.println ("Modificado"+ClaseConEstaticos.real);
        objeto4.real = 123.45;
        System.out.println ("Atributo 'del objeto':" + objeto3.real);
        System.out.println ("Modificado"+ClaseConEstaticos.real);

        // Métodos estáticos
        objeto3.metodoNoEstatico();   // Métodos NO estáticos
        objeto4.metodoNoEstatico();

        objeto3.metodoEstatico();  // Método estático por medio de una instancia
        ClaseConEstaticos.metodoEstatico();  // Método estático por medio de la Clase
    }
}
