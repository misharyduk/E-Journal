package com.ejournal.university.teacher.dto;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.teacher.entity.AcademicRank;

import java.util.List;

public class TeacherRequestDto {

    private String firstName;
    private String secondName;
    private String middleName;
    private List<AcademicRank> academicRanks;
    private AddressDto homeAddress;
    private String mobilePhone;
    private String email;

}
