package com.java.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class RestuarantInsert {

	public static void main(String[] args) {
		Restuarant rest = new Restuarant();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Restuarant Name   ");
		rest.setRestname(sc.next());
		System.out.println("Enter Restuarant city  ");
		rest.setRestcity(sc.next());
		System.out.println("Enter Mobile  ");
		rest.setMobile(sc.next());
		RestuarantDAO dao = new RestuarantDAO();
		try {
			System.out.println(dao.addRest(rest));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}