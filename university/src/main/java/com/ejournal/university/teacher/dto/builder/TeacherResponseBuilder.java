package com.ejournal.university.teacher.dto.builder;

import com.ejournal.university.common.dto.builder.Builder;
import com.ejournal.university.faculty.dto.FacultyResponseDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;

public class TeacherResponseBuilder implements Builder<TeacherResponseDto> {

    private Long teacherId;
    private String firstName;
    private String lastName;
    private String middleName;
    //    private List<String> academicRanks;
    private String mobilePhone;
    private String email;
    private FacultyResponseDto faculty;

    private TeacherResponseBuilder(){}

    public static TeacherResponseBuilder getInstance(){
        return new TeacherResponseBuilder();
    }

    public TeacherResponseBuilder setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public TeacherResponseBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public TeacherResponseBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public TeacherResponseBuilder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public TeacherResponseBuilder setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public TeacherResponseBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public TeacherResponseBuilder setFaculty(FacultyResponseDto faculty) {
        this.faculty = faculty;
        return this;
    }

    @Override
    public TeacherResponseDto build() {
        return new TeacherResponseDto(teacherId, firstName, lastName, middleName,
                mobilePhone, email, faculty);
    }
}
