package com.ejournal.journal.lesson_journal.entity;

import lombok.Getter;

@Getter
public enum LessonRepeat {
    ONCE("once"),
    ONCE_A_WEEK_PER_MONTH("once-a-week-per-month"),
    ONCE_A_WEEK_PER_SEMESTER("once-a-week-per-semester"),
    ONCE_AN_EVEN_WEEK_PER_MONTH("once-an-even-week-per-month"),
    ONCE_AN_ODD_WEEK_PER_MONTH("once-an-odd-week-per-month"),
    ONCE_AN_EVEN_WEEK_PER_SEMESTER("once-an-even-week-per-semester"),
    ONCE_AN_ODD_WEEK_PER_SEMESTER("once-an-odd-week-per-semester");

    private final String value;

    LessonRepeat(String value) {
        this.value = value;
    }
}
