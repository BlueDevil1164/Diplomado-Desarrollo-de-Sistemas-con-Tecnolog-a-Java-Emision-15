package mx.unam.dgtic.datos.electronicos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "Proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    protected int id;
    protected String nombreProveedor;

    @ManyToMany(mappedBy = "proveedores")
    private Collection<Electronico> electronicos;

    public Proveedor(){electronicos = new ArrayList<Electronico>();}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getProveedor() {return nombreProveedor;}

    public void setProveedor(String proveedor) {this.nombreProveedor = proveedor;}

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public Collection<Electronico> getElectronicos() {
        return electronicos;
    }

    public void setElectronicos(Collection<Electronico> electronicos) {this.electronicos = electronicos;}

    public void addElectronico(Electronico electronico) {
        if (!getElectronicos().contains(electronico)) {
            getElectronicos().add(electronico);
        }
        if (!electronico.getProveedores().contains(this)) {
            electronico.getProveedores().add(this);
        }
    }

    public void removeElectronico(Electronico electronico) {
        if (electronicos.contains(electronico)) {
            electronicos.remove(electronico);
            electronico.getProveedores().remove(this);
        }
    }

    public String toString() {
        return "Proveedor id: " + getId() + ", proveedor: " + getProveedor() +
                " con electronicos " + getElectronicos().size() + " electronicos";
    }


}