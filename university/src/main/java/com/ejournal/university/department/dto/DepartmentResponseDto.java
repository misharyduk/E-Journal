package com.ejournal.university.department.dto;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;

public class DepartmentResponseDto {

    private String departmentName;
    private String departmentDescription;
    private AddressDto address;
    private String officeNumber;
    private String mobilePhone;
    private String email;
    private TeacherResponseDto headOfDepartment;

}
