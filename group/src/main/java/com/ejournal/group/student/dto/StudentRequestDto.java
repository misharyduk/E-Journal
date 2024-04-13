package com.ejournal.group.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentRequestDto {

    private String firstName;
    private String lastName;
    private String middleName;
    private String mobilePhone;
    private String email;
    private Long groupId;


}
