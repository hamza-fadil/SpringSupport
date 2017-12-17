package com.support.informatique.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Ordinateur;
import com.support.informatique.metier.OrdinateurService;
@Controller
public class OrdinateurController {
	@Autowired
	private OrdinateurService ordinateurService;
	
	
	
	@RequestMapping("/ordinateurs")
	public String ordinateurs(ModelMap model) {
		
		model.addAttribute("ordinateurs",ordinateurService.findAll() );
		return "ordinateurs";
	}
	 
    @RequestMapping(value = { "/newOrdinateur" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model) {
        Ordinateur ordinateur = new Ordinateur();
        model.addAttribute("ordinateur", ordinateur);
        model.addAttribute("edit", false);
        return "ordinateur";
    }
 
    
    @RequestMapping(value = { "/newOrdinateur" }, method = RequestMethod.POST)
    public String saveProduit(@Valid Ordinateur ordinateur, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "ordinateur";
        }
        ordinateurService.save(ordinateur);
        
        return "redirect:/ordinateurs";   
    }
    
    /*
     * This method will provide the medium to update an existing Ordinateur.
     */
    @RequestMapping(value = { "/edit-{idMateriel}-Ordinateur" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idMateriel, ModelMap model) {
        Ordinateur ordinateur = ordinateurService.findOne(idMateriel);
        model.addAttribute("ordinateur", ordinateur);
        model.addAttribute("edit", true);
        return "ordinateur";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating Ordinateur in database. It also validates the ordinateur input
     */
    @RequestMapping(value = { "/edit-{idMateriel}-Ordinateur" }, method = RequestMethod.POST)
    public String updateTicket(@Valid Ordinateur ordinateur, BindingResult result,
            ModelMap model, @PathVariable int idMateriel) {
 
        if (result.hasErrors()) {
            return "ordinateur";
        }
 
       
 
        ordinateurService.save(ordinateur);
 
        
        return "redirect:/ordinateurs";
    }
    @RequestMapping(value = {"delete-{idMateriel}-Ordinateur"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Ordinateur ordinateur,@PathVariable int idMateriel) {
    	ordinateurService.delete(idMateriel);
    	return "redirect:/ordinateurs";
    }
}
