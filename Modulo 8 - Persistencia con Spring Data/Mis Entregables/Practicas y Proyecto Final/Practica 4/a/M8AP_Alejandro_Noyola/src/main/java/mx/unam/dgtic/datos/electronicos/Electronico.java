package mx.unam.dgtic.datos.electronicos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name= "Electronico.buscarTodosConMarcas",
                query ="SELECT DISTINCT a FROM Electronico a JOIN FETCH a.marcas")
})
@Table(name = "Electronicos")
public class Electronico {

    @Id
    private String idElectronico;
    private String nombreElectronico;
    private Double precio;
    private Integer existencias;
    private Long codigoDeBarras;
    private Double precioDeVenta;
    private Double costoDeProduccion;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "electronico") // Relación con Marca
    private List<Marca> marcas = new ArrayList<>();


    public Electronico() {
    }

    @ManyToMany
    @JoinTable(
            name = "Electronicos_Proveedores",
            joinColumns = @JoinColumn(name = "idElectronico"),
            inverseJoinColumns = @JoinColumn(name = "id_proveedor")
    )
    private Collection<Proveedor> proveedores;

    public Electronico(String idElectronico, String nombreElectronico, Double precio, Integer existencias, Long codigoDeBarras, Double precioDeVenta, Double costoDeProduccion) {
        this.idElectronico = idElectronico;
        this.nombreElectronico = nombreElectronico;
        this.precio = precio;
        this.existencias = existencias;
        this.codigoDeBarras = codigoDeBarras;
        this.precioDeVenta = precioDeVenta;
        this.costoDeProduccion = costoDeProduccion;
    }

    public String getIdElectronico() {
        return idElectronico;
    }

    public void setIdElectronico(String idElectronico) {
        this.idElectronico = idElectronico;
    }

    public String getNombreElectronico() {
        return nombreElectronico;
    }

    public void setNombreElectronico(String nombreElectronico) {
        this.nombreElectronico = nombreElectronico;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public Long getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(Long codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public Double getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(Double precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public Double getCostoDeProduccion() {
        return costoDeProduccion;
    }

    public void setCostoDeProduccion(Double costoDeProduccion) {
        this.costoDeProduccion = costoDeProduccion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public Collection<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(Collection<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public void addProveedor(Proveedor proveedor) {
        if (!proveedores.contains(proveedor)) {
            proveedores.add(proveedor);
            proveedor.addElectronico(this);
        }
    }

    public void removeProveedor(Proveedor proveedor) {
        if (proveedores.contains(proveedor)) {
            proveedores.remove(proveedor);
            proveedor.removeElectronico(this);
        }
    }


    @Override
    public String toString() {
        String categoriaStr = (getCategoria() != null) ? getCategoria().getCategoria() : "null";
        return "Electronico{" +
                "idElectronico=" + idElectronico +
                ", nombreElectronico='" + nombreElectronico + '\'' +
                ", precio=" + precio +
                ", existencias=" + existencias +
                ", codigoDeBarras=" + codigoDeBarras +
                ", precioDeVenta=" + precioDeVenta +
                ", costoDeProduccion=" + costoDeProduccion +
                ", categoria=" + categoriaStr +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronico that = (Electronico) o;
        return Objects.equals(idElectronico, that.idElectronico);
    }


    @Override
    public int hashCode() {
        return Objects.hash(idElectronico);
    }
}
