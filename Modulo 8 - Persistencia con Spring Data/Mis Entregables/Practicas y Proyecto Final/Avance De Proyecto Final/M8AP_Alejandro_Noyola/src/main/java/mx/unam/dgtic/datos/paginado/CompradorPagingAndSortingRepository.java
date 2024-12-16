package mx.unam.dgtic.datos.paginado;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;


public interface CompradorPagingAndSortingRepository extends PagingAndSortingRepository<Comprador, Integer> {

    // Consulta Derivada Paginada
    Page<Comprador> findByNombreCompradorLike(String patron, Pageable pagina);

    //Page<Comprador> findByApellidoCompradorNotLike(String patron, Pageable pagina);

    /*
        Page<Comprador> findByGenero(String genero, Pageable pagina);

        Page<Comprador> findByEdadGreaterThan(Integer edad, Pageable pagina);

        Page<Comprador> findByNombreCompradorIgnoreCase(String nombre, Pageable pagina);


     */
    // Consulta nombrada paginada
    @Query("SELECT DISTINCT c.nombreComprador FROM Comprador c")
    Page<String> findDistinctNombreComprador(Pageable pageable);

    @Query("SELECT DISTINCT c.apellidoComprador FROM Comprador c")
    Page<String> findDistinctApellidoComprador(Pageable pageable);

    @Query(value = "SELECT c.genero AS campo, COUNT(*) AS conteo " +
            "FROM Comprador c " +
            "GROUP BY c.genero")
    Page<ConteoPorCampo> contarPorGenero(Pageable pagina);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM Comprador " +  // Asegúrate de que esto sea correcto
                    "WHERE CONCAT(nombreComprador, ' ', apellidoComprador) LIKE %?1% " +
                    "OR CONCAT(apellidoComprador, ' ', nombreComprador) LIKE %?1% " +
                    "ORDER BY nombreComprador, apellidoComprador"
    )
    Page<Comprador> buscarPorCombinacionNombreApellido(String combinacion, Pageable pagina);
/*
    @Query("SELECT c FROM Comprador c WHERE c.fechaRegistro >= :fechaInicio AND c.fechaRegistro <= :fechaFin")
    Page<Comprador> findByFechaRegistroBetween(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin, Pageable pageable);

 */

}