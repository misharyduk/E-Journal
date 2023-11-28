package com.ejournal.university.department.dto;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.department.dto.builder.DepartmentResponseBuilder;
import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
    private Faculty faculty;

    public DepartmentResponseDto() {}

    public DepartmentResponseDto(Long departmentId, String departmentName, String departmentDescription,
                                 AddressDto address, String officeNumber, String mobilePhone,
                                 String email, TeacherResponseDto headOfDepartment, Faculty faculty) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.address = address;
        this.officeNumber = officeNumber;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.headOfDepartment = headOfDepartment;
        this.faculty = faculty;
    }

    public static DepartmentResponseBuilder builder(){
        return DepartmentResponseBuilder.getInstance();
    }
}
