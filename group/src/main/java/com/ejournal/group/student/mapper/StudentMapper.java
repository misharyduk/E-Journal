package com.ejournal.group.student.mapper;

import com.ejournal.group.group.mapper.GroupMapper;
import com.ejournal.group.student.dto.StudentRequestDto;
import com.ejournal.group.student.dto.StudentResponseDto;
import com.ejournal.group.student.entity.Student;

public class StudentMapper {

    public static Student mapToEntity(StudentRequestDto requestDto, Student student){
        student.setFirstName(requestDto.getFirstName());
        student.setLastName(requestDto.getLastName());
        student.setMiddleName(requestDto.getMiddleName());
        student.setEmail(requestDto.getEmail());
        student.setMobilePhone(requestDto.getMobilePhone());
        return student;
    }

    public static StudentResponseDto basicMapToDto(Student student){
        return StudentResponseDto.builder()
                .setStudentId(student.getId())
                .setFirstName(student.getFirstName())
                .setLastName(student.getLastName())
                .setMiddleName(student.getMiddleName())
                .setEmail(student.getEmail())
                .setMobilePhone(student.getMobilePhone())
                .build();
    }

    public static StudentResponseDto mapToDto(Student student){
        StudentResponseDto responseDto = basicMapToDto(student);
        if(student.getGroup() != null)
            responseDto.setGroup(GroupMapper.basicMapToDto(student.getGroup()));
        return responseDto;
    }

}
