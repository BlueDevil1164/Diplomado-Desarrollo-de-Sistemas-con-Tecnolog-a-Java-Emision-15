package unam.diplomado.pixup.disco.repository;

import unam.diplomado.pixup.disco.domain.Artista;

import java.util.Collection;
import java.util.Optional;

public interface ArtistaRepository {

    Collection<Artista> findAll();
    Optional<Artista> findById(Integer id);
}
