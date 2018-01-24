package com.support.informatique.controller;

import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.commons.validator.routines.EmailValidator;
import com.support.informatique.entities.User;
import com.support.informatique.service.UserService;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
    @RequestMapping(value = { "/newUser" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());
		  }
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "admin/user";
    }
    @RequestMapping("/inscription")
    public String addUser(ModelMap model) {
    	User user = new User();
    	model.addAttribute(user);
        return "inscription";
    }
	@RequestMapping(value = { "/inscription" }, method = RequestMethod.POST)
    public String newUser(@Valid User user, ModelMap model,HttpServletRequest request) {
		EmailValidator validator = EmailValidator.getInstance();
		String EmailTrouv = userService.getEmail(user.getEmail());
		String UserTrouv = userService.findName(user.getUsername());
		boolean confirmPassword = user.getConfirmPassword().equals(user.getPassword());
		Boolean validEmail = validator.isValid(user.getEmail());
		user.setEnabled("1");
        user.setTypeUser("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword()));
	    if(!validEmail) {
	    	model.addAttribute("emailInv",true);
	    	return "inscription";
	    }
	    else if (EmailTrouv != null) {
	    	model.addAttribute("emailDup",true);
	    	return "inscription";
	    }
	    else if (UserTrouv != null) {
	    	model.addAttribute("userTrouv",true);
	    	return "inscription";
	    }
	    else if (!confirmPassword) {
	    	model.addAttribute("confirmPassword",true);
	    	return "inscription";
	    }
	    else {
			//userService.saveUser(user);
			
			user.setEnabled("0");
		    
		    // Generate random 36-character string token for confirmation link
		    user.setConfirmationToken(UUID.randomUUID().toString());
		        
		   // userService.saveUser(user);
		    
				
			String appUrl = request.getScheme() + "://" + request.getServerName()+":8080";
			
			final String username = "amatosami3@gmail.com";
			final String password = "poly2016";
			
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			
			
			Session session = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					  });

					try {

						Message message = new MimeMessage(session);
						message.setFrom(new InternetAddress("amatosami3@gmail.com"));
						message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(user.getEmail()));
						message.setSubject("confirmation d'adresse mail");
					 
						message.setText("To confirm your e-mail address, please click the link below:\n"
								+ appUrl + "/confirm?token=" + user.getConfirmationToken());

						Transport.send(message);

						System.out.println("Done");

					} catch (MessagingException e) {
						throw new RuntimeException(e);
					}
				
			 
			userService.save(user);
			model.addAttribute("successMessage", "A confirmation e-mail has been sent to \" + user.getEmail())");
			model.addAttribute("user", new User());
			return "login";
			}
	    }
	
	// Process confirmation link
			@RequestMapping(value="/confirmPassword", method = RequestMethod.GET)
			public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {
					
				User user = userService.findByConfirmationToken(token);
					
				if (user == null) { // No token found in DB
					modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
				} else { // Token found
					modelAndView.addObject("confirmationToken", user.getConfirmationToken());
				}
					
				modelAndView.setViewName("confirmpassword");
				return modelAndView;		
			}

		    
		 // Process confirmation link
		 		@RequestMapping(value="/confirmPassword", method = RequestMethod.POST)
		 		public String processConfirmationForm(ModelMap model,ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map requestParams, RedirectAttributes redir,@RequestParam("password") String password,@RequestParam("confirm_password") String confirm_password,RedirectAttributes attributes) {
		 						 			 
		 		
		 			// Find the user associated with the reset token
		 		//String s=requestParams.get("key");
		 			
		 			User user = userService.findByConfirmationToken((String)requestParams.get("token"));
		 			
		 			System.out.println((String)requestParams.get("token"));
		 			System.out.println(requestParams.get("token"));

		 			// Set new password
		 			//user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

		 			// Set user to enabled
		 			user.setEnabled(1);
		 			
		 			// Save user
		 			userService.saveUserSecond(user);
		 			
		 			if(password.isEmpty()) {
						model.addAttribute("errorMessage", "Please enter a valid password");
						return "confirmpassword";
		 			}
					
					if(password.equals(confirm_password)) {
						user.setPassword(passwordEncoder.encode(password));
						userService.save(user);
						System.out.println("Password has been changed successfully");
//						model.addAttribute("success", "Password has been changed successfully");
						attributes.addFlashAttribute("success","Password has been changed successfully");
			 			modelAndView.addObject("successMessage", "confirmation reussite ");
						return "redirect:/login";
						}
					else {
						model.addAttribute("errorMessage", "The entered password don't match");
						return "confirmpassword";
					}
		 			
		 			
//		 			modelAndView.addObject("successMessage", "confirmation reussite ");
//		 			return "redirect:/conReussite";		
		 		}
		 		
	
	
	@RequestMapping("/conReussite")
	public String prodits(ModelMap model) {
		 
		model.addAttribute("message", "confirmation reussite " );
		return "conReussite";
	}
	
    @RequestMapping(value = { "/newUser" }, method = RequestMethod.POST)
    public String saveProduit(@Valid User user, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
        	model.addAttribute("emaildupliqué", true);
            return "admin/user";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        
        return "redirect:/admin/users";   
    }
    

    @RequestMapping(value = {"delete-{idUser}-User"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid User user,@PathVariable int idUser) {
    	userService.deletebyId(idUser);
    	return "redirect:/admin/users";
    }
    @RequestMapping(value = { "/edit-{idUser}-User" }, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
            ModelMap model, @PathVariable int idUser) {
    	User oldUser = userService.findById(idUser);
    	user.setCreateTime(oldUser.getCreateTime());
    	if (user.getPassword().equals(oldUser.getPassword())) {
    		user.setPassword(oldUser.getPassword());
		}
    	else {
    		System.out.println("changer");
    		user.setPassword(passwordEncoder.encode(user.getPassword()));
    	}
        if (result.hasErrors()) {
            return "/admin/user";
        }
        userService.save(user);        
        return "redirect:admin/users";
 }
    @RequestMapping(value = { "/edit-{idUser}-User" }, method = RequestMethod.GET)
    public String editUsers(@PathVariable int idUser, ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			
        User user = userService.findOne(idUser);
        model.addAttribute("pass", userDetail.getPassword() );
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "/admin/user";
    }

		@RequestMapping(value="/forgotPassword", method = RequestMethod.GET)
	public String changePassword( ModelMap model) {                 
		
		return "forgotPassword";
	    }
	

	@RequestMapping(value="/forgotPassword", method = RequestMethod.POST)
	public String changePassword(ModelMap model,@RequestParam("email") String email,HttpServletRequest request,RedirectAttributes attributes) {                 
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(email);

		user.setConfirmationToken(UUID.randomUUID().toString());
		String appUrl = request.getScheme() + "://" + request.getServerName()+":8084";
		
		final String username = "amatosami3@gmail.com";
		final String password = "poly2016";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });

				try {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("amatosami3@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(user.getEmail()));
					message.setSubject("Change your password");
				 
					message.setText("To change your passaword, please click the link below:\n"
							+ appUrl + "/confirmPassword?token=" + user.getConfirmationToken());

					Transport.send(message);

					System.out.println("Done");
					attributes.addFlashAttribute("success","Link to change your password sent to your email address");
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			
		 
		userService.save(user);
		model.addAttribute("successMessage", "A confirmation e-mail has been sent to \" + user.getEmail())");
		model.addAttribute("user", new User());
		return "login";

}
	
}


