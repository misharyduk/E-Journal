package com.ejournal.journal.exercise_journal.controller;

import com.ejournal.journal.common.dto.PageableRequestDto;
import com.ejournal.journal.common.dto.PageableResponseDto;
import com.ejournal.journal.exercise_journal.dto.PracticeJournalResponseDto;
import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkRequestDto;
import com.ejournal.journal.exercise_journal.service.PracticeJournalService;
import com.ejournal.journal.journal.dto.ExerciseWorkRequestDto;
import com.ejournal.journal.journal.dto.ExerciseWorkResponseDto;
import com.ejournal.journal.journal.dto.JournalResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/workjournal")
@RequiredArgsConstructor
public class PracticeJournalController {

    private final PracticeJournalService practiceJournalService;

    @GetMapping("/{practiceJournalId}")
    public ResponseEntity<PracticeJournalResponseDto> fetchJournal(@PathVariable("practiceJournalId") Long practiceJournalId){
        PracticeJournalResponseDto practiceJournal = practiceJournalService.fetchById(practiceJournalId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(practiceJournal);
    }

    @PostMapping("/{practiceJournalId}/works")
    public ResponseEntity<PracticeJournalResponseDto> addExerciseWorkToJournal(@PathVariable("practiceJournalId") Long practiceJournalId,
                                                                               @RequestBody ExerciseWorkRequestDto exerciseWorkRequestDto){

        PracticeJournalResponseDto practiceJournal = practiceJournalService.createExerciseWork(practiceJournalId, exerciseWorkRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(practiceJournal);
    }

    @PostMapping("/{practiceJournalId}/grades")
    public ResponseEntity<PracticeJournalResponseDto> setGrade(@PathVariable("practiceJournalId") Long practiceJournalId,
                                                               @RequestBody WorkStudentMarkRequestDto markRequestDto){
        PracticeJournalResponseDto practiceJournal = practiceJournalService.markStudentGrade(practiceJournalId, markRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(practiceJournal);
    }

    @PutMapping("/{practiceJournalId}/grades/{gradeId}")
    public ResponseEntity<PracticeJournalResponseDto> updateGrade(@PathVariable("practiceJournalId") Long practiceJournalId,
                                                                  @PathVariable("gradeId") Long gradeId,
                                                                  @RequestBody WorkStudentMarkRequestDto markRequestDto){
        PracticeJournalResponseDto practiceJournal = practiceJournalService.updateStudentGrade(practiceJournalId, gradeId, markRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(practiceJournal);
    }

}
