/*
* Noyola Nazario Alejandro
* Diplomado de desarrollo de Sistemas con Tecnología Java Emisión 15
* Clase Generica
* */
public class Generica <T>{// Es una clase generica

    public T atributo;
    public int numero;

    public void imprime(String p1, T p2){
        System.out.println("Atributo" + this.atributo);
        System.out.println(p1 + "--" + p2);
    }

}
