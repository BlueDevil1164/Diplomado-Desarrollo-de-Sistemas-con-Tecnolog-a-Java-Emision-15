package mx.unam.dgtic;

import mx.unam.dgtic.datos.Materia;
import mx.unam.dgtic.datos.MateriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

import java.util.stream.Stream;

@SpringBootTest
public class M803_01ConsultasDerivadasTests {


    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    private static final String MATERIA = "Álgebra Lineal";
    private static final Integer CREDITOS = 4;
    private static final Integer HORAS = 50;

    @Autowired
    MateriaRepository repositorioMateria;

    @Test
    void buscarPorMateriaTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar materias por nombre " + MATERIA);
        System.out.println("Número de materias con nombre " + MATERIA + " " + repositorioMateria.countByMateria(MATERIA));
        repositorioMateria.findByMateria(MATERIA).forEach(System.out::println);

    }

    @Test
    void buscarPorMateriaNotTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar materias que no tengan nombre " + MATERIA);
        System.out.println("Número de materias que no tienen nombre " + MATERIA + " " + repositorioMateria.countByMateriaNot(MATERIA));
        repositorioMateria.findByMateriaNot(MATERIA).forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Física General", "Biología General", "Literatura Clásica", "Historia Universal"})
    void buscarPorMateriaTest(String materia) {
        System.out.println(ALUMNO);
        System.out.println("Buscar materias por nombre " + materia);
        System.out.println("Número de materias con nombre " + materia + " " + repositorioMateria.countByMateria(materia));
        repositorioMateria.findByMateria(materia).forEach(System.out::println);
    }

    @Test
    @Transactional
    void streamPorMateriaTest() {
        System.out.println(ALUMNO);
        try (Stream<Materia> materiaStream = repositorioMateria.streamByMateriaNot(MATERIA)) {
            System.out.println("Materias con nombre diferente a " + MATERIA);
            materiaStream.forEach(a -> {
                System.out.println("Procesando Materia: " + a.getMateria() + " " + a.getCreditos());
            });
        }
    }

    @Test
    void buscarPorCamposTest() throws ParseException {
        System.out.println(ALUMNO);
        System.out.println("Materias con creditos = " + CREDITOS);
        repositorioMateria.readByCreditos(CREDITOS).forEach(System.out::println);
        System.out.println("Materias con horas = " + HORAS);
        repositorioMateria.readByHoras(HORAS).forEach(System.out::println);
    }

    //----------------------------------------

    /*
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

     */

}
