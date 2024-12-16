package mx.unam.dgtic.service;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public interface Auth0Service {
    void validateUser(String email);
    void createUser(String email,String name, String lastName);

}
