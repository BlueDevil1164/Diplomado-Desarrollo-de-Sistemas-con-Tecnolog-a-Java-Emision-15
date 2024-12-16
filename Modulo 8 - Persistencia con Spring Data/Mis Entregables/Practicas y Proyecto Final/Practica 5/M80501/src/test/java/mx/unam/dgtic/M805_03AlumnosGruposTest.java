package mx.unam.dgtic;

import mx.unam.dgtic.datos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class M805_03AlumnosGruposTest {
    final String ALUMNO = "ALEJANDRO NOYOLA NAZARIO";

    private static final String MATRICULA = "1A";


    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    GrupoRepository grupoRepository;

    @Test
    @Transactional
    void buscarGruposPorAlumno(){
        System.out.println(ALUMNO);
        System.out.println("Buscar grupos por Alumno");

        alumnoRepository.findAll().forEach(a-> {
            System.out.println(a.getNombre() + " " + a.getPaterno() + " "
                    + a.getEstado().getAbreviatura());
            a.getGrupos().forEach(g->{
                System.out.println("Id Grupo " + g.getId() + "Grupo" + g.getGrupo());
            });
        });
    }

    @Test
    @Transactional
    void  buscarAlumnosPorGruposTest(){
        System.out.println(ALUMNO);
        System.out.println("BuscarAlumnos por Grupos");
        grupoRepository.findAll().forEach(g -> {
            System.out.println(g.getId() + " " + g.getGrupo());
            g.getAlumnos().forEach(a ->{
                System.out.println(a.getMatricula() + " " + a.getNombre() + " "
                        + a.getPaterno() + " " + a.getEstado().getAbreviatura());
            });
        });
    }

    @Test
    void buscarGruposPorMatriculaTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar Grupos por Matricula");
        alumnoRepository.findGruposByMatricula(MATRICULA).forEach(System.out::println);

    }

    @Test
    @Transactional
    void agregarAlumnoGrupo(){
        System.out.println(ALUMNO);
        System.out.println("Agregar Alumno a Grupo");
        Optional<Alumno> optional = alumnoRepository.findById("1F");
        Alumno a = optional.get();
        a.addGrupo(grupoRepository.findById(1).get());
        a.addGrupo(grupoRepository.findById(3).get());

        alumnoRepository.save(a);

        alumnoRepository.findGruposByMatricula("1F").forEach(System.out::println);

        System.out.println("Remover Alumno");
        a.removeGrupo(grupoRepository.findById(3).get());
        alumnoRepository.save(a);
        alumnoRepository.findGruposByMatricula("1F").forEach(System.out::println);
    }
}