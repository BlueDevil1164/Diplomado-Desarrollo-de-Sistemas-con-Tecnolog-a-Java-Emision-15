package mx.unam.dgtic;

import mx.unam.dgtic.datos.MateriaNamedQueryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M803_03ConsultasNombradasTests {


    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    private static final String NOMBRE = "Carlos David";
    private static final String PATERNO = "Perez";
    private static final double ESTATURA = 1.63;
    private static final String FECHA = "1991-04-03";

    @Autowired
    MateriaNamedQueryRepository repositorioMateria;

    @Test
    void buscarNamedQueryTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar Altos");
        repositorioMateria.buscarAltos().forEach(System.out::println);
    }


}
