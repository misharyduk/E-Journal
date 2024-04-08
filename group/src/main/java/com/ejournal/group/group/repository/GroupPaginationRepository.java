package com.ejournal.group.group.repository;

import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupPaginationRepository {

    Page<Tuple> fetchPage(Pageable pageable, String field, String direction);

}
