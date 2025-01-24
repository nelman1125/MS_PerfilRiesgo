package co.com.bancolombia.jpa.perfilriesgo;

import co.com.bancolombia.jpa.helper.AdapterOperations;

import co.com.bancolombia.model.perfilriesgo.PerfilRiesgo;
import co.com.bancolombia.model.perfilriesgo.gateways.PerfilRiesgoRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PerfilRiesgoJPARepositoryAdapter extends AdapterOperations<PerfilRiesgo, PerfilRiesgoData, Long, PerfilRiesgoDataRepository>
        implements PerfilRiesgoRepository {

    public PerfilRiesgoJPARepositoryAdapter(PerfilRiesgoDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, PerfilRiesgo.class));
    }


    @Override
    public PerfilRiesgo savePerfilRiesgo(PerfilRiesgo perfilRiesgo) {
        return save(perfilRiesgo);
    }

    @Override
    public PerfilRiesgo getPerfilRiesgo(String id) {
        return findById(Long.valueOf(id));
    }

    @Override
    public List<PerfilRiesgo> getAllPerfilRiesgos() {
        return toList(repository.findAll());
    }

    @Override
    public PerfilRiesgo updatePerfilRiesgo(PerfilRiesgo perfilRiesgo) {
        return save(perfilRiesgo);
    }

    @Override
    public void deletePerfilRiesgo(String id) {
        repository.deleteById(Long.valueOf(id));
    }
}
