package co.com.bancolombia.usecase.perfilriesgo;

import co.com.bancolombia.model.perfilriesgo.PerfilRiesgo;
import co.com.bancolombia.model.perfilriesgo.gateways.PerfilRiesgoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PerfilRiesgoUseCase {
    private final PerfilRiesgoRepository perfilRiesgoRepository;


    public PerfilRiesgo savePerfilRiesgo(PerfilRiesgo perfilRiesgo) {
        return perfilRiesgoRepository.savePerfilRiesgo(perfilRiesgo);
    }

    public PerfilRiesgo getPerfilRiesgo(String id) {
        return perfilRiesgoRepository.getPerfilRiesgo(id);
    }

    public List<PerfilRiesgo> getAllPerfilRiesgos() {
        return perfilRiesgoRepository.getAllPerfilRiesgos();
    }

    public PerfilRiesgo updatePerfilRiesgo(PerfilRiesgo perfilRiesgo) {
        return perfilRiesgoRepository.updatePerfilRiesgo(perfilRiesgo);
    }

    public void deletePerfilRiesgo(String id) {
        perfilRiesgoRepository.deletePerfilRiesgo(id);
    }


}
