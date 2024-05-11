package com.ejournal.journal.journal.controller;

import com.ejournal.journal.common.dto.ResponseDto;
import com.ejournal.journal.journal.dto.AcademicModuleRequestDto;
import com.ejournal.journal.journal.dto.AcademicModuleResponseDto;
import com.ejournal.journal.journal.dto.ExerciseWorkRequestDto;
import com.ejournal.journal.journal.dto.ExerciseWorkResponseDto;
import com.ejournal.journal.journal.service.ExerciseWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ejournal.journal.common.util.ServiceConstants.INSTANCE_DELETED;
import static com.ejournal.journal.common.util.ServiceConstants.STATUS_CODE_200;

@RestController
@RequestMapping("/api/v1/works")
@RequiredArgsConstructor
public class ExerciseWorkController {

    private final ExerciseWorkService exerciseWorkService;

    @GetMapping(params = "journalId")
    public ResponseEntity<List<ExerciseWorkResponseDto>> fetchAllExerciseWorksByJournal(@RequestParam("journalId") Long journalId){

        List<ExerciseWorkResponseDto> exerciseWorks = exerciseWorkService.fetchAllByJournal(journalId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(exerciseWorks);
    }

    @GetMapping("/{exerciseWorkId}")
    public ResponseEntity<ExerciseWorkResponseDto> fetchExerciseWorkById(@PathVariable("exerciseWorkId") Long exerciseWorkId){

        ExerciseWorkResponseDto ResponseDto = exerciseWorkService.fetchById(exerciseWorkId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto);
    }

    @DeleteMapping("/{exerciseWorkId}")
    public ResponseEntity<ResponseDto> deleteExerciseWork(@PathVariable("exerciseWorkId") Long exerciseWorkId){
        boolean isWorkDeleted = exerciseWorkService.delete(exerciseWorkId);
        if(isWorkDeleted)
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_CODE_200, "Exercise Work" + INSTANCE_DELETED));
        else
            throw new RuntimeException("Cannot delete work with id " + exerciseWorkId);
    }

}
