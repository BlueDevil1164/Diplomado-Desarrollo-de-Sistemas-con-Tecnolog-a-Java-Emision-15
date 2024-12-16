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
@Entity(name = "barco")
public class BarcoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bco")
    private Integer idBarco;

    @NotBlank
    @Length(min = 1, max = 50, message = "El nombre debe tener una longitud entre 1 y 50")
    @Column(name = "nombre")
    private String nombre;

}
