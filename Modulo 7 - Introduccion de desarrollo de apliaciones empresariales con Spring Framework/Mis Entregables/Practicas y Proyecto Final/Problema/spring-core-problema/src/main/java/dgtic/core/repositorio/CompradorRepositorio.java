package dgtic.core.repositorio;

import dgtic.core.modelo.Comprador;

import java.util.List;

public interface CompradorRepositorio {
    List<Comprador> findAll();
    Comprador findById(String matricula);
    void save(Comprador comprador);

}
