package com.ejournal.group.group.service.feign_clients.university.dto;

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
    private Long numberOfDepartments;
    private Long numberOfTeachers;
    private Long numberOfStudents;

}
