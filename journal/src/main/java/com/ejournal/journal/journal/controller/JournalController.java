package com.ejournal.journal.journal.controller;

import com.ejournal.journal.common.dto.PageableRequestDto;
import com.ejournal.journal.common.dto.PageableResponseDto;
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
    public ResponseEntity<JournalResponseDto> createJournal(@RequestBody JournalRequestDto journalRequestDto){

        JournalResponseDto journal = journalService.create(journalRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(journal);
    }

    @GetMapping
    public ResponseEntity<List<JournalResponseDto>> fetchAllJournals(){

        List<JournalResponseDto> journals = journalService.fetchAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(journals);
    }

//    @GetMapping("/{journalId}")
//    public ResponseEntity<JournalResponseDto> fetchJournal(@PathVariable("journalId") Long journalId){
//
//        JournalResponseDto responseDto = journalService.fetchById(journalId);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(responseDto);
//    }

    @GetMapping(params = {"page", "size", "field", "dir"})
    public ResponseEntity<PageableResponseDto<JournalResponseDto>> fetchJournalsPage(PageableRequestDto pageableRequestDto){

        PageableResponseDto<JournalResponseDto> journalPageDto = journalService.fetchPage(pageableRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(journalPageDto);
    }

    @GetMapping
    public ResponseEntity<JournalResponseDto> fetchJournalWithLessonsPage(
            @PathVariable("journalId") Long journalId,
            @RequestParam(required = false) PageableRequestDto pageableRequestDto){

        JournalResponseDto responseDto = journalService.fetchById(journalId, pageableRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @GetMapping(params = "subjectId")
    public ResponseEntity<List<JournalResponseDto>> fetchAllJournalsBySubject(@RequestParam("subjectId") Long subjectId){
        List<JournalResponseDto> journals = journalService.fetchAllBySubject(subjectId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(journals);
    }

    @GetMapping(params = "teacherId")
    public ResponseEntity<List<JournalResponseDto>> fetchAllJournalsByTeacher(@RequestParam("teacherId") Long teacherId){
        List<JournalResponseDto> journals = journalService.fetchAllByTeacher(teacherId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(journals);
    }

    @GetMapping(params = "groupId")
    public ResponseEntity<List<JournalResponseDto>> fetchAllJournalsByGroup(@RequestParam("groupId") Long groupId){
        List<JournalResponseDto> journals = journalService.fetchAllByGroup(groupId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(journals);
    }

}
