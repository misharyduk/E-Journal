package com.ejournal.university.info.dto;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.info.dto.builder.UniversityResponseBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UniversityResponseDto {

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

    public UniversityResponseDto(){}

    public UniversityResponseDto(String universityName,
                                 String universityDescription,
                                 AddressDto address,
                                 String mobilePhone,
                                 String email,
                                 String accreditation,
                                 RectorDto rector) {
        this.universityName = universityName;
        this.universityDescription = universityDescription;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.accreditation = accreditation;
        this.rector = rector;
    }

    public static UniversityResponseBuilder builder(){
        return UniversityResponseBuilder.getInstance();
    }

    @Override
    public String toString() {
        return "UniversityDto{" +
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
