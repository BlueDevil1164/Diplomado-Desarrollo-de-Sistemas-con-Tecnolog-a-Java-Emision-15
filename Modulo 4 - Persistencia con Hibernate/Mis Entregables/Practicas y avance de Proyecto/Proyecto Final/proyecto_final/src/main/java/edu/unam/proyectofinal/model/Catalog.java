package edu.unam.proyectofinal.model;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import java.io.Serializable;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Catalog<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;
    protected Integer id;
    protected String cveLaptop;
    protected String descripcion;

    abstract Integer getId();

    public void setId(Integer id) {
        this.id = id;
    }

    abstract String getCveLaptop();

    public void setCveLaptop(String cveLaptop) {
        this.cveLaptop = cveLaptop;
    }

    abstract String getDescripcion();

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}