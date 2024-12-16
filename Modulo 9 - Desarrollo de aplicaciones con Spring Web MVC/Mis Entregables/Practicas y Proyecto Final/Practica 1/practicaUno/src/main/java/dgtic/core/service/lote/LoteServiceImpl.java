package dgtic.core.service.lote;

import dgtic.core.model.entities.LoteEntity;
import dgtic.core.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoteServiceImpl implements LoteService {

    @Autowired
    private LoteRepository loteRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<LoteEntity> buscarTodos(Pageable pageable) {
        return loteRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void guardar(LoteEntity entity) {
        loteRepository.save(entity);

    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        loteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public LoteEntity buscarPorId(Integer id) {
        return loteRepository.findById(id).orElse(null);
    }

}
