package dgtic.core.servicio;

import dgtic.core.modelo.Comprador;
import dgtic.core.modelo.Electronico;
import dgtic.core.modelo.excepciones.PrecioInvalido;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.CompradorRepositorio;
import dgtic.core.repositorio.ElectronicoRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static dgtic.core.repositorio.BaseDeDatos.compradores;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = CompradorServicioImplTest.class)
@ComponentScan("dgtic.core")

class CompradorServicioImplTest {

    @Mock
    private ElectronicoRepositorio electronicoRepositorio;

    @Mock
    private CompradorRepositorio compradorRepositorio;

    //private CompradorService compradorService;

    @InjectMocks
    private  CompradorServiceImpl compradorService;

    private List<Comprador> compradores;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        compradores = BaseDeDatos.compradores; // Accede directamente a la lista de compradores
    }

    @Test //Busqueda de todos los Compradores
    void testFindAll() {
        System.out.println("La prueba 'testFindAll' ha pasado correctamente!");

        when(compradorRepositorio.findAll()).thenReturn(compradores);

        List<Comprador> result = compradorRepositorio.findAll();
        assertNotNull(result);
        assertEquals(compradores.size(), result.size());

        // Imprimir información de todos los compradores
        System.out.println("Lista de Compradores:");
        for (Comprador comprador : result) {
            System.out.println("Matrícula: " + comprador.getMatricula() +
                    ", Nombre: " + comprador.getNombre() +
                    ", Apellido: " + comprador.getApellido() +
                    ", Edad: " + comprador.getEdad() +
                    ", Correo: " + comprador.getCorreo());
        }
    }

    @Test //Busqueda por Id y Nombre
    void testFindByIdAndName() {
        System.out.println("La prueba 'testFindByIdAndName' ha pasado correctamente!");

        when(compradorRepositorio.findById(anyString())).thenReturn(compradores.stream()
                .filter(c -> c.getMatricula().equals("118\n"))
                .findFirst()
                .orElse(null));

        Comprador comprador = compradorService.findById("118\n");
        assertNotNull(comprador);
        assertEquals("Rose\n", comprador.getNombre());

        System.out.println("Comprador encontrado: " + comprador.getNombre());
        System.out.println("Datos encontrados:");
        System.out.println("Matrícula: " + comprador.getMatricula() +
                ", Nombre: " + comprador.getNombre() +
                ", Apellido: " + comprador.getApellido() +
                ", Edad: " + comprador.getEdad() +
                ", Correo: " + comprador.getCorreo());

    }

    @Test //Prueba de un comprador de un ID inexistente
    void testFindByIdNotFound() {
        System.out.println("La prueba 'testFindByIdNotFound' ha pasado correctamente!");

        when(compradorRepositorio.findById(anyString())).thenReturn(null);

        Comprador comprador = compradorService.findById("126\n");
        assertNull(comprador); // Verifica que no se encontró

        System.out.println("No se encontró el comprador con matrícula '126'.");
    }

    @Test // Prueba para la verifocacion de un precio existente en la BD
    void testSetPrecioValido() {
        System.out.println("La prueba 'testSetPrecioValido' ha pasado correctamente!");

        Electronico electronico = new Electronico();
        electronico.setPrecio(15000);
        assertEquals(15000, electronico.getPrecio());
    }

    @Test //Despligue y uso de la Excepcion "Precio Invalido"
    void testSetPrecioInvalido() {
        System.out.println("La prueba 'testSetPrecioInvalido' ha pasado correctamente!");

        Electronico electronico = new Electronico();
        Exception exception = assertThrows(PrecioInvalido.class, () -> {
            electronico.setPrecio(-1);
        });

        String expectedMessage = "Precio no valido, no puede ser menor a 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test //Despligue de un comprador y sus electronicos comprados
    void testCompradorConElectronicos() {
        System.out.println("La prueba 'testCompradorConElectronicos' ha pasado correctamente!");

        Comprador comprador = compradores.stream()
                .filter(c -> c.getMatricula().equals("118\n"))
                .findFirst()
                .orElse(null);

        assertNotNull(comprador);
        assertFalse(comprador.getElectronicos().isEmpty());

        System.out.println("Comprador: " + comprador.getNombre());
        System.out.println("Electrónicos del comprador:");
        for (Electronico electronico : comprador.getElectronicos()) {
            System.out.println("Nombre: " + electronico.getNombre() +
                    ", Precio: " + electronico.getPrecio() +
                    ", Marca: " + electronico.getMarca());
        }
    }

    @Test //Despligue de un  nuevo comprador sin compras
    void testCompradorSinElectronicos() {
        System.out.println("La prueba 'testCompradorSinElectronicos' ha pasado correctamente!");

        Comprador comprador = new Comprador("126\n", "Juan", "Pérez", 30, "juan.perez@gmail.com", "password123");
        assertNotNull(comprador);
        assertTrue(comprador.getElectronicos().isEmpty());

        System.out.println("Comprador sin electrónicos: " + comprador.getNombre());
    }

    @Test //Despligue de todos los compradores y sus electronicos comprados
    void testCompradoresConElectronicos() {
        System.out.println("La prueba 'testCompradorConElectronicos' ha pasado correctamente!");

        for (Comprador comprador : compradores) {
            assertNotNull(comprador);
            assertFalse(comprador.getElectronicos().isEmpty(), "El comprador " + comprador.getNombre() + " no tiene electrónicos asociados.");

            System.out.println("Comprador: " + comprador.getNombre());
            System.out.println("Electrónicos del comprador:");
            for (Electronico electronico : comprador.getElectronicos()) {
                System.out.println("Nombre: " + electronico.getNombre() +
                        ", Precio: " + electronico.getPrecio() +
                        ", Marca: " + electronico.getMarca());
            }
            System.out.println("-----------------------------------------------------");
        }
    }



}
