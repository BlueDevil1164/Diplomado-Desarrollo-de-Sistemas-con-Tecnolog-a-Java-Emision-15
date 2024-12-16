/***
 ** Unidad 3 - Principios y Patrones de Diseño
 ** @Producto: {{Clase Pago}}
 ** @author: {{Noyola Nazario Alejandro}}
 ** @Fecha: {{20 de Junio 2024}}
 ***/

import java.util.Date;

import java.util.Date;

public class Pago {
    private double monto;
    private Date fecha;
    private String metodo;

    // Constructor
    public Pago(double monto, Date fecha, String metodo) {
        this.monto = monto;
        this.fecha = fecha;
        this.metodo = metodo;
    }

    // Getters y setters
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    //Metodo para realizar pago

    public void realizarPago() {
        if (metodo.equals("Pago con Tarjeta")) {

            System.out.println("Realizando pago de $" + monto + " usando Tarjeta de credito");

        } else if (metodo.equals("Pago con Paypal")) {

            System.out.println("Realizando pago de $" + monto + " usando Paypal");
        }
    }
}



