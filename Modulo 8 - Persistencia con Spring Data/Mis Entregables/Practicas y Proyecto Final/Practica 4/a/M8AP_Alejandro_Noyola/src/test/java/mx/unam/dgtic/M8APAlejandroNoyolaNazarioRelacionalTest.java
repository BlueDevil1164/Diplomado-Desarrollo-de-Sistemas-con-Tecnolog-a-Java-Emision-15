package mx.unam.dgtic;
import mx.unam.dgtic.datos.electronicos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class M8APAlejandroNoyolaNazarioRelacionalTest{
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
    void buscarProvedoresPorElectronico(){
        System.out.println(ALUMNO);
        System.out.println("Buscar proveedores por Electronico");

        electronicosRepository.findAll().forEach(a->{
            System.out.println(a.getIdElectronico()+ " " + a.getNombreElectronico() +  " " + a.getExistencias() + " "
                    + a.getCategoria().getAbreviatura());
            a.getProveedores().forEach(g->{
                System.out.println("Id Proveedor "+ g.getId() + " Proveedor " + g.getProveedor());
            });
        });

    }

    @Test
    @Transactional
    void buscarElectronicosPorProveedorTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar Electronico por Proveedor");
        proveedorRepository.findAll().forEach(g->{
            System.out.println(g.getId()+" "+g.getProveedor());
            g.getElectronicos().forEach(a->{
                System.out.println(a.getIdElectronico()+ " " + a.getNombreElectronico() +  " " + a.getExistencias() + " "
                        + a.getCategoria().getAbreviatura());
            });
        });
    }

    @Transactional
    @Test
    void buscarProvedorPorId(){
        System.out.println(ALUMNO);
        System.out.println("Buscar provehdores por Id");
        electronicosRepository.findProveedoresByIdElectronico(MATRICULA).forEach(System.out::println);
    }


    @Test
    void buscarElectronicoMarcasTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar todos los electronicos con sus Marcas");

        electronicosRepository.buscarTodosConMarcas().forEach(a->{
            System.out.println("--- Alumno ---");
            System.out.println(a.getNombreElectronico()+" "+a.getExistencias()+
                    " "+a.getCategoria().getCategoria());
            a.getMarcas().forEach(c->{
                System.out.println(c.getStarRate() +" "+c.getMarca());
            });
        });
    }


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

    @Test
    void buscarMarcasElectronicoTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar todas las Marcas y sus Electronicos");

        marcaRepository.findAll().forEach(c -> {
            System.out.println("StarRate " + c.getStarRate() + ", " + "Marca " + c.getMarca());

            if (c.getElectronico() != null) {
                System.out.println("Electronico " + c.getElectronico().getNombreElectronico() + ", "
                        + c.getElectronico().getExistencias() + " "
                        + (c.getElectronico().getCategoria() != null ? c.getElectronico().getCategoria().getAbreviatura() : "No Categoria"));
            } else {
                System.out.println("No hay electronico asociado a esta marca.");
            }
        });
    }


}

