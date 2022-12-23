package com.accenture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.model.Model;

public class customerRegister extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		Model m = new Model(name, username, password, email);

		int rows = m.customerRegister();
		System.out.println("result of rows is " + rows);
		if (rows == 1) {
			response.sendRedirect("/car-service-center-mvc/registerSuccess.html");
		} else if (rows == -1) {
			response.sendRedirect("/car-service-center-mvc/duplicateUsername.html");
		} else {
			response.sendRedirect("/car-service-center-mvc/registerFail.html");
		}

	}

}
