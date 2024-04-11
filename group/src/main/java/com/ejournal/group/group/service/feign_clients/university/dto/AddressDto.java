package com.ejournal.group.group.service.feign_clients.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
