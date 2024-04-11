package com.ejournal.group.group.service.feign_clients.university.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DepartmentResponseDto {

    private Long departmentId;
    private String departmentName;
    private String departmentDescription;
    private AddressDto address;
    private String officeNumber;
    private String mobilePhone;
    private String email;
    private TeacherResponseDto headOfDepartment;
    private FacultyResponseDto faculty;

}
