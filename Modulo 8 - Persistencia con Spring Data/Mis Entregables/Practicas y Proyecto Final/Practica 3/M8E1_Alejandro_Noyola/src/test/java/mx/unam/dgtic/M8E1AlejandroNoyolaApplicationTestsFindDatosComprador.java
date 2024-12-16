package mx.unam.dgtic;

import mx.unam.dgtic.datos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class M8E1AlejandroNoyolaApplicationTestsFindDatosComprador {
    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    final String MATRICULA = "1F";

    @Autowired
    CompradorRepository compradorRepository;

    @Test
    void insertarUnoCompradorTest(){
        System.out.println(ALUMNO);
        System.out.println("Insertar Comprador");


        Comprador comprador = new Comprador(13579, "Valerie", "Noyola", 27, "F", "Vale1164@gmail.com", "GoldenEyes1164", "Vale@r360");


        compradorRepository.save(comprador);

        Optional<Comprador> optional = compradorRepository.findById(13579);
        if (optional.isPresent()){
            System.out.println("Recuperar comprador desde la BD");
            System.out.println(optional.get());
        }else {
            System.out.println("Matricula 13579 no localizada");
        }

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
