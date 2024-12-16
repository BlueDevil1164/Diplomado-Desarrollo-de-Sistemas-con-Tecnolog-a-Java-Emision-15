package edu.unam.mapeo2;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * La clase TableTest representa un objeto de prueba con id, nombre y apellido.
 */
@Entity
@Table(name = "table_test")
public class TableTest {
    private Integer id;
    private String name;
    private String lastName;

    @Id
    @Column(name = "table_test")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "last_name", length = 200)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return "Contacto [id=" + id + ", nombre=" + name + ", apellidos=" + lastName + "]";
    }
}

