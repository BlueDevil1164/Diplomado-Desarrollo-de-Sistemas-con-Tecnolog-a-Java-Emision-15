package unam.diplomado.pixup.disco.api.Exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.disco.domain.DiscoImageAlreadyExistsException;
@Provider
public class DiscoImageAlreadyExistsExceptionMapper implements ExceptionMapper<DiscoImageAlreadyExistsException> {
    @Override
    public Response toResponse(DiscoImageAlreadyExistsException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(e.getMessage())
                .build();
    }
}
