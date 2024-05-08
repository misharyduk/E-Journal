package com.ejournal.journal.lesson_journal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class LessonAttendance {
    @Id
    @SequenceGenerator(name = "lesson_attend_id_sequence_generator", sequenceName = "lesson_attend_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_attend_id_sequence_generator")
    @Column(name = "lesson_attend_id")
    private Long id;
    @Column(name = "attendance_val")
    private String attendanceValue;
    @Column(name = "student_id")
    private Long studentId;
    @JoinColumn(name = "lesson_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Lesson lesson;
}
