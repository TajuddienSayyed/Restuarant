
package com.java.jdbc;

public class Restuarant {

	private int restid;
	private String restname;
	private String restcity;
	private String mobile;
	public int getRestid() {
		return restid;
	}
	public void setRestid(int restid) {
		this.restid = restid;
	}
	public String getRestname() {
		return restname;
	}
	public void setRestname(String restname) {
		this.restname = restname;
	}
	public String getRestcity() {
		return restcity;
	}
	public void setRestcity(String restcity) {
		this.restcity = restcity;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Restuarant [restid=" + restid + ", restname=" + restname + ", restcity=" + restcity + ", mobile="
				+ mobile + "]";
	}
	
	
	
}