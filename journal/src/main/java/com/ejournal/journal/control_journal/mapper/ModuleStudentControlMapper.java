package com.ejournal.journal.control_journal.mapper;

import com.ejournal.journal.control_journal.dto.ControlWorkStudentResponseDto;
import com.ejournal.journal.control_journal.dto.ModuleStudentControlResponseDto;
import com.ejournal.journal.control_journal.entity.ModuleStudentControl;

public class ModuleStudentControlMapper {
    public static ModuleStudentControlResponseDto mapToDto(ModuleStudentControl moduleStudentControl){
        return ModuleStudentControlResponseDto.builder()
                .id(moduleStudentControl.getId())
                .studentId(moduleStudentControl.getStudentId())
                .moduleId(moduleStudentControl.getModuleId())
                .workSumGrade(moduleStudentControl.getWorkSumGrade())
                .controlWorkStudent(new ControlWorkStudentResponseDto(
                        moduleStudentControl.getControlWorkStudent().getId(),
                        moduleStudentControl.getControlWorkStudent().getStudentId(),
                        moduleStudentControl.getControlWorkStudent().getMark()))
                .finalGrade(moduleStudentControl.getFinalGrade())
                .build();
    }
}
