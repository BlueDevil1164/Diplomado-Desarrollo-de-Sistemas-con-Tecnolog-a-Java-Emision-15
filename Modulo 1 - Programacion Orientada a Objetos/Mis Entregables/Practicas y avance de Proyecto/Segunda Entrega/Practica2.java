/*
 * Noyola Nazario Alejandro
 * Diplomado de desrrollo de Tecnogias con java
 * */
import java.util.Scanner;
public class Practica2 extends Producto {
    // Definicion de Subrutinas
    /// Procedimientos

    private double IVA;
    public static  void Candidatura(){
        //Nuestro menu
        System.out.println(" 1: Cuaderno");
        System.out.println(" 3: Pluma");
        System.out.println(" 5: Regla");
        System.out.println(" 0: Terminar Compras");
    }
    public static void main (String[] args) {
        int productos = 6;

        Producto cuaderno = new Producto();

        Producto pluma = new Producto();

        Producto regla = new Producto();

        int Compras = 0;
        int ComprasCuaderno = 0;
        int ComprasPluma = 0;
        int ComprasRegla= 0;

        double total = 0.0;
        double subtotal = 0.0;

        double iva = 0.0;

        double compra = 0.0;

        do {
            //Nuestro menu
            System.out.println("------------------------------------------------------");
            System.out.println("Las opciones de la Tienda es la siguiente: Por favor solo elige los codigos de los productos presentes");
            System.out.println(" 1: Cuaderno");
            System.out.println(" 3: Pluma");
            System.out.println(" 5: Regla");
            System.out.println(" 0: Terminar Compras");
            System.out.print("¿Que vas a comprar? Escribe su codigo.\n");
            System.out.println("------------------------------------------------------");

            System.out.println("El codigo de tu producto es: ");
            Scanner teclado = new Scanner(System.in);

            //Uso de switch como Menu
            productos = teclado.nextInt();
            //Mensajes por cada opcion
            switch (productos) {

                case 1:
                    System.out.println(" Compraste un Cuaderno ");
                    subtotal = cuaderno.getPrecio() + subtotal;
                    Compras++;
                    ComprasCuaderno++;
                    System.out.println("Subtotal: = " + subtotal + "Productos Comprados" + Compras);
                    System.out.println("Productos Comprados "  + Compras);
                    System.out.println("Cuadernos Comprados " + ComprasCuaderno);

                    break;
                case 3:
                    System.out.println(" Compraste una Pluma ");
                    pluma.setPrecio(13.00);
                    subtotal = pluma.getPrecio() + subtotal;
                    Compras++;
                    ComprasPluma++;
                    System.out.println("Subtotal: = " + subtotal);
                    System.out.println("Productos Comprados " + Compras);
                    System.out.println("Plumas Compradas " + ComprasPluma);
                    break;
                case 5:
                    System.out.println(" Compraste un Regla ");
                    regla.setPrecio(16.50);
                    subtotal = regla.getPrecio() + subtotal;
                    Compras++;
                    ComprasRegla++;
                    System.out.println("Subtotal: = " + subtotal );
                    System.out.println("Productos Comprados " + Compras);
                    System.out.println("Reglas Compradas " + ComprasRegla);
                    break;
                default:
                    System.out.println("Compra finalizada");
                    System.out.println("Es todo por hoy gracias");
                    break;
            }

        } while (productos !=0);

        if (subtotal > 0) {

            iva = (subtotal * .16);

            total =subtotal + iva;

            System.out.println("El total de cuadernos comprados:" + ComprasCuaderno);
            System.out.println("El total de plumas comprados:  " + ComprasPluma);
            System.out.println("El total de reglas compradas: " + ComprasRegla);

            System.out.println("IVA: $" + iva);

            System.out.println("Subtotal: $" + subtotal);

            System.out.println("Total: $"+ total );

            System.out.println("------------------------------------------------------");
        } else {

            System.out.println("No hay compra, no compraste nada. :(");
            System.out.println("------------------------------------------------------");
        }
    }
}
