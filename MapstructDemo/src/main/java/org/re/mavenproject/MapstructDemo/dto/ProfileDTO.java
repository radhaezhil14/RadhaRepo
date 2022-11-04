package org.re.mavenproject.MapstructDemo.dto;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.re.mavenproject.MapstructDemo.mapper.UserMapper;

import lombok.Data;

/*A new DTO which takes input from two different DTO */
@Data
public class ProfileDTO {
	


	private List<AddressDTO> addresses;
	private EductionDTO education;
	
}
