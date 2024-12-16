public class Estudiante extends Persona {
    private long matricula;
    private double edad; // Cambiamos a double la edad (en Persona es int)

    public Estudiante () {
        super();  // Ejecuta explícitamente el contructor Persona()
        this.setMatricula(12345);
    }
    public Estudiante (long matriculaEntrada){
        this();
        this.setMatricula(matriculaEntrada);
        // Aquí va a la bbdd a extraer la información
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
    public void setEdad(boolean mayorDeEdad) {
        if (mayorDeEdad)
            this.setEdad(18);
        else
            this.setEdad(10);
    }
    /* double getEdad() {  // Esta no se considera una sobrecarga válida
        return this.edad;
    }*/
    public void setEdad (double nuevaEdad){
        this.edad = nuevaEdad;
    }

    @Override
    public String toString() {
        return super.toString()
                + "--" +
                "matricula=" + matricula + " edad del estudiante de "+ this.edad;
    }
}
