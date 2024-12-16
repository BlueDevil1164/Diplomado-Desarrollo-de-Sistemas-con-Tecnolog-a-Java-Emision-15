package unam.diplomado.pixup.disco.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.disco.api.dto.*;
import unam.diplomado.pixup.disco.domain.*;
import unam.diplomado.pixup.disco.service.DiscoService;

public class DiscoResource implements DiscoApi {

    @Inject
    private DiscoService discoService;

    @Inject
    private DiscoMapper discoMapper;

    @Override
    public Response altaDisco(DiscoRequestDTO discoRequestDTO) {
        // Transformacion DTO - Entity
        //DiscoDTO DiscoRequestDTO = null;
        Disco disco = discoMapper.toDisco(discoRequestDTO);
        // Invocacion servicio negocio
        Disco discoCreado = discoService.altaDisco(disco);

        // Transformacion Entity - DTO

        DiscoDTO discoDTO = discoMapper.toDTO(discoCreado);
        return Response
                .status(Response.Status.CREATED)
                .entity(discoDTO)
                .build();


    }

}

