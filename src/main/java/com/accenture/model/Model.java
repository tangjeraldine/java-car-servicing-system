package com.accenture.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model {
	private String name;
	private String username;
	private String password;
	private String email;
	private ResultSet res = null;

	public Model(String name, String username, String password, String email) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Model(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int customerRegister() {
		int rows = 0;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Driver loaded successfully");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/car_service_center?serverTimezone=UTC", "root", "Th$Beebies2809");
			System.out.println("Connection established successfully");

			String s1 = "select * from customer_db where username=?";
			PreparedStatement pstmt0 = con.prepareStatement(s1);
			pstmt0.setString(1, username);
			res = pstmt0.executeQuery();
			if (res.next()) {
				return -1; //there is duplicate username
			} else {
				String s2 = "insert into customer_db values(?, ?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(s2);
				pstmt.setString(1, name);
				pstmt.setString(2, username);
				pstmt.setString(3, password);
				pstmt.setString(4, email);
				rows = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	public int customerLogin() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Driver loaded successfully");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/car_service_center?serverTimezone=UTC", "root", "Th$Beebies2809");
			System.out.println("Connection established successfully");

			String s2 = "select * from customer_db where username=? and password=?";
			PreparedStatement pstmt = con.prepareStatement(s2);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			res = pstmt.executeQuery();
			System.out.println("value of res here is "+res);
//			if (res == null) {
//				return 0;
//			}
			while (res.next()) {
				name = res.getString(1);
				username= res.getString(2);
				password= res.getString(3);
				email = res.getString(4);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
