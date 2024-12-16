package edu.unam.proyectofinal.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "laptop")
@NamedQueries(
        {@NamedQuery(name = "laptopsAll", query = "FROM Laptop"),
                @NamedQuery(name = "laptopById", query = "SELECT c FROM Laptop c WHERE c.id = :id"),
                @NamedQuery(name ="laptopsByTipo", query = "SELECT c FROM Laptop c WHERE c.laptopType.id = :idTipoLaptop")
        })
public class Laptop {
    private Integer id;
    private String modelo;
    private Integer pantalla;
    private String marca;
    private String color;
    private Integer ram;

    private LaptopType laptopType;
    private Set<MeansLaptops> meansLaptops;

    @Id
    @Column(name = "laptop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "modelo", length = 50)
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Column(name = "pantalla")
    public Integer getPantalla() {
        return pantalla;
    }

    public void setPantalla(Integer pantalla) {
        this.pantalla = pantalla;
    }

    @Column(name = "marca", length = 50)
    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Column(name = "color", length = 50)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "ram")
    public Integer getRam(){
        return ram;
    }

    public void setRam(Integer ram){
        this.ram = ram;
    }

    @ManyToOne(targetEntity = LaptopType.class, optional = false, fetch = FetchType.LAZY) //indica el tipo de clase
    @JoinColumn(name = "laptop_type_id", nullable = false)//indicar la columna de la relacion de B
    @Fetch(FetchMode.JOIN) //join al navegar en la propiedad
    public LaptopType getLaptopType() {
        return laptopType;
    }

    public void setLaptopType(LaptopType laptopType) {
        this.laptopType = laptopType;
    }

    @OneToMany(mappedBy = "laptop", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    public Set<MeansLaptops> getMeansLaptops() {
        return meansLaptops;
    }

    public void setMeansLaptops(Set<MeansLaptops> meansLaptops) {
        this.meansLaptops = meansLaptops;
    }

    @Override
    public String toString() {
        return "Contacto [id=" + id + ", modelo=" + modelo + ", pantalla=" + pantalla + ", color=" + color
                + ", ram=" + ram + ", tipoLaptop=" + laptopType + ", laptopsMedios=" + meansLaptops
                + "]";
    }

}