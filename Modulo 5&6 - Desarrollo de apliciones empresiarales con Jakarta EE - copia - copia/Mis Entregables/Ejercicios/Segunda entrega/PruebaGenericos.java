/*
 * Noyola Nazario Alejandro
 * Diplomado de desarrollo de Sistemas con Tecnología Java Emisión 15
 * Clase PruebaGenericos
 * */

import java.security.CodeSigner;
public class PruebaGenericos {
    public static  void main (String[] args){
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Prueba de genericos");
        Generica<String> o1 = new Generica<>();
        System.out.println("----------------------------------------------------------------------------------------------------");

        o1.atributo = "Hola";
        o1.numero = 34;
        o1.imprime("Hola", "Mundo");
        System.out.println("----------------------------------------------------------------------------------------------------");

        Generica<CuentaBancaria> o2 = new Generica<CuentaBancaria>();
        o2.atributo = new CuentaBancaria("12345");
        o2.numero = 86;
        o2.imprime("Adios", new CuentaBancaria("98765"));
        System.out.println("----------------------------------------------------------------------------------------------------");


        Generica<Docente> o3 = new Generica<>();
        o3.atributo = new Docente();
        o3.numero = -14;
        o3.imprime("UNAM", new Docente());
        System.out.println("----------------------------------------------------------------------------------------------------");


        Generica<Estudiante> o4 = new Generica<>();
        o4.atributo = new Estudiante();
        o4.numero = -14;
        o4.imprime("UNAM", new Estudiante());
        System.out.println("----------------------------------------------------------------------------------------------------");


        // Generica con dos clases como parámetro
        System.out.println("Uso de genérica con dos parámetros.");
        OtraGenerica<String, Double> o5 = new OtraGenerica<>();
        o5.atributo = "Hola";
        o5.despliega(67.9);
        System.out.println("----------------------------------------------------------------------------------------------------");


        OtraGenerica<Casa, Persona> o6 = new OtraGenerica<>();
        o6.atributo = new Casa();
        o6.despliega(new Persona());
        System.out.println("----------------------------------------------------------------------------------------------------");

    }

}
