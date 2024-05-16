package com.ejournal.journal.journal.mapper;

import com.ejournal.journal.journal.dto.*;
import com.ejournal.journal.journal.entity.Journal;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWork;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWorkType;
import com.ejournal.journal.journal.entity.academic_entities.SemesterNumber;

public class JournalMapper {

    public static Journal mapToEntity(JournalRequestDto requestDto, Journal journal){
        journal.setGroupId(requestDto.getGroupId());
        journal.setSubjectId(requestDto.getSubjectId());
        journal.setLectureTeacherId(requestDto.getLectureTeacherId());
        journal.setPracticalTeacherId(requestDto.getPracticalTeacherId());
        journal.setSemesterNumber(SemesterNumber.valueOf(requestDto.getSemesterNumber().toUpperCase()));
        journal.setFirstAcademicYear(requestDto.getFirstAcademicYear());
        journal.setSecondAcademicYear(requestDto.getSecondAcademicYear());
        return journal;
    }

    public static JournalResponseDto mapToDto(Journal journal){
        JournalResponseDto responseDto = new JournalResponseDto();
        responseDto.setId(journal.getId());
        responseDto.setSemesterNumber(journal.getSemesterNumber().getValue());
        responseDto.setFirstAcademicYear(journal.getFirstAcademicYear());
        responseDto.setSecondAcademicYear(journal.getSecondAcademicYear());
        responseDto.setAcademicModules(journal.getAcademicModules().stream()
                .map(m -> new AcademicModuleResponseDto(m.getId(), m.getModuleNumber(), m.getModuleStartDate(), m.getModuleEndDate())).toList());
        responseDto.setLectureLessonsJournalId(journal.getLectureLessonJournalId());
        responseDto.setPracticeLessonsJournalId(journal.getPracticeLessonJournalId());
        responseDto.setExerciseJournalId(journal.getExerciseWorkJournalId());
        responseDto.setControlJournalId(journal.getControlJournalId());
        return responseDto;
    }
}
