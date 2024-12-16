public class Persona {
    private String nombre;
    private int edad;
    private String domicilio;
    private char genero;

    public Persona() {
        this.setNombre("indefinido");
        this.setEdad(0);
        this.setDomicilio("desconocido");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public final void setEdad(int edad) {
        if (this.edad > 16)
            this.edad = edad;
    }

    public boolean adulto (){
        return this.getEdad()>=18;  // Regresa true si la persona (estudiante) es un adulto
    }
    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '(' +
                 edad +
                ") domicilio='" + domicilio + '\'' +
                '}';
    }
}
