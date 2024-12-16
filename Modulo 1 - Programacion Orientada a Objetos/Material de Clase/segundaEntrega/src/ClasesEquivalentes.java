public class ClasesEquivalentes {
    public static void imprime (Object x){
        System.out.println (x);
    }
    public static void main (String[] args){
        // Uso de Clases equivalentes
        Casa o1 = new Casa();
        CuentaBancaria o2 = new CuentaBancaria("12345");
        Docente o3 = new Docente();
        int entero = 100;   // Es variable, no objeto
        double doble = 99.8;

        imprime (o1);
        imprime (o2);
        imprime (o3);

        imprime (entero);  //??

        // Clases equivalentes
        // Byte, Short, Integer, Long
        // byte  short   int     long

        Integer objetoEntero;
        Long objetoLong;

        objetoEntero = 356;   // Autoboxing
        objetoLong = -987L;

        imprime(objetoEntero);
        imprime (objetoLong);

        System.out.println(objetoEntero+100);
        //                 Integer     +int
        //                  int        + int     Unboxing

        System.out.println (objetoEntero.doubleValue());
        entero = Integer.parseInt("12345");
        System.out.println(entero+10);
        System.out.println(Long.MIN_VALUE);

        //   Float, Double
        //   float  double

        //   Boolean
        //   boolean

        //   Character
        //    char
    }
}
