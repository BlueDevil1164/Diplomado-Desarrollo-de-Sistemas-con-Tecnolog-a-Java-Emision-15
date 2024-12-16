package mx.unam.dgtic;

import mx.unam.dgtic.datos.AlumnoNamedQueryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
public class M804_01ConsultasNombradasTests {


    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
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

        Date fecha = Date.valueOf(FECHA);
        System.out.println("Buscar Altos despues de fecha");
        repositorioAlumno.buscarAltosConFecha(fecha).forEach(System.out::println);

        System.out.println("Buscar por nombre y paterno");
        repositorioAlumno.buscarPorNombreYPaterno(NOMBRE, PATERNO).forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"NSR", "NMR", "MDF"})
    void buscarPorCurpContengaTest(String substring) {
        System.out.println(ALUMNO);
        System.out.println("Buscar por Curp contenga: " + substring);
        System.out.println("Coinciden " + repositorioAlumno.contarPorCurpContenga(substring) + " Alumnos");
        repositorioAlumno.buscarPorCurpContenga(substring).forEach(System.out::println);
    }

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

    @Test
    void buscarEstaturaTest() {
        Double estaturafin = 1.68;
        System.out.println(ALUMNO);
        System.out.println("Alumnos NOT BETWEEN estatura " + ESTATURA + " y " + estaturafin);
        repositorioAlumno.searchByEstaturaNotBetweenOrderByEstatura(ESTATURA, estaturafin).forEach(
                a -> System.out.println(a.getEstatura() + " " + a.getNombre() + " " + a.getPaterno())
        );
        System.out.println("Estatura Promedio " + repositorioAlumno.leerEstaturaPromedio());
        System.out.println("Alumnos más altos que la estatura promedio");
        repositorioAlumno.buscarAltosMayorPromedio().forEach(
                a -> System.out.println(a.getEstatura() + " " + a.getNombre() + " " + a.getPaterno())
        );
    }

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
        repositorioAlumno.findByCurpRegexp(regex).forEach(
                a -> System.out.println(a.getCurp() + " " + a.getNombre() + " " + a.getPaterno())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ROXANA GUTIERREZ",
            "GUTIERREZ ROXANA",
            "ROXANA",
            "GUTIERREZ",
            "MIGUEL GUTIERREZ"
    })
    void buscarCombinacionNombrePaternoTest(String combinacion) {
        System.out.println(ALUMNO);
        System.out.println("Buscar combinacion " + combinacion);
        repositorioAlumno.buscarPorCombinacionNombrePaterno(combinacion).forEach(
                a -> System.out.println(a.getNombre() + " " + a.getPaterno())
        );
    }

    @Test
    void buscarDistinctNombrePaternoTest() {
        System.out.println(ALUMNO);
        System.out.println("Lista de nombres únicos");
        repositorioAlumno.findDistinctNombre().forEach(System.out::println);
        System.out.println("Lista de paternos únicos");
        repositorioAlumno.findDistinctPaterno().forEach(System.out::println);
        System.out.println("Lista de nombres y paternos únicos");
        repositorioAlumno.findDistinctNombrePaterno().forEach(System.out::println);
    }

    @Test
    void conteoPorCamposTest() {
        System.out.println(ALUMNO);
        System.out.println("Contar por nombre");
        repositorioAlumno.contarPorNombre().forEach(
                cp -> System.out.println(cp.getCampo() + " " + cp.getConteo())
        );
        System.out.println(ALUMNO);
        System.out.println("Contar por paterno");
        repositorioAlumno.contarPorPaterno().forEach(
                cp -> System.out.println(cp.getCampo() + " " + cp.getConteo())
        );
        System.out.println(ALUMNO);
        System.out.println("Contar por año");
        repositorioAlumno.contarPorAnio().forEach(
                cp -> System.out.println(cp.getCampo() + " " + cp.getConteo())
        );
        System.out.println(ALUMNO);
        System.out.println("Contar por estado");
        repositorioAlumno.contarPorEstado().forEach(
                cp -> System.out.println(cp.getCampo() + " " + cp.getConteo())
        );
        System.out.println(ALUMNO);
        System.out.println("Contar por sexo");
        repositorioAlumno.contarPorSexo().forEach(
                cp -> System.out.println(cp.getCampo() + " " + cp.getConteo())
        );
    }

}
