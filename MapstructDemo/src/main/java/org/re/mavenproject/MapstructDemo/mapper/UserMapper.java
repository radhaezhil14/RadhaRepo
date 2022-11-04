package org.re.mavenproject.MapstructDemo.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.re.mavenproject.MapstructDemo.dto.AddressDTO;
import org.re.mavenproject.MapstructDemo.dto.UserDTO;
import org.re.mavenproject.MapstructDemo.model.Address;
import org.re.mavenproject.MapstructDemo.model.User;

@Mapper

public interface UserMapper {
	
	UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target="firstName",source= "initials")// Mapping fields that have different property names
	@Mapping(target="userType", constant="Customer")//Setting a fixed constant value to  DTO
	@Mapping(target="userId", expression = "java(generateID())")
	@Mapping(target="addressDTO",source= "address")// Mapping a property which is a POJO
	/*Set the fullname in DTO with initals and lastname from model*/
	@Mapping(target="fullName" ,source="user",qualifiedByName = "fullnamebyinitialsandlastname")
	UserDTO convertToDto(User user);
	
	@InheritInverseConfiguration(name = "convertToDto")
	@Mapping(target="lastName", source="fullName")
	@Mapping(target="address",source= "addressDTO")// Mapping a property which is a POJO

	User convertToEntity(UserDTO userDTO);
	
	@Mapping(target="location", source="city")
	AddressDTO toAddressDTO(Address address);
	
	default String generateID()
	{
		return "usr" + Math.random();
	}
	@Named("fullnamebyinitialsandlastname")
	default String fullnamebyinitialsandlastname(User user)
	{
		return user.getInitials() + " " + user.getLastName();
	}
	

}
