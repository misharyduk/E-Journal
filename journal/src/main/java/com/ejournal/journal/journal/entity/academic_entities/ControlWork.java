package com.ejournal.journal.journal.entity.academic_entities;

import com.ejournal.journal.control_journal.entity.ControlWorkStudent;
import com.ejournal.journal.exercise_journal.entity.WorkStudent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class ControlWork {
    @Id
    @SequenceGenerator(name = "contr_work_id_sequence_generator", sequenceName = "contr_work_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contr_work_id_sequence_generator")
    @Column(name = "contr_work_id")
    private Long id;
    @Column(name = "exec_date")
    private Date executionDate;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<ControlWorkStudent> controlWorkStudents = new ArrayList<>();
}
