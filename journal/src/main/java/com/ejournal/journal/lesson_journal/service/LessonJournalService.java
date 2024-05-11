package com.ejournal.journal.lesson_journal.service;

import com.ejournal.journal.exercise_journal.dto.PracticeJournalResponseDto;
import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkRequestDto;
import com.ejournal.journal.journal.entity.Journal;
import com.ejournal.journal.lesson_journal.dto.LessonJournalResponseDto;
import com.ejournal.journal.lesson_journal.dto.LessonRequestDto;
import com.ejournal.journal.lesson_journal.dto.LessonResponseDto;
import com.ejournal.journal.lesson_journal.dto.StudentAttendanceRequestDto;

public interface LessonJournalService {

    LessonJournalResponseDto fetchById(Long id);

    Journal enrichAndSaveLessonJournal(Journal journal, String lessonJournalType);

    LessonJournalResponseDto markStudentAttendance(Long lessonJournalId, StudentAttendanceRequestDto attendanceRequestDto);

    LessonJournalResponseDto updateStudentAttendance(Long lessonJournalId, Long attendanceId, StudentAttendanceRequestDto attendanceRequestDto);

    LessonJournalResponseDto createLesson(Long lessonJournalId, LessonRequestDto lessonRequestDto);
}
