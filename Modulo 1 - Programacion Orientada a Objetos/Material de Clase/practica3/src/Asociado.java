public class Asociado extends Persona{
    private int id;
    private byte antiguedad;
    private double calificacionPromedio;

    public Asociado() {
        super();
        this.setId(1);
        this.setAntiguedad((byte)0);
        this.setCalificacionPromedio(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0)
            this.id = id;
    }

    public byte getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(byte antiguedad) {
        if (antiguedad >=0 )
            this.antiguedad = antiguedad;
    }

    public double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(double calificacionPromedio) {
        if (calificacionPromedio >= 0 && calificacionPromedio <= 5)
            this.calificacionPromedio = calificacionPromedio;
    }

    @Override
    public String toString() {
        return "Asociado " + this.getId() + ": "
                + this.getNombre() +
                " (" + this.getGenero() + ")." +
                this.getCalificacionPromedio() + "extrellas";
    }
}
