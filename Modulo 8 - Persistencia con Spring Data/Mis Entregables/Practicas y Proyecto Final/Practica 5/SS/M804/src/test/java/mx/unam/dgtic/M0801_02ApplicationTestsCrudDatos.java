package mx.unam.dgtic;

import mx.unam.dgtic.datos.Alumno;
import mx.unam.dgtic.datos.AlumnoRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
public class M0801_02ApplicationTestsCrudDatos {


    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    final String MATRICULA = "1F";

    @Autowired
    AlumnoRepository repositorioAlumno;

    @Test
    void insertUnoTest() {
        System.out.println(ALUMNO);
        System.out.println("Insertar Alumno");
        LocalDate fechaLocal = LocalDate.of(1983, 7, 27);
        Date fecha = Date.from(fechaLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Alumno alumno = new Alumno(MATRICULA, "FERNANDO", "CASTAÑEDA", fecha, 1.80);
        repositorioAlumno.save(alumno);
        Optional<Alumno> optional = repositorioAlumno.findById(MATRICULA);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("Matricula " + MATRICULA + " no localizada");
        }
    }

    @Test
    void editarUnoTest() {
        System.out.println(ALUMNO);
        System.out.println("Editar Alumno");
        Optional<Alumno> optional = repositorioAlumno.findById(MATRICULA);
        if (optional.isPresent()) {
            Alumno alumno = optional.get();
            System.out.println("Alumno antes de actualizar");
            System.out.println(alumno);
            alumno.setNombre("JOSE FERNANDO");
            alumno.setPaterno("CASTAÑEDA ESTRADA");
            try {
                alumno.setFnac(new SimpleDateFormat("yyyy-MM-dd").parse("1983-07-27"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            repositorioAlumno.save(alumno);
            System.out.println("Alumno despues de la actualizacion");
            System.out.println(repositorioAlumno.findById(MATRICULA).get());
        } else {
            System.out.println("Matricula " + MATRICULA + " no localizada");
        }
    }

    @Test
    void eliminarUnoTest() {
        System.out.println(ALUMNO);
        System.out.println("Eliminar Alumno");
        Optional<Alumno> optional = repositorioAlumno.findById(MATRICULA);
        if (optional.isPresent()) {
            Alumno alumno = optional.get();
            System.out.println("Alumno antes de la eliminacion");
            System.out.println(alumno);
            repositorioAlumno.delete(alumno);
        } else {
            System.out.println("Matricula " + MATRICULA + " no localizada");
        }
        System.out.println("Eliminar alumno por ID");
        repositorioAlumno.deleteById("1A");
        System.out.println("Alumnos en la BD");
        repositorioAlumno.findAll().forEach(System.out::println);
    }

    @Disabled
    @Test
    void eliminarUnoDinamicoTest() throws IOException {
        System.out.println(ALUMNO);
        System.out.println("Eliminar Alumno Dinamico");
        System.out.println("Alumnos en la BD");
        repositorioAlumno.findAll().forEach(System.out::println);
        System.out.print("Ingresa la matricula del alumno a eliminar: ");
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String matricula = entrada.readLine();
        Optional<Alumno> optional = repositorioAlumno.findById(matricula);
        if (optional.isPresent()) {
            Alumno alumno = optional.get();
            System.out.println("Alumno antes de la eliminacion");
            System.out.println(alumno);
            repositorioAlumno.deleteById(matricula);
            System.out.println("Alumno con Matricula " + matricula + " ha sido eliminado");
        } else {
            System.out.println("Matricula " + MATRICULA + " no localizada");
        }
        System.out.println("Alumnos en la BD");
        repositorioAlumno.findAll().forEach(System.out::println);
    }

    @Test
    void insertarVariosTest() {
        System.out.println(ALUMNO);
        System.out.println("Insertar Varios alumnos");
        List<Alumno> alumnos = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            alumnos.add(new Alumno(i + "M", "Marco " + i, "Polo " + i, new Date(), 1.65));
        }
        System.out.println("Existen " + repositorioAlumno.count() + " alumnos antes de la insercion");
        repositorioAlumno.saveAll(alumnos);
        System.out.println("Existen " + repositorioAlumno.count() + " alumnos despues de la insercion");
        System.out.println("Alumnos en la BD");
        repositorioAlumno.findAll().forEach(System.out::println);
    }

    @Test
    void eliminarVariosTest() {
        System.out.println(ALUMNO);
        System.out.println("Eliminar Varios alumnos");
        List<String> matriculas = IntStream.range(1, 6).mapToObj(i -> i + "M").collect(Collectors.toList());
        System.out.println(matriculas);
        System.out.println("Existen " + repositorioAlumno.count() + " alumnos antes de la eliminacion");
        repositorioAlumno.deleteAllById(matriculas);
        System.out.println("Alumnos en la BD");
        repositorioAlumno.findAll().forEach(System.out::println);
    }


}
