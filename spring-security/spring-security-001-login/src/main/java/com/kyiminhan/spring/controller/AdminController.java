package com.kyiminhan.spring.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Lazy
@Controller
@RequestMapping("/adimn")
public class AdminController {

	@GetMapping(value = { "/home" })
	public String init(Model model) {
		return "home";
	}

}
