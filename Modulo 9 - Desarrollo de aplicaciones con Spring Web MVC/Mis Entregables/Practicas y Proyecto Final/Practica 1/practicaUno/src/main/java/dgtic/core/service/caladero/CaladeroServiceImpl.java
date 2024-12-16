package dgtic.core.service.caladero;

import dgtic.core.model.entities.CaladeroEntity;
import dgtic.core.repository.CaladeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CaladeroServiceImpl implements CaladeroService {

    @Autowired
    private CaladeroRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<CaladeroEntity> buscarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional
    public void guardar(CaladeroEntity entity) {
        repository.save(entity);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CaladeroEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

}
