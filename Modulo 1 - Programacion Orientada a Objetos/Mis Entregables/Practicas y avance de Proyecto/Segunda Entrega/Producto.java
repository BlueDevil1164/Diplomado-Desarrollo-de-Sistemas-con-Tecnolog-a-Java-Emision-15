public class Producto {
    private String codigo;
    private String producto;
    private double precio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(){
        this.setCodigo("1");
        this.setProducto("Cuaderno");
        this.setPrecio(50.00);
    }

    /* public Producto (){
        this.setCodigo("1");
        this.setProducto("Cuaderno");
        this.setPrecio(50.00);

    }

    public Producto (){
        this.setCodigo("3");
        this.setProducto("Pluma");
        this.setPrecio(13.00);

    }

    public Producto (){
        this.setCodigo("5");
        this.setProducto("Regla");
        this.setPrecio(16.50);

    }
    */


}
