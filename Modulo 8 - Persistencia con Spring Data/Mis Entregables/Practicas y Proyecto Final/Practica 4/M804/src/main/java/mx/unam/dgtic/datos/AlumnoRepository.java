package mx.unam.dgtic.datos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface AlumnoRepository extends CrudRepository<Alumno, String> {

    // Métodos de Búsqueda con Consultas Derivadas
    List<Alumno> findByNombre(String nombre);

    List<Alumno> getByNombre(String nombre);

    List<Alumno> searchByNombre(String nombre);

    List<Alumno> readByNombre(String nombre);

    List<Alumno> queryByNombre(String nombre);

    Stream<Alumno> streamByNombre(String nombre);

    List<Alumno> readByPaterno(String paterno);

    List<Alumno> readByEstatura(double estatura);

    List<Alumno> readByFnac(Date fnac);

    List<Alumno> readByCurp(String curp);

    List<Alumno> findByNombreNot(String nombre);

    Stream<Alumno> streamByNombreNot(String nombre);

    // Métodos de Conteo
    Long countByNombre(String nombre);

    Long countByNombreNot(String nombre);

    // Nulos
    List<Alumno> findByPaternoIsNull();

    List<Alumno> findByPaternoIsNotNull();

    Long countByPaternoIsNull();

    Long countByPaternoIsNotNull();

    // Operadores Lógicos
    List<Alumno> queryByNombreAndPaterno(String nombre, String paterno);

    List<Alumno> queryByNombreOrPaterno(String nombre, String paterno);

    List<Alumno> queryByNombreOrPaternoNull(String nombre);

    List<Alumno> queryByNombreOrPaternoNotNull(String nombre);

    List<Alumno> queryByNombreOrPaternoAndEstatura(String nombre, String paterno, double estatura);

    Long countByNombreOrPaterno(String nombre, String paterno);

    Boolean existsByNombreOrPaterno(String nombre, String paterno);

    // Limitar Consultas
    List<Alumno> readFirstByEstatura(double estatura);

    List<Alumno> readFirstByNombre(String nombre);

    List<Alumno> readTopByEstatura(double estatura);

    List<Alumno> readTop1ByEstatura(double estatura);

    List<Alumno> readTop3ByEstatura(double estatura);

    // Orderna Consultas
    List<Alumno> readTop3ByEstaturaOrderByNombreDesc(double estatura);

    List<Alumno> findByNombreOrderByPaternoAsc(String nombre);

    List<Alumno> findByNombreOrderByPaternoDesc(String nombre);

    List<Alumno> readTop2ByNombreOrderByPaternoAsc(String nombre);

    List<Alumno> readTop2ByNombreOrderByPaternoDesc(String nombre);

    // Operadores
    // In
    List<Alumno> searchByEstaturaIn(Collection<Double> estaturas);

    List<Alumno> searchByEstaturaNotIn(Collection<Double> estaturas);

    List<Alumno> searchByNombreIn(Collection<String> nombres);

    List<Alumno> searchByNombreNotIn(Collection<String> nombres);

    // Between
    List<Alumno> searchByEstaturaBetweenOrderByEstatura(double estaturaIni, double estatiraFin);

    List<Alumno> searchByNombreBetweenOrderByNombre(String nombreIni, String nombreFin);

    // Before, After
    List<Alumno> queryByFnacBefore(Date fecha);

    List<Alumno> queryByFnacAfter(Date fecha);

    // Mayor que, Menor que
    List<Alumno> queryByEstaturaLessThan(double estatura);

    List<Alumno> queryByEstaturaLessThanEqual(double estatura);

    List<Alumno> queryByEstaturaGreaterThan(double estatura);

    List<Alumno> queryByEstaturaGreaterThanEqual(double estatura);

    // Patrones
    List<Alumno> findByNombreStartingWith(String inicia);

    List<Alumno> findByNombreContaining(String contiene);

    List<Alumno> findByNombreEndingWith(String termina);

    // Like
    List<Alumno> findByNombreLike(String nombre);

    List<Alumno> findByNombreNotLike(String nombre);

    Long countByNombreLike(String nombre);

    Long countByNombreNotLike(String nombre);

    // Eliminar
    @Transactional
    List<Alumno> deleteByNombreLike(String patron);

}
