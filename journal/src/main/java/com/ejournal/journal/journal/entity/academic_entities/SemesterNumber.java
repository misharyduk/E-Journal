package com.ejournal.journal.journal.entity.academic_entities;

import lombok.Getter;

@Getter
public enum SemesterNumber {
    FIRST("перший"),
    SECOND("другий");

    private SemesterNumber(String value){
        this.value = value;
    }

    private final String value;
}
