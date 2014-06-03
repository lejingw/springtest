package com.lejingw.apps.myspring3.annotation.bean;

import org.springframework.beans.factory.annotation.Required;


public class TestBean {
    
    private String message;
    
    @Required
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
