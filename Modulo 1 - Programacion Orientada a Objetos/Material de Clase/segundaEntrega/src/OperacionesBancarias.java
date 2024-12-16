public class OperacionesBancarias {
    public static void main (String[] args){
        // Simulación de operaciones bancarias con la clase CuentaBancaria
        // Clase objeto = new Constructor ();zz
        CuentaBancaria ctaHugo = new CuentaBancaria("12345");
        CuentaBancaria ctaPaco = new CuentaBancaria("98765");

        // DEPÓSITO
        System.out.println ("Cuenta de Hugo: "+ ctaHugo);

        // ¿Cómo hacer un depósito?
        if (ctaHugo.depositar (-200)){
            System.out.println("Operación realizada");
        } else{
            System.out.println("Error en la transacción, te regreso tu dinero...");
        }
        System.out.println ("Cuenta de Hugo después del depósito: "+ ctaHugo);
        /// YA NO FUNCIONARÍA ctaHugo.setSaldo(1000000);  // !!

        // RETIROS
        if (ctaHugo.retirar (100)){
            System.out.println("Retiro realizado correctamente");
        } else{
            System.out.println("Error en el retiro.");
        }
        System.out.println ("Cuenta de Hugo después del retiro: "+ ctaHugo);

        // TRANSFERENCIA
        System.out.println (ctaHugo);
        System.out.println (ctaPaco );

        // Transferencia de $5   de Hugo    a    Paco
        ctaHugo.transferir (ctaPaco, 5);

        System.out.println (ctaHugo);
        System.out.println (ctaPaco );


        CuentaBancaria otraCuenta = new CuentaBancaria("84756");   //??
        System.out.println ("Otra cuenta "+otraCuenta);
    }  // FInal del main()
} // FInal del class
