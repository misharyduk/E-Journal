package com.ejournal.journal.lesson_journal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity @Table(name = "lesson_journal")
@Getter @Setter
public class LessonJournal {
    @Id
    @SequenceGenerator(name = "lesson_journal_id_sequence_generator", sequenceName = "lesson_journal_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_journal_id_sequence_generator")
    @Column(name = "lesson_journal_id")
    private Long id;
    @OneToMany(mappedBy = "lessonJournal", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Lesson> lessons;
}
