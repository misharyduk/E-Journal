package com.ejournal.university.department.dto;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.department.dto.builder.DepartmentResponseBuilder;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentResponseDto {

    private String departmentName;
    private String departmentDescription;
    private AddressDto address;
    private String officeNumber;
    private String mobilePhone;
    private String email;
    private TeacherResponseDto headOfDepartment;

    public DepartmentResponseDto() {}

    public DepartmentResponseDto(String departmentName, String departmentDescription,
                                 AddressDto address, String officeNumber, String mobilePhone,
                                 String email, TeacherResponseDto headOfDepartment) {
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.address = address;
        this.officeNumber = officeNumber;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.headOfDepartment = headOfDepartment;
    }

    public static DepartmentResponseBuilder builder(){
        return DepartmentResponseBuilder.getInstance();
    }
}
