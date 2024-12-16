package mx.unam.dgtic.dto;

import jakarta.validation.constraints.*;

import java.util.Objects;

/**
* Alumno DTO es un objeto para manejar datos hacia el front
*
* @autor Alejandro Noyola
*/
public class AlumnoDTO {

    @NotNull(message = "La matricula no debe ser nula")
    @NotBlank(message = "La matricula no debe ser texto en blanco")
    private String matricula;

    @NotBlank(message = "El nombre del alumno no debe ser blanco")
    private String nombre;

    @NotBlank(message = "El apellido no debe ser blanco")
    private String paterno;

    //@Past(message = "La fecha debe ser en pasado")-> Entity
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}",
            message = "El formato de la fecha es del tipo AAAA-MM-DD")
    @NotBlank(message = "La fecha no puede estar en blanco")
    private String fnac;

    @Positive(message = "La estatura debe ser un valor positivo")
    @DecimalMin(value = "0.5", message = "La estatura no debe ser menor de 0.5 metros")
    @DecimalMax(value = "2.6", message = "La estatura no debe pasar de 2.6 metros")
    private double estatura;


    @NotNull(message = "Debes proporcionar un estado")
    @NotBlank(message = "Debes proporcionar un texto con el nombre del estado")
    private String estado;

    /**
     * Este constuctor genera un alumno vacio
     */
    public AlumnoDTO() {
    }

    /**
     * Este constructor......
     * @param matricula matricula del tipo String con formato '1A' @type String
     * @param nombre
     * @param paterno
     * @param fnac
     * @param estatura
     * @param estado
     */
    public AlumnoDTO(String matricula, String nombre, String paterno, String fnac, double estatura, String estado) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.paterno = paterno;
        this.fnac = fnac;
        this.estatura = estatura;
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este metodo retorna el apellido parteno de la instancia
     * @return @type String retorna un estring con el apellido paterno 
     */
    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "AlumnoDTO{" +
                "matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", fnac='" + fnac + '\'' +
                ", estatura=" + estatura +
                ", estado='" + estado + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoDTO alumnoDTO = (AlumnoDTO) o;
        return Objects.equals(matricula, alumnoDTO.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }

}
