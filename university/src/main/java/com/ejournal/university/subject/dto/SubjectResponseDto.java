package com.ejournal.university.subject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectResponseDto {

    private String subjectName;

}
