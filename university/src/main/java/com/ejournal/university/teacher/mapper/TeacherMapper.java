package com.ejournal.university.teacher.mapper;

import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.faculty.mapper.FacultyMapper;
import com.ejournal.university.faculty.service.FacultyService;
import com.ejournal.university.teacher.dto.TeacherRequestDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.ejournal.university.teacher.entity.Teacher;
import lombok.AllArgsConstructor;

public class TeacherMapper {

    public static Teacher mapToEntity(TeacherRequestDto requestDto, Teacher teacher){
        teacher.setFirstName(requestDto.getFirstName());
        teacher.setLastName(requestDto.getLastName());
        teacher.setMiddleName(requestDto.getMiddleName());
        teacher.setEmail(requestDto.getEmail());
        teacher.setMobilePhone(requestDto.getMobilePhone());
        // TODO: add faculty mapping
        return teacher;
    }

    public static TeacherResponseDto mapToDto(Teacher teacher){
        return TeacherResponseDto.builder()
                .setTeacherId(teacher.getId())
                .setFirstName(teacher.getFirstName())
                .setLastName(teacher.getLastName())
                .setMiddleName(teacher.getMiddleName())
                .setEmail(teacher.getEmail())
                .setMobilePhone(teacher.getMobilePhone())
                // TODO: add faculty mapping
                .build();
    }
}
