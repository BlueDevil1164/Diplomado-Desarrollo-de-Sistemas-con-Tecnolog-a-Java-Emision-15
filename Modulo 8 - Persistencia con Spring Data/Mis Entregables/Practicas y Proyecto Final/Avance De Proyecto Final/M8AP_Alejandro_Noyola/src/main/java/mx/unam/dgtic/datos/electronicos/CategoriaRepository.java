package mx.unam.dgtic.datos.electronicos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    Categoria findByCategoria(String categoria);

    List<Categoria> findByCategoriaContaining(String cat);

    @Query("SELECT e, COUNT(a) FROM Categoria e LEFT JOIN e.electronicos a GROUP BY e")
    List<Object[]> findCategoriaElectronicosCount();

    @Query("SELECT DISTINCT e FROM Categoria e JOIN e.electronicos a "+ "WHERE a.nombreElectronico LIKE %:nombreElectronico%")
    List<Categoria> findCategoriaByElectronicoNombreLike(String nombreElectronico);

    @Query("SELECT e FROM Categoria e WHERE e.electronicos IS EMPTY")
    List<Categoria> findCategoriasSinElectronicos();

    @Query("SELECT e FROM Categoria e WHERE SIZE(e.electronicos) >= :minimo")
    List<Categoria> findCategoriasConMinimoElectronicos(int minimo);

}
