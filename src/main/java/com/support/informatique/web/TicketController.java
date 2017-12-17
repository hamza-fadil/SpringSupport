package com.support.informatique.web;

	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import com.support.informatique.entities.Ticket;
import com.support.informatique.metier.TicketService;

	@Controller
	public class TicketController {

		@Autowired
		private TicketService ticketService;
		
		
		
		@RequestMapping("/tickets")
		public String tickets(ModelMap model) {
			
			model.addAttribute("tickets",ticketService.findAll() );
			return "tickets";
		}
		 
	    @RequestMapping(value = { "/newTicket" }, method = RequestMethod.GET)
	    public String newTicket(ModelMap model) {
	        Ticket produit = new Ticket();
	        model.addAttribute("ticket", produit);
	        model.addAttribute("edit", false);
	        return "ticket";
	    }
	 
	    
	    @RequestMapping(value = { "/newTicket" }, method = RequestMethod.POST)
	    public String saveTicket(@Valid Ticket ticket, BindingResult result,
	            ModelMap model) {
	 
	        if (result.hasErrors()) {
	            return "ticket";
	        }
	        ticketService.save(ticket);
	        
	        return "redirect:/tickets";   
	    }
	    
	    /*
	     * This method will provide the medium to update an existing Produit.
	     */
	    @RequestMapping(value = { "/edit-{idTicket}-Ticket" }, method = RequestMethod.GET)
	    public String editTicket(@PathVariable int idTicket, ModelMap model) {
	        Ticket ticket = ticketService.findOne(idTicket);
	        model.addAttribute("ticket", ticket);
	        model.addAttribute("edit", true);
	        return "ticket";
	    }
	     
	    /*
	     * This method will be called on form submission, handling POST request for
	     * updating Produit in database. It also validates the user input
	     */
	    @RequestMapping(value = { "/edit-{idTicket}-Ticket" }, method = RequestMethod.POST)
	    public String updateTicket(@Valid Ticket ticket, BindingResult result,
	            ModelMap model, @PathVariable int idTicket) {
	 
	        if (result.hasErrors()) {
	            return "ticket";
	        }
	 
	       
	 
	        ticketService.save(ticket);
	 
	        
	        return "redirect:/tickets";
	    }
	    @RequestMapping(value = {"delete-{idTicket}-Ticket"}, method = RequestMethod.GET)
	    public String deleteTicket(@Valid Ticket ticket,@PathVariable int idTicket) {
	    	ticketService.deletebyId(idTicket);
	    	return "redirect:/tickets";
	    }
		
	}
