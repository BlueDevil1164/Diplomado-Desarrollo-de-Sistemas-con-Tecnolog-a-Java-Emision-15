public class CuentaBancaria {
    // Atributos
    // public tipo nombre;
    public String numeroCuenta;
    private String titular;
    public String tipoCUenta; // Crédito, Dëbito, Inversión
    private double saldo;
    public String fechaApertura;

    // Métodos
    // Constructor
    public CuentaBancaria (){
        // Asignar valores iniciales a los atributos
        this.numeroCuenta = "S/C";
        this.titular = "Sin titular";
        this.tipoCUenta = "Débito";
        this.setSaldo(0);
        this.fechaApertura = "01/01/2000";
    }  // Fin del constructor CuentaBancaria ()
    public CuentaBancaria (String cuenta){
        // Recibe el número de cuenta, y buscará esa cuenta en la BBDD
        // Hugo: 12345, Débito, 111, 01/01/2001
        // Paco: 98765, Débito, 222, 02/02/2002
        // Luis: 76543, Crédito, -200, 03/03/2003

        // Para llenar los atributos con los valor por default:
        this();  // Llama al constructor sin parámetros de entrada CuentaBancaria()

        if (cuenta.equals ("12345")){  // Cuenta de Hugo
            this.numeroCuenta = cuenta;
            this.titular = "Hugo";
            this.tipoCUenta = "Débito";
            this.setSaldo(111);
            this.fechaApertura = "01/01/2001";
        } else {
            if (cuenta.equals ("98765")){  // Cuenta de Paco
                this.numeroCuenta = cuenta;
                this.titular = "Paco";
                this.tipoCUenta = "Débito";
                this.setSaldo(22);
                this.fechaApertura = "02/02/2002";
            }
        }
    }  // Fin del constructor CuentaBancaria (String)

    public void setTitular (String titularEntrada){
        this.titular = titularEntrada;
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCUenta() {
        return tipoCUenta;
    }

    public void setTipoCUenta(String tipoCUenta) {
        this.tipoCUenta = tipoCUenta;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getTitular (){
        return this.titular;
    }
    private void setSaldo(double saldoEntrada){
        if (saldoEntrada >= 0)
            this.saldo = saldoEntrada;
    }
    public double getSaldo(){

        return this.saldo;
    }

    public boolean depositar (double cantidad){
        // Este método grabará en la bbdd el saldo actualizado
        // Regresará true si pudo hacer la operación, o false en cualquier otro caso.
        boolean resultado=false;
        if (cantidad > 0){
            //this.saldo += cantidad;
            this.setSaldo (this.getSaldo()+cantidad);
            // Aquí debe estar la actualización en la BBDD
            resultado = true;
        }
        return resultado;
    }
    public boolean retirar (double monto){
        // Debe tener saldo suficiente para el retiro
        // El monto a retirar debería ser mayor a cero

        // Falta implementar
        // No permitir retiros si no hay saldo en el cajero
        // El monto sea siempre en múltiplos de 100
        boolean resultado=false;
        if (monto > this.saldo || monto <= 0){  // No hay saldo o el monto es negativo
            resultado = false;
        } else {
            this.setSaldo (this.getSaldo()-monto);
            // Aquí van las operaciones a la BBDD
            resultado = true;
        }
        return resultado;
    }

    public boolean transferir (CuentaBancaria destino, double monto) {
        // 1. Retirar de la cuenta origen (this) un monto
        // 2. Depositar el monto a la cuenta destino (destino)
        boolean resultado = false;
        // 1.
        if (this.retirar (monto)) {
            // 2.
            resultado = destino.depositar(monto);
        }
        return resultado;
    }


    @Override
    public String toString() {
        String resultado = "Cuenta de " +this.getTitular() + " ("+this.getTipoCUenta()+") con saldo de $"+this.getSaldo();
        return resultado;
    }

}
