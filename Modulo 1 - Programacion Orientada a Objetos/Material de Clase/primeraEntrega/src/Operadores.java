// Ejemplo de diversos operadores en Java
// Carlos Eligio

public class Operadores {
    public static void main (String[] args){
        // Operadores aritméticos

        System.out.println (10+3);  // Suma
        System.out.println (10-3);  // Resta
        System.out.println (10*3);  // Multiplicación
        System.out.println ((double)10 / 3);  // División
        System.out.println ((double)(10 / 3));  // División

        System.out.println (10%3);  // Residuo ("módulo")

        // Asignación
        int numero;
        numero = 10;

        // Asignación compuesta
        numero += 3;    // numero = numero + 3;
        ///   !!!!! numero =- 3;
        System.out.println (numero);
        numero -= 100;    // numero = numero - 100;
        System.out.println (numero);

        // ++ y ---
        numero = numero +1;  // INcrementa en uno a numero
        numero += 1;   // Ídem

        numero = 87;
        numero++;      // Ídem
        System.out.println ("Número incrementado con variable++;"+numero);
        ++numero;      // Ídem
        System.out.println ("Número incrementado con ++variable;"+numero);

        System.out.println ("Número incrementado con variable++"+numero++);
        System.out.println (numero);


        System.out.println ("Número incrementado con ++variable"+  ++numero);
        System.out.println (numero);

        numero = 100;
        System.out.println (numero);

        ///   numero = numero++;
        numero--;
        System.out.println (numero);  // ¿QUé valor despliega?

        // Operadores de comparación
        //  >   <    >=    <=   ==     !=

        System.out.println (numero > 99);
        System.out.println (numero < 99);
        System.out.println (numero >= 99);
        System.out.println (numero <= 99);

        System.out.println (numero == 99);
        System.out.println (numero != 99);

        // Operadores lógicos
        // and (&& y &), or (|| y |) , not (!)

        boolean pcd= true;
        int edad = 20;

        System.out.println ("¿Tiene atención preferencial?"+( (pcd == true) ||   (edad++ >=65)     ));

        // Operador terciario (if inline)
        System.out.println (edad >= 18?"Ya puedes votar": "Aún no eres mayor de edad, felicidades");

        //   cebolla-catsup-mostaza
        //      0       0       0       0
        //      1       0       0       4
        //      1       1       1       7
        //      1       0       1       5

        byte hamburguesa = 5;
        System.out.println ("¿Tiene Cebolla?" + ( hamburguesa & 4) );
        System.out.println ("¿Tiene CATSUP?" + ( hamburguesa & 2) );

        System.out.println ("Más catsup"+ (hamburguesa | 2));


    }
}
