package servicio;

import entidades.Pago;

public class PaypalPago implements PasarelaPagoAbstracta{
    private final double COMISION=0.2;

    @Override
    public void realizarPago(Pago pago) {
        if(pago==null){
            throw new NullPointerException("El pago se encuentra en formato incorrecto");
        }

        if(pago.getMonto()==0){
            throw new ArithmeticException("El monto del pago no puede ser 0");
        }

        System.out.println("Pago realizado....");
    }

    @Override
    public void validarEstadoPago(Pago pago) {
        if(pago.getEstado()=="PENDIENTE"){
            throw new RuntimeException("El pago se encuentra pendiente");
        }

        if(pago.getEstado()=="PROCESADO"){
            System.out.println("el pago se proceso...");
        }
    }

    @Override
    public boolean validarOrigenDestino(Pago pago) {
        if(pago.getDestino()!=null && pago.getOrigen()!=null){
            return true;
        }

        return false;
    }


    @Override
    public Double obtenerMontoPagoTotal(Pago pago) {
        var montoComision=pago.getMonto()*COMISION;
        var montoPagoTotal=montoComision+pago.getMonto();

        return montoPagoTotal;
    }
}
