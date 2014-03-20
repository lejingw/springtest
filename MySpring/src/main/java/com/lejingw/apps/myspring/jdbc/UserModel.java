package com.lejingw.apps.myspring.jdbc;
public class UserModel {  
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	private int id;  
    private String myName;     
    //省略getter和setter  
    
} 