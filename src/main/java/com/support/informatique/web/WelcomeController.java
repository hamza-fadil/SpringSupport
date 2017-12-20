package com.support.informatique.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class WelcomeController {
	@Autowired

	
	
	
	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	 

}
