package mx.unam.dgtic.datos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AlumnoNamedQueryRepository extends CrudRepository<Alumno, String> {

    List<Alumno> buscarAltos();

    List<Alumno> buscarAltosConFecha(@Param("fecha") Date fecha);

    List<Alumno> buscarPorNombre(String nombre);

    List<Alumno> buscarPorNombreYPaterno(String nombre, String paterno);

    List<Alumno> buscarPorCurpContenga(@Param("substring") String substring);

    Long contarPorCurpContenga(@Param("substring") String substring);

    List<Alumno> buscarPorEstadoCurp(@Param("codigoEstado") String codigoEstado);

    Long contarPorEstadoCurp(@Param("codigoEstado") String codigoEstado);

    List<Alumno> searchByEstaturaNotBetweenOrderByEstatura(
            @Param("estaturaini") Double estaturaini,
            @Param("estaturafin") Double estaturafin
    );

    List<Alumno> buscarAltosMayorPromedio();

    @Query(value = "SELECT avg(a.estatura) FROM Alumno a")
    double leerEstaturaPromedio();

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM Alumnos a WHERE a.curp REGEXP :regex"
    )
    List<Alumno> findByCurpRegexp(@Param("regex") String regex);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM Alumnos " +
                    "WHERE CONCAT(nombre, ' ' ,paterno) LIKE %?1% " +
                    "OR CONCAT(paterno, ' ', nombre) LIKE %?1% " +
                    "OR CONCAT(SUBSTRING_INDEX(nombre, ' ', 1), ' ', paterno) LIKE %?1% " +
                    "OR CONCAT(SUBSTRING_INDEX(nombre, ' ', -1), ' ', paterno) LIKE %?1% " +
                    "ORDER BY nombre, paterno"
    )
    List<Alumno> buscarPorCombinacionNombrePaterno(String combinacion);

    //DISTINCT
    @Query(value = "SELECT DISTINCT a.nombre FROM Alumno a ORDER BY a.nombre")
    List<String> findDistinctNombre();

    @Query(value = "SELECT DISTINCT a.paterno FROM Alumno a ORDER BY a.paterno")
    List<String> findDistinctPaterno();

    @Query(value = "SELECT DISTINCT CONCAT(a.nombre, ' ', a.paterno) nombrecompleto FROM Alumno a ORDER BY a.nombre")
    List<String> findDistinctNombrePaterno();

    @Query(value = "SELECT a.nombre AS campo, COUNT(*) AS conteo " +
            "FROM Alumno a " +
            "GROUP BY a.nombre " +
            "ORDER BY a.nombre"
    )
    List<ConteoPorCampo> contarPorNombre();

    @Query(value = "SELECT a.paterno AS campo, COUNT(*) AS conteo " +
            "FROM Alumno a " +
            "GROUP BY a.paterno " +
            "ORDER BY a.paterno"
    )
    List<ConteoPorCampo> contarPorPaterno();

    @Query(value = "SELECT EXTRACT(YEAR FROM a.fnac) AS campo, COUNT(*) AS conteo " +
            "FROM Alumno a " +
            "GROUP BY EXTRACT(YEAR FROM a.fnac) " +
            "ORDER BY 1"
    )
    List<ConteoPorCampo> contarPorAnio();

    @Query(value = "SELECT SUBSTRING(a.curp, 12, 2) AS campo, COUNT(*) AS conteo " +
            "FROM Alumno a " +
            "GROUP BY campo " +
            "ORDER BY 1")
    List<ConteoPorCampo> contarPorEstado();

    @Query(value = "SELECT SUBSTRING(a.curp, 11, 1) AS campo, COUNT(*) AS conteo " +
            "FROM Alumno a " +
            "GROUP BY campo " +
            "ORDER BY 1")
    List<ConteoPorCampo> contarPorSexo();

}
