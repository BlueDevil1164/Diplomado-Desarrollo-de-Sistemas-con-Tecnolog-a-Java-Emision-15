package dgtic.core.service.comprador;

import dgtic.core.model.entities.CompradorEntity;
import dgtic.core.repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompradorServiceImpl implements CompradorService {

    @Autowired
    private CompradorRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<CompradorEntity> buscarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional
    public void guardar(CompradorEntity entity) {
        repository.save(entity);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CompradorEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

}
