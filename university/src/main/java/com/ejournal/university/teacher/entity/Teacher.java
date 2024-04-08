package com.ejournal.university.teacher.entity;

import com.ejournal.university.faculty.entity.Faculty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_id_sequence_generator", sequenceName = "teacher_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_id_sequence_generator")
    @Column(name = "teacher_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    //    private List<String> academicRanks;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "email")
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Teacher(String firstName, String lastName, String middleName, String mobilePhone, String email, Faculty faculty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.faculty = faculty;
    }
}
