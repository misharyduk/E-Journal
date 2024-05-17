package com.ejournal.journal.lesson_journal.service.impl;

import com.ejournal.journal.common.exception.ResourceNotFoundException;
import com.ejournal.journal.journal.entity.Journal;
import com.ejournal.journal.lesson_journal.dto.*;
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
    public Journal enrichAndSaveLessonJournal(Journal journal, String lessonJournalType) {
        LessonJournal lessonJournal = new LessonJournal();
        lessonJournalRepository.saveLessonJournal(lessonJournal);
        if(lessonJournalType.equals("LECTURE")){
            journal.setLectureLessonJournalId(lessonJournal.getId());
        } else {
            journal.setPracticeLessonJournalId(lessonJournal.getId());
        }
        return journal;
    }

    @Override
    public LessonJournalResponseDto createLesson(Long lessonJournalId, LessonRequestDto lessonRequestDto) {

        if(lessonJournalId == null || lessonJournalId <= 0)
            throw new RuntimeException("Journal id cannot be less than 1");

        LessonJournal lessonJournal = lessonJournalRepository.fetchLessonJournal(lessonJournalId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson journal", "id", String.valueOf(lessonJournalId)));

        Lesson lesson = LessonMapper.mapToEntity(lessonRequestDto, new Lesson());

        lessonJournal.getLessons().add(lesson);
        lesson.setLessonJournal(lessonJournal);

        lessonRepository.createInstance(lesson);
        lessonJournalRepository.saveLessonJournal(lessonJournal);

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
        String validAttendanceValue = switch (attendanceRequestDto.getAttendanceValue()) {
            case "not-present" -> "н";
            case "ill" -> "хв";
            case "not-attestation" -> "н/а";
            default -> attendanceRequestDto.getAttendanceValue();
        };

        lessonAttendance.setAttendanceValue(validAttendanceValue);
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
            String validAttendanceValue = switch (attendanceRequestDto.getAttendanceValue()) {
                case "not-present" -> "н";
                case "ill" -> "хв";
                case "not-attestation" -> "н/а";
                default -> null;
            };
            lessonAttendance.setAttendanceValue(validAttendanceValue);
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
