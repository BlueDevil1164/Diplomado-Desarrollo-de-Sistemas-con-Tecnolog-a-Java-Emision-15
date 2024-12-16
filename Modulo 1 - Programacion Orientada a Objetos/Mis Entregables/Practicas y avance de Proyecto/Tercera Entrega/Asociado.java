public class Asociado extends Persona {
    private int id;
    private byte antiguedad;
    private double calificacionPromedio;
    private int edad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        //this.id = id;
        if (id < 0) {
            throw new IllegalArgumentException("El id no puede ser negativo.");
        }
        this.id = id;
    }



    public byte getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(byte antiguedad) {
        if (antiguedad < 0) {
            throw new IllegalArgumentException("El numero de cliente  no puede ser negativo.");
        }
        this.antiguedad = antiguedad;
        }


    public double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(double calificacionPromedio) {
        //this.calificacionPromedio = calificacionPromedio;
        if (calificacionPromedio >=0 && calificacionPromedio <= 5)
            this.calificacionPromedio = calificacionPromedio;
    }

    @Override
    public String toString() {
        return "Asociado{" +
                "id=" + id +
                ", antiguedad=" + antiguedad +
                ", calificacionPromedio=" + calificacionPromedio +
                ", edad=" + edad +
                '}';
    }
}
