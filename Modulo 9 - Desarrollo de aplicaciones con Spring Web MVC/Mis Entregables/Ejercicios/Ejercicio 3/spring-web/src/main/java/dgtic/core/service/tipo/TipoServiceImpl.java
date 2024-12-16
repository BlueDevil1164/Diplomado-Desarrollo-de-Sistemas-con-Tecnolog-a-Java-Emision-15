package dgtic.core.service.tipo;

import dgtic.core.model.entities.TipoEntity;
import dgtic.core.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<TipoEntity> buscarTipo(Pageable pageable) {
        return tipoRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void guardar(TipoEntity tipoEntity) {
        tipoRepository.save(tipoEntity);
    }

}
