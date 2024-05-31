package com.ejournal.group.student.service.impl;

import com.ejournal.group.common.dto.PageableRequestDto;
import com.ejournal.group.common.dto.PageableResponseDto;
import com.ejournal.group.common.util.SortFieldValidator;
import com.ejournal.group.group.dto.GroupResponseDto;
import com.ejournal.group.student.dto.StudentResponseDto;
import com.ejournal.group.student.repository.StudentPaginationRepository;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static com.ejournal.group.common.util.SortFieldValidator.*;
import static com.ejournal.group.common.util.SortFieldValidator.StudentField.*;

@Service
@RequiredArgsConstructor
public class StudentPaginationService {

    private final StudentPaginationRepository studentPaginationRepository;

    public PageableResponseDto<StudentResponseDto> fetchPage(PageableRequestDto pageableRequestDto) {
        StudentField validSortFieldName = StudentField.validate(pageableRequestDto.getField());
        return switch (validSortFieldName) {
            case STUDENT_ID, FIRST_NAME, LAST_NAME -> fetchOnBasicField(pageableRequestDto, validSortFieldName.getValidHQLField());
//            case MARKS -> fetchOnMarks(pageableRequestDto);
        };
    }

    private PageableResponseDto<StudentResponseDto> fetchOnBasicField(PageableRequestDto pageableRequestDto, String field) {

        Pageable pageable = PageRequest.of(pageableRequestDto.getPage() - 1, pageableRequestDto.getSize())
                .withSort(Sort.Direction.fromString(pageableRequestDto.getDir()), field);

        Page<Tuple> pageOfStudents = studentPaginationRepository.fetchPage(pageable, field, pageableRequestDto.getDir());
        var listOfStudentDTOs = pageOfStudents.stream()
                .map(t -> convertTuple(t, STUDENT_ID))
                .toList();

        return new PageableResponseDto<>(
                pageOfStudents.getTotalPages(),
                pageableRequestDto.getPage(),
                pageOfStudents.getSize(),
                field,
                pageOfStudents.getTotalElements(),
                listOfStudentDTOs
        );
    }

    private StudentResponseDto convertTuple(Tuple tuple, StudentField sortField){
        StudentResponseDto responseDto = StudentResponseDto.builder().setStudentId(tuple.get("studentId", Long.class))
                .setFirstName(tuple.get("firstName", String.class))
                .setLastName(tuple.get("lastName", String.class))
                .setMiddleName(tuple.get("middleName", String.class))
                .setEmail(tuple.get("email", String.class))
                .setMobilePhone(tuple.get("mobilePhone", String.class))
                .setGroup(GroupResponseDto.builder().setGroupId(tuple.get("groupId", Long.class)).build())
                .build();

        /* switch (sortField){
            case MARKS -> responseDto.setNumberOfMarks(tuple.get("marksCount", Long.class));
          } */

        return responseDto;
    }

}
