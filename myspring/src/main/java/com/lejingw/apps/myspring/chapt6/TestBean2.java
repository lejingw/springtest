package com.lejingw.apps.myspring.chapt6;

import org.springframework.beans.factory.annotation.Autowired;

public class TestBean2 {  
    public String getMessage() {
		return message;
	}
	private String message;  
    @Autowired //构造器注入  
    private TestBean2(String message) {  
        this.message = message;  
    }
}  