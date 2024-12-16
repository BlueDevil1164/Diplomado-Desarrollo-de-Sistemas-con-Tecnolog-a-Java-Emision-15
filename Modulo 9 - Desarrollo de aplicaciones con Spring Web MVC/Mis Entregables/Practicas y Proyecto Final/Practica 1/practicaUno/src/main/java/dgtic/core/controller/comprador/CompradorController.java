package dgtic.core.controller.comprador;

import dgtic.core.model.entities.CompradorEntity;
import dgtic.core.service.comprador.CompradorService;
import dgtic.core.util.RenderPagina;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//endPoint localhost:8080/comprador/
@RequestMapping(value = "comprador")
public class CompradorController {

    @Autowired
    private CompradorService service;

    @GetMapping("alta-comprador")
    //endPoint localhost:8080/comprador/alta-comprador
    public String altaComprador(Model model) {
        CompradorEntity comprador = new CompradorEntity();
        model.addAttribute("contenido", "Alta de Comprador");
        model.addAttribute("comprador", comprador);
        return "comprador/alta-comprador";
    }

    @PostMapping("salvar-comprador")
    public String salvarComprador(@Valid @ModelAttribute("comprador") CompradorEntity comprador, BindingResult result, Model model, RedirectAttributes flash) {
        System.out.println("Comprador: " + comprador);
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Error en el nombre, no debe ser vacío");
            return "comprador/alta-comprador";
        }
        service.guardar(comprador);
        // model.addAttribute("success", "Se almacenó con éxito");
        // model.addAttribute("comprador", comprador);
        flash.addFlashAttribute("success", "Se almacenó con éxito");
        // return "comprador/alta-comprador";
        return "redirect:/comprador/lista-comprador";
    }

    @GetMapping("lista-comprador")
    public String listaComprador(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model) {

        Pageable pageable = PageRequest.of(page, 2);
        Page<CompradorEntity> compradorEntities = service.buscarTodos(pageable);
        RenderPagina<CompradorEntity> renderPagina = new RenderPagina<>("lista-comprador", compradorEntities);
        model.addAttribute("comprador", compradorEntities);
        model.addAttribute("page", renderPagina);
        model.addAttribute("contenido", "Consultar Compradores");
        return "comprador/lista-comprador";

    }

    @GetMapping("eliminar-comprador/{id}")
    public String eliminarComprador(@PathVariable Integer id, RedirectAttributes flash) {
        service.borrar(id);
        flash.addFlashAttribute("success", "Comprador Eliminado");
        return "redirect:/comprador/lista-comprador";
    }

    @GetMapping("modificar-comprador/{id}")
    public String modificarComprador(@PathVariable Integer id, Model model) {
        CompradorEntity comprador = service.buscarPorId(id);
        model.addAttribute("comprador", comprador);
        model.addAttribute("contenido", "Modificar Comprador");
        return "comprador/alta-comprador";
    }

}
