package com.lejingw.apps.myspring.aop;

public class DataAccessException extends RuntimeException {
	public DataAccessException(){
	}
	public DataAccessException(String string) {
		super(string);
	}

}
