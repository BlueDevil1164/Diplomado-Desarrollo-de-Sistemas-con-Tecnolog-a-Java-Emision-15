package edu.unam.springsecurity.auth.controller;

import edu.unam.springsecurity.system.service.AdminService;
import edu.unam.springsecurity.system.service.HomeService;
import edu.unam.springsecurity.system.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	private final HomeService homeService;
	private final UserService userService;
	private final AdminService adminService;

	// Controller Injection
	public HomeController(HomeService homeService, UserService userService, AdminService adminService) {
		this.homeService = homeService;
		this.userService = userService;
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
	@PreAuthorize("hasRole('USER')")
	public String user(Model model) {
		model.addAttribute("text", userService.getText());
		return "user";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
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