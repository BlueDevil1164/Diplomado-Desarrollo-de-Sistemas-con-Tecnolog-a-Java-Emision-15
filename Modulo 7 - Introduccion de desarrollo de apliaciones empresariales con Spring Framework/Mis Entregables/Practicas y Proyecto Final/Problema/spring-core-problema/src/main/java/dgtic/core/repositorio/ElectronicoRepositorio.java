package dgtic.core.repositorio;

import dgtic.core.modelo.Electronico;

import java.util.List;

public interface ElectronicoRepositorio {
    List<Electronico> findAll();
    Electronico findById(Long id);
    void save(Electronico electronico);

}
