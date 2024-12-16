package unam.diplomado.pixup.disco.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.disco.domain.Artista;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Singleton
public class JpaArtistaRepository implements  ArtistaRepository{

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Collection<Artista> findAll() {
        TypedQuery<Artista> query = entityManager.createQuery(
                "SELECT a FROM Artista a", Artista.class);
        return query.getResultList();
    }


    @Override
    public Optional<Artista> findById(Integer id) {
        TypedQuery<Artista> query = entityManager.createQuery(
                "SELECT a FROM Artista a WHERE a.id = :id", Artista.class
        );
        query.setParameter("id", id);
        if (query.getResultList().isEmpty()){
            return Optional.empty();
        }
        return Optional.of(query.getSingleResult());
        //Artista artista = entityManager.find(Artista.class, id);
        //return artista != null ? Optional.of(artista) : Optional.empty();
    }
}
