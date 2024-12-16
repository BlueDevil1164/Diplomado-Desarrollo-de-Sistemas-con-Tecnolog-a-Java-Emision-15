public class EjemploFInal {
    public static void main (String[] args){
        // final

        // En constantes
        final double PI = 3.141592;  // Inmutable, ya no puede cambiar de valor
        final double IVA = 0.16;
        System.out.println (PI);
        System.out.println (IVA);

        // IVA = 0.87;
        // PI = 1.98;
        System.out.println (IVA+PI);

        // En clases
        Egresado o1 = new Egresado();
        System.out.println (o1);

        EgresadoVIP o2 = new EgresadoVIP();

    }
}
