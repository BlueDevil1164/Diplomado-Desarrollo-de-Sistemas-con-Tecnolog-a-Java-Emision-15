package mx.unam.dgtic.service;

import mx.unam.dgtic.client.OnfidoClient;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/

public class OnfidoServiceImpl implements OnfidoService{

    private OnfidoClient client;

    public OnfidoServiceImpl(OnfidoClient client) {
        this.client = client;
    }

    @Override
    public void validateIndentity(String name, String email) {
        // Validate indentity Onfido
        client.sendValidationOnfido(name,email);
    }
}
