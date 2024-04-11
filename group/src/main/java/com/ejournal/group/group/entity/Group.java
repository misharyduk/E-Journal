package com.ejournal.group.group.entity;

import com.ejournal.group.student.entity.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Group {
    @Id
    @SequenceGenerator(name = "group_id_sequence_generator", sequenceName = "group_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_id_sequence_generator")
    @Column(name = "group_id")
    private Long id;
    @Column(name = "group_number")
    private Integer groupNumber;
    @OneToMany(mappedBy = "group")
    private List<Student> students;
}
