package com.ejournal.journal.exercise_journal.service.impl;

import com.ejournal.journal.common.exception.ResourceNotFoundException;
import com.ejournal.journal.exercise_journal.dto.PracticeJournalResponseDto;
import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkRequestDto;
import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkResponseDto;
import com.ejournal.journal.exercise_journal.entity.PracticeJournal;
import com.ejournal.journal.exercise_journal.entity.WorkStudent;
import com.ejournal.journal.exercise_journal.mapper.WorkStudentMapper;
import com.ejournal.journal.exercise_journal.repository.PracticeJournalRepository;
import com.ejournal.journal.exercise_journal.repository.WorkStudentRepository;
import com.ejournal.journal.exercise_journal.service.PracticeJournalService;
import com.ejournal.journal.journal.dto.AcademicModuleResponseDto;
import com.ejournal.journal.journal.dto.ControlWorkResponseDto;
import com.ejournal.journal.journal.dto.ExerciseWorkRequestDto;
import com.ejournal.journal.journal.dto.ExerciseWorkResponseDto;
import com.ejournal.journal.journal.entity.Journal;
import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWork;
import com.ejournal.journal.journal.mapper.AcademicModuleMapper;
import com.ejournal.journal.journal.mapper.ExerciseWorkMapper;
import com.ejournal.journal.journal.repository.AcademicModuleRepository;
import com.ejournal.journal.journal.repository.ExerciseWorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PracticeJournalServiceImpl implements PracticeJournalService {

    private final PracticeJournalRepository practiceJournalRepository;
    private final WorkStudentRepository workStudentRepository;
    private final ExerciseWorkRepository exerciseWorkRepository;
    private final AcademicModuleRepository academicModuleRepository;

    @Override
    public PracticeJournalResponseDto fetchById(Long id) {
        PracticeJournal practiceJournal = practiceJournalRepository.fetchPracticeJournal(id)
                .orElseThrow(() -> new ResourceNotFoundException("Practice journal", "id", String.valueOf(id)));

        List<AcademicModule> academicModules = academicModuleRepository.fetchAllModulesByExerciseJournal(id);

        return PracticeJournalResponseDto.builder()
                .id(practiceJournal.getId())
                .academicModules(academicModules.stream().map(AcademicModuleMapper::mapToDto).toList())
                .exerciseWorks(practiceJournal.getExerciseWorks().stream()
                        .map(this::mapExerciseToDto).toList())
                .build();
    }

    @Override
    public PracticeJournalResponseDto createExerciseWork(Long practiceJournalId, ExerciseWorkRequestDto exerciseWorkRequestDto) {
        PracticeJournal practiceJournal = practiceJournalRepository.fetchPracticeJournal(practiceJournalId)
                .orElseThrow(() -> new ResourceNotFoundException("Practice journal", "id", String.valueOf(practiceJournalId)));

        ExerciseWork exerciseWork = ExerciseWorkMapper.mapToEntity(exerciseWorkRequestDto, new ExerciseWork());

        AcademicModule academicModule = academicModuleRepository.fetchModuleById(exerciseWorkRequestDto.getModuleId())
                .orElseThrow(() -> new ResourceNotFoundException("Module", "id", String.valueOf(exerciseWorkRequestDto.getModuleId())));
        exerciseWork.setAcademicModule(academicModule);

        exerciseWork.setPracticeJournal(practiceJournal);
        practiceJournal.getExerciseWorks().add(exerciseWork);

//        academicModuleRepository.saveInstance(academicModule);
        exerciseWorkRepository.createInstance(exerciseWork);
        practiceJournalRepository.savePracticeJournal(practiceJournal);

        List<AcademicModule> academicModules = academicModuleRepository.fetchAllModulesByExerciseJournal(practiceJournalId);

        return PracticeJournalResponseDto.builder()
                .id(practiceJournal.getId())
                .academicModules(academicModules.stream().map(AcademicModuleMapper::mapToDto).toList())
                .exerciseWorks(practiceJournal.getExerciseWorks().stream()
                        .map(this::mapExerciseToDto).toList())
                .build();
    }

    @Override
    public Journal enrichAndSavePracticeJournal(Journal journal) {
        PracticeJournal practiceJournal = new PracticeJournal();
        practiceJournalRepository.savePracticeJournal(practiceJournal);
        journal.setExerciseWorkJournalId(practiceJournal.getId());
        return journal;
    }

    @Override
    public List<WorkStudentMarkResponseDto> fetchAllStudentsGrades() {
        List<WorkStudent> workStudents = workStudentRepository.fetchAllStudentsGrades();
        return workStudents.stream().map(WorkStudentMapper::mapMarkResponse).toList();
    }

    @Override
    public PracticeJournalResponseDto markStudentGrade(Long practiceJournalId, WorkStudentMarkRequestDto markRequestDto) {
        PracticeJournal practiceJournal = practiceJournalRepository.fetchPracticeJournal(practiceJournalId)
                .orElseThrow(() -> new ResourceNotFoundException("Practice journal", "id", String.valueOf(practiceJournalId)));

        List<AcademicModule> academicModules = academicModuleRepository.fetchAllModulesByExerciseJournal(practiceJournalId);

        ExerciseWork exerciseWork = exerciseWorkRepository.fetchExerciseWorkById(markRequestDto.getExerciseWorkId())
                .orElseThrow(() -> new ResourceNotFoundException("Exercise work", "id", String.valueOf(markRequestDto.getExerciseWorkId())));

        WorkStudent workStudent = WorkStudentMapper.mapMarkRequest(markRequestDto);
        exerciseWork.getWorkStudents().add(workStudent);
        workStudent.setExerciseWork(exerciseWork);
        workStudentRepository.saveWorkStudent(workStudent);

        practiceJournalRepository.savePracticeJournal(practiceJournal);
        return PracticeJournalResponseDto.builder()
                .id(practiceJournal.getId())
                .academicModules(academicModules.stream().map(AcademicModuleMapper::mapToDto).toList())
                .exerciseWorks(practiceJournal.getExerciseWorks().stream()
                        .map(this::mapExerciseToDto).toList())
                .build();
    }

    @Override
    public PracticeJournalResponseDto updateStudentGrade(Long practiceJournalId, Long gradeId, WorkStudentMarkRequestDto markRequestDto) {
        PracticeJournal practiceJournal = practiceJournalRepository.fetchPracticeJournal(practiceJournalId)
                .orElseThrow(() -> new ResourceNotFoundException("Practice journal", "id", String.valueOf(practiceJournalId)));

        List<AcademicModule> academicModules = academicModuleRepository.fetchAllModulesByExerciseJournal(practiceJournalId);

        WorkStudent workStudent = workStudentRepository.fetchWorkStudent(gradeId)
                .orElseThrow(() -> new ResourceNotFoundException("Work_Student", "id", String.valueOf(gradeId)));

        if(markRequestDto.getExecutionDate() != null)
            workStudent.setExecutionDate(markRequestDto.getExecutionDate());
        if(markRequestDto.getDefendDate() != null)
            workStudent.setDefendDate(markRequestDto.getDefendDate());
        workStudent.setMark(markRequestDto.getMark());

        workStudentRepository.saveWorkStudent(workStudent);
        practiceJournalRepository.savePracticeJournal(practiceJournal);

        return PracticeJournalResponseDto.builder()
                .id(practiceJournal.getId())
                .academicModules(academicModules.stream().map(AcademicModuleMapper::mapToDto).toList())
                .exerciseWorks(practiceJournal.getExerciseWorks().stream()
                        .map(this::mapExerciseToDto).toList())
                .build();
    }

    private ExerciseWorkResponseDto mapExerciseToDto(ExerciseWork exerciseWork){
        ExerciseWorkResponseDto responseDto = ExerciseWorkMapper.mapToDto(exerciseWork);
        responseDto.setAcademicModule(AcademicModuleMapper.mapToDto(exerciseWork.getAcademicModule()));
        responseDto.setWorkStudentMarks(exerciseWork.getWorkStudents().stream().map(WorkStudentMapper::mapMarkResponse).toList());
        return responseDto;
    }
}
