package com.ejournal.university.info.dto;

import com.ejournal.university.common.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Data;

public class UniversityRequestDto {

    private String universityName;
    private String universityDescription;
    private AddressDto address;
    private String mobilePhone;
    private String email;
    private String accreditation;
    private RectorDto rector;

    @Data
    @AllArgsConstructor
    public static class RectorDto {
        private String firstName;
        private String lastName;
        private String middleName;
    }

    public UniversityRequestDto(){}
    @Override
    public String toString() {
        return "UniversityRequestDto{" +
                "universityName='" + universityName + '\'' +
                ", universityDescription='" + universityDescription + '\'' +
                ", address=" + address +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", accreditation='" + accreditation + '\'' +
                ", rector=" + rector +
                '}';
    }

}
