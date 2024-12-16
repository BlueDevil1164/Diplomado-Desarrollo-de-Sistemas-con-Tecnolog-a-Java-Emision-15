public class Factorial {
    public static double factorial (int n){
        double resultado = 0;
        System.out.println ("Entrando a calcular el factorial de "+n);
        if (n == 0)  // 0!  = 1
            resultado = 1;
        else  // n! = n * (n-1)!
            resultado = n * factorial (n -1);
        System.out.println (", que es "+ resultado);
        return resultado;

    }

    public static void main (String[] args){
        System.out.println ("5! = "+ factorial (5));
    }
}
