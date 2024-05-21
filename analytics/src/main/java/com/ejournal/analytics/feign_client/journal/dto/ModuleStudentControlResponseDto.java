package com.ejournal.analytics.feign_client.journal.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class ModuleStudentControlResponseDto {
    private Long id;
    private Long studentId;
    private Long moduleId;
    private Double workSumGrade; // sum of all exercise works of module
    private ControlWorkStudentResponseDto controlWorkStudent; // mark for control work
    private Double finalGrade; // final grade of module
}
