/*
* Noyola Nazario Alejandro
* 18/05/24
* Creacion de clase television
* */
public class Television implements IcontrolesUniversales {

    // Atributos
    private final short tamano; // pulgadas
    private String resolucion;
    private byte volumen; // 0 a 100
    private int brillo; // 0 a 50
    private double canal;
    private boolean encendido;

    // Atributo auxiliar para funcionalidad unmute
    private byte volumenPrevio;

    // Métodos

    // Constructores
    public Television() {
        this.tamano = (short) 32;
        this.setResolucion("1920x1080");
        this.setVolumen((byte) 20);
        this.setBrillo(10);
        this.setCanal(1.1);
        this.setEncendido(false);
    }

    // Getters y Setters
    public short getTamano() {
        return this.tamano;
    }

    // No se puede modificar el tamaño de una televisión
    // public void setTamano(short tamano) {
    //     this.tamano = tamano;
    // }

    public String getResolucion() {
        return this.resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public byte getVolumen() {
        return this.volumen;
    }

    private void setVolumen(byte volumen) {
        if (volumen >= 0 && volumen <= 100) {
            this.volumen = volumen;
        }
    }

    public int getBrillo() {
        return this.brillo;
    }

    public void setBrillo(int brillo) {
        if (volumen >= 0 && volumen <= 50) {
            this.brillo = brillo;
        }
    }

    public double getCanal() {
        return this.canal;
    }

    private void setCanal(double canal) {
        this.canal = canal;
    }

    public boolean isEncendido() {
        return this.encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    // Otros métodos
    public void encenderApagar() {
        this.setEncendido(!this.isEncendido());
    }

    public boolean enciendeABC() {
        this.encenderApagar();
        return this.isEncendido();
    }

    @Override
    public boolean enciende() {
        this.encenderApagar();
        return this.isEncendido();
    }

    public void imprimeStatus() {
        // Este metodo sobreescribe el de la interface (metodo default)
        System.out.println(" Estatus actual de la Television");
    }

    @Override
    public void bajaVolumen() {
        this.setVolumen((byte) (this.getVolumen() - 1));
    }

    @Override
    public void subeVolumen() {
        this.setVolumen((byte) (this.getVolumen() + 1));
    }

    public void silenciarDesilenciar() {
        if (this.getVolumen() > 0) {
            this.volumenPrevio = this.getVolumen();
            this.setVolumen((byte) 0);
        } else {
            this.setVolumen(this.volumenPrevio);
        }
    }

    public void cambiarCanal(double canal) {
        this.setCanal(canal);
    }

    public String toString() {
        return "Television: {" +
                "tamano=" + this.getTamano() +
                ", resolucion='" + this.getResolucion() + '\'' +
                ", volumen=" + this.getVolumen() +
                ", brillo=" + this.getBrillo() +
                ", canal=" + this.getCanal() +
                ", encendido=" + this.isEncendido() +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Hacemos uso del metodo mein de la prueba de televiosres para una Prueba de la clase Television");
        System.out.println("----------------------------------------------------------------------------------------------------");
        Television tv1 = new Television();
        System.out.println(tv1);
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(" EncenderApagar");
        tv1.encenderApagar();
        System.out.println(tv1);
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(" SubirVolumen");
        tv1.subeVolumen();
        System.out.println(tv1);
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(" SilenciarDesilenciar");
        tv1.silenciarDesilenciar();
        System.out.println(tv1);
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(" SilenciarDesilenciar");
        tv1.silenciarDesilenciar();
        System.out.println(tv1);
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(" CambiarCanal: 2.1");
        tv1.cambiarCanal(2.1);
        System.out.println(tv1);
        System.out.println("----------------------------------------------------------------------------------------------------");
        tv1.imprimeStatus();

    }

}