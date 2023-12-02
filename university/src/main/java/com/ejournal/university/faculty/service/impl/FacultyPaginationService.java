package com.ejournal.university.faculty.service.impl;

import com.ejournal.university.common.dto.PageableRequestDto;
import com.ejournal.university.common.dto.PageableResponseDto;
import com.ejournal.university.common.util.SortFieldValidator.FacultyField;
import com.ejournal.university.faculty.dto.FacultyResponseDto;
import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.faculty.mapper.FacultyMapper;
import com.ejournal.university.faculty.repository.FacultyPaginationRepository;
import com.ejournal.university.faculty.repository.FacultyRepository;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static com.ejournal.university.common.util.SortFieldValidator.FacultyField.*;

@Service
@RequiredArgsConstructor
public class FacultyPaginationService {

    private final FacultyPaginationRepository facultyPaginationRepository;

    public PageableResponseDto<FacultyResponseDto> fetchPage(PageableRequestDto pageableRequestDto) {
        FacultyField validSortFieldName = FacultyField.validate(pageableRequestDto.getField());
        return switch (validSortFieldName) {
            case FACULTY_ID, FACULTY_NAME -> fetchOnBasicField(pageableRequestDto, validSortFieldName.getValidHQLField());
            case DEPARTMENTS -> fetchOnNumberOfDepartments(pageableRequestDto);
            case TEACHERS -> fetchOnNumberOfTeachers(pageableRequestDto);
            case STUDENTS -> fetchOnNumberOfStudents(pageableRequestDto);
        };
    }

    private PageableResponseDto<FacultyResponseDto> fetchOnBasicField(PageableRequestDto pageableRequestDto, String field) {

        Pageable pageable = PageRequest.of(pageableRequestDto.getPage() - 1, pageableRequestDto.getSize())
                .withSort(Sort.Direction.fromString(pageableRequestDto.getDir()), field);

        Page<Tuple> pageOfFaculties = facultyPaginationRepository.fetchPage(pageable,
                field, pageableRequestDto.getDir());
        var listOfFacultyDTOs = pageOfFaculties.stream()
                .map(t -> convertTuple(t, FACULTY_ID))
                .toList();

        return new PageableResponseDto<>(
                pageOfFaculties.getTotalPages(),
                pageableRequestDto.getPage(),
                pageOfFaculties.getSize(),
                field,
                pageOfFaculties.getTotalElements(),
                listOfFacultyDTOs
        );
    }

    private PageableResponseDto<FacultyResponseDto> fetchOnNumberOfDepartments(PageableRequestDto pageableRequestDto) {
        Pageable pageable = PageRequest.of(pageableRequestDto.getPage() - 1, pageableRequestDto.getSize())
                .withSort(Sort.Direction.fromString(pageableRequestDto.getDir()), "departments");

        Page<Tuple> pageOfFaculties = facultyPaginationRepository.fetchPageOnDepartments(pageable);

        var listOfFacultyDTOs = pageOfFaculties.stream()
                .map(t -> convertTuple(t, DEPARTMENTS))
                .toList();

        return new PageableResponseDto<>(
                pageOfFaculties.getTotalPages(),
                pageableRequestDto.getPage(),
                pageOfFaculties.getSize(),
                "departments",
                pageOfFaculties.getTotalElements(),
                listOfFacultyDTOs
        );
    }

    private PageableResponseDto<FacultyResponseDto> fetchOnNumberOfTeachers(PageableRequestDto pageableRequestDto) {
        Pageable pageable = PageRequest.of(pageableRequestDto.getPage() - 1, pageableRequestDto.getSize())
                .withSort(Sort.Direction.fromString(pageableRequestDto.getDir()), "teachers");

        Page<Tuple> pageOfFaculties = facultyPaginationRepository.fetchPageOnTeachers(pageable);

        var listOfFacultyDTOs = pageOfFaculties.stream()
                .map(t -> convertTuple(t, TEACHERS))
                .toList();

        return new PageableResponseDto<>(
                pageOfFaculties.getTotalPages(),
                pageableRequestDto.getPage(),
                pageOfFaculties.getSize(),
                "teachers",
                pageOfFaculties.getTotalElements(),
                listOfFacultyDTOs
        );
    }

    private PageableResponseDto<FacultyResponseDto> fetchOnNumberOfStudents(PageableRequestDto pageableRequestDto) {
        // TODO implement method
        return null;
    }

    private FacultyResponseDto convertTuple(Tuple tuple, FacultyField sortField){
        FacultyResponseDto responseDto = FacultyResponseDto.builder().setFacultyId(tuple.get("facultyId", Long.class))
                .setFacultyName(tuple.get("facultyName", String.class))
                .setFacultyDescription(tuple.get("facultyDescription", String.class))
                .build();

        switch (sortField){
            case DEPARTMENTS -> responseDto.setNumberOfDepartments(tuple.get("departmentCount", Long.class));
            case TEACHERS -> responseDto.setNumberOfTeachers(tuple.get("teacherCount", Long.class));
        }

        return responseDto;
    }
}
