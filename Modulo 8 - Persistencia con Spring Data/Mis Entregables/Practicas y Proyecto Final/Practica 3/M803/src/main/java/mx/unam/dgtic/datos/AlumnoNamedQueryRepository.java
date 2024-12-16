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

/*
    @Query(value = "SELECT avg(a.estatura) FROM Alumno a")
    double leerEstaturaPromedio();

    List<Alumno> buscarPorCurpContenga(@Param("substring") String substring);

    List<Alumno> buscarPorEstadoCurp(@Param("codigoEstado") String substring);


 */




    // ------------------------------------------------------------------------------------


    List<Alumno> buscarAltosMayorPromedio();

    @Query(value = "SELECT avg(a.estatura) FROM Alumno a")
    double leerEstaturaPromedio();

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM Alumnos a WHERE a.curp REGEXP :regex"
    )

    List<Alumno> findByCurpRegex(@Param("regex") String regex);

    @Query(
            nativeQuery = true,
            value = "SELCT * FROM Alumnos " +
                    "WHERE CONCAT(nombre, ' ', paterno) LIKE %?1%" +
                    "OR CONCAT(paterno, ' ' ,nombre '') LIKE %? " +
                    "OR CONCAT(SUBSTRING_INDEX(nombre, ' ', 1), ' ', paterno) LIKE %?1% " +
                    "OR CONCAT(SUBSTRING_INDEX(nombre, ' ', -1), ' ', paterno) LIKE %?1% " +
                    "ORDER BY nombre, paterno"
    )
    List<Alumno> buscarPorCombinacionNombrePaterno(String combinacion);


    //DISTINCT
    @Query(value = "SELECT DISTINCT a.nombre FROM Alumno ORDER BY a.nombre")
    List<String> findDistrictNombre();

    @Query(value = "SELECT DISTINCT a.paterno FROM Alumno ORDER BY a.paterno")
    List<String> findDistrictPaterno();

    @Query(value = "SELECT DISTINCT CONCAT(a.nombre, ' ' a.paterno) Nnombre FROM Alumno ORDER BY a.paterno")
    List<String> findDistrictNombrePaterno();


    @Query(value = "SELECT a.nombre AS campo, COUNT(*) AS conteo " +
            "FROM Alumno a " +
            "GROUP BY a.nombre" +
            "ORDER BY a.nombre ")
    List<ConteoPorCampo> contarPorNombre();

    @Query(value = "SELECT a.paterno AS campo, COUNT(*) AS conteo " +
            "FROM Alumno a " +
            "GROUP BY a.paterno" +
            "ORDER BY a.paterno ")
    List<ConteoPorCampo> contarPorPaterno();

    @Query(value = "SELECT EXTRACT(YEAR FROM a.fnac) AS campo, COUNT(*) AS conteo " +
            "FROM Alumno a " +
            "GROUP BY campo" +
            "ORDER BY 1 ")
    List<ConteoPorCampo> contarPorAnio();

    @Query (value = "SELECT SUBSTRING(a.curp, 12, 2) AS campo, COUNT(*) AS conteo " +
            "FROM Alumno a " +
            "GROUP BY campo" +
            "ORDER BY 1 ")
    List<ConteoPorCampo> contarPorEstado();

    @Query (value = "SELECT SUBSTRING(a.curp, 11, 1) AS campo, COUNT(*) AS conteo " +
            "FROM Alumno a " +
            "GROUP BY campo" +
            "ORDER BY 1 ")
    List<ConteoPorCampo> contarPorSexo();


}
