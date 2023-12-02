package com.ejournal.university.info.service.impl;

import com.ejournal.university.common.dto.PageableRequestDto;
import com.ejournal.university.common.dto.PageableResponseDto;
import com.ejournal.university.common.util.SortFieldValidator;
import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.info.repository.UniversityPaginationRepository;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static com.ejournal.university.common.util.SortFieldValidator.UniversityField.*;

@Service
@RequiredArgsConstructor
public class UniversityPaginationService {

    private final UniversityPaginationRepository universityPaginationRepository;

    public PageableResponseDto<UniversityResponseDto> fetchPage(PageableRequestDto pageableRequestDto) {
        SortFieldValidator.UniversityField validSortFieldName = SortFieldValidator.UniversityField.validate(pageableRequestDto.getField());
        return switch (validSortFieldName) {
            case UNIVERSITY_ID, UNIVERSITY_NAME, ACCREDITATION -> fetchOnBasicField(pageableRequestDto, validSortFieldName.getValidHQLField());
            case FACULTIES -> fetchOnNumberOfFaculties(pageableRequestDto);
            case DEPARTMENTS -> fetchOnNumberOfDepartments(pageableRequestDto);
            case TEACHERS -> fetchOnNumberOfTeachers(pageableRequestDto);
            case STUDENTS -> fetchOnNumberOfStudents(pageableRequestDto);
        };
    }

    private PageableResponseDto<UniversityResponseDto> fetchOnBasicField(PageableRequestDto pageableRequestDto, String field) {
        Pageable pageable = PageRequest.of(pageableRequestDto.getPage() - 1, pageableRequestDto.getSize())
                .withSort(Sort.Direction.fromString(pageableRequestDto.getDir()), field);

        Page<Tuple> pageOfUniversities = universityPaginationRepository.fetchPage(pageable, field, pageableRequestDto.getDir());
        var listOfUniversityDTOs = pageOfUniversities.stream()
                .map(t -> convertTuple(t, UNIVERSITY_NAME))
                .toList();

        return new PageableResponseDto<>(
                pageOfUniversities.getTotalPages(),
                pageableRequestDto.getPage(),
                pageOfUniversities.getSize(),
                field,
                pageOfUniversities.getTotalElements(),
                listOfUniversityDTOs
        );

    }

    private PageableResponseDto<UniversityResponseDto> fetchOnNumberOfFaculties(PageableRequestDto pageableRequestDto) {
        Pageable pageable = PageRequest.of(pageableRequestDto.getPage() - 1, pageableRequestDto.getSize())
                .withSort(Sort.Direction.fromString(pageableRequestDto.getDir()), "faculties");

        Page<Tuple> pageOfUniversities = universityPaginationRepository.fetchPageOnFaculties(pageable);
        var listOfUniversityDTOs = pageOfUniversities.stream()
                .map(t -> convertTuple(t, FACULTIES))
                .toList();

        return new PageableResponseDto<>(
                pageOfUniversities.getTotalPages(),
                pageableRequestDto.getPage(),
                pageOfUniversities.getSize(),
                "faculties",
                pageOfUniversities.getTotalElements(),
                listOfUniversityDTOs
        );
    }

    private PageableResponseDto<UniversityResponseDto> fetchOnNumberOfDepartments(PageableRequestDto pageableRequestDto) {
        Pageable pageable = PageRequest.of(pageableRequestDto.getPage() - 1, pageableRequestDto.getSize())
                .withSort(Sort.Direction.fromString(pageableRequestDto.getDir()), "departments");

        Page<Tuple> pageOfUniversities = universityPaginationRepository.fetchPageOnDepartments(pageable);
        var listOfUniversityDTOs = pageOfUniversities.stream()
                .map(t -> convertTuple(t, DEPARTMENTS))
                .toList();

        return new PageableResponseDto<>(
                pageOfUniversities.getTotalPages(),
                pageableRequestDto.getPage(),
                pageOfUniversities.getSize(),
                "departments",
                pageOfUniversities.getTotalElements(),
                listOfUniversityDTOs
        );
    }

    private PageableResponseDto<UniversityResponseDto> fetchOnNumberOfTeachers(PageableRequestDto pageableRequestDto) {
        Pageable pageable = PageRequest.of(pageableRequestDto.getPage() - 1, pageableRequestDto.getSize())
                .withSort(Sort.Direction.fromString(pageableRequestDto.getDir()), "teachers");

        Page<Tuple> pageOfUniversities = universityPaginationRepository.fetchPageOnTeachers(pageable);
        var listOfUniversityDTOs = pageOfUniversities.stream()
                .map(t -> convertTuple(t, TEACHERS))
                .toList();

        return new PageableResponseDto<>(
                pageOfUniversities.getTotalPages(),
                pageableRequestDto.getPage(),
                pageOfUniversities.getSize(),
                "teachers",
                pageOfUniversities.getTotalElements(),
                listOfUniversityDTOs
        );
    }

    private PageableResponseDto<UniversityResponseDto> fetchOnNumberOfStudents(PageableRequestDto pageableRequestDto) {
        // TODO implement method
        return null;
    }

    private UniversityResponseDto convertTuple(Tuple tuple, SortFieldValidator.UniversityField sortField){
        UniversityResponseDto responseDto = UniversityResponseDto.builder().setUniversityId(tuple.get("universityId", Long.class))
                .setUniversityName(tuple.get("universityName", String.class))
                .setUniversityDescription(tuple.get("universityDescription", String.class))
                .build();

        switch (sortField){
            case FACULTIES -> responseDto.setNumberOfFaculties(tuple.get("facultyCount", Long.class));
            case DEPARTMENTS -> responseDto.setNumberOfDepartments(tuple.get("departmentCount", Long.class));
            case TEACHERS -> responseDto.setNumberOfTeachers(tuple.get("teacherCount", Long.class));
        }

        return responseDto;
    }

}
