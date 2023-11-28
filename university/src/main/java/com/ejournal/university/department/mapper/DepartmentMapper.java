package com.ejournal.university.department.mapper;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.entity.Address;
import com.ejournal.university.common.mapper.AddressMapper;
import com.ejournal.university.department.dto.DepartmentRequestDto;
import com.ejournal.university.department.dto.DepartmentResponseDto;
import com.ejournal.university.department.entity.Department;
import com.ejournal.university.faculty.mapper.FacultyMapper;
import com.ejournal.university.teacher.mapper.TeacherMapper;

public class DepartmentMapper {

    public static Department mapToEntity(DepartmentRequestDto requestDto, Department department){
        department.setDepartmentName(requestDto.getDepartmentName());
        department.setDepartmentDescription(requestDto.getDepartmentDescription());
        if(requestDto.getAddress() != null)
            department.setAddress(AddressMapper.mapToEntity(requestDto.getAddress(), new Address()));
        department.setOfficeNumber(requestDto.getOfficeNumber());
        department.setEmail(requestDto.getEmail());
        department.setMobilePhone(requestDto.getMobilePhone());
        return department;
    }

    public static DepartmentResponseDto basicMapToDto(Department department){
        return DepartmentResponseDto.builder()
                .setDepartmentId(department.getId())
                .setDepartmentName(department.getDepartmentName())
                .setDepartmentDescription(department.getDepartmentDescription())
                .setAddress(AddressMapper.mapToDto(department.getAddress(), new AddressDto()))
                .setOfficeNumber(department.getOfficeNumber())
                .setEmail(department.getEmail())
                .setMobilePhone(department.getMobilePhone())
                .build();
    }

    public static DepartmentResponseDto mapToDto(Department department){
        DepartmentResponseDto responseDto = basicMapToDto(department);
        responseDto.setHeadOfDepartment(TeacherMapper.basicMapToDto(department.getHeadOfDepartment()));
        responseDto.setFaculty(FacultyMapper.basicMapToDto(department.getFaculty()));
        return responseDto;
    }
}
