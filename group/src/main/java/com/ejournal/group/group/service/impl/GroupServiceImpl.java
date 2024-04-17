package com.ejournal.group.group.service.impl;

import com.ejournal.group.common.dto.PageableRequestDto;
import com.ejournal.group.common.dto.PageableResponseDto;
import com.ejournal.group.common.exception.ResourceNotFoundException;
import com.ejournal.group.group.dto.GroupRequestDto;
import com.ejournal.group.group.dto.GroupResponseDto;
import com.ejournal.group.group.entity.Group;
import com.ejournal.group.group.mapper.GroupMapper;
import com.ejournal.group.group.repository.GroupRepository;
import com.ejournal.group.group.service.GroupService;
import com.ejournal.group.group.service.feign_clients.university.UniversityFeignClient;
import com.ejournal.group.group.service.feign_clients.university.dto.DepartmentResponseDto;
import com.ejournal.group.student.dto.StudentRequestDto;
import com.ejournal.group.student.dto.StudentResponseDto;
import com.ejournal.group.student.entity.Student;
import com.ejournal.group.student.mapper.StudentMapper;
import com.ejournal.group.student.repository.StudentRepository;
import com.ejournal.group.student.service.StudentService;
import com.ejournal.group.student.service.impl.StudentPaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    // OpenFeign Clients
    private final UniversityFeignClient universityClient;

    private final StudentService studentService;
    private final GroupPaginationService groupPaginationService;

    private final GroupRepository groupRepository;

    @Override
    public GroupResponseDto create(GroupRequestDto requestDto) {
        Group group = GroupMapper.mapToEntity(requestDto, new Group());

        if(requestDto.getDepartmentId() <= 0)
            throw new RuntimeException("Department id cannot be less or equals than 0");

        ResponseEntity<DepartmentResponseDto> departmentDto = universityClient.fetchDepartment(requestDto.getDepartmentId());

        if(departmentDto.getBody() == null)
            throw new ResourceNotFoundException("Department", "id", String.valueOf(requestDto.getDepartmentId()));

        group.setDepartmentId(requestDto.getDepartmentId());

        groupRepository.createInstance(group);
        return GroupMapper.mapToDto(group);
    }

    @Override
    public GroupResponseDto fetchById(Long id) {
        Group group = groupRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Group", "id", String.valueOf(id)));

        // fetching department
        ResponseEntity<DepartmentResponseDto> departmentDto = universityClient.fetchDepartment(group.getDepartmentId());
        if(departmentDto.getBody() == null)
            throw new ResourceNotFoundException("Department", "id", String.valueOf(group.getDepartmentId()));

        // fetching students
        List<StudentResponseDto> students = studentService.fetchByGroupId(group.getId());

        GroupResponseDto responseDto = GroupMapper.mapToDto(group);
        responseDto.setNumberOfStudents((long) students.size());
        responseDto.setDepartment(departmentDto.getBody());
        return responseDto;
    }

    @Override
    public List<GroupResponseDto> fetchAll() {
        List<Group> allGroups = groupRepository.fetchAllInstances();
        return allGroups.stream()
                .map(GroupMapper::mapToDto)
                .peek(dto -> dto.setNumberOfStudents(studentService.countByGroupId(dto.getId())))
                .toList();
    }

    @Override
    public PageableResponseDto<GroupResponseDto> fetchPage(PageableRequestDto pageableRequestDto) {
        PageableResponseDto<GroupResponseDto> page = groupPaginationService.fetchPage(pageableRequestDto);
        return page;
    }

    @Override
    public GroupResponseDto update(Long id, GroupRequestDto requestDto) {
        Group group = groupRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Group", "id", String.valueOf(id)));
        Group updatedGroup = GroupMapper.mapToEntity(requestDto, group);

        updatedGroup = groupRepository.updateInstance(updatedGroup);
        return GroupMapper.mapToDto(updatedGroup);
    }

    @Override
    public boolean deleteById(Long id) {
        Group group = groupRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Group", "id", String.valueOf(id)));
        groupRepository.deleteInstance(group);
        return true;
    }

}
