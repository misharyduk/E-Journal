package com.ejournal.university.department.service.impl;

import com.ejournal.university.common.dto.PageableRequestDto;
import com.ejournal.university.common.dto.PageableResponseDto;
import com.ejournal.university.common.exception.ResourceNotFoundException;
import com.ejournal.university.common.util.SortFieldValidator;
import com.ejournal.university.department.dto.DepartmentRequestDto;
import com.ejournal.university.department.dto.DepartmentResponseDto;
import com.ejournal.university.department.entity.Department;
import com.ejournal.university.department.mapper.DepartmentMapper;
import com.ejournal.university.department.repository.DepartmentRepository;
import com.ejournal.university.department.service.DepartmentService;
import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.faculty.repository.FacultyRepository;
import com.ejournal.university.teacher.entity.Teacher;
import com.ejournal.university.teacher.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;
    private final TeacherRepository teacherRepository;

    private final DepartmentPaginationService paginationService;

    @Override
    public DepartmentResponseDto create(DepartmentRequestDto requestDto) {
        Department department = DepartmentMapper.mapToEntity(requestDto, new Department());

        // fetching faculty for appropriate mapping
        Faculty faculty = facultyRepository.fetchInstanceById(requestDto.getFacultyId())
                .orElseThrow(() -> new ResourceNotFoundException("Faculty", "id", String.valueOf(requestDto.getFacultyId())));
        department.setFaculty(faculty);

        // fetching head of department for appropriate mapping
        Teacher headOfDepartment = teacherRepository.fetchInstanceById(requestDto.getHeadOfDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Head of Department", "id", String.valueOf(requestDto.getFacultyId())));
        department.setHeadOfDepartment(headOfDepartment);

        departmentRepository.createInstance(department);
        return DepartmentMapper.mapToDto(department);
    }

    @Override
    public DepartmentResponseDto fetchById(Long id) {
        Department department = departmentRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", String.valueOf(id)));
        return DepartmentMapper.mapToDto(department);
    }

    @Override
    public List<DepartmentResponseDto> fetchAll() {
        List<Department> allDepartments = departmentRepository.fetchAllInstances();
        return allDepartments.stream()
                .map(DepartmentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageableResponseDto<DepartmentResponseDto> fetchPage(PageableRequestDto pageableRequestDto) {

        PageableResponseDto<DepartmentResponseDto> page = paginationService.fetchPage(pageableRequestDto);
        return page;
    }

    @Override
    public DepartmentResponseDto update(Long id, DepartmentRequestDto requestDto) {
        Department department = departmentRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", String.valueOf(id)));
        Department updatedDepartment = DepartmentMapper.mapToEntity(requestDto, department);

        // checking if head of department hasn't been updated
        Teacher headOfDepartment = teacherRepository.fetchInstanceById(requestDto.getHeadOfDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Head of Department", "id", String.valueOf(requestDto.getHeadOfDepartmentId())));
        updatedDepartment.setHeadOfDepartment(headOfDepartment);

        updatedDepartment = departmentRepository.updateInstance(updatedDepartment);
        return DepartmentMapper.mapToDto(updatedDepartment);
    }

    @Override
    public boolean deleteById(Long id) {
        Department department = departmentRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", String.valueOf(id)));
        departmentRepository.deleteInstance(department);
        return true;
    }
}
