package mx.unam.dgtic.datos;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Permitir autogeneración del ID
    @Column(name = "idVendedor")
    private Integer idVendedor;
    private String nombreVendedor;
    private String apellidoVendedor;
    private Integer edad;
    private String genero;
    private String correo;
    private String usuarioVendedor = "Invitado";  // DEFAULT 'Invitado'
    private String contrasena;

    public Vendedor() {
    }

    public Vendedor(Integer idVendedor) {

        this.idVendedor = idVendedor;
    }

    public Vendedor(String nombreVendedor, String apellidoVendedor, Integer edad, String genero, String correo, String usuarioVendedor, String contrasena) {
        this.nombreVendedor = nombreVendedor;
        this.apellidoVendedor = apellidoVendedor;
        this.edad = edad;
        this.genero = genero;
        this.correo = correo;
        this.usuarioVendedor = usuarioVendedor;
        this.contrasena = contrasena;
    }


    @Override
    public String toString() {
        return "Vendedor{" +
                "idVendedor=" + idVendedor +
                ", nombreVendedor='" + nombreVendedor + '\'' +
                ", apellidoVendedor='" + apellidoVendedor + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", correo='" + correo + '\'' +
                ", usuarioVendedor='" + usuarioVendedor + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return idVendedor.equals(vendedor.idVendedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVendedor);
    }
}
