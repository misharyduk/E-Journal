package com.ejournal.university.teacher.service.impl;

import com.ejournal.university.common.exception.ResourceNotFoundException;
import com.ejournal.university.department.entity.Department;
import com.ejournal.university.teacher.dto.TeacherRequestDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.ejournal.university.teacher.entity.Teacher;
import com.ejournal.university.teacher.mapper.TeacherMapper;
import com.ejournal.university.teacher.repository.TeacherRepository;
import com.ejournal.university.teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public TeacherResponseDto create(TeacherRequestDto requestDto) {
        Teacher teacher = TeacherMapper.mapToEntity(requestDto, new Teacher());
        return TeacherMapper.mapToDto(teacherRepository.createInstance(teacher));
    }

    @Override
    public TeacherResponseDto fetchById(Long id) {
        Teacher teacher = teacherRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "id", String.valueOf(id)));
        return TeacherMapper.mapToDto(teacher);
    }

    @Override
    public List<TeacherResponseDto> fetchAll() {
        List<Teacher> allTeachers = teacherRepository.fetchAllInstances();
        return allTeachers.stream()
                .map(TeacherMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherResponseDto update(Long id, TeacherRequestDto requestDto) {
        Teacher teacher = teacherRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "id", String.valueOf(id)));
        Teacher updatedTeacher = TeacherMapper.mapToEntity(requestDto, teacher);
        updatedTeacher = teacherRepository.updateInstance(updatedTeacher);
        return TeacherMapper.mapToDto(updatedTeacher);
    }

    @Override
    public boolean deleteById(Long id) {
        Teacher teacher = teacherRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "id", String.valueOf(id)));
        teacherRepository.deleteInstance(teacher);
        return true;
    }
}
