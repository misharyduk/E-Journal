package com.ejournal.university.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class AddressDto {

    public String country;
    public String city;
    public String street;
    public String number;
    public String zipCode;

}
