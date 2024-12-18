package unam.diplomado.pixup.disco.api.Exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.disco.domain.DisqueraNotFoundException;
@Provider
public class DisqueraNotFoundExceptionMapper implements ExceptionMapper<DisqueraNotFoundException> {

    @Override
    public Response toResponse(DisqueraNotFoundException e) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(e.getMessage())
                .build();

    }
}
