//Ejemplo de diversos  operadores en java
//Alejandro Noyola

public class Operadores {
    public static void main (String[] args){
        //Operadores aritmeticos

        System.out.println ("Suma de 10+3 =");
        System.out.println (10+3); //Suma
        System.out.println ("------------------------------------------");
        System.out.println ("Resta de 10-3 =");
        System.out.println (10-3); //Resta
        System.out.println ("------------------------------------------");
        System.out.println ("Multiplicacion de 10*3 =");
        System.out.println (10*3); //Multiplicacion
        System.out.println ("------------------------------------------");
        System.out.println ("Division de 10.0/3 =");
        System.out.println (10.0/3); //Dvision
        System.out.println ("------------------------------------------");
        System.out.println ("Modulo(Residuo) de 10%3 =");
        System.out.println (10%3); //residuo(modulo)
        System.out.println ("------------------------------------------");

        //Asignacion
        int numero;
        numero = 10;

        //Asignacion compuesta
        numero += 3;      //numero = numero + 3;
        ///    !!!!! numero =-3

        System.out.println ("Asignacion Compuesta ");
        System.out.println (numero);
        numero -=100;      // numero = numero - 100
        System.out.println (numero); //suma
        System.out.println ("------------------------------------------");


        System.out.println ("Incremento de numeros: ");
        // ++ y ---
        numero = numero +1;   //incrementa en uno un numero
        numero += 1;

        numero = 87;
        numero++;       //Idem
        System.out.println ("Numero incrementado con variable++;"+numero);
        ++numero;       //Idem
        System.out.println ("Numero incrementado con ++variable;"+numero);

        System.out.println ("Numero incrementado con ++variable;"+numero++);
        System.out.println (numero);

        System.out.println ("Numero incrementado con ++variable;"+ ++numero);
        System.out.println (numero);


        System.out.println ("------------------------------------------");

        numero  = 100;
        System.out.println (numero);

        numero  = numero++;
        System.out.println (numero); //¿Que valor despliega?
        System.out.println ("------------------------------------------");
        System.out.println ("Evaluaciones de operadores comparativos con el numero 99 y la variable numero asignado con 100: ");
        System.out.println ("------------------------------------------");
        System.out.println ("Operadores de comparacion:  >   <    >=    <=    ==    !=");

        //Operadores de comparacion
        // >   <    >=    <=    ==    !=
        System.out.println ("------------------------------------------");
        System.out.println ("Numero > 99?");
        System.out.println (numero > 99);
        System.out.println ("------------------------------------------");
        System.out.println ("Numero < 99?");
        System.out.println (numero < 99);
        System.out.println ("------------------------------------------");
        System.out.println ("Numero >= 99?");
        System.out.println (numero >= 99);
        System.out.println ("------------------------------------------");
        System.out.println ("Numero <= 99?");
        System.out.println (numero <= 99);
        System.out.println ("------------------------------------------");
        System.out.println ("Numero == 99?");
        System.out.println (numero == 99);
        System.out.println ("------------------------------------------");
        System.out.println ("Numero != 99?");
        System.out.println (numero != 99);

        //Operadores logicos
        // and (&& y &), or (|| y |), not (!)

        System.out.println ("------------------------------------------");
        System.out.println ("Evaluamos en un simple ejemplo de como de ser mayor de edad(+65):");
        System.out.println (" ");
        boolean pcd= true;
        int edad = 20;
        int edad1 = 17;
        System.out.println ("Ejemplo con una variable edad =20 y el operador AND(&&)");
        //Operadores logicos
        // and (&& y &), or (|| y |), not (!)
        System.out.println ("¿Tiene Atencion preferencial? "+ (pcd == true  && (edad >=65)    ));

        System.out.println ("------------------------------------------");
        System.out.println ("Ejemplo con una variable edad = 17 y el operador OR(||)");
        System.out.println ("¿Tiene Atencion preferencial? "+ (pcd == true  || (edad1 >=65)    ));



        System.out.println ("------------------------------------------");
        System.out.println ("Ejemplo con una variable edad =20 y el operador >= para dar una respuesta si es mayor de edad ");

        System.out.println (edad >=18?"Ya puedes votar":"Aun no eres mayor de edad");

        System.out.println ("------------------------------------------");
        System.out.println ("Ejemplo con una variable edad =17 y el operador >= para dar una respuesta si es mayor de edad ");
        System.out.println (edad1 >=18?"Ya puedes votar":"Aun no eres mayor de edad");

        System.out.println ("------------------------------------------");
        /*cebolla-catsup-mostaza
             0       0       0       0
             1       0       0       4
             1       0       1       5
             1       1       1       7
        */


        System.out.println ("Variables tipo byte para una Hamburguesa de valor 5: ");
    byte hamburgesa = 5;
        System.out.println ("Tiene Cebolla ?" + (hamburgesa & 4));
        System.out.println ("Tiene Catsup ?" + (hamburgesa & 2));

        System.out.println ("Mas Catsup ?" + (hamburgesa | 2));

        System.out.println ("------------------------------------------");

    }
}
