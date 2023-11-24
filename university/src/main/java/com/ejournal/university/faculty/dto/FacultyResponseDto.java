package com.ejournal.university.faculty.dto;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.faculty.dto.builder.FacultyResponseBuilder;
import com.ejournal.university.teacher.dto.TeacherResponseDto;

public class FacultyResponseDto {

    private String facultyName;
    private String facultyDescription;
    private AddressDto address;
    private String officeNumber;
    private String mobilePhone;
    private String email;
    private TeacherResponseDto dean;

    public FacultyResponseDto(){}

    public FacultyResponseDto(String facultyName, String facultyDescription,
                              AddressDto address, String officeNumber,
                              String mobilePhone, String email, TeacherResponseDto dean) {
        this.facultyName = facultyName;
        this.facultyDescription = facultyDescription;
        this.address = address;
        this.officeNumber = officeNumber;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.dean = dean;
    }

    public static FacultyResponseBuilder builder(){
        return FacultyResponseBuilder.getInstance();
    }
}
