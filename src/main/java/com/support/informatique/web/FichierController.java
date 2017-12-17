package com.support.informatique.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Fichier;
import com.support.informatique.metier.FichierService;

@Controller
public class FichierController {
	@Autowired
	private FichierService fichierService;
	
	
	
	@RequestMapping("/fichiers")
	public String fichiers(ModelMap model) {
		
		model.addAttribute("fichiers",fichierService.findAll() );
		return "fichiers";
	}
	 
    @RequestMapping(value = { "/newFichier" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model) {
        Fichier produit = new Fichier();
        model.addAttribute("fichier", produit);
        model.addAttribute("edit", false);
        return "fichier";
    }
 
    
    @RequestMapping(value = { "/newFichier" }, method = RequestMethod.POST)
    public String saveProduit(@Valid Fichier fichier, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "fichier";
        }
        fichierService.save(fichier);
        
        return "redirect:/fichiers";   
    }
    
    /*
     * This method will provide the medium to update an existing Produit.
     */
    @RequestMapping(value = { "/edit-{idFichier}-Fichier" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idFichier, ModelMap model) {
        Fichier fichier = fichierService.findOne(idFichier);
        model.addAttribute("fichier", fichier);
        model.addAttribute("edit", true);
        return "fichier";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating Produit in database. It also validates the fichier input
     */
    @RequestMapping(value = { "/edit-{idFichier}-Fichier" }, method = RequestMethod.POST)
    public String updateTicket(@Valid Fichier fichier, BindingResult result,
            ModelMap model, @PathVariable int idFichier) {
 
        if (result.hasErrors()) {
            return "fichier";
        }
 
       
 
        fichierService.save(fichier);
 
        
        return "redirect:/fichiers";
    }
    @RequestMapping(value = {"delete-{idFichier}-Fichier"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Fichier fichier,@PathVariable int idFichier) {
    	fichierService.deletebyId(idFichier);
    	return "redirect:/fichiers";
    }
}
