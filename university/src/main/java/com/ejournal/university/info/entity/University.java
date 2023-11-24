package com.ejournal.university.info.entity;

import com.ejournal.university.common.entity.Address;
import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.teacher.entity.Teacher;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class University {

    private Long id;
    private String facultyName;
    private String facultyDescription;
    private Address address;
    private String mobilePhone;
    private String email;
    private String accreditation;
    private Teacher rector;
    private List<Faculty> faculties = new ArrayList<>();

}
