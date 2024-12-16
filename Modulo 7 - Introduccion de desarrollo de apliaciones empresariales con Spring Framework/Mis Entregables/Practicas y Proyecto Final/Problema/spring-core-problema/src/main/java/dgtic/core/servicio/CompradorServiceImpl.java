package dgtic.core.servicio;

import dgtic.core.modelo.Comprador;
import dgtic.core.repositorio.CompradorRepositorio;
import dgtic.core.repositorio.ElectronicoRepositorio;

import java.util.List;
import java.util.stream.Collectors;

public class CompradorServiceImpl implements CompradorService {
    private CompradorRepositorio compradorRepositorio;
    private ElectronicoRepositorio electronicoRepositorio;

    public CompradorServiceImpl(CompradorRepositorio compradorRepositorio, ElectronicoRepositorio electronicoRepositorio) {
        this.compradorRepositorio = compradorRepositorio;
        this.electronicoRepositorio = electronicoRepositorio;
    }

    @Override
    public List<Comprador> findAll() {
        return compradorRepositorio.findAll();
    }

    @Override
    public Comprador findById(String matricula) {
        return compradorRepositorio.findById(matricula);
    }


    @Override
    public String registro(String matricula) {
        return compradorRepositorio.findAll().stream()
                .filter(comp->(comp.getMatricula().equals(matricula)))
                .map(comp->(comp.getMatricula()+";"+ (comp.getElectronicos().stream()
                        .map(mat->(mat.getId()+";"+mat.getNombre()+";"
                                +mat.getPrecio()))
                        .collect(Collectors.joining(";")))
                        +";"+comp.getNombre()+";"+comp.getEdad()))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public int matricula (String matricula) {
        return compradorRepositorio.findAll().stream()
                .filter(comp->(comp.getMatricula().equals(matricula)))
                .findFirst()
                .map(comp->(comp.getElectronicos().stream()
                        .map(xx->xx.getPrecio()).reduce(0,Integer::sum)))
                .get();
    }

}
