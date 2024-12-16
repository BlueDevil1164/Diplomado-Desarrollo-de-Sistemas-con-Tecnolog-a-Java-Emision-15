package mx.unam.dgtic;

import mx.unam.dgtic.datos.AlumnoNamedQueryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M803_03ConsultasNombradasTests {

    final String ALUMNO = "JOSE FERNANDO CASTAÑEDA ESTRADA";
    private static final String NOMBRE = "Carlos David";
    private static final String PATERNO = "Perez";
    private static final double ESTATURA = 1.63;
    private static final String FECHA = "1991-04-03";

    @Autowired
    AlumnoNamedQueryRepository repositorioAlumno;

    @Test
    void buscarNamedQueryTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar Altos");
        repositorioAlumno.buscarAltos().forEach(System.out::println);
    }

}
