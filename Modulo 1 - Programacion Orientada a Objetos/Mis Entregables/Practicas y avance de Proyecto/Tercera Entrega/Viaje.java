public class Viaje extends Persona {

    //public Cliente(){}
        private int id;
        private Cliente cliente;
        private Asociado chofer;

        private double precio;

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        //this.precio = precio;
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    private String fechaHoraInicio;
        private String fechaHoraFinal;
        private int calificacion;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
