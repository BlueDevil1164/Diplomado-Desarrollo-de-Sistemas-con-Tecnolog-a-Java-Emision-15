package unam.diplomado.pixup.disco.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity

public class Disco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "titulo es requerido")
    private String titulo;
    @Column(name="precio")
    private Float precio;
    @Column(name="existencia")
    private Integer existencia;
    @Column(name="descuento")
    private Float descuento;
    @Column(name="fecha_lanzamiento")
    private Date fechaLanzamiento;
    @Column(name="imagen")
    private String imagen;
    @ManyToOne(targetEntity = Disquera.class)
    @JoinColumn(name="id_disquera", nullable = false)
    private Disquera disquera;
    @ManyToOne(targetEntity = Artista.class)
    @JoinColumn(name="id_artista", nullable = false)
    private Artista artista;
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
