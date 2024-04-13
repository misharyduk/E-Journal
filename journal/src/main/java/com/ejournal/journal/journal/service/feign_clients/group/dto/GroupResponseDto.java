package com.ejournal.journal.journal.service.feign_clients.group.dto;

import com.ejournal.journal.journal.service.feign_clients.university.dto.DepartmentResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GroupResponseDto {

    private Long id;
    private Integer groupNumber;
    private Long numberOfStudents;
    private DepartmentResponseDto department;

}
