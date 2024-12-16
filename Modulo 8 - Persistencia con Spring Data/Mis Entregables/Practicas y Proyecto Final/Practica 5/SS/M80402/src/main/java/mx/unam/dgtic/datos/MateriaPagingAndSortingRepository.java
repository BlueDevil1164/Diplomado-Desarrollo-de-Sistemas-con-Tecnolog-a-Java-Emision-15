package mx.unam.dgtic.datos;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MateriaPagingAndSortingRepository extends PagingAndSortingRepository<Materia, String> {

    // Consulta Derivada Paginada
    //Page<Materia> findByCurpLike(String patron, Pageable pagina);

    //Page<Materia> findByCurpNotLike(String patron, Pageable pagina);

    // Consulta nombrada paginada
    @Query(value = "SELECT DISTINCT a.materia FROM Materia a")
    Page<String> findDistinctMateria(Pageable pagina);

    @Query(value = "SELECT DISTINCT a.creditos FROM Materia a")
    Page<String> findDistinctCreditos(Pageable pagina);

    @Query(value = "SELECT a.materia AS campo, COUNT(*) AS conteo " +
            "FROM Materia a " +
            "GROUP BY a.materia")
    Page<ConteoPorCampo> contarPorMateria(Pageable pagina);

    /*
    @Query(nativeQuery = true,
            value = "SELECT SUBSTRING(a.curp, 11, 1) AS campo, COUNT(*) AS conteo " +
            "FROM Alumnos a GROUP BY campo")
    Page<ConteoPorCampo> contarPorSexo(Pageable pagina);

     */

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM Materias " +
                    "WHERE CONCAT(materia, ' ' ,creditos) LIKE %?1% " +
                    "OR CONCAT(creditos, ' ', materia) LIKE %?1% " +
                    "OR CONCAT(SUBSTRING_INDEX(materia, ' ', 1), ' ', creditos) LIKE %?1% " +
                    "OR CONCAT(SUBSTRING_INDEX(materia, ' ', -1), ' ', creditos) LIKE %?1% " +
                    "ORDER BY materia, creditos"
    )
    Page<Materia> buscarPorCombinacionMateriacreditos(String combinacion, Pageable pagina);

}
