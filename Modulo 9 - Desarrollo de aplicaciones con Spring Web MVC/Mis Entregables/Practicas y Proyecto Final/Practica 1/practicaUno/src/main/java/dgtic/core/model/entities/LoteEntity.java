package dgtic.core.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "lote")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lte")
    private Integer idLote;

    @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private LocalDateTime fecha;

    @Column(name = "kilos")
    @Min(value = 1)
    @Max(value = 999)
    private Integer kilos;

    @Column(name = "numero_cajas")
    @Min(value = 1)
    @Max(value = 999)
    private Integer numCajas;

    @Column(name = "precio_kilo_salida")
    @Digits(integer = 3, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal precioKiloSalida;

}
