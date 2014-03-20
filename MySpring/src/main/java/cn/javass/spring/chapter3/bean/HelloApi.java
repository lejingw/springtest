package cn.javass.spring.chapter3.bean;

import java.util.Map;

import org.springframework.beans.BeansException;

public class HelloApi extends Printer {
	public <T> Map<String, T> testa(Class<T> type) throws BeansException {
		return null;
	}
}
