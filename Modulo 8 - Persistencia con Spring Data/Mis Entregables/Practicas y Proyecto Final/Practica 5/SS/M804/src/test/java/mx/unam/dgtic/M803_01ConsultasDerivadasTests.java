package mx.unam.dgtic;

import mx.unam.dgtic.datos.Alumno;
import mx.unam.dgtic.datos.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

@SpringBootTest
public class M803_01ConsultasDerivadasTests {


    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    private static final String NOMBRE = "Carlos David";
    private static final String PATERNO = "Perez";
    private static final double ESTATURA = 1.63;
    private static final String FECHA = "1991-04-03";
    private static final String CURP = "ROCD910124HDFTLR04";

    @Autowired
    AlumnoRepository repositorioAlumno;

    @Test
    void buscarPorNombreTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar alumnos por nombre " + NOMBRE);
        System.out.println("Número de alumnos con nombre " + NOMBRE + " " + repositorioAlumno.countByNombre(NOMBRE));
        repositorioAlumno.findByNombre(NOMBRE).forEach(System.out::println);
        //repositorioAlumno.getByNombre(NOMBRE).forEach(System.out::println);
        //repositorioAlumno.searchByNombre(NOMBRE).forEach(System.out::println);
        //repositorioAlumno.readByNombre(NOMBRE).forEach(System.out::println);
        //repositorioAlumno.queryByNombre(NOMBRE).forEach(System.out::println);
    }

    @Test
    void buscarPorNombreNotTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar alumnos que no tengan nombre " + NOMBRE);
        System.out.println("Número de alumnos que no tienen nombre " + NOMBRE + " " + repositorioAlumno.countByNombreNot(NOMBRE));
        repositorioAlumno.findByNombreNot(NOMBRE).forEach(System.out::println);
        //repositorioAlumno.getByNombre(NOMBRE).forEach(System.out::println);
        //repositorioAlumno.searchByNombre(NOMBRE).forEach(System.out::println);
        //repositorioAlumno.readByNombre(NOMBRE).forEach(System.out::println);
        //repositorioAlumno.queryByNombre(NOMBRE).forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Carlos David", "Ana", "Luis", "Maria"})
    void buscarPorNombreTest(String nombre) {
        System.out.println(ALUMNO);
        System.out.println("Buscar alumnos por nombre " + nombre);
        System.out.println("Número de alumnos con nombre " + nombre + " " + repositorioAlumno.countByNombre(nombre));
        repositorioAlumno.findByNombre(nombre).forEach(System.out::println);
    }

    @Test
    @Transactional
    void streamPorNombreTest() {
        try (Stream<Alumno> alumnoStream = repositorioAlumno.streamByNombreNot(NOMBRE)) {
            System.out.println("Alumnos con nombre diferente a " + NOMBRE);
            alumnoStream.forEach(a -> {
                System.out.println("Procesando Alumno: " + a.getNombre() + " " + a.getPaterno());
            });
            //alumnoStream.close();
        }
    }

    @Test
    void buscarPorCamposTest() throws ParseException {
        System.out.println(ALUMNO);
        System.out.println("Alumnos con paterno " + PATERNO);
        repositorioAlumno.readByPaterno(PATERNO).forEach(System.out::println);
        System.out.println("Alumnos con estatura " + ESTATURA);
        repositorioAlumno.readByEstatura(ESTATURA).forEach(System.out::println);
        System.out.println("Alumnos con fechaNac " + FECHA);
        repositorioAlumno.readByFnac(new SimpleDateFormat("yyyy-MM-dd").parse(FECHA)).forEach(System.out::println);
        System.out.println("Alumnos con CURP " + CURP);
        repositorioAlumno.readByCurp(CURP).forEach(System.out::println);
    }

    @Test
    void buscarNulosTest() {
        System.out.println(ALUMNO);
        System.out.println("Alumnos con Paterno Nulo: " + repositorioAlumno.countByPaternoIsNull());
        repositorioAlumno.findByPaternoIsNull().forEach(System.out::println);
        System.out.println("Alumnos con Paterno NO Nulo: " + repositorioAlumno.countByPaternoIsNotNull());
        repositorioAlumno.findByPaternoIsNotNull().forEach(System.out::println);
    }

    @Test
    void buscarAndOrTest() {
        System.out.println(ALUMNO);
        System.out.println("Nombre: " + NOMBRE + " OR Paterno: " + PATERNO);
        if (repositorioAlumno.existsByNombreOrPaterno(NOMBRE, PATERNO)) {
            System.out.println("Existen " + repositorioAlumno.countByNombreOrPaterno(NOMBRE, PATERNO) + " alumnos.");
            repositorioAlumno.queryByNombreOrPaterno(NOMBRE, PATERNO).forEach(System.out::println);
        } else {
            System.out.println("No se encontraron alumnos con los datos proporcionados.");
        }
    }

    @Test
    void buscarPorNombreOrderTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar alumnos por nombre " + NOMBRE);
        System.out.println("Número de alumnos con nombre " + NOMBRE + " " + repositorioAlumno.countByNombre(NOMBRE));
        System.out.println("Ordenado Ascendente");
        repositorioAlumno.findByNombreOrderByPaternoAsc(NOMBRE).forEach(System.out::println);
        System.out.println("Ordenado Descendente");
        repositorioAlumno.findByNombreOrderByPaternoDesc(NOMBRE).forEach(System.out::println);
        System.out.println("Primero");
        repositorioAlumno.readFirstByNombre(NOMBRE).forEach(System.out::println);
        System.out.println("Primeros 2 Asc");
        repositorioAlumno.readTop2ByNombreOrderByPaternoAsc(NOMBRE).forEach(System.out::println);
        System.out.println("Primeros 2 Desc");
        repositorioAlumno.readTop2ByNombreOrderByPaternoDesc(NOMBRE).forEach(System.out::println);
    }

}
