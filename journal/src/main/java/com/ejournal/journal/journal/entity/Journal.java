package com.ejournal.journal.journal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Journal {
    @Id
    @SequenceGenerator(name = "journal_id_sequence_generator", sequenceName = "journal_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "journal_id_sequence_generator")
    @Column(name = "journal_id")
    private Long id;
    @Column(name = "subject_id")
    private Long subjectId;
    @Column(name = "group_id")
    private Long groupId;
    @Column(name = "teacher_id")
    private Long teacherId;

    public Journal(Long subjectId, Long groupId, Long teacherId) {
        this.subjectId = subjectId;
        this.groupId = groupId;
        this.teacherId = teacherId;
    }
}
