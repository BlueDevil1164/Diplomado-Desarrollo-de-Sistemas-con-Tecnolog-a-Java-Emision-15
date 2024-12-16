public class PruebaHerencia {
    public static void main(String[] args) {
        Padre p = new Padre();
        Hijo h = new Hijo();
        System.out.println(p+ "--"+p.adulto()+ "++" );
        System.out.println((p instanceof Padre) + "--"+ (p instanceof Hijo));
        System.out.println(p.getClass() + "++"+ h.getClass());
        p.metodo();
        System.out.println(h + "--"+h.adulto());
        System.out.println((h instanceof Padre) + "--"+ (h instanceof Hijo));
        h.metodo();
        h.metodo(100);

    }
}
