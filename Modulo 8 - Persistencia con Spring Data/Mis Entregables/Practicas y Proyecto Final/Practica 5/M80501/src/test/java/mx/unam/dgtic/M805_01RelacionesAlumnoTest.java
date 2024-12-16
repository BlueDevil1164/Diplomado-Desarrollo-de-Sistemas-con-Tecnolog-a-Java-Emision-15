package mx.unam.dgtic;

import mx.unam.dgtic.datos.AlumnoRepository;
import mx.unam.dgtic.datos.Estado;
import mx.unam.dgtic.datos.EstadoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class M805_01RelacionesAlumnoTest {
    final String ALUMNO = "ALEJANDRO NOYOLA NAZARIO";
    final String ESTADO = "Guerrero";


    @Autowired
    AlumnoRepository repositorioAlumno;

    @Autowired
    EstadoRepository repositorioEstado;

    @Transactional
    @Test
    void  buscarPorEstadoTest(){
        System.out.println(ALUMNO);

        System.out.println("Estado");
        Estado estado =  repositorioEstado.findByEstado(ESTADO);
        System.out.println(estado);
        System.out.println("Alumnos en el estado " + estado.getEstado());
        estado.getAlumnos().forEach(a -> System.out.println(
                a.getNombre() + " " + a.getPaterno() + " "
                    + a.getEstado().getAbreviatura()));

        System.out.println("Buscar Alumnos por el Objeto ESTADO");
        repositorioAlumno.findByEstado(estado).forEach(System.out::println);

        System.out.println("Buscar Alumnos con la cadena ESdo " + ESTADO);
        repositorioAlumno.findByEstadoEstado(ESTADO).forEach(System.out::println);

        System.out.println("Buscar Alumnos por Abreviatura de Estado CDMX");
        repositorioAlumno.findByEstadoAbreviatura("CDMX").forEach(System.out::println);

    }



    //Captura 1
    @Test
    void findEstadoTest(){
        System.out.println(ALUMNO);
        System.out.println("Estados que no tienen  ningun Alumno");
        repositorioEstado.findEstadosSinAlumnos().forEach(System.out::println);

        System.out.println("Buscar Alumnos con la cadena ESdo " + ESTADO);
        repositorioEstado.findEstadoConMinimoAlumnos(2).forEach(System.out::println);

        System.out.println("Numero de Alumnos por Estado");
        List<Object[]> resultado = repositorioEstado.findByEstadoAlumnosCount();
        for (Object[] r:resultado){
            Estado estado = (Estado) r[0];
            Long conteoAlu = (Long) r[1];
            System.out.println("Estado " + estado.getEstado()
                   + ", Numero Alumnos " + conteoAlu);
        }
    }
}