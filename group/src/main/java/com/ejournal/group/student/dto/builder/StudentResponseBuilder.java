package com.ejournal.group.student.dto.builder;

import com.ejournal.group.common.dto.builder.Builder;
import com.ejournal.group.student.dto.StudentResponseDto;
import com.ejournal.group.group.dto.GroupResponseDto;

public class StudentResponseBuilder implements Builder<StudentResponseDto> {

    private Long studentId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String mobilePhone;
    private String email;
    private GroupResponseDto group;

    private StudentResponseBuilder(){}

    public static StudentResponseBuilder getInstance(){
        return new StudentResponseBuilder();
    }

    public StudentResponseBuilder setStudentId(Long studentId) {
        this.studentId = studentId;
        return this;
    }

    public StudentResponseBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StudentResponseBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentResponseBuilder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public StudentResponseBuilder setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public StudentResponseBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public StudentResponseBuilder setGroup(GroupResponseDto group) {
        this.group = group;
        return this;
    }


    @Override
    public StudentResponseDto build() {
        return new StudentResponseDto(studentId, firstName, lastName,
                middleName, mobilePhone, email, group);
    }
}
