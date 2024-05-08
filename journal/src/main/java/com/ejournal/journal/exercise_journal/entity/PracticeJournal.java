package com.ejournal.journal.exercise_journal.entity;

import com.ejournal.journal.journal.entity.academic_entities.ExerciseWork;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity @Table(name = "practice_journal")
@Getter @Setter
public class PracticeJournal {
    @Id
    @SequenceGenerator(name = "practice_journal_id_sequence_generator", sequenceName = "practice_journal_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "practice_journal_id_sequence_generator")
    @Column(name = "practice_journal_id")
    private Long id;
    @OneToMany(mappedBy = "practiceJournal", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ExerciseWork> exerciseWorks;
}
