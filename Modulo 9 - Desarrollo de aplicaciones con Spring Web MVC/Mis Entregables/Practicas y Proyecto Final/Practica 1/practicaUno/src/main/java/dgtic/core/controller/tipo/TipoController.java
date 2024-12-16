package dgtic.core.controller.tipo;

import dgtic.core.model.entities.TipoEntity;
import dgtic.core.service.tipo.TipoService;
import dgtic.core.util.RenderPagina;
import dgtic.core.validator.TipoValidator;
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
//endPoint localhost:8080/tipo/
@RequestMapping(value = "tipo")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @Autowired
    private TipoValidator tipoValidator;

    @GetMapping("alta-tipo")
    //endPoint localhost:8080/tipo/alta-tipo
    public String altaTipo(Model model) {
        TipoEntity tipo = new TipoEntity();
        model.addAttribute("contenido", "Alta de Tipo");
        tipo.setIdTipo(1111);
        // model.addAttribute("success", "nombre");
        model.addAttribute("tipo", tipo);
        return "tipo/alta-tipo";
    }

    @PostMapping("salvar-tipo")
    public String salvarTipo(@Valid @ModelAttribute("tipo") TipoEntity tipo, BindingResult result, Model model, RedirectAttributes flash) {
        System.out.println("Tipo: " + tipo);
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Error en el nombre, no debe ser vacío");
            return "tipo/alta-tipo";
        }
        tipoService.guardar(tipo);
        // model.addAttribute("contenido", "Alta de Tipo");
        flash.addFlashAttribute("success", "Se almacenó con éxito");
        // model.addAttribute("success", "Se almacenó con éxito");
        // model.addAttribute("tipo", tipo);
        // return "tipo/alta-tipo";
        return "redirect:/tipo/lista-tipo";
    }

    @GetMapping("lista-tipo")
    public String listaTipo(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model) {

        Pageable pageable = PageRequest.of(page, 2);
        Page<TipoEntity> tipoEntities = tipoService.buscarTodos(pageable);
        RenderPagina<TipoEntity> renderPagina = new RenderPagina<>("lista-tipo", tipoEntities);
        model.addAttribute("tipo", tipoEntities);
        model.addAttribute("page", renderPagina);
        model.addAttribute("contenido", "Consultar Tipos");
        return "tipo/lista-tipo";

    }

    @GetMapping("eliminar-tipo/{id}")
    public String eliminarTipo(@PathVariable Integer id, RedirectAttributes flash) {
        tipoService.borrar(id);
        flash.addFlashAttribute("success", "Tipo Eliminado");
        return "redirect:/tipo/lista-tipo";
    }

    @GetMapping("modificar-tipo/{id}")
    public String modificarTipo(@PathVariable Integer id, Model model) {
        TipoEntity tipo = tipoService.buscarPorId(id);
        model.addAttribute("tipo", tipo);
        model.addAttribute("contenido", "Modificar Tipo");
        return "tipo/alta-tipo";
    }

    /*
    @InitBinder("tipo")
    public void nombreTipo(WebDataBinder binder) {
        // binder.addValidators(tipoValidator);
        binder.registerCustomEditor(String.class, "nombre", new MayusculasConverter());
    }
    */

}
