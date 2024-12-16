package mx.unam.dgtic.clienteweb.services;

import mx.unam.dgtic.dto.AlumnoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AlumnoWebClientService {

    @Autowired
    private WebClient webClient;


    public List<AlumnoDTO> getAll(){
        Mono<List<AlumnoDTO>> alumnosMono = webClient.get()
                .uri("/")
                .retrieve()
                .bodyToFlux(AlumnoDTO.class)
                .collectList();
        List<AlumnoDTO> alumnos = alumnosMono.block();
        return alumnos;
    }

    public AlumnoDTO getAlumnoByMatricula(String matricula){
        Mono<AlumnoDTO> alumnoDtoMono = webClient.get()
                .uri("/{matricula}", matricula)
                .retrieve()
                .bodyToMono(AlumnoDTO.class);
        AlumnoDTO alumnoDTO = alumnoDtoMono.block();
        return alumnoDTO;
    }

    public AlumnoDTO actualizaAlumno(AlumnoDTO alumnoDTO){
        return webClient.put().uri("/{matricula}", alumnoDTO.getMatricula())
                .bodyValue(alumnoDTO)
                .retrieve()
                .bodyToMono(AlumnoDTO.class)
                .block();
    }
}
