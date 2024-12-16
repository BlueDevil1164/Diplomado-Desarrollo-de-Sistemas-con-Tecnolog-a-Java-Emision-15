package edu.unam.proyectofinal.model;

import jakarta.persistence.*;

@Entity //definir la entidad
@Table(name = "laptop_type") //indicar el nombre de la tabla que representa
public class LaptopType extends Catalog<Integer> {
    private static final long serialVersionUID = 1L;
    protected Integer id;
    protected String cveLaptop;
    protected String descripcion;

    @Id //indicar que la propiedad es una llave
    @Column(name = "laptop_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //estrategia de manejo de llave
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
        return "TipoLaptop [id=" + id + ", cveLaptop=" + cveLaptop + ", descripcion=" + descripcion + ", hashCode()=" + hashCode()
                + "]";
    }
}