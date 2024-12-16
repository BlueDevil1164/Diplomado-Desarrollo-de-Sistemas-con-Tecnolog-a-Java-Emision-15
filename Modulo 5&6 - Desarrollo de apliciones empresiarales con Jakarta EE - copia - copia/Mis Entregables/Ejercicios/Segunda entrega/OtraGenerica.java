/*
 * Noyola Nazario Alejandro
 * Diplomado de desarrollo de Sistemas con Tecnología Java Emisión 15
 * Clase OtraGenerica
 * */

public class OtraGenerica <T, S>{
    public T atributo;

    public void despliega(S parametro) {
        System.out.println("Atributo: " + atributo);
        System.out.println("Parámetro: " + parametro);
    }
}

