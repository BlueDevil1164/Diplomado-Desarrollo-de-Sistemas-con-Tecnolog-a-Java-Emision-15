package mx.unam.dgtic.core.Ejercicio_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class HelloWorldController {
    @GetMapping("/welcome")
    public String welcome(){
        return "Hello World Spring Security!";
    }
}
