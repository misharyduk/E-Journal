package com.ejournal.university.department.mapper;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.entity.Address;
import com.ejournal.university.common.mapper.AddressMapper;
import com.ejournal.university.department.dto.DepartmentRequestDto;
import com.ejournal.university.department.dto.DepartmentResponseDto;
import com.ejournal.university.department.entity.Department;
import com.ejournal.university.faculty.mapper.FacultyMapper;
import com.ejournal.university.teacher.mapper.TeacherMapper;
import com.ejournal.university.teacher.service.TeacherService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DepartmentMapper {

    private static TeacherService teacherService;

    public static Department mapToEntity(DepartmentRequestDto requestDto, Department department){
        department.setDepartmentName(requestDto.getDepartmentName());
        department.setDepartmentDescription(requestDto.getDepartmentDescription());
        department.setAddress(AddressMapper.mapToEntity(requestDto.getAddress(), new Address()));
        department.setOfficeNumber(requestDto.getOfficeNumber());
        department.setEmail(requestDto.getEmail());
        department.setMobilePhone(requestDto.getMobilePhone());
        return department;
    }

    public static DepartmentResponseDto mapToResponseDto(Department department){
        return DepartmentResponseDto.builder()
                .setDepartmentName(department.getDepartmentName())
                .setDepartmentDescription(department.getDepartmentDescription())
                .setAddress(AddressMapper.mapToDto(department.getAddress(), new AddressDto()))
                .setOfficeNumber(department.getOfficeNumber())
                .setEmail(department.getEmail())
                .setMobilePhone(department.getMobilePhone())
                .setHeadOfDepartment(TeacherMapper.mapToDto(department.getHeadOfDepartment()))
                .setFaculty(FacultyMapper.mapToDto(department.getFaculty()))
                .build();
    }

}
