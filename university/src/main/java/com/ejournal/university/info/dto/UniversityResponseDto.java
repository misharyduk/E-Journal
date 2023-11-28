package com.ejournal.university.info.dto;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.info.dto.builder.UniversityResponseBuilder;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class UniversityResponseDto {

    private Long universityId;
    private String universityName;
    private String universityDescription;
    private AddressDto address;
    private String mobilePhone;
    private String email;
    private String accreditation;
    private TeacherResponseDto rector;

    public UniversityResponseDto(){}

    public UniversityResponseDto(Long universityId,
                                 String universityName,
                                 String universityDescription,
                                 AddressDto address,
                                 String mobilePhone,
                                 String email,
                                 String accreditation,
                                 TeacherResponseDto rector) {
        this.universityId = universityId;
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
                "universityId='" + universityId + '\'' +
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
