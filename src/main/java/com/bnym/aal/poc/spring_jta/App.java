package com.bnym.aal.poc.spring_jta;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static springJtaDaoClass springJtaDaoClass;

	public springJtaDaoClass getSpringJtaDaoClass() {
		return springJtaDaoClass;
	}

	public void setSpringJtaDaoClass(springJtaDaoClass springJtaDaoClass) {
		this.springJtaDaoClass = springJtaDaoClass;
	}

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

		springJtaDaoClass.daoWrapper();

	}
}
