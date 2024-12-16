package mx.unam.dgtic.datos;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "electronicos")
public class Electronicos {
    @Id
    @Column(name = "idElectronico")
    private Integer idElectronico;
    private String nombreElectronico;
    private Double precio;
    private Integer existencias;
    private Long codigoDeBarras;
    private Double precioDeVenta;
    private Double costoDeProduccion;

    public Electronicos() {
    }

    public Electronicos(Integer idElectronico) {
        this.idElectronico = idElectronico;
    }

    public Electronicos(Integer idElectronico, String nombreElectronico, Double precio, Integer existencias, Long codigoDeBarras, Double precioDeVenta, Double costoDeProduccion) {
        this.idElectronico = idElectronico;
        this.nombreElectronico = nombreElectronico;
        this.precio = precio;
        this.existencias = existencias;
        this.codigoDeBarras = codigoDeBarras;
        this.precioDeVenta = precioDeVenta;
        this.costoDeProduccion = costoDeProduccion;
    }

    public Integer getIdElectronico() {
        return idElectronico;
    }

    public void setIdElectronico(Integer idElectronico) {
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

    @Override
    public String toString() {
        return "Electronicos{" +
                "idElectronico=" + idElectronico +
                ", nombreElectronico='" + nombreElectronico + '\'' +
                ", precio=" + precio +
                ", existencias=" + existencias +
                ", codigoDeBarras=" + codigoDeBarras +
                ", precioDeVenta=" + precioDeVenta +
                ", costoDeProduccion=" + costoDeProduccion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronicos electronicos = (Electronicos) o;
        return idElectronico.equals(electronicos.idElectronico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idElectronico);
    }
}
