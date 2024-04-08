package com.ejournal.group.student.entity;

import com.ejournal.group.group.entity.Group;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Student {

    @Id
    @SequenceGenerator(name = "student_id_sequence_generator", sequenceName = "student_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_sequence_generator")
    @Column(name = "student_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "email")
    private String email;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
