package com.ejournal.university.teacher.mapper;

import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.faculty.mapper.FacultyMapper;
import com.ejournal.university.faculty.service.FacultyService;
import com.ejournal.university.teacher.dto.TeacherRequestDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.ejournal.university.teacher.entity.Teacher;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TeacherMapper {

    private static FacultyService facultyService;

    public static Teacher mapToEntity(TeacherRequestDto requestDto, Teacher teacher){
        teacher.setFirstName(requestDto.getFirstName());
        teacher.setLastName(requestDto.getLastName());
        teacher.setMiddleName(requestDto.getMiddleName());
        teacher.setEmail(requestDto.getEmail());
        teacher.setMobilePhone(requestDto.getMobilePhone());
        teacher.setFaculty(FacultyMapper.mapToEntity(facultyService.fetchById(requestDto.getFacultyId())), new Faculty());
        return teacher;
    }

    public static TeacherResponseDto mapToDto(Teacher teacher){
        return TeacherResponseDto.builder()
                .setFirstName(teacher.getFirstName())
                .setLastName(teacher.getLastName())
                .setMiddleName(teacher.getMiddleName())
                .setEmail(teacher.getEmail())
                .setMobilePhone(teacher.getMobilePhone())
                .setFaculty(FacultyMapper.mapToDto(teacher.getFaculty()))
                .build();
    }
}
