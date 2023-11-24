package com.ejournal.university.department.entity;

import com.ejournal.university.common.entity.Address;
import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.info.entity.University;
import com.ejournal.university.teacher.entity.Teacher;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private Long id;
    private String departmentName;
    private String departmentDescription;
    private Address address;
    private String officeNumber;
    private String mobilePhone;
    private String email;
    private Teacher headOfDepartment;
    private Faculty faculty;

}
