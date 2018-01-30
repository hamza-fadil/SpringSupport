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
    

    @RequestMapping(value = {"enable-{idUser}-User"}, method = RequestMethod.GET)
    public String deleteTicket(@PathVariable int idUser) {
    	User oldUser = userService.findOne(idUser);
    	System.out.println(oldUser.getEnabled());
    	String a = oldUser.getEnabled();
    	if (oldUser.getEnabled().equals("1")) {
			oldUser.setEnabled("0");
			userService.save(oldUser);
			return "redirect:/admin/users";
		}
    	else {
			oldUser.setEnabled("1");
			userService.save(oldUser);
			return "redirect:/admin/users";

    	}
    	
    	
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
		User EmailTrouv = userService.findByEmail(email);
	    if (EmailTrouv == null) {
	    	model.addAttribute("nonTrouv","Cet email n'as pas été trouvé dans la base de donnée, revérifiez s'il vous plait");
	    	return "forgotPassword";
	    }
	    else {
		User user = userService.findByEmail(email);
		user.setConfirmationToken(UUID.randomUUID().toString());
		String appUrl = request.getScheme() + "://" + request.getServerName()+":8080";
		final String usernameM = "s.informatique2018@gmail.com";
		final String password = "demoniak";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(usernameM, password);
					}
				  });
				try {
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("s.informatique@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(user.getEmail()));
					message.setSubject("Demande de modification de mot de passe");
				 
					message.setText("Pour modifier votre mot de passe, veuillez suivre le lien ci dessous:\n"
							+ appUrl + "/confirmPassword?token=" + user.getConfirmationToken());
					Transport.send(message);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
		userService.save(user);
		model.addAttribute("successMessage", "Un email de confirmation a été envoyé à ");
		model.addAttribute("user", user);
		return "login";
	    	}
	}
	@RequestMapping(value = { "/inscription" }, method = RequestMethod.POST)
    public String newUser(@Valid User user, ModelMap model,HttpServletRequest request) {
		EmailValidator validator = EmailValidator.getInstance();
		String EmailTrouv = userService.getEmail(user.getEmail());
		String UserTrouv = userService.findName(user.getUsername());
		System.out.println("test");
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
			user.setEnabled("0");
		    user.setConfirmationToken(UUID.randomUUID().toString());
			String appUrl = request.getScheme() + "://" + request.getServerName()+":8080";
			final String username = "s.informatique2018@gmail.com";
			final String password = "demoniak";
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
						message.setFrom(new InternetAddress("s.informatique2018@gmail.com"));
						message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(user.getEmail()));
						message.setSubject("Confirmation d'adresse mail");
						message.setText("Pour confirmer votre email, veuillez suivre le lien ci dessous:\n"
								+ appUrl + "/confirm?token=" + user.getConfirmationToken());
						Transport.send(message);
					} catch (MessagingException e) {
						throw new RuntimeException(e);
					}
			userService.save(user);
			model.addAttribute("successMessage", "Un email de confirmation a été envoyé à ");
			model.addAttribute("user", user);
			return "login";
			}
	    }
	@RequestMapping(value="/confirm", method = RequestMethod.GET)
	public String preconfirmMail(ModelMap model, @RequestParam("token") String token) {
		User user = userService.findByConfirmationToken(token);
		System.out.println(user);
		if (user==null) { // No token found in DB
			model.addAttribute("confirmed", "Le jeton que vous venez d'utiliser n'existe pas ou n'existe plus.");
		} else { // Token found
			user.setConfirmationToken("confirmed");
 			user.setEnabled("1");
 			userService.save(user);	
 			model.addAttribute("confirmed", "Votre email à bien été confirmé.");
		}
		return("login");
	}
	@RequestMapping(value="/confirmPassword", method = RequestMethod.GET)
	public String preconfirmPass(ModelMap model, @RequestParam("token") String token) {
		User user = userService.findByConfirmationToken(token);
		if (user == null) { // No token found in DB
			model.addAttribute("confirmed", "Le jeton que vous venez d'utiliser n'existe pas ou n'existe plus.");
			return("login");
		} else { // Token found
			return("changePassword");
		}
	}
		@RequestMapping(value="/confirmPassword", method = RequestMethod.POST)
		public String processConfirmationForm(ModelMap model, @RequestParam("token") String token,@RequestParam("password") String password,@RequestParam("confirmPassword") String confirmPassword) {
			User user = userService.findByConfirmationToken(token);
		if(password.equals(confirmPassword)) {
			user.setPassword(passwordEncoder.encode(password));
			user.setConfirmationToken("confirmed");
			userService.save(user);
			model.addAttribute("passChange","Votre mot de passe à bien été changer");
			return "login";
			}
		else {
			model.addAttribute("errorMessage", "Les mots de passe ne sont pas identique ");
			return "confirmPassword";
			}
		}

		//END
}


