
package com.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestuarantDAO {

	Connection con;
	PreparedStatement pst;
	
	public String updateRest(Restuarant rest) throws ClassNotFoundException, SQLException {
		Restuarant restFound = searchRest(rest.getRestid());
		if (restFound!=null) {
			String cmd = "Update Restaurant set RestaurantName=?,RestaurantCity=?,"+ "Mobile=? Where RestaurantId=? ";
			pst = con.prepareStatement(cmd);
			pst.setString(1, rest.getRestname());
			pst.setString(2, rest.getRestcity());
			pst.setString(3, rest.getMobile());
			pst.setInt(4, rest.getRestid());
			pst.executeUpdate();
			return "Record Updated...";
		}
		return "Record Not Found...";
	}
	public String deleteRest(int restid) throws ClassNotFoundException, SQLException {
		Restuarant rest = searchRest(restid);
		if (rest!=null) {
			con = ConnectionHelper.getConnection();
			String cmd = "Delete From Restaurant where RestaurantId=?";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, restid);
			pst.executeUpdate();
			return "Record Deleted...";
		}
		return "Record Not Found...";
	}
	public String addRest(Restuarant rest) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Insert into Restaurant(RestaurantName,RestaurantCity,Mobile)"
				+ " values(?,?,?)";
		pst = con.prepareStatement(cmd);
		pst.setString(1, rest.getRestname());
		pst.setString(2, rest.getRestcity());
		pst.setString(3, rest.getMobile());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	
	public Restuarant searchRest(int restid) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "select * from Restaurant  where RestaurantId=?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1,restid);
		ResultSet rs = pst.executeQuery();
		Restuarant  rest = null;
		if (rs.next()) {
			rest = new Restuarant();
			rest.setRestid(rs.getInt("RestaurantId"));
			rest.setRestname(rs.getString("RestaurantName"));
			rest.setRestcity(rs.getString("RestaurantCity"));
			rest.setMobile(rs.getString("Mobile"));
			//employ.setBasic(rs.getDouble("basic"));			
		}
		return rest;
	}
	
	public List<Restuarant> showRest() throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "select * from Restaurant";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Restuarant> restList = new ArrayList<Restuarant>();
		Restuarant rest= null;
		while(rs.next()) {
			rest = new Restuarant();
			rest.setRestid(rs.getInt("RestaurantId"));
			rest.setRestname(rs.getString("RestaurantName"));
			rest.setRestcity(rs.getString("RestaurantCity"));
			rest.setMobile(rs.getString("Mobile"));
			//employ.setBasic(rs.getDouble("basic"));
			restList.add(rest);
		}
		return restList;
	}
}