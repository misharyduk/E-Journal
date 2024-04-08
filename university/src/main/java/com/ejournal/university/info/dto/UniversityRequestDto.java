package com.ejournal.university.info.dto;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.teacher.dto.TeacherRequestDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class UniversityRequestDto {

    private String universityName;
    private String universityDescription;
    private AddressDto address;
    private String mobilePhone;
    private String email;
    private String accreditation;
    private Long rectorId;
    private TeacherRequestDto rector;

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
