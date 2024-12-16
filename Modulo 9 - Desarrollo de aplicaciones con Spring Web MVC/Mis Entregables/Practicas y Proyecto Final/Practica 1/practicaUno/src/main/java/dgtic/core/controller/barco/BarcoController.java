package dgtic.core.controller.barco;

import dgtic.core.model.entities.BarcoEntity;
import dgtic.core.service.barco.BarcoService;
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
//endPoint localhost:8080/barco/
@RequestMapping(value = "barco")
public class BarcoController {

    @Autowired
    private BarcoService service;

    @GetMapping("alta-barco")
    //endPoint localhost:8080/barco/alta-barco
    public String altaBarco(Model model) {
        BarcoEntity barco = new BarcoEntity();
        model.addAttribute("contenido", "Alta de Barco");
        model.addAttribute("barco", barco);
        return "barco/alta-barco";
    }

    @PostMapping("salvar-barco")
    public String salvarBarco(@Valid @ModelAttribute("barco") BarcoEntity barco, BindingResult result, Model model, RedirectAttributes flash) {
        System.out.println("Barco: " + barco);
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Error en el nombre, no debe ser vacío");
            return "barco/alta-barco";
        }
        service.guardar(barco);
        // model.addAttribute("success", "Se almacenó con éxito");
        // model.addAttribute("barco", barco);
        flash.addFlashAttribute("success", "Se almacenó con éxito");
        // return "barco/alta-barco";
        return "redirect:/barco/lista-barco";
    }

    @GetMapping("lista-barco")
    public String listaBarco(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model) {

        Pageable pageable = PageRequest.of(page, 2);
        Page<BarcoEntity> barcoEntities = service.buscarTodos(pageable);
        RenderPagina<BarcoEntity> renderPagina = new RenderPagina<>("lista-barco", barcoEntities);
        model.addAttribute("barco", barcoEntities);
        model.addAttribute("page", renderPagina);
        model.addAttribute("contenido", "Consultar Barcos");
        return "barco/lista-barco";

    }

    @GetMapping("eliminar-barco/{id}")
    public String eliminarBarco(@PathVariable Integer id, RedirectAttributes flash) {
        service.borrar(id);
        flash.addFlashAttribute("success", "Barco Eliminado");
        return "redirect:/barco/lista-barco";
    }

    @GetMapping("modificar-barco/{id}")
    public String modificarBarco(@PathVariable Integer id, Model model) {
        BarcoEntity barco = service.buscarPorId(id);
        model.addAttribute("barco", barco);
        model.addAttribute("contenido", "Modificar Barco");
        return "barco/alta-barco";
    }

}
