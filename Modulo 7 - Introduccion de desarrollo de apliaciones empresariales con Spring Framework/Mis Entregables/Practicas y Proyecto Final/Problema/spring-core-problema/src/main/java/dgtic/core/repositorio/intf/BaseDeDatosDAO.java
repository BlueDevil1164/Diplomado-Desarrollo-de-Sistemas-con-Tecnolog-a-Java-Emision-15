package dgtic.core.repositorio.intf;

import dgtic.core.modelo.Comprador;

import java.util.List;

public interface BaseDeDatosDAO {
    public List<Comprador> getCompradores(String marca);
    public Comprador getComprador(String marca, String matricula);


}
