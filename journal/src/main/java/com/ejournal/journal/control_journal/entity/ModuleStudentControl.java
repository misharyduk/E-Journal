package com.ejournal.journal.control_journal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "module_student_control")
@Getter @Setter @NoArgsConstructor
public class ModuleStudentControl {
    @Id
    @SequenceGenerator(name = "mod_stud_contr_id_sequence_generator", sequenceName = "mod_stud_contr_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mod_stud_contr_id_sequence_generator")
    @Column(name = "mod_stud_contr_id")
    private Long id;
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "module_id")
    private Long moduleId;
    @Column(name = "work_sum_grade")
    private Double workSumGrade; // sum of all exercise works of module
    @JoinColumn(name = "control_work_student_id")
    @OneToOne(cascade = CascadeType.PERSIST)
    private ControlWorkStudent controlWorkStudent; // mark for control work
    @Column(name = "final_grade")
    private Double finalGrade; // final grade of module

    public ModuleStudentControl(Long studentId, Long moduleId, Double workSumGrade, ControlWorkStudent controlWorkStudent, Double finalGrade) {
        this.studentId = studentId;
        this.moduleId = moduleId;
        this.workSumGrade = workSumGrade;
        this.controlWorkStudent = controlWorkStudent;
        this.finalGrade = finalGrade;
    }
}
