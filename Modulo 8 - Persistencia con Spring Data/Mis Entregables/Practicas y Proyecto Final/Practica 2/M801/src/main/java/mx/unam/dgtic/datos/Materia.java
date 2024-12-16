package mx.unam.dgtic.datos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "Materias")
public class Materia {
    @Id
    @Column(name="clave_materia")
    private String claveMateria;
    private String materia;
    private Integer creditos;
    private Integer horas;

    public Materia() {
    }

    public Materia(String claveMateria) {
        this.claveMateria = claveMateria;
    }

    public Materia(String claveMateria, String materia, Integer creditos, Integer horas) {
        this.claveMateria = claveMateria;
        this.materia = materia;
        this.creditos = creditos;
        this.horas = horas;
    }

    public String getClaveMateria() {
        return claveMateria;
    }

    public void setClaveMateria(String claveMateria) {
        this.claveMateria = claveMateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "claveMateria='" + claveMateria + '\'' +
                ", materia='" + materia + '\'' +
                ", creditos=" + creditos +
                ", horas=" + horas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return claveMateria.equals(materia.claveMateria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(claveMateria);
    }
}
