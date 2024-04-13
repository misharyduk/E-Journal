package com.ejournal.group.student.repository;

import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentPaginationRepository {

    Page<Tuple>fetchPage(Pageable pageable, String field, String direction);

}
