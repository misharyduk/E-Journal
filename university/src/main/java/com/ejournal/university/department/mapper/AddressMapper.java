package com.ejournal.university.department.mapper;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.entity.Address;

public class AddressMapper {

    public static Address mapToEntity(AddressDto addressDto, Address address){
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setNumber(addressDto.getNumber());
        address.setZipCode(addressDto.getZipCode());
        return address;
    }

    public static AddressDto mapToDto(Address address, AddressDto addressDto){
        addressDto.setCountry(address.getCountry());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setNumber(address.getNumber());
        addressDto.setZipCode(address.getZipCode());
        return addressDto;
    }

}
