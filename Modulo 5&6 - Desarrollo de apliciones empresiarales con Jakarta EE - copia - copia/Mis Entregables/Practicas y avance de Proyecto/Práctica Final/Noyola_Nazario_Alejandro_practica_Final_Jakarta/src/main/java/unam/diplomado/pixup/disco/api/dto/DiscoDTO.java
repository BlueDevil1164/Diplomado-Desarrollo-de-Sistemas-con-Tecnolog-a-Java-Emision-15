package unam.diplomado.pixup.disco.api.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.domain.Disquera;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

import java.util.Date;

@Data
@AllArgsConstructor
public class DiscoDTO {

    @NotBlank(message = "titulo es requerido")
    @NotNull
    private String titulo;
    @NotNull
    private Float precio;
    @NotNull
    private Integer existencia;
    @NotNull
    private Float descuento;
    @NotNull
    private Date fechaLanzamiento;
    @NotNull
    private String imagen;

    @NotNull(message="Artista es requerido")
    private Artista artista;

    @NotNull(message="Disquera es requerido")
    private Disquera disquera;

    @NotNull(message="Genero Musica es requerido")
    private GeneroMusical generoMusical;
}
