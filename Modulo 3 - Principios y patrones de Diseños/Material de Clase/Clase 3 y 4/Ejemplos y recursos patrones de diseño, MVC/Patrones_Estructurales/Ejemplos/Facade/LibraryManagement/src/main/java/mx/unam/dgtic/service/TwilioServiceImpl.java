package mx.unam.dgtic.service;

import mx.unam.dgtic.sdk.TwilioSDK;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/

public class TwilioServiceImpl implements TwilioService{
    public TwilioServiceImpl() {
    }

    @Override
    public void sendSMS(String phoneNumber) {
        TwilioSDK.sendNotification(phoneNumber);
    }
}
