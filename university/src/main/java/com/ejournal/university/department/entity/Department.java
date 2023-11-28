package com.ejournal.university.department.entity;

import com.ejournal.university.common.entity.Address;
import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.info.entity.University;
import com.ejournal.university.teacher.entity.Teacher;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private Long id;
    @Column(name = "department_name")
    private String departmentName;
    @Lob
    @Column(name = "department_description")
    private String departmentDescription;
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
    @JoinColumn(name = "head_of_department_id")
    private Teacher headOfDepartment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

}
