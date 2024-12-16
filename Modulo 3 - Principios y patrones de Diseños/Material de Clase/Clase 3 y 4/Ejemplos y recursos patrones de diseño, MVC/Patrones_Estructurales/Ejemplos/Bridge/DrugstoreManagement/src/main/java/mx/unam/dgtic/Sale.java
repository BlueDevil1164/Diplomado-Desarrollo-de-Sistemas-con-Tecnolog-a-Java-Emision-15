package mx.unam.dgtic;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public abstract class Sale {
    protected InformTemplate template;

    public Sale(InformTemplate formato) {
        this.template = formato;
    }

    public abstract String getDetails();
    public abstract double getTotal();

    public void generateInform() {
        String encabezado = template.generateHeader();
        String cuerpo = template.generateBody(getDetails(), getTotal());
        System.out.println(encabezado + "\n" + cuerpo);
    }
}
