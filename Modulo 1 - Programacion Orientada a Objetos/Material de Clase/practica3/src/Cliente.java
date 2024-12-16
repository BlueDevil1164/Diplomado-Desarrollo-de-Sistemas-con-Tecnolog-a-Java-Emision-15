public class Cliente extends Persona {
    private int numeroCliente;
    private byte nivel;

    public Cliente() {
        super();
        this.setNumeroCliente(0);
        this.setNivel((byte)1);
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        if (numeroCliente >= 0)
            this.numeroCliente = numeroCliente;
    }

    public byte getNivel() {
        return nivel;
    }

    public void setNivel(byte nivel) {
        if (nivel >= 1 && nivel <=3)
            this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Cliente " + this.getNumeroCliente() + ": " +
                this.getNombre() +
                ", nivel=" +  this.getNivel();
    }
}