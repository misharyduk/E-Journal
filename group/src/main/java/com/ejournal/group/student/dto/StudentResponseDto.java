package com.ejournal.group.student.dto;

import com.ejournal.group.group.entity.Group;
import com.ejournal.group.group.dto.GroupResponseDto;
import com.ejournal.group.student.dto.builder.StudentResponseBuilder;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String mobilePhone;
    private String email;
    private GroupResponseDto group;

    public StudentResponseDto() {
    }

    public StudentResponseDto(Long id, String firstName, String lastName,
                              String middleName, String mobilePhone,
                              String email, GroupResponseDto group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.group = group;
    }

    public static StudentResponseBuilder builder(){
        return StudentResponseBuilder.getInstance();
    }
}
