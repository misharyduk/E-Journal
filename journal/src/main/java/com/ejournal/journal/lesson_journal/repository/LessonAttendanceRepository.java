package com.ejournal.journal.lesson_journal.repository;

import com.ejournal.journal.exercise_journal.entity.WorkStudent;
import com.ejournal.journal.lesson_journal.entity.LessonAttendance;

import java.util.Optional;

public interface LessonAttendanceRepository {

    boolean saveLessonAttendance(LessonAttendance lessonAttendance);

    Optional<LessonAttendance> fetchLessonAttendance(Long lessonAttendanceId);

    boolean deleteLessonAttendance(LessonAttendance lessonAttendance);
}
