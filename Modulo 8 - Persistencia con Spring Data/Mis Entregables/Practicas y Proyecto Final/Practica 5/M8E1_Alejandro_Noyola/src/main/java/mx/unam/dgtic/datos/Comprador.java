package mx.unam.dgtic.datos;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comprador")
public class Comprador {

    @Id
    @Column(name = "idComprador")
    private Integer idComprador;
    private String nombreComprador;
    private String apellidoComprador;
    private Integer edad;
    private String genero;
    private String correo;
    private String usuarioComprador = "Invitado";  // DEFAULT 'Invitado'
    private String contrasena;

    public Comprador() {
    }

    public Comprador(Integer idComprador, String nombreComprador, String apellidoComprador, Integer edad, String genero, String correo, String usuarioComprador, String contrasena) {
        this.idComprador = idComprador;
        this.nombreComprador = nombreComprador;
        this.apellidoComprador = apellidoComprador;
        this.edad = edad;
        this.genero = genero;
        this.correo = correo;
        this.usuarioComprador = usuarioComprador;
        this.contrasena = contrasena;
    }

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getApellidoComprador() {
        return apellidoComprador;
    }

    public void setApellidoComprador(String apellidoComprador) {
        this.apellidoComprador = apellidoComprador;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuarioComprador() {
        return usuarioComprador;
    }

    public void setUsuarioComprador(String usuarioComprador) {
        this.usuarioComprador = usuarioComprador;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Comprador{" +
                "idComprador=" + idComprador +
                ", nombreComprador='" + nombreComprador + '\'' +
                ", apellidoComprador='" + apellidoComprador + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", correo='" + correo + '\'' +
                ", usuarioComprador='" + usuarioComprador + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comprador comprador = (Comprador) o;
        return idComprador.equals(comprador.idComprador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComprador);
    }



}
