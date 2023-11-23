package com.ejournal.university.faculty.dto;

import com.ejournal.university.info.dto.UniversityRequestDto;

public class FacultyRequestDto {

    private String facultyName;
    private String facultyDescription;
    private AddressDto address;
    private String mobilePhone;
    private String email;
    private Long deanId;

    private class AddressDto{
        private String country;
        private String city;
        private String street;
        private String number;
        private String zipCode;
        private String officeNumber;
    }
}
