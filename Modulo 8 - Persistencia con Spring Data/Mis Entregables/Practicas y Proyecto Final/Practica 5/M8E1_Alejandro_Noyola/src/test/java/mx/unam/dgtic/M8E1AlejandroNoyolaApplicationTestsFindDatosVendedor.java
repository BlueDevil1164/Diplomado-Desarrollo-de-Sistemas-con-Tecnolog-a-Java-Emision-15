package mx.unam.dgtic;

import mx.unam.dgtic.datos.Laptops;
import mx.unam.dgtic.datos.LaptopsRepository;
import mx.unam.dgtic.datos.Vendedor;
import mx.unam.dgtic.datos.VendedorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@SpringBootTest
public class M8E1AlejandroNoyolaApplicationTestsFindDatosVendedor {
    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    final Integer MATRICULA = 23583;

    @Autowired
    VendedorRepository vendedorRepository;

    /*
    @Test
    void insertarVariosCompradorTest(){
        System.out.println(ALUMNO);
        System.out.println("Insertar varios vendedores");

        List<Vendedor> vendedores = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            vendedores.add(new Vendedor(i+ 97541 , "Marco "+i, "Polo "+i, 75, "M", " MarcoPolo1117","MP@r360"));
        }

        System.out.printf("Existen: %d vendedores antes de la insersion\n", vendedorRepository.count());
        vendedorRepository.saveAll(vendedores);
        System.out.printf("Existen: %d vendedores despues de la insersion\n", vendedorRepository.count());
        System.out.println("Vendedores en la db:");
        vendedorRepository.findAll().forEach(System.out::println);

    }

     /*

    @Test
    void eliminarVariosCompradorTest(){
        System.out.println(ALUMNO);
        System.out.println("Eliminar varios Alumnos");


        List<Integer> idVendedor = IntStream.range(1,6).mapToObj(i -> i+"M").collect(Collectors.toList());
        Optional<Vendedor> optional = alumnoRepository.findById(MATRICULA);
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
    */


}

