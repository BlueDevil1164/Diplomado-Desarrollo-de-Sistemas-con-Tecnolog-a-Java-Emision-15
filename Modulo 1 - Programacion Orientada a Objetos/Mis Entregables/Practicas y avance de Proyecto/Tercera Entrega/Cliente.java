public class Cliente extends Persona{
    private int numeroDeCliente;
    private byte nivel;

    public int getNumeroDeCliente() {
        return numeroDeCliente;
    }

    public void setNumeroDeCliente(int numeroDeCliente) {
        if (numeroDeCliente < 0) {
            throw new IllegalArgumentException("El numero de cliente  no puede ser negativo.");
        }
        this.numeroDeCliente = numeroDeCliente;
    }

    public byte getNivel() {
        return nivel;
    }

    public void setNivel(byte nivel) {
        if (nivel >=0 && nivel <= 3)
            this.nivel = nivel;
    }

    /*public Cliente(){
        this.setNumeroDeCliente(1234);
        this.setNivel(1);

    }*/

    @Override
    public String toString() {
        return "Cliente{" +
                "numeroDeCliente=" + numeroDeCliente +
                ", nivel=" + nivel +
                '}';
    }
}
