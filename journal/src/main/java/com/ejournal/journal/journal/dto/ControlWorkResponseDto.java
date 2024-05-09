package com.ejournal.journal.journal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class ControlWorkResponseDto {
    private Long id;
    private Date executionDate;
}
