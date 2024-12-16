package mx.unam.dgtic.datos;


import mx.unam.dgtic.datos.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface AlumnoRepository extends CrudRepository<Alumno, String> {
    // Métodos de busqueda con consultas derivadas
    List<Alumno> findByNombre(String nombre); // <
    List<Alumno> getByNombre(String nombre); // <
    List<Alumno> searchByNombre(String nombre); // <
    List<Alumno> readByNombre(String nombre); // <
    List<Alumno> queryByNombre(String nombre); // <
    // Es lo mismo el uso de estas 5 palabras reservadas (find, get,query,search, read)
    // List<Alumno> findByNombres(String nombre); esto da error por que el campo es 'nombre' no 'nombres'
    Stream<Alumno> streamByNombre(String nombre);

    List<Alumno> findByNombreNot(String nombre); // Todos los que no tengan el nombre
    Stream<Alumno> streamByNombreNot(String nombre);
    List<Alumno> readByPaterno(String paterno);
    List<Alumno> readByEstatura(Double estatura);
    List<Alumno> readByFnac(Date fnac);
    List<Alumno> readByCurp(String curp);


    // Método de conteo
    long countByNombre (String nombre);
    long countByNombreNot (String nombre);

    // Nulos
    List<Alumno> findByPaternoIsNull();
    List<Alumno> findByPaternoIsNotNull();

    long countByPaternoIsNull();
    long countByPaternoIsNotNull();

    // Concatenacion de valores (conjunción)
    List<Alumno> queryByNombreAndPaterno(String nombre, String paterno);
    // Disyunción
    List<Alumno> queryByNombreOrPaterno(String nombre, String paterno);
    List<Alumno> queryByNombreOrPaternoNull(String nombre);
    List<Alumno> queryByNombreOrPaternoNotNull(String nombre);
    List<Alumno> queryByNombreOrPaternoAndEstatura(String nombre, String paterno, Double estatura);

    long countByNombreAndPaterno(String nombre, String paterno);
    long countByNombreOrPaterno(String nombre, String paterno);

    // Para saber si existe
    boolean existsByNombreAndPaterno(String nombre, String paterno);
    boolean existsByNombreOrPaterno(String nombre, String paterno);

    // LimitarConsultas
    List<Alumno> readFirstByEstatura (Double estatura);
    List<Alumno> readTopByEstatura (Double estatura);
    List<Alumno> readTop3ByEstatura (Double estatura);
    List<Alumno> readTop3ByEstaturaOrderByNombreDesc (Double estatura);

    List<Alumno> readTop2ByNombreOrderByPaternoDesc (String nombre);
    List<Alumno> readTop2ByNombreOrderByPaternoAsc (String nombre);

    List<Alumno> findByNombreOrderByPaternoAsc (String nombre);
    List<Alumno> findByNombreOrderByPaternoDesc (String nombre);

    // Operadores
    // IN
    List<Alumno> searchByEstaturaIn(Collection<Double> estatura);
    List<Alumno> searchByEstaturaNotIn(Collection<Double> estatura);

    List<Alumno> searchByNombreIn(Collection<String> nombres);
    List<Alumno> searchByNombreNotIn(Collection<String> nombres);

    // Between
    List<Alumno> searchByEstaturaBetweenOrderByEstatura(double estaturaIni, double estaturaFin);
    //List<Alumno> searchByEstaturaNotBetweenOrderByEstatura(double estaturaIni, double estaturaFin);

    // < >
    List<Alumno> queryByFnacBefore(Date fecha);
    List<Alumno> queryByFnacAfter(Date fecha);

    List<Alumno> queryByEstaturaLessThan(double estatura);
    List<Alumno> queryByEstaturaLessThanEqual(double estatura);

    List<Alumno> queryByEstaturaGreaterThan(double estatura);
    List<Alumno> queryByEstaturaGreaterThanEqual(double estatura);

    List<Alumno> searchByNombreBetweenOrderByNombre(String nombre, String nombre2);
    //List<Alumno> searchByNombreNotBetweenOrderByNombre(String nombre, String nombre2);

    // Patrones
    List<Alumno> findByNombreStartingWith(String inicia);
    List<Alumno> findByNombreEndingWith(String termina);
    List<Alumno> findByNombreContaining(String contiene);

    // Like
    List<Alumno> findByNombreLike(String patron);
    List<Alumno> findByNombreNotLike(String patron);

    long countByNombreLike(String patron);
    long countByNombreNotLike(String patron);


    // Eliminar con consulta derivada
    @Transactional
    List<Alumno> deleteByNombreLike(String patron);
}