public class Viaje {
    private int identificador;
    public Cliente cliente;
    public Asociado chofer;
    private String fechaHoraInicio;
    private String fechaHoraFinal;
    private double precio;
    private int calificación;

    public Viaje() {

    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        if (identificador >= 0)
            this.identificador = identificador;
    }

    public String getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(String fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public String getFechaHoraFinal() {
        return fechaHoraFinal;
    }

    public void setFechaHoraFinal(String fechaHoraFinal) {
        this.fechaHoraFinal = fechaHoraFinal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0)
            this.precio = precio;
    }

    public int getCalificación() {
        return calificación;
    }

    public void setCalificación(int calificación) {
        if (calificación >= 0 && calificación <= 5)
            this.calificación = calificación;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Asociado getChofer() {
        return chofer;
    }

    public void setChofer(Asociado chofer) {
        this.chofer = chofer;
    }

    @Override
    public String toString() {
        return "Viaje " + this.getIdentificador() +
                "\n\tCliente=" + this.cliente +
                "\n\tChofer=" + this.chofer +
                "\n\t$" + this.getPrecio() +
                "\t" + this.getCalificación() + " estrellas";

    }
}
