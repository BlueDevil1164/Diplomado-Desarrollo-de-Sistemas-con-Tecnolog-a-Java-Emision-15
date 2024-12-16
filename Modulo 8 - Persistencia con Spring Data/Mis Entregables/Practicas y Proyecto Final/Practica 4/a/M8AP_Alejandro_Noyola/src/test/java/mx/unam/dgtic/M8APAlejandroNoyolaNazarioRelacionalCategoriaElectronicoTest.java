package mx.unam.dgtic;
import mx.unam.dgtic.datos.electronicos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class M8APAlejandroNoyolaNazarioRelacionalCategoriaElectronicoTest {
    final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
    final String MATRICULA = "E001";
    final String CATEGORIA = "Smartphones";

    @Autowired
    private ElectronicosRepository electronicosRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Transactional
    @Test
    void buscarPorCategoriaTest(){
        System.out.println(ALUMNO);
        System.out.println("Ctegoria: ");
        Categoria categoria = categoriaRepository.findByCategoria(CATEGORIA);
        System.out.println(categoria);
        System.out.println("Electronicos en el categoria "+categoria.getCategoria());
        categoria.getElectronicos().forEach(a -> System.out.println(
                a.getNombreElectronico() + " " + a.getExistencias() + " "
                        + a.getCategoria().getAbreviatura()));

        System.out.println("Buscar Elctronicos por el objeto Categoria");
        electronicosRepository.findByCategoria(categoria).forEach(System.out::println);

        System.out.println("Buscar Elctronicos por la cadena ESTADO " + CATEGORIA);
        electronicosRepository.findByCategoriaCategoria(CATEGORIA).forEach(System.out::println);

        System.out.println("Buscar Elctronicos por abreviatura de LAPTOPS");
        electronicosRepository.findByCategoriaAbreviatura("LTP").forEach(System.out::println);

    }

    @Test
    void findCategoriaTest(){
        System.out.println(ALUMNO);
        System.out.println("Categoria que no tienen ningun Electronico");
        categoriaRepository.findCategoriasSinElectronicos().forEach(System.out::println);

        System.out.println("Categoria con al menos 2 Electronicos");
        categoriaRepository.findCategoriasConMinimoElectronicos(2).forEach(System.out::println);

        System.out.println("Numero de alumnos por Categoria:");
        List<Object[]> resultado = categoriaRepository.findCategoriaElectronicosCount();
        for(Object[] r:resultado){
            Categoria categoria =  (Categoria) r[0];
            Long conteoAlu = (Long) r[1];
            System.out.println("Categoria "+ categoria.getCategoria() +  ", Numero Categoria " + conteoAlu);
        }
    }

    @Transactional
    @Test
    void buscarElectronicosPorCategoriaTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar Electrónicos por Categoría");

        String categoriaNombre = "Tablets";
        Categoria categoria = categoriaRepository.findByCategoria(categoriaNombre);

        if (categoria != null) {
            System.out.println("Categoría: " + categoria.getCategoria());
            System.out.println("Electrónicos en la categoría: ");
            categoria.getElectronicos().forEach(electronico -> {
                System.out.println("  Nombre: " + electronico.getNombreElectronico() + ", "
                        + "Existencias: " + electronico.getExistencias() + ", "
                        + "Abreviatura de la categoría: " + categoria.getAbreviatura());
            });
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    @Transactional
    @Test
    void buscarElectronicoPorCategoriaTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar Electrónicos por Categoría: " + CATEGORIA);

        Categoria categoria = categoriaRepository.findByCategoria(CATEGORIA);

        if (categoria != null) {
            System.out.println("Categoría: " + categoria.getCategoria());
            System.out.println("Electrónicos en la categoría: ");
            categoria.getElectronicos().forEach(electronico -> {
                System.out.println("  Nombre: " + electronico.getNombreElectronico() + ", "
                        + "Existencias: " + electronico.getExistencias() + ", "
                        + "Abreviatura de la categoría: " + categoria.getAbreviatura());
            });
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }


    @Transactional
    @Test
    void buscarCategoriasConElectronicosTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar Categorías con Electrónicos");

        List<Categoria> categoriasConElectronicos = categoriaRepository.findCategoriasConMinimoElectronicos(1);

        if (!categoriasConElectronicos.isEmpty()) {
            categoriasConElectronicos.forEach(categoria -> {
                System.out.println("Categoría: " + categoria.getCategoria() + ", Abreviatura: " + categoria.getAbreviatura());
                categoria.getElectronicos().forEach(electronico -> {
                    System.out.println("  Electrónico: " + electronico.getNombreElectronico());
                });
            });
        } else {
            System.out.println("No hay categorías con electrónicos.");
        }
    }

    @Transactional
    @Test
    void contarElectronicosPorCategoriaTest() {
        System.out.println(ALUMNO);
        System.out.println("Contar Electrónicos por Categoría: " + CATEGORIA);

        Categoria categoria = categoriaRepository.findByCategoria(CATEGORIA);

        if (categoria != null) {
            long count = electronicosRepository.countByCategoria(categoria);
            System.out.println("Categoría: " + categoria.getCategoria() + ", "
                    + "Número de Electrónicos: " + count);
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    @Transactional
    @Test
    void buscarElectronicosPorCategoriaAbreviaturaTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar Electrónicos por Abreviatura de Categoría");

        String abreviatura = "TBL";

        List<Electronico> electronicos = electronicosRepository.findByCategoriaAbreviatura(abreviatura);

        if (!electronicos.isEmpty()) {
            System.out.println("Electrónicos en la categoría abreviada '" + abreviatura + "':");
            electronicos.forEach(electronico -> {
                System.out.println("  Nombre: " + electronico.getNombreElectronico() + ", "
                        + "Existencias: " + electronico.getExistencias());
            });
        } else {
            System.out.println("No se encontraron electrónicos en la categoría abreviada '" + abreviatura + "'.");
        }
    }


    @Transactional
    @Test
    void buscarCategoriasPorNombreElectronicoTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar Categorías por Nombre de Electrónico");

        String nombreElectronico = "iPad Pro";
        List<Categoria> categorias = categoriaRepository.findCategoriaByElectronicoNombreLike(nombreElectronico);

        if (!categorias.isEmpty()) {
            System.out.println("Categorías asociadas con el electrónico que contiene '" + nombreElectronico + "':");
            categorias.forEach(categoria -> {
                System.out.println("  Categoría: " + categoria.getCategoria() + ", "
                        + "Abreviatura: " + categoria.getAbreviatura());
            });
        } else {
            System.out.println("No se encontraron categorías asociadas con el electrónico que contiene '" + nombreElectronico + "'.");
        }
    }




}

