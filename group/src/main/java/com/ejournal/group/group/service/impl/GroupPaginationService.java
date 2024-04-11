package com.ejournal.group.group.service.impl;

import com.ejournal.group.common.dto.PageableRequestDto;
import com.ejournal.group.common.dto.PageableResponseDto;
import com.ejournal.group.common.util.SortFieldValidator;
import com.ejournal.group.group.dto.GroupResponseDto;
import com.ejournal.group.group.repository.GroupPaginationRepository;
import com.ejournal.group.student.dto.StudentResponseDto;
import com.ejournal.group.student.repository.StudentPaginationRepository;
import com.ejournal.group.student.service.StudentService;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static com.ejournal.group.common.util.SortFieldValidator.GroupField.*;
import static com.ejournal.group.common.util.SortFieldValidator.*;

@Service
@RequiredArgsConstructor
public class GroupPaginationService {

    private final GroupPaginationRepository groupPaginationRepository;
    private final StudentService studentService;

    public PageableResponseDto<GroupResponseDto> fetchPage(PageableRequestDto pageableRequestDto) {
        GroupField validSortFieldName = GroupField.validate(pageableRequestDto.getField());
        return switch (validSortFieldName) {
            case GROUP_ID, GROUP_NUMBER, STUDENTS -> fetchOnBasicField(pageableRequestDto, validSortFieldName.getValidHQLField());
//            case STUDENTS -> fetchOnNumberOfStudent(pageableRequestDto);
        };
    }

    private PageableResponseDto<GroupResponseDto> fetchOnBasicField(PageableRequestDto pageableRequestDto, String field) {

        Pageable pageable = PageRequest.of(pageableRequestDto.getPage() - 1, pageableRequestDto.getSize())
                .withSort(Sort.Direction.fromString(pageableRequestDto.getDir()), field);

        Page<Tuple> pageOfGroups = groupPaginationRepository.fetchPage(pageable, field, pageableRequestDto.getDir());
        var listOfGroupDTOs = pageOfGroups.stream()
                .map(this::convertTuple)
                .toList();

        return new PageableResponseDto<>(
                pageOfGroups.getTotalPages(),
                pageableRequestDto.getPage(),
                pageOfGroups.getSize(),
                field,
                pageOfGroups.getTotalElements(),
                listOfGroupDTOs
        );
    }

    private GroupResponseDto convertTuple(Tuple tuple){
        GroupResponseDto responseDto = GroupResponseDto.builder().setGroupId(tuple.get("groupId", Long.class))
                .setGroupNumber(tuple.get("groupNumber", Integer.class))
                .build();

        responseDto.setNumberOfStudents(tuple.get("studentsCount", Long.class));

        return responseDto;
    }

}
