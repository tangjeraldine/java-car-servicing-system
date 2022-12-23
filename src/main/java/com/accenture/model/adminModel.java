package com.accenture.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class adminModel {
	private String name;
	private String admin_username;
	private String admin_password;
	private String username;
	private String email;
	private String cust_name;
	private String cust_username;
	private String cust_email;
	private ResultSet res = null;
//	public static ArrayList<String> cust_name_arr = new ArrayList<String>();
//	public static ArrayList<String> cust_username_arr = new ArrayList<String>();
//	public static ArrayList<String> cust_email_arr = new ArrayList<String>();

	public adminModel(String admin_username, String admin_password) {
		super();
		this.admin_username = admin_username;
		this.admin_password = admin_password;
	}
	
	public adminModel(String cust_name) {
		super();
		this.cust_name = cust_name;
	}
	
	public adminModel() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return admin_username;
	}

	public void setUsername(String username) {
		this.admin_username = username;
	}

	public String getPassword() {
		return admin_password;
	}

	public void setPassword(String password) {
		this.admin_password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int adminLogin() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Driver loaded successfully");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/car_service_center?serverTimezone=UTC", "root", "Th$Beebies2809");
			System.out.println("Connection established successfully");

			String s2 = "select * from admin_db where admin_username=? and admin_password=?";
			PreparedStatement pstmt = con.prepareStatement(s2);
			pstmt.setString(1, admin_username);
			pstmt.setString(2, admin_password);
			res = pstmt.executeQuery();
			System.out.println("value of res here is "+res);
//			if (res == null) {
//				return 0;
//			}
			while (res.next()) {
				admin_username= res.getString(1);
				admin_password= res.getString(2);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_username() {
		return cust_username;
	}

	public void setCust_username(String cust_username) {
		this.cust_username = cust_username;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	
	public ArrayList<CustomerDetail> viewAllCustomers() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Driver loaded successfully");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/car_service_center?serverTimezone=UTC", "root", "Th$Beebies2809");
			System.out.println("Connection established successfully");

			String s2 = "select * from customer_db";
			Statement pstmt = con.createStatement();
			res = pstmt.executeQuery(s2);
//			System.out.println("value of res here is "+res);
			
			ArrayList<CustomerDetail> al = new ArrayList<CustomerDetail>();
			while (res.next()) {
//				cust_name_arr.add(res.getString(1));
//				cust_username_arr.add(res.getString(2));
//				cust_email_arr.add(res.getString(4));
				name = res.getString(1);
				username = res.getString(2);
				email = res.getString(4);
				CustomerDetail tempCust = new CustomerDetail(name, username, email);
				al.add(tempCust);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int viewOneCustomer() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Driver loaded successfully");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/car_service_center?serverTimezone=UTC", "root", "Th$Beebies2809");
			System.out.println("Connection established successfully");

			String s2 = "select * from customer_db where name=?";
			PreparedStatement pstmt = con.prepareStatement(s2);
			pstmt.setString(1, cust_name);
			res = pstmt.executeQuery();
//			System.out.println("value of res here is "+res);
			
			while (res.next()) {
				setCust_name(res.getString(1));
				setCust_username(res.getString(2));
				setCust_email(res.getString(4));
				
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
}


