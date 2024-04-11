package com.ejournal.group.student.repository;

import com.ejournal.group.common.repository.CommonRepository;
import com.ejournal.group.student.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CommonRepository<Student> {

    List<Student> fetchStudentsByGroupId(Long groupId);

    Long countStudentByGroupId(Long groupId);
}
