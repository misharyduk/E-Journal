package com.ejournal.university.teacher.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherResponseDto {

    private String firstName;
    private String lastName;
    private String middleName;
    //    private List<String> academicRanks;
    private String mobilePhone;
    private String email;

}
