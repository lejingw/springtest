package com.lejingw.apps.myspring3.aop.service.impl;

import com.lejingw.apps.myspring3.aop.service.IIntroductionService;

public class IntroductiondService implements IIntroductionService {
    
    @Override
    public void induct() {
        System.out.println("=========introduction");
    }
}
