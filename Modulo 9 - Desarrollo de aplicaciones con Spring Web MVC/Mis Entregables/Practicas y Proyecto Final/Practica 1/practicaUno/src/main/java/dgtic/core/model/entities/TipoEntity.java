package dgtic.core.model.entities;

import dgtic.core.validator.NoEspacioNoVacio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tipo")
public class TipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tpo")
    private Integer idTipo;

    //@NotBlank //(message = "El nombre no debe ser vacío")
    @NoEspacioNoVacio
    @Length(min = 1, max = 30, message = "El nombre debe tener una longitud entre 1 y 30")
    @Column(name = "nombre")
    private String nombre;

}
