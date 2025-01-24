package co.com.bancolombia.jpa.perfilriesgo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name="perfil_riesgo", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PerfilRiesgoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id" )
    private Long id;

    @Column(name ="id_cliente" )
    private String idCliente;

    @Column(name ="puntuacion_riesgo" )
    private Integer puntuacionRiesgo;

    @Column(name ="nivel_riesgo" )
    private String nivelRiesgo;

    @Column(name ="fecha_evaluacion" )
    private String fechaEvaluacion;


    @ElementCollection
    @Column(name = "fuente_dato") // Nombre de la columna en la tabla de unión
    private List<String> fuentesDatos;


}