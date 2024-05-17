package com.ejournal.journal.journal.service.impl;

import com.ejournal.journal.common.exception.ResourceNotFoundException;
import com.ejournal.journal.journal.dto.AcademicModuleRequestDto;
import com.ejournal.journal.journal.dto.AcademicModuleResponseDto;
import com.ejournal.journal.journal.dto.ExerciseWorkResponseDto;
import com.ejournal.journal.journal.entity.Journal;
import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;
import com.ejournal.journal.journal.entity.academic_entities.ControlWork;
import com.ejournal.journal.journal.repository.AcademicModuleRepository;
import com.ejournal.journal.journal.repository.JournalRepository;
import com.ejournal.journal.journal.service.AcademicModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademicModuleServiceImpl implements AcademicModuleService {

    private final AcademicModuleRepository academicModuleRepository;
    private final JournalRepository journalRepository;

    @Override
    public List<AcademicModuleResponseDto> fetchAllByJournal(Long journalId) {
        return academicModuleRepository.fetchAllModulesByJournal(journalId)
                .stream()
                .map(this::fillAcademicModuleResponseDto)
                .toList();
    }

    @Override
    public AcademicModuleResponseDto fetchById(Long moduleId) {
        AcademicModule academicModule = academicModuleRepository.fetchModuleById(moduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Module", "id", String.valueOf(moduleId)));
        return fillAcademicModuleResponseDto(academicModule);
    }

    @Override
    public AcademicModule create(Long journalId, AcademicModuleRequestDto module) {
        AcademicModule academicModule = new AcademicModule();
        academicModule.setModuleNumber(module.getModuleNumber());
        academicModule.setModuleStartDate(module.getStartDate());
        academicModule.setModuleEndDate(module.getEndDate());

        ControlWork controlWork = new ControlWork();
        controlWork.setExecutionDate(module.getControlWorkExecutionDate());
        academicModule.setControlWork(controlWork);

        Journal journal = journalRepository.fetchInstanceById(journalId)
                .orElseThrow(() -> new ResourceNotFoundException("Journal", "id", String.valueOf(journalId)));
        academicModule.setJournal(journal);

        academicModuleRepository.createInstance(academicModule);

        return academicModule;
    }

    @Override
    public boolean delete(Long moduleId) {

        AcademicModule academicModule = academicModuleRepository.fetchModuleById(moduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Module", "id", String.valueOf(moduleId)));

        academicModuleRepository.deleteModule(academicModule);

        return true;
    }

    private AcademicModuleResponseDto fillAcademicModuleResponseDto(AcademicModule academicModule){
        AcademicModuleResponseDto responseDto = new AcademicModuleResponseDto(academicModule.getId(), academicModule.getModuleNumber(), academicModule.getModuleStartDate(), academicModule.getModuleEndDate());
        responseDto.setExerciseWorks(academicModule.getExerciseWorks().stream()
                .map(w -> new ExerciseWorkResponseDto(w.getId(), w.getWorkNumber(), w.getExerciseWorkType().toString().toLowerCase())).toList());
        return responseDto;
    }
}
