public class Persona {
    private String nombre; // Longitud de al menos 7 caracteres
    private byte edad;     // Mayores de 10 años
    private char genero;   // Femenino, Masculino, Desconocido, No quiso decirlo

    public Persona (){
        this.setNombre("Desconocido");
        this.setEdad((byte)10);
        this.setGenero('D');
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre.length() >=7 )
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
}