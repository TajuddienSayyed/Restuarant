package com.java.jdbc;

import java.sql.SQLException;
import java.util.List;

public class RestuarntShowMain {

	public static void main(String[] args) {
		RestuarantDAO dao = new RestuarantDAO();
		try {
			List<Restuarant> RestList = dao.showRest();
			for (Restuarant rest : RestList) {
				System.out.println(rest);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}