package com.ejournal.journal.journal.entity.academic_entities;

import com.ejournal.journal.control_journal.entity.ControlJournal;
import com.ejournal.journal.control_journal.entity.ModuleStudentControl;
import com.ejournal.journal.journal.entity.Journal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "academic_module")
@Getter @Setter
public class AcademicModule {
    @Id
    @SequenceGenerator(name = "acad_module_id_sequence_generator", sequenceName = "acad_module_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acad_module_id_sequence_generator")
    @Column(name = "acad_module_id")
    private Long id;
    @Column(name = "module_number")
    private Integer moduleNumber;
    @JoinColumn(name = "journal_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Journal journal;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "academicModule")
    private List<ExerciseWork> exerciseWorks = new ArrayList<>();
    @JoinColumn(name = "control_work_id")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private ControlWork controlWork;
}
