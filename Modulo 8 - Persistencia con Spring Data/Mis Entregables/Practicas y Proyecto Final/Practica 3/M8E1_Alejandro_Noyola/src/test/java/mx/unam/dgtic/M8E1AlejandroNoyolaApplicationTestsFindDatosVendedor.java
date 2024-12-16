package mx.unam.dgtic;


import mx.unam.dgtic.datos.Comprador;
import mx.unam.dgtic.datos.Vendedor;
import mx.unam.dgtic.datos.VendedorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@SpringBootTest
public class M8E1AlejandroNoyolaApplicationTestsFindDatosVendedor {
    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    final Integer MATRICULA = 23583;
    private static int contador = 1; // Contador estático

    @Autowired
    VendedorRepository vendedorRepository;

    @Test
    void insertarVariosVendedorTest() { //Paso 1 Insercion de usuarios por default
        System.out.println("Insertar varios vendedores");

        List<Vendedor> vendedores = new ArrayList<>();
        long cantidadExistente = vendedorRepository.count(); // Obtener la cantidad actual de vendedores

        for (int i = 0; i < 5; i++) { // Creando 5 usuarios invitados nuevos
            String correo = "Invitado" + (cantidadExistente + i + 1) + "@gmail.com"; // Correos únicos
            String usuario = "InvitadoUser" + (cantidadExistente + i + 1); // Nombres de usuario únicos
            int edad = 25; // Asigna una edad válida (debe ser >= 15)
            String contrasena = "INVITADO" + (cantidadExistente + i + 1); // Asigna una contraseña por defecto
            vendedores.add(new Vendedor("Invitado " + (cantidadExistente + i + 1), "ApellidoInvitado " + (cantidadExistente + i + 1), edad, "N", correo, usuario, contrasena));
        }

        System.out.printf("Existen: %d vendedores antes de la inserción\n", vendedorRepository.count());
        try {
            vendedorRepository.saveAll(vendedores);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
        System.out.printf("Existen: %d vendedores después de la inserción\n", vendedorRepository.count());
        System.out.println("Vendedores en la db:");
        vendedorRepository.findAll().forEach(System.out::println);
    }

    @Test
    void eliminarVariosVendedoresTest() { //Paso 2 Eliminacion de los usuarios por defaul
        System.out.println("Eliminar varios Vendedores");

        // Asumir que MATRICULA se define o se usa una lista de IDs existente
        List<Integer> idsVendedoresAEliminar = IntStream.range(1, 6)
                .map(i -> 97562 + i) // Ajustar el rango según tus IDs
                .boxed()
                .collect(Collectors.toList());

        // Eliminar los vendedores según la lista de IDs
        for (Integer id : idsVendedoresAEliminar) {
            Optional<Vendedor> optional = vendedorRepository.findById(id);
            if (optional.isPresent()) {
                System.out.println("Eliminando vendedor con ID: " + id);
                vendedorRepository.delete(optional.get());
            } else {
                System.out.println("Vendedor con ID " + id + " no localizado");
            }
        }

        // Mostrar todos los vendedores restantes
        System.out.println("Vendedores en la db después de la eliminación:");
        vendedorRepository.findAll().forEach(System.out::println);
    }


    @Test
    void DeleteTest() { //Paso 3 Eliminar la base, repetir desde el paso 1 para repetir el proceso
        System.out.println("BD eliminada");

        // Limpiar registros anteriores
        vendedorRepository.deleteAll();
    }


}









