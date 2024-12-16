package unam.diplomado.pixup.disco.api.Exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.disco.domain.ArtistaNotFoundException;
import unam.diplomado.pixup.disco.domain.DiscoAlreadyExistsException;
import unam.diplomado.pixup.usuario.api.dto.ErrorResponse;
@Provider
public class DiscoAlreadyExistsExceptionMapper implements ExceptionMapper<DiscoAlreadyExistsException> {
    @Override
    public Response toResponse(DiscoAlreadyExistsException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(e.getMessage())
                .build();
    }
}
