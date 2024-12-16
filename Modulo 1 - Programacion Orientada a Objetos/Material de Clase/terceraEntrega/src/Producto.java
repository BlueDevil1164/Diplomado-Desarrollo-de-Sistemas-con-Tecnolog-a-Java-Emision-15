import java.util.Objects;

public class Producto implements Comparable {
    public String nombre;
    public double precio;

    public Producto() {
        this.nombre = "Desconocido";
        this.precio = 0;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " $" + precio ;
    }

    @Override
    public int compareTo(Object otro) {
        // compareTo regresa 3 posibles valores:
        //  0 Si this y otro son iguales
        //  1 Si this > otro
        // -1 Si this < otro
        int regreso = 0;
        if (this != otro)
            if (this.getClass() == otro.getClass()) {
                Producto otroProducto = (Producto) otro;
                regreso = this.nombre.compareTo(otroProducto.nombre);
                if (regreso == 0)  // Solo cuando los nombres fueron iguales
                    if (this.precio > otroProducto.precio)
                        regreso = 1;
                    else
                        if (this.precio < otroProducto.precio)
                            regreso = -1;
            }

        return regreso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}  // Fin del class
