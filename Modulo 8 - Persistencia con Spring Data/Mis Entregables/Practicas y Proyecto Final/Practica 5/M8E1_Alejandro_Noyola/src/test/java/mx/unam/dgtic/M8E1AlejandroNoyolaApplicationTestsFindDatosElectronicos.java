package mx.unam.dgtic;

import mx.unam.dgtic.datos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class M8E1AlejandroNoyolaApplicationTestsFindDatosElectronicos {
    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    final String MATRICULA = "1F";

    @Autowired
    ElectronicosRepository electronicosRepository;

    @Test
    void editarUnoElectronicosTest(){
        System.out.println(ALUMNO);
        System.out.println("Editar Electronico");


        Optional<Electronicos> optional = electronicosRepository.findById(24680);
        if (optional.isPresent()){
            Electronicos electronicos = optional.get();
            System.out.println("Electronico antes de actualizar");
            System.out.println(electronicos);

            electronicos.setNombreElectronico("Xbpx Series S");
            electronicos.setPrecio(9299.00);
            electronicos.setExistencias(75);
            electronicos.setPrecioDeVenta(999.99);
            electronicos.setCostoDeProduccion(900.500);

            electronicosRepository.save(electronicos);
            System.out.println("Electronico despues de actualizar");
            System.out.println(electronicos);
        }else {
            System.out.println("Matricula 1F no localizada");
        }

    }

}

