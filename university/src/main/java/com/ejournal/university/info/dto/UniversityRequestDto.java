package com.ejournal.university.info.dto;

public class UniversityRequestDto {

    private String universityName;
    private String universityDescription;
    private AddressDto address;
    private String mobilePhone;
    private String accreditation;
    private Rector rector;

    private class AddressDto{
        private String country;
        private String city;
        private String street;
        private String number;
        private String zipCode;
    }

    private class Rector{
        private String firstName;
        private String lastName;
        private String middleName;
    }

}
