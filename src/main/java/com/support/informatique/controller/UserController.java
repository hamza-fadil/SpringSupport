package com.support.informatique.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.commons.validator.routines.EmailValidator;

import com.support.informatique.entities.User;
import com.support.informatique.service.UserService;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
    @RequestMapping(value = { "/newUser" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());
		  }
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "admin/user";
    }
    @RequestMapping("/inscription")
    public String addUser(ModelMap model) {
    	User user = new User();
    	model.addAttribute(user);
        return "inscription";
    }
 
	@RequestMapping(value = { "/inscription" }, method = RequestMethod.POST)
    public String newUser(@Valid User user, ModelMap model) {
		EmailValidator validator = EmailValidator.getInstance();
		Boolean present = userService.findByEmail(user.getEmail()).equals(user.getEmail());
		Boolean validEmail = validator.isValid(user.getEmail());
		user.setEnabled("1");
        user.setTypeUser("ROLE_USER");
		System.out.println("test");
		System.out.println(user.toString());
        if (!validEmail) {
        	model.addAttribute("emailInv",true);
        	System.out.println("test1");
        	return "inscription";
        }
        if (present) {     	
        	model.addAttribute("emailDup",true);
        	System.out.println("test2");
        	return "inscription";
        }
        if (!present && validEmail) {
        	System.out.println("test3");
        	System.out.println(user.toString());
            userService.save(user);  
            return "redirect:/"; 
//        }
//		return "redirect:/index";
//        
//        }
//		Boolean test2 = validEmail;
//		model.addAttribute("tout",user.toString());
//        Boolean test = userService.findByEmail(user.getEmail()).equals(user.getEmail());
//    	model.addAttribute("present",test);
//    	model.addAttribute("valide",test2);
//    	model.addAttribute("emailTrou", userService.findByEmail(user.getEmail()));
//    	model.addAttribute("emailDonne",user.getEmail());
	}
		return "redirect:/index";
	}
    @RequestMapping(value = { "/newUser" }, method = RequestMethod.POST)
    public String saveProduit(@Valid User user, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
        	model.addAttribute("emaildupliqué", true);
            return "tests/user";
        }
        userService.save(user);
        
        return "redirect:/admin/users";   
    }
    

    @RequestMapping(value = {"delete-{idUser}-User"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid User user,@PathVariable int idUser) {
    	userService.deletebyId(idUser);
    	return "redirect:/admin/users";
    }
}
