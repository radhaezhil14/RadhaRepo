package org.re.mavenproject.MapstructDemo.dto;

import lombok.Data;

@Data
public class UserDTO {

	private int age;
	private String firstName;
	private String fullName;
	private String userId;
	private String userType;	
	private AddressDTO addressDTO;
}
