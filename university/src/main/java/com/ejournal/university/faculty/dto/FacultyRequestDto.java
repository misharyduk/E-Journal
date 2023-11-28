package com.ejournal.university.faculty.dto;

import com.ejournal.university.common.dto.AddressDto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FacultyRequestDto {

    private String facultyName;
    private String facultyDescription;
    private AddressDto address;
    private String officeNumber;
    private String mobilePhone;
    private String email;
    private Long deanId;
    private Long universityId;
}
