public class Personaje {
    private String nombre;
    private int vida;  // 0-100
    private boolean vivo;
    private int fuerza;

    public Personaje(){
        this.setNombre ("Desconocido");
        this.setVida (100);
        this.setFuerza (1);
        this.setVivo (true);
    }
    public Personaje (String nombre){
        this();
        // Aquí debería de ir a la BBDD por la información...
        if (nombre.equals ("Ryu")){
            this.setNombre (nombre);
            this.setVida (50);
            this.setFuerza (3);
        } else if (nombre.equals ("Ken")) {
                this.setNombre (nombre);
                this.setVida (80);
                this.setFuerza (5);
            }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        if (vida >=0 && vida <=100)
            this.vida = vida;
        if (this.getVida() == 0)
            this.setVivo(false);
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public boolean isVivo() {
        return vivo;
    }
    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
    public void ataca (Personaje oponente){
        oponente.setVida(oponente.getVida()-this.getFuerza());
    }
    @Override
    public String toString() {
        return nombre + "(" + vida + ")";
    }
}
