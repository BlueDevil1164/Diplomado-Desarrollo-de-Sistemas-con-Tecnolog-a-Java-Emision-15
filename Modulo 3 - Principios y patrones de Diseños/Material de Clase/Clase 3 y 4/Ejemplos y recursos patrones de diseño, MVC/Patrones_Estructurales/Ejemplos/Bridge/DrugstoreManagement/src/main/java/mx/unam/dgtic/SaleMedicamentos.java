package mx.unam.dgtic;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class SaleMedicamentos extends Sale {
    public SaleMedicamentos(InformTemplate informTemplate) {
        super(informTemplate);
    }

    @Override
    public String getDetails() {
        return "Detalles de la venta de medicamentos";
    }

    @Override
    public double getTotal() {
        return 100.0; // Cálculo del total de la venta de medicamentos
    }
}