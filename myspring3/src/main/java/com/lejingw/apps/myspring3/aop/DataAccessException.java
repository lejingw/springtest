package com.lejingw.apps.myspring3.aop;

public class DataAccessException extends RuntimeException {
	public DataAccessException(){
	}
	public DataAccessException(String string) {
		super(string);
	}

}
