package mx.unam.dgtic.facade;

import mx.unam.dgtic.service.Auth0Service;
import mx.unam.dgtic.service.FirebaseService;
import mx.unam.dgtic.service.OnfidoService;
import mx.unam.dgtic.service.TwilioService;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class LibraryFacade {
    private Auth0Service auth0Service;
    private FirebaseService firebaseService;
    private TwilioService twilioService;
    private OnfidoService onfidoService;

    public LibraryFacade(Auth0Service auth0Service, FirebaseService firebaseService, TwilioService twilioService, OnfidoService onfidoService) {
        this.auth0Service = auth0Service;
        this.firebaseService = firebaseService;
        this.twilioService = twilioService;
        this.onfidoService = onfidoService;
    }

    public void signUpUser(String name, String email, String lastName, String phoneNumber){
        // Logica de negocio para el registro de usuarios en el sistema.

        // validacion de identidad con Onfido
        onfidoService.validateIndentity(name,email);

        // Creacion de usuario en Auth0
        auth0Service.validateUser(email);
        auth0Service.createUser(email, name, lastName);

        // Envio de SMS de confirmacion con Twilio
        twilioService.sendSMS(phoneNumber);

        // Registro de usuario en NoSQL Firebase
        firebaseService.createUser(email, name);

        // Otros pasos
    }
}
