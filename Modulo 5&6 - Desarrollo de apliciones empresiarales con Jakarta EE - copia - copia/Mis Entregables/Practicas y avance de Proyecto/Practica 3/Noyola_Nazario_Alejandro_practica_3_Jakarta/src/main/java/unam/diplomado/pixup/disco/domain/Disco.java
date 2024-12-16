package unam.diplomado.pixup.disco.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@ToString
public class Disco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotBlank(message = "titulo es requerido")
    private String titulo;
    @NotNull
    @Column(name="precio")
    private Float precio;
    @NotNull
    @Column(name="existencia")
    private Integer existencia;
    @NotNull
    @Column(name="descuento")
    private Float descuento;
    @NotNull
    @Column(name="fecha_lanzamiento")
    private Date fechaLanzamiento;
    @NotNull
    @Column(name="imagen")
    private String imagen;
    @NotNull
    @ManyToOne(targetEntity = Disquera.class)
    @JoinColumn(name="id_disquera", nullable = false)
    private Disquera disquera;
    @NotNull
    @ManyToOne(targetEntity = Artista.class)
    @JoinColumn(name="id_artista", nullable = false)
    private Artista artista;
    @NotNull
    @ManyToOne(targetEntity = GeneroMusical.class)
    @JoinColumn(name="id_genero_musical", nullable = false)
    private GeneroMusical generoMusical;

    public Disco(String titulo, Float precio, Integer existencia, Float descuento, Date fechaLanzamiento, String imagen, Disquera disquera, Artista artista, GeneroMusical generoMusical) {
        this.titulo = titulo;
        this.precio = precio;
        this.existencia = existencia;
        this.descuento = descuento;
        this.fechaLanzamiento = fechaLanzamiento;
        this.imagen = imagen;
        this.disquera = disquera;
        this.artista = artista;
        this.generoMusical = generoMusical;
    }


}
