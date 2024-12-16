package mx.unam.dgtic;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class SaleCuidadoPersonal extends Sale {
    public SaleCuidadoPersonal(InformTemplate informTemplate) {
        super(informTemplate);
    }

    @Override
    public String getDetails() {
        return "Detalles de la venta de productos de cuidado personal";
    }

    @Override
    public double getTotal() {
        return 50.0; // Cálculo del total de la venta de productos de cuidado personal
    }
}
