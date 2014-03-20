package com.lejingw.apps.myspring.aop.impl;

import com.lejingw.apps.myspring.aop.IIntroductionService;

public class IntroductiondService implements IIntroductionService {
	@Override
	public void induct() {
		System.out.println("=========introduction");
	}
}