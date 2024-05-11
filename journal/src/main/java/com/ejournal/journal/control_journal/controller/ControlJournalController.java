package com.ejournal.journal.control_journal.controller;

import com.ejournal.journal.control_journal.dto.ControlJournalResponseDto;
import com.ejournal.journal.control_journal.dto.ControlMarkRequestDto;
import com.ejournal.journal.control_journal.service.ControlJournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/controljournal")
@RequiredArgsConstructor
public class ControlJournalController {

    private final ControlJournalService controlJournalService;

    @GetMapping("/{controlJournalId}")
    public ResponseEntity<ControlJournalResponseDto> fetchJournal(@PathVariable("controlJournalId") Long controlJournalId){
        ControlJournalResponseDto controlJournal = controlJournalService.fetchById(controlJournalId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(controlJournal);
    }

    @PutMapping("/{controlJournalId}/modules/{moduleId}/grades")
    public ResponseEntity<ControlJournalResponseDto> updateWorkFinalGrade(@PathVariable("controlJournalId") Long controlJournalId,
                                                                           @PathVariable("moduleId") Long moduleId,
                                                                           @RequestBody ControlMarkRequestDto markRequestDto){
        ControlJournalResponseDto controlJournal = controlJournalService.updateControlJournalGrade(controlJournalId, moduleId, markRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(controlJournal);
    }

    @PutMapping("/{controlJournalId}/semester/grades")
    public ResponseEntity<ControlJournalResponseDto> updateSemesterGrade(@PathVariable("controlJournalId") Long controlJournalId,
                                                                          @RequestBody ControlMarkRequestDto markRequestDto){
        ControlJournalResponseDto controlJournal = controlJournalService.updateSemesterGrade(controlJournalId, markRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(controlJournal);
    }

}
