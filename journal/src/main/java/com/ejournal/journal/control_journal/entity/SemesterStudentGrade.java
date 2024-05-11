package com.ejournal.journal.control_journal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "semester_student_grade")
@Getter @Setter @NoArgsConstructor
public class SemesterStudentGrade {
    @Id
    @SequenceGenerator(name = "sem_stud_grade_id_sequence_generator", sequenceName = "sem_stud_grade_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sem_stud_grade_id_sequence_generator")
    @Column(name = "sem_stud_grade_id")
    private Long id;
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "mark")
    private Double grade;

    public SemesterStudentGrade(Long studentId, Double grade) {
        this.studentId = studentId;
        this.grade = grade;
    }
}
