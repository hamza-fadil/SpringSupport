package com.support.informatique.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Marque;
import com.support.informatique.entities.Ordinateur;
import com.support.informatique.metier.MarqueService;
import com.support.informatique.metier.OrdinateurService;
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
		return "ordinateurs";
	}


    @RequestMapping(value = { "/newOrdinateur" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model) {
        Ordinateur ordinateur = new Ordinateur();
        model.addAttribute("ordinateur", ordinateur);
        model.addAttribute("edit", false);
        model.addAttribute("marques",marqueService.findAll() );
        model.addAttribute("marque",marqueService.findName() );
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
    @RequestMapping(value = {"delete-{idMateriel}-Ordinateur"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Ordinateur ordinateur,@PathVariable int idMateriel) {
    	ordinateurService.delete(idMateriel);
    	return "redirect:/ordinateurs";
    }
}
