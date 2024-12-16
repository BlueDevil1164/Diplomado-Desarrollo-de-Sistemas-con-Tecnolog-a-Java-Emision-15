// Definición de una nueva enumeración
public enum Niveles {
    // Lista de valores posibles
    ANONIMO (0,0), BRONCE (3, 3), PLATA(5,6), ORO(10,12);

    // Atributos
    private int descuento;
    private int mesesSinIntereses;

    // Métodos
    /// COnstructor que reciba el descuento
    Niveles (int descuentoAplicable, int msi){
        this.descuento = descuentoAplicable;
        this.mesesSinIntereses = msi;
    }

    public int getDescuento(){
        return this.descuento;
    }
    public int getMesesSinIntereses() {
        return this.mesesSinIntereses;
    }
    @Override
    public String toString(){
        String resultado;
        resultado = " Nivel " + name();   // name() regresa el valor del nivel actual
        resultado +=" ("+this.getDescuento()+ "%)";
        return resultado;
    }
}  // FIn del enum
