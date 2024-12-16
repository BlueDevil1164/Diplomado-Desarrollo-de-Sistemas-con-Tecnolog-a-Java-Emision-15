package unam.diplomado.pixup.disco.api.Exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.disco.domain.DiscoImageNotFoundException;
import unam.diplomado.pixup.usuario.api.dto.ErrorResponse;
@Provider
public class DiscoNotFoundExceptionMapper implements ExceptionMapper<DiscoImageNotFoundException> {
    @Override
    public Response toResponse(DiscoImageNotFoundException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(new ErrorResponse(
                        Response.Status.CONFLICT.getStatusCode(),
                        "BUSINESS_RULE",
                        e.getMessage()))
                .build();
    }
}
