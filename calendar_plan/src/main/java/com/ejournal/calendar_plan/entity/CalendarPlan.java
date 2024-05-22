package com.ejournal.calendar_plan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name ="calendar_plan")
@Getter @Setter
public class CalendarPlan {
    @Id
    @SequenceGenerator(name = "calendar_plan_id_sequence_generator", sequenceName = "calendar_plan_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendar_plan_id_sequence_generator")
    @Column(name = "id")
    private Long id;
    @Column(name = "journal_id")
    private Long journalId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "calendarPlan")
    private List<CalendarPlanRecord> calendarPlanRecords = new ArrayList<>();
}
