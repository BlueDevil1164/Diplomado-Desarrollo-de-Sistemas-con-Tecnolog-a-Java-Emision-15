import java.util.Scanner;

public class EjemploSwitch {
    public static void main (String[] args){
        //Ejemplo de uso de switch como sentencia
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ejemplo de casos en un Switch: ");
        System.out.println("Con casos de 0, 1 o mas faltas");
        System.out.println("*----------------------------------*");
        int faltas = 0;
        System.out.print("¿Cuantas faltas tuviste?\n" + "Tu respuesta: ");
        faltas = teclado.nextInt();
        System.out.println("*----------------------------------*");
        switch (faltas) {
            case 0: //faltas ==0
                System.out.println("En caso de que sean 0 Faltas");
                System.out.println("Felicidades, nunca faltaste");
                break;
            case 1:
                System.out.println("En caso de que sean 1 Faltas");
                System.out.println("Creo que no tienes problema");
                break;
            default:
                System.out.println("En caso de que sean 2 Faltas o mas");
                System.out.println("Ya ni entres chavo");
                break;

        }
        System.out.println("*----------------------------------*");
        System.out.println("En este caso se se evalua: un caso por defalut por defecto");
        String turno = "X";
        switch (turno) {
            case "M":
                System.out.println("Matutino");
                break;
            case "V":
                System.out.println("Vespertino");
                break;
            default:
                System.out.println("Es otro turno");
        }
        System.out.println("*----------------------------------*");
        System.out.println("Es todo por hoy gracias");

                //switch como expresion

                String respuesta = switch (turno){

                case "M" -> "Matutino";
                case "V" -> "Vespertino";
                default -> "Mixto";

            };
            System.out.println("Respuesta " + respuesta);

        }

}
