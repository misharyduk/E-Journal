package com.ejournal.journal.control_journal.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class ControlMarkRequestDto {
    private Double mark;
    private Long studentId;
    private String controlType;
}
