package dgtic.core.service.barco;

import dgtic.core.model.entities.BarcoEntity;
import dgtic.core.repository.BarcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BarcoServiceImpl implements BarcoService {

    @Autowired
    private BarcoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<BarcoEntity> buscarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional
    public void guardar(BarcoEntity entity) {
        repository.save(entity);

    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public BarcoEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }


}
