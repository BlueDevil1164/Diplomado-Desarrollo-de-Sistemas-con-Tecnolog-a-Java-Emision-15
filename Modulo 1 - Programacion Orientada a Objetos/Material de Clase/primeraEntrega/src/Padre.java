import java.util.Objects;

public class Padre {
    private int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Object  adulto () {
        return this.getEdad() >= 18;

    }
    public void metodo (){
        System.out.println("1");
    }

    @Override
    public String toString() {
        return "Padre{" +
                "edad=" + edad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Padre padre)) return false;
        return edad == padre.edad;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(edad);
    }
}
