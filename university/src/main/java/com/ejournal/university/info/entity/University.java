package com.ejournal.university.info.entity;

import com.ejournal.university.common.entity.Address;
import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.teacher.entity.Teacher;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class University {

    @Id
    @SequenceGenerator(name = "university_id_sequence_generator", sequenceName = "university_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "university_id_sequence_generator")
    @Column(name = "university_id")
    private Long id;
    @Column(name = "university_name")
    private String universityName;
    @Column(name = "university_description", columnDefinition = "TEXT")
    @Lob
    private String universityDescription;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "email")
    private String email;
    @Column(name = "accreditation")
    private String accreditation;
    @OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "rector_id")
    private Teacher rector;
    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Faculty> faculties = new ArrayList<>();

}
