package com.bnym.aal.poc.spring_jta;

import java.io.Serializable;

public class Persons implements Serializable {
	/**
		 * 
		 */
	private  final long serialVersionUID = 1L;

	
	private  Integer in;
	private  String lastName;
	private  String firstName;
	private  String address;
	private  String city;

	public Persons persons(Integer in, String lastName, String firstName, String address, String city) {
		Persons persons=new Persons();
		persons.setIn(in);
		persons.setLastName(lastName);
		persons.setFirstName(firstName);
		persons.setAddress(address);
		persons.setCity(city);
		return persons;
	}

	public  Integer getIn() {
		return in;
	}

	public void setIn(Integer in) {
		this.in = in;
	}

	public  String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public  String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public  String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public  String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Persons [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
