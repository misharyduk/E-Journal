package com.ejournal.university.subject.mapper;

import com.ejournal.university.subject.dto.SubjectRequestDto;
import com.ejournal.university.subject.dto.SubjectResponseDto;
import com.ejournal.university.subject.entity.Subject;

public class SubjectMapper {

    public static Subject mapToEntity(SubjectRequestDto requestDto, Subject subject){
        subject.setName(requestDto.getSubjectName());
        return subject;
    }

    public static SubjectResponseDto mapToDto(Subject subject){
        return new SubjectResponseDto(subject.getId(), subject.getName());
    }

}
