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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "university_id")
    private Long id;
    @Column(name = "university_name")
    private String facultyName;
    @Column(name = "university_description")
    private String facultyDescription;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "email")
    private String email;
    @Column(name = "accreditation")
    private String accreditation;
    @OneToOne
    @JoinColumn(name = "rector_id")
    private Teacher rector;
    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
    private List<Faculty> faculties = new ArrayList<>();

}
