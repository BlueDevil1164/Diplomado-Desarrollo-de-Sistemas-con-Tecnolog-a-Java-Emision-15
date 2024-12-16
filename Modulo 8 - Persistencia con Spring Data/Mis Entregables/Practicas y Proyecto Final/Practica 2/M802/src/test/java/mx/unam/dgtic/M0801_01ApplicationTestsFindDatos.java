package mx.unam.dgtic;

import mx.unam.dgtic.datos.Alumno;
import mx.unam.dgtic.datos.AlumnosRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class M0801_01ApplicationTestsFindDatos {
    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";

    @Autowired
    AlumnosRepository repositorioAlumno;

    @Test
    void buscarTodosTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar todos los alumnos");

        System.out.println("Existen "+ repositorioAlumno.count() + " alumnos en la tabla");

        Iterable<Alumno> iterablea =repositorioAlumno.findAll();
        iterablea.forEach(System.out::println);

        List<Alumno> alumnos = new ArrayList<Alumno>();
        iterablea.forEach(alumnos::add);
        System.out.println(alumnos);

        System.out.println("Datos de Alumnos");
        iterablea.forEach((alumno) -> {
            System.out.println(alumno.getNombre() + "|" + alumno.getPaterno()
                        + "|" + alumno.getFnac() + "|" + alumno.getEstatura());
        });

        System.out.println("Alumnos stream directo");
        repositorioAlumno.findAll().forEach(System.out::println);
    }
    /////cuarta captura
    @Test
    void  buscarTest(){
       String matricula = "4A";
        System.out.println(ALUMNO);
        System.out.println("Buscar Alumno por ID " + matricula);
        Optional<Alumno> optional = repositorioAlumno.findById(matricula);

        if (optional.isPresent()){
            System.out.println(optional.get());
            Alumno a = optional.get();
            System.out.println("Nombre " + a.getNombre());
            System.out.println("Paterno " + a.getPaterno());
            System.out.println("Fnac " + a.getFnac());
            System.out.println("Estatura " +  a.getEstatura());
        }else {
            System.out.println("Matricula " + matricula + " no localizada");
        }
    }

    @Test
    void buscarVariosTest(){
        System.out.println(ALUMNO);
        System.out.println("buscar varios alumnos#");


        repositorioAlumno.findAllById(List.of("2A", "4A", "3B", "100x")).forEach(
                alumno -> System.out.println(
                        "Matricula: "+ alumno.getMatricula()
                                + "Nombre: "+ alumno.getNombre()
                                + "Apellido: "  + alumno.getPaterno())
        );
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
