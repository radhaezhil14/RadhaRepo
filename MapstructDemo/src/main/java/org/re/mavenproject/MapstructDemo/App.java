package org.re.mavenproject.MapstructDemo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.re.mavenproject.MapstructDemo.dto.ProfileDTO;
import org.re.mavenproject.MapstructDemo.dto.UserDTO;
import org.re.mavenproject.MapstructDemo.mapper.ProfileDTOMapper;
import org.re.mavenproject.MapstructDemo.mapper.UserMapper;
import org.re.mavenproject.MapstructDemo.model.Address;
import org.re.mavenproject.MapstructDemo.model.Education;
import org.re.mavenproject.MapstructDemo.model.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// Create User object and set values for the same
		User usr = new User();
		usr.setAge(23);
		usr.setInitials("Radha");
		usr.setLastName("Ezhil");
		// Create Address object
		Address address = new Address();
		address.setCity("Chennai");
		usr.setAddress(address);
		// Call the mapstruct method
		UserDTO userdto = UserMapper.USER_MAPPER.convertToDto(usr);
		System.out.println(userdto);
		System.out.println(userdto.getUserType());
		System.out.println("City :" + userdto.getAddressDTO().getLocation());

		List<Address> addresslist = Stream.of("Delhi", "Bengaluru").map(city -> {
			Address address1 = new Address();
			address1.setCity(city);
			return address1;

		}).collect(Collectors.toList());

		Education edu = new Education();
		edu.setCollege("SRR");
		/*
		 * Call ProfileDTOMapper method with two different DTO as inputs. Create a list
		 * of addresses and education object
		 * 
		 */
		ProfileDTO profdto = ProfileDTOMapper.PROFILE_MAPPER.buildProfileDTO(edu, addresslist);
		System.out.println("Location List:" + profdto.getAddresses());
		System.out.println("Education :" + profdto.getEducation());

		System.out.println("*********After Conversion");
		User userTest = UserMapper.USER_MAPPER.convertToEntity(userdto);
		System.out.println(userTest);



	}
}
