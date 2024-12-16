package unam.diplomado.pixup.disco.domain;

public class DisqueraNotFoundException extends RuntimeException {
    public DisqueraNotFoundException(Integer id) {
        super("No existe la Disquera con el id: " + id);
    }
}
