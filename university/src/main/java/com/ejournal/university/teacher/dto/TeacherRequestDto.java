package com.ejournal.university.teacher.dto;

import com.ejournal.university.common.dto.AddressDto;

import java.util.List;

public class TeacherRequestDto {

    private String firstName;
    private String secondName;
    private String middleName;
    private List<String> academicRanks;
    private AddressDto homeAddress;
    private String mobilePhone;
    private String email;

}
