package com.support.informatique.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Imprimante;
import com.support.informatique.entities.Marque;
import com.support.informatique.service.MarqueService;
@Controller
public class MarqueController {
	@Autowired
	private MarqueService marqueService;
	
	 
    @RequestMapping(value = { "/newMarque" }, method = RequestMethod.GET)
    public String marque(ModelMap model,HttpServletRequest request) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Marque marque = new Marque();
        model.addAttribute("marque", marque);
        model.addAttribute("edit", false);
        if (request.isUserInRole("ADMIN"))
		  {	
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());	
			  return "/admin/marque"; 
			  
		  }
		  else if (request.isUserInRole("TECH"))
		  {
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());
			  return "/tech/marque"; 
			  	
		  }
		return "/403";
    }
 
    @RequestMapping(value = { "/newMarque" }, method = RequestMethod.POST)
    public String saveTicket(@Valid Marque marque, BindingResult result, ModelMap model,HttpServletRequest request) {
	    if (request.isUserInRole("ADMIN"))
		  {
		        if (result.hasErrors()) {
		            return "admin/marque";
		        }     
		        marqueService.save(marque);
		        return "redirect:admin/marques";   
		  }
		  else if (request.isUserInRole("TECH"))
		  {		  
		        if (result.hasErrors()) {
		            return "tech/marque";
		        }
		        marqueService.save(marque);
		        return "redirect:tech/marques";   
		  }
		return "/403";	
}

    @RequestMapping(value = { "/edit-{idMarque}-Marque" }, method = RequestMethod.GET)
    public String editMarque(@PathVariable int idMarque, ModelMap model,HttpServletRequest request) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Marque marque = marqueService.findOne(idMarque);
        model.addAttribute("marque", marque);
        model.addAttribute("edit", true);
        if (request.isUserInRole("ADMIN"))
		  {	
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());	
			  return "/admin/marque"; 
			  
		  }
		  else if (request.isUserInRole("TECH"))
		  {
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());
			  return "/tech/marque"; 
			  	
		  }
		return "/403";
    }
     
    @RequestMapping(value = { "/edit-{idMarque}-Marque" }, method = RequestMethod.POST)
    public String updateMarque(@Valid Marque marque, BindingResult result,
            ModelMap model, @PathVariable int idMarque,HttpServletRequest request) {
    	marqueService.save(marque);
    	if (request.isUserInRole("ADMIN"))
	  {	
        return "redirect:admin/marques";
	  }
	  else if (request.isUserInRole("TECH"))
	  {		  
		  return "redirect:tech/marques";
	  }
	    return "/403";
    }
    @RequestMapping(value = {"delete-{idMarque}-Marque"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Marque marque,@PathVariable int idMarque,HttpServletRequest request) {
    	marqueService.deletebyId(idMarque);
	    if (request.isUserInRole("USER")) {
	        return "redirect:user/tickets";
	  } 
	    else if (request.isUserInRole("ADMIN"))
	  {	
        return "redirect:admin/tickets";
	  }
	  else if (request.isUserInRole("TECH"))
	  {		  
		  return "redirect:tech/tickets";
	  }
	    return "/403";
    }
    }

