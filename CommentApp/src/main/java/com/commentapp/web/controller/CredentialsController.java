package com.commentapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.commentapp.entity.CredentialsEntity;
import com.commentapp.entity.UserEntity;
import com.commentapp.service.CommentService;
import com.commentapp.service.CredentialService;

@Controller
@SessionAttributes({"credLogin","comments"})
public class CredentialsController {
	@Autowired
	private CredentialService credService;

	
	@RequestMapping(value = "/")
	public ModelAndView setupLogin(CredentialsEntity credLogin) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("credLogin", new CredentialsEntity());
		return modelAndView;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute("credLogin") CredentialsEntity creds) {
		ModelAndView modelAndView = new ModelAndView();
		CredentialsEntity credential = credService.getCredentials(creds);
		if(credential!=null) {
			modelAndView.addObject("email", credential.getEmail());
			UserEntity u1 = new UserEntity();
			u1.setCred(credential);
			modelAndView.addObject("comments", u1);
			modelAndView.setViewName("comments");
		}
		else {
			modelAndView.addObject("error", "Incorrect credentials");
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}
	@RequestMapping(value = "/loadSignUp")
	public ModelAndView loadSignUp(CredentialsEntity credLogin) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("credLogin", new CredentialsEntity());
		modelAndView.setViewName("SignUp");
		return modelAndView;
	}
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public ModelAndView signUp(@ModelAttribute("credLogin") CredentialsEntity cred) {
		ModelAndView modelAndView = new ModelAndView();
		credService.addUser(cred);
		/*modelAndView.addObject("comments", new UserEntity());
		modelAndView.addObject("email", cred.getEmail());*/
		modelAndView.setViewName("login");
		return modelAndView;
	}
	@RequestMapping(value = "/loadResetPassword")
	public ModelAndView loadResetPassword(CredentialsEntity cred) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PasswordReset");
		modelAndView.addObject("credLogin",new CredentialsEntity());
		return modelAndView;
	}
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(@ModelAttribute("credLogin") CredentialsEntity cred) {
		ModelAndView modelAndView = new ModelAndView();
		CredentialsEntity creds = credService.resetPassword(cred);
		modelAndView.setViewName("PasswordReset");
		if(creds!=null) {
			modelAndView.addObject("message", "Password is : "+ creds.getPassword());
		}
		else {
			modelAndView.addObject("message", "User not found");
		}
		
		return modelAndView;
	}
}
