package dgtic.core.modelo.exeptions;

public class CreditosMenores extends RuntimeException {

    public CreditosMenores(String mensaje) {
        super(mensaje);
    }
}
