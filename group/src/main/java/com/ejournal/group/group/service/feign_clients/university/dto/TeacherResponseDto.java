package com.ejournal.group.group.service.feign_clients.university.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TeacherResponseDto {

    private Long teacherId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String mobilePhone;
    private String email;
    private FacultyResponseDto faculty;

}
