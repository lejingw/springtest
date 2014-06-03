package com.lejingw.apps.myspring3.annotation.bean;

import org.springframework.beans.factory.annotation.Value;

public class TestBean21 {
    
    @Value(value = "#{message}")
    private String message;

    public String getMessage() {
        return message;
    }
}
