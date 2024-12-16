package mx.unam.dgtic;

import mx.unam.dgtic.datos.AlumnoNamedQueryRepository;
import mx.unam.dgtic.datos.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Date;

@SpringBootTest
@ComponentScan("mx.unam.dgtic")
public class M803_03ConsultasNombradasTests {
    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    private static final String NOMBRE = "Ana";
    private static final String PATERNO = "Perez";
    private static final double ESTATURA = 1.63;
    private static final Date FECHA = Date.valueOf("1991-04-03");
    private static final String CURP = "ROCD910124HDFTLR04";
    private static final String PATRON = "a";

    @Autowired
    AlumnoRepository alumnoRepository;
    @Autowired
    AlumnoNamedQueryRepository namedQueryRepository;

    @Test
    void buscarNamedQueryTest(){
        System.out.println(ALUMNO);
        namedQueryRepository.buscarAltos().forEach(System.out::println);

    }
}