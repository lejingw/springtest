package cn.javass.spring.chapter12;

import org.springframework.beans.factory.annotation.Autowired;

public class TestBean11 {
    
    private String a;
    
    @Autowired(required=false)
    private TestBean11(String b) {
        this.a = b;
    }
    
    public String getMessage() {
        return a;
    }
}
