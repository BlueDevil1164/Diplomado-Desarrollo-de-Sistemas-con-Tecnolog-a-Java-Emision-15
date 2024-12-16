package dgtic.core.controller.lote;

import dgtic.core.model.entities.LoteEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "lote")
public class LoteController {

    @GetMapping("alta-lote")
    //endPoint localhost:8080/lote/alta-lote
    public String altaLote(Model model) {
        LoteEntity lote = new LoteEntity();
        model.addAttribute("contenido", "Alta de Lote");
        model.addAttribute("lote", lote);
        return "lote/alta-lote";
    }

    @PostMapping("salvar-lote")
    public String salvarLote(LoteEntity lote, Model model, RedirectAttributes flash) {
        System.out.println("Formulario: " + lote.getId_lote() + " " + lote.getNombre());
        model.addAttribute("contenido", "Alta de Lote");
        // flash.addFlashAttribute("success", "Se almacenó con éxito");
        model.addAttribute("success", "Se almacenó con éxito");
        model.addAttribute("lote", lote);
        return "lote/alta-lote";
        //return "redirect:/inicio";
    }

}
