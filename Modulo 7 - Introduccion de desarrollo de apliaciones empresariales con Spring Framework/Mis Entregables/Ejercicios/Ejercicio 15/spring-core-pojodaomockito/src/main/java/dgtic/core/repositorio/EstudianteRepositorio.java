package dgtic.core.repositorio;

import dgtic.core.modelo.Estudiante;

import java.util.List;

public interface EstudianteRepositorio {

    List<Estudiante> findAll();
    Estudiante findById(String matricula);
    void save(Estudiante estudiante);
}
