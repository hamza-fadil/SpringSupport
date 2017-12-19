package com.support.informatique.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.User;
import com.support.informatique.metier.UserService;
@Controller
public class WelcomeController {
	@Autowired

	
	
	
	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	 

}
