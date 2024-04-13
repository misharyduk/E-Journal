package com.ejournal.group.student.service.impl;

import com.ejournal.group.common.dto.PageableRequestDto;
import com.ejournal.group.common.dto.PageableResponseDto;
import com.ejournal.group.common.exception.ResourceNotFoundException;
import com.ejournal.group.group.entity.Group;
import com.ejournal.group.group.repository.GroupRepository;
import com.ejournal.group.student.dto.StudentRequestDto;
import com.ejournal.group.student.dto.StudentResponseDto;
import com.ejournal.group.student.entity.Student;
import com.ejournal.group.student.mapper.StudentMapper;
import com.ejournal.group.student.repository.StudentRepository;
import com.ejournal.group.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentPaginationService studentPaginationService;

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    @Override
    public StudentResponseDto create(StudentRequestDto requestDto) {
        Student student = StudentMapper.mapToEntity(requestDto, new Student());

        //fetching group
        Group group = groupRepository.fetchInstanceById(requestDto.getGroupId())
                .orElseThrow(() -> new ResourceNotFoundException("Group", "id", String.valueOf(requestDto.getGroupId())));
        student.setGroup(group);

        studentRepository.createInstance(student);
        return StudentMapper.mapToDto(student);
    }

    @Override
    public StudentResponseDto fetchById(Long id) {
        Student student = studentRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", String.valueOf(id)));

        return StudentMapper.mapToDto(student);
    }

    @Override
    public List<StudentResponseDto> fetchByGroupId(Long groupId) {
        List<Student> students = studentRepository.fetchStudentsByGroupId(groupId);
        return students.stream()
                .map(StudentMapper::mapToDto)
                .toList();
    }

    @Override
    public Long countByGroupId(Long groupId){
        return studentRepository.countStudentByGroupId(groupId);
    }

    @Override
    public List<StudentResponseDto> fetchAll() {
        List<Student> allStudents = studentRepository.fetchAllInstances();
        return allStudents.stream()
                .map(StudentMapper::mapToDto)
                .toList();
    }

    @Override
    public PageableResponseDto<StudentResponseDto> fetchPage(PageableRequestDto pageableRequestDto) {
        PageableResponseDto<StudentResponseDto> page = studentPaginationService.fetchPage(pageableRequestDto);
        return page;
    }


    @Override
    public StudentResponseDto update(Long id, StudentRequestDto requestDto) {
        Student student = studentRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", String.valueOf(id)));
        Student updatedStudent = StudentMapper.mapToEntity(requestDto, student);

        // mapping rector either he's been updated or not
        Group group = groupRepository.fetchInstanceById(requestDto.getGroupId())
                .orElseThrow(() -> new ResourceNotFoundException("Group", "id", String.valueOf(requestDto.getGroupId())));
        updatedStudent.setGroup(group);

        updatedStudent = studentRepository.updateInstance(updatedStudent);
        return StudentMapper.mapToDto(updatedStudent);
    }

    @Override
    public boolean deleteById(Long id) {
        Student student = studentRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", String.valueOf(id)));
        studentRepository.deleteInstance(student);
        return true;
    }
}
