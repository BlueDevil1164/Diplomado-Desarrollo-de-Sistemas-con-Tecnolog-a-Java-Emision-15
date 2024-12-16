package dgtic.core.repository;

import dgtic.core.model.entities.TipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoRepository extends JpaRepository<TipoEntity, Integer> {

    @Query("SELECT t FROM tipo t where t.nombre like %?1%")
    public List<TipoEntity> findByNombre(String nombre);

}
