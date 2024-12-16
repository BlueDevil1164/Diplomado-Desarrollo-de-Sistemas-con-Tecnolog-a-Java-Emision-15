package unam.diplomado.pixup.disco.api.dto;

import jakarta.inject.Singleton;
import unam.diplomado.pixup.disco.domain.Disco;

@Singleton
public class DiscoMapper {
    public DiscoDTO toDTO(Disco disco){
        return new DiscoDTO(
                disco.getTitulo(),
        disco.getPrecio(), disco.getExistencia(),
        disco.getDescuento(), disco.getFechaLanzamiento(),
        disco.getImagen(), disco.getArtista(),
        disco.getDisquera(), disco.getGeneroMusical()
            );
    }
    public Disco toDisco(DiscoRequestDTO discoDTO) {
        return new Disco(discoDTO.getTitulo(),
                discoDTO.getPrecio(),
                discoDTO.getExistencia(),
                discoDTO.getDescuento(),
                discoDTO.getFechaLanzamiento(),
                discoDTO.getImagen(),
                discoDTO.getDisquera(),
                discoDTO.getArtista(),
                discoDTO.getGeneroMusical()
                );
    }


}
