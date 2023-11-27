package com.ejournal.university.subject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class SubjectResponseDto {

    private Long subjectId;
    private String subjectName;

}
