package mx.unam.dgtic.datos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Objects;

public interface EstadoRepository extends CrudRepository<Estado, Integer> {
    Estado findByEstado(String estado);

    List<Estado> findByEstadoContaining(String edo);

    @Query("SELECT e, COUNT(a) FROM Estado e LEFT JOIN e.alumnos a GROUP BY e")
    List<Object[]> findByEstadoAlumnosCount();

    @Query("SELECT DISTINCT e FROM Estado e JOIN e.alumnos a " +
            "WHERE a.nombre LIKE%:nombre%")
    List<Estado> findEstadoByAlumnoNombreLike(String nombre);

    @Query("SELECT e FROM Estado e WHERE e.alumnos IS EMPTY")
    List<Estado> findEstadosSinAlumnos();

    @Query("SELECT e FROM Estado e WHERE SIZE(e.alumnos) >= :minimo")
    List<Estado> findEstadoConMinimoAlumnos(int minimo);


}
