package com.ejournal.university.info.mapper;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.entity.Address;
import com.ejournal.university.common.mapper.AddressMapper;
import com.ejournal.university.info.dto.UniversityRequestDto;
import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.info.entity.University;
import com.ejournal.university.teacher.dto.TeacherRequestDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.ejournal.university.teacher.entity.Teacher;
import com.ejournal.university.teacher.mapper.TeacherMapper;

public class UniversityMapper {

    public static University mapToEntity(UniversityRequestDto requestDto, University university){
        university.setUniversityName(requestDto.getUniversityName());
        university.setUniversityDescription(requestDto.getUniversityDescription());
        university.setAddress(AddressMapper.mapToEntity(requestDto.getAddress(), new Address()));
        university.setEmail(requestDto.getEmail());
        university.setMobilePhone(requestDto.getMobilePhone());
        university.setAccreditation(requestDto.getAccreditation());
        university.setRector(TeacherMapper.mapToEntity(requestDto.getRector(), new Teacher()));
        return university;
    }

    public static UniversityResponseDto mapToDto(University university){
        return UniversityResponseDto.builder()
                .setUniversityId(university.getId())
                .setUniversityName(university.getUniversityName())
                .setUniversityDescription(university.getUniversityDescription())
                .setAddress(AddressMapper.mapToDto(university.getAddress(), new AddressDto()))
                .setEmail(university.getEmail())
                .setMobilePhone(university.getMobilePhone())
                .setAccreditation(university.getAccreditation())
                .setRector(TeacherMapper.mapToDto(university.getRector()))
                .build();
    }

}
