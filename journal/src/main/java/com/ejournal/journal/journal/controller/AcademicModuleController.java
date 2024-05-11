package com.ejournal.journal.journal.controller;

import com.ejournal.journal.common.dto.ResponseDto;
import com.ejournal.journal.journal.dto.AcademicModuleRequestDto;
import com.ejournal.journal.journal.dto.AcademicModuleResponseDto;
import com.ejournal.journal.journal.dto.JournalRequestDto;
import com.ejournal.journal.journal.dto.JournalResponseDto;
import com.ejournal.journal.journal.service.AcademicModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ejournal.journal.common.util.ServiceConstants.INSTANCE_DELETED;
import static com.ejournal.journal.common.util.ServiceConstants.STATUS_CODE_200;

@RestController
@RequestMapping("/api/v1/modules")
@RequiredArgsConstructor
public class AcademicModuleController {

    private final AcademicModuleService academicModuleService;

    @GetMapping(params = "journalId")
    public ResponseEntity<List<AcademicModuleResponseDto>> fetchAllModulesByJournal(@RequestParam("journalId") Long journalId){

        List<AcademicModuleResponseDto> academicModules = academicModuleService.fetchAllByJournal(journalId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(academicModules);
    }

    @GetMapping("/{moduleId}")
    public ResponseEntity<AcademicModuleResponseDto> fetchModuleById(@PathVariable("moduleId") Long moduleId){

        AcademicModuleResponseDto academicModule = academicModuleService.fetchById(moduleId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(academicModule);
    }

    @DeleteMapping("/{moduleId}")
    public ResponseEntity<ResponseDto> deleteModule(@PathVariable("moduleId") Long moduleId){
        academicModuleService.delete(moduleId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_CODE_200, "Academic Module" + INSTANCE_DELETED));
    }

}
