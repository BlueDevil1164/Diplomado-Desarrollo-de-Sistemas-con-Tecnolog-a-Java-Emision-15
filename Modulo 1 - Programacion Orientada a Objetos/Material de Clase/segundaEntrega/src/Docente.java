import java.util.Objects;

public class Docente extends Persona{
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
        if (this == o) return true;  // Hacen referencia al mismo objeto
        if (o == null || getClass() != o.getClass()) return false;

        Docente docente = (Docente) o;

        return getNumeroEmpleado() == docente.getNumeroEmpleado() ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroEmpleado(), getNivel());
    }
}
