package dgtic.core.modelo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Data
public class Estudiante {
    private String matricula;
    private String nombre;
    private Integer edad;
    private List<Materia> materias = new ArrayList<>();

    public Estudiante(String matricula, String nombre, Integer edad) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
    }

    public void setMaterias(Materia... materias) {
        this.materias.addAll(Arrays.asList(materias));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(matricula, that.matricula) && Objects.equals(nombre, that.nombre) && Objects.equals(edad, that.edad) && Objects.equals(materias, that.materias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, nombre, edad, materias);
    }
}
