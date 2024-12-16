/***
 ** Unidad 3 - Principios y Patrones de Diseño
 ** @Producto: {{Clase PagoTarjeta}}
 ** @author: {{Noyola Nazario Alejandro}}
 ** @Fecha: {{20 de Junio 2024}}
 ***/
import java.util.Date;

public class PagoTarjeta extends Pago {
    private String numeroTarjeta;

    // Constructor de la Tajeta y que estiende de pago
    public PagoTarjeta(double monto, Date fecha, String metodo, String numeroTarjeta) {
        super(monto, fecha, metodo); // Llama al constructor de la superclase Pago
        this.numeroTarjeta = numeroTarjeta;
    }

    // Método para realizar el pago con tarjeta
    @Override
    public void realizarPago() {
        if (getMonto() >= 0) {
            System.out.println("Pago realizado con éxito con tarjeta " + numeroTarjeta);
        } else {
            System.out.println("Dinero insuficiente. Pago no realizado.");
        }
    }

    // Getter y setter específico para número de tarjeta
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
}

