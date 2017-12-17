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
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping("/users")
	public String users(ModelMap model) {
		
		model.addAttribute("users",userService.findAll() );
		return "users";
	}
	 
    @RequestMapping(value = { "/newUser" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "user";
    }
 
    
    @RequestMapping(value = { "/newUser" }, method = RequestMethod.POST)
    public String saveProduit(@Valid User user, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "user";
        }
        userService.save(user);
        
        return "redirect:/users";   
    }
    
    /*
     * This method will provide the medium to update an existing User.
     */
    @RequestMapping(value = { "/edit-{idUser}-User" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idUser, ModelMap model) {
        User user = userService.findOne(idUser);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "user";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating User in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{idUser}-User" }, method = RequestMethod.POST)
    public String updateTicket(@Valid User user, BindingResult result,
            ModelMap model, @PathVariable int idUser) {
 
        if (result.hasErrors()) {
            return "user";
        }
 
       
 
        userService.save(user);
 
        
        return "redirect:/users";
    }
    @RequestMapping(value = {"delete-{idUser}-User"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid User user,@PathVariable int idUser) {
    	userService.deletebyId(idUser);
    	return "redirect:/users";
    }
}
