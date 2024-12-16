import java.util.Scanner;
public class EjemploSwitch {
    public static void main (String[] args){
        // Ejemplo de uso de switch como sentencia
        Scanner teclado = new Scanner (System.in);
        int faltas = 0;
        System.out.print ("¿Cuántas faltas tuviste? ");
        faltas = teclado.nextInt();
        switch (faltas) {
            case 0:  // faltas == 0
                System.out.println ("Felicidades, asististe a todas las sesiones");
                break;
            case 1:  // faltas == 1
                System.out.println ("Creo que no hay problema");
                break;
            default:  // No fue ni 0 ni 1
                System.out.println ("Sí tienes problemas");
                break;

        }

        String turno = "X";
        switch (turno){
            case "M":
                System.out.println("Matutino");
                break;
            default:
                System.out.println("Otro turno");
                break;
        }
        System.out.println("Eso es todo por hoy, nos vemos;");

        // switch como expresión ("switch in line")  A partir de la ver. 14
        String respuesta = switch (turno){
            case "M" -> "Matutino";
            case "V" -> "Vespertino";
            default ->  "Mixto";
        };
        System.out.println ("Respuesta:"+respuesta);
    }
}
