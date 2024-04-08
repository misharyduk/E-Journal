package com.ejournal.university.teacher.dto;

import com.ejournal.university.common.dto.AddressDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class TeacherRequestDto {

    private String firstName;
    private String lastName;
    private String middleName;
//    private List<String> academicRanks;
    private String mobilePhone;
    private String email;
    private Long facultyId;

}
