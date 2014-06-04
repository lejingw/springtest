package com.lejingw.apps.myspring3.annotation.bean.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lejingw.apps.myspring3.annotation.bean.service.TestServiceImpl;

@Controller
public class TestAction {
    
    @Autowired
    private TestServiceImpl testService;
    
    public void list() {
        //调用业务逻辑层方法
    }
}
