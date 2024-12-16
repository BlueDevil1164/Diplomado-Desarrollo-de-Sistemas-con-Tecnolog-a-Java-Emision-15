enum Logico {VERDADERO, FALSO};
// enum Nombre {Valores posibles que puede tomar la enumeración}
enum Turno {MATUTINO, VESPERTINO, MIXTO}
public class Enumeraciones {
    public static void main(String[] args) {
        // Ejemplo de definición y uso de enumeraciones

        // Uso de la enumeración Logico

        Logico registrado = Logico.VERDADERO;
        Logico aprobado = Logico.FALSO;

        System.out.println ("¿Está registrado? "+ registrado);
        System.out.println ("¿Aprobó? "+ aprobado);
        Turno raul = Turno.VESPERTINO;
        Turno lucia = Turno.VESPERTINO;

        System.out.println("Turno de Raúl: "+ raul);
        System.out.println("¿Raúl y Lucía están en el mismo turno?"+ (raul == lucia));

        // Uso de enumeraciones definidas en su propia .java
        Niveles nivelRaul = Niveles.BRONCE;
        System.out.println ("Nivel de Raúl: "+ nivelRaul);
        System.out.println ("\tDescuento de "+ nivelRaul.getDescuento()+"%");
        System.out.println ("\tMSI de "+ nivelRaul.getMesesSinIntereses());

        Niveles nivelLucia = Niveles.ANONIMO;
        System.out.println ("Nivel de Lucía: "+ nivelLucia);
        System.out.println ("\tDescuento de "+ nivelLucia.getDescuento()+"%");
        System.out.println ("\tMSI de "+ nivelLucia.getMesesSinIntereses());
    }  // Fin del main()
}  // Fin del class
