package com.bnym.aal.poc.spring_jta;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App implements Serializable{
	public static springJtaDaoClass springJtaDaoClass;

	public springJtaDaoClass getSpringJtaDaoClass() {
		return springJtaDaoClass;
	}

	public void setSpringJtaDaoClass(springJtaDaoClass springJtaDaoClass) {
		this.springJtaDaoClass = springJtaDaoClass;
	}

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

		Persons p1=new Persons();
		p1.setIn(3);
		p1.setLastName("a");
		p1.setFirstName("b");
		p1.setAddress("c");
		p1.setCity("d");
		
		Persons p2=new Persons();
		p2.setIn(4);
		p2.setLastName("a");
		p2.setFirstName("b");
		p2.setAddress("c");
		p2.setCity("d");
		
		springJtaDaoClass.daoWrapper(p1,p2);

	}
}
