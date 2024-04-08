package com.ejournal.university.faculty.dto;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.faculty.dto.builder.FacultyResponseBuilder;
import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FacultyResponseDto {

    private Long facultyId;
    private String facultyName;
    private String facultyDescription;
    private AddressDto address;
    private String officeNumber;
    private String mobilePhone;
    private String email;
    private TeacherResponseDto dean;
    private UniversityResponseDto university;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long numberOfDepartments;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long numberOfTeachers;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long numberOfStudents;

    public FacultyResponseDto(){}

    public FacultyResponseDto(Long facultyId, String facultyName, String facultyDescription,
                              AddressDto address, String officeNumber,
                              String mobilePhone, String email, TeacherResponseDto dean,
                              UniversityResponseDto university) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyDescription = facultyDescription;
        this.address = address;
        this.officeNumber = officeNumber;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.dean = dean;
        this.university = university;
    }

    public static FacultyResponseBuilder builder(){
        return FacultyResponseBuilder.getInstance();
    }
}
