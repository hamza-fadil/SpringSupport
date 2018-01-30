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
import com.support.informatique.entities.Telephone;
import com.support.informatique.service.MarqueService;
import com.support.informatique.service.TelephoneService;
@Controller
public class TelephoneController {
	@Autowired
	private TelephoneService telephoneService;
	@Autowired
	private MarqueService marqueService;
	

    @RequestMapping(value = { "/newTelephone" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model,HttpServletRequest request) {
        Telephone telephone = new Telephone();
        model.addAttribute("telephone", telephone);
        model.addAttribute("edit", false);
        model.addAttribute("marques",marqueService.findAll() );
        model.addAttribute("marque",marqueService.findName() );
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (request.isUserInRole("ADMIN"))
		  {	
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());	
			  return "admin/telephone"; 
			  
		  }
		  else if (request.isUserInRole("TECH"))
		  {
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());
			  return "tech/telephone"; 
			  	
		  }
		return "/403";
    }
 
    
    @RequestMapping(value = { "/newTelephone" }, method = RequestMethod.POST)
    public String saveProduit(@Valid Telephone telephone, BindingResult result,
            ModelMap model,HttpServletRequest request) {
    	if (result.hasErrors()) {
            return "telephone";
        }
        telephoneService.save(telephone);
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (request.isUserInRole("ADMIN"))
		  {	
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());	
			  return "redirect:/admin/parcs"; 
			  
		  }
		  else if (request.isUserInRole("TECH"))
		  {
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());
			  return "redirect:/tech/parcs"; 
			  	
		  }
		return "/403";  
    }
    

    @RequestMapping(value = { "/edit-{idMateriel}-Telephone" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idMateriel, ModelMap model,HttpServletRequest request) {
        Telephone telephone = telephoneService.findOne(idMateriel);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Marque selecteMarque = marqueService.findOne(idMateriel);
        model.addAttribute("telephone", telephone);
        model.addAttribute("edit", true);
        model.addAttribute("marque", selecteMarque);
        model.addAttribute("marques",marqueService.findAll() );
        
    	if (request.isUserInRole("ADMIN"))
		  {	
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());	
			  return "admin/telephone"; 
			  
		  }
		  else if (request.isUserInRole("TECH"))
		  {
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());
			  return "tech/telephone"; 
			  	
		  }
		return "/403";
    }
     
    @RequestMapping(value = { "/edit-{idMateriel}-Telephone" }, method = RequestMethod.POST)
    public String updateTicket(@Valid Telephone telephone, BindingResult result,
            ModelMap model, @PathVariable int idMateriel,HttpServletRequest request) {
        telephoneService.save(telephone);
    	if (result.hasErrors()) {
            return "telephone";
        }
        telephoneService.save(telephone);
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (request.isUserInRole("ADMIN"))
		  {	
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());	
			  return "redirect:/admin/parcs"; 
			  
		  }
		  else if (request.isUserInRole("TECH"))
		  {
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());
			  return "redirect:/tech/parcs"; 
			  	
		  }
		return "/403";  
    }
    @RequestMapping(value = {"delete-{idMateriel}-Telephone"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Telephone telephone,ModelMap model,@PathVariable int idMateriel,HttpServletRequest request) {
    	telephoneService.delete(idMateriel);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (request.isUserInRole("ADMIN"))
		  {	
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());	
			  return "redirect:/admin/parcs"; 
			  
		  }
		  else if (request.isUserInRole("TECH"))
		  {
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());
			  return "redirect:/tech/parcs"; 
			  	
		  }
		return "/403";  
    }
}
