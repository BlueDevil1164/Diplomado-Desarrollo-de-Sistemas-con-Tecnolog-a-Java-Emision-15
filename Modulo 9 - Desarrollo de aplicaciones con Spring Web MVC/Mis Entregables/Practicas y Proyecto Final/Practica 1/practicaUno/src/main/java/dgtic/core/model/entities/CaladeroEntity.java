package dgtic.core.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "caladero")
public class CaladeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clo")
    private Integer idCaladero;

    @NotBlank
    @Length(min = 1, max = 100, message = "La dirección debe tener una longitud entre 1 y 100")
    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "extension")
    @Digits(integer = 3, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal extension;

}
