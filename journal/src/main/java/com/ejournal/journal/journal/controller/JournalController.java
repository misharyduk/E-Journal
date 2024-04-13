package com.ejournal.journal.journal.controller;

import com.ejournal.journal.journal.dto.JournalRequestDto;
import com.ejournal.journal.journal.dto.JournalResponseDto;
import com.ejournal.journal.journal.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/journals")
@RequiredArgsConstructor
public class JournalController {

    private final JournalService journalService;

    @PostMapping
    public ResponseEntity<Long> createJournal(@RequestBody JournalRequestDto journalRequestDto){

        Long responseDto = journalService.create(journalRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<JournalResponseDto>> fetchAllJournals(){

        List<JournalResponseDto> journals = journalService.fetchAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(journals);
    }

    @GetMapping("/{journalId}")
    public ResponseEntity<JournalResponseDto> fetchJournal(@PathVariable("journalId") Long journalId){

        JournalResponseDto responseDto = journalService.fetchById(journalId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

}
