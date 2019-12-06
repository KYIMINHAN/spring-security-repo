package com.kyiminhan.spring.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Lazy
@Controller
public class LoginController {

	@GetMapping(value = "/login")
	public String login(Model model) {
		return "login";
	}
}
