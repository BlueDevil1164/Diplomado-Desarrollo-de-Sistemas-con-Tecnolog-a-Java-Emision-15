package dgtic.core.repositorio.intf;

import dgtic.core.modelo.Estudiante;

import java.util.List;

public interface BaseDeDatosDAO {
    public List<Estudiante> getEstudiantes(String carrera);

    public Estudiante getEstudiente(String carrera, String matricula);
    
}
