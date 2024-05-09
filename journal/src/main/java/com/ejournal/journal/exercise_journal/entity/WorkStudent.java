package com.ejournal.journal.exercise_journal.entity;

import com.ejournal.journal.journal.entity.academic_entities.ExerciseWork;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity @Table(name = "work_student")
@Getter @Setter
public class WorkStudent {
    @Id
    @SequenceGenerator(name = "work_student_id_sequence_generator", sequenceName = "work_student_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_student_id_sequence_generator")
    @Column(name = "work_student_id")
    private Long id;
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "exec_date")
    private Date executionDate;
    @Column(name = "def_date")
    private Date defendDate;
    @Column(name = "mark")
    private Float mark;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "exer_work_id")
    private ExerciseWork exerciseWork;
}
