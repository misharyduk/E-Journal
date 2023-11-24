package com.ejournal.university.info.repository;

import com.ejournal.university.info.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository {

    List<University> findAll();

    Optional<University> findById(Long id);

    University save(University university);

    void delete(University university);

}
