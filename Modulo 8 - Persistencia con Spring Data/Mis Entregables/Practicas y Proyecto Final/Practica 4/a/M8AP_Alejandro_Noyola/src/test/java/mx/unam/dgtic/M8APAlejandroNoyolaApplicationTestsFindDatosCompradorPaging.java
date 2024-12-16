package mx.unam.dgtic;


import mx.unam.dgtic.datos.paginado.Comprador;
import mx.unam.dgtic.datos.paginado.CompradorPagingAndSortingRepository;
import mx.unam.dgtic.datos.paginado.ConteoPorCampo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;


@SpringBootTest
public class M8APAlejandroNoyolaApplicationTestsFindDatosCompradorPaging {
    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    private static final int PAGE_SIZE = 10;

    @Autowired
    private CompradorPagingAndSortingRepository compradorPagingAndSortingRepository;

    public void mostrarInformacionDePagina(Page<Comprador> compradorPage) {
        System.out.println("<<< Informacion De Pagina >>>");
        // Número total de elementos en todas las páginas
        System.out.println("Número total de Compradores: " + compradorPage.getTotalElements());

        // Número total de páginas
        System.out.println("Número total de páginas: " + compradorPage.getTotalPages());

        // Número de la página actual (comienza en 0)
        System.out.println("Página actual: " + compradorPage.getNumber());

        // Número de elementos en la página actual
        System.out.println("Número de alumnos en la página actual: " + compradorPage.getNumberOfElements());

        // Tamaño de la página (cuántos elementos se muestran por página)
        System.out.println("Tamaño de la página (número máximo de alumnos por página): " + compradorPage.getSize());

        // ¿Es esta la primera página?
        System.out.println("¿Es la primera página? " + compradorPage.isFirst());

        // ¿Es esta la última página?
        System.out.println("¿Es la última página? " + compradorPage.isLast());

        // ¿Hay una página siguiente disponible?
        System.out.println("¿Hay una página siguiente? " + compradorPage.hasNext());

        // ¿Hay una página anterior disponible?
        System.out.println("¿Hay una página anterior? " + compradorPage.hasPrevious());

        // Obtener la lista de alumnos en la página actual
        System.out.println("Alumnos en la página actual:");
        compradorPage.getContent().forEach(System.out::println);
    }



    @Test
    void buscarTodosPaginaTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar todos los Compradores usando paginado");
        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("nombreComprador").ascending());
        Page<Comprador> compradorPage;

        for (int i = 0; i < 4; i++) {  // Asumiendo que hay al menos 4 páginas
            compradorPage = compradorPagingAndSortingRepository.findAll(pagina);
            System.out.println("Página " + (i + 1) + " de " + compradorPage.getTotalPages());
            compradorPage.forEach(System.out::println);
            pagina = compradorPage.nextPageable();
        }
    }



    @ParameterizedTest
    @ValueSource(strings = {"nombreComprador", "apellidoComprador", "edad", "correo"})
    void buscarTodosPaginaWhileTest(String campo) {
        System.out.println(ALUMNO);
        System.out.println("Buscar todos los Compradores usando paginado");
        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by(campo).ascending());
        Page<Comprador> compradorPage;

        do {
            compradorPage = compradorPagingAndSortingRepository.findAll(pagina);
            System.out.println("Página " + (pagina.getPageNumber() + 1) + " de " + compradorPage.getTotalPages());
            compradorPage.forEach(System.out::println);
            pagina = compradorPage.nextPageable();
        } while (compradorPage.hasNext());
    }

    @ParameterizedTest
    @ValueSource(strings = {"nombreComprador", "apellidoComprador", "edad", "correo"})
    void buscarCompradoresOrdenadosTest(String campo) {
        System.out.println(ALUMNO);
        System.out.println("Ordenado por " + campo);
        Sort sort = Sort.by(Sort.Direction.DESC, campo);
        compradorPagingAndSortingRepository.findAll(sort).forEach(System.out::println);
    }


    @Test
    void contarPorGeneroWhileTest() {
        System.out.println(ALUMNO);
        System.out.println("Contar por genero");
        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("campo").ascending());
        Page<ConteoPorCampo> compradorPage;

        do {
            compradorPage = compradorPagingAndSortingRepository.contarPorGenero(pagina);
            System.out.println("Página " + (pagina.getPageNumber() + 1) + " de " + compradorPage.getTotalPages()
                    + " con " + compradorPage.getNumberOfElements() + " elementos"
                    + " de " + compradorPage.getTotalElements() + " en total");
            compradorPage.forEach(cp -> System.out.println(cp.getCampo() + " " + cp.getConteo()));
            pagina = compradorPage.nextPageable();
        } while (compradorPage.hasNext());
    }

    @Test
    void contarCompradoresPorGeneroTest() {
        System.out.println(ALUMNO);
        System.out.println("Contar compradores agrupados por género");
        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("campo").ascending());
        Page<ConteoPorCampo> compradorPage;

        do {
            compradorPage = compradorPagingAndSortingRepository.contarPorGenero(pagina);
            System.out.println("Página " + (pagina.getPageNumber() + 1) + " de " + compradorPage.getTotalPages()
                    + " con " + compradorPage.getNumberOfElements() + " elementos"
                    + " de " + compradorPage.getTotalElements() + " en total");
            compradorPage.forEach(cp -> System.out.println(cp.getCampo() + " " + cp.getConteo()));
            pagina = compradorPage.nextPageable();
        } while (compradorPage.hasNext());
    }

    @Test
    void buscarCompradoresPorNombreLikeTest() {
        String patron = "Valerie"; // Cambia esto al patrón que quieras probar
        System.out.println(ALUMNO);
        System.out.println("Buscar compradores cuyo nombre contiene: " + patron);
        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("nombreComprador").ascending());
        Page<Comprador> compradorPage;

        do {
            compradorPage = compradorPagingAndSortingRepository.findByNombreCompradorLike(patron, pagina);
            System.out.println("Página " + (pagina.getPageNumber() + 1) + " de " + compradorPage.getTotalPages());
            compradorPage.forEach(System.out::println);
            pagina = compradorPage.nextPageable();
        } while (compradorPage.hasNext());
    }

}



