package edu.wccnet.jwon1.springMVC.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.wccnet.jwon1.springMVC.domain.Order;
import edu.wccnet.jwon1.springMVC.domain.PizzaService;


@Controller
public class MainController {
	@Autowired
	private PizzaService pizzaService;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("order", new Order());
		
		return "info-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("order") Order order,
			BindingResult result) {
		if(result.hasErrors()) {
			return "info-form";
		}else {
			return "confirmation";
		}
	}
	
	@ModelAttribute
	public void populateFormWithData(Model model) {
		model.addAttribute("sizeList", pizzaService.populateSize());
		model.addAttribute("toppingList", pizzaService.populateTopping());
		model.addAttribute("stateList", pizzaService.populateState());
	}
	
}
