package com.ejournal.journal.control_journal.entity;

import com.ejournal.journal.journal.entity.academic_entities.ControlWork;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWork;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "control_work_student")
@Getter @Setter @NoArgsConstructor
public class ControlWorkStudent {
    @Id
    @SequenceGenerator(name = "cont_work_student_id_sequence_generator", sequenceName = "cont_work_student_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cont_work_student_id_sequence_generator")
    @Column(name = "cont_work_student_id")
    private Long id;
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "mark")
    private Double mark;

    public ControlWorkStudent(Double mark, Long studentId) {
        this.mark = mark;
        this.studentId = studentId;
    }
}
