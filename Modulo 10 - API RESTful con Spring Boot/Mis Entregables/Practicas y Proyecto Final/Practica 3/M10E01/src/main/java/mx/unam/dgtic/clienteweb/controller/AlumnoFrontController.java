package mx.unam.dgtic.clienteweb.controller;

import mx.unam.dgtic.clienteweb.services.AlumnoFrontService;
import mx.unam.dgtic.clienteweb.services.AlumnoWebClientService;
import mx.unam.dgtic.dto.AlumnoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AlumnoFrontController {

    @Autowired
    private AlumnoFrontService service;

    @Autowired
    private AlumnoWebClientService alumnoWebClientService;

    @GetMapping(path = "/front/alumnos/{matricula}")
    public String getAlumno(
            @PathVariable String matricula,
            Model model
    ){
        AlumnoDTO alumnoDTO = service.getAlumnoByMatricula(matricula);
        model.addAttribute("alumno", alumnoDTO);
        return "alumnodetalle";
    }

    @GetMapping(path = "/front/alumnos/")
    public String getAllAlumnos(Model model){
        model.addAttribute("alumnos", alumnoWebClientService.getAll());
        return "alumnos";
    }

    @GetMapping(path = "/front/alumnos/{matricula}/editar")
    public String getFormEditar(@PathVariable String matricula, Model model){
        AlumnoDTO alumnoDTO = alumnoWebClientService.getAlumnoByMatricula(matricula);
        model.addAttribute("alumno", alumnoDTO);
        return "formEditar";
    }

    @PutMapping(path = "/front/alumnos/editar")
    public String actualizarAlumno(@RequestBody AlumnoDTO alumnoDTO, Model model){
        AlumnoDTO alumnoActualizado = alumnoWebClientService.actualizaAlumno(alumnoDTO);
        model.addAttribute("alumno", alumnoActualizado);
        return "formEditar";
    }

}
