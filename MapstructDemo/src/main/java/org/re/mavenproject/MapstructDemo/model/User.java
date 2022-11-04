package org.re.mavenproject.MapstructDemo.model;

import lombok.Data;

@Data
public class User {
	
	private int age;
	private String initials;
	private String lastName;
	private Address address;

}
