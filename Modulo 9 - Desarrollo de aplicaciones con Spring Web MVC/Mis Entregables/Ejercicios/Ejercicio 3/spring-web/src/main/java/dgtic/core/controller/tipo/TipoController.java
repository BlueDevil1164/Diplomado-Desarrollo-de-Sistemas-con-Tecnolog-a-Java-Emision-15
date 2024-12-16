package dgtic.core.controller.tipo;

import dgtic.core.model.entities.TipoEntity;
import dgtic.core.service.tipo.TipoService;
import dgtic.core.util.RenderPagina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "tipo")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @GetMapping("alta-tipo")
    //endPoint localhost:8080/tipo/alta-tipo
    public String altaTipo(Model model) {
        TipoEntity tipo = new TipoEntity();
        model.addAttribute("contenido", "Alta de Tipo");
        tipo.setIdTipo(1117);
        model.addAttribute("tipo", tipo);
        return "tipo/alta-tipo";
    }

    @PostMapping("salvar-tipo")
    public String salvarTipo(TipoEntity tipo, Model model, RedirectAttributes flash) {
        System.out.println("Formulario: " + tipo.getIdTipo() + " " + tipo.getNombre());
        tipoService.guardar(tipo);
        model.addAttribute("contenido", "Alta de Tipo");
        // flash.addFlashAttribute("success", "Se almacenó con éxito");
        model.addAttribute("success", "Se almacenó con éxito");
        model.addAttribute("tipo", tipo);
        return "tipo/alta-tipo";
        //return "redirect:/inicio";
    }

    @GetMapping("lista-tipo")
    public String listaTipo(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model){
        Pageable pageable= PageRequest.of(page,2);
        Page<TipoEntity> tipoEntities=tipoService.buscarTipo(pageable);
        RenderPagina<TipoEntity> renderPagina=new RenderPagina<>("lista-tipo",tipoEntities);
        model.addAttribute("tipo",tipoEntities);
        model.addAttribute("page",renderPagina);
        model.addAttribute("contenido","Lista de tipos de Peces");
        return "tipo/lista-tipo";
    }

}
