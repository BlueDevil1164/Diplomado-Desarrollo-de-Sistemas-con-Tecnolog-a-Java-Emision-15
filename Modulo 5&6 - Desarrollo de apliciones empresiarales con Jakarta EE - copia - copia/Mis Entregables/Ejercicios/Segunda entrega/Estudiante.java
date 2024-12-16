/*
 * Noyola Nazario Alejandro
 * Diplomado de desarrollo de Sistemas con Tecnología Java Emisión 15
 * Clase Estudiante
 * */
public class Estudiante extends Persona {
        private long matricula;

    public Estudiante(){
        super();
        this.setMatricula(12345);
    }

    public Estudiante (long matriculaEntrada){
        this();
        this.setMatricula(matriculaEntrada);
        // Aqui va ala BBDD a extraer la informacion
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public void setEdad(boolean mayorDeEdad){
        if (mayorDeEdad);
    }


    @Override
    public String toString() {
        return super.toString()
                + "--" +
                "matricula= " + matricula;
        /*return "Estudiante{" + this.getNombre() + "---" +
                "matricula=" + matricula +
                '}'; */
    }
}

