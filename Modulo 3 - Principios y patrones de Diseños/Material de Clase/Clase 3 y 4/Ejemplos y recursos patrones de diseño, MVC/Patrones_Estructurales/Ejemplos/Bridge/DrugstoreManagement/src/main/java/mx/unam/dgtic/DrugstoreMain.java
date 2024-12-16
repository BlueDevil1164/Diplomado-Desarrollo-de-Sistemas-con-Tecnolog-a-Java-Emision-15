package mx.unam.dgtic;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 * En este sistema, tenemos diferentes tipos de ventas (por ejemplo, venta de medicamentos,
 * venta de productos de cuidado personal) y necesitamos generar informes sobre esas ventas en
 * diferentes formatos (por ejemplo, informe en PDF, informe en Excel). Además, la farmacia puede tener múltiples sucursales,
 * por lo que también queremos generar informes por sucursal.
 **
 **  @author: hxa.dev
 ***/
public class DrugstoreMain {
    public static void main(String[] args) {
        Sale saleMedicamentos =new SaleMedicamentos(new InformPDF());
        saleMedicamentos.generateInform();
        Sale saleCuidadoPersonal =new SaleCuidadoPersonal(new InformExcel());
        saleCuidadoPersonal.generateInform();

    }
}