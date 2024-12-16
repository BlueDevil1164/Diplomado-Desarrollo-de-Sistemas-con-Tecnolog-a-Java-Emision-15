package mx.unam.dgtic;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public interface InformTemplate {
    String generateHeader();
    String generateBody(String detalleVenta, double total);
}
