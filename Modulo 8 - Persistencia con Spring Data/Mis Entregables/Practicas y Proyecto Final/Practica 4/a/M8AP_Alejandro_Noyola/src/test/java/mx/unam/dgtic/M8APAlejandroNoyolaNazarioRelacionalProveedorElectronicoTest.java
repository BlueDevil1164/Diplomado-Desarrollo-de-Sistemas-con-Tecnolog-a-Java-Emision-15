package mx.unam.dgtic;
import mx.unam.dgtic.datos.electronicos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class M8APAlejandroNoyolaNazarioRelacionalProveedorElectronicoTest {
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
    void buscarProvedoresPorElectronico() {
        System.out.println(ALUMNO);
        System.out.println("Buscar proveedores por Electronico");

        electronicosRepository.findAll().forEach(a -> {
            System.out.print(a.getIdElectronico() + " " + a.getNombreElectronico() + " " + a.getExistencias() + " ");

            // Null check for Categoria
            if (a.getCategoria() != null) {
                System.out.println(a.getCategoria().getAbreviatura());
            } else {
                System.out.println("No Categoria asociada.");
            }

            if (a.getProveedores() != null && !a.getProveedores().isEmpty()) {
                a.getProveedores().forEach(g -> {
                    System.out.println("  Id Proveedor " + g.getId() + " Proveedor " + g.getProveedor());
                });
            } else {
                System.out.println("  No hay proveedores asociados a este electronico.");
            }
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



}

