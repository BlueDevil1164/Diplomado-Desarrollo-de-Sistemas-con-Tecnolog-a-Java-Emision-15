public class Hijo extends Padre{
    public int edad;
    public String adulto () {
        return (this.getEdad() >= 18)?"Adulto":"Menor de edad";
    }
    public void metodo (int a){
        System.out.println("1"+a);
    }

}
