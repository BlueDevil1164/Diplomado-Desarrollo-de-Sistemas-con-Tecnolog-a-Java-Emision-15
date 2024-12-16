package mx.unam.dgtic.datos.electronicos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ElectronicosRepository extends CrudRepository<Electronico, Integer> {

    List<Electronico> findByCategoria(Categoria categoria);

    long countByCategoria(Categoria categoria);

    List<Electronico> findByCategoriaCategoria(String categoria);
    List<Electronico> findByCategoriaAbreviatura(String abreviatura);


    List<Electronico> buscarTodosConMarcas();

    @Query("SELECT g FROM Electronico a JOIN a.proveedores g WHERE a.idElectronico = :idElectronico")
    List<Proveedor> findProveedoresByIdElectronico(@Param("idElectronico") String idElectronico);


}
