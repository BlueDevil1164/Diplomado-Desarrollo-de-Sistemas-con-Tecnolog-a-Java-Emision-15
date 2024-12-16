/***
 ** Unidad 3 - Principios y Patrones de Diseño
 ** @Producto: {{Clase Pago}}
 ** @author: {{Noyola Nazario Alejandro}}
 ** @Fecha: {{20 de Junio 2024}}
 ***/
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Pedido implements EstadoPedido {
    private int numeroPedido;
    private Date fecha;
    private double total;
    private Carrito carrito;
    private boolean procesado;

    // Constructor de los pedidos
    public Pedido(int numeroPedido, Date fecha, Carrito carrito) {
        this.numeroPedido = numeroPedido;
        this.fecha = fecha;
        this.carrito = carrito;
        this.procesado = false;
        this.total = 0.0; // Inicializamos el total en 0
    }

    //Implementación del método CalcularT que interactua con carrito
    public void calcularTotal() {
        double total = 0.0;
        List<String> productos = carrito.getProductos();

        for (String producto : productos) {
            double precio = carrito.getPrecioProducto(producto);
            total += precio;
        }

        this.total = total;
    }


    // Método procesar() de la interfaz EstadoPedido
    @Override
    public void procesar() {
        if (!procesado) {
            System.out.println("Procesando la orden: " + carrito);
            procesado = true;
        } else {
            System.out.println("La orden ya ha sido procesada: " + carrito);
        }
    }

    // Método cancelarPedido() de la interfaz EstadoPedido
    @Override
    public void cancelarPedido() {
        if (procesado) {
            System.out.println("No se puede cancelar la orden ya procesada: " + carrito);
        } else {
            System.out.println("Cancelando la orden: " + carrito);
        }
    }

}
