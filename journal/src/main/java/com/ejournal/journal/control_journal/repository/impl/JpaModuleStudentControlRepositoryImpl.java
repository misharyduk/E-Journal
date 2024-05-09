package com.ejournal.journal.control_journal.repository.impl;

import com.ejournal.journal.control_journal.entity.ModuleStudentControl;
import com.ejournal.journal.control_journal.repository.ModuleStudentControlRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaModuleStudentControlRepositoryImpl extends JpaRepository<ModuleStudentControl, Long>, ModuleStudentControlRepository {

}
