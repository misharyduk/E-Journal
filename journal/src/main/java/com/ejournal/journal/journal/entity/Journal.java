package com.ejournal.journal.journal.entity;

import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;
import com.ejournal.journal.journal.entity.academic_entities.SemesterNumber;
import com.ejournal.journal.lesson_journal.entity.Lesson;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Journal {
    @Id
    @SequenceGenerator(name = "journal_id_sequence_generator", sequenceName = "journal_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "journal_id_sequence_generator")
    @Column(name = "journal_id")
    private Long id;
    @Column(name = "semester_number")
    @Enumerated(EnumType.STRING)
    private SemesterNumber semesterNumber;
    @Column(name = "first_acad_year")
    private Integer firstAcademicYear;
    @Column(name = "second_acad_year")
    private Integer secondAcademicYear;
    @OneToMany(mappedBy = "journal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AcademicModule> academicModules = new ArrayList<>();
    @Column(name = "subject_id")
    private Long subjectId;
    @Column(name = "group_id")
    private Long groupId;
    @Column(name = "lecture_teacher_id")
    private Long lectureTeacherId;
    @Column(name = "practical_teacher_id")
    private Long practicalTeacherId;
    @OneToMany(mappedBy = "journal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Lesson> lessons = new ArrayList<>();

    public Journal(SemesterNumber semesterNumber, Long subjectId, Long groupId, Long lectureTeacherId, Long practicalTeacherId) {
        this.semesterNumber = semesterNumber;
        this.subjectId = subjectId;
        this.groupId = groupId;
        this.lectureTeacherId = lectureTeacherId;
        this.practicalTeacherId = practicalTeacherId;
    }
}
