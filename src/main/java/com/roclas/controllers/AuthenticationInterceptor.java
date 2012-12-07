package com.roclas.controllers;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.roclas.form.LoginForm;
//import com.sivalabs.entities.User;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter
{
 @Override
 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
  String uri = request.getRequestURI();
  String rootpath= request.getContextPath();
  String admin_prefix="/admin/";
  if(uri.matches(".*"+admin_prefix+".*")) {
	System.out.println("checking if user's logged in (to access "+uri+") "+rootpath);
   //String userData = (String) request.getSession().getAttribute("LOGGEDIN_USER"); 
   LoginForm loginForm=(LoginForm) request.getSession().getAttribute("loginForm"); 
   
   String redirectUri=uri.split(admin_prefix)[0]+"/login";
   if(loginForm== null || loginForm.getUserName()==null){
	System.out.println("not logged in");
    response.sendRedirect(redirectUri);
    return false;
   }else {
	   System.out.println(loginForm.getUserName()+" is logged in");
   }
  }else{
	System.out.println("no privileges needed (to access "+uri+") "+rootpath);
  }
  return true;
 }
}
