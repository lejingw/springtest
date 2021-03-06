package com.lejingw.apps.myspring3.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class TestBean23 {
    
    private String message;
    
    @Autowired
    private TestBean23(@Value(value = "#{message}#{message}") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
