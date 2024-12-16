package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Estudiante;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.BaseDeDatosDAO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("baseDeDatosDAO")
@Primary
public class BaseDeDatosDAOImpl implements BaseDeDatosDAO {


    @Override
    public List<Estudiante> getEstudiantes(String carrera) {
        return BaseDeDatos.carreras.get(carrera);
    }

    @Override
    public Estudiante getEstudiente(String carrera, String matricula) {
        return BaseDeDatos.carreras.get(carrera)
                .stream()
                .filter(est -> est.getMatricula().equals(matricula))
                .findFirst().orElse(null);
    }
}
