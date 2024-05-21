package com.ejournal.analytics.feign_client.journal.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ControlJournalResponseDto {
    private Long id;
    private List<AcademicModuleResponseDto> academicModules;
    private List<ModuleStudentControlResponseDto> moduleStudentControls;
    private List<SemesterStudentGradeResponseDto> semesterStudentGrades;
}
