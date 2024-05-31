package com.ejournal.journal.lesson_journal.service;

import com.ejournal.journal.lesson_journal.dto.LessonAttendanceResponseDto;

import java.util.List;

public interface AttendanceService {

    List<LessonAttendanceResponseDto> fetchAllLessonAttendances();

}
