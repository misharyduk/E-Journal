package com.ejournal.university.faculty.dto.builder;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.dto.builder.Builder;
import com.ejournal.university.faculty.dto.FacultyResponseDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;

public class FacultyResponseBuilder implements Builder<FacultyResponseDto> {

    private String facultyName;
    private String facultyDescription;
    private AddressDto address;
    private String officeNumber;
    private String mobilePhone;
    private String email;
    private TeacherResponseDto dean;

    private FacultyResponseBuilder(){}

    public static FacultyResponseBuilder getInstance(){
        return new FacultyResponseBuilder();
    }

    public FacultyResponseBuilder setFacultyName(String facultyName) {
        this.facultyName = facultyName;
        return this;
    }

    public FacultyResponseBuilder setFacultyDescription(String facultyDescription) {
        this.facultyDescription = facultyDescription;
        return this;
    }

    public FacultyResponseBuilder setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public FacultyResponseBuilder setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
        return this;
    }

    public FacultyResponseBuilder setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public FacultyResponseBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public FacultyResponseBuilder setDean(TeacherResponseDto dean) {
        this.dean = dean;
        return this;
    }

    @Override
    public FacultyResponseDto build() {
        return new FacultyResponseDto(facultyName, facultyDescription,
                address, officeNumber, mobilePhone, email, dean);
    }
}
