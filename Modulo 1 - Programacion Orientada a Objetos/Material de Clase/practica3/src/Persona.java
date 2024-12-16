public class Persona implements Comparable{
    private String nombre;
    private byte edad;
    private char genero;

    public Persona (){
        this.setNombre("Desconocido");
        this.setEdad((byte)10);
        this.setGenero('D');
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        if (edad >= 10)
            this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        String validos = "FMDN";  // Femenino, Masculino, Desconocido, No quiso decirlo
        if (validos.indexOf(genero) >= 0)
            this.genero = genero;
    }

    @Override
    public int compareTo(Object o) {
        return 0;

    }
}