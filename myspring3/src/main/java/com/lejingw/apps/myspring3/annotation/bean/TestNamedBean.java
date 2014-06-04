package com.lejingw.apps.myspring3.annotation.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.ApplicationContext;

@Named("namedBean")
public class TestNamedBean {

	@Inject
	private ApplicationContext ctx;

	public ApplicationContext getCtx() {
		return ctx;
	}
}
