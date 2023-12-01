package com.ejournal.university.faculty.dto.builder;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.dto.builder.Builder;
import com.ejournal.university.faculty.dto.FacultyResponseDto;
import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;

public class FacultyResponseBuilder implements Builder<FacultyResponseDto> {

    private Long facultyId;
    private String facultyName;
    private String facultyDescription;
    private AddressDto address;
    private String officeNumber;
    private String mobilePhone;
    private String email;
    private TeacherResponseDto dean;
    private UniversityResponseDto university;
    private Long numberOfDepartments;
    private Long numberOfTeachers;
    private Long numberOfStudents;

    private FacultyResponseBuilder(){}

    public static FacultyResponseBuilder getInstance(){
        return new FacultyResponseBuilder();
    }

    public FacultyResponseBuilder setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
        return this;
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

    public FacultyResponseBuilder setUniversity(UniversityResponseDto university) {
        this.university = university;
        return this;
    }

    public FacultyResponseBuilder setNumberOfDepartments(Long numberOfDepartments) {
        this.numberOfDepartments = numberOfDepartments;
        return this;
    }

    public FacultyResponseBuilder setNumberOfTeachers(Long numberOfTeachers) {
        this.numberOfTeachers = numberOfTeachers;
        return this;
    }

    public FacultyResponseBuilder setNumberOfStudents(Long numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        return this;
    }

    @Override
    public FacultyResponseDto build() {
        FacultyResponseDto responseDto = new FacultyResponseDto(facultyId, facultyName, facultyDescription,
                address, officeNumber, mobilePhone, email, dean, university);
        responseDto.setNumberOfDepartments(numberOfDepartments);
        responseDto.setNumberOfTeachers(numberOfTeachers);
        responseDto.setNumberOfStudents(numberOfStudents);
        return responseDto;
    }
}
