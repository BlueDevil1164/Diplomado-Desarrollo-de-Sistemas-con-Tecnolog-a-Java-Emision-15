package unam.diplomado.pixup.disco.service;

import jakarta.ejb.Local;
import unam.diplomado.pixup.disco.domain.Disco;

@Local
public interface DiscoService {
    // Método para registrar un disco con las validaciones necesarias
    Disco altaDisco(Disco disco);

}
