package mx.unam.dgtic;


import mx.unam.dgtic.datos.ConteoPorCampo;
import mx.unam.dgtic.datos.Materia;
import mx.unam.dgtic.datos.MateriaPagingAndSortingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class M804_02PagingAndSortingTests {



    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    private static final int PAGE_SIZE = 10;

    @Autowired
    MateriaPagingAndSortingRepository repositorioMateria;

    public void mostrarInformacionDePagina(Page<Materia> materiaPage) {
        System.out.println("<<< Informacion De Pagina >>>");
        // Número total de elementos en todas las páginas
        System.out.println("Número total de alumnos: " + materiaPage.getTotalElements());

        // Número total de páginas
        System.out.println("Número total de páginas: " + materiaPage.getTotalPages());

        // Número de la página actual (comienza en 0)
        System.out.println("Página actual: " + materiaPage.getNumber());

        // Número de elementos en la página actual
        System.out.println("Número de alumnos en la página actual: " + materiaPage.getNumberOfElements());

        // Tamaño de la página (cuántos elementos se muestran por página)
        System.out.println("Tamaño de la página (número máximo de alumnos por página): " + materiaPage.getSize());

        // ¿Es esta la primera página?
        System.out.println("¿Es la primera página? " + materiaPage.isFirst());

        // ¿Es esta la última página?
        System.out.println("¿Es la última página? " + materiaPage.isLast());

        // ¿Hay una página siguiente disponible?
        System.out.println("¿Hay una página siguiente? " + materiaPage.hasNext());

        // ¿Hay una página anterior disponible?
        System.out.println("¿Hay una página anterior? " + materiaPage.hasPrevious());

        // Obtener la lista de alumnos en la página actual
        System.out.println("Alumnos en la página actual:");
        materiaPage.getContent().forEach(System.out::println);
    }

    @Test
    void buscarTodosPaginaTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar todos los Alumnos usando paginado");
        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("materia").ascending());
        Page<Materia> alumnoPage = repositorioMateria.findAll(pagina);
        System.out.println("Página 1 de " + alumnoPage.getTotalPages());
        alumnoPage.forEach(System.out::println);
        pagina = PageRequest.of(1, PAGE_SIZE, Sort.by("materia").ascending());
        alumnoPage = repositorioMateria.findAll(pagina);
        System.out.println("Página 2 de " + alumnoPage.getTotalPages());
        alumnoPage.forEach(System.out::println);
        pagina = PageRequest.of(2, PAGE_SIZE, Sort.by("materia").ascending());
        alumnoPage = repositorioMateria.findAll(pagina);
        System.out.println("Página 3 de " + alumnoPage.getTotalPages());
        alumnoPage.forEach(System.out::println);
        pagina = PageRequest.of(3, PAGE_SIZE, Sort.by("materia").ascending());
        alumnoPage = repositorioMateria.findAll(pagina);
        System.out.println("Página 4 de " + alumnoPage.getTotalPages());
        alumnoPage.forEach(System.out::println);
        mostrarInformacionDePagina(alumnoPage);
    }
/*
    @ParameterizedTest
    @ValueSource(strings = {"nombre", "paterno", "estatura", "fnac"})
    void alumnoPagindoWhileTest(String campo) {
        System.out.println(ALUMNO);
        System.out.println("Buscar todos los Alumnos usando paginado");
        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by(campo).ascending());
        Page<Materia> alumnoPage;
        do {
            alumnoPage = repositorioMateria.findAll(pagina);
            System.out.println("Página  " + (pagina.getPageNumber() + 1) + " de " + alumnoPage.getTotalPages());
            alumnoPage.forEach(System.out::println);
            pagina = alumnoPage.nextPageable();
            // pagina = alumnoPage.previousPageable();
            // pagina = alumnoPage.previousOrFirstPageable();
            // pagina = alumnoPage.nextOrLastPageable();
        } while (alumnoPage.hasNext());
    }


 */
    @ParameterizedTest
    @ValueSource(strings = {"materia", "creditos", "horas"})
    void buscarMateriasOrdenadasTest(String campo) {
        System.out.println(ALUMNO);
        System.out.println("Ordenado por " + campo);
        Sort sort = Sort.by(Sort.Direction.DESC, campo);
        repositorioMateria.findAll(sort).forEach(System.out::println);
    }
/*
    @Test
    void buscarCurpLikeWhileTest() {
        String patron = "%QT%";
        System.out.println(ALUMNO);
        System.out.println("Buscar por Curp Like " + patron);
        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("nombre").ascending());
        Page<Materia> alumnoPage;
        do {
            alumnoPage = repositorioMateria.findByCurpLike(patron, pagina);
            System.out.println("Página " + (pagina.getPageNumber() + 1) + " de " + alumnoPage.getTotalPages()
                    + " con " + alumnoPage.getNumberOfElements() + " elementos"
                    + " de " + alumnoPage.getTotalElements() + " en total"
            );
            alumnoPage.forEach(System.out::println);
            pagina = alumnoPage.nextPageable();
        } while (alumnoPage.hasNext());
    }

    @Test
    void contarPorNombreWhileTest() {
        System.out.println(ALUMNO);
        System.out.println("Contar por nombre");
        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("campo").ascending());
        // Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("conteo").descending());
        Page<ConteoPorCampo> alumnoPage;
        do {
            alumnoPage = repositorioMateria.contarPorMateria(pagina);
            System.out.println("Página " + (pagina.getPageNumber() + 1) + " de " + alumnoPage.getTotalPages()
                    + " con " + alumnoPage.getNumberOfElements() + " elementos"
                    + " de " + alumnoPage.getTotalElements() + " en total"
            );
            alumnoPage.forEach(cp -> System.out.println(cp.getCampo() + " " + cp.getConteo()));
            pagina = alumnoPage.nextPageable();
        } while (alumnoPage.hasNext());
    }

    @Test
    void contarPorSexoWhileTest() {
        System.out.println(ALUMNO);
        System.out.println("Contar por sexo");
        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("campo").ascending());
        Page<ConteoPorCampo> alumnoPage;
        do {
            alumnoPage = repositorioMateria.contarPorSexo(pagina);
            System.out.println("Página " + (pagina.getPageNumber() + 1) + " de " + alumnoPage.getTotalPages()
                    + " con " + alumnoPage.getNumberOfElements() + " elementos"
                    + " de " + alumnoPage.getTotalElements() + " en total"
            );
            alumnoPage.forEach(cp -> System.out.println(cp.getCampo() + " " + cp.getConteo()));
            pagina = alumnoPage.nextPageable();
        } while (alumnoPage.hasNext());
    }



 */

}