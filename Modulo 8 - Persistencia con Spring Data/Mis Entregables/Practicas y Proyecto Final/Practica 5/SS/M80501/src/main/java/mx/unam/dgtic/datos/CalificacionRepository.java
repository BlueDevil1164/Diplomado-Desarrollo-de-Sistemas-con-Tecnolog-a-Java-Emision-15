package mx.unam.dgtic.datos;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalificacionRepository extends CrudRepository<Calificacion, Integer> {
    List<Calificacion> findByMateria(String materia);
    List<Calificacion> findByCalificacion(int calificacion);

    List<Alumno> findByAlumnoNombre(String nombre);
    List<Alumno> findByAlumnoPaterno(String paterno);
    List<Alumno> findByAlumnoPaternoLike(String paterno);

}
