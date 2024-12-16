/*
 * Noyola Nazario Alejandro
 * Diplomado de desarrollo de Sistemas con Tecnología Java Emisión 15
 * Clase Persona
 * */
public class Persona {
    private String nombre;
    private int edad;
    private String domicilio;
    private char genero;

    public Persona(){
        this.setNombre("indefinido");
        this.setEdad(0);
        this.setDomicilio("Mikasa");
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

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public boolean adulto (){
        return this.getEdad()>=18;  // Regresa true si la persona (estudiante) es un adulto
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }
}
