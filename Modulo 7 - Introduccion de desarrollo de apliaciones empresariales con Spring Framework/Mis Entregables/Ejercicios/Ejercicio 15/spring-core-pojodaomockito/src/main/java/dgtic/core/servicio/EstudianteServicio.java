package dgtic.core.servicio;

import dgtic.core.modelo.Estudiante;

import java.util.List;

public interface EstudianteServicio {
    List<Estudiante> findAll();
    Estudiante findById(String matricula);
    String archivoCSV(String matricula);
    int creditos(String matricula);
}
