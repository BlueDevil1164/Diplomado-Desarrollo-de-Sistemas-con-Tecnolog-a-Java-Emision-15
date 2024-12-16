package unam.diplomado.pixup.disco.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.domain.Disco;

import java.util.List;
import java.util.Optional;

@Singleton
public class JpaDiscoRepository implements DiscoRepository {

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Disco save(Disco disco) {
        if (disco.getId() == null){
            // Si el disco no tiene ID, se persiste como un nuevo registro
            entityManager.persist(disco);
            return disco;
        }else {
            //si el disco tiene ID, se actualiza merge
            return entityManager.merge(disco);
        }
        //return null;
    }

    @Override
    public Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista) {
        TypedQuery<Disco> query = entityManager.createQuery(
                "SELECT d FROM Disco d WHERE d.titulo = :titulo AND d.artista.id = :idArtista", Disco.class
        );
        query.setParameter("titulo", titulo);
        query.setParameter("idArtista", idArtista);
        if(query.getResultList() == null || query.getResultList().isEmpty()){
            return Optional.empty();
        }
        return Optional.of(query.getSingleResult());

    }

    @Override
    public Optional<Disco> findByImage(String image) {
        TypedQuery<Disco> query = entityManager.createQuery(
                "SELECT d FROM Disco d WHERE d.image = :image", Disco.class
        );
        query.setParameter("image", image);
        if (query.getResultList() == null || query.getResultList().isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(query.getSingleResult());
    }

}
