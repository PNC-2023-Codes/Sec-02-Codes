package com.douglashdezt.sec02.helloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
	
	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@GetMapping("/greet")
	public String greetSomeone(@RequestParam(name = "name", defaultValue = "No name") String name, Model model) {
		model.addAttribute("someone", name);
		return "hello_someone";
	}
}
