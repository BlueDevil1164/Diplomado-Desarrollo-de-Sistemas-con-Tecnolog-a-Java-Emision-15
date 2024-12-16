package dgtic.core.servicio;

import dgtic.core.repositorio.intf.BaseDeDatosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
public class ServicioDAO {
    @Autowired
    @Qualifier("baseDeDatosDAOExtra")
    private BaseDeDatosDAO seBaseDeDatosDAO;

    /*@Autowired
    public ServicioDAO(@Qualifier("baseDeDatosDAOExtra") BaseDeDatosDAO servicioDAO) {
        this.seBaseDeDatosDAO=servicioDAO;

    }*/

    public BaseDeDatosDAO getSeBaseDeDatosDAO() {
        return seBaseDeDatosDAO;
    }

   //@Autowired(required = false)
    public void setSeBaseDeDatosDAO(@Qualifier("baseDeDatosDAOExtra") BaseDeDatosDAO seBaseDeDatosDAO) {
        this.seBaseDeDatosDAO = seBaseDeDatosDAO;
    }

    public String archivoCSV(String carrera){
        return seBaseDeDatosDAO.getEstudiantes(carrera).stream()
                .map(alm->alm.getMatricula()+";"+
                        (alm.getMaterias().stream()
                                .map(mat->(mat.getNombre()+";"+mat.getCreditos()))
                                .collect(Collectors.joining(";")))+";"+alm.getNombre())
                .collect(Collectors.joining("\n"));
    }
}
