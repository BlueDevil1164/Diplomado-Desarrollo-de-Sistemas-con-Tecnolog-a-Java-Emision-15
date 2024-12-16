package entidades;

import constantes.TipoPago;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class Pago {
    private int id;
    private Date fecha;
    private String origen;
    private String destino;
    private TipoPago tipoPago;
    private String estado;
    private Double monto;
}
