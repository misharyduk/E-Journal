package com.ejournal.journal.control_journal.dto;

import com.ejournal.journal.control_journal.entity.ModuleStudentControl;
import com.ejournal.journal.control_journal.entity.SemesterStudentGrade;
import com.ejournal.journal.journal.dto.AcademicModuleResponseDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data @Builder
public class ControlJournalResponseDto {
    private Long id;
    private List<AcademicModuleResponseDto> academicModules;
    private List<ModuleStudentControlResponseDto> moduleStudentControls;
    private List<SemesterStudentGradeResponseDto> semesterStudentGrades;
}
