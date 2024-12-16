package mx.unam.dgtic.datos;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlumnoPagingAndSortingRepository
    extends PagingAndSortingRepository<Alumno, String> {


    //Page<Alumno> find
}
