package dgtic.core.service.barco;

import dgtic.core.model.entities.BarcoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BarcoService {

    Page<BarcoEntity> buscarTodos(Pageable pageable);

    void guardar(BarcoEntity entity);

    void borrar(Integer id);

    BarcoEntity buscarPorId(Integer id);

}
