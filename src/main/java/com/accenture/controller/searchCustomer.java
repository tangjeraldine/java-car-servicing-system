package com.accenture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.adminModel;

public class searchCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cust_name = request.getParameter("customerSearch");
	
		adminModel AM = new adminModel(cust_name);
		
		int rows = AM.viewOneCustomer();
		
		String cust_name2 = AM.getCust_name();
		String cust_username = AM.getCust_username();
		String cust_email = AM.getCust_email();
		
		// first time getting the session, put as true
		HttpSession session = request.getSession(true);
		session.setAttribute("cust_name", cust_name2);
		session.setAttribute("cust_username", cust_username);
		session.setAttribute("cust_email", cust_email);

		if (cust_name!=null) {
			response.sendRedirect("/car-service-center-mvc/customerSearchResult.jsp");
		} else {
			response.sendRedirect("/car-service-center-mvc/adminSearchFail.html");
		}
	}

}
