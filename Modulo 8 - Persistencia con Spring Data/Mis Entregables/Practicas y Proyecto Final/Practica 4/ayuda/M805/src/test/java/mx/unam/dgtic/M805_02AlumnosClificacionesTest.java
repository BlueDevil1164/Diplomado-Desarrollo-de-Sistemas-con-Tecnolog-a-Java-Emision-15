package mx.unam.dgtic;

import mx.unam.dgtic.datos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class M805_02AlumnosClificacionesTest {
    final String ALUMNO = "CAROLINA ALVAREZ RODEA";
    private static final String MATERIA = "BD";
    private static final int CALIFICACION = 8;
    private static final String NOMBRE = "Perla";
    private static final String PATERNO = "Perez";
    private static final int ID_ESTADO = 10;

    @Autowired
    AlumnoRepository repositorioAlumno;
    @Autowired
    CalificacionRepository repositorioCalificacion;
    @Autowired
    EstadoRepository repositorioEstado;

    @Test
    void buscarAlumnosCalificacionesTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar todos los alumnos con sus calificaciones");

        repositorioAlumno.buscarTodosConCalificaciones().forEach(a->{
            System.out.println("--- Alumno ---");
            System.out.println(a.getNombre()+" "+a.getPaterno()+
                    " "+a.getEstado().getEstado());
            a.getCalificaciones().forEach(c->{
                System.out.println(c.getMateria() +" "+c.getCalificacion());
            });
        });
    }

    @Test
    void buscarCalificacionesAlumnoTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar todas las calificaciones y sus Alumnos");
        repositorioCalificacion.findAll().forEach(c->{
            System.out.println("Materia "+ c.getMateria() + ", "
                    +"Calificacion " +c.getCalificacion() + ", "
                    +"Alumno " + c.getAlumno().getNombre() +", "
                          +c.getAlumno().getPaterno()
                          + " " +c.getAlumno().getEstado().getAbreviatura()
                    );
                });
    }

    @Test
    void insertarCalificacionesTest(){
        System.out.println(ALUMNO);
        System.out.println("Insertar calificaciones");
        System.out.println("1. Insertat Alumno");
        Alumno a =  new Alumno("1F", "CAROLINA", "ALVAREZ", new Date(), 1.74);

        a.setEstado(repositorioEstado.findById(ID_ESTADO).get());
        repositorioAlumno.save(a);

        Optional<Alumno> optional = repositorioAlumno.findById("1F");
        if(optional.isPresent()){
            System.out.println(optional.get());
            System.out.println("2. Insertar Calificaciones");
            Calificacion c =  new Calificacion(11, MATERIA, CALIFICACION, optional.get());
            repositorioCalificacion.save(c);
            c =  new Calificacion(12, "JAVA", CALIFICACION, optional.get());
            repositorioCalificacion.save(c);
        } else{
            System.out.println("Matricula 1F no localizada");
        }
    }
}
