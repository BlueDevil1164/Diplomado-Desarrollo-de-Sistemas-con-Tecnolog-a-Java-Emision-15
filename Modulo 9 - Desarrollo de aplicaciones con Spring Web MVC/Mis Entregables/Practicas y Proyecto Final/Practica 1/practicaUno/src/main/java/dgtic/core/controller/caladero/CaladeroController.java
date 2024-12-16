package dgtic.core.controller.caladero;

import dgtic.core.model.entities.CaladeroEntity;
import dgtic.core.service.caladero.CaladeroService;
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
//endPoint localhost:8080/caladero/
@RequestMapping(value = "caladero")
public class CaladeroController {

    @Autowired
    private CaladeroService service;

    @GetMapping("alta-caladero")
    //endPoint localhost:8080/caladero/alta-caladero
    public String altaCaladero(Model model) {
        CaladeroEntity caladero = new CaladeroEntity();
        model.addAttribute("contenido", "Alta de Caladero");
        model.addAttribute("caladero", caladero);
        return "caladero/alta-caladero";
    }

    @PostMapping("salvar-caladero")
    public String salvarCaladero(@Valid @ModelAttribute("caladero") CaladeroEntity caladero, BindingResult result, Model model, RedirectAttributes flash) {
        System.out.println("Caladero: " + caladero);
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Error en el nombre, no debe ser vacío");
            return "caladero/alta-caladero";
        }
        service.guardar(caladero);
        // model.addAttribute("success", "Se almacenó con éxito");
        // model.addAttribute("caladero", caladero);
        flash.addFlashAttribute("success", "Se almacenó con éxito");
        // return "caladero/alta-caladero";
        return "redirect:/caladero/lista-caladero";
    }

    @GetMapping("lista-caladero")
    public String listaCaladero(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model) {

        Pageable pageable = PageRequest.of(page, 2);
        Page<CaladeroEntity> caladeroEntities = service.buscarTodos(pageable);
        RenderPagina<CaladeroEntity> renderPagina = new RenderPagina<>("lista-caladero", caladeroEntities);
        model.addAttribute("caladero", caladeroEntities);
        model.addAttribute("page", renderPagina);
        model.addAttribute("contenido", "Consultar Caladeros");
        return "caladero/lista-caladero";

    }

    @GetMapping("eliminar-caladero/{id}")
    public String eliminarCaladero(@PathVariable Integer id, RedirectAttributes flash) {
        service.borrar(id);
        flash.addFlashAttribute("success", "Caladero Eliminado");
        return "redirect:/caladero/lista-caladero";
    }

    @GetMapping("modificar-caladero/{id}")
    public String modificarCaladero(@PathVariable Integer id, Model model) {
        CaladeroEntity caladero = service.buscarPorId(id);
        model.addAttribute("caladero", caladero);
        model.addAttribute("contenido", "Modificar Caladero");
        return "caladero/alta-caladero";
    }

}
