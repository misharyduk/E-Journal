package com.ejournal.university.faculty.dto;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.info.dto.UniversityRequestDto;

public class FacultyRequestDto {

    private String facultyName;
    private String facultyDescription;
    private AddressDto address;
    private String officeNumber;
    private String mobilePhone;
    private String email;
    private Long deanId;
}
