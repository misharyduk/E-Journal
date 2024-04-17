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
        return journal;
    }

    public static JournalResponseDto mapToDto(Journal journal){
        JournalResponseDto responseDto = new JournalResponseDto();
        responseDto.setId(journal.getId());
        responseDto.setSemesterNumber(journal.getSemesterNumber().getValue());
        responseDto.setAcademicModules(journal.getAcademicModules().stream()
                .map(m -> new AcademicModuleResponseDto(m.getId(), m.getModuleNumber())).toList());
        return responseDto;
    }
}
