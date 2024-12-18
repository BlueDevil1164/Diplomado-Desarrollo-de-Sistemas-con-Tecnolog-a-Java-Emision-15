package unam.diplomado.pixup.disco.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.disco.api.dto.DiscoRequestDTO;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("discos")
public interface DiscoApi {
    @POST
    @Path("alta")
    Response altaDisco(@NotNull @Valid DiscoRequestDTO disco);
}
