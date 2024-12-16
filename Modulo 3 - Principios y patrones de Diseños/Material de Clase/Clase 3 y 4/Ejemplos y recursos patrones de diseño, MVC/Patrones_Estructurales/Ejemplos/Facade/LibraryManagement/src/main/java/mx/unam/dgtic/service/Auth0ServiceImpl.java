package mx.unam.dgtic.service;

import mx.unam.dgtic.client.Auth0Client;
import mx.unam.dgtic.client.OnfidoClient;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/

public class Auth0ServiceImpl implements Auth0Service{

    private Auth0Client client;

    public Auth0ServiceImpl(Auth0Client client) {
        this.client = client;
    }

    @Override
    public void validateUser(String email) {
        client.sendValidateUser(email);
    }

    @Override
    public void createUser(String email, String name, String lastName) {
        client.sendCreateUSer(email, name, lastName);
    }
}
