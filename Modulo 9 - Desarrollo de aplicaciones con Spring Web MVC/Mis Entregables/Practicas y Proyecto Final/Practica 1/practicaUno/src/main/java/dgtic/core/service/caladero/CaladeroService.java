package dgtic.core.service.caladero;

import dgtic.core.model.entities.CaladeroEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CaladeroService {

    Page<CaladeroEntity> buscarTodos(Pageable pageable);

    void guardar(CaladeroEntity entity);

    void borrar(Integer id);

    CaladeroEntity buscarPorId(Integer id);

}
