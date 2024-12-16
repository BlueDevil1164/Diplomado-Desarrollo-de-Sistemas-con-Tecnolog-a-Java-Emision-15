package servicio;

import entidades.Pago;

public interface PasarelaPagoAbstracta {
    void realizarPago(Pago pago);
    void validarEstadoPago(Pago pago);
    boolean validarOrigenDestino(Pago pago);
    Double obtenerMontoPagoTotal(Pago pago);
}
