package edu.unam.proyectofinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "means_laptop")
public class MeansLaptops {
    private Integer id;
    private String value;
    private Laptop laptop;
    private CatalogLaptops catalogLaptops;

    @Id
    @Column(name = "means_laptop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "value", length = 300)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "laptop_id")
    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @ManyToOne(targetEntity = CatalogLaptops.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "catalogolaptops_id", nullable = false, referencedColumnName = "catalogolaptops_id")
    public CatalogLaptops getCatalogLaptops() {
        return catalogLaptops;
    }

    public void setCatalogLaptops(CatalogLaptops catalogLaptops) {
        this.catalogLaptops = catalogLaptops;
    }

    @Override
    public String toString() {
        return "LaptopMedio [id=" + id + ", valor=" + value + "]";
    }
}