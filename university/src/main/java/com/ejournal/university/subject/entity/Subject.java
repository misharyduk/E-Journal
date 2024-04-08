package com.ejournal.university.subject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Subject {

    @Id
    @SequenceGenerator(name = "subject_id_sequence_generator", sequenceName = "subject_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_id_sequence_generator")
    @Column(name = "subject_id")
    private Long id;
    @Column(name = "subject_name")
    private String name;

}
