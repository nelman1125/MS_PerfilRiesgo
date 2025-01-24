package co.com.bancolombia.model.perfilriesgo.gateways;

import co.com.bancolombia.model.perfilriesgo.PerfilRiesgo;

import java.util.List;

public interface PerfilRiesgoRepository {
    PerfilRiesgo savePerfilRiesgo(PerfilRiesgo perfilRiesgo);

    PerfilRiesgo getPerfilRiesgo(String id);

    List<PerfilRiesgo> getAllPerfilRiesgos();

    PerfilRiesgo updatePerfilRiesgo(PerfilRiesgo perfilRiesgo);

    void deletePerfilRiesgo(String id);
}
