package com.support.informatique.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
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
		String EmailTrouv = userService.findByEmail(user.getEmail());
		String UserTrouv = userService.findName(user.getUsername());
		boolean confirmPassword = user.getConfirmPassword().equals(user.getPassword());
		Boolean validEmail = validator.isValid(user.getEmail());
		user.setEnabled("1");
        user.setTypeUser("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
	    if(!validEmail) {
	    	model.addAttribute("emailInv",true);
	    	return "inscription";
	    }
	    else if (EmailTrouv != null) {
	    	model.addAttribute("emailDup",true);
	    	return "inscription";
	    }
	    else if (UserTrouv != null) {
	    	model.addAttribute("userTrouv",true);
	    	return "inscription";
	    }
	    else if (!confirmPassword) {
	    	model.addAttribute("confirmPassword",true);
	    	return "inscription";
	    }
	    else {
	    	userService.save(user);  
            return "redirect:/"; 
	    }
	}
	
	
    @RequestMapping(value = { "/newUser" }, method = RequestMethod.POST)
    public String saveProduit(@Valid User user, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
        	model.addAttribute("emaildupliqué", true);
            return "admin/user";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        
        return "redirect:/admin/users";   
    }
    

    @RequestMapping(value = {"delete-{idUser}-User"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid User user,@PathVariable int idUser) {
    	userService.deletebyId(idUser);
    	return "redirect:/admin/users";
    }
    @RequestMapping(value = { "/edit-{idUser}-User" }, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
            ModelMap model, @PathVariable int idUser) {
    	User oldUser = userService.findById(idUser);
    	user.setCreateTime(oldUser.getCreateTime());
    	if (user.getPassword().equals(oldUser.getPassword())) {
    		user.setPassword(oldUser.getPassword());
		}
    	else {
    		System.out.println("changer");
    		user.setPassword(passwordEncoder.encode(user.getPassword()));
    	}
        if (result.hasErrors()) {
            return "/admin/user";
        }
        userService.save(user);        
        return "redirect:admin/users";
 }
    @RequestMapping(value = { "/edit-{idUser}-User" }, method = RequestMethod.GET)
    public String editUsers(@PathVariable int idUser, ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			
        User user = userService.findOne(idUser);
        model.addAttribute("pass", userDetail.getPassword() );
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "/admin/user";
    }
    
}


