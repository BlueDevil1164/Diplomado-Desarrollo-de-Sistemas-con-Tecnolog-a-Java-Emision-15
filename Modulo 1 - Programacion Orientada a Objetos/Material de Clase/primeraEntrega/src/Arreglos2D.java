public class Arreglos2D {
    public static void main (String[] args){
        String[] primos = new String[3];
        primos [0] = "Hugo";
        primos [1] = "Paco";
        primos [2] = "Luis";

        double [][] calificaciones = new double [3] [4];
        // 3 personas (Hugo, Paco, Luis)
        // y cada persona tiene 4 calificaciones (ejercicios, prácticas en clase, proyecto final y participación en clase

        calificaciones[1][2] = 10;  // 10 a Paco (1) en al proyecto final (2)

        for (int fila=0; fila <3; fila++){
            for (int columna=0; columna < 4; columna ++){
                System.out.println("Fila: "+fila+", columna: "+columna+ " con valor de "+ calificaciones[fila][columna]);
            }
        }


        calificaciones = new double [2][10];

    }
}
