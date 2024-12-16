public class Juego {
    public static void main (String[] args){
        System.out.println ("Simulación de un video juego");

        // Crear los personajes
        Personaje uno = new Personaje ("Ryu");
        Personaje dos = new Personaje ("Ken");

        System.out.println (uno+ "\t\t\t"+ dos);
        // Caracteres "de escape"
        //   \t    TABULADOR
        //   \n    SALTO DE LÍNEA


        // INteracción entre los personajes (pelea)
        uno.ataca (dos);
        System.out.println (uno+ "\t\t\t"+ dos);

        dos.ataca (uno);
        dos.ataca (uno);
        dos.ataca (uno);
        dos.ataca (uno);
        System.out.println (uno+ "\t\t\t"+ dos);






    }
}
