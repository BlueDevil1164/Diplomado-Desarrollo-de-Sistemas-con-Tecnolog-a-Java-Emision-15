public class Radio implements IcontrolesUniversales{
    private int volumen;
    private double frecuencia;
    public  void subeVolumen(){

    };
    public  void bajaVolumen(){
        // Baja el volumen mientras no baje de VOLUMENMINIMO
        this.volumen--;
        if (this.volumen < VOLUMENMINIMO)
            this.volumen=0;
    };
    public  boolean enciende(){

        return true;
    };
}
