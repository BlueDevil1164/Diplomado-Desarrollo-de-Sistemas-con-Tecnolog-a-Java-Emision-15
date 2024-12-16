import java.util.Date;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 ** @Producto: {{Clase PagoPaypal}}
 ** @author: {{Noyola Nazario Alejandro}}
 ** @Fecha: {{20 de Junio 2024}}
 ***/

import java.util.Date;

//Constructor de Paypal y que estiende de pago
public class PagoPaypal extends Pago {
    private String emailPaypal;

    // Constructor
    public PagoPaypal(double monto, Date fecha, String metodo, String emailPaypal) {
        super(monto, fecha, metodo); // Llama al constructor de la superclase Pago
        this.emailPaypal = emailPaypal;
    }

    // Método para realizar el pago con tarjeta
    @Override
    public void realizarPago() {
        if (getMonto() >= 0) {
            System.out.println("Pago realizado con éxito con cuanta " + emailPaypal);
        } else {
            System.out.println("Dinero insuficiente. Pago no realizado.");
        }
    }

    // Getter y setter específico para número de tarjeta
    public String getEmailPaypal() {
        return emailPaypal;
    }

    public void setEmailPaypal(String emailPaypal) {
        this.emailPaypal = emailPaypal;
    }
}