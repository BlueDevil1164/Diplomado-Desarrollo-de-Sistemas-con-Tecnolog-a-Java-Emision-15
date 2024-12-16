package unam.diplomado.pixup.disco.repository;

import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.domain.Disquera;

import java.util.Collection;
import java.util.Optional;

public interface DisqueraRepository {

    Collection<Disquera> findAll();
    Optional<Disquera> findById(Integer id);
}
