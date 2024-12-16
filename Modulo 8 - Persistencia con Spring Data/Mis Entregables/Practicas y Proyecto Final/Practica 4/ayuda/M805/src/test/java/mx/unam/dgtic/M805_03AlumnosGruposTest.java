package mx.unam.dgtic;

import mx.unam.dgtic.datos.Alumno;
import mx.unam.dgtic.datos.AlumnoRepository;
import mx.unam.dgtic.datos.GrupoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class M805_03AlumnosGruposTest {
    final String ALUMNO = "CAROLINA ALVAREZ RODEA";
    final String MATRICULA = "1A";
    @Autowired
    AlumnoRepository repositorioAlumno;
    @Autowired
    GrupoRepository repositorioGrupo;

    @Transactional
    @Test
    void buscarGruposPorAlumno(){
        System.out.println(ALUMNO);
        System.out.println("Buscar grupos por Alumno");

        repositorioAlumno.findAll().forEach(a->{
            System.out.println(a.getMatricula()+ " " + a.getNombre() +  " " + a.getPaterno() + " "
                    + a.getEstado().getAbreviatura());
            a.getGrupos().forEach(g->{
                System.out.println("Id Grupo "+ g.getId() + " Grupo " + g.getGrupo());
            });
        });

    }

    @Test
    @Transactional
    void buscarAlumnosPorGrupoTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar Alumnos por Grupo");
        repositorioGrupo.findAll().forEach(g->{
            System.out.println(g.getId()+" "+g.getGrupo());
            g.getAlumnos().forEach(a->{
                System.out.println(a.getMatricula()+ " " + a.getNombre() +  " " + a.getPaterno() + " "
                        + a.getEstado().getAbreviatura());
            });
        });
    }

    @Transactional
    @Test
    void buscarGruposPorMatricula(){
        System.out.println(ALUMNO);
        System.out.println("Buscar Grupos por Matricula");
        repositorioAlumno.findGruposByMatricula(MATRICULA).forEach(System.out::println);
    }

    @Test
    @Transactional
    void agregarAlumnoGrupo(){
        System.out.println(ALUMNO);
        System.out.println("Agregar Alumno a Grupo");
        Optional<Alumno> optional = repositorioAlumno.findById("1F");
        Alumno a = optional.get();
        a.addGrupo(repositorioGrupo.findById(1).get());
        a.addGrupo(repositorioGrupo.findById(3).get());

        repositorioAlumno.save(a);

        repositorioAlumno.findGruposByMatricula("1F").forEach(System.out::println);

        System.out.println("Remover Alumno de Grupo");
        a.removeGrupo(repositorioGrupo.findById(3).get());
        repositorioAlumno.save(a);
        repositorioAlumno.findGruposByMatricula("1F").forEach(System.out::println);
    }

}
