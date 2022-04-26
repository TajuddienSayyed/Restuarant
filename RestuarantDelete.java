package com.java.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class RestuarantDelete {

	public static void main(String[] args) {
		int restid;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Resturant id   ");
		restid=sc.nextInt();
		RestuarantDAO dao= new RestuarantDAO();
		try {
			System.out.println(dao.deleteRest(restid));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}