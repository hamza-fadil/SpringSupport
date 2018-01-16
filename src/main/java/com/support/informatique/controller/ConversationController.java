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
    public String newConversation(ModelMap model,HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Conversation produit = new Conversation();
        model.addAttribute("conversation", produit);
        model.addAttribute("edit", false);
        if (request.isUserInRole("USER")) {
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());
			  return "/user/ticket";
			  	
		  } else if (request.isUserInRole("ADMIN"))
		  {	
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());	
			  return "/admin/ticket"; 
			  
		  }
		  else if (request.isUserInRole("TECH"))
		  {
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());
			  return "/tech/ticket"; 
			  	
		  }
		return "/403";
    }
    @RequestMapping(value = { "/newConversation" }, method = RequestMethod.POST)
    public String saveConversation(@Valid Conversation conversation, BindingResult result,ModelMap model,HttpServletRequest request) {
        if (result.hasErrors()) {
            return "conversation";
        }
        conversationService.save(conversation);
        
	    if (request.isUserInRole("USER")) {
	        if (result.hasErrors()) {
	            return "user/ticket";
	        }
	        return "redirect:user/ticket";   
		  } 
	    else if (request.isUserInRole("ADMIN"))
		  {	
		        if (result.hasErrors()) {
		            return "admin/ticket";
		        }
		        return "redirect:admin/ticket";   
		  }
		  else if (request.isUserInRole("TECH"))
		  {		  
		        if (result.hasErrors()) {
		            return "tech/ticket";
		        }
		        return "redirect:tech/ticket";   
		  }
		return "/403"; 
    }
    @RequestMapping(value = { "/edit-{idConversation}-Conversation" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idConversation, ModelMap model) {
        Conversation conversation = conversationService.findOne(idConversation);
        model.addAttribute("conversation", conversation);
        model.addAttribute("edit", true);
        return "tests/conversation";
    }
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
