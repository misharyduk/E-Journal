package com.ejournal.journal.exercise_journal.controller;

import com.ejournal.journal.common.dto.PageableRequestDto;
import com.ejournal.journal.exercise_journal.dto.PracticeJournalResponseDto;
import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkRequestDto;
import com.ejournal.journal.exercise_journal.service.PracticeJournalService;
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
    public ResponseEntity<PracticeJournalResponseDto> fetchJournal(@PathVariable("practiceJournalId") Long practiceJournalId,
                                                                   @RequestParam(required = false) PageableRequestDto worksPageableRequestDto){
        PracticeJournalResponseDto practiceJournal = practiceJournalService.fetchById(practiceJournalId, worksPageableRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(practiceJournal);
    }

    @PostMapping("/{practiceJournalId}/grade")
    public ResponseEntity<PracticeJournalResponseDto> setGrade(@PathVariable("practiceJournalId") Long practiceJournalId,
                                                               WorkStudentMarkRequestDto markRequestDto,
                                                               @RequestParam(required = false) PageableRequestDto currentPageableRequestDto){
        PracticeJournalResponseDto practiceJournal = practiceJournalService.markStudentGrade(practiceJournalId, markRequestDto, currentPageableRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(practiceJournal);
    }

    @PutMapping("/{practiceJournalId}/grade/{gradeId}")
    public ResponseEntity<PracticeJournalResponseDto> updateGrade(@PathVariable("practiceJournalId") Long practiceJournalId,
                                                                  @PathVariable("gradeId") Long gradeId,
                                                                  @RequestParam(required = false) PageableRequestDto currentPageableRequestDto){
        PracticeJournalResponseDto practiceJournal = practiceJournalService.updateStudentGrade(practiceJournalId, gradeId, currentPageableRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(practiceJournal);
    }

    @DeleteMapping("/{practiceJournalId}/grade/{gradeId}")
    public ResponseEntity<PracticeJournalResponseDto> deleteGrade(@PathVariable("practiceJournalId") Long practiceJournalId,
                                                                  @PathVariable("gradeId") Long gradeId,
                                                                  @RequestParam(required = false) PageableRequestDto currentPageableRequestDto){
        PracticeJournalResponseDto practiceJournal = practiceJournalService.deleteStudentGrade(practiceJournalId, gradeId, currentPageableRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(practiceJournal);
    }

}
