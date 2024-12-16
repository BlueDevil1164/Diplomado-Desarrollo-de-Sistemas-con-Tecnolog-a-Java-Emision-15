public class ClaseConEstaticos {
    public String texto;
    public int numero;
    public static double real=98.7;// Elemento estático

    public void metodoNoEstatico (){
        System.out.println ("Método no estático. El número = "+this.numero);
    }

    public static void metodoEstatico() {
        System.out.println ("Método no estático. El atributo estático es  " + real);
    }
}
