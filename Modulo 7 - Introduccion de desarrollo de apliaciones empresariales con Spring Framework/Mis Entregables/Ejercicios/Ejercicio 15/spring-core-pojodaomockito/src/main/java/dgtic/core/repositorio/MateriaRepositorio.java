package dgtic.core.repositorio;

import dgtic.core.modelo.Materia;

import java.util.List;

public interface MateriaRepositorio {
    List<Materia> findAll();
    Materia findById(Long id);
    void save(Materia materia);
}
