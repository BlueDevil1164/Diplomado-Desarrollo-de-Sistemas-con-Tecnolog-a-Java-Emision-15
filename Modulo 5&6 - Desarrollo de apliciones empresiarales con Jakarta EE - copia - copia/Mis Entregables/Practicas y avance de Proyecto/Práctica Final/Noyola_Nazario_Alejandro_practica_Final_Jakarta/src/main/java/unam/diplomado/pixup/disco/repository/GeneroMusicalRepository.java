package unam.diplomado.pixup.disco.repository;

import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

import java.util.Collection;
import java.util.Optional;

public interface GeneroMusicalRepository {

    Collection<GeneroMusical> findAll();
    Optional<GeneroMusical> findById(Integer id);

}
