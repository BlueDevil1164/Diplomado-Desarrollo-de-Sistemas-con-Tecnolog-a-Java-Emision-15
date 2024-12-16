public class Generica <T extends Persona>{// Es una clase genérica con UN parámetro (T)
    public T atributo;
    public int numero;

    public void imprime (String p1, T p2){
        System.out.println("("+this.numero+")= "+ this.atributo);
        System.out.println(p1 + "--"+ p2);
        System.out.println ("Tiene una edad de " + atributo.getEdad());  //getEdad() no existe para todas las clases

    }
}
