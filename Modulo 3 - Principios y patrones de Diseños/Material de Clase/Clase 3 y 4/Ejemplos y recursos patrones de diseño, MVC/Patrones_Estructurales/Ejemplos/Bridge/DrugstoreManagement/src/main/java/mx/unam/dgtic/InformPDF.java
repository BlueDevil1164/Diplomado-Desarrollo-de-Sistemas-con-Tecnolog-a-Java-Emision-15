package mx.unam.dgtic;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class InformPDF implements InformTemplate {
    @Override
    public String generateHeader() {
        return "===== INFORME DE VENTA EN FORMATO PDF =====";
    }

    @Override
    public String generateBody(String detalleVenta, double total) {
        return "Detalle: " + detalleVenta + "\nTotal: $" + total;
    }
}
