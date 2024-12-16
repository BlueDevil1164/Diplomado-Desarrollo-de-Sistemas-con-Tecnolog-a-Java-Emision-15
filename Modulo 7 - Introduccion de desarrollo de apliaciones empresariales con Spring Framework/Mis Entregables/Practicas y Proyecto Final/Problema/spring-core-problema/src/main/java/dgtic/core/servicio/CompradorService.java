package dgtic.core.servicio;

import dgtic.core.modelo.Comprador;

import java.util.List;

public interface CompradorService {
    List<Comprador> findAll();
    Comprador findById(String matricula);
    String registro(String matricula);
    int matricula(String matricula);
}
