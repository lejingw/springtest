package cn.javass.spring.chapter12;

import org.springframework.beans.factory.annotation.Autowired;

public class TestBean12 {
    
    private String abc;
    
    public String getAbc() {
        return abc;
    }
//    public String getA() {
//        return a;
//    }
//    
    @Autowired
    public void setAbc(String a) {
        this.abc = a;
    }
}
