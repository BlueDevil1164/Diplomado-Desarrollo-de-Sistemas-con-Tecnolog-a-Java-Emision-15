package servicio;

import constantes.TipoPago;
import entidades.Pago;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class CodiPagoTest {

    @Test
    public void testRealizarPagoCuandoPagoSeaNuloEntoncesObtenerNullPointerException() {
        //Given
        CodiPago codiPago=new CodiPago();
        //Pago pagoTesting= Pago.builder().tipoPago(TipoPago.CODI).id(1).monto(20.0).build();

        //pagoTesting=null;

        Pago finalPagoTesting = null;

        assertThrows(NullPointerException.class,()->{
            codiPago.realizarPago(finalPagoTesting);
        });



    }

    @Test
    public void testRealizarPagoCuandoPagoMontoIgualCeroEntoncesObtenerArithmeticException() {
        //Given
        CodiPago codiPago=new CodiPago();
        //Pago pagoTesting= Pago.builder().tipoPago(TipoPago.CODI).id(1).monto(20.0).build();

        //pagoTesting=null;

        Pago finalPagoTesting = new Pago();
        finalPagoTesting.setMonto(0.0);

        assertThrows(ArithmeticException.class,()->{
            codiPago.realizarPago(finalPagoTesting);
        });

    }

    @Test
    public void testValidarEstadoPagoCuandoEstadoEsPendienteEntoncesValidarTrue() {
        CodiPago codiPago=new CodiPago();

        Pago pagoTesting=new Pago();
        pagoTesting.setEstado("PENDIENTE");
        pagoTesting.setMonto(200.0);

        assertTrue(pagoTesting.getEstado()=="PENDIENTE");
    }

    @Test
    public void testValidarEstadoPagoCuandoEstadoEsPendienteEntoncesValidarTrueYObtenerRuntimeException() {
        CodiPago codiPago=new CodiPago();

        Pago pagoTesting=new Pago();
        pagoTesting.setEstado("PENDIENTE");
        pagoTesting.setMonto(200.0);

        assertTrue(pagoTesting.getEstado()=="PENDIENTE");

        assertThrows(RuntimeException.class,()->{
            codiPago.validarEstadoPago(pagoTesting);
        });
    }

    @Test
    public void testValidarOrigenDestino() {
    }

    @Test
    public void testObtenerMontoPagoTotal() {
    }
}