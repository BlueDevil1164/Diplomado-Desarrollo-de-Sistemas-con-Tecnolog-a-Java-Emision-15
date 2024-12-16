package mx.unam.dgtic.client;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/

public interface Auth0Client {
    void sendValidateUser(String email);
    void sendCreateUSer(String email, String name, String lastNAme);
}
