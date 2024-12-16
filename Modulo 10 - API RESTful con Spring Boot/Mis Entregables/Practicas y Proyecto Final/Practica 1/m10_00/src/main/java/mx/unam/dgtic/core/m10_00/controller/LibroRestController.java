package mx.unam.dgtic.core.m10_00.controller;

import mx.unam.dgtic.core.m10_00.model.Libro;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/libreria")
public class LibroRestController {
    public static final String NOMBRE = "Alejandro Noyola Nazario";

    HashMap<Integer, Libro> libreria;

    public LibroRestController(){
        libreria = new HashMap<>();
        libreria.put(0, new Libro(0,"Modulo 10 ", "Alejandro Noyola"));
        libreria.put(1, new Libro(1,"El Perfume ", "Patrick Suskind"));
        libreria.put(2, new Libro(2,"El señor de los anillos ", "J.R. Tolkien"));
        libreria.put(3, new Libro(3,"Funddacion ", "Issac Asimov"));

    }

    @GetMapping(path = "/saludar", produces = MediaType.TEXT_HTML_VALUE)
    public  String saludar(){
        return "Hello There " +NOMBRE;
    }

    @GetMapping(path = "/", headers = {"Accept=application/json", },
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<Integer, Libro>> getAll(){
        //return libreria;
        return new ResponseEntity<>(libreria, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libro> getLibro(@PathVariable int id) {
        //return libreria.get(id);
        Libro libro = libreria.get(id);
        if (libro != null) {
            return ResponseEntity.ok(libro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libro> addBook(@RequestBody Libro libro) {
        int id = 1;
        while (libreria.containsKey(id)) {
            id++;
        }
        libro.setId(id);
        libreria.put(id, libro);
        return new ResponseEntity<>(libro, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libro> reemplazarLibro(@PathVariable int id, @RequestBody Libro libro) {
       // libreria.replace(id, libro);
        if (libreria.containsKey(id)) {
            libreria.replace(id, libro);
            return ResponseEntity.ok(libreria.get(id));

        } else {
            libreria.put(id, libro);
            return new ResponseEntity<>(libreria.get(id), HttpStatus.CREATED);
        }
    }

    @PutMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String errorPut(){
        return "{'menseje':'Error, este metodo (PUT) no soporta a acciones recurso completo'}";
    }

    @PatchMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libro> actualizarLibro(@PathVariable int id, @RequestBody Libro libro) {
        Libro libroDB = libreria.get(id);


        if (libro == null){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        if (libroDB == null){
            return ResponseEntity.notFound().build();
        }
        if (libro.getTitulo() != null) {
            libroDB.setTitulo(libro.getTitulo());
        }
        if (libro.getAutor() != null) {
            libroDB.setAutor(libro.getAutor());
        }

        //return libreria.get(id);
        libreria.replace(id,libroDB);
        return  ResponseEntity.ok(libreria.get(id));
    }

    @PatchMapping("/")
    public ResponseEntity<String> patchNoPermitido(){
        return new ResponseEntity<>("{'msg':'Accion no permitida'}",
                    HttpStatus.METHOD_NOT_ALLOWED);
    }


    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
                                   consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libro> deleteLibro(@PathVariable int id) {
        //return libreria.remove(id);
        if (libreria.containsKey(id)) {
            return ResponseEntity.ok(libreria.remove(id));
        } else {
            return ResponseEntity.notFound().build();

        }
    }
}
