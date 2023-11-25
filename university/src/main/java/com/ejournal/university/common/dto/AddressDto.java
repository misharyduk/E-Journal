package com.ejournal.university.common.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    public String country;
    public String city;
    public String street;
    public String number;
    public String zipCode;

}
