package dgtic.core.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "comprador")
public class CompradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cpr")
    private Integer idComprador;

    @NotBlank
    @Length(min = 1, max = 15, message = "El nombre debe tener una longitud entre 1 y 15")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Length(min = 1, max = 15, message = "El apellidoPaterno debe tener una longitud entre 1 y 15")
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @NotBlank
    @Length(min = 1, max = 15, message = "El apellidoMaterno debe tener una longitud entre 1 y 15")
    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @NotBlank
    @Length(min = 1, max = 100, message = "La dirección debe tener una longitud entre 1 y 100")
    @Column(name = "direccion")
    private String direccion;

    @NotBlank
    @Length(min = 1, max = 80, message = "El correo debe tener una longitud entre 1 y 80")
    @Column(name = "correo")
    private String correo;

}
