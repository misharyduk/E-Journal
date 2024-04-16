package com.ejournal.journal.journal.entity.academic_entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ExerciseWork {
    @Id
    @SequenceGenerator(name = "exer_work_id_sequence_generator", sequenceName = "exer_work_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exer_work_id_sequence_generator")
    @Column(name = "exer_work_id")
    private Long id;
    @Column(name = "work_number")
    private Integer workNumber;
    @Column(name = "exercise_work_type")
    @Enumerated(EnumType.STRING)
    private ExerciseWorkType exerciseWorkType;
    @JoinColumn(name = "academic_module_id")
    @ManyToOne
    private AcademicModule academicModule;
}
