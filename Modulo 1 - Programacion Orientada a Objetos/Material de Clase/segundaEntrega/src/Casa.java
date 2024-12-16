import java.util.Objects;

public class Casa {
    // Atributos
    // superficie de terreno, superficie de construcción, pisos, precio, antigüedad, color



    public int superficieTerreno;
    public int superficieConstruccion;
    public double precio;
    public String color="Rojo";  // Se puede, aquí, asignar un valor inicial
    public boolean comprado;  // Los boolean se inicializan por default con false

    // Métodos
    public Casa (){}

    // Vender, Rentar, Agregar, Dar de baja, Cambiar propietario, Pintar

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Casa casa)) return false;

        return superficieTerreno == casa.superficieTerreno && superficieConstruccion == casa.superficieConstruccion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(superficieTerreno, superficieConstruccion);
    }
}
