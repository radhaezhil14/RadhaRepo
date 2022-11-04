package org.re.mavenproject.MapstructDemo.mapper;

import org.re.mavenproject.MapstructDemo.dto.AddressDTO;
import org.re.mavenproject.MapstructDemo.dto.UserDTO;
import org.re.mavenproject.MapstructDemo.model.Address;
import org.re.mavenproject.MapstructDemo.model.User;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-04T17:11:09-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4 (Eclipse Adoptium)"
)
*/
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO convertToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setFirstName( user.getInitials() );
        userDTO.setAddressDTO( toAddressDTO( user.getAddress() ) );
        userDTO.setFullName( fullnamebyinitialsandlastname( user ) );
        userDTO.setAge( user.getAge() );

        userDTO.setUserType( "Customer" );
        userDTO.setUserId( generateID() );

        return userDTO;
    }

    @Override
    public User convertToEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setLastName( userDTO.getFullName() );
        user.setAddress( addressDTOToAddress( userDTO.getAddressDTO() ) );
        user.setInitials( userDTO.getFirstName() );
        user.setAge( userDTO.getAge() );

        return user;
    }

    @Override
    public AddressDTO toAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setLocation( address.getCity() );

        return addressDTO;
    }

    protected Address addressDTOToAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        return address;
    }
}
