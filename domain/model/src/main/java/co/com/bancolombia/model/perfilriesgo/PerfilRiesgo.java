package co.com.bancolombia.model.perfilriesgo;
import lombok.*;
//import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PerfilRiesgo {
    private String id;
    private String idCliente;
    private Integer puntuacionRiesgo;
    private String nivelRiesgo;
    private String fechaEvaluacion;
    private List<FuenteDatos> fuentesDatos; // Usando una lista de enums

    public enum NivelRiesgo {
        BAJO, MEDIO, ALTO
    }

    public enum FuenteDatos {
        BURO_CREDITO,
        HISTORIAL_CREDITICIO_INTERNO,
        INGRESOS_DECLARADOS,
        EGRESOS_DECLARADOS,
        NIVEL_ENDEUDAMIENTO,
        HISTORIAL_TRANSACCIONAL,
        COMPORTAMIENTO_PAGO,
        REFERENCIAS_COMERCIALES,
        REFERENCIAS_PERSONALES,
    }
}
