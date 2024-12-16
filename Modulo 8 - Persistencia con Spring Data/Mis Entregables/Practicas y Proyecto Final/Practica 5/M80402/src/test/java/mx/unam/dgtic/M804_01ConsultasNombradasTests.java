package mx.unam.dgtic;

import mx.unam.dgtic.datos.MateriaNamedQueryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M804_01ConsultasNombradasTests {

    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    private static final String MATERIA = "Álgebra Lineal";
    private static final Integer CREDITOS = 4;
    private static final Integer HORAS = 50;

    @Autowired
    MateriaNamedQueryRepository repositorioMateria;

    @Test
    void buscarNamedQueryTest() {
        System.out.println(ALUMNO);

        System.out.println("Buscar Altos");
        repositorioMateria.buscarAltos().forEach(System.out::println);

        Integer horas = Integer.valueOf(HORAS);
        System.out.println("Buscar Altos despues de horas");
        repositorioMateria.buscarAltosConHoras(horas).forEach(System.out::println);

        System.out.println("Buscar por materia y creditos");
        repositorioMateria.buscarPorMateriaYCreditos(MATERIA, CREDITOS).forEach(System.out::println);
    }
/*
    @ParameterizedTest
    @ValueSource(strings = {"NSR", "NMR", "MDF"})
    void buscarPorCurpContengaTest(String substring) {
        System.out.println(ALUMNO);
        System.out.println("Buscar por Curp contenga: " + substring);
        System.out.println("Coinciden " + repositorioMateria.contarPorCurpContenga(substring) + " Alumnos");
        repositorioMateria.buscarPorCurpContenga(substring).forEach(System.out::println);
    }
    */
/*
    @ParameterizedTest
    @CsvSource({
            "DF, Ciudad de México",
            "NL, Nuevo León",
            "QT, Querétaro",
            "GT, Guanajuato",
            "GR, Guerrero"
    })
    void buscarPorCurpEstadoTest(String codigoEstado, String nombreEstado) {
        System.out.println(ALUMNO);
        System.out.println("Buscar por Curp estado: " + nombreEstado);
        System.out.println("Almnos nacidos en " + nombreEstado + " " + repositorioAlumno.contarPorEstadoCurp(codigoEstado));
        repositorioAlumno.buscarPorEstadoCurp(codigoEstado).forEach(
                a -> System.out.println(a.getCurp() + " " + a.getNombre() + " " + a.getPaterno())
        );
    }

 */

    @Test
    void buscarHorasTest() {
        Integer horasfin = 80;
        System.out.println(ALUMNO);
        System.out.println("Materias NOT BETWEEN horas " + HORAS + " y " + horasfin);
        repositorioMateria.searchByHorasNotBetweenOrderByHoras(HORAS, horasfin).forEach(
                a -> System.out.println(a.getHoras() + " " + a.getMateria() + " " + a.getCreditos())
        );
        System.out.println("-----------------------------------------------------------");
        System.out.println("Horas Promedio " + repositorioMateria.leerHorasPromedio());
        System.out.println("Materias más altas que las horas promedio");
        System.out.println("-----------------------------------------------------------");

        repositorioMateria.buscarAltosMayorPromedio().forEach(
                a -> System.out.println(a.getHoras() + " " + a.getMateria() + " " + a.getCreditos())
        );
    }

    @Test
    void buscarCreditosTest() {
        Integer creditosfin = 6;
        System.out.println(ALUMNO);
        System.out.println("Materias NOT BETWEEN creditos " + CREDITOS + " y " + creditosfin);
        repositorioMateria.searchByCreditosNotBetweenOrderByCreditos(CREDITOS, creditosfin).forEach(
                a -> System.out.println(a.getCreditos() + " " + a.getMateria() + " " + a.getHoras())
        );
        System.out.println("-----------------------------------------------------------");
        System.out.println("Creditos Promedio " + repositorioMateria.leerCreditosPromedio());
        System.out.println("Materias más altas que los creditos promedio");
        System.out.println("-----------------------------------------------------------");

        repositorioMateria.buscarAltosMayorPromedio().forEach(
                a -> System.out.println(a.getCreditos() + " " + a.getMateria() + " " + a.getHoras())
        );
    }


/*
    @ParameterizedTest
    @CsvSource({
            "'^.{10}M.{7}$', 'Buscar Mujeres'",   // CURP para mujeres (dígito 11 es "M")
            "'^.{10}H.{7}$', 'Buscar Hombres'",    // CURP para hombres (dígito 11 es "H")
            "'^(?![A-Z]{4}\\d{6}[HM][A-Z]{5}\\d{2}).*$', 'CURP no válidos'", // CURP no válidos
            "'^[A-Z]{4}\\d{6}[HM](?!QT|DF)[A-Z]{5}\\d{2}$', 'No son de QT ni DF'"  // No pertenecen a QT ni DF
    })
    void buscarCurpRegexTest(String regex, String desc) {
        System.out.println(ALUMNO);
        System.out.println("Resultados para la expresión regular " + regex + " (" + desc + ")");
        repositorioMateria.findByCurpRegexp(regex).forEach(
                a -> System.out.println(a.getCurp() + " " + a.getNombre() + " " + a.getPaterno())
        );
    }

 */

    @ParameterizedTest
    @ValueSource(strings = {
            "Biología General",
            "Física General",
            "Historia Universal",
            "Literatura Clásica",
            "Matemáticas Básicas"
    })
    void buscarCombinacionMateriaCreditosTest(String combinacion) {
        System.out.println(ALUMNO);
        System.out.println("Buscar combinacion " + combinacion);
        repositorioMateria.buscarPorCombinacionMateriaCreditos(combinacion).forEach(
                a -> System.out.println(a.getMateria() + " " + a.getCreditos())
        );
    }

    @Test
    void buscarDistinctMateriaCreditosTest() {
        System.out.println(ALUMNO);
        System.out.println("Lista de nombres únicos");
        repositorioMateria.findDistinctMateria().forEach(System.out::println);
        System.out.println("Lista de paternos únicos");
        repositorioMateria.findDistinctCreditos().forEach(System.out::println);
        System.out.println("Lista de nombres y paternos únicos");
        repositorioMateria.findDistinctMateriaCreditos().forEach(System.out::println);
    }

    @Test
    void conteoPorCamposTest() {
        System.out.println(ALUMNO);
        System.out.println("Contar por materia");
        repositorioMateria.contarPorMateria().forEach(
                cp -> System.out.println(cp.getCampo() + " " + cp.getConteo())
        );
        System.out.println(ALUMNO);
        System.out.println("Contar por creditos");
        repositorioMateria.contarPorCreditos().forEach(
                cp -> System.out.println(cp.getCampo() + " " + cp.getConteo())
        );
        System.out.println(ALUMNO);
        System.out.println("Contar por año Horas");
        repositorioMateria.contarPorHoras().forEach(
                cp -> System.out.println(cp.getCampo() + " " + cp.getConteo())
        );

    }

}
