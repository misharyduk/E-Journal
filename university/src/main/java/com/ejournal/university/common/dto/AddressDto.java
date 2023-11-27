package com.ejournal.university.common.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private String country;
    private String city;
    private String street;
    private String number;
    private String zipCode;

}
