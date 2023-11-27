package com.ejournal.university.teacher.dto;

import com.ejournal.university.faculty.dto.FacultyResponseDto;
import com.ejournal.university.teacher.dto.builder.TeacherResponseBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherResponseDto {

    private String firstName;
    private String lastName;
    private String middleName;
    //    private List<String> academicRanks;
    private String mobilePhone;
    private String email;
    private FacultyResponseDto faculty;

    public TeacherResponseDto() {
    }

    public TeacherResponseDto(String firstName, String lastName,
                              String middleName, String mobilePhone,
                              String email, FacultyResponseDto faculty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.faculty = faculty;
    }

    public static TeacherResponseBuilder builder(){
        return TeacherResponseBuilder.getInstance();
    }
}
