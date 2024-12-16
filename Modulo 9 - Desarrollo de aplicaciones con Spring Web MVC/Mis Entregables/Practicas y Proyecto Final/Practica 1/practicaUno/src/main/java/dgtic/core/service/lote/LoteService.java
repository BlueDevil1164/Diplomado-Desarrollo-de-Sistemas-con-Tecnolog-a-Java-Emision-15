package dgtic.core.service.lote;

import dgtic.core.model.entities.LoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoteService {

    Page<LoteEntity> buscarTodos(Pageable pageable);

    void guardar(LoteEntity entity);

    void borrar(Integer id);

    LoteEntity buscarPorId(Integer id);

}
