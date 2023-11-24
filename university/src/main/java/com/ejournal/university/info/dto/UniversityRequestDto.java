package com.ejournal.university.info.dto;

import com.ejournal.university.common.dto.AddressDto;

public class UniversityRequestDto {

    private String universityName;
    private String universityDescription;
    private AddressDto address;
    private String mobilePhone;
    private String email;
    private String accreditation;
    private RectorDto rector;

    private class RectorDto{
        private String firstName;
        private String lastName;
        private String middleName;
    }

}
