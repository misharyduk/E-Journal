package com.ejournal.calendar_plan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @Table(name = "calendar_plan_record")
@Getter @Setter @NoArgsConstructor
public class CalendarPlanRecord {
    @Id
    @SequenceGenerator(name = "calendar_plan_record_id_sequence_generator", sequenceName = "calendar_plan_record_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendar_plan_record_id_sequence_generator")
    @Column(name = "id")
    private Long id;
    @Column(name = "lesson_id")
    private Long lessonId;
    @Column(name = "lesson_number")
    private Integer lessonNumber;
    @Column(name = "lesson_date") // TODO think about removing this field as it's duplicate from Lesson class
    private Date lessonDate;
    @Column(name = "theme_name")
    private String themeName;
    @Column(name = "ind_assignment")
    private String individualAssignment;
    @Column(name = "ind_assign_date")
    private Date individualAssignmentDate;
    @JoinColumn(name = "calendar_plan_id")
    @ManyToOne
    private CalendarPlan calendarPlan;

    public CalendarPlanRecord(Long lessonId, Integer lessonNumber, Date lessonDate, String themeName, String individualAssignment, Date individualAssignmentDate) {
        this.lessonId = lessonId;
        this.lessonNumber = lessonNumber;
        this.lessonDate = lessonDate;
        this.themeName = themeName;
        this.individualAssignment = individualAssignment;
        this.individualAssignmentDate = individualAssignmentDate;
    }

    public CalendarPlanRecord(Long lessonId, Date lessonDate) {
        this.lessonId = lessonId;
        this.lessonDate = lessonDate;
    }
}
