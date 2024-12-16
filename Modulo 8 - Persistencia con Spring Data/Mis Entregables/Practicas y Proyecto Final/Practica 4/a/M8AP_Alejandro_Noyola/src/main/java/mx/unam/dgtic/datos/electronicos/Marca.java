package mx.unam.dgtic.datos.electronicos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Marca")
public class Marca {

    @Id
    private Integer id;
    private String marca;
    private Integer starRate;

    @ManyToOne
    @JoinColumn(name = "electronicos_matricula")
    private Electronico electronico;

    public Marca() {
    }

    public Marca(Integer id) {
        this.id = id;
    }

    public Marca(Integer id, String marca, Integer starRate) {
        this.id = id;
        this.marca = marca;
        this.starRate = starRate;
    }

    public Marca(Integer id, String marca, Integer starRate, Electronico electronico) {
        this.id = id;
        this.marca = marca;
        this.starRate = starRate;
        this.electronico = electronico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getStarRate() {
        return starRate;
    }

    public void setStarRate(Integer starRate) {
        this.starRate = starRate;
    }

    public Electronico getElectronico() {
        return electronico;
    }

    public void setElectronico(Electronico electronico) {
        this.electronico = electronico;
    }


    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", starRate=" + starRate +
                ", electronico=" + electronico +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca that = (Marca) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
