package dgtic.core.modelo;

public class Persona {
    private String nombre;
    private Integer edad;
    private String correo;
    private TiendaElectronicos producto;

    public Persona(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo(String correo) {
        return nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TiendaElectronicos getProducto() {
        return producto;
    }

    public void setProducto(TiendaElectronicos producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                '}';
    }
}



