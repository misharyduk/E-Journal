package com.ejournal.university.faculty.dto;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;

public class FacultyResponseDto {

    private String facultyName;
    private String facultyDescription;
    private AddressDto address;
    private String officeNumber;
    private String mobilePhone;
    private String email;
    private TeacherResponseDto dean;

}
