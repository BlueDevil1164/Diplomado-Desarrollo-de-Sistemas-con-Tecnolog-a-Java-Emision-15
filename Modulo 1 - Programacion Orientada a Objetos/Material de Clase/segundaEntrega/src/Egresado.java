public final class Egresado extends Estudiante {
    public int generacion;

    public Egresado() {
        this.generacion = 2000;
    }

    /* Si setEdad se definió como final en la superclase, ya no podríamos cambiar el comportamiento
    en alguna de sus subclases
    public void setEdad(int edad) {


    }*/
    @Override
    public String toString() {
        return "EGRESADO "+super.toString() + "\n{" +
                "generacion=" + generacion +
                '}';
    }
}
