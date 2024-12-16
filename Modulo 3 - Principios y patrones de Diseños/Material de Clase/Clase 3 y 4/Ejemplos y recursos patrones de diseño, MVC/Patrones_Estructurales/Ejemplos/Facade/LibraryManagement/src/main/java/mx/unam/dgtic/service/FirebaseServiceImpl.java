package mx.unam.dgtic.service;

import mx.unam.dgtic.sdk.FirebaseSDK;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/

public class FirebaseServiceImpl implements FirebaseService{
    @Override
    public void createUser(String email, String name) {
        FirebaseSDK.createUser(name,email);
    }
}
