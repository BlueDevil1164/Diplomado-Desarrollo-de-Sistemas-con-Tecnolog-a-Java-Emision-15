package dgtic.core.modelo;

import dgtic.core.modelo.excepciones.PrecioInvalido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Electronico {
    private Long id;
    private String nombre;
    private Integer precio;
    private Integer existencias;
    private String codigoDeBarras;
    private String color;
    private String marca;

    public Electronico(String nombre, Integer precio, Integer existencias, String codigoDeBarras, String color, String marca) {
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
        this.codigoDeBarras = codigoDeBarras;
        this.color = color;
        this.marca = marca;
    }


    public void setPrecio(Integer precio){
        if(precio < 0){
            throw new PrecioInvalido("Precio no valido, no puede ser menor a 0");

        } else {
            this.precio = precio;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Electronico electronico)) return false;
        return Objects.equals(id, electronico.id)
                && Objects.equals(nombre, electronico.nombre)
                && Objects.equals(precio, electronico.precio)
                && Objects.equals(existencias, electronico.existencias)
                && Objects.equals(codigoDeBarras, electronico.codigoDeBarras)
                && Objects.equals(color, electronico.color)
                && Objects.equals(marca, electronico.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio, existencias,codigoDeBarras, color, marca);
    }
}
