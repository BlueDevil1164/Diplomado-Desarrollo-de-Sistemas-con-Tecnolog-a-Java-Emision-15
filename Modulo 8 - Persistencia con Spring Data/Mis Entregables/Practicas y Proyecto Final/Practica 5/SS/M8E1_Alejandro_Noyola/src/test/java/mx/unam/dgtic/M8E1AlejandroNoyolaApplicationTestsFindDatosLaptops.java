package mx.unam.dgtic;

import mx.unam.dgtic.datos.Electronicos;
import mx.unam.dgtic.datos.ElectronicosRepository;
import mx.unam.dgtic.datos.Laptops;
import mx.unam.dgtic.datos.LaptopsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class M8E1AlejandroNoyolaApplicationTestsFindDatosLaptops {
    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    final Integer MATRICULA = 23583;

    @Autowired
    LaptopsRepository laptopsRepository;

    @Test
    void eliminarUnoLaptopsTest(){
        System.out.println(ALUMNO);
        System.out.println("Eliminar Laptop");


        Optional<Laptops> optional = laptopsRepository.findById(MATRICULA);
        if (optional.isPresent()){
            System.out.println("Laptop antes de eliminacion");
            System.out.println(laptopsRepository.findById(MATRICULA));
            System.out.println("----------------------------------------------");

            laptopsRepository.delete(optional.get());
            System.out.println("----------------------------------------------");


        }else {
            System.out.println("Matricula " + MATRICULA + " no localizada");
        }
        System.out.println("Elliminar laptop por id");
        laptopsRepository.deleteById(23583);

        System.out.println("Laptops de la BD");
        laptopsRepository.findAll().forEach(System.out::println);

    }

}

