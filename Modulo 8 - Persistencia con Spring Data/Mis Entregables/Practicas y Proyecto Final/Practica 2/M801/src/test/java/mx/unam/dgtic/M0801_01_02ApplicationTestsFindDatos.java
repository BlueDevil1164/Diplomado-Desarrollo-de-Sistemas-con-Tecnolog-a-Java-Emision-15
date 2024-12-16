package mx.unam.dgtic;

import mx.unam.dgtic.datos.Alumno;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import mx.unam.dgtic.datos.AlumnoRepository;


@SpringBootTest
public class M0801_01_02ApplicationTestsFindDatos {
    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    final String MATRICULA = "1F";

    @Autowired
    AlumnoRepository alumnoRepository;

    @Test
    void insertarUnoTest(){
        System.out.println(ALUMNO);
        System.out.println("Insertar Alumno");

        LocalDate fechaLocal = LocalDate.of(1987, 6, 26);
        Date fecha = Date.from(fechaLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Alumno alumno = new Alumno("1F", "ALEJANDRO","NOYOLA", fecha, 1.78);


        alumnoRepository.save(alumno);

        Optional<Alumno> optional = alumnoRepository.findById("1F");
        if (optional.isPresent()){
            System.out.println("Recuperar alumno desde la BD");
            System.out.println(optional.get());
        }else {
            System.out.println("Matricula 1F no localizada");
        }

    }

    @Test
    void editarUnoTest(){
        System.out.println(ALUMNO);
        System.out.println("Editar Alumno");


        Optional<Alumno> optional = alumnoRepository.findById("1F");
        if (optional.isPresent()){
            Alumno alumno = optional.get();
            System.out.println("Alumno antes de actualizar");
            System.out.println(alumno);

            alumno.setNombre("Ale");
            alumno.setPaterno("NOYOLA NAZARIO");
            alumno.setEstatura(1.78);

            try{
                alumno.setFnac(new SimpleDateFormat("yyyy-MM-dd").parse("1998-01-06"));
            } catch (ParseException e){
                throw new RuntimeException();
            }
            alumnoRepository.save(alumno);

        }else {
            System.out.println("Matricula 1F no localizada");
        }

    }

    @Test
    void eliminarUnoTest(){
        System.out.println(ALUMNO);
        System.out.println("Eliminar Alumno");


        Optional<Alumno> optional = alumnoRepository.findById(MATRICULA);
        if (optional.isPresent()){
            System.out.println("Alumno antes de eliminacion");
            alumnoRepository.delete(optional.get());


        }else {
            System.out.println("Matricula" + MATRICULA + "no localizada");
        }
        System.out.println("Elliminar alumno por id");
        alumnoRepository.deleteById("1A");

        System.out.println("Alumnos de la BD");
        alumnoRepository.findAll().forEach(System.out::println);

    }

    /*
    @Test
    void eliminarUnoDinamicoTest(){
        System.out.println(ALUMNO);
        System.out.println("Eliminar Alumno Dinamico");

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce la matricula a eliminar: ");
        String matricula = entrada.readLine();

        Optional<Alumno> optional = alumnoRepository.findById(matricula);
        if (optional.isPresent()){
            System.out.println("Alumno antes de eliminacion");
            alumnoRepository.deleteById(optional.get());
            System.out.println("Alumnos con matricula" + matricula + "ha sido eliminado");

        }else {
            System.out.println("Matricula" + matricula + "no localizada");
        }

    }

     */

    @Test
    void insertarVariosTest(){
        System.out.println(ALUMNO);
        System.out.println("Insertar varios alumnos");

        List<Alumno> alumnos = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            alumnos.add(new Alumno(i+"M", "Marco "+i, "Polo "+i, new Date(), 1.70));
        }

        System.out.printf("Existen: %d alumnos antes de la insersion\n", alumnoRepository.count());
        alumnoRepository.saveAll(alumnos);
        System.out.printf("Existen: %d alumnos despues de la insersion\n", alumnoRepository.count());
        System.out.println("Alumnos en la db:");
        alumnoRepository.findAll().forEach(System.out::println);

    }

    @Test
    void eliminarVariosTest(){
        System.out.println(ALUMNO);
        System.out.println("Eliminar varios Alumnos");


        List<String> matriculas = IntStream.range(1,6).mapToObj(i -> i+"M").collect(Collectors.toList());
        Optional<Alumno> optional = alumnoRepository.findById(MATRICULA);
        if (optional.isPresent()){
            System.out.println("Alumno antes de eliminacion");
            alumnoRepository.delete(optional.get());


        }else {
            System.out.println("Matricula" + MATRICULA + "no localizada");
        }
        System.out.println("Elliminar alumno por id");
        alumnoRepository.deleteById("1A");

        System.out.println("Alumnos en la db");
        alumnoRepository.findAll().forEach(System.out::println);

    }




}

/*
1. Cargar esquema y Datos
2. Properties
3. Buscar Todos Alumnos
4. Buscar uno
5. Entitiy Materia

6. MateriaRepository
7. Listar todas las materias
 */
