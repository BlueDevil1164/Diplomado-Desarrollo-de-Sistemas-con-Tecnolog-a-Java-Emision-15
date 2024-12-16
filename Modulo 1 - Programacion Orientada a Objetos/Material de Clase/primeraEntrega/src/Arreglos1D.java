public class Arreglos1D {
    public static void main (String[] args){
        String[] primos = new String[3];
        primos [0] = "Hugo";
        primos [1] = "Paco";
        primos [2] = "Luis";
        double[] calificaciones = {9.8, 6.9, 7.45};

        for (int i=0; i<3; i++)
            System.out.println ("Elemento con índice "+ i + " de "+primos[i]+ " con una calificación de "+ calificaciones[i]);


        int numero=1;
        String[] nombres = {"Enero","Febrero","Marzo", "Abril", "Mayo", "Diciembre"};
        System.out.println ("El mes "+ numero + " corresponde al mes "+nombres[numero-1]);





    }
}
