package com.ejournal.journal.control_journal.entity;

import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWork;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "control_journal")
@Getter @Setter
public class ControlJournal {
    @Id
    @SequenceGenerator(name = "control_journal_id_sequence_generator", sequenceName = "control_journal_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "control_journal_id_sequence_generator")
    @Column(name = "control_journal_id")
    private Long id;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ModuleStudentControl>moduleStudentControls = new ArrayList<>();
    @OneToOne(cascade = CascadeType.PERSIST)
    private SemesterStudentGrade semesterStudentGrade;
}
