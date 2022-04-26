package com.java.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class RestuarantSearch{

	public static void main(String[] args) {
		RestuarantDAO dao = new RestuarantDAO();
		int restid;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Restuarant id Number  ");
		restid = sc.nextInt();
		try {
			Restuarant rest = dao.searchRest(restid);
			if (rest!=null) {
				System.out.println(rest);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}