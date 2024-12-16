public class OtraGenerica <T, S>{
    public T atributo;

    public void despliega (S parametro){
        System.out.println(this.atributo);
        System.out.println(parametro);
        System.out.println("--------");
    }
}
