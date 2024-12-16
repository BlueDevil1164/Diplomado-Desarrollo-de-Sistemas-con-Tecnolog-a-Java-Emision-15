package dgtic.modelo;

public class Profesor {

    private String nombre;
    private Responsabilidades responsabilidades;

    // Constructor
    public Profesor() {
        responsabilidades = new Responsabilidades();
    }

    // Getter para el nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para responsabilidades
    public Responsabilidades getResponsabilidades() {
        return responsabilidades;
    }

    // Setter para responsabilidades
    public void setResponsabilidades(Responsabilidades responsabilidades) {
        this.responsabilidades = responsabilidades;
    }
}

