public class Television implements IcontrolesUniversales, Ibbdd{
    // Atributos
    private byte tamano;
    private String resolucion;
    private int volumen; //  0-100
    private int brillo;  //  0-30
    private double canal;
    private boolean encendido;


    private int volumenAnterior;
    // Métodos
    /// Constructores
    public Television () {
        this.setTamano(    (byte)0     );
        this.setResolucion("1920x1080");
        this.setVolumen(50);
        this.setBrillo(20);
        this.setCanal(0);   // {2,4,5,8,11,13}

        this.setEncendido(false);
    }

    /// Set y Get
    public byte getTamano() {
        return tamano;
    }

    public void setTamano(byte tamano) {
        this.tamano = tamano;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public int getVolumen() {
        return volumen;
    }

    private void setVolumen(int volumen) {
        if (volumen >=0 && volumen <=100)
            this.volumen = volumen;
    }

    public int getBrillo() {
        return this.brillo;
    }

    public void setBrillo(int brillo) {
        if (brillo >= 0 && brillo <=30)
            this.brillo = brillo;
    }

    public double getCanal() {
        return this.canal;
    }

    public void setCanal(double canal) {
        this.canal = canal;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }


    /// Los demás métodos
    public void subeVolumen(){
        this.setVolumen(this.getVolumen()+1);
    }
    public void bajaVolumen(){
        this.setVolumen(this.getVolumen()-1);
    }

    @Override
    public boolean enciende() {
        this.encendido();
        return this.isEncendido();
    }

    public void silencio(){

        if (this.getVolumen() == 0)  // Está en silencio
            this.setVolumen(volumenAnterior);  // Restablecemos el valor anterior
        else {
            volumenAnterior = this.getVolumen();  // Guardo el valor actual
            this.setVolumen(0);
        }
    }

    public void encendido (){
        this.setEncendido(!this.isEncendido());
    }


    public void imprimeStatus(){
        // Esté método sobreescribe el de la interface (método default)
        // El cuerpo del método
        System.out.println("Muestro el estatus de la televisión");
    }
    // toString()


    @Override
    public String toString() {
        return "Television{" +
                "tamano=" + tamano +
                ", resolucion='" + resolucion + '\'' +
                ", volumen=" + volumen +
                ", brillo=" + brillo +
                ", canal=" + canal +
                ", encendido=" + encendido +
                ", volumenAnterior=" + volumenAnterior +
                '}';
    }

    @Override
    public boolean altaBBDD() {
        return false;
    }

    @Override
    public boolean bajaBBDD() {
        return false;
    }
}
