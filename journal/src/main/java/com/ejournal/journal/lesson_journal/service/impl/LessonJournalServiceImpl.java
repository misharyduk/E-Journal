package com.ejournal.journal.lesson_journal.service.impl;

import com.ejournal.journal.common.exception.ResourceNotFoundException;
import com.ejournal.journal.exercise_journal.dto.PracticeJournalResponseDto;
import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkRequestDto;
import com.ejournal.journal.exercise_journal.entity.PracticeJournal;
import com.ejournal.journal.exercise_journal.entity.WorkStudent;
import com.ejournal.journal.exercise_journal.mapper.WorkStudentMapper;
import com.ejournal.journal.exercise_journal.repository.PracticeJournalRepository;
import com.ejournal.journal.exercise_journal.repository.WorkStudentRepository;
import com.ejournal.journal.exercise_journal.service.PracticeJournalService;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWork;
import com.ejournal.journal.lesson_journal.dto.LessonAttendanceResponseDto;
import com.ejournal.journal.lesson_journal.dto.LessonJournalResponseDto;
import com.ejournal.journal.lesson_journal.dto.LessonResponseDto;
import com.ejournal.journal.lesson_journal.dto.StudentAttendanceRequestDto;
import com.ejournal.journal.lesson_journal.entity.Lesson;
import com.ejournal.journal.lesson_journal.entity.LessonAttendance;
import com.ejournal.journal.lesson_journal.entity.LessonJournal;
import com.ejournal.journal.lesson_journal.mapper.LessonMapper;
import com.ejournal.journal.lesson_journal.repository.LessonAttendanceRepository;
import com.ejournal.journal.lesson_journal.repository.LessonJournalRepository;
import com.ejournal.journal.lesson_journal.repository.LessonRepository;
import com.ejournal.journal.lesson_journal.service.LessonJournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonJournalServiceImpl implements LessonJournalService {

    private final LessonJournalRepository lessonJournalRepository;
    private final LessonRepository lessonRepository;
    private final LessonAttendanceRepository lessonAttendanceRepository;


    @Override
    public LessonJournalResponseDto fetchById(Long lessonJournalId) {
        LessonJournal lessonJournal = lessonJournalRepository.fetchLessonJournal(lessonJournalId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson journal", "id", String.valueOf(lessonJournalId)));
        return LessonJournalResponseDto.builder()
                .id(lessonJournal.getId())
                .lessons(lessonJournal.getLessons().stream()
                        .map(this::mapLessonDto)
                        .toList())
                .build();
    }

    @Override
    public LessonJournalResponseDto markStudentAttendance(Long lessonJournalId, StudentAttendanceRequestDto attendanceRequestDto) {
        LessonJournal lessonJournal = lessonJournalRepository.fetchLessonJournal(lessonJournalId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson journal", "id", String.valueOf(lessonJournalId)));

        Lesson lesson = lessonRepository.fetchInstanceById(attendanceRequestDto.getLessonId())
                .orElseThrow(() -> new ResourceNotFoundException("Lesson", "id", String.valueOf(attendanceRequestDto.getLessonId())));

        LessonAttendance lessonAttendance = new LessonAttendance();
        lessonAttendance.setAttendanceValue(attendanceRequestDto.getAttendanceValue());
        lessonAttendance.setStudentId(attendanceRequestDto.getStudentId());
        lessonAttendance.setLesson(lesson);

        lessonAttendanceRepository.saveLessonAttendance(lessonAttendance);
        lesson.getLessonAttendances().add(lessonAttendance);

        lessonJournalRepository.saveLessonJournal(lessonJournal);
        return LessonJournalResponseDto.builder()
                .id(lessonJournal.getId())
                .lessons(lessonJournal.getLessons().stream()
                        .map(this::mapLessonDto)
                        .toList())
                .build();
    }

    @Override
    public LessonJournalResponseDto updateStudentAttendance(Long lessonJournalId, Long attendanceId, StudentAttendanceRequestDto attendanceRequestDto) {

        LessonAttendance lessonAttendance = lessonAttendanceRepository.fetchLessonAttendance(attendanceId)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance", "id", String.valueOf(attendanceId)));

        if(attendanceRequestDto.getAttendanceValue() != null && !attendanceRequestDto.getAttendanceValue().isBlank()){
            lessonAttendance.setAttendanceValue(attendanceRequestDto.getAttendanceValue());
            lessonAttendanceRepository.saveLessonAttendance(lessonAttendance);
        } else {
            Lesson lesson = lessonAttendance.getLesson();
            lesson.getLessonAttendances().removeIf(la -> la.getId().equals(attendanceId));
            lessonRepository.updateInstance(lesson);
            lessonAttendanceRepository.deleteLessonAttendance(lessonAttendance);
        }

        LessonJournal lessonJournal = lessonJournalRepository.fetchLessonJournal(lessonJournalId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson journal", "id", String.valueOf(lessonJournalId)));

        return LessonJournalResponseDto.builder()
                .id(lessonJournal.getId())
                .lessons(lessonJournal.getLessons().stream()
                        .map(this::mapLessonDto)
                        .toList())
                .build();
    }

    private LessonResponseDto mapLessonDto(Lesson lesson){
        LessonResponseDto responseDto = LessonMapper.mapToDto(lesson, new LessonResponseDto());
        responseDto.setLessonAttendances(lesson.getLessonAttendances().stream()
                .map(la -> new LessonAttendanceResponseDto(la.getId(), la.getStudentId(), lesson.getId(), la.getAttendanceValue())).toList());
        return responseDto;
    }
}
