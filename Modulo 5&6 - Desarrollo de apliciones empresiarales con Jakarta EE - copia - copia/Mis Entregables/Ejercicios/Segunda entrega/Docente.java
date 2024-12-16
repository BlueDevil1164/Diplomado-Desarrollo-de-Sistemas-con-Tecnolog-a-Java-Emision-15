/*
 * Noyola Nazario Alejandro
 * Diplomado de desarrollo de Sistemas con Tecnología Java Emisión 15
 * Clase Docente
 * */

import java.util.Objects;

public class Docente extends  Persona{
    private int numeroEmpleado;
    private byte antiguedad;
    private char nivel;

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public byte getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(byte antiguedad) {
        this.antiguedad = antiguedad;
    }

    public char getNivel() {
        return nivel;
    }

    public void setNivel(char nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Docente docente)) return false;
        return numeroEmpleado == docente.numeroEmpleado && nivel == docente.nivel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroEmpleado, nivel);
    }
}
