package com.accenture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.Model;

public class customerLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		super.service(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Model m = new Model(username, password);
		
		int rows = m.customerLogin();
		
		String name1 = m.getName();
		String username1 = m.getUsername();
		String password1 = m.getPassword();
		String email1 = m.getEmail();
		
		// first time getting the session, put as true
		HttpSession session = request.getSession(true);
		session.setAttribute("name", name1);
		session.setAttribute("username", username1);
		session.setAttribute("password", password1);
		session.setAttribute("email", email1);
		System.out.println("name1 is "+name1);
		System.out.println("username1 is "+username1);
		System.out.println("result of rows is "+rows);
		if (name1!=null) {
			response.sendRedirect("/car-service-center-mvc/custLoginSuccess.jsp");
		} else {
			response.sendRedirect("/car-service-center-mvc/custLoginFail.html");
		}
		
	}

}
