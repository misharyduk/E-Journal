package com.ejournal.journal.control_journal.repository.impl;

import com.ejournal.journal.control_journal.repository.ControlWorkRepository;
import com.ejournal.journal.journal.entity.academic_entities.ControlWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaControlWorkRepositoryImpl extends JpaRepository<ControlWork, Long>, ControlWorkRepository {

}
