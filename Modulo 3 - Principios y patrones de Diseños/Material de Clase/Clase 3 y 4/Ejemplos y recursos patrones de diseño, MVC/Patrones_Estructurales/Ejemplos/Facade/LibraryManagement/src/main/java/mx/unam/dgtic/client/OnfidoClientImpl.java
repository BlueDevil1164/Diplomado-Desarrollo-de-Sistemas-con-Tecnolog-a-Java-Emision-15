package mx.unam.dgtic.client;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class OnfidoClientImpl implements OnfidoClient{

    public OnfidoClientImpl() {
    }

    @Override
    public void sendValidationOnfido(String username, String email) {
        System.out.println("Sending validation for "+email+", "+username);
    }
}
