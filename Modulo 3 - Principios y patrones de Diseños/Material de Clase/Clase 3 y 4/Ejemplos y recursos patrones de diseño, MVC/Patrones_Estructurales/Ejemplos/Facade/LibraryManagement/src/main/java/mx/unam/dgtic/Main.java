package mx.unam.dgtic;

import mx.unam.dgtic.client.Auth0ClientImpl;
import mx.unam.dgtic.client.OnfidoClient;
import mx.unam.dgtic.client.OnfidoClientImpl;
import mx.unam.dgtic.facade.LibraryFacade;
import mx.unam.dgtic.service.Auth0ServiceImpl;
import mx.unam.dgtic.service.FirebaseServiceImpl;
import mx.unam.dgtic.service.OnfidoServiceImpl;
import mx.unam.dgtic.service.TwilioServiceImpl;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Main {
    public static void main(String[] args) {
        LibraryFacade facade=new LibraryFacade(
                new Auth0ServiceImpl(new Auth0ClientImpl()),
                new FirebaseServiceImpl(),
                new TwilioServiceImpl(),
                new OnfidoServiceImpl(new OnfidoClientImpl()));
        facade.signUpUser("Pedrito", "pedrito@unam.com", "Gonzalez","32131312");
    }
}