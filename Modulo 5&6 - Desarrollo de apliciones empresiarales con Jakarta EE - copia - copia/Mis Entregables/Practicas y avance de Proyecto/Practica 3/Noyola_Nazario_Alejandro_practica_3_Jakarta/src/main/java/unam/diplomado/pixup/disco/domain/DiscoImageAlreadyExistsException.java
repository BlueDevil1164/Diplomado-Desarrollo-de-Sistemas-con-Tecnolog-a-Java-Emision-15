package unam.diplomado.pixup.disco.domain;

public class DiscoImageAlreadyExistsException extends  RuntimeException{
    public DiscoImageAlreadyExistsException(String imagen){
        super("Ya existe el disco con la imagen: " + imagen);
    }
}
