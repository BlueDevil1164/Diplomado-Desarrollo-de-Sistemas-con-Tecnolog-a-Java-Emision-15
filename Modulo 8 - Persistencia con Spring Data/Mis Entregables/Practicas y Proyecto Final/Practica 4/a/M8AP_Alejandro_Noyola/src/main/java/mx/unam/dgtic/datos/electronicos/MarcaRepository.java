package mx.unam.dgtic.datos.electronicos;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MarcaRepository extends CrudRepository <Marca, Integer> {

    List<Marca> findByMarca(String marca);
    List<Marca> findByStarRate(Integer starRate);
    List<Marca> findByElectronicoNombreElectronico(String nombreElectronico);
    List<Marca> findByElectronicoCodigoDeBarras(Long codigoDeBarras);;

}
