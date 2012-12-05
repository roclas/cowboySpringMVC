package com.roclas.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.roclas.form.LoginForm;

@Controller
@SessionAttributes("loginForm")
public class LoginController {
	
	//@RequestMapping(method = RequestMethod.GET)
	@RequestMapping(method=RequestMethod.GET, value="/login")
	public String showForm(Map model){
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/admin/logout")
	public String logout(){
		return "logout";
	}

	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String processForm(@Valid LoginForm loginForm, BindingResult result, Map model) {
		String userName = "Admin";
		String password = "root";
		if(result.hasErrors()){ return "loginform"; }
		loginForm = (LoginForm) model.get("loginForm");
		if (!loginForm.getUserName().equals(userName) || !loginForm.getPassword().equals(password)) {
			loginForm.setUserName(null);
			return "loginerror";
		}
		loginForm.setPassword(null);
		return "loginsuccess";
	}
	
	
}