package mx.unam.dgtic.datos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "laptops")
public class Laptops {
    @Id
    @Column(name = "idLaptop")
    private Integer idLaptop;
    private String modelo;
    private Double pantalla;
    private String marca;
    private String color;
    private Double ram;

    public Laptops() {
    }

    public Laptops(Integer idLaptop) {

        this.idLaptop = idLaptop;
    }

    public Laptops(Integer idLaptop, String modelo, Double pantalla, String marca, String color, Double ram) {
        this.idLaptop = idLaptop;
        this.modelo = modelo;
        this.pantalla = pantalla;
        this.marca = marca;
        this.color = color;
        this.ram = ram;
    }

    public Integer getIdLaptop() {
        return idLaptop;
    }

    public void setIdLaptop(Integer idLaptop) {
        this.idLaptop = idLaptop;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPantalla() {
        return pantalla;
    }

    public void setPantalla(Double pantalla) {
        this.pantalla = pantalla;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getRam() {
        return ram;
    }

    public void setRam(Double ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Laptops{" +
                "idLaptop=" + idLaptop +
                ", modelo='" + modelo + '\'' +
                ", pantalla=" + pantalla +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", ram=" + ram +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptops laptops = (Laptops) o;
        return laptops.equals(laptops.idLaptop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLaptop);
    }



}
