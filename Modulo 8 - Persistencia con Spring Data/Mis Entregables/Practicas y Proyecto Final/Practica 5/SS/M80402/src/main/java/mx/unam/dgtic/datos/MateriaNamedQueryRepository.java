package mx.unam.dgtic.datos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MateriaNamedQueryRepository extends CrudRepository<Materia, String> {

    List<Materia> buscarAltos();

    List<Materia> buscarAltosConHoras(@Param("horas") Integer horas);

    List<Materia> buscarPorMateria(String materia);

    List<Materia> buscarPorMateriaYCreditos(String materia, Integer creditos);

    List<Materia> searchByCreditosNotBetweenOrderByCreditos(
            @Param("creditosini") Integer creditosini,
            @Param("creditosfin") Integer creditosfin
    );

    List<Materia> searchByHorasNotBetweenOrderByHoras(
            @Param("horasini") Integer horasini,
            @Param("horasfin") Integer horasfin
    );

    List<Materia> buscarAltosMayorPromedio();

    @Query(value = "SELECT avg(a.horas) FROM Materia a")
    Integer leerHorasPromedio();

    @Query(value = "SELECT avg(a.creditos) FROM Materia a")
    Integer leerCreditosPromedio();

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM Materia m WHERE m.materia REGEXP :regex"
    )
     List<Materia> findByMateriaRegexp(@Param("regex") String regex);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM Materias " +
                    "WHERE CONCAT(materia, ' ' ,creditos) LIKE %?1% " +
                    "OR CONCAT(creditos, ' ', materia) LIKE %?1% " +
                    "OR CONCAT(SUBSTRING_INDEX(materia, ' ', 1), ' ', creditos) LIKE %?1% " +
                    "OR CONCAT(SUBSTRING_INDEX(materia, ' ', -1), ' ', creditos) LIKE %?1% " +
                    "ORDER BY materia, creditos"
    )
    List<Materia> buscarPorCombinacionMateriaCreditos(String combinacion);

    //DISTINCT
    @Query(value = "SELECT DISTINCT m.materia FROM Materia m ORDER BY m.materia")
    List<String> findDistinctMateria();

    @Query(value = "SELECT DISTINCT m.creditos FROM Materia m ORDER BY m.creditos")
    List<String> findDistinctCreditos();

    @Query(value = "SELECT DISTINCT CONCAT(m.materia, ' ', m.creditos) materiacompleta FROM Materia m ORDER BY m.materia")
    List<String> findDistinctMateriaCreditos();

    @Query(value = "SELECT m.materia AS campo, COUNT(*) AS conteo " +
            "FROM Materia m " +
            "GROUP BY m.materia " +
            "ORDER BY m.materia"
    )
    List<ConteoPorCampo> contarPorMateria();


    @Query(value = "SELECT m.creditos AS campo, COUNT(*) AS conteo " +
            "FROM Materia m " +
            "GROUP BY m.creditos " +
            "ORDER BY m.creditos"
    )
    List<ConteoPorCampo> contarPorCreditos();

    @Query(value = "SELECT m.horas AS campo, COUNT(*) AS conteo " +
            "FROM Materia m " +
            "GROUP BY m.horas " +
            "ORDER BY m.horas"
    )
    List<ConteoPorCampo> contarPorHoras();



}
