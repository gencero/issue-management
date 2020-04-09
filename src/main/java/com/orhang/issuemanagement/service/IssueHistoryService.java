package com.orhang.issuemanagement.service;

import com.orhang.issuemanagement.dto.IssueHistoryDto;
import com.orhang.issuemanagement.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {
    IssueHistoryDto save(IssueHistoryDto issueHistory);
    IssueHistoryDto getById(Long id);
    Page<IssueHistoryDto> getAllPageable(Pageable pageable);
    Boolean delete(IssueHistoryDto issueHistory);
}