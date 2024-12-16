package unam.diplomado.pixup.disco.domain;

public class DiscoNotFoundException extends RuntimeException{
    public DiscoNotFoundException(Integer id){
        super("No se encontró el disco con id: " + id);
    }
}
