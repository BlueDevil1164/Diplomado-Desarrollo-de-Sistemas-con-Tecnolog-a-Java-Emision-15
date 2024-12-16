package unam.diplomado.pixup.disco.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.domain.Disquera;

import java.util.Collection;
import java.util.Optional;

@Singleton
public class JpaDisqueraRepository implements DisqueraRepository{

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Collection<Disquera> findAll() {
        TypedQuery<Disquera> query = entityManager.createQuery(
                "SELECT d FROM Disquera d", Disquera.class);
        return query.getResultList();
    }


    @Override
    public Optional<Disquera> findById(Integer id) {
        TypedQuery<Disquera> query = entityManager.createQuery(
                "SELECT d FROM Disquera d WHERE d.id = :id", Disquera.class
        );
        query.setParameter("id", id);
        if (query.getResultList().isEmpty()){
            return Optional.empty();
        }
        return Optional.of(query.getSingleResult());
    }
}
