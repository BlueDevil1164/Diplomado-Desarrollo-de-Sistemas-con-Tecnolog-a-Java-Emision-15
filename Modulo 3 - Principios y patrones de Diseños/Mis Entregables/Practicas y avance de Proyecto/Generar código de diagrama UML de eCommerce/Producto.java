/***
 ** Unidad 3 - Principios y Patrones de Diseño
 ** @Producto: {{Clase Producto}}
 ** @author: {{Noyola Nazario Alejandro}}
 ** @Fecha: {{20 de Junio 2024}}
 ***/

//Declaracion de atributos de un producto en venta
public class Producto {
    private String nombre;
    private Double precio;
    private String descripcion;
    private String detalles;
    //private String precio;


    //Getters de Precio y Detalles
    public String getDetalles() {
        return this.detalles;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
