package mx.unam.dgtic;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class InformExcel implements InformTemplate {
    @Override
    public String generateHeader() {
        return "===== INFORME DE VENTA EN FORMATO EXCEL =====";
    }

    @Override
    public String generateBody(String detalleVenta, double total) {
        return "Detalle: " + detalleVenta + "\nTotal: $" + total;
    }
}