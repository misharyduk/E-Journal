package com.ejournal.journal.lesson_journal.controller;

import com.ejournal.journal.exercise_journal.dto.PracticeJournalResponseDto;
import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkRequestDto;
import com.ejournal.journal.exercise_journal.service.PracticeJournalService;
import com.ejournal.journal.lesson_journal.dto.LessonJournalResponseDto;
import com.ejournal.journal.lesson_journal.dto.StudentAttendanceRequestDto;
import com.ejournal.journal.lesson_journal.service.LessonJournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lessonjournal")
@RequiredArgsConstructor
public class LessonJournalController {

    private final LessonJournalService lessonJournalService;

    @GetMapping("/{lessonJournalId}")
    public ResponseEntity<LessonJournalResponseDto> fetchJournal(@PathVariable("lessonJournalId") Long lessonJournalId){
        LessonJournalResponseDto lessonJournal = lessonJournalService.fetchById(lessonJournalId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lessonJournal);
    }

    @PostMapping("/{lessonJournalId}/attendances")
    public ResponseEntity<LessonJournalResponseDto> setAttendance(@PathVariable("lessonJournalId") Long lessonJournalId,
                                                                                                       StudentAttendanceRequestDto attendanceRequestDto){
        LessonJournalResponseDto lessonJournal = lessonJournalService.markStudentAttendance(lessonJournalId, attendanceRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lessonJournal);
    }

    @PutMapping("/{lessonJournalId}/attendances/{attendanceId}")
    public ResponseEntity<LessonJournalResponseDto> updateAttendanceValue(@PathVariable("lessonJournalId") Long lessonJournalId,
                                                                  @PathVariable("attendanceId") Long attendanceId,
                                                                  StudentAttendanceRequestDto attendanceRequestDto){
        LessonJournalResponseDto lessonJournal = lessonJournalService.updateStudentAttendance(lessonJournalId, attendanceId, attendanceRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lessonJournal);
    }

}
