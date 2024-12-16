package unam.diplomado.pixup.disco.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.disco.domain.Disquera;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class JpaGeneroMusicalRepository implements GeneroMusicalRepository {
    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;


    @Override
    public Collection<GeneroMusical> findAll() {
        TypedQuery<GeneroMusical> query = entityManager.createQuery(
                "SELECT gm FROM GeneroMusical gm", GeneroMusical.class);
        return query.getResultList();
    }


    @Override
    public Optional<GeneroMusical> findById(Integer id) {
        TypedQuery<GeneroMusical> query = entityManager.createQuery(
                "SELECT gm FROM GeneroMusical gm WHERE gm.id = :id", GeneroMusical.class
        );
        query.setParameter("id", id);
        if (query.getResultList().isEmpty()){
            return Optional.empty();
        }
        return Optional.of(query.getSingleResult());
    }
}
