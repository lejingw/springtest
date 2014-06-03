package com.lejingw.apps.myspring3.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class TestBean12 {
    
    @Autowired
    private String message;
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
