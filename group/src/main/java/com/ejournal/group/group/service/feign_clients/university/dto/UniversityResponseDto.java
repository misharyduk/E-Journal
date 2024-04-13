package com.ejournal.group.group.service.feign_clients.university.dto;

import lombok.Getter;
import lombok.Setter;

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
    private Long numberOfFaculties;
    private Long numberOfDepartments;
    private Long numberOfTeachers;
    private Long numberOfStudents;

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
