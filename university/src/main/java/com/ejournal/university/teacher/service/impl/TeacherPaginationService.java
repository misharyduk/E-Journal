package com.ejournal.university.teacher.service.impl;

import com.ejournal.university.common.dto.PageableRequestDto;
import com.ejournal.university.common.dto.PageableResponseDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.ejournal.university.teacher.repository.TeacherPaginationRepository;
import com.ejournal.university.common.util.SortFieldValidator.TeacherField;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherPaginationService {

    private final TeacherPaginationRepository teacherPaginationRepository;

    public PageableResponseDto<TeacherResponseDto> fetchPage(PageableRequestDto pageableRequestDto) {
        String validSortFieldName = TeacherField.validate(pageableRequestDto.getField()).getValidHQLField();
        Pageable pageable = PageRequest.of(pageableRequestDto.getPage() - 1, pageableRequestDto.getSize())
                .withSort(Sort.Direction.fromString(pageableRequestDto.getDir()), validSortFieldName);

        Page<Tuple> pageOfTeachers = teacherPaginationRepository.fetchPage(pageable, validSortFieldName, pageableRequestDto.getDir());
        var listOfTeacherDTOs = pageOfTeachers.stream()
                .map(t -> convertTuple(t))
                .toList();

        return new PageableResponseDto<>(
                pageOfTeachers.getTotalPages(),
                pageableRequestDto.getPage(),
                pageOfTeachers.getSize(),
                validSortFieldName,
                pageOfTeachers.getTotalElements(),
                listOfTeacherDTOs
        );
    }

    private TeacherResponseDto convertTuple(Tuple tuple){
        return TeacherResponseDto.builder()
                .setTeacherId(tuple.get("teacherId", Long.class))
                .setFirstName(tuple.get("firstName", String.class))
                .setLastName(tuple.get("lastName", String.class))
                .setMiddleName(tuple.get("middleName", String.class))
                .setEmail(tuple.get("email", String.class))
                .setMobilePhone(tuple.get("mobilePhone", String.class))
                .build();
    }
}
