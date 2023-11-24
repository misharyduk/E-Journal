package com.ejournal.university.faculty.entity;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.entity.Address;
import com.ejournal.university.info.entity.University;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.ejournal.university.teacher.entity.Teacher;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "faculty_id")
    private Long id;
    @Column(name = "faculty_name")
    private String facultyName;
    @Column(name = "faculty_description")
    private String facultyDescription;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name = "office_number")
    private String officeNumber;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "email")
    private String email;
    @OneToOne
    @JoinColumn(name = "dean_id")
    private Teacher dean;
    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
    private List<Teacher> teachers = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private University university;

}
