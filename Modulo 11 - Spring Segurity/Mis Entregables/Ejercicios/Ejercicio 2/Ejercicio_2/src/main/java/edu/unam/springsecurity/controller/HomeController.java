package edu.unam.springsecurity.controller;

import edu.unam.springsecurity.service.AdminService;
import edu.unam.springsecurity.service.HomeService;
import edu.unam.springsecurity.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	private final HomeService homeService;
	private final UsuarioService userService;
	private final AdminService adminService;

	// Controller Injection
	public HomeController(HomeService homeService, UsuarioService usuarioService, AdminService adminService) {
		this.homeService = homeService;
		this.userService = usuarioService;
		this.adminService = adminService;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("text", homeService.getText());
		return "index";
	}

	@GetMapping("/index")
	public String index() {
		return "redirect:/";
	}
	
	@GetMapping("/user")
	public String user(Model model) {
		model.addAttribute("text", userService.getText());
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("text", adminService.getText());
		return "admin";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login_success_handler")
	public String loginSuccessHandler() {
		System.out.println("Logging user login success...");
		return "index";
	}

	@PostMapping("/login_failure_handler")
	public String loginFailureHandler() {
		System.out.println("Login failure handler....");
		return "login";
	}
}
