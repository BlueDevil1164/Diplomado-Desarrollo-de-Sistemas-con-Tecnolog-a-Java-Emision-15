package mx.unam.dgtic.client;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Auth0ClientImpl implements Auth0Client{
    @Override
    public void sendValidateUser(String email) {
        System.out.println("Sending validation...");
    }

    @Override
    public void sendCreateUSer(String email, String name, String lastNAme) {
        System.out.println("Creating user...");
    }
}
