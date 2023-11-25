package com.ejournal.university.department.dto.builder;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.dto.builder.Builder;
import com.ejournal.university.department.dto.DepartmentResponseDto;
import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.teacher.dto.TeacherResponseDto;

public class DepartmentResponseBuilder implements Builder<DepartmentResponseDto> {

    private String departmentName;
    private String departmentDescription;
    private AddressDto address;
    private String officeNumber;
    private String mobilePhone;
    private String email;
    private TeacherResponseDto headOfDepartment;
    private Faculty faculty;

    private DepartmentResponseBuilder(){}

    public static DepartmentResponseBuilder getInstance(){
        return new DepartmentResponseBuilder();
    }

    public DepartmentResponseBuilder setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public DepartmentResponseBuilder setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
        return this;
    }

    public DepartmentResponseBuilder setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public DepartmentResponseBuilder setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
        return this;
    }

    public DepartmentResponseBuilder setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public DepartmentResponseBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public DepartmentResponseBuilder setHeadOfDepartment(TeacherResponseDto headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
        return this;
    }

    public DepartmentResponseBuilder setFaculty(Faculty faculty) {
        this.faculty = faculty;
        return this;
    }

    @Override
    public DepartmentResponseDto build() {
        return new DepartmentResponseDto(departmentName, departmentDescription, address,
                officeNumber, mobilePhone, email, headOfDepartment, faculty);
    }
}
