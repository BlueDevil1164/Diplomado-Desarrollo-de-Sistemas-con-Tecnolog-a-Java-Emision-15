package mx.unam.dgtic.datos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Objects;

@Document(collection = "materias")
public class Materia {
    @Id
    private String id;
    @Field("clave_mat")
    private String claveMateria;
    private Double creditos;

    private Detalles detalles;
    private List<Tema> tema;

    public Materia() {

    }

    public Materia(String claveMateria, Double creditos) {
        this.claveMateria = claveMateria;
        this.creditos = creditos;
    }

    public Materia(String claveMateria) {
        this.claveMateria = claveMateria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClaveMateria() {
        return claveMateria;
    }

    public void setClaveMateria(String claveMateria) {
        this.claveMateria = claveMateria;
    }

    public Double getCreditos() {
        return creditos;
    }

    public void setCreditos(Double creditos) {
        this.creditos = creditos;
    }

    public List<Tema> getTema() {
        return tema;
    }

    public void setTema(List<Tema> tema) {
        this.tema = tema;
    }

    public Detalles getDetalles() {
        return detalles;
    }

    public void setDetalles(Detalles detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "id='" + id + '\'' +
                ", clave='" + claveMateria + '\'' +
                ", creditos=" + creditos +
                ", temas=" + tema +
                ", detalles=" + detalles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return Objects.equals(id, materia.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
