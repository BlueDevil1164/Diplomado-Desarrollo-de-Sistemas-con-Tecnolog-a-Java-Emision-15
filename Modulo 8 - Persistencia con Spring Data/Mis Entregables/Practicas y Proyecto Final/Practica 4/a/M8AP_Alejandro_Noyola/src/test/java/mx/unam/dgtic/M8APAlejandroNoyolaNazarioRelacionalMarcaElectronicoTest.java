package mx.unam.dgtic;
import mx.unam.dgtic.datos.electronicos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class M8APAlejandroNoyolaNazarioRelacionalMarcaElectronicoTest {
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

