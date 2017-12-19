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
import com.support.informatique.entities.Imprimante;
import com.support.informatique.metier.ImprimanteService;
import com.support.informatique.metier.MarqueService;
@Controller
public class ImprimanteController {
	@Autowired
	private ImprimanteService imprimanteService;
	@Autowired
	private MarqueService marqueService;
	
	
	@RequestMapping("/imprimantes")
	public String imprimantes(ModelMap model) {
		
		model.addAttribute("imprimantes",imprimanteService.findAll() );
		model.addAttribute("marques",marqueService.findAll() );
		
		
	
		return "imprimantes";
	}

 
    @RequestMapping(value = { "/newImprimante" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model) {
        Imprimante imprimante = new Imprimante();
        model.addAttribute("imprimante", imprimante);
        model.addAttribute("edit", false);
        model.addAttribute("marques",marqueService.findAll() );
        model.addAttribute("marque",marqueService.findName() );
        return "imprimante";
    }
 
    
    @RequestMapping(value = { "/newImprimante" }, method = RequestMethod.POST)
    public String saveProduit(@Valid Imprimante imprimante, BindingResult result,
            ModelMap model) {
    	if (result.hasErrors()) {
            return "imprimante";
        }
        imprimanteService.save(imprimante);
        
        return "redirect:/imprimantes";   
    }
    

    @RequestMapping(value = { "/edit-{idMateriel}-Imprimante" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idMateriel, ModelMap model) {
        Imprimante imprimante = imprimanteService.findOne(idMateriel);
        Marque selecteMarque = marqueService.findOne(idMateriel);
        model.addAttribute("imprimante", imprimante);
        model.addAttribute("edit", true);
        model.addAttribute("marque", selecteMarque);
        model.addAttribute("marques",marqueService.findAll() );
        
        return "imprimante";
    }
     
    @RequestMapping(value = { "/edit-{idMateriel}-Imprimante" }, method = RequestMethod.POST)
    public String updateTicket(@Valid Imprimante imprimante, BindingResult result,
            ModelMap model, @PathVariable int idMateriel) {
 
        if (result.hasErrors()) {
            return "imprimante";
        }
 
       
 
        imprimanteService.save(imprimante);

        
        return "redirect:/imprimantes";
    }
    @RequestMapping(value = {"delete-{idMateriel}-Imprimante"}, method = RequestMethod.GET)
    public String deleteImprimante(@Valid Imprimante imprimante,@PathVariable int idMateriel) {
    	imprimanteService.delete(idMateriel);
    	return "redirect:/imprimantes";
    }
}
