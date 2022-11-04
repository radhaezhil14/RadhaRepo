package org.re.mavenproject.MapstructDemo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.re.mavenproject.MapstructDemo.dto.ProfileDTO;

import org.re.mavenproject.MapstructDemo.model.Address;
import org.re.mavenproject.MapstructDemo.model.Education;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE , uses = {UserMapper.class})
public interface ProfileDTOMapper {
	
	ProfileDTOMapper PROFILE_MAPPER = Mappers.getMapper(ProfileDTOMapper.class);

	//@Mapping(target="",source="")
	ProfileDTO buildProfileDTO(Education education,List<Address> addresses);

}
