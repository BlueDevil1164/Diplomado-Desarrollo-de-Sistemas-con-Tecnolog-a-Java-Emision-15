package unam.diplomado.pixup.disco.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.pixup.disco.domain.*;
import unam.diplomado.pixup.disco.repository.ArtistaRepository;
import unam.diplomado.pixup.disco.repository.DiscoRepository;
import unam.diplomado.pixup.disco.repository.DisqueraRepository;
import unam.diplomado.pixup.disco.repository.GeneroMusicalRepository;

import java.util.Optional;

@Stateless
public class DiscoServiceImpl implements  DiscoService{
    @Inject
    private DisqueraRepository disqueraRepository;
    @Inject
    private ArtistaRepository artistaRepository;
    @Inject
    private GeneroMusicalRepository generoMusicalRepository;
    @Inject
    private DiscoRepository discoRepository;

    @Override
    @Transactional(value=Transactional.TxType.REQUIRED)
    public Disco altaDisco(Disco disco) {
        // validacion usuario duplicado
        Optional<Disco> discoExistente =
                discoRepository.findByTituloAndArtista(disco.getTitulo(), disco.getArtista().getId());
        System.out.println(discoExistente);
        if (discoExistente.isPresent()){
            System.out.println("Se encontro el mismo disco");
            throw new DiscoAlreadyExistsException(disco.getTitulo(), disco.getArtista().getId());
        }


        //TIENES QUE VALIDAR QUE NO EXISTA UN DISCO CON LA MISMA IMAGEN
        Optional<Disco> discoImagen =
                discoRepository.findByImage(disco.getImagen());
        System.out.println(discoImagen);
        if (discoImagen.isPresent()){
            System.out.println("Se encontro la misma imagen");
            throw new DiscoImageAlreadyExistsException(disco.getImagen());
        }


        // validacion existencia disquera
        Optional<Disquera> disquera =
                disqueraRepository.findById(disco.getDisquera().getId());
        if (disquera.isEmpty()){
            throw new DisqueraNotFoundException(disco.getDisquera().getId());
        }
        // validacion existencia artista
        Optional<Artista> artista =
                artistaRepository.findById(disco.getArtista().getId());
        if (artista.isEmpty()){
            throw new ArtistaNotFoundException(disco.getArtista().getId());
        }
        // validacion existencia artista
        Optional<GeneroMusical> generoMusical =
                generoMusicalRepository.findById(disco.getGeneroMusical().getId());
        if (generoMusical.isEmpty()) {
            throw new GeneroMusicalNotFoundException(disco.getGeneroMusical().getId());
        }
        disco.setArtista(artista.get());
        disco.setDisquera(disquera.get());
        disco.setGeneroMusical(generoMusical.get());
        //String titulo, Integer idArtista
        return discoRepository.save(disco);


    }
}
