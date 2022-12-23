package com.accenture.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.CustomerDetail;
import com.accenture.model.adminModel;

public class viewAllCustomers extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		adminModel AM = new adminModel();

		ArrayList<CustomerDetail> al = AM.viewAllCustomers();
		
//		String cust_name = AM.getCust_name();
//		String cust_username = AM.getCust_username();
//		String cust_email = AM.getCust_email();
		
		// first time getting the session, put as true
		HttpSession session = request.getSession(true);
		//using an arraylist approach --> iterate over the information in a table in jsp file
//		session.setAttribute("cust_name", adminModel.cust_name_arr);
//		session.setAttribute("cust_username", adminModel.cust_username_arr);
//		session.setAttribute("cust_email", adminModel.cust_email_arr);
		
		//alternatively 
		session.setAttribute("al", al);

		if (al!=null) {
			response.sendRedirect("/car-service-center-mvc/adminAllCustomerList.jsp");
		} else {
			response.sendRedirect("/car-service-center-mvc/adminSearchFail.html");
		}
	}

}
