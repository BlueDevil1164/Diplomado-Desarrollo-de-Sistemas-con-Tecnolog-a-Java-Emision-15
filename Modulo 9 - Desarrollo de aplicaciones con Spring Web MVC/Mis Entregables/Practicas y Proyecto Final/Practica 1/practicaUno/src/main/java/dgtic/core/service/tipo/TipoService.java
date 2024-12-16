package dgtic.core.service.tipo;

import dgtic.core.model.entities.TipoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TipoService {

    Page<TipoEntity> buscarTodos(Pageable pageable);

    void guardar(TipoEntity entity);

    void borrar(Integer id);

    TipoEntity buscarPorId(Integer id);

}
