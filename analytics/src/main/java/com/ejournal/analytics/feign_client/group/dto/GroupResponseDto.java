package com.ejournal.analytics.feign_client.group.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data @Builder
@JsonIgnoreProperties
public class GroupResponseDto {

    private Long id;
    private Integer groupNumber;
    private List<StudentResponseDto> students;
    private Long numberOfStudents;

}
