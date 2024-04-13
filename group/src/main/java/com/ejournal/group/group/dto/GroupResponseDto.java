package com.ejournal.group.group.dto;

import com.ejournal.group.group.dto.builder.GroupResponseBuilder;
import com.ejournal.group.group.service.feign_clients.university.dto.DepartmentResponseDto;
import com.ejournal.group.student.dto.StudentResponseDto;
import com.ejournal.group.student.dto.builder.StudentResponseBuilder;
import com.ejournal.group.student.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@JsonIgnoreProperties
public class GroupResponseDto {

    private Long id;
    private Integer groupNumber;
    private List<StudentResponseDto> students;
    private Long numberOfStudents;
    private DepartmentResponseDto department;

    public GroupResponseDto() {
    }

    public GroupResponseDto(Long id, Integer groupNumber, List<StudentResponseDto> students) {
        this.id = id;
        this.groupNumber = groupNumber;
        this.students = students;
    }

    public static GroupResponseBuilder builder(){
        return GroupResponseBuilder.getInstance();
    }
}
