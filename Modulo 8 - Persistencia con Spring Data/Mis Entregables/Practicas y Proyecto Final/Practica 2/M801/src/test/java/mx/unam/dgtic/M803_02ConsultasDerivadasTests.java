package mx.unam.dgtic;

import mx.unam.dgtic.datos.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Date;
import java.util.Arrays;

@SpringBootTest
@ComponentScan("mx.unam.dgtic")
public class M803_02ConsultasDerivadasTests {
    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    private static final String NOMBRE = "Ana";
    private static final String PATERNO = "Perez";
    private static final double ESTATURA = 1.63;
    private static final Date FECHA = Date.valueOf("1991-04-03");
    private static final String CURP = "ROCD910124HDFTLR04";
    private static final String PATRON = "a";

    @Autowired
    AlumnoRepository alumnoRepository;


    @Test
    void buscarInBetweenTest(){
        System.out.println(ALUMNO);

        System.out.println("Alumno IN estatura " + ESTATURA + ", 1.68, 1.56");
        alumnoRepository.searchByEstaturaIn(Arrays.asList(ESTATURA, 1.68, 1.56))
                .forEach(System.out::println);

        System.out.println("Alumno NOT IN estatura " + ESTATURA + ", 1.68, 1.56");
        alumnoRepository.searchByEstaturaNotIn(Arrays.asList(ESTATURA, 1.68, 1.56))
                .forEach(System.out::println);

        System.out.println("Alumno IN " + NOMBRE + ", Carlos, Javier");
        alumnoRepository.searchByNombreIn(Arrays.asList(NOMBRE, "Carlos", "Javier"))
                .forEach(System.out::println);

        System.out.println("Alumno NOT IN " + NOMBRE + ", Carlos, Javier");
        alumnoRepository.searchByNombreNotIn(Arrays.asList(NOMBRE, "Carlos", "Javier"))
                .forEach(System.out::println);

        System.out.println("Alumno Between " + NOMBRE + ", Javier");
        alumnoRepository.searchByNombreBetweenOrderByNombre(NOMBRE, "Javier")
                .forEach(System.out::println);


    }

    @Test
    void buscarPorFechaYEstaturaTest() {
        System.out.println(ALUMNO);
        // Consultas basadas en la fecha de nacimiento
        System.out.println("Buscar alumnos nacidos antes de " + FECHA);
        alumnoRepository.queryByFnacBefore(FECHA).forEach(System.out::println);

        System.out.println("Buscar alumnos nacidos después de " + FECHA);
        alumnoRepository.queryByFnacAfter(FECHA).forEach(System.out::println);

        // Consultas basadas en la estatura
        System.out.println("Buscar alumnos con estatura menor que " + ESTATURA);
        alumnoRepository.queryByEstaturaLessThan(ESTATURA).forEach(System.out::println);

        System.out.println("Buscar alumnos con estatura menor o igual a " + ESTATURA);
        alumnoRepository.queryByEstaturaLessThanEqual(ESTATURA).forEach(System.out::println);

        System.out.println("Buscar alumnos con estatura mayor que " + ESTATURA);
        alumnoRepository.queryByEstaturaGreaterThan(ESTATURA).forEach(System.out::println);

        System.out.println("Buscar alumnos con estatura mayor o igual a " + ESTATURA);
        alumnoRepository.queryByEstaturaGreaterThanEqual(ESTATURA).forEach(System.out::println);
    }

    @Test
    void buscarPatronTest(){
        System.out.println(ALUMNO);

        System.out.println("Alumno nombre inicia con " + PATRON);
        alumnoRepository.findByNombreStartingWith(PATRON).forEach(System.out::println);

        System.out.println("Alumno nombre contiene con " + PATRON);
        alumnoRepository.findByNombreContaining(PATRON).forEach(System.out::println);

        System.out.println("Alumno nombre termina con " + PATRON);
        alumnoRepository.findByNombreEndingWith(PATRON).forEach(System.out::println);

    }

    // El operador Like utiliza dos comedines % cualquier caracter _ posición
    // "a%" en este caso estamos diciendo que tiene a y luego cualquier carcter ergo que empiece con a
    // Tambien se puede negar con un NOT LIKE
    // "_" que tengan 3 caracteres
    // "___a%" que tenga una "a" en la cuarta posición y luego lo que sea
    // "___a% %" que tenga una "a" en la cuarta posición, luego un espacio y despues lo que sea
    // "%a___" que tenga una a en la antepenultima posición
    @ParameterizedTest
    @CsvSource({
            "a%, 'Inicia con a'",
            "%a%, 'Contiene a'",
            "%a, 'Termina con a'",
            "_, 'Tres caracteres'",
            "___a%, 'a en la cuarta posición'",
            "___a% %, 'a en la cuarta posición y dos nombres'",
            "%a___, 'a en el antepenultima posición'",
            "% %, 'Dos nombres'",
            "% %a, 'Dos nombres y el segundo termina con una a'",
    })
    void buscarLikeTest(String patron, String desc){
        System.out.println(ALUMNO);
        System.out.println("Nombre "+desc+" "+patron+" "+alumnoRepository.countByNombreLike(patron));
        alumnoRepository.findByNombreLike(patron).forEach(System.out::println);

        System.out.println("Nombre NO "+desc+" "+patron+" "+alumnoRepository.countByNombreNotLike(patron));
        alumnoRepository.findByNombreNotLike(patron).forEach(System.out::println);
    }
    @Test
    void eliminarLikeTest(){
        System.out.println(ALUMNO);
        System.out.println(alumnoRepository.count()+ " Alumnos antes de eliminar");
        alumnoRepository.deleteByNombreLike("% %").forEach(System.out::println);
        System.out.println(alumnoRepository.count()+ " Alumnos despues de eliminar");

    }



}

