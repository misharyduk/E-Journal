package com.ejournal.journal.lesson.entity;

import com.ejournal.journal.journal.entity.Journal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
public class Lesson {
    @Id
    @SequenceGenerator(name = "lesson_id_sequence_generator", sequenceName = "lesson_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_id_sequence_generator")
    @Column(name = "lesson_id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "date")
    private Date date;
    @Column(name = "order")
    private Integer order;
    @Column(name = "auditory")
    private String auditory;
    @JoinColumn(name = "journal_id")
    @ManyToOne
    private Journal journal;
}
