package com.ejournal.analytics.feign_client.journal;

import com.ejournal.analytics.feign_client.journal.dto.ControlJournalResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("journal")
public interface ControlJournalFeignClient {

    @GetMapping("/api/v1/controljournal/{controlJournalId}")
    ResponseEntity<ControlJournalResponseDto> fetchJournal(@PathVariable("controlJournalId") Long controlJournalId);

}
