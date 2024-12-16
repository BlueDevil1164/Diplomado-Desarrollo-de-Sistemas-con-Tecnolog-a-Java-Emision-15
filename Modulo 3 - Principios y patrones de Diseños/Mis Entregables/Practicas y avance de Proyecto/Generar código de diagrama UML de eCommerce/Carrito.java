import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/***
 ** Unidad 3 - Principios y Patrones de Diseño
 ** @Producto: {{Clase Carrito}}
 ** @author: {{Noyola Nazario Alejandro}}
 ** @Fecha: {{20 de Junio 2024}}
 ***/
public class Carrito  {

    List<String> productos = new ArrayList<>();

    public List<String> getProductos() {
        return productos;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public String getProductoUsuario() {
        return productoUsuario;
    }

    Scanner scanner = new Scanner(System.in);
    String productoUsuario = scanner.nextLine();

    public void agregarProducto() {

        System.out.println("Escriba el producto que quiere agregar");
        productos.add(productoUsuario);
        System.out.println("Producto agregado");

    }

    public void quitarProducto() {

        System.out.println("Escriba el producto que quiere quitar");
        productos.remove(productoUsuario);
        System.out.println("Producto eliminado");

    }
    //metodo para vaciar el carrito
    public void vaciarCarrito() {

        productos.clear();
        System.out.println("Carrito vacio");

    }

    // Método para obtener el precio de un producto necesario para que
    public double getPrecioProducto(String producto) {
        if (producto.equals("producto1")) {
            return 10.0; // Precio del producto1
        } else if (producto.equals("producto2")) {
            return 15.0; // Precio del producto2
        }
        return 0.0; // En caso de que el producto no tenga precio definido
    }

    // Método para mostrar los productos en el carrito
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío");
        } else {
            System.out.println("Productos en el carrito:");
            for (String producto : productos) {
                System.out.println("- " + producto);
            }
        }
    }


}

