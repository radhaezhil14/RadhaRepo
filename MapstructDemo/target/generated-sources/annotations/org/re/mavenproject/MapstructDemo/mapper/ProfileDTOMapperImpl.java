package org.re.mavenproject.MapstructDemo.mapper;

import java.util.ArrayList;
import java.util.List;
import org.mapstruct.factory.Mappers;
import org.re.mavenproject.MapstructDemo.dto.AddressDTO;
import org.re.mavenproject.MapstructDemo.dto.EductionDTO;
import org.re.mavenproject.MapstructDemo.dto.ProfileDTO;
import org.re.mavenproject.MapstructDemo.model.Address;
import org.re.mavenproject.MapstructDemo.model.Education;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-04T17:11:09-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4 (Eclipse Adoptium)"
)
*/
public class ProfileDTOMapperImpl implements ProfileDTOMapper {

    private final UserMapper userMapper = Mappers.getMapper( UserMapper.class );

    @Override
    public ProfileDTO buildProfileDTO(Education education, List<Address> addresses) {
        if ( education == null && addresses == null ) {
            return null;
        }

        ProfileDTO profileDTO = new ProfileDTO();

        profileDTO.setEducation( educationToEductionDTO( education ) );
        profileDTO.setAddresses( addressListToAddressDTOList( addresses ) );

        return profileDTO;
    }

    protected List<AddressDTO> addressListToAddressDTOList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressDTO> list1 = new ArrayList<AddressDTO>( list.size() );
        for ( Address address : list ) {
            list1.add( userMapper.toAddressDTO( address ) );
        }

        return list1;
    }

    protected EductionDTO educationToEductionDTO(Education education) {
        if ( education == null ) {
            return null;
        }

        EductionDTO eductionDTO = new EductionDTO();

        eductionDTO.setCollege( education.getCollege() );

        return eductionDTO;
    }
}
