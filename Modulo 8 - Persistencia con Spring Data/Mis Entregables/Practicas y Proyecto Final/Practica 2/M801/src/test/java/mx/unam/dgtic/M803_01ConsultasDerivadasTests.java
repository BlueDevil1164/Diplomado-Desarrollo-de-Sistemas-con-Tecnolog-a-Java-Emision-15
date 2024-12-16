package mx.unam.dgtic;

import mx.unam.dgtic.datos.Alumno;
import mx.unam.dgtic.datos.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

@SpringBootTest
@ComponentScan("mx.unam.dgtic")
public class M803_01ConsultasDerivadasTests {
    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    private static final String NOMBRE = "Ana";
    private static final String PATERNO = "Perez";
    private static final double ESTATURA = 1.63;
    private static final String FECHA = "1991-04-03";
    private static final String CURP = "ROCD910124HDFTLR04";
    @Autowired
    AlumnoRepository alumnoRepository;

    @Test
    void buscarPorNombreTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar alumnos con el nombre: "+NOMBRE);
        System.out.println("Número de alumnos con el nombre "+NOMBRE+ ": "+
                alumnoRepository.countByNombre(NOMBRE));
        alumnoRepository.getByNombre(NOMBRE).forEach(System.out::println);
    }
    @Test
    void buscarPorNombreNotTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar alumnos sin el nombre: "+NOMBRE);
        System.out.println("Número de alumnos sin el nombre "+NOMBRE+ ": "+
                alumnoRepository.countByNombreNot(NOMBRE));
        alumnoRepository.findByNombreNot(NOMBRE).forEach(System.out::println);
    }
    @ParameterizedTest
    @ValueSource(strings = {"Carlos David", "Ana", "Luis", "María"})
    void buscarPorNombreTest(String nombre){
        System.out.println(ALUMNO);
        System.out.println("Buscar alumnos con el nombre: '"+nombre+"'");
        System.out.println("Número de alumnos con el nombre '"+nombre+ "': "+
                alumnoRepository.countByNombre(nombre));
        alumnoRepository.findByNombre(nombre).forEach(System.out::println);
    }

    @Test
    @Transactional
    void streamPorNombreTest(){
        try (Stream<Alumno> alumnoStream = alumnoRepository.streamByNombreNot(NOMBRE)) {
            System.out.println(ALUMNO);
            System.out.println("Alumnos con el nombre diferente a "+NOMBRE);
            alumnoStream.forEach(a -> {
                System.out.println("- Procesando alumno: "+ a.getNombre()+" "+a.getPaterno());
            });
            // los streams son objetos que si no cerramos ocupan memoria pero al usar el try no hace falta
            // alumnoStream.close(;

        }
    }

    @Test
    void buscarPorCamposTest() throws ParseException {
        System.out.println(ALUMNO);
        System.out.println("Alumnos con apterno "+PATERNO);
        alumnoRepository.readByPaterno(PATERNO).forEach(System.out::println);

        System.out.println("Alumnos con estatura "+ESTATURA);
        alumnoRepository.readByEstatura(ESTATURA).forEach(System.out::println);

        System.out.println("Alumnos con Fecha de Nacimiento "+FECHA);
        alumnoRepository.readByFnac(new SimpleDateFormat("yyyy-MM-dd").parse(FECHA))
                .forEach(System.out::println);

        System.out.println("Alumnos con CURP: " +CURP);
        alumnoRepository.readByCurp(CURP).forEach(System.out::println);
    }

    @Test
    void buscarNulosTest(){
        System.out.println(ALUMNO);
        System.out.println("Alumnos con el campo Paterno nulo: "+alumnoRepository.countByPaternoIsNull());
        alumnoRepository.findByPaternoIsNull().forEach(System.out::println);
        System.out.println("Alumnos con el campo paterno no Nulo: "+alumnoRepository.countByPaternoIsNotNull());
        alumnoRepository.findByPaternoIsNotNull().forEach(System.out::println);
    }

    @Test
    void buscarAndOrTest(){
        System.out.println(ALUMNO);
        System.out.println("Nombre OR Paterno");
        if (alumnoRepository.existsByNombreOrPaterno(NOMBRE, PATERNO)){
            System.out.println("Existen "+alumnoRepository.countByNombreOrPaterno(NOMBRE, PATERNO) +" alumnos)");
            alumnoRepository.queryByNombreOrPaterno(NOMBRE, PATERNO).forEach(System.out::println);
        }
        System.out.println("Nombre AND Paterno");
        if (alumnoRepository.existsByNombreAndPaterno(NOMBRE, PATERNO)){
            System.out.println("Existen "+alumnoRepository.countByNombreOrPaterno(NOMBRE, PATERNO) +" alumnos)");
            alumnoRepository.queryByNombreOrPaterno(NOMBRE, PATERNO).forEach(System.out::println);
        }

        System.out.println("Buscar por nombre o paterno nulo: ");
        alumnoRepository.queryByNombreOrPaternoNull(NOMBRE);
    }

    @Test
    void buscarPorNombreOrdenadoPorPaterno(){
        System.out.println(ALUMNO);
        System.out.println("Bucar por nombre y ordenar por apellido");

        System.out.println("Ordenado ascendente");
        alumnoRepository.findByNombreOrderByPaternoAsc("Carlos David").forEach(System.out::println);

        System.out.println("Ordenado descendente");
        alumnoRepository.findByNombreOrderByPaternoDesc("Carlos David").forEach(System.out::println);

        System.out.println("Primeros 2 asc");
        alumnoRepository.readTop2ByNombreOrderByPaternoAsc("Carlos David").forEach(System.out::println);
        System.out.println("Primeros 2 desc");
        alumnoRepository.readTop2ByNombreOrderByPaternoDesc("Carlos David").forEach(System.out::println);
    }
}