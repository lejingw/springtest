package com.lejingw.apps.myspring.spel;

import org.springframework.beans.factory.annotation.Value;

public class SpELBean {
	@Value("#{'Hello' + world}")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}