package unam.diplomado.pixup.disco.domain;

public class DiscoImageNotFoundException extends RuntimeException{
    public DiscoImageNotFoundException(String imagen) {
        super("No existe el disco con la imagen: " + imagen);
    }
}
