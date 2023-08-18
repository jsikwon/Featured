package edu.wccnet.jwon1.mp3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.wccnet.jwon1.mp3.domain.Mortgage;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		Mortgage mortgage = new Mortgage();
		
		model.addAttribute("mortgage", mortgage);
		return "info-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@ModelAttribute("mortgage") Mortgage mortgage) {
			mortgage.calcMonthly();
			mortgage.populatePaymentList();
			return "confirmation";
	}
	

}
