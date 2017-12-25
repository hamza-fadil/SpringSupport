package com.support.informatique.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@RequestMapping("/telephones")
	public String telephones(ModelMap model) {
		
		model.addAttribute("telephones",telephoneService.findAll() );
		model.addAttribute("marques",marqueService.findAll() );
		
		
	
		return "tests/telephones";
	}

    @RequestMapping(value = { "/newTelephone" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model) {
        Telephone telephone = new Telephone();
        model.addAttribute("telephone", telephone);
        model.addAttribute("edit", false);
        model.addAttribute("marques",marqueService.findAll() );
        model.addAttribute("marque",marqueService.findName() );
        return "telephone";
    }
 
    
    @RequestMapping(value = { "/newTelephone" }, method = RequestMethod.POST)
    public String saveProduit(@Valid Telephone telephone, BindingResult result,
            ModelMap model) {
    	if (result.hasErrors()) {
            return "telephone";
        }
        telephoneService.save(telephone);
        
        return "redirect:/telephones";   
    }
    

    @RequestMapping(value = { "/edit-{idMateriel}-Telephone" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idMateriel, ModelMap model) {
        Telephone telephone = telephoneService.findOne(idMateriel);
        Marque selecteMarque = marqueService.findOne(idMateriel);
        model.addAttribute("telephone", telephone);
        model.addAttribute("edit", true);
        model.addAttribute("marque", selecteMarque);
        model.addAttribute("marques",marqueService.findAll() );
        
        return "tests/telephone";
    }
     
    @RequestMapping(value = { "/edit-{idMateriel}-Telephone" }, method = RequestMethod.POST)
    public String updateTicket(@Valid Telephone telephone, BindingResult result,
            ModelMap model, @PathVariable int idMateriel) {
 
        if (result.hasErrors()) {
            return "tests/telephone";
        }
 
       
 
        telephoneService.save(telephone);
 
        
        return "redirect:/tests/telephones";
    }
    @RequestMapping(value = {"delete-{idMateriel}-Telephone"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Telephone telephone,@PathVariable int idMateriel) {
    	telephoneService.delete(idMateriel);
    	return "redirect:/tests/telephones";
    }
}
