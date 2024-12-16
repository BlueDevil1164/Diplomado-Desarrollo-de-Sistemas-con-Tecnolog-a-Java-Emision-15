public class Recursividad {
    public static long fibonacci (int i){
        long resultado = 0;
        // System.out.println ("Entré a la función");
        switch (i){
            case 1:  // Primera posición
                resultado = 0;
                break;
            case 2:  // Segunda posición
                resultado = 1;
                break;
            default:  // Para todos los demás...
                resultado = fibonacci (i-1)+ fibonacci (i-2);
        }
        return resultado;
    }

    public static void main (String[] args) {
        for (int i = 1; i <= 10; i++){
            System.out.print (fibonacci(i)+ ", ");
        }

    }
}
