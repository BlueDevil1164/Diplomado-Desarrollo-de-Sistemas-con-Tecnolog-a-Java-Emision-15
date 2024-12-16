package mx.unam.dgtic;

import mx.unam.dgtic.datos.Alumno;
import mx.unam.dgtic.datos.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class M801_01ApplicationTestsFindDatos {

    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";

    @Autowired
    AlumnoRepository repositorioAlumno;

    @Test
    void buscarTodosTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar todos los alumnos");
        System.out.println("Existen " + repositorioAlumno.count() + " alumnos en la tabla");
        System.out.println("Lista de alumnos");
        Iterable<Alumno> iterable = repositorioAlumno.findAll();
        iterable.forEach(System.out::println);
        List<Alumno> alumnos = new ArrayList<Alumno>();
        iterable.forEach(alumnos::add);
        System.out.println(alumnos);
        System.out.println("Datos de alumnos");
        iterable.forEach((alumno) -> {
            System.out.println(
                    alumno.getNombre() + "|" +
                            alumno.getPaterno() + "|" +
                            alumno.getFnac() + "|" +
                            alumno.getEstatura()
            );
        });
        System.out.println("Alumnos stream directo");
        repositorioAlumno.findAll().forEach(System.out::println);
    }

    @Test
    void buscarUnoTest() {
        String matricula = "4A";
        System.out.println(ALUMNO);
        System.out.println("Buscar Alumno por ID " + matricula);
        Optional<Alumno> optional = repositorioAlumno.findById(matricula);
        if (optional.isPresent()) {
            System.out.println(optional.get());
            Alumno a = optional.get();
            System.out.println("Nombre: " + a.getNombre());
            System.out.println("Paterno: " + a.getPaterno());
            System.out.println("FNac: " + a.getFnac());
            System.out.println("Estatura: " + a.getEstatura());
        } else {
            System.out.println("Matricula " + matricula + " no localizada");
        }
    }

    @Test
    void buscarVariosTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar varios alumnos en lista");
        repositorioAlumno.findAllById(List.of("2A", "4A", "3B", "100X"))
                .forEach(a -> System.out.println(
                        "Matricula " + a.getMatricula() +
                                " Nombre " + a.getNombre() +
                                " Paterno " + a.getPaterno()
                ));
    }

}
