package co.com.bancolombia.api;

import co.com.bancolombia.model.perfilriesgo.PerfilRiesgo;
import co.com.bancolombia.usecase.perfilriesgo.PerfilRiesgoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API Rest controller.
 * <p>
 * Example of how to declare and use a use case:
 * <pre>
 * private final MyUseCase useCase;
 *
 * public String commandName() {
 *     return useCase.execute();
 * }
 * </pre>
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final PerfilRiesgoUseCase perfilRiesgoUseCase;

    @PostMapping(path = "/perfilriesgo")
    public ResponseEntity<PerfilRiesgo> savePerfilRiesgo(@RequestBody PerfilRiesgo perfilRiesgo) {
        PerfilRiesgo p = perfilRiesgoUseCase.savePerfilRiesgo(perfilRiesgo);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping(path = "/obtenerperfilriesgo/{id}")
    public ResponseEntity<PerfilRiesgo> obtenerPerfil(@PathVariable("id") String id) {
        PerfilRiesgo p = perfilRiesgoUseCase.getPerfilRiesgo(id);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @PutMapping(path = "/actualizarperfilriesgo")
    public ResponseEntity<PerfilRiesgo> actualizarPerfil(@RequestBody PerfilRiesgo perfilRiesgo) {
        PerfilRiesgo p = perfilRiesgoUseCase.updatePerfilRiesgo(perfilRiesgo);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping(path = "/eliminarperfilriesgo/{id}")
    public ResponseEntity<Void> eliminarPerfil(@PathVariable("id") String id) {
        perfilRiesgoUseCase.deletePerfilRiesgo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/obtenerperfilriesgos")
    public ResponseEntity<PerfilRiesgo> obtenerPerfiles() {
        List<PerfilRiesgo> p = perfilRiesgoUseCase.getAllPerfilRiesgos();
        return new ResponseEntity(p, HttpStatus.CREATED);
    }

}
