package com.ejournal.journal.exercise_journal.mapper;

import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkRequestDto;
import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkResponseDto;
import com.ejournal.journal.exercise_journal.entity.WorkStudent;

public class WorkStudentMapper {
    public static WorkStudentMarkResponseDto mapMarkResponse(WorkStudent workStudent){
        return WorkStudentMarkResponseDto.builder()
                .id(workStudent.getId())
                .studentId(workStudent.getStudentId())
                .executionDate(workStudent.getExecutionDate())
                .defendDate(workStudent.getDefendDate())
                .mark(workStudent.getMark())
                .build();
    }

    public static WorkStudent mapMarkRequest(WorkStudentMarkRequestDto workStudentMarkRequestDto){
        WorkStudent workStudent = new WorkStudent();
        workStudent.setStudentId(workStudentMarkRequestDto.getStudentId());
        workStudent.setExecutionDate(workStudentMarkRequestDto.getExecutionDate());
        workStudent.setDefendDate(workStudentMarkRequestDto.getDefendDate());
        workStudent.setMark(workStudentMarkRequestDto.getMark());
        return workStudent;
    }
}
