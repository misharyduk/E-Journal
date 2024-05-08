package com.ejournal.journal.exercise_journal.controller;

import com.ejournal.journal.common.dto.PageableRequestDto;
import com.ejournal.journal.common.dto.PageableResponseDto;
import com.ejournal.journal.exercise_journal.dto.PracticeJournalResponseDto;
import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkRequestDto;
import com.ejournal.journal.exercise_journal.service.PracticeJournalService;
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

    @PostMapping("/{practiceJournalId}/grades")
    public ResponseEntity<PracticeJournalResponseDto> setGrade(@PathVariable("practiceJournalId") Long practiceJournalId,
                                                               WorkStudentMarkRequestDto markRequestDto){
        PracticeJournalResponseDto practiceJournal = practiceJournalService.markStudentGrade(practiceJournalId, markRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(practiceJournal);
    }

    @PutMapping("/{practiceJournalId}/grades/{gradeId}")
    public ResponseEntity<PracticeJournalResponseDto> updateGrade(@PathVariable("practiceJournalId") Long practiceJournalId,
                                                                  @PathVariable("gradeId") Long gradeId,
                                                                  WorkStudentMarkRequestDto markRequestDto){
        PracticeJournalResponseDto practiceJournal = practiceJournalService.updateStudentGrade(practiceJournalId, gradeId, markRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(practiceJournal);
    }

}
