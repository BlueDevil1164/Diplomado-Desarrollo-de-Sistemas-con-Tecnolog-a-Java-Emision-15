/*
 * Noyola Nazario Alejandro
 * Diplomado de desarrollo de Sistemas con Tecnología Java Emisión 15
 * Clase ClaseConEstaticos
 * */
public class ClaseConEstaticos {
    public String texto;
    public int numero;
    public static double real=98.7;// Elemento estatico

    public void metodoNoEstatico(){
        System.out.println("Metodo no estatico. El numero = "+this.numero);
    }
    public static void metodoEstatico(){
        System.out.println("Metodo no estatico. El numero = "+real);

    }

}
