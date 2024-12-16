package mx.unam.dgtic.datos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Materias")


@NamedQuery(
        name = "Materia.buscarPorMateria",
        query = "SELECT m FROM Materia m WHERE m.materia = ?1"
)
@NamedQuery(
        name = "Materia.buscarPorMateriaYCreditos",
        query = "SELECT m FROM Materia m WHERE m.materia = ?1 AND m.creditos = ?2"
)

/*
@NamedQuery(
        name = "Materia.buscarPorCurpContenga",
        query = "SELECT a FROM Alumno a WHERE a.curp LIKE CONCAT('%', :substring, '%')"
)



@NamedQuery(
        name = "Materia.contarPorCurpContenga",
        query = "SELECT COUNT(a) FROM Alumno a WHERE a.curp LIKE CONCAT('%', :substring, '%')"
)

@NamedQuery(
        name = "Materia.buscarPorEstadoCurp",
        query = "SELECT a FROM Alumno a WHERE SUBSTRING(a.curp, 12, 2) = :codigoEstado"
)

@NamedQuery(
        name = "Materia.contarPorEstadoCurp",
        query = "SELECT COUNT(a) FROM Alumno a WHERE SUBSTRING(a.curp, 12, 2) = :codigoEstado"
)
*/

@NamedQuery(
        name = "Materia.buscarAltos",
        query = "SELECT m FROM Materia m WHERE m.horas >= 40"
)

@NamedQuery(
        name = "Materia.buscarAltosConHoras",
        query = "SELECT m FROM Materia m WHERE m.horas >= :horas"
)

@NamedQuery(
        name = "Materia.searchByHorasNotBetweenOrderByHoras",
        query = "SELECT m FROM Materia m " +
                "WHERE m.horas NOT BETWEEN :horasini AND :horasfin " +
                "ORDER BY m.horas ASC"
)

@NamedQuery(
        name = "Materia.searchByCreditosNotBetweenOrderByCreditos",
        query = "SELECT m FROM Materia m " +
                "WHERE m.creditos NOT BETWEEN :creditosini AND :creditosfin " +
                "ORDER BY m.creditos ASC"
)

@NamedNativeQuery(
        name = "Materia.buscarAltosMayorPromedio",
        query = "SELECT * FROM Materias " +
                "WHERE horas >= (SELECT AVG(horas) promedio FROM Materia) " +
                "ORDER BY horas DESC",
        resultClass = Materia.class
)


public class Materia {

    @Id
    private String clave_materia;

    private String materia;

    private Integer creditos;

    private Integer horas;

    public Materia() {
    }

    public Materia(String clave_materia) {
        this.clave_materia = clave_materia;
    }

    public Materia(String clave_materia, String materia, Integer creditos, Integer horas) {
        this.clave_materia = clave_materia;
        this.materia = materia;
        this.creditos = creditos;
        this.horas = horas;
    }

    public String getClave_materia() {
        return clave_materia;
    }

    public void setClave_materia(String clave_materia) {
        this.clave_materia = clave_materia;
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
                "clave_materia='" + clave_materia + '\'' +
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
        return clave_materia.equals(materia.clave_materia);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(clave_materia);
    }

}
