package dgtic.core.modelo;

import dgtic.core.modelo.exeptions.CreditosMenores;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
    private Long id;
    private String nombre;
    private Integer creditos;

    public Materia(String nombre, Integer creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public void setCreditos(Integer creditos) {
        if(creditos < 0)
            throw new CreditosMenores("Credino valido, negativo.");
        this.creditos = creditos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return Objects.equals(id, materia.id) && Objects.equals(nombre, materia.nombre) && Objects.equals(creditos, materia.creditos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, creditos);
    }
}
