package co.com.bancolombia.jpa.perfilriesgo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

public interface PerfilRiesgoDataRepository extends CrudRepository<PerfilRiesgoData, Long>, QueryByExampleExecutor<PerfilRiesgoData> {
    Optional<PerfilRiesgoData> findByIdCliente(String numeroIdentificacion);
}