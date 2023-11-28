package com.ejournal.university.faculty.mapper;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.entity.Address;
import com.ejournal.university.common.mapper.AddressMapper;
import com.ejournal.university.faculty.dto.FacultyRequestDto;
import com.ejournal.university.faculty.dto.FacultyResponseDto;
import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.info.mapper.UniversityMapper;
import com.ejournal.university.info.service.UniversityService;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.ejournal.university.teacher.mapper.TeacherMapper;
import com.ejournal.university.teacher.service.TeacherService;
import lombok.AllArgsConstructor;

public class FacultyMapper {

    public static Faculty mapToEntity(FacultyRequestDto requestDto, Faculty faculty){
        faculty.setFacultyName(requestDto.getFacultyName());
        faculty.setFacultyDescription(requestDto.getFacultyDescription());
        faculty.setAddress(AddressMapper.mapToEntity(requestDto.getAddress(), new Address()));
        faculty.setOfficeNumber(requestDto.getOfficeNumber());
        faculty.setEmail(requestDto.getEmail());
        faculty.setMobilePhone(requestDto.getMobilePhone());
        return faculty;
    }

    public static FacultyResponseDto basicMapToDto(Faculty faculty){
        return FacultyResponseDto.builder().setFacultyId(faculty.getId())
                .setFacultyName(faculty.getFacultyName())
                .setFacultyDescription(faculty.getFacultyDescription())
                .setAddress(AddressMapper.mapToDto(faculty.getAddress(), new AddressDto()))
                .setOfficeNumber(faculty.getOfficeNumber())
                .setEmail(faculty.getEmail())
                .setMobilePhone(faculty.getMobilePhone())
                .build();
    }

    public static FacultyResponseDto mapToDto(Faculty faculty){
        FacultyResponseDto responseDto = basicMapToDto(faculty);
        if(faculty.getDean() != null)
            responseDto.setDean(TeacherMapper.basicMapToDto(faculty.getDean()));
        responseDto.setUniversity(UniversityMapper.basicMapToDto(faculty.getUniversity()));
        return responseDto;
    }

}
