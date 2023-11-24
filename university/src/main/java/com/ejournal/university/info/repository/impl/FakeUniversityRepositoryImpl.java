package com.ejournal.university.info.repository.impl;

import com.ejournal.university.info.entity.University;
import com.ejournal.university.info.repository.UniversityRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FakeUniversityRepositoryImpl implements UniversityRepository {

    @Override
    public List<University> findAll() {
        return null;
    }

    @Override
    public Optional<University> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public University save(University university) {
        return null;
    }

    @Override
    public void delete(University university) {

    }
}
