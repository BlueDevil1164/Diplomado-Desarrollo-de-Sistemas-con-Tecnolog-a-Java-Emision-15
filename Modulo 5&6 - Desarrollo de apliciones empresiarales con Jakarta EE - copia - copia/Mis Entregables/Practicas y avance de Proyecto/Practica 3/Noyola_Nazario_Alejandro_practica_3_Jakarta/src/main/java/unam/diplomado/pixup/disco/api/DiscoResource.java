package unam.diplomado.pixup.disco.api;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.disco.domain.*;
import unam.diplomado.pixup.disco.service.DiscoService;

public class DiscoResource implements DiscoApi {

    @Inject
    private DiscoService discoService;

    @Override
    public Response altaDisco(@NotNull @Valid Disco disco) {
        try {
            Disco altaDisco = discoService.altaDisco(disco);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(altaDisco)
                    .build();

         }catch (Exception e){

            if (e.getCause() instanceof DiscoAlreadyExistsException){
                return Response
                        .status(Response.Status.CONFLICT)
                        .entity(e.getMessage())
                        .build();
            }
            if (e.getCause() instanceof ArtistaNotFoundException) {
                return Response
                        .status(Response.Status.PRECONDITION_REQUIRED)
                        .entity(e.getMessage())
                        .build();
            }
            if (e.getCause() instanceof DisqueraNotFoundException) {
                return Response
                        .status(Response.Status.PRECONDITION_REQUIRED)
                        .entity(e.getMessage())
                        .build();
            }
            if (e.getCause() instanceof GeneroMusicalNotFoundException) {
                return Response
                        .status(Response.Status.PRECONDITION_REQUIRED)
                        .entity(e.getMessage())
                        .build();
            }
            if (e.getCause() instanceof DiscoImageAlreadyExistsException) {
                return Response
                        .status(Response.Status.CONFLICT)
                        .entity(e.getMessage())
                        .build();
            }
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Un error ocurrio.")
                    .build();
        }

    }
}

