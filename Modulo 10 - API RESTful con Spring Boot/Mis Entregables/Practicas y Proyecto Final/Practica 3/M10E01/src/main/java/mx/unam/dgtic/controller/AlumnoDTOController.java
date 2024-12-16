package mx.unam.dgtic.controller;

import jakarta.validation.Valid;
import mx.unam.dgtic.dto.AlumnoDTO;
import mx.unam.dgtic.exception.EstadoNoExisteExepcion;
import mx.unam.dgtic.model.Alumno;
import mx.unam.dgtic.servicio.IAlumnoDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping(path = "/api/v2/alumnos",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class AlumnoDTOController {

    @Autowired
    private IAlumnoDTOService alumnoDTOService;

    // Obtener todos
    @GetMapping(path = "/")
    public List<AlumnoDTO> getAllDTO() {
        return alumnoDTOService.getAlumnosList();
    }

    // Obtener por matrícula
    @GetMapping(path = "/{matricula}")
    public ResponseEntity<AlumnoDTO> getByIdDTO(@PathVariable String matricula) {
        Optional<AlumnoDTO> alumnoDTO = alumnoDTOService.getAlumnoById(matricula);
        if (alumnoDTO.isPresent()) {
            return ResponseEntity.ok(alumnoDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/")
    public ResponseEntity<AlumnoDTO> createAlumnoDTO(
            @Valid @RequestBody AlumnoDTO alumno) throws ParseException, URISyntaxException, EstadoNoExisteExepcion {
        AlumnoDTO alumnoDTO = alumnoDTOService.createAlumno(alumno);
        URI location = new URI("/api/v2/alumnos/" + alumnoDTO.getMatricula());
        return ResponseEntity.created(location).body(alumnoDTO);
    }

    @PutMapping(path = "/{matricula}")
    public ResponseEntity<AlumnoDTO> updateAlumnoDTO(@PathVariable String matricula, @RequestBody AlumnoDTO alumno) throws ParseException, EstadoNoExisteExepcion {
        alumno.setMatricula(matricula);
        return ResponseEntity.ok(alumnoDTOService.updateAlumno(alumno));
    }

    @PatchMapping(path = "/{matricula}")
    public ResponseEntity<AlumnoDTO> updatePartialAlumnoDTO(@PathVariable String matricula, @RequestBody AlumnoDTO alumno) throws ParseException, EstadoNoExisteExepcion {
        Optional<AlumnoDTO> alumnoDB = alumnoDTOService.getAlumnoById(matricula);
        if (alumnoDB.isPresent()) {
            AlumnoDTO modificable = alumnoDB.get();
            if (alumno.getNombre() != null) modificable.setNombre(alumno.getNombre());
            if (alumno.getPaterno() != null) modificable.setPaterno(alumno.getPaterno());
            if (alumno.getFnac() != null) modificable.setFnac(alumno.getFnac());
            if (alumno.getEstatura() != 0.0) modificable.setEstatura(alumno.getEstatura());
            if (alumno.getEstado() != null) modificable.setEstado(alumno.getEstado());
            return ResponseEntity.ok(alumnoDTOService.updateAlumno(modificable));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{matricula}")
    public ResponseEntity<?> deleteAlumno(@PathVariable String matricula) {
        if (alumnoDTOService.deleteAlumno(matricula)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/estados/{edo}")
    public ResponseEntity<List<AlumnoDTO>> getByEstado(@PathVariable String edo) {
        return ResponseEntity.ok(alumnoDTOService.findAlumnosByEstado(edo));
    }

    // /api/v2/alumnos/paginado?page=0&size=2&dir=asc&sort=nombre
    @GetMapping(path = "/paginado")
    public ResponseEntity<List<AlumnoDTO>> getPaginadoAlumnoDTO(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "asc") String dir,
            @RequestParam(defaultValue = "matricula") String sort
    ) {
        return ResponseEntity.ok(alumnoDTOService.getAlumnosPageable(page, size, dir, sort));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> errorFormatoDeCliente(
            HttpMessageNotReadableException ex){
        HashMap<String, String> detalles = new HashMap<>();
        detalles.put("mensaje","el formato de los datos es incorrecto");
        detalles.put("detalle", ex.getMessage());
        detalles.put("timestamp", LocalDateTime.now().toString());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(detalles);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> tratamientoValidacion(
            MethodArgumentNotValidException ex){

        HashMap<String, Object> detalles = new HashMap<>();
        detalles.put("mensaje", "Eror de validacion de campos. Revisa la entrada" );
        detalles.put("statusCode", ex.getStatusCode().toString());
        detalles.put("timestap", LocalDateTime.now().toString());
        HashMap<String, String> detalleCampos = new HashMap<>();

        int i = 1;
        for (FieldError campoError : ex.getBindingResult().getFieldErrors()){
            detalleCampos.put(campoError.getField()+ i++ ,campoError.getDefaultMessage());
        }
        detalles.put("errores",detalleCampos);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(detalles);
    }

    @GetMapping(path = "/ping/{veces}")
    public ResponseEntity<String> ping(@PathVariable int veces){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < veces; i++) {
            str.append("\n TTL " + i );
        }
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.TEXT_PLAIN)
                .body(str.toString());
    }

}
