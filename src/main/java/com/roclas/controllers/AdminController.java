package com.roclas.controllers;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roclas.form.LoginForm;
 
@Controller
public class AdminController {
  
 @RequestMapping(method=RequestMethod.GET, value="/admin/home")
 public String handleRequest(@ModelAttribute("LoginForm") LoginForm loginform){
	  //if(user==null)return "redirect:/admin/login";
	  return "home";
 }
 
 @RequestMapping(method=RequestMethod.GET, value="/admin/welcome")
 public String handleRequest2(){
  //if(user==null)return "redirect:/admin/login";
  return "welcome";
 }
 
}