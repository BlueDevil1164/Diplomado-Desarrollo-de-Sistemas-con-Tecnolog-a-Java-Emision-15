public class Arreglos2D {
        public static void main (String[] args){
            String[] primos = new String[3];
            primos [0] = "Hugo";
            primos [1] = "Paco";
            primos [2] = "Luis";

            double [][] calificaiones = new double[3][4];
            // 3 personas  y cada persona tiene 4 calificaiones
            // Y cada persona tiene 4 calificaciones

            calificaiones[1][2] =10; //10 a Paco (1) y final (2)

            for (int fila = 0; fila <3; fila ++){
                for (int columna =0; columna < 4; columna ++){
                    System.out.println("Fila: " +fila+", columna: "+columna+ "con valor de "+ calificaiones[fila][columna]);

                }

            }
            calificaiones = new double [2][10];




        }

}
