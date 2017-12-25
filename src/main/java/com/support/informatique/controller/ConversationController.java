package com.support.informatique.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Conversation;
import com.support.informatique.service.ConversationService;
@Controller
public class ConversationController {
	@Autowired
	private ConversationService conversationService;
	
	
	
	@RequestMapping("/conversations")
	public String conversations(ModelMap model) {
		
		model.addAttribute("conversations",conversationService.findAll() );
		return "tests/conversations";
	}
	 
    @RequestMapping(value = { "/newConversation" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model) {
        Conversation produit = new Conversation();
        model.addAttribute("conversation", produit);
        model.addAttribute("edit", false);
        return "tests/conversation";
    }
 
    
    @RequestMapping(value = { "/newConversation" }, method = RequestMethod.POST)
    public String saveProduit(@Valid Conversation conversation, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "conversation";
        }
        conversationService.save(conversation);
        
        return "redirect:/tests/conversations";   
    }
    
    /*
     * This method will provide the medium to update an existing Produit.
     */
    @RequestMapping(value = { "/edit-{idConversation}-Conversation" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idConversation, ModelMap model) {
        Conversation conversation = conversationService.findOne(idConversation);
        model.addAttribute("conversation", conversation);
        model.addAttribute("edit", true);
        return "tests/conversation";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating Produit in database. It also validates the conversation input
     */
    @RequestMapping(value = { "/edit-{idConversation}-Conversation" }, method = RequestMethod.POST)
    public String updateTicket(@Valid Conversation conversation, BindingResult result,
            ModelMap model, @PathVariable int idConversation) {
 
        if (result.hasErrors()) {
            return "tests/conversation";
        }
 
       
 
        conversationService.save(conversation);
 
        
        return "redirect:/tests/conversations";
    }
    @RequestMapping(value = {"delete-{idConversation}-Conversation"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Conversation conversation,@PathVariable int idConversation) {
    	conversationService.deletebyId(idConversation);
    	return "redirect:/tests/conversations";
    }
}
