package com.ejournal.journal.control_journal.service.impl;

import com.ejournal.journal.common.exception.ResourceNotFoundException;
import com.ejournal.journal.control_journal.dto.ControlJournalResponseDto;
import com.ejournal.journal.control_journal.dto.ControlMarkRequestDto;
import com.ejournal.journal.control_journal.dto.SemesterStudentGradeResponseDto;
import com.ejournal.journal.control_journal.entity.ControlJournal;
import com.ejournal.journal.control_journal.entity.ControlWorkStudent;
import com.ejournal.journal.control_journal.entity.ModuleStudentControl;
import com.ejournal.journal.control_journal.mapper.ModuleStudentControlMapper;
import com.ejournal.journal.control_journal.repository.ControlJournalRepository;
import com.ejournal.journal.control_journal.repository.ModuleStudentControlRepository;
import com.ejournal.journal.control_journal.service.ControlJournalService;
import com.ejournal.journal.journal.dto.AcademicModuleResponseDto;
import com.ejournal.journal.journal.dto.ControlWorkResponseDto;
import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;
import com.ejournal.journal.journal.mapper.AcademicModuleMapper;
import com.ejournal.journal.journal.repository.AcademicModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ControlJournalServiceImpl implements ControlJournalService {

    private final ControlJournalRepository controlJournalRepository;
    private final AcademicModuleRepository academicModuleRepository;

    @Override
    public ControlJournalResponseDto fetchById(Long controlJournalId) {
        ControlJournal controlJournal = controlJournalRepository.fetchControlJournal(controlJournalId)
                .orElseThrow(() -> new ResourceNotFoundException("Control journal", "id", String.valueOf(controlJournalId)));

        List<AcademicModule> academicModules = academicModuleRepository.fetchAllModulesByControlJournal(controlJournalId);

        return mapControlJournalToResponseDto(controlJournal, academicModules);
    }



    @Override
    public ControlJournalResponseDto updateControlJournalGrade(Long controlJournalId, Long moduleId, ControlMarkRequestDto markRequestDto) {
        ControlJournal controlJournal = controlJournalRepository.fetchControlJournal(controlJournalId)
                .orElseThrow(() -> new ResourceNotFoundException("Control journal", "id", String.valueOf(controlJournalId)));

        ModuleStudentControl moduleStudentControl = controlJournal.getModuleStudentControls().stream()
                .filter(c -> (c.getModuleId().equals(moduleId) && c.getStudentId().equals(markRequestDto.getStudentId())))
                .findFirst()
                .get();

        switch (markRequestDto.getControlType()){
            case "work-final-grade":
                moduleStudentControl.setWorkSumGrade(markRequestDto.getMark());
                break;
            case "control-grade":
                if(moduleStudentControl.getControlWorkStudent() != null)
                    moduleStudentControl.getControlWorkStudent().setMark(markRequestDto.getMark());
                else {
                    ControlWorkStudent controlWorkStudent = new ControlWorkStudent();
                    controlWorkStudent.setStudentId(markRequestDto.getStudentId());
                    controlWorkStudent.setMark(markRequestDto.getMark());
                    moduleStudentControl.setControlWorkStudent(controlWorkStudent);
                }
                break;
            case "module-final-grade":
                moduleStudentControl.setFinalGrade(markRequestDto.getMark());
                break;
        }

        controlJournalRepository.saveControlJournal(controlJournal);

        List<AcademicModule> academicModules = academicModuleRepository.fetchAllModulesByControlJournal(controlJournalId);

        return mapControlJournalToResponseDto(controlJournal, academicModules);
    }

    private ControlJournalResponseDto mapControlJournalToResponseDto(ControlJournal controlJournal, List<AcademicModule> academicModules) {
        return ControlJournalResponseDto.builder()
                .id(controlJournal.getId())
                .academicModules(academicModules.stream().map(this::mapAcademicModuleToDto).toList())
                .moduleStudentControls(controlJournal.getModuleStudentControls().stream().map(ModuleStudentControlMapper::mapToDto).toList())
                .semesterStudentGrade(new SemesterStudentGradeResponseDto(
                        controlJournal.getSemesterStudentGrade().getId(),
                        controlJournal.getSemesterStudentGrade().getStudentId(),
                        controlJournal.getSemesterStudentGrade().getGrade()
                ))
                .build();
    }

    private AcademicModuleResponseDto mapAcademicModuleToDto(AcademicModule academicModule){
        AcademicModuleResponseDto responseDto = AcademicModuleMapper.mapToDto(academicModule);
        responseDto.setControlWork(new ControlWorkResponseDto(academicModule.getControlWork().getId(), academicModule.getControlWork().getExecutionDate()));
        return responseDto;
    }
}
