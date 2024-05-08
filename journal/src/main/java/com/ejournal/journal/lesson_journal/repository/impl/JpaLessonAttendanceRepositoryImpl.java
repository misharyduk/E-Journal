package com.ejournal.journal.lesson_journal.repository.impl;

import com.ejournal.journal.lesson_journal.entity.LessonAttendance;
import com.ejournal.journal.lesson_journal.repository.LessonAttendanceRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaLessonAttendanceRepositoryImpl extends JpaRepository<LessonAttendance, Long>, LessonAttendanceRepository {

    @Override
    default boolean saveLessonAttendance(LessonAttendance lessonAttendance){
        save(lessonAttendance);
        return true;
    }

    @Override
    default Optional<LessonAttendance> fetchLessonAttendance(Long lessonAttendanceId){
        return findById(lessonAttendanceId);
    }

    @Override
    default boolean deleteLessonAttendance(LessonAttendance lessonAttendance){
        delete(lessonAttendance);
        return true;
    }
}
