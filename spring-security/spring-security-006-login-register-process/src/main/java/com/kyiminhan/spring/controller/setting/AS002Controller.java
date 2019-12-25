package com.kyiminhan.spring.controller.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kyiminhan.spring.service.AS002Service;
import com.kyiminhan.spring.service.dto.AS002PwdChangeDto;
import com.kyiminhan.spring.validator.AS002Validator;

@Controller
public class AS002Controller {

	@Autowired
	private AS002Service as002Service;

	@Autowired
	private AS002Validator validator;

	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		binder.addValidators(this.validator);
	}

	@GetMapping(value = { "/init-password-change" })
	public String doInitPasswordChange(final Model model) {
		model.addAttribute("dto", AS002PwdChangeDto.builder().build());
		return "setting/AS002-initial-pwd-change";
	}

	@PostMapping(value = { "/init-password-change" })
	public String doInitPasswordChange(@ModelAttribute("dto") @Validated final AS002PwdChangeDto dto,
	        final BindingResult result, final RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "setting/AS002-initial-pwd-change";
		}
		this.as002Service.changeInitPassword(dto);
		attributes.getFlashAttributes().clear();
		attributes.addFlashAttribute("messages", "success.register");
		return "redirect:/home";
	}
}
