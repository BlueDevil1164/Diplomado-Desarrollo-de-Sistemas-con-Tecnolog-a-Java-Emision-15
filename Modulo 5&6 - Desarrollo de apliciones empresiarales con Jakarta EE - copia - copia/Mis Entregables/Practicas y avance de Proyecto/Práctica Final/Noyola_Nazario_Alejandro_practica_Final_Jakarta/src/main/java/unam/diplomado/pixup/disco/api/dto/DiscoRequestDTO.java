package unam.diplomado.pixup.disco.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.domain.Disquera;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscoRequestDTO {
    @NotNull
    @NotBlank(message = "Titulo es requerido")
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
    @NotBlank(message = "Imagen es requerido")
    private String imagen;
    @NotNull
    private Disquera disquera;
    @NotNull
    private Artista artista;
    @NotNull
    private GeneroMusical generoMusical;

}
