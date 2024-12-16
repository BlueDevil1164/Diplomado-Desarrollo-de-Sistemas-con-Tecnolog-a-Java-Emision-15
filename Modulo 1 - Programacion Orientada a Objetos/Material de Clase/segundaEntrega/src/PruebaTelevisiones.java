public class PruebaTelevisiones {
    public static void main (String[] args){
        System.out.println ("Prueba de Televisiones");
        Television tv1 = new Television();
        System.out.println ("Al crearse: " + tv1);
        tv1.encendido();   // Cambia el estatus de encendido
        System.out.println ("Después del encendido: "+tv1);
        tv1.subeVolumen();
        System.out.println ("Después de subir el volumen " +tv1);
        tv1.silencio();
        System.out.println (tv1);
        tv1.silencio();
        System.out.println (tv1);
        tv1.encendido();
        System.out.println (tv1);

        tv1.imprimeStatus();

    }
}
