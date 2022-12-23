package com.accenture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.adminModel;


public class adminLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String adminUsername = request.getParameter("adminUsername");
		String adminPassword = request.getParameter("adminPassword");
		
		adminModel AM = new adminModel(adminUsername, adminPassword);
		
		int rows = AM.adminLogin();
		
		String admin_username1 = AM.getUsername();
		String admin_password1 = AM.getPassword();
		
		// first time getting the session, put as true
		HttpSession session = request.getSession(true);
		session.setAttribute("admin_username", admin_username1);
		session.setAttribute("admin_password", admin_password1);

		System.out.println("username1 is "+admin_username1);
		System.out.println("result of rows is "+rows);
		if (admin_password1!=null) {
			response.sendRedirect("/car-service-center-mvc/adminLoginSuccess.jsp");
		} else {
			response.sendRedirect("/car-service-center-mvc/adminLoginFail.html");
		}
	}

}
