package com.ejournal.journal.common.feign_client.group.dto;

import com.ejournal.journal.common.feign_client.university.dto.DepartmentResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GroupResponseDto {

    private Long id;
    private Integer groupNumber;
    private Long numberOfStudents;
    private DepartmentResponseDto department;

}
