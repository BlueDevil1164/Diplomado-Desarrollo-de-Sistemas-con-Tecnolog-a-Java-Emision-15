package edu.unam.proyectofinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogoLaptops")
public class CatalogLaptops extends Catalog<Integer> {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String cveLaptop;
    private String descripcion;

    @Id
    @Column(name = "catalogoLaptops_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "cveLaptop", length = 50, nullable = false)
    public String getCveLaptop() {
        return cveLaptop;
    }

    public void setCveLaptop(String cveLaptop) {
        this.cveLaptop = cveLaptop;
    }

    @Column(name = "descripcion", length = 50, nullable = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "CatalogoLaptop [id=" + id + ", cveLaptop=" + cveLaptop + ", descripcion=" + descripcion + "]";
    }
}