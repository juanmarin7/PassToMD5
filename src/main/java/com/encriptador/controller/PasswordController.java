package com.encriptador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.encriptador.model.PasswordForm;
import com.encriptador.util.PasswordEncryp;

@Controller
public class PasswordController {

	@GetMapping("/encriptador")
	public String showEncryptForm(Model model) {
	    model.addAttribute("passwordForm", new PasswordForm());
	    return "encriptador";
	}

	@PostMapping("/encriptador")
	public String encryptPassword(@ModelAttribute PasswordForm passwordForm, Model model) {
	    String password = passwordForm.getPassword();
	    if (password == null || password.isEmpty()) {
	        model.addAttribute("errorMessage", "Debe digitar un valor");
	        return "encriptador";
	    }
	    String encryptedPassword = PasswordEncryp.encryptMD5(password);
	    model.addAttribute("encryptedPassword", encryptedPassword);
	    return "encriptador";
	}


}
