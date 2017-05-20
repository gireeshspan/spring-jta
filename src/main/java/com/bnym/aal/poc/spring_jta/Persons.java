package com.bnym.aal.poc.spring_jta;

import java.io.Serializable;

public class Persons implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private static final Persons Persons = null;
	private static Integer in;
	private static String lastName;
	private static String firstName;
	private static String address;
	private static String city;

	public Persons persons(Integer in, String lastName, String firstName, String address, String city) {
		Persons persons = new Persons();
		persons.setIn(in);
		persons.setLastName(lastName);
		persons.setFirstName(firstName);
		persons.setAddress(address);
		persons.setCity(city);
		return persons;
	}

	public static Integer getIn() {
		return in;
	}

	public void setIn(Integer in) {
		Persons.in = in;
	}

	public static String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		Persons.lastName = lastName;
	}

	public static String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		Persons.firstName = firstName;
	}

	public static String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		Persons.address = address;
	}

	public static String getCity() {
		return city;
	}

	public void setCity(String city) {
		Persons.city = city;
	}

	@Override
	public String toString() {
		return "Persons [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
