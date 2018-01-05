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

import com.support.informatique.entities.Marque;
import com.support.informatique.entities.Ordinateur;
import com.support.informatique.service.MarqueService;
import com.support.informatique.service.OrdinateurService;
@Controller
public class OrdinateurController {
	@Autowired
	private OrdinateurService ordinateurService;
	@Autowired
	private MarqueService marqueService;
	
	
	@RequestMapping("/ordinateurs")
	public String ordinateurs(ModelMap model) {
		
		model.addAttribute("ordinateurs",ordinateurService.findAll() );
		model.addAttribute("marques",marqueService.findAll() );
		return "tests/ordinateurs";
	}


    @RequestMapping(value = { "/newOrdinateur" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model,HttpServletRequest request) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Ordinateur ordinateur = new Ordinateur();
        model.addAttribute("ordinateur", ordinateur);
        model.addAttribute("edit", false);
        model.addAttribute("marques",marqueService.findAll() );
        model.addAttribute("marque",marqueService.findName() );
	         if (request.isUserInRole("ADMIN"))
			  {	
				  UserDetails userDetail = (UserDetails) auth.getPrincipal();
					model.addAttribute("username", userDetail.getUsername());	
				  return "/admin/ordinateur"; 
				  
			  }
			  else if (request.isUserInRole("TECH"))
			  {
				  UserDetails userDetail = (UserDetails) auth.getPrincipal();
					model.addAttribute("username", userDetail.getUsername());
				  return "/tech/ordinateur"; 
				  	
			  }
			return "/403";
	    }
    
    @RequestMapping(value = { "/newOrdinateur" }, method = RequestMethod.POST)
    public String saveTicket(@Valid Ordinateur ordinateur, BindingResult result, ModelMap model,HttpServletRequest request) {
	    if (request.isUserInRole("ADMIN"))
		  {	
		        if (result.hasErrors()) {
		            return "admin/ordinateur";
		        }     
		        ordinateurService.save(ordinateur);
		        
		        return "redirect:admin/parcs";   
			  
		  }
		  else if (request.isUserInRole("TECH"))
		  {		  
		        if (result.hasErrors()) {
		            return "tech/ordinateur";
		        }
				ordinateurService.save(ordinateur);
		        return "redirect:tech/parcs";   
		  	
		  }
		return "/403";	
}

    @RequestMapping(value = { "/edit-{idMateriel}-Ordinateur" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idMateriel, ModelMap model) {
        Ordinateur ordinateur = ordinateurService.findOne(idMateriel);
        Marque selecteMarque = marqueService.findOne(idMateriel);
        model.addAttribute("ordinateur", ordinateur);
        model.addAttribute("edit", true);
        model.addAttribute("marque", selecteMarque);
        model.addAttribute("marques",marqueService.findAll() );
        
        return "ordinateur";
    }
     
    @RequestMapping(value = { "/edit-{idMateriel}-Ordinateur" }, method = RequestMethod.POST)
    public String updateTicket(@Valid Ordinateur ordinateur, BindingResult result,
            ModelMap model, @PathVariable int idMateriel) {
 
        if (result.hasErrors()) {
            return "ordinateur";
        }
        ordinateurService.save(ordinateur);
        return "redirect:/ordinateurs";
    }
   
}
