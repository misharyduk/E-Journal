package com.ejournal.analytics.feign_client.journal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ControlWorkStudentResponseDto {
    private Long id;
    private Long studentId;
    private Double mark;
}
