package com.ejournal.university.teacher.dto;

import com.ejournal.university.faculty.dto.FacultyResponseDto;
import com.ejournal.university.teacher.dto.builder.TeacherResponseBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class TeacherResponseDto {

    private Long teacherId;
    private String firstName;
    private String lastName;
    private String middleName;
    //    private List<String> academicRanks;
    private String mobilePhone;
    private String email;
    private FacultyResponseDto faculty;

    public TeacherResponseDto() {
    }

    public TeacherResponseDto(Long teacherId, String firstName, String lastName,
                              String middleName, String mobilePhone,
                              String email, FacultyResponseDto faculty) {
        this.teacherId = teacherId;
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
